/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

/**
 *
 * @author uliss
 */
public class Professor_VO {
    private String pKIdProfessor;
    private String newPkIdProfessor;
    private String fkIdDepartamento;
    private String nome;

    public String getpKIdProfessor() {
        return pKIdProfessor;
    }

    public void setpKIdProfessor(String pKIdProfessor) {
        this.pKIdProfessor = pKIdProfessor;
    }

    public String getFkIdDepartamento() {
        return fkIdDepartamento;
    }

    public void setFkIdDepartamento(String fkIdDepartamento) {
        this.fkIdDepartamento = fkIdDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNewPkIdProfessor() {
        return newPkIdProfessor;
    }

    public void setNewPkIdProfessor(String newPkIdProfessor) {
        this.newPkIdProfessor = newPkIdProfessor;
    }
    
}
