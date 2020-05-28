package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.ProveedoresDAO;

public class Proveedor extends Stage {

    private TableView<ProveedoresDAO> TVProveedores;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtNombre, txtTel, txtDir;
    private Button btnGuardar;
    private ProveedoresDAO objPDAO = null;

    public Proveedor(TableView<ProveedoresDAO> TVProveedores){
        this.TVProveedores = TVProveedores;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de proveedores");
        this.show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        labelNombre = new Label("Nombre");
        txtNombre = new TextField();
        txtNombre.setPromptText("Introduce el nombre del proveedor");

        txtTel = new TextField();
        txtTel.setPromptText("Introduce el teléfono");

        txtDir = new TextField();
        txtDir.setPromptText("Introduce la direccion");

        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarProveedor());

        vBox.getChildren().addAll(labelNombre,txtNombre,txtTel,txtDir);
        scene = new Scene(vBox, 250, 300);
    }

    private void GuardarProveedor() {

        String nombre = txtNombre.getText();
        String tel = txtTel.getText();
        String dire = txtDir.getText();

        if (objPDAO == null){
            objPDAO = new ProveedoresDAO();
            objPDAO.setNombre_proveedor(nombre);
            objPDAO.setTelefono(tel);
            objPDAO.setDireccion(dire);
            objPDAO.INSERT();
        } else {
            objPDAO.setNombre_proveedor(nombre);
            objPDAO.setTelefono(tel);
            objPDAO.setDireccion(dire);
            objPDAO.UPDATE();
        }

        TVProveedores.setItems(objPDAO.SELECT());
        TVProveedores.refresh();
        this.close();

    }

    public void setProveedoresDAO(ProveedoresDAO proveedoresDAO){
        this.objPDAO = proveedoresDAO;
        txtNombre.setText(proveedoresDAO.getNombre_proveedor());
        txtTel.setText(proveedoresDAO.getTelefono());
        txtDir.setText(proveedoresDAO.getDireccion());
    }
}
