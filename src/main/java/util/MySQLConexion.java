package util;
import java.sql.*;
public class MySQLConexion {
    
    public static Connection getConexion(){
        Connection con = null;
        
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost/bdGestionPedidos"; 
            String usr = "root";
            String psw = ""; 
            con = DriverManager.getConnection(url,usr,psw); 
            System.out.println("conexion ok");
        } catch (ClassNotFoundException ex) { 
            System.out.println("No hay Driver!!"); 
        } catch (SQLException ex) { 
            System.out.println("Error con la BD "); 
        }
        
        return con; 
    }
    
}

