 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Fornecedor;
import Model.dao.FornecedorDAO;
import View.MenuView;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mtskaioken
 */
public class MenuController {
     private MenuView view;

     public MenuController(MenuView view) {
        this.view = view;
    }
     //vou ter que fzr métodos placeholders para todos txtFields, melhorar isso numa versão posterior
     public void setPlaceHolderEmpresaFornecedora(String placeholder){
         JTextField EmpresaFornecedora = view.getTxtEmpresaFornecedora();
         if (EmpresaFornecedora.getText().equals(placeholder)) {
         EmpresaFornecedora.setText("");
         EmpresaFornecedora.setForeground(Color.BLACK);
        }
    }    
    public void clearPlaceHolderEmpresaFornecedora(String placeholder){
         JTextField EmpresaFornecedora = view.getTxtEmpresaFornecedora();
        if (EmpresaFornecedora.getText().isEmpty()) {
         EmpresaFornecedora.setForeground(Color.GRAY);
         EmpresaFornecedora.setText(placeholder);
        }
    }
    public void setPlaceHolderCnpj(String placeholder){
        JTextField Cnpj = view.getTxtCnpj();
         if (Cnpj.getText().equals(placeholder)) {
         Cnpj.setText("");
         Cnpj.setForeground(Color.BLACK);
        }
    }    
    public void clearPlaceHolderCnpj(String placeholder){
        JTextField Cnpj = view.getTxtCnpj();
        if (Cnpj.getText().isEmpty()) {
         Cnpj.setForeground(Color.GRAY);
         Cnpj.setText(placeholder);
        }
    }

    public void setPlaceHolderEnderecoSede(String placeholder) {
        JTextField EnderecoSede = view.getTxtEnderecoSede();
         if (EnderecoSede.getText().equals(placeholder)) {
         EnderecoSede.setText("");
         EnderecoSede.setForeground(Color.BLACK);
        }
    }
    
    public void clearPlaceHolderEnderecoSede(String placeholder) {
        JTextField EnderecoSede = view.getTxtEnderecoSede();
        if (EnderecoSede.getText().isEmpty()) {
         EnderecoSede.setForeground(Color.GRAY);
         EnderecoSede.setText(placeholder);
        }
    }   

    public void setPlaceHolderTelefone(String placeholder) {
        JTextField Telefone = view.getTxtTelefoneEmpresa();
         if (Telefone.getText().equals(placeholder)) {
         Telefone.setText("");
         Telefone.setForeground(Color.BLACK);
        }
     }
    
    public void clearPlaceHolderTelefone(String placeholder) {
        JTextField Telefone = view.getTxtTelefoneEmpresa();
        if (Telefone.getText().isEmpty()) {
         Telefone.setForeground(Color.GRAY);
         Telefone.setText(placeholder);
        }
    }
    public void SalvaFornecedor(){ //Create
      String Empresa_Fornecedora = view.getTxtEmpresaFornecedora().getText();
      String Cnpj = view.getTxtCnpj().getText();
      String Endereco = view.getTxtEnderecoSede().getText();
      int Telefone = Integer.parseInt(view.getTxtTelefoneEmpresa().getText());
        
      Fornecedor fornecedor = new Fornecedor(Empresa_Fornecedora, Cnpj, Endereco, Telefone);
      FornecedorDAO FornecedorDao = new FornecedorDAO();       
    
      FornecedorDao.insert(fornecedor);
        
      view.getTxtEmpresaFornecedora().setText("");
      view.getTxtCnpj().setText("");
      view.getTxtEnderecoSede().setText("");
      view.getTxtTelefoneEmpresa().setText("");
      
      clearPlaceHolderEmpresaFornecedora("Empresa:");
      clearPlaceHolderCnpj("CNPJ:"); 
      clearPlaceHolderEnderecoSede("Endereço:");
      clearPlaceHolderTelefone("Telefone:");
    }
    public void readJTable(){ //Read
       DefaultTableModel modelo = (DefaultTableModel) view.getjTabela().getModel();
       modelo.setNumRows(0);
       FornecedorDAO fdao = new FornecedorDAO();
       
       for(Fornecedor f: fdao.read()) {
            
           modelo.addRow(new Object[]{
            f.getId(),
            f.getEmpresa_fornecedora(),
            f.getCnpj(),
            f.getEndereco(),
            f.getTelefone()
            });
       }
    }
    public void getRowFornecedor(){
        if (view.getjTabela().getSelectedRow() != -1){
          
          view.getTxtEmpresaFornecedora().setForeground(Color.BLACK);
          view.getTxtCnpj().setForeground(Color.BLACK);
          view.getTxtEnderecoSede().setForeground(Color.BLACK);         
          view.getTxtTelefoneEmpresa().setForeground(Color.BLACK);
          
          view.getTxtEmpresaFornecedora().setText(view.getjTabela().getValueAt(view.getjTabela().getSelectedRow(), 1).toString());
          view.getTxtCnpj().setText(view.getjTabela().getValueAt(view.getjTabela().getSelectedRow(), 2).toString());  
          view.getTxtEnderecoSede().setText(view.getjTabela().getValueAt(view.getjTabela().getSelectedRow(), 3).toString());
          view.getTxtTelefoneEmpresa().setText(view.getjTabela().getValueAt(view.getjTabela().getSelectedRow(), 4).toString());
        }
    }
    public void updateFornecedor(){    //Update
        if (view.getjTabela().getSelectedRow() != -1){
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fornecedorDao = new FornecedorDAO();

        fornecedor.setId((int)view.getjTabela().getValueAt(view.getjTabela().getSelectedRow(), 0));
        fornecedor.setEmpresa_fornecedora(view.getTxtEmpresaFornecedora().getText());
        fornecedor.setCnpj(view.getTxtCnpj().getText());
        fornecedor.setEndereco(view.getTxtEnderecoSede().getText());
        fornecedor.setTelefone(Integer.parseInt(view.getTxtTelefoneEmpresa().getText()));
                
        fornecedorDao.update(fornecedor);
        
        view.getTxtEmpresaFornecedora().setText("");
        view.getTxtCnpj().setText("");
        view.getTxtEnderecoSede().setText("");
        view.getTxtTelefoneEmpresa().setText("");

        clearPlaceHolderEmpresaFornecedora("Empresa:");
        clearPlaceHolderCnpj("CNPJ:"); 
        clearPlaceHolderEnderecoSede("Endereço:");
        clearPlaceHolderTelefone("Telefone:");
        }
    
    }
}
