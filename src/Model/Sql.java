/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.sql.*;

/**
 *
 * @author mtskaioken
 */
public final class Sql { 
    private static String url ="jdbc:mysql://localhost:3360/CRUD";
    private static String user ="root";
    private static String pw = "";
    private static Connection conn = null;
    private static String login_bd;
    private static String senha_bd;
    
    public static Connection SqlConnect(){
        try {
            conn = DriverManager.getConnection(getUrl(), getUser(), getPw());
            Statement stmt = conn.createStatement(); 
            return conn;
            } catch (SQLException e) {
            return null;
        }
   }
   //consulta sql
   //alterar o parâmetro desse método para receber a inserção sql
   public static String SqlRequest(String login, String senha){
       try {
            Statement smtp = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = smtp.executeQuery("SELECT login, senha FROM usuario WHERE login='"+login+"' and senha='"+senha+"'");
            
            while (rs.next()) {                        
            login_bd = rs.getString("login");
            senha_bd = rs.getString("senha");
            return "Login é: "+login_bd+"\nSenha é: "+senha_bd;
            }
            return "Dado para pesquisa Incorreto!";
            
        } catch (SQLException sqlErro) {
            return "erro sql: "+sqlErro;
        }
    }
   //envio de sql
   public static void SqlResponse(){
       
   }
   
    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }
    public static String getPw() {
        return pw;
    }
   
}
