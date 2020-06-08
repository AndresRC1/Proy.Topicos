package sample.ModelosDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaDAO {
    private int id_categoria;
    private String categoria;

    public int getId_categoria() { return id_categoria; }

    public void setId_categoria(int id_categoria) { this.id_categoria = id_categoria; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public void INSERT(){

        String query = "INSERT INTO categoria_producto (categoria)" +
                "VALUES ('"+categoria+"')";
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void UPDATE(){

        String query = "UPDATE categoria_producto SET " +
                "categoria  ='"+categoria+"' "+
                "WHERE id_categoria = " +id_categoria;
        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void DELETE(){

        String query = "DELETE FROM categoria_producto WHERE id_categoria = "+id_categoria+"";

        System.out.println(query);
        try {
            Statement st = Conexion.conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<CategoriaDAO> SELECT(){

        ObservableList<CategoriaDAO> list = FXCollections.observableArrayList();
        CategoriaDAO catDAO = null;

        String query = "SELECT * FROM categoria_producto ";

        try {
            Statement st = Conexion.conn.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()){
                catDAO = new CategoriaDAO();
                catDAO.id_categoria = res.getInt("id_categoria");
                catDAO.categoria = res.getString("categoria");
                list.add(catDAO);
            }
        } catch (Exception e){

        }
        return list;
    }
}
