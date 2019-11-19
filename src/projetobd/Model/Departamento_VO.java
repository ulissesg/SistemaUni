/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

/**
 *
 * @author gabri
 */
public class Departamento_VO {
    private String PK_IDdepartamento;
    private String NewPK_IDdepartamento;
    private String FK_IDsetor;
    private String hora_total_curso;
    private String num_creditos;

    public String getPK_IDdepartamento() {
        return PK_IDdepartamento;
    }

    public void setPK_IDdepartamento(String PK_IDdepartamento) {
        this.PK_IDdepartamento = PK_IDdepartamento;
    }

    public String getFK_IDsetor() {
        return FK_IDsetor;
    }

    public void setFK_IDsetor(String FK_IDsetor) {
        this.FK_IDsetor = FK_IDsetor;
    }

    public String getHora_total_curso() {
        return hora_total_curso;
    }

    public void setHora_total_curso(String hora_total_curso) {
        this.hora_total_curso = hora_total_curso;
    }

    public String getNum_creditos() {
        return num_creditos;
    }

    public void setNum_creditos(String num_creditos) {
        this.num_creditos = num_creditos;
    }

    public String getNewPK_IDdepartamento() {
        return NewPK_IDdepartamento;
    }

    public void setNewPK_IDdepartamento(String NewPK_IDdepartamento) {
        this.NewPK_IDdepartamento = NewPK_IDdepartamento;
    }
    

}    
