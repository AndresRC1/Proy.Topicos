package sample.Vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.ModelosDAO.Conexion;

import java.sql.Connection;

public class Mesero extends Stage {

    public Scene escena;
    private MenuBar menuBar;
    private Menu menuOrden, menuCompra,menuCompraD;
    private MenuItem ItemOrden, ItemCompra, ItemCompraD;
    private BorderPane panel;

    public Mesero(){
        panel = new BorderPane();
        CreatGUI();
        escena = new Scene(panel, 750,330);
        setScene(escena);
        //escena.getStylesheets().add("sample/Estilos/estilos_principal.css");
        setTitle("CRUD Mesero");
        //setMaximized(true);
        //escena.getStylesheets().add(getClass().getResource("../Estilos/estilos_principal.css").toExternalForm());
        show();

    }

    private void CreatGUI() {

        menuBar = new MenuBar();

        menuOrden = new Menu("Lista de Orden");
        menuOrden.setId("menu1");

        menuCompra = new Menu("Lista de Compra");
        menuCompra.setId("menu2");

        menuCompraD = new  Menu("Lista de Compra Detalle");
        menuCompraD.setId("menu3");

        ItemOrden = new MenuItem("Orden");
        ItemOrden.setOnAction(event -> EventoItem(1));

        ItemCompra = new MenuItem("Compra");
        ItemCompra.setOnAction(event -> EventoItem(2));

        ItemCompraD = new MenuItem("Compra detalle");
        ItemCompraD.setOnAction(event -> EventoItem(3));


        menuBar.getMenus().addAll(menuOrden, menuCompra, menuCompraD);
        menuOrden.getItems().addAll(ItemOrden );
        menuCompra.getItems().addAll(ItemCompra);
        menuCompraD.getItems().addAll(ItemCompraD);

        panel.setTop(menuBar);

    }

    private void EventoItem(int opc){
        switch (opc){
            case 1: new ListaOrden(); break;
            case 2: new ListaCompra(); break;
            case 3: new ListaCompra_detalle(); break;
           // case 4: new RealizaOrden(); break;
        }
    }

    public void getScena(Scene scene){
    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

}
