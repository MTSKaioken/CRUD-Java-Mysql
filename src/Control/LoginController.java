/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.LoginView;
import View.MenuView;
import Model.dao.ConnectionFactory;
import Model.Usuario;
import Model.dao.UsuariosDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mtskaioken
 */
public class LoginController {
    private LoginView view;
    
    public LoginController(LoginView view){
        this.view = view;
    }
    public void autenticar() throws SQLException{
        String login = view.getTxtlogin().getText();
        String senha = view.getTxtSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(login, senha);
        UsuariosDAO usuarioDao = new UsuariosDAO();
        ConnectionFactory.getConnection();
        
        boolean existe = usuarioDao.AutentificaUsuario(usuarioAutenticar);
        
        if(existe){
        MenuView menuView = new MenuView();
        menuView.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario e/ou Senha incorretos");
        }
    }
    
    public void CallCadastrar() throws SQLException{
        String login = view.getTxtlogin().getText();
        String senha = view.getTxtSenha().getText();
        if (login.equals("") || senha.equals("")){
            System.out.println("campos vazios");
        }
        else{
        Usuario usuarioAutenticar = new Usuario(login, senha);
        UsuariosDAO usuarioDao = new UsuariosDAO();
        ConnectionFactory.getConnection();
        boolean existe = usuarioDao.AutentificaUsuario(usuarioAutenticar);
        
        if(existe == false){
            SalvaUsuario();              
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
            }
        }
    }
    public void SalvaUsuario(){  
        
    String Login = view.getTxtlogin().getText();
    String Senha = view.getTxtSenha().getText();
    Usuario usuario = new Usuario(Login, Senha);
    UsuariosDAO usuarioDao = new UsuariosDAO();   
    usuarioDao.insert(usuario);
 
    }

    
    
}
