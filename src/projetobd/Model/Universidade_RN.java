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
public class Universidade_RN {

    Conexao conex;

    public Universidade_RN() {
        conex = new Conexao();
    }

//CADASTROS---------------------------------------------------------------------
    public boolean inserirUniversidade(Universidade_VO obj) throws Exception {     
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_universidade_insert(?,?,?)}");
            
            System.out.println(obj.getNome());
            ps2.setString(3, obj.getNome());
            ps2.setString(2, obj.getCnpj());
            ps2.setString(1, obj.getPkUNi());
            

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao cadastrar Universidade:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EDITAR------------------------------------------------------------------------

    public boolean editarUniversidade(Universidade_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_Universidade_update(?,?,?,?)}");

            ps2.setString(3, obj.getCnpj());
            ps2.setString(4, obj.getNome());
            ps2.setString(1, obj.getPkUNi());
            ps2.setString(2, obj.getNewPkUni());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao editar acessos da Universidade:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EXCLUIR------------------------------------------------------------------------

    public boolean excluirUniversidade(Universidade_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_universidade_delete(?)}");

            ps2.setString(1, obj.getPkUNi());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir acessos da universidade:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------  
//SELECT------------------------------------------------------------------------

    public boolean selectUniversidade(Universidade_VO obj) throws Exception {
        Universidade_VO UniversidadeVO = obj;
        try {
            conex = new Conexao();
            Statement stm = conex.conectar().createStatement();

            ResultSet rs = stm.executeQuery("Select * from Universidade where PK_uni = " + "'" + UniversidadeVO.getPkUNi() + "'");
            while (rs.next()) {
                UniversidadeVO.setNome(rs.getString("NOME"));
                UniversidadeVO.setCnpj(rs.getString("CNPJ"));
                UniversidadeVO.setPkUNi(rs.getString("PK_uni"));
                return true;

            }
        } catch (SQLException e) {
            throw new Exception("Falha na busca de Universidade:\n" + e.getMessage());
        }
        return false;
    }
//------------------------------------------------------------------------------
}
