package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProveedoresDAO {

    private int id_proveedor;
    private String nombre_proveedor;
    private String telefono;
    private String direccion;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void INSERT(){

        String query = "INSERT INTO proveedor (nombre_proveedor, telefono, direccion)" +
                "VALUES ('"+nombre_proveedor+"', '"+telefono+"', '"+direccion+"')";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void UPDATE(){

        String query = "UPDATE proveedor SET" +
                "nombre_proveedor = '" + nombre_proveedor + "', " +
                "telefono = '" + telefono+ "'," +
                "direccion ='" + direccion+ "'" +
                "WHERE id_proveedor = '" + id_proveedor+ "'";
        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void DELETE(){

        String query = "DELETE FROM proveedor WHERE id_proveedor = "+id_proveedor+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<ProveedoresDAO> SELECT(){

        ObservableList<ProveedoresDAO> list = FXCollections.observableArrayList();
        ProveedoresDAO provDAO = null;

        String query = "SELECT * FROM proveedor ";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                provDAO = new ProveedoresDAO();
                provDAO.id_proveedor = res.getInt("id_proveedor");
                provDAO.nombre_proveedor = res.getString("nombre_proveedor");
                provDAO.telefono = res.getString("telefono");
                provDAO.direccion = res.getString("direccion");
                list.add(provDAO);
            }
        } catch (Exception e){

        }
            return list;
    }
}
