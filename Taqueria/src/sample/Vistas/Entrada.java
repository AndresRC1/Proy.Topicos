package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.ModelosDAO.Conexion;
import javafx.scene.image.ImageView;


import java.sql.Connection;

public class Entrada extends Stage implements EventHandler {

    public Scene escena;
    Label lblLogo;
    private Button btnAdmin, btnMese;
    VBox vbBotones;

    public Entrada(){
        CreatGUI();
        setScene(escena);
        setTitle("Inicio de sesion");
        show();
    }

    private void CreatGUI() {
        lblLogo=new Label();
        lblLogo.setGraphic(new ImageView("sample/Imagenes/logo.png"));

        btnAdmin = new Button("Administrador");
        btnAdmin.setMaxSize(250,300);
        btnAdmin.setOnAction(event -> EventoItem(1));

        btnMese = new Button("Mesero");
        btnMese.setMaxSize(250,300);
        btnMese.setOnAction(event -> EventoItem(2));

        vbBotones=new VBox();
        vbBotones.setSpacing(10);
        vbBotones.getChildren().addAll(lblLogo,btnAdmin, btnMese);
        vbBotones.setAlignment(Pos.CENTER);
        escena =new Scene(vbBotones, 300, 350);
        escena.getStylesheets().add("sample/Estilos/estilos_principal.css");
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

