/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author uliss
 */
public class Turma_RN {
    
    Conexao conex;

    public Turma_RN (){
        conex = new Conexao();
    }
    
    // Inserir -----------------------------------------------------------------
    
    public boolean inserirTurma (Turma_VO tur) throws Exception {
        try {
            conex = new Conexao();
            
            PreparedStatement insertTur = conex.conectar().prepareCall("{call dbo.p_turma_insert(?,?,?,?,?,?)}");
            
            insertTur.setString(1, tur.getPKIDturma());
            insertTur.setString(2, tur.getFKCurso());
            insertTur.setString(3, tur.getFKIDdisciplina());
            insertTur.setString(4, tur.getNum_curso());
            insertTur.setString(5, tur.getSemestre());
            insertTur.setString(6, tur.getFKIDprofessor());
            
            insertTur.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao inserir na turma: \n" + e.getMessage());
        }
    }
    
    //Editar -------------------------------------------------------------------
    
    public boolean editarTurma (Turma_VO tur) throws Exception {
        try {
            conex = new Conexao();
            
            PreparedStatement editarTur = conex.conectar().prepareCall("{call dbo.p_turma_update(?,?,?,?,?,?,?)}");
            
            editarTur.setString(1, tur.getPKIDturma());
            editarTur.setString(2, tur.getNewPkIDTurma());
            editarTur.setString(3, tur.getFKCurso());
            editarTur.setString(4, tur.getFKIDdisciplina());
            editarTur.setString(5, tur.getNum_curso());
            editarTur.setString(6, tur.getSemestre());
            editarTur.setString(7, tur.getFKIDprofessor());
            
            editarTur.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao editar na turma: \n" + e.getMessage());
        }
    }
    
    //Buscar -------------------------------------------------------------------
    
    public boolean buscarTurma (Turma_VO tur) throws Exception{
        try {
            conex = new Conexao();
            
            Statement buscaTur = conex.conectar().createStatement();
            
            
            ResultSet rs = buscaTur.executeQuery("select *  from turma where PK_IDturma = " + "'" + tur.getPKIDturma() + "'");
            
            while(rs.next()){
                tur.setPKIDturma(rs.getString("PK_IDturma"));
                tur.setFKCurso(rs.getString("FK_curso"));
                tur.setFKIDdisciplina(rs.getString("FK_IDdisciplina"));
                tur.setNum_curso(rs.getString("num_curso"));
                tur.setSemestre(rs.getString("semestre"));
                tur.setFKIDprofessor(rs.getString("FK_IDprofessor"));
                return true;
            }
            
        } catch (SQLException e) {
            throw new Exception("Falha ao bucar em turma: \n" + e.getMessage());
        }
        return false;
    }
    
    //EXCLUIR ------------------------------------------------------------------]
    
    public boolean excluirTurma (Turma_VO tur) throws Exception {
        try {
            conex = new Conexao();
            
            PreparedStatement excluirTur = conex.conectar().prepareCall("{call dbo.p_turma_delete(?)}");
            
            excluirTur.setString(1, tur.getPKIDturma());
                       
            excluirTur.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir da turma: \n" + e.getMessage());
        }
    }
    
}
