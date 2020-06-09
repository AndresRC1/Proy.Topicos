package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAO {

    private int id_producto;
    private String nombre_producto;
    private String descripcion;
    private int cantidad;
    private double costo;
    private int id_proveedor;
    private int id_categoria;

    public int getId_producto() { return id_producto; }

    public void setId_producto(int id_producto) { this.id_producto = id_producto; }

    public String getNombre_producto() { return nombre_producto; }

    public void setNombre_producto(String nombre_producto) { this.nombre_producto = nombre_producto; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getCosto() { return costo; }

    public void setCosto(double costo) { this.costo = costo; }

    public int getId_proveedor() { return id_proveedor; }

    public void setId_proveedor(int id_proveedor) { this.id_proveedor = id_proveedor; }

    public int getId_categoria() { return id_categoria; }

    public void setId_categoria(int id_categoria) { this.id_categoria = id_categoria; }

    public void INSERT(){
        String query = "INSERT INTO proveedor (nombre_producto, descripcion, cantidad, costo)" +
                "VALUES ('"+nombre_producto+"', '"+descripcion+"', "+cantidad+",  "+costo+", '"+id_proveedor+"', '"+id_categoria+"')";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void UPDATE(){

        String query = "UPDATE producto SET " +
                "nombre_producto = '" + nombre_producto + "', " +
                "descripcion = '" + descripcion+ "'," +
                "cantidad =" + cantidad+ "" +
                "costo =" + costo+"" +
                "id_proveedor ='" + id_proveedor+"'" +
                "id_categoria ='" + id_categoria+"'" +
                "WHERE id_producto = " + id_producto;
        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void DELETE(){

        String query = "DELETE FROM producto WHERE id_producto = "+id_producto+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<ProductoDAO> SELECT(){

        ObservableList<ProductoDAO> list = FXCollections.observableArrayList();
        ProductoDAO prodDAO = null;

        String query = "SELECT * FROM proveedor ";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                prodDAO = new ProductoDAO();
                prodDAO.id_producto = res.getInt("id_producto");
                prodDAO.nombre_producto = res.getString("nombre_producto");
                prodDAO.descripcion = res.getString("descripcion");
                prodDAO.cantidad = res.getInt("cantidad");
                prodDAO.costo = res.getDouble("costo");
                prodDAO.id_categoria = res.getInt("id_categoria");
                prodDAO.id_proveedor = res.getInt("id_proveedor");
                list.add(prodDAO);
            }
        } catch (Exception e){

        }
        return list;
    }


}
