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
import sample.Componentes.CellButtonProducto;
import sample.ModelosDAO.Conexion;
import sample.ModelosDAO.ProductoDAO;

import java.sql.Connection;

public class ListaProducto extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<ProductoDAO> TVProducto;
    private Button btn;

    ListaProducto(){
        CrearGUI();
        setTitle("CRUD Producto");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVProducto = new TableView<>();
        CrearTabla();
        btn = new Button("Agregar");
        btn.setOnAction(event -> AgregarProducto());
        vBox.getChildren().addAll(TVProducto,btn);
        scene = new Scene(vBox, 750, 280);
    }

    private void AgregarProducto(){new Producto(TVProducto);}

    private void CrearTabla(){
        TableColumn<ProductoDAO, Integer> ColumnIdProducto = new TableColumn<>("Id Prducto");
        ColumnIdProducto.setCellValueFactory(new PropertyValueFactory<>("id_producto"));

        TableColumn<ProductoDAO, String> ColumnNomProducto = new TableColumn<>("Nombre Producto");
        ColumnNomProducto.setCellValueFactory(new PropertyValueFactory<>("nombre_producto"));

        TableColumn<ProductoDAO, String> ColumnDescripcion = new TableColumn<>("Descripcion");
        ColumnDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        TableColumn<ProductoDAO, Integer> ColumnCantidad = new TableColumn<>("Cantidad");
        ColumnCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<ProductoDAO, Double> ColumnCosto = new TableColumn<>("Costo");
        ColumnCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        TableColumn<ProductoDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<ProductoDAO, String>, TableCell<ProductoDAO, String>>() {
            @Override
            public TableCell<ProductoDAO, String> call(TableColumn<ProductoDAO, String> param) {
                return new CellButtonProducto(1);

            }
        });

        TableColumn<ProductoDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<ProductoDAO, String>, TableCell<ProductoDAO, String>>() {
            @Override
            public TableCell<ProductoDAO, String> call(TableColumn<ProductoDAO, String> param) {
                return new CellButtonProducto(2);
            }
        });

        TVProducto.getColumns().addAll(ColumnIdProducto, ColumnNomProducto, ColumnDescripcion, ColumnCantidad, ColumnCosto, tbcEditar, tbcEliminar);
        TVProducto.setItems(new ProductoDAO().SELECT());

    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

}
