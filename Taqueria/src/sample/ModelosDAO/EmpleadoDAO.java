package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoDAO {
    private  int id_empleado;
    private String nombre_empleado;
    private String telefono;
    private String direccion;
    private String usuario;
    private String password;

    public int getId_empleado() { return id_empleado; }

    public void setId_empleado(int id_empleado) { this.id_empleado = id_empleado; }

    public String getNombre_empleado() { return nombre_empleado; }

    public void setNombre_empleado(String nombre_empleado) { this.nombre_empleado = nombre_empleado; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getUsuario() { return usuario; }

    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public void INSERT(){
        String query = "INSERT INTO empleado (nombre_emplead, telefono, direccion, usuario, password)" +
                "VALUES ('"+nombre_empleado+"', '"+telefono+"', "+direccion+",  "+usuario+", "+password+")";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void UPDATE(){

        String query = " UPDATE empleado SET " +
                " nombre_empleado = '" + nombre_empleado + "', " +
                " telefono = '" + telefono + "'," +
                " direccion ='" + direccion + "'," +
                " usuario ='" + usuario +"'," +
                " password ='" + password +"'" +
                " WHERE id_empleado = " + id_empleado;
        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void DELETE(){

        String query = "DELETE FROM empleado WHERE id_empleado = "+id_empleado+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ObservableList<EmpleadoDAO> SELECT(){

        ObservableList<EmpleadoDAO> list = FXCollections.observableArrayList();
        EmpleadoDAO empDAO = null;

        String query = "SELECT * FROM empleado";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                empDAO = new EmpleadoDAO();
                empDAO.id_empleado = res.getInt("id_empleado");
                empDAO.nombre_empleado = res.getString("nombre_empleado");
                empDAO.telefono = res.getString("telefono");
                empDAO.direccion = res.getString("direccion");
                empDAO.usuario = res.getString("usuario");
                empDAO.password = res.getString("password");
                list.add(empDAO);
            }
        } catch (Exception e){

        }
        return list;
    }
}
