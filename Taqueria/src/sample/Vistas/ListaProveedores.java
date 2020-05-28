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
import sample.Componentes.CellButton;
import sample.ModelosDAO.ProveedoresDAO;

public class ListaProveedores extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<ProveedoresDAO> TVProveedores;
    private Button btnAdd;

    public ListaProveedores(){
        CrearGUI();
        setTitle("CRUD Proveedores");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVProveedores = new TableView<>();
        CrearTabla();
        btnAdd = new Button("Agregar");
        btnAdd.setOnAction(event -> AgregarProveedor());
        vBox.getChildren().addAll(TVProveedores,btnAdd);
        scene = new Scene(vBox, 750, 280);
    }

    private void AgregarProveedor(){
        new Proveedor(TVProveedores);
    }

    private void CrearTabla() {
        TableColumn<ProveedoresDAO, Integer> ColumnIdProveedor = new TableColumn<>("Id Proveedor");
        ColumnIdProveedor.setCellValueFactory(new PropertyValueFactory<>("id_proveedor"));

        TableColumn<ProveedoresDAO, Integer> ColumnNomProveedor = new TableColumn<>("Nombre Proveedor");
        ColumnNomProveedor.setCellValueFactory(new PropertyValueFactory<>("nombre_proveedor"));

        TableColumn<ProveedoresDAO, Integer> ColumnTel = new TableColumn<>("Telefono");
        ColumnTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<ProveedoresDAO, Integer> ColumnDireccion  = new TableColumn<>("Direccion");
        ColumnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<ProveedoresDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<ProveedoresDAO, String>, TableCell<ProveedoresDAO, String>>() {
            @Override
            public TableCell<ProveedoresDAO, String> call(TableColumn<ProveedoresDAO, String> param) {
                return new CellButton(1);
            }
        });

        TableColumn<ProveedoresDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<ProveedoresDAO, String>, TableCell<ProveedoresDAO, String>>() {
            @Override
            public TableCell<ProveedoresDAO, String> call(TableColumn<ProveedoresDAO, String> param) {
                return new CellButton(2);
            }
        });

        TVProveedores.getColumns().addAll(ColumnIdProveedor, ColumnNomProveedor, ColumnTel, ColumnDireccion, tbcEditar, tbcEliminar);
        TVProveedores.setItems(new ProveedoresDAO().SELECT());

    }
}
