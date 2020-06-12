package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.ModelosDAO.Conexion;

import java.sql.Connection;

public class Login extends Stage implements EventHandler {

    private Scene scene;
    Label lable, lblima;
    VBox vBox;
    TextField txtUser;
    PasswordField txtPass;
    Button btnAccept;


    public Login(){
        crearGUI();
        scene = new Scene(vBox, 350, 250);
        setScene(scene);
        setTitle("Login para el Administrador");
        this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this);
        scene.getStylesheets().add("sample/Estilos/estilo_login.css");
        show();
    }

    private void crearGUI() {
        vBox = new VBox();
        lable = new Label();
        lable.setStyle("-fx-base: #ffff;");
        lable.setText("Inicia Sesión Administrador");

        lblima=new Label();
        lblima.setGraphic(new ImageView("sample/Imagenes/jefe.png"));

        txtUser = new TextField();
        txtUser.setStyle("-fx-translate-y: 10");
        txtUser.setStyle("-fx-background-radius: 5");
        txtUser.setLayoutX(50);
        txtUser.setPromptText("Usuario");

        txtPass = new PasswordField();
        txtPass.setStyle("-fx-translate-y: 10");
        txtPass.setStyle("-fx-background-radius: 5");
        txtPass.setLayoutX(50);
        txtPass.setPromptText("Contraseña");

        btnAccept = new Button("Entrar");
        btnAccept.setStyle("-fx-translate-y: 35");

        vBox.getChildren().addAll(lable,lblima,txtUser,txtPass,btnAccept);
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

    String user = "Admin";
    String pass = "12345";

    private void acceder() {
        if(txtUser.getText().equals(user) && txtPass.getText().equals(pass)){
            Administrador admin = new Administrador();
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

