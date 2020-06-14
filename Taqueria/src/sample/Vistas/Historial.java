package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Historial extends Stage {
    private Scene scene;
    Label lblTitulo;
    VBox vBox;


    public Historial(){
        crearGUI();
        setScene(scene);
        setTitle("Inicio de sesion");
        show();
    }

    private void crearGUI() {
        vBox = new VBox();
        lblTitulo = new Label();
        lblTitulo.setStyle("-fx-base: #ffff;");
        lblTitulo.setText("Inicia Sesión Administrador");

        scene =new Scene(lblTitulo, 300, 350);
        scene.getStylesheets().add("sample/Estilos/estilos_principal.css");


    }
}
