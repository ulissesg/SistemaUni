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
public class Turma_VO {
    private String PKIDturma;
    private String FKCurso;
    private String FKIDdisciplina;
    private String num_curso;
    private String semestre;
    private String FKIDprofessor;
    private String NewPkIDTurma;

    public String getPKIDturma() {
        return PKIDturma;
    }

    public void setPKIDturma(String PKIDturma) {
        this.PKIDturma = PKIDturma;
    }

    public String getFKCurso() {
        return FKCurso;
    }

    public void setFKCurso(String FKCurso) {
        this.FKCurso = FKCurso;
    }

    public String getFKIDdisciplina() {
        return FKIDdisciplina;
    }

    public void setFKIDdisciplina(String FKIDdisciplina) {
        this.FKIDdisciplina = FKIDdisciplina;
    }

    public String getNum_curso() {
        return num_curso;
    }

    public void setNum_curso(String num_curso) {
        this.num_curso = num_curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getFKIDprofessor() {
        return FKIDprofessor;
    }

    public void setFKIDprofessor(String FKIDprofessor) {
        this.FKIDprofessor = FKIDprofessor;
    }

    public String getNewPkIDTurma() {
        return NewPkIDTurma;
    }

    public void setNewPkIDTurma(String NewPkIDTurma) {
        this.NewPkIDTurma = NewPkIDTurma;
    }

}
