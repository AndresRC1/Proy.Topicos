package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.CategoriaDAO;
import sample.ModelosDAO.Compra_detalleDAO;
import sample.ModelosDAO.EmpleadoDAO;
import sample.ModelosDAO.ProductoDAO;

public class compra_detalle extends Stage {

    private TableView<Compra_detalleDAO> TVCompra_detalle;
    private Scene scene;
    private HBox hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7;
    private VBox vBox;
    private Label labelNombre, lblTB,lblbc, lblbj,lblTT,lbltp,lbltb,lbltc,lblTP,lblpp, lblvacio, lblptaq;
    private TextField txtCompra, txtorden, txtproducto, txtCantidad, txtprecioU;
    private Button btnGuardar, btnTick;
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
        hbox1=new HBox();
        hbox2=new HBox();
        hbox3=new HBox();
        hbox4=new HBox();
        hbox5=new HBox();
        hbox6=new HBox();
        hbox7=new HBox();

        labelNombre = new Label("-----------------------MENU---------------------------");
        lblTB=new Label("       BEBIDAS          ");
        lblbc=new Label("1. Cerveza.....$22.0         ");
        lblbj=new Label("7. Jugo.....$12.0             ");
        lblvacio=new Label("                                     ");
        lblTT=new Label("        TACOS        ");
        lbltp=new Label("3. Pastor.....$10.0  ");
        lbltb=new Label("4. Bisteck.....$10.0  ");
        lbltc=new Label("5. Chorizo.....$10.0  ");
        lblTP=new Label("           POSTRES            ");
        lblpp=new Label("6. P. de Chocolate.....$25.0  ");
        lblptaq=new Label("8. P. de Takis.......$13.0  ");

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

        btnTick = new Button("Imprimir");
        btnTick.setOnAction(event -> GeneraTic());

        hbox1.getChildren().addAll(lblTB,lblTT);
        hbox2.getChildren().addAll(lblbc,lbltp);
        hbox3.getChildren().addAll(lblbj,lbltb);
        hbox4.getChildren().addAll(lblvacio,lbltc);
        hbox5.getChildren().addAll(lblTP);
        hbox6.getChildren().addAll(lblpp);
        hbox7.getChildren().addAll(lblptaq);

        vBox.getChildren().addAll(labelNombre,hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7,txtCompra,txtorden,txtproducto,txtCantidad,txtprecioU,btnGuardar, btnTick);
        scene = new Scene(vBox, 500,500);
    }
    private void GeneraTic(){ new Ticket(); }
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
