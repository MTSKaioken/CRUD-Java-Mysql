/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import com.mysql.cj.protocol.Resultset;
import connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuarios;

/**
 *
 * @author mtskaioken
 */
public class UsuariosDAO {    
    public void insert(Usuarios Usuario){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    try {
        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, Usuario.getLogin());
        stmt.setString(2, Usuario.getSenha());
        stmt.executeUpdate();
        System.out.println("Conexão e Query executadas");
    }
    catch (SQLException ex){
        System.out.print("Erro na consulta");
        }
    finally{
        System.out.println("Conexão Fechada");
        ConnectionFactory.closeConnection(con, stmt);
    }
} 
    public boolean AutentificaUsuario(Usuarios usuarioAutenticar) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
        String sql = "SELECT * FROM usuario WHERE login = ? and senha = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, usuarioAutenticar.getLogin());
        stmt.setString(2, usuarioAutenticar.getSenha());
        stmt.execute();
        
        rs = stmt.getResultSet();
        }
        catch(SQLException ex){
            System.out.println("Erro");
        }
        finally{
            return rs.next();
        }
    }    
}
