package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.ModelosDAO.Conexion;

import java.sql.Connection;

public class LoginM extends Stage implements EventHandler{

    private Scene scene;
    Label lbl;
    VBox vBox;
    TextField txtUserm;
    PasswordField txtPassm;
    Button btnAccept, btnima;

    public LoginM(){
        crearGUI();
        scene = new Scene(vBox, 350, 250);
        setScene(scene);
        setTitle("Login para el Mesero");
        this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this);
        scene.getStylesheets().add("sample/Estilos/Bootstrap3.css");
        show();
    }

    private void crearGUI() {
        vBox = new VBox();
        lbl = new Label();
        lbl.setText("Inicia Sesión Mesero");

        btnima=new Button();
        //btnima.setGraphic(new ImageView("Imagenes/mesero.png"));

        txtUserm = new TextField();
        txtUserm.setStyle("-fx-translate-y: 10");
        txtUserm.setStyle("-fx-background-radius: 5");
        txtUserm.setLayoutX(50);
        txtUserm.setPromptText("Empleado");

        txtPassm = new PasswordField();
        txtPassm.setStyle("-fx-translate-y: 10");
        txtPassm.setStyle("-fx-background-radius: 5");
        txtPassm.setLayoutX(50);
        txtPassm.setPromptText("Contraseña");

        btnAccept = new Button("Entrar");
        btnAccept.setStyle("-fx-translate-y: 35");

        vBox.getChildren().addAll(lbl,btnima,txtUserm,txtPassm,btnAccept);
        vBox.setAlignment(Pos.CENTER);
        btnAccept.setOnAction(eventLogin);
        btnAccept.setAlignment(Pos.CENTER);
    }

    EventHandler eventLogin = new EventHandler() {
        @Override
        public void handle(Event event) {
            acceder();

        }
    };

    String userme = "mesero";
    String passme= "123";

    private void acceder() {
        if(txtUserm.getText().equals(userme) && txtPassm.getText().equals(passme)){
            Mesero admin = new Mesero();
            admin.getScena(scene);
            scene.getWindow().hide();
        } else {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("Datos erróneos");
            alert.setContentText("Verifica tus datos");
            alert.show();
        }


    }
    @Override
    public void handle(Event event) {

    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();
}

