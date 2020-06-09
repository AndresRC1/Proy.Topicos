package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.CellButtonCategoria;
import sample.ModelosDAO.CategoriaDAO;
import sample.ModelosDAO.Conexion;
import javafx.scene.control.TableView;


import java.sql.Connection;

public class ListaCategoria extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<CategoriaDAO> TVCategoria;
    private Button btn;

    public ListaCategoria() {
        CrearGUI();
        setTitle("CRUD Categoria");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVCategoria = new TableView<>();
        CrearTabla();
        btn = new Button("Agregar");
        btn.setOnAction(event -> AgregarCategoria());
        vBox.getChildren().addAll(TVCategoria,btn);
        scene = new Scene(vBox, 500, 280);
    }

private void AgregarCategoria(){ new Categoria(TVCategoria); }
private void CrearTabla(){
    TableColumn<CategoriaDAO, Integer> ColumnIdCategoria = new TableColumn<>("Id Categoria");
    ColumnIdCategoria.setCellValueFactory(new PropertyValueFactory<>("id_categoria"));

    TableColumn<CategoriaDAO, String> ColumnCategoria = new TableColumn<>("Categoria");
    ColumnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

    TableColumn<CategoriaDAO, String> tbcEditar = new TableColumn<>("Editar");
    tbcEditar.setCellFactory(new Callback<TableColumn<CategoriaDAO, String>, TableCell<CategoriaDAO, String>>() {
        @Override
        public TableCell<CategoriaDAO, String> call(TableColumn<CategoriaDAO, String> param) {
            return new CellButtonCategoria(1);
        }
    });
    TableColumn<CategoriaDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
    tbcEliminar.setCellFactory(new Callback<TableColumn<CategoriaDAO, String>, TableCell<CategoriaDAO, String>>() {
        @Override
        public TableCell<CategoriaDAO, String> call(TableColumn<CategoriaDAO, String> param) {
            return new CellButtonCategoria(2);
        }
    });


    TVCategoria.getColumns().addAll(ColumnIdCategoria, ColumnCategoria, tbcEditar, tbcEliminar);
    TVCategoria.setItems(new CategoriaDAO().SELECT());

}
        Conexion cc = new Conexion();
        Connection con = cc.Connect();
    }
