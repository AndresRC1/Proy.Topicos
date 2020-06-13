package sample.Vistas;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.ModelosDAO.Conexion;

import java.sql.Connection;

public class Administrador extends Stage {

    public Scene escena;
    private MenuBar menuBar;
    private Menu menuProveedores, menuCategorias,menuProducto,menuEmpleado, menuOrden, menuCompra, menuCompraD;
    private MenuItem ItemProveedor, ItemProducto, ItemCategoria, ItemEmpleado, ItemOrden, ItemCompra, ItemCompraD;
    private BorderPane panel;

    public Administrador(){
        panel = new BorderPane();
        CreatGUI();
        escena = new Scene(panel, 750,330);
        setScene(escena);
        escena.getStylesheets().add("sample/Estilos/estilos_principal.css");
        setTitle("CRUD Administrador");
        //setMaximized(true);
        //escena.getStylesheets().add(getClass().getResource("../Estilos/estilos_principal.css").toExternalForm());
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

        menuEmpleado = new Menu("Lista de Empleados");
        menuEmpleado.setId("menu4");

        menuOrden = new  Menu("Lista de Orden");
        menuOrden.setId("menu5");

        menuCompra = new Menu("Lista de Compra");
        menuCompra.setId("menu6");

        menuCompraD = new Menu("Lista de Compra detalles");
        menuCompraD.setId("menu7");

        ItemProveedor = new MenuItem("Proveedores");
        ItemProveedor.setOnAction(event -> EventoItem(1));

        ItemCategoria = new MenuItem("Categorias");
        ItemCategoria.setOnAction(event -> EventoItem(2));

        ItemProducto = new MenuItem("Producto");
        ItemProducto.setOnAction(event -> EventoItem(3));

        ItemEmpleado = new MenuItem("Empleado");
        ItemEmpleado.setOnAction(event -> EventoItem(4));

        ItemOrden = new MenuItem("Orden");
        ItemOrden.setOnAction(event -> EventoItem(5));

        ItemCompra = new MenuItem("Compra");
        ItemCompra.setOnAction(event -> EventoItem(6));

        ItemCompraD = new MenuItem("Compra detalle");
        ItemCompraD.setOnAction(event -> EventoItem(7));

        menuBar.getMenus().addAll(menuProveedores, menuCategorias, menuProducto, menuEmpleado, menuOrden, menuCompra, menuCompraD);
        menuProveedores.getItems().addAll(ItemProveedor );
        menuCategorias.getItems().addAll(ItemCategoria);
        menuProducto.getItems().addAll(ItemProducto);
        menuEmpleado.getItems().addAll(ItemEmpleado);
        menuOrden.getItems().addAll(ItemOrden);
        menuCompra.getItems().addAll(ItemCompra);
        menuCompraD.getItems().addAll(ItemCompraD);
        panel.setTop(menuBar);

    }

    private void EventoItem(int opc){
        switch (opc){
            case 1: new ListaProveedores(); break;
            case 2: new ListaCategoria(); break;
            case 3: new ListaProducto(); break;
            case 4: new ListaEmpleado(); break;
            case 5: new ListaOrden(); break;
            case 6: new ListaCompra(); break;
            case 7: new ListaCompra_detalle(); break;
        }
    }

    public void getScena(Scene scene){
    }

    Conexion cc = new Conexion();
    Connection con = cc.Connect();

}
