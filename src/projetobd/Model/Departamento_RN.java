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
 * @author gabri
 */
public class Departamento_RN {

    Conexao conex;

    public Departamento_RN() {
        conex = new Conexao();
    }

//CADASTROS---------------------------------------------------------------------
    public boolean inserirDepartamento(Departamento_VO obj) throws Exception {  
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_departamento_insert(?,?,?,?)}");

            ps2.setString(1, obj.getPK_IDdepartamento());
            ps2.setString(2, obj.getFK_IDsetor());
            ps2.setString(3, obj.getHora_total_curso());
            ps2.setString(4, obj.getNum_creditos());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao cadastrar ao Departamento:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EDITAR------------------------------------------------------------------------

    public boolean editarDepartamento(Departamento_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_Departamento_update(?,?,?,?,?)}");

            ps2.setString(1, obj.getPK_IDdepartamento());
            ps2.setString(2, obj.getNewPK_IDdepartamento());
            ps2.setString(3, obj.getFK_IDsetor());
            ps2.setString(4, obj.getHora_total_curso());
            ps2.setString(5, obj.getNum_creditos());
            
            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao editar acessos da Departamento:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EXCLUIR------------------------------------------------------------------------

    public boolean excluirDepartamento(Departamento_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_departamento_delete(?)}");

            ps2.setString(1, obj.getPK_IDdepartamento());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir acessos da Departamento:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------  
//SELECT------------------------------------------------------------------------

    public boolean selectDepartamento(Departamento_VO obj) throws Exception {
        Departamento_VO DepartamentoVO = obj;
        try {
            conex = new Conexao();
            Statement stm = conex.conectar().createStatement();

            ResultSet rs = stm.executeQuery("Select * from Departamento where PK_IDdepartamento = " + "'" + DepartamentoVO.getPK_IDdepartamento() + "'");
            while (rs.next()) {
                DepartamentoVO.setPK_IDdepartamento(rs.getString("PK_IDdepartamento"));
                DepartamentoVO.setFK_IDsetor(rs.getString("FK_IDsetor"));
                DepartamentoVO.setHora_total_curso(rs.getString("hora_total_curso"));
                DepartamentoVO.setNum_creditos(rs.getString("num_creditos"));
                return true;

            }
        } catch (SQLException e) {
            throw new Exception("Falha na busca de Departamento:\n" + e.getMessage());
        }
        return false;
    }
//------------------------------------------------------------------------------
}
