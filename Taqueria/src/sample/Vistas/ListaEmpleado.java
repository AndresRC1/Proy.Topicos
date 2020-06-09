package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.CellButtonEmpleado;
import sample.ModelosDAO.Conexion;
import sample.ModelosDAO.EmpleadoDAO;
import javafx.scene.control.TableView;

import java.sql.Connection;


public class ListaEmpleado extends Stage {

    private Scene scene;
    private VBox vBox;
    private TableView<EmpleadoDAO> TVEmpleado;
    private Button btnAdd;

    public ListaEmpleado() {
        CrearGUI();
        setTitle("CRUD Empleado");
        setScene(scene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        TVEmpleado = new TableView<>();
        CrearTabla();
        btnAdd = new Button("Agregar");
        btnAdd.setOnAction(event -> AgregarEmpleado());
        vBox.getChildren().addAll(TVEmpleado, btnAdd);
        scene = new Scene(vBox, 800, 280);
    }

    private void AgregarEmpleado() {
        new Empleado(TVEmpleado);
    }

    private void CrearTabla() {
        TableColumn<EmpleadoDAO, Integer> ColumnIdEmpleado = new TableColumn<>("Id Empleado");
        ColumnIdEmpleado.setCellValueFactory(new PropertyValueFactory<>("id_empleado"));

        TableColumn<EmpleadoDAO, String> ColumnNomEmpleado = new TableColumn<>("Nombre Empleado");
        ColumnNomEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre_empleado"));

        TableColumn<EmpleadoDAO, String> ColumnTel = new TableColumn<>("Telefono");
        ColumnTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<EmpleadoDAO, String> ColumnDireccion = new TableColumn<>("Direccion");
        ColumnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<EmpleadoDAO, String> ColumnUsuario = new TableColumn<>("Usuario");
        ColumnUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));

        TableColumn<EmpleadoDAO, String> ColumnPass = new TableColumn<>("Password");
        ColumnPass.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<EmpleadoDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<EmpleadoDAO, String>, TableCell<EmpleadoDAO, String>>() {
            @Override
            public TableCell<EmpleadoDAO, String> call(TableColumn<EmpleadoDAO, String> param) {
                return new CellButtonEmpleado(1);
            }
        });
        TableColumn<EmpleadoDAO, String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<EmpleadoDAO, String>, TableCell<EmpleadoDAO, String>>() {
            @Override
            public TableCell<EmpleadoDAO, String> call(TableColumn<EmpleadoDAO, String> param) {
                return new CellButtonEmpleado(2);
            }
        });

        TVEmpleado.getColumns().addAll(ColumnIdEmpleado, ColumnNomEmpleado, ColumnTel, ColumnDireccion, ColumnUsuario, ColumnPass, tbcEditar, tbcEliminar);
        TVEmpleado.setItems(new EmpleadoDAO().SELECT());
    }
        Conexion cc = new Conexion();
        Connection con = cc.Connect();
    }

