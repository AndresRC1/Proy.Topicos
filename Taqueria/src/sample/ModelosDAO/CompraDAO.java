package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompraDAO {

    private int id_compra;
    private String fecha;
    private int id_empleado;

    public int getId_compra() { return id_compra; }

    public void setId_compra(int id_empleado) { this.id_empleado = id_empleado; }

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getId_empleado() { return id_empleado; }

    public void setId_empleado(int id_empleado) { this.id_empleado = id_empleado; }

    public void INSERT(){
        String query = "INSERT INTO compra (fecha,  id_empleado)" +
                "VALUES ('"+fecha+"', "+id_empleado+")";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void UPDATE(){

        String query = "UPDATE producto SET " +
                "fecha = '" + fecha + "', " +
                "id_empleado =" + id_empleado+"" +
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

        String query = "DELETE FROM compra WHERE id_compra = "+id_compra+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<CompraDAO> SELECT(){

        ObservableList<CompraDAO> list = FXCollections.observableArrayList();
        CompraDAO comDAO = null;

        String query = "SELECT * FROM compra";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                comDAO = new CompraDAO();
                comDAO.id_compra = res.getInt("id_compra");
                comDAO.fecha = res.getString("fecha");
                comDAO.id_empleado = res.getInt("id_empleado");
                list.add(comDAO);
            }
        } catch (Exception e){

        }
        return list;
    }


}
