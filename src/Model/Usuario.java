/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mtskaioken
 */
public class Usuario {
    private String Login;
    private String Senha;
    
    public Usuario(){
        
    }
    public Usuario(String Login, String Senha){
        setLogin(Login);
        setSenha(Senha);
    }
    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
