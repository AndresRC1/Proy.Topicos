package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Login extends Stage implements EventHandler {

    private Scene scene;
    Label lable;
    VBox vBox;
    TextField txtUser;
    PasswordField txtPass;
    Button btnAccept;

    public Login(){
        crearGUI();
        scene = new Scene(vBox, 350, 250);
        setScene(scene);
        setTitle("Login");
        this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this);
        //scene.getStylesheets().add("sample/Estilos/Bootstrap3.css");
        show();
    }

    private void crearGUI() {
        vBox = new VBox();
        lable = new Label();
        lable.setText("Iniciar Sesión");

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

        vBox.getChildren().addAll(lable,txtUser,txtPass,btnAccept);
        btnAccept.setOnAction(eventLogin);
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
}
