package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.CategoriaDAO;
import sample.ModelosDAO.CompraDAO;
import sample.ModelosDAO.EmpleadoDAO;
import sample.ModelosDAO.ProductoDAO;

public class Compra extends Stage {
    private TableView<CompraDAO> TVCompra;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtDate, txtEmpleado;
    private Button btnGuardar;
    private CompraDAO objCoDAO = null;
    private EmpleadoDAO objEmDAO = null;

    public Compra(TableView<CompraDAO> TVCompra){
        this.TVCompra = TVCompra;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de compra");
        this.show();
    }
    private void CrearGUI(){
        vBox = new VBox();
        labelNombre = new Label("Nombre");

        txtDate = new TextField();
        txtDate.setPromptText("Introduce la fecha");

        txtEmpleado= new TextField();
        txtEmpleado.setPromptText("Inroduce el Id del empleado");


        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarCompra());

        vBox.getChildren().addAll(labelNombre,txtDate,txtEmpleado,btnGuardar);
        scene = new Scene(vBox, 300,300);
    }
    private void GuardarCompra(){
        String fecha= txtDate.getText();
        Integer emp = Integer.valueOf(txtEmpleado.getText());

        if (objCoDAO == null){
            objCoDAO = new CompraDAO();
            objCoDAO.setFecha(fecha);
            objCoDAO.setId_empleado(emp);
            objCoDAO.INSERT();
        } else {
            objCoDAO.setFecha(fecha);
            objCoDAO.setId_empleado(emp);
            objCoDAO.UPDATE();
        }

        TVCompra.setItems(objCoDAO.SELECT());
        TVCompra.refresh();
        this.close();
    }
    public void setCompraDAO(CompraDAO compraDAO){
        this.objCoDAO = compraDAO;
        txtDate.setText(compraDAO.getFecha());
        txtEmpleado.setText(String.valueOf(compraDAO.getId_empleado()));
    }


}
