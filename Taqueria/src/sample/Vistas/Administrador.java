package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Administrador extends Stage {

    public Scene escena;
    private MenuBar menuBar;
    private Menu menuAdmin, menuOrden;
    private MenuItem ItemProveedor, ItemProducto, ItemCategoria;
    private BorderPane panel;

    public Administrador(){
        panel = new BorderPane();
        CreatGUI();
        escena = new Scene(panel, 400,330);
        setScene(escena);
        setTitle("CRUD Administrador");
        //setMaximized(true);
        //escena.getStylesheets().add(getClass().getResource("sample/Estilos/Bootstrap3.css").toExternalForm());
        show();

    }

    private void CreatGUI() {
        menuBar = new MenuBar();

        menuAdmin = new Menu("Lista de proveedores");
        menuAdmin.setId("menu1");

        ItemProveedor = new MenuItem("Proveedores");
        ItemProveedor.setOnAction(event -> EventoItem(1));

        menuBar.getMenus().addAll(menuAdmin);
        menuAdmin.getItems().addAll(ItemProveedor);
        panel.setTop(menuBar);


    }

    private void EventoItem(int opc){
        switch (opc){
            case 1: new ListaProveedores(); break;
        }
    }


    public void getScena(Scene scene){

    }
}
