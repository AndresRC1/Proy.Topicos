package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.CellButtonOrden;
import sample.ModelosDAO.Compra_detalleDAO;
import sample.ModelosDAO.OrdenDAO;
import sample.ModelosDAO.Conexion;
import javafx.scene.control.TableView;

import java.sql.Connection;

public class ListaOrden extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<OrdenDAO> TVOrden;
    private TableView<Compra_detalleDAO> TVCompra_detalle;
    private Button btn, btnCrearOr;

    public ListaOrden() {
        CrearGUI();
        setTitle("CRUD Orden");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVOrden = new TableView<>();
        TVCompra_detalle=new TableView<>();
        CrearTabla();
        btn = new Button("Agregar");
        btn.setOnAction(event -> Agregar());
        btnCrearOr = new Button("Crear Orden");
        btnCrearOr.setOnAction(event -> CrearOrden());

        vBox.getChildren().addAll(TVOrden,btn, btnCrearOr);
        scene = new Scene(vBox, 500, 280);
    }

    private void Agregar(){ new Orden(TVOrden); }

    private void CrearOrden(){ new RealizaOrden(); }

    private void CrearTabla(){
        TableColumn<OrdenDAO, Integer> ColumnIdOrden = new TableColumn<>("Id Orden");
        ColumnIdOrden.setCellValueFactory(new PropertyValueFactory<>("id_orden"));

        TableColumn<OrdenDAO, String> ColumnNota = new TableColumn<>("Nota");
        ColumnNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        TableColumn<OrdenDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<OrdenDAO, String>, TableCell<OrdenDAO, String>>() {
            @Override
            public TableCell<OrdenDAO, String> call(TableColumn<OrdenDAO, String> param) {
                return new CellButtonOrden(1);
            }
        });
        TableColumn<OrdenDAO, String> tbcCancelar = new TableColumn<>("Cancelar");
        tbcCancelar.setCellFactory(new Callback<TableColumn<OrdenDAO, String>, TableCell<OrdenDAO, String>>() {
            @Override
            public TableCell<OrdenDAO, String> call(TableColumn<OrdenDAO, String> param) {
                return new CellButtonOrden(2);
            }
        });


        TVOrden.getColumns().addAll(ColumnIdOrden, ColumnNota, tbcCancelar);
        TVOrden.setItems(new OrdenDAO().SELECT());

    }
    Conexion cc = new Conexion();
    Connection con = cc.Connect();
}
