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
public class Historico_VO {
    private String PK_historico;
    private String num_vezes_cursado;
    private String nota_final;
    private String disciplina;
    private String situacao;
    private String FK_GRR;

    public String getPK_historico() {
        return PK_historico;
    }

    public void setPK_historico(String PK_hsitorico) {
        this.PK_historico = PK_hsitorico;
    }

    public String getNum_vezes_cursado() {
        return num_vezes_cursado;
    }

    public void setNum_vezes_cursado(String num_vezes_cursado) {
        this.num_vezes_cursado = num_vezes_cursado;
    }

    public String getNota_final() {
        return nota_final;
    }

    public void setNota_final(String nota_final) {
        this.nota_final = nota_final;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getFK_GRR() {
        return FK_GRR;
    }

    public void setFK_GRR(String FK_GRR) {
        this.FK_GRR = FK_GRR;
    }
}
