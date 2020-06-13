package sample.ModelosDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {

    private static String host = "localhost";
    private static String db = "taqueria";
    private static String user = "root";
    private static String pass = "1234";
    public static Connection conn = null;

    public Connection Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+ host +":3306/" + db, user, pass);
            System.out.println("Se ha conectado bien chaval");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /*public static Connection getConnection(){
        if (conn == null) Connect();
        return conn;
    }*/

    public static void Disconnect() {
        try {
            conn.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}