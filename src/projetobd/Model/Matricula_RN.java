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
public class Matricula_RN {
    
    Conexao conex; 
    
    public Matricula_RN (){
        conex = new Conexao();
    }    
    
    //Inserir ------------------------------------------------------------------
    public boolean inserirMatricula(Matricula_VO mat) throws Exception{
        try {
            conex = new Conexao();
            
            PreparedStatement insertMat = conex.conectar().prepareCall("{call dbo.p_matricula_insert(?,?)}");
            
            insertMat.setString(1, mat.getFKGrr());
            insertMat.setString(2, mat.getFKIDTurma());
            
            insertMat.executeUpdate();
            return true;
                        
        } catch (SQLException e) {
            throw new Exception("Falha ao inserir na matricula:\n" + e.getMessage());
        }
    }
    
    //Buscar -------------------------------------------------------------------
    
    public boolean buscaMatricula(Matricula_VO mat) throws Exception{
        try {
            conex = new Conexao();
            
            Statement buscaMat = conex.conectar().createStatement();
            
            ResultSet rs = buscaMat.executeQuery("select * from matricula where FK_GRR = " + "'" + mat.getFKGrr() + "'");
            
            while (rs.next()){
                mat.setFKGrr(rs.getString("FK_GRR"));
                mat.setFKIDTurma(rs.getString("FK_IDturma"));
                return true;
            }
            
        } catch (SQLException e) {
            throw new Exception("Falha ao buscar na matricula:\n" + e.getMessage());
        }
        return false;
    }
    
    //Deletar ------------------------------------------------------------------
    
    public boolean excluirMatricula(Matricula_VO mat) throws Exception{
        try {
            
            conex = new Conexao();
            
            PreparedStatement excluirMat = conex.conectar().prepareCall("{call dbo.p_matricula_delete(?) }");
            
            excluirMat.setString(1, mat.getFKGrr());
            
            excluirMat.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new Exception("Falha ao excluir da matricula: \n" + e.getMessage());
        }
    }
}
