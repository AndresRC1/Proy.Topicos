package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdenDAO {private int id_orden;
    private String nota;

    public int getId_orden() { return id_orden; }

    public void setId_orden(int id_orden) { this.id_orden = id_orden; }

    public String getNota() { return nota; }

    public void setNota(String nota) { this.nota = nota; }

    public void INSERT(){

        String query = "INSERT INTO orden (nota)" +
                "VALUES ('"+nota+"')";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void UPDATE(){

        String query = "UPDATE orden SET " +
                "nota  ='"+nota+"' "+
                "WHERE id_orden = " +id_orden;
        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void DELETE(){

        String query = "DELETE FROM orden WHERE id_orden = "+id_orden+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<OrdenDAO> SELECT(){

        ObservableList<OrdenDAO> list = FXCollections.observableArrayList();
        OrdenDAO ordDAO = null;

        String query = "SELECT * FROM orden ";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                ordDAO = new OrdenDAO();
                ordDAO.id_orden = res.getInt("id_orden");
                ordDAO.nota = res.getString("nota");
                list.add(ordDAO);
            }
        } catch (Exception e){

        }
        return list;
    }

    public ObservableList<OrdenDAO> COMOBOCAT(){

        ObservableList<OrdenDAO> list = FXCollections.observableArrayList();
        OrdenDAO ordDAO = null;

        String query = "select nota from orden; ";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                ordDAO = new OrdenDAO();
                ordDAO.nota = res.getString("nota");
                list.add(ordDAO);
            }
        } catch (Exception e){

        }
        return list;
    }
}
