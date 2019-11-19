/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

import java.sql.*;
import java.sql.ResultSet;
/**
 *
 * @author gabriel
 */
public class Setor_RN {

    Conexao conex;

    public Setor_RN() {
        conex = new Conexao();
    }

//CADASTROS---------------------------------------------------------------------
    public boolean inserirSetor(Setor_VO obj) throws Exception { 
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_setor_insert(?,?,?)}");

            ps2.setString(2, obj.getNome());
            ps2.setString(1, obj.getPKIdSetor());
            ps2.setString(3, obj.getFkUni());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao cadastrar ao Setor:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EDITAR------------------------------------------------------------------------

    public boolean editarSetor(Setor_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_setor_update(?,?,?,?)}");

            ps2.setString(1, obj.getPKIdSetor());
            ps2.setString(2, obj.getNewPkIdSetor());
            ps2.setString(3, obj.getNome());
            ps2.setString(4, obj.getFkUni());
            
            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao editar acessos da Setor:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EXCLUIR------------------------------------------------------------------------

    public boolean excluirSetor(Setor_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_setor_delete(?)}");

            ps2.setString(1, obj.getPKIdSetor());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir acessos da Setor:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------  
//SELECT------------------------------------------------------------------------

    public boolean selectSetor(Setor_VO obj) throws Exception {
        Setor_VO SetorVO = obj;
        try {
            conex = new Conexao();
            Statement stm = conex.conectar().createStatement();

            ResultSet rs = stm.executeQuery("Select * from Setor where PK_IDsetor = " + "'" + SetorVO.getPKIdSetor() + "'");
            while (rs.next()) {
                SetorVO.setNome(rs.getString("NOME"));
                SetorVO.setFkUni(rs.getString("FK_uni"));
                SetorVO.setPKIdSetor(rs.getString("PK_IDsetor"));
                return true;

            }
        } catch (SQLException e) {
            throw new Exception("Falha na busca de Setor:\n" + e.getMessage());
        }
        return false;
    }
//------------------------------------------------------------------------------
}
