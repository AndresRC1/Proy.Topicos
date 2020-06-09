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
    private Menu menuProveedores, menuCategorias,menuProducto, menuOrden;
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

        menuProveedores = new Menu("Lista de proveedores");
        menuProveedores.setId("menu1");

        menuCategorias = new Menu("Lista de categorias");
        menuCategorias.setId("menu2");

        menuProducto = new  Menu("Lista de Productos");
        menuProducto.setId("menu3");

        ItemProveedor = new MenuItem("Proveedores");
        ItemProveedor.setOnAction(event -> EventoItem(1));

        ItemCategoria = new MenuItem("Categorias");
        ItemCategoria.setOnAction(event -> EventoItem(2));

        ItemProducto = new MenuItem("Producto");
        ItemProducto.setOnAction(event -> EventoItem(3));

        menuBar.getMenus().addAll(menuProveedores, menuCategorias, menuProducto);
        menuProveedores.getItems().addAll(ItemProveedor );
        menuCategorias.getItems().addAll(ItemCategoria);
        menuProducto.getItems().addAll(ItemProducto);
        panel.setTop(menuBar);


    }

    private void EventoItem(int opc){
        switch (opc){
            case 1: new ListaProveedores(); break;
            case 2: new ListaCategoria(); break;
            case 3: new ListaProducto(); break;
        }
    }


    public void getScena(Scene scene){

    }
}
