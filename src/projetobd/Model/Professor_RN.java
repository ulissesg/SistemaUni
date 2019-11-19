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
public class Professor_RN {
    Conexao conex ;
    
    public Professor_RN(){
        conex = new Conexao();
    }
    
    //Inserir ------------------------------------------------------------------
    
    public boolean inserirProf (Professor_VO prof) throws Exception{
        try {
            conex = new Conexao();
            
            PreparedStatement insertProf = conex.conectar().prepareCall("{call dbo.p_professor_insert(?,?,?)}");
            
            insertProf.setString(1, prof.getpKIdProfessor());
            insertProf.setString(2, prof.getFkIdDepartamento());
            insertProf.setString(3, prof.getNome());
            
            insertProf.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao inserir em professor:\n" + e.getMessage());
        }
    }
    
    //Editar -------------------------------------------------------------------
    
    public boolean editarProf (Professor_VO prof) throws Exception{
        try {
            conex = new Conexao();
            
            PreparedStatement editarProf = conex.conectar().prepareCall("{call dbo.p_professor_update(?,?,?,?)}");
            
            editarProf.setString(1, prof.getpKIdProfessor());
            editarProf.setString(2, prof.getNewPkIdProfessor());
            editarProf.setString(3, prof.getFkIdDepartamento());
            editarProf.setString(4, prof.getNome());
            
            editarProf.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao editar em professor:\n" + e.getMessage());
        }
    }
    
    
    //Buscar -------------------------------------------------------------------
    
    public boolean buscarProf (Professor_VO prof) throws Exception{
         try {
             conex = new Conexao();
             
             Statement buscProf = conex.conectar().createStatement();
             
             ResultSet rs = buscProf.executeQuery("select * from professor where PK_IDprofessor = " + "'" + prof.getpKIdProfessor()+ "'");
             
             while (rs.next()){
                 prof.setpKIdProfessor(rs.getString("PK_IDprofessor"));
                 prof.setFkIdDepartamento(rs.getString("FK_IDdepartamento"));
                 prof.setNome(rs.getString("nome"));
                 return true;
             }
             
         } catch (SQLException e) {
             throw new Exception("Falha ao buscar em professor: \n" + e.getMessage());
         }
         return false;
     }
    
    //Excluir ------------------------------------------------------------------
    
    public boolean excluirProf (Professor_VO prof) throws Exception{
        try {
            conex = new Conexao();
            
            PreparedStatement excluirProf = conex.conectar().prepareCall("{call dbo.p_professor_delete(?)}");
            
            excluirProf.setString(1, prof.getpKIdProfessor());
            
            excluirProf.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir em professor:\n" + e.getMessage());
        }
    }
}
