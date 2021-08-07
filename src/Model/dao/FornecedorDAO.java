/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Fornecedor;
import javax.swing.JOptionPane;

/**
 *
 * @author mtskaioken
 */
public class FornecedorDAO {
    public void insert(Fornecedor Fornecedor){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        String sql = "INSERT INTO Fornecedor (nomeempresa, cnpj, endereco, telefone) VALUES (?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, Fornecedor.getEmpresa_fornecedora());
        stmt.setString(2, Fornecedor.getCnpj());
        stmt.setString(3, Fornecedor.getEndereco());
        stmt.setInt(4, Fornecedor.getTelefone());
        stmt.executeUpdate();
        System.out.println("Dados salvos!"); 
           
        }
        catch (SQLException ex){
        System.out.print("Erro ao salvar!");
        }
        finally{
        System.out.println("Conexão Fechada");
        ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Fornecedor> read(){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM Fornecedor";
    List <Fornecedor> fornecedores = new ArrayList<>();
        try{
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();

            while(rs.next()){
               Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setEmpresa_fornecedora(rs.getString("nomeempresa"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelefone(rs.getInt("telefone"));
               fornecedores.add(fornecedor);
            }
        }
        catch(SQLException ex){
            System.out.println("Erro na leitura");
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
     return fornecedores;
    }
    public void update(Fornecedor f){
     Connection con = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;
       try{
           stmt = con.prepareStatement("UPDATE Fornecedor SET nomeempresa = ?, cnpj = ?, endereco = ?, telefone = ? WHERE id = ?");
           stmt.setString(1, f.getEmpresa_fornecedora());
           stmt.setString(2, f.getCnpj());
           stmt.setString(3, f.getEndereco());
           stmt.setInt(4, f.getTelefone());
           stmt.setInt(5, f.getId());
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
       }
       catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt);
         }
       
    }
    
}
