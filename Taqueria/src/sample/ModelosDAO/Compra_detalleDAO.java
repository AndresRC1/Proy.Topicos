package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Compra_detalleDAO {
    private int id_compra;
    private int id_orden;
    private int id_producto;
    private int cantidad;
    private int precio_unitario;

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void INSERT(){
        String query = "INSERT INTO compra_detalle (id_compra, id_orden, id_producto, cantidad, precio_unitario)" +
                "VALUES ("+id_compra+", "+id_orden+", "+id_producto+",  "+cantidad+", "+precio_unitario+")";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void UPDATE(){

        String query = "UPDATE compra_detalle SET " +
                "id_compra = " + id_compra + ", " +
                "id_orden = " + id_orden+ "," +
                "id_producto =" + id_producto+ "," +
                "cantidad =" + cantidad+"," +
                "precio_unitario =" + precio_unitario+"," +
                " WHERE id_compra = " + id_compra;
        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void DELETE(){

        String query = "DELETE FROM compra_detalle WHERE id_compra = "+id_compra+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Compra_detalleDAO> SELECT(){

        ObservableList<Compra_detalleDAO> list = FXCollections.observableArrayList();
        Compra_detalleDAO cdDAO = null;

        String query = "SELECT * FROM compra_detalle";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                cdDAO = new Compra_detalleDAO();
                cdDAO.id_compra = res.getInt("id_compra");
                cdDAO.id_orden = res.getInt("id_orden");
                cdDAO.id_producto = res.getInt("id_producto");
                cdDAO.cantidad = res.getInt("cantidad");
                cdDAO.precio_unitario = res.getInt("precio_unitario");
                list.add(cdDAO);
            }
        } catch (Exception e){

        }
        return list;
    }


}
