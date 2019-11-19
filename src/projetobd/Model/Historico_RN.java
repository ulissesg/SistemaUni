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
public class Historico_RN {
   
    Conexao conex;
    
    public Historico_RN(){
        conex = new Conexao();
    }
    
    //INSERIR-------------------------------------------------------------------
    public boolean inserirHistorico (Historico_VO his) throws Exception{
        try {

            conex = new Conexao();
            PreparedStatement insertH = conex.conectar().prepareCall("{call dbo.p_historico_insert(?,?,?,?,?)}");
            
            insertH.setString(1, his.getNum_vezes_cursado());
            insertH.setString(2, his.getNota_final());
            insertH.setString(3, his.getDisciplina());
            insertH.setString(4, his.getSituacao());
            insertH.setString(5, his.getFK_GRR());

            insertH.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
            throw new Exception("Falha ao inserir no historico:\n" + e.getMessage());
            
        }
    }
    
    //EDITAR--------------------------------------------------------------------
    public boolean editarHistorico (Historico_VO his) throws Exception {
        
        try {
            conex = new Conexao();
            PreparedStatement editarH = conex.conectar().prepareCall("{call dbo.p_historico_update(?,?,?,?,?,?)}");
            
            editarH.setString(1, his.getPK_historico());
            editarH.setString(2, his.getNum_vezes_cursado());
            editarH.setString(3, his.getNota_final());
            editarH.setString(4, his.getDisciplina());
            editarH.setString(5, his.getSituacao());
            editarH.setString(6, his.getFK_GRR());
            
            editarH.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
            throw new Exception("Falha ao editar no historico:\n" + e.getMessage());
            
        }
    }
    
    //EXCLUIR-------------------------------------------------------------------
    
    public boolean excluirHistorico (Historico_VO his) throws Exception{
        try {
            conex = new Conexao();
            
            PreparedStatement excluirH = conex.conectar().prepareCall("{call dbo.p_historico_delete(?)}");
            
            excluirH.setString(1, his.getPK_historico());
            
            excluirH.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
            throw new Exception("Falha ao excluir do historico:\n" + e.getMessage());
            
        }
    }
    
    //SELECT--------------------------------------------------------------------
    
    public boolean selectHistorico (Historico_VO his) throws Exception{
        
        Historico_VO historico = his;
        
        try {
            
            conex = new Conexao();
            
            Statement selectH = conex.conectar().createStatement();
            
            ResultSet rs = selectH.executeQuery("Select * from historico where PK_historico = " + "'" + his.getPK_historico() + "'");
            
            while (rs.next()){
                
                historico.setPK_historico(rs.getString("PK_historico"));
                historico.setNum_vezes_cursado(rs.getString("num_vezes_cursado"));
                historico.setNota_final(rs.getString("nota_final"));
                historico.setDisciplina(rs.getString("disciplina"));
                historico.setSituacao(rs.getString("situacao"));
                historico.setFK_GRR(rs.getString("FK_GRR"));
                return true;
                
            }
        } catch (SQLException e) {
            
            throw new Exception("Falha na selecao no historico:\n" + e.getMessage());
            
        }
        return false;
    }
}
