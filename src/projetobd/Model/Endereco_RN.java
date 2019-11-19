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
public class Endereco_RN {
    Conexao conex;
    
    public Endereco_RN(){
        conex = new Conexao();
    }
    
    //Inserir ------------------------------------------------------------------
    public boolean inserirEndereco (Endereco_VO end) throws Exception{
        try {
            conex = new Conexao();
            PreparedStatement ps = conex.conectar().prepareCall("{call dbo.p_endereco_insert(?,?,?,?,?,?,?,?)}");
                    
            ps.setString(1, end.getPKEndereco());
            ps.setString(2, end.getCep());
            ps.setString(3, end.getNumero());
            ps.setString(4, end.getRua());
            ps.setString(5, end.getCidade());
            ps.setString(6, end.getPais());
            ps.setString(7, end.getComplemento());
            ps.setString(8, end.getFKGrr());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao inserir no endereco:\n" + e.getMessage());
        }
    }
    
    //Editar -------------------------------------------------------------------
    
    public boolean editarEndereco (Endereco_VO end) throws Exception{
        try {
            conex = new Conexao();
            PreparedStatement ps = conex.conectar().prepareCall("{call dbo.p_endereco_update(?,?,?,?,?,?,?,?,?)}");
            
            ps.setString(1, end.getPKEndereco());
            ps.setString(2, end.getNewPKEndereco());
            ps.setString(3, end.getCep());
            ps.setString(4, end.getNumero());
            ps.setString(5, end.getRua());
            ps.setString(6, end.getCidade());
            ps.setString(7, end.getPais());
            ps.setString(8, end.getComplemento());
            ps.setString(9, end.getFKGrr());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao editar no endereco:\n" + e.getMessage());
        }
    } 
    
    //Buscar -------------------------------------------------------------------
    
    public boolean buscarEndereco (Endereco_VO end) throws Exception{
        
        Endereco_VO endereco = end;
        
        try {
            
            conex = new Conexao();
            
            Statement buscaEnd = conex.conectar().createStatement();
            
            ResultSet rs = buscaEnd.executeQuery("Select * from endereco where PK_endereco = " + "'" + endereco.getPKEndereco() + "'");
            
            while(rs.next()){
                endereco.setPKEndereco(rs.getString("PK_endereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setPais(rs.getString("pais"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setFKGrr(rs.getString("FK_GRR"));
                return true;
            }
            
        } catch (SQLException e) {
            throw new Exception("Falha na busca em endereco:\n" + e.getLocalizedMessage());
        }
        return false;
    }
    
    //Excluir-------------------------------------------------------------------
    
    public boolean excluirEndereco (Endereco_VO end) throws Exception{        
        try {
            
            conex = new Conexao();
            
            PreparedStatement ps = conex.conectar().prepareCall("{call dbo.p_endereco_delete(?)}");
            
            ps.setString(1, end.getPKEndereco());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir no endereco:\n" + e.getMessage());
        }
    }
}
