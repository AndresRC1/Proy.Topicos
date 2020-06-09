
package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.CategoriaDAO;
import sample.ModelosDAO.Conexion;
import sample.ModelosDAO.ProductoDAO;

import java.sql.ResultSet;
import java.sql.Statement;

public class Producto extends Stage {

    private TableView<ProductoDAO> TVProducto;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtNombre, txtDescripcion, txtCantidad, txtCosto;
    private ComboBox comboCategoria;
    private ComboBox comboProveedor;
    private Button btnGuardar;
    private ProductoDAO objPrDAO = null;
    private CategoriaDAO objCatDAO = null;

    public Producto(TableView<ProductoDAO> TVProducto){
        this.TVProducto = TVProducto;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de productos");
        this.show();
    }
    private void CrearGUI(){
        vBox = new VBox();
        labelNombre = new Label("Nombre");
        txtNombre = new TextField();
        txtNombre.setPromptText("Introduce el nombre del producto");

        txtDescripcion = new TextField();
        txtDescripcion.setPromptText("Introduce la descripcion");

        txtCantidad = new TextField();
        txtCantidad.setPromptText("Introduce la cantidad");

        txtCosto = new TextField();
        txtCosto.setPromptText("Introduce el costo");

        comboCategoria = new ComboBox();
        comboCategoria.setItems(objCatDAO.COMOBOCAT());

        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarProducto());

        vBox.getChildren().addAll(labelNombre,txtNombre,txtDescripcion,txtCantidad,txtCosto, comboCategoria, comboProveedor,btnGuardar);
        scene = new Scene(vBox, 300,300);
    }
    private void GuardarProducto(){
        String nombre = txtNombre.getText();
        String des = txtDescripcion.getText();
        Integer can = Integer.valueOf(txtCantidad.getText());
        Double cos = Double.valueOf(txtCosto.getText());

        if (objPrDAO == null){
            objPrDAO = new ProductoDAO();
            objPrDAO.setNombre_producto(nombre);
            objPrDAO.setDescripcion(des);
            objPrDAO.setCantidad(can);
            objPrDAO.setCosto(cos);
            objPrDAO.INSERT();
        } else {
            objPrDAO.setNombre_producto(nombre);
            objPrDAO.setDescripcion(des);
            objPrDAO.setCantidad(can);
            objPrDAO.setCosto(cos);
            objPrDAO.UPDATE();
        }

        TVProducto.setItems(objPrDAO.SELECT());
        TVProducto.refresh();
        this.close();
    }
    public void setProductoDAO(ProductoDAO productoDAO){
        this.objPrDAO = productoDAO;
        txtNombre.setText(productoDAO.getNombre_producto());
        txtDescripcion.setText(productoDAO.getDescripcion());
        txtCantidad.setText(String.valueOf(productoDAO.getCantidad()));
        txtCosto.setText(String.valueOf(productoDAO.getCosto()));
    }


}
