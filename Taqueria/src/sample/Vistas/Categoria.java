package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.ModelosDAO.CategoriaDAO;

public class Categoria extends Stage {

    private TableView<CategoriaDAO> TVCategoria;
    private Scene scene;
    private VBox vBox;
    private Label labelNombre;
    private TextField txtCategoria;
    private Button btnGuardar;
    private CategoriaDAO objCDAO = null;

    public Categoria(TableView<CategoriaDAO> TVCategoria){
        this.TVCategoria = TVCategoria;
        CrearGUI();
        this.setScene(scene);
        this.setTitle("Altas y modificaciones de categorias");
        this.show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        labelNombre = new javafx.scene.control.Label("Nombre");
        txtCategoria = new TextField();
        txtCategoria.setPromptText("Introduce el nombre de la Categoria");

        btnGuardar = new javafx.scene.control.Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarCategoria());

        vBox.getChildren().addAll(labelNombre,txtCategoria,btnGuardar);
        scene = new Scene(vBox, 250, 300);
    }

    private void GuardarCategoria() {
        String categoria = txtCategoria.getText();

        if (objCDAO == null){
            objCDAO = new CategoriaDAO();
            objCDAO.setCategoria(categoria);
            objCDAO.INSERT();
        } else {
            objCDAO.setCategoria(categoria);
            objCDAO.UPDATE();
        }

        TVCategoria.setItems(objCDAO.SELECT());
        TVCategoria.refresh();
        this.close();
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO){
        this.objCDAO = categoriaDAO;
        txtCategoria.setText(categoriaDAO.getCategoria());
    }

}
