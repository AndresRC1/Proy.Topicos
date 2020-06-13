package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.CellButtonCompra;
import sample.ModelosDAO.CompraDAO;
import sample.ModelosDAO.Conexion;

import java.sql.Connection;

public class ListaCompra extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<CompraDAO> TVCompra;
    private Button btn;

    ListaCompra(){
        CrearGUI();
        setTitle("CRUD Compra");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVCompra = new TableView<>();
        CrearTabla();
        btn = new Button("Agregar");
        btn.setOnAction(event -> AgregarCompra());
        vBox.getChildren().addAll(TVCompra,btn);
        scene = new Scene(vBox, 900, 280);
    }

    private void AgregarCompra(){new Compra(TVCompra);}

    private void CrearTabla(){
        TableColumn<CompraDAO, Integer> ColumnIdCompra = new TableColumn<>("Id Compra");
        ColumnIdCompra.setCellValueFactory(new PropertyValueFactory<>("id_compra"));

        TableColumn<CompraDAO, String> ColumnFecha = new TableColumn<>("Fecha");
        ColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        TableColumn<CompraDAO, Integer> ColumnIdEmpleado = new TableColumn<>("Id Empleado");
        ColumnIdEmpleado.setCellValueFactory(new PropertyValueFactory<>("id_empleado"));

        TableColumn<CompraDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<CompraDAO, String>, TableCell<CompraDAO, String>>() {
            @Override
            public TableCell<CompraDAO, String> call(TableColumn<CompraDAO, String> param) {
                return new CellButtonCompra(1);

            }
        });

        TableColumn<CompraDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<CompraDAO, String>, TableCell<CompraDAO, String>>() {
            @Override
            public TableCell<CompraDAO, String> call(TableColumn<CompraDAO, String> param) {
                return new CellButtonCompra(2);
            }
        });

        TVCompra.getColumns().addAll(ColumnIdCompra, ColumnFecha,ColumnIdEmpleado,  tbcEditar, tbcEliminar);
        TVCompra.setItems(new CompraDAO().SELECT());

    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

}
