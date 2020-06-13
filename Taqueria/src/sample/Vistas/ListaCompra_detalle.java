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
import sample.Componentes.CellButtonCompra_detalle;
import sample.Componentes.CellButtonProducto;
import sample.ModelosDAO.Compra_detalleDAO;
import sample.ModelosDAO.Conexion;
import sample.ModelosDAO.ProductoDAO;

import java.sql.Connection;

public class ListaCompra_detalle extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<Compra_detalleDAO> TVCompra_detalle;
    private Button btn;

    ListaCompra_detalle(){
        CrearGUI();
        setTitle("CRUD Compra_detalle");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVCompra_detalle = new TableView<>();
        CrearTabla();
        btn = new Button("Agregar");
        btn.setOnAction(event -> AgregarCompraD());
        vBox.getChildren().addAll(TVCompra_detalle,btn);
        scene = new Scene(vBox, 900, 280);
    }

    private void AgregarCompraD(){new compra_detalle(TVCompra_detalle);}

    private void CrearTabla(){
        TableColumn<Compra_detalleDAO, Integer> ColumnIdCompra = new TableColumn<>("Id Compra");
        ColumnIdCompra.setCellValueFactory(new PropertyValueFactory<>("id_compra"));

        TableColumn<Compra_detalleDAO, String> ColumnIdOrden = new TableColumn<>("Id orden");
        ColumnIdOrden.setCellValueFactory(new PropertyValueFactory<>("id_orden"));

        TableColumn<Compra_detalleDAO, String> ColumnIdProducto = new TableColumn<>("Id producto");
        ColumnIdProducto.setCellValueFactory(new PropertyValueFactory<>("id_producto"));

        TableColumn<Compra_detalleDAO, Integer> ColumnCantidad = new TableColumn<>("Cantidad");
        ColumnCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<Compra_detalleDAO, Double> ColumnPrecioU = new TableColumn<>("Precio unitario");
        ColumnPrecioU.setCellValueFactory(new PropertyValueFactory<>("precio_unitario"));

        TableColumn<Compra_detalleDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<Compra_detalleDAO, String>, TableCell<Compra_detalleDAO, String>>() {
            @Override
            public TableCell<Compra_detalleDAO, String> call(TableColumn<Compra_detalleDAO, String> param) {
                return new CellButtonCompra_detalle(1);
            }
        });

        TableColumn<Compra_detalleDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<Compra_detalleDAO, String>, TableCell<Compra_detalleDAO, String>>() {
            @Override
            public TableCell<Compra_detalleDAO, String> call(TableColumn<Compra_detalleDAO, String> param) {
                return new CellButtonCompra_detalle(2);
            }
        });

        TVCompra_detalle.getColumns().addAll(ColumnIdCompra, ColumnIdOrden, ColumnIdProducto, ColumnCantidad,ColumnPrecioU,  tbcEditar, tbcEliminar);
        TVCompra_detalle.setItems(new Compra_detalleDAO().SELECT());

    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

}
