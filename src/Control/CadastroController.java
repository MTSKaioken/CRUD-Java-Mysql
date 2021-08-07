/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.CadastroView;
import View.MenuView;
import Model.Usuario;
import Model.dao.UsuariosDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author mtskaioken
 */
public class CadastroController {
    private CadastroView view;

     public CadastroController(CadastroView view) {
        this.view = view;
    }
    
    
    public void SalvaUsuario(){        
    String Login = view.getTxtLogin().getText();
    String Senha = view.getTxtSenha().getText();
    Usuario usuario = new Usuario(Login, Senha);
    UsuariosDAO usuarioDao = new UsuariosDAO();       
    usuarioDao.insert(usuario);      
    }
    
}
