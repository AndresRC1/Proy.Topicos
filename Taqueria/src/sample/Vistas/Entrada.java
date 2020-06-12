package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.Conexion;
import javafx.scene.image.ImageView;


import java.sql.Connection;

public class Entrada extends Stage implements EventHandler {

    public Scene escena;
    private Button btnAdmin, btnMese, btnLogo;
    VBox vbBotones;

    public Entrada(){
        CreatGUI();
        setScene(escena);
        setTitle("Inicio de sesion");
        show();
    }

    private void CreatGUI() {
        btnLogo=new Button();
        //btnLogo.setGraphic(new ImageView("Imagenes/logo.png"));

        btnAdmin = new Button("Administrador");
        btnAdmin.setOnAction(event -> EventoItem(1));

        btnMese = new Button("Mesero");
        btnMese.setOnAction(event -> EventoItem(2));

        vbBotones=new VBox();
        vbBotones.setSpacing(10);
        vbBotones.getChildren().addAll(btnLogo,btnAdmin, btnMese);
        vbBotones.setAlignment(Pos.CENTER);
        escena =new Scene(vbBotones, 200, 100);
        //escena.getStylesheets().add("Estilos/estilos_principal.css");
        //escena.setAlignment(Pos.CENTER)

    }

    private void EventoItem(int opc){
        switch (opc){
            case 1: new Login(); break;
            case 2: new LoginM(); break;
        }
    }

    public void getScena(Scene scene){
    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

    @Override
    public void handle(Event event) {
    }
}

