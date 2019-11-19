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
public class Disciplina_RN {

    Conexao conex;

    public Disciplina_RN() {
        conex = new Conexao();
    }

//CADASTROS---------------------------------------------------------------------
    public boolean inserirDisciplinas(Disciplina_VO obj) throws Exception {  
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_disciplina_insert(?,?,?,?,?,?,?)}");

            ps2.setString(7, obj.getCheck_disciplina_obg());
            ps2.setString(6, obj.getNome());
            ps2.setString(5, obj.getHoras());
            ps2.setString(4, obj.getPreRequisitos());
            ps2.setString(3, obj.getModalidade());
            ps2.setString(2, obj.getData());
            ps2.setString(1, obj.getPK_IDdisciplina());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao cadastrar ao Disciplinas:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EDITAR------------------------------------------------------------------------

    public boolean editarDisciplina(Disciplina_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_disciplinas_update(?,?,?,?,?,?,?,?)}");

            ps2.setString(8, obj.getCheck_disciplina_obg());
            ps2.setString(7, obj.getNome());
            ps2.setString(6, obj.getHoras());
            ps2.setString(5, obj.getPreRequisitos());
            ps2.setString(4, obj.getModalidade());
            ps2.setString(3, obj.getData());
            ps2.setString(1, obj.getPK_IDdisciplina());
            ps2.setString(2, obj.getNewPK_IDdisciplina());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao editar acessos da Disciplina:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------
//EXCLUIR------------------------------------------------------------------------

    public boolean excluirDisciplina(Disciplina_VO obj) throws Exception {
        try {
            conex = new Conexao();
            PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_disciplinas_delete(?)}");

            ps2.setString(1, obj.getPK_IDdisciplina());

            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Falha ao excluir acessos da Disciplina:\n" + e.getMessage());
        }
    }
//------------------------------------------------------------------------------  
//SELECT------------------------------------------------------------------------

    public boolean selectDisciplina(Disciplina_VO obj) throws Exception {
        Disciplina_VO DisciplinaVO = obj;
        try {
            conex = new Conexao();
            Statement stm = conex.conectar().createStatement();

            ResultSet rs = stm.executeQuery("Select * from disciplinas where PK_IDdisciplinas = " + "'" + DisciplinaVO.getPK_IDdisciplina() + "'");
            while (rs.next()) {
                DisciplinaVO.setCheck_disciplina_obg(rs.getString("check_disciplina_obg"));
                DisciplinaVO.setNome(rs.getString("nome"));
                DisciplinaVO.setHoras(rs.getString("HORAS"));
                DisciplinaVO.setPreRequisitos(rs.getString("REQUESITO"));
                DisciplinaVO.setModalidade(rs.getString("MODALIDADE"));
                DisciplinaVO.setData(rs.getString("DATA"));
                DisciplinaVO.setPK_IDdisciplina(rs.getString("PK_IDdisciplinas"));
                return true;

            }
        } catch (SQLException e) {
            throw new Exception("Falha na busca de Departamento:\n" + e.getMessage());
        }
        return false;
    }
//------------------------------------------------------------------------------
}