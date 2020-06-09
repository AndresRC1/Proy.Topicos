package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.EmpleadoDAO;


public class Empleado extends Stage {

    private TableView<EmpleadoDAO> TVEmpleado;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtNombre, txtTelefono, txtDireccion, txtUsaurio, txtPassword;
    private Button btnGuardar;
    private EmpleadoDAO objEmDAO = null;

    public Empleado(TableView<EmpleadoDAO> TVEmpleado){
        this.TVEmpleado = TVEmpleado;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de los Empleados");
        this.show();
    }

    private void CrearGUI(){
        vBox = new VBox();
        labelNombre = new Label("Nombre");
        txtNombre = new TextField();
        txtNombre.setPromptText("Introduce el nombre del Empleado");

        txtTelefono = new TextField();
        txtTelefono.setPromptText("Introducce el Telefono");

        txtDireccion = new TextField();
        txtDireccion.setPromptText("Introducce la Direccion");

        txtUsaurio = new TextField();
        txtUsaurio.setPromptText("Introducce el Usuario");

        txtPassword = new TextField();
        txtPassword.setPromptText("Introducce el Password");

        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarEmpelado());

        vBox.getChildren().addAll(labelNombre,txtNombre,txtTelefono,txtDireccion,txtUsaurio,txtPassword,btnGuardar);
        scene = new Scene(vBox, 250, 300);
    }
    private void GuardarEmpelado() {

        String nombre = txtNombre.getText();
        String tel = txtTelefono.getText();
        String dire = txtDireccion.getText();
        String usa = txtUsaurio.getText();
        String pas = txtPassword.getText();

        if (objEmDAO == null){
            objEmDAO = new EmpleadoDAO();
            objEmDAO.setNombre_empleado(nombre);
            objEmDAO.setTelefono(tel);
            objEmDAO.setDireccion(dire);
            objEmDAO.setUsuario(usa);
            objEmDAO.setPassword(pas);
            objEmDAO.INSERT();
        } else {
            objEmDAO.setNombre_empleado(nombre);
            objEmDAO.setTelefono(tel);
            objEmDAO.setDireccion(dire);
            objEmDAO.setUsuario(usa);
            objEmDAO.setPassword(pas);
            objEmDAO.UPDATE();
        }

        TVEmpleado.setItems(objEmDAO.SELECT());
        TVEmpleado.refresh();
        this.close();
    }

    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO){
        this.objEmDAO = empleadoDAO;
        txtNombre.setText(empleadoDAO.getNombre_empleado());
        txtTelefono.setText(empleadoDAO.getTelefono());
        txtDireccion.setText(empleadoDAO.getDireccion());
        txtUsaurio.setText(empleadoDAO.getUsuario());
        txtPassword.setText(empleadoDAO.getPassword());
    }
}
