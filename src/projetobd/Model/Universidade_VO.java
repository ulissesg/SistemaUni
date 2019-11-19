/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

/**
 *
 * @author gabriel
 */
public class Universidade_VO {
    private String nome;
    private String cnpj;
    private String pkUNi;
    private String newPkUni;
    
//---------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }
//---------------------------
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.cnpj = Cnpj;
    }
//--------------------------- 
    public String getPkUNi() {
        return pkUNi;
    }

    public void setPkUNi(String pkUNi) {
        this.pkUNi = pkUNi;
    }
//---------------------------
    public String getNewPkUni() {
        return newPkUni;
    }

    public void setNewPKUni(String NewPKUni) {
        this.newPkUni = NewPKUni;
    }
}