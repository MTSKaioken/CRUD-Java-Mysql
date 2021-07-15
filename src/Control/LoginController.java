/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.CadastroView;
import View.LoginView;
import View.MenuView;
import connection.ConnectionFactory;
import model.Usuarios;
import dao.UsuariosDAO;
import java.sql.SQLException;

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
        
        Usuarios usuarioAutenticar = new Usuarios(login, senha);
        UsuariosDAO usuarioDao = new UsuariosDAO();
        ConnectionFactory.getConnection();
        
        boolean existe = usuarioDao.AutentificaUsuario(usuarioAutenticar);
        
        if(existe){
        MenuView menuView = new MenuView();
        menuView.setVisible(true);
        }
        else{
        System.out.print("Não existe");
        }
    }
    public void CallCadastrar(){
        CadastroView cadastroView = new CadastroView();
        cadastroView.setVisible(true);  
    }

    
    
}
