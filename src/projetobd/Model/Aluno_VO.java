/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

import java.sql.Date;

/**
 *
 * @author Jonathan
 */
public class Aluno_VO {
    private String pk_grr;
    private String NewPKGrr;
    private String senha;
    private String nome;
    private String cpf;
    /**
     * @return the pk_grr
     */
    public String getPk_grr() {
        return pk_grr;
    }

    /**
     * @param pk_grr the pk_grr to set
     */
    public void setPk_grr(String pk_grr) {
        this.pk_grr = pk_grr;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNewPKGrr() {
        return NewPKGrr;
    }

    public void setNewPKGrr(String NewPKGrr) {
        this.NewPKGrr = NewPKGrr;
    }
}
