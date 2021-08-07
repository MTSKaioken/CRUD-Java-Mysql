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
public class Fornecedor {
    private int id;
    private String empresa_fornecedora;
    private String cnpj;
    private String endereco;
    private int telefone;
    
    public Fornecedor(){
        
    }
    public Fornecedor(String empresa, String cnpj, String endereco, int telefone){
        setEmpresa_fornecedora(empresa);
        setCnpj(cnpj);
        setEndereco(endereco);
        setTelefone(telefone);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa_fornecedora() {
        return empresa_fornecedora;
    }

    public void setEmpresa_fornecedora(String empresa_fornecedora) {
        this.empresa_fornecedora = empresa_fornecedora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
}
