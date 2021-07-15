/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mtskaioken
 */
public final class ConnectionFactory { 
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3360/CRUD";
    private static final String USER ="root";
    private static final String PASS ="";
    
    public static Connection getConnection(){
        try {  
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);    
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão.",ex);
        }

   }
    public static void closeConnection(Connection con){       
            try {
                 if(con != null){
                con.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection con, PreparedStatement stmt){       
            closeConnection(con);
            try {
                 if(stmt != null){
                stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){       
            closeConnection(con, stmt);
            try {
                if(rs != null){
                rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
       
    }
    
