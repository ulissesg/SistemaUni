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
public class Curso_VO {
    private String pkCursos;
    private String newPkCursos;
    private String coordenador;
    private String modalidade;
    private String nome;

    public String getPkCursos() {
        return pkCursos;
    }

    public void setPkCursos(String pkCursos) {
        this.pkCursos = pkCursos;
    }

    public String getNewPkCursos() {
        return newPkCursos;
    }

    public void setNewPkCursos(String newPkCursos) {
        this.newPkCursos = newPkCursos;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
