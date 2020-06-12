package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.OrdenDAO;

public class Orden extends Stage {

    private TableView<OrdenDAO> TVOrden;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtNota;
    private Button btnGuardar;
    private OrdenDAO objCDAO = null;

    public Orden(TableView<OrdenDAO> TVOrden){
        TVOrden = TVOrden;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de Orden");
        this.show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        labelNombre = new javafx.scene.control.Label("Nombre");
        txtNota = new TextField();
        txtNota.setPromptText("NOTA");

        btnGuardar = new javafx.scene.control.Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarOrden());

        vBox.getChildren().addAll(labelNombre,txtNota,btnGuardar);
        scene = new Scene(vBox, 250, 300);
    }

    private void GuardarOrden() {
        String nota = txtNota.getText();

        if (objCDAO == null){
            objCDAO = new OrdenDAO();
            objCDAO.setNota(nota);
            objCDAO.INSERT();
        } else {
            objCDAO.setNota(nota);
            objCDAO.UPDATE();
        }

        TVOrden.setItems(objCDAO.SELECT());
        TVOrden.refresh();
        this.close();
    }

    public void setOrdenDAO(OrdenDAO OrdenDAO){
        this.objCDAO = OrdenDAO;
        txtNota.setText(OrdenDAO.getNota());
    }

}
