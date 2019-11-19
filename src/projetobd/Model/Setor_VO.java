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
public class Setor_VO {
    private String nome;
    private String PKIdSetor;
    private String FkUni;
    private String NewPkIdSetor;
    
//---------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
//---------------------------
    public String getPKIdSetor() {
        return PKIdSetor;
    }

    public void setPKIdSetor(String PKIdSetor) {
        this.PKIdSetor = PKIdSetor;
    }
//--------------------------- 
    public String getFkUni() {
        return FkUni;
    }

    public void setFkUni(String FkUni) {
        this.FkUni = FkUni;
    }
//---------------------------
    public String getNewPkIdSetor() {
        return NewPkIdSetor;
    }

    public void setNewPkIdSetor(String NewPkIdSetor) {
        this.NewPkIdSetor = NewPkIdSetor;
    }
}