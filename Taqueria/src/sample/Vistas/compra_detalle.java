package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.CategoriaDAO;
import sample.ModelosDAO.Compra_detalleDAO;
import sample.ModelosDAO.EmpleadoDAO;
import sample.ModelosDAO.ProductoDAO;

public class compra_detalle extends Stage {

    private TableView<Compra_detalleDAO> TVCompra_detalle;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtCompra, txtorden, txtproducto, txtCantidad, txtprecioU;
    private Button btnGuardar;
    private Compra_detalleDAO objCdDAO = null;

    public compra_detalle(TableView<Compra_detalleDAO> TVCompra_detalle){
        this.TVCompra_detalle = TVCompra_detalle;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de Compra detalle");
        this.show();
    }
    private void CrearGUI(){
        vBox = new VBox();
        labelNombre = new Label("Nombre");

        txtCompra = new TextField();
        txtCompra.setPromptText("Introduce id de compra");

        txtorden = new TextField();
        txtorden.setPromptText("Introduce id de orden");

        txtproducto = new TextField();
        txtproducto.setPromptText("Introduce id producto");

        txtCantidad = new TextField();
        txtCantidad.setPromptText("Introduce cantidad");

        txtprecioU = new TextField();
        txtprecioU.setPromptText("Introduce precio unitario");

        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarCompraD());

        vBox.getChildren().addAll(labelNombre,txtCompra,txtorden,txtproducto,txtCantidad,txtprecioU,btnGuardar);
        scene = new Scene(vBox, 300,300);
    }
    private void GuardarCompraD(){
        Integer comp = Integer.valueOf(txtCompra.getText());
        Integer orde = Integer.valueOf(txtorden.getText());
        Integer pro = Integer.valueOf(txtproducto.getText());
        Integer can = Integer.valueOf(txtCantidad.getText());
        Integer preu = Integer.valueOf(txtprecioU.getText());

        if (objCdDAO == null){
            objCdDAO = new Compra_detalleDAO();
            objCdDAO.setId_compra(comp);
            objCdDAO.setId_orden(orde);
            objCdDAO.setId_producto(pro);
            objCdDAO.setCantidad(can);
            objCdDAO.setPrecio_unitario(preu);
            objCdDAO.INSERT();
        } else {
            objCdDAO.setId_compra(comp);
            objCdDAO.setId_orden(orde);
            objCdDAO.setId_producto(pro);
            objCdDAO.setCantidad(can);
            objCdDAO.setPrecio_unitario(preu);
            objCdDAO.UPDATE();
        }

        TVCompra_detalle.setItems(objCdDAO.SELECT());
        TVCompra_detalle.refresh();
        this.close();
    }
    public void setCompra_detalleDAO(Compra_detalleDAO compra_detalleDAO){
        this.objCdDAO = compra_detalleDAO;
        txtCompra.setText(String.valueOf(compra_detalleDAO.getId_compra()));
        txtorden.setText(String.valueOf(compra_detalleDAO.getId_orden()));
        txtproducto.setText(String.valueOf(compra_detalleDAO.getId_producto()));
        txtCantidad.setText(String.valueOf(compra_detalleDAO.getCantidad()));
        txtprecioU.setText(String.valueOf(compra_detalleDAO.getPrecio_unitario()));
    }


}