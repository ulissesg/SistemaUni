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
public class Curso_RN {
    
     Conexao conex;
     
     public Curso_RN (){
         conex = new Conexao();
     }
     
     //Inserir -----------------------------------------------------------------
     
     public boolean inserirCurso (Curso_VO cur) throws Exception{
         try {
             conex = new Conexao();
             
             PreparedStatement insertCur = conex.conectar().prepareCall("{call dbo.p_cursos_insert(?,?,?,?)}");
             
             insertCur.setString(1, cur.getPkCursos());
             insertCur.setString(2, cur.getCoordenador());
             insertCur.setString(3, cur.getModalidade());
             insertCur.setString(4, cur.getNome());
             
             insertCur.executeUpdate();
             return true;
             
         } catch (SQLException e) {
             throw new Exception("Falha ao inserir em curso: \n" + e.getMessage());
         }
     }
     
     //Editar ------------------------------------------------------------------
     
     public boolean editarCurso (Curso_VO cur) throws Exception{
         try {
             conex = new Conexao();
             
             PreparedStatement editarCur = conex.conectar().prepareCall("{call dbo.p_cursos_update(?,?,?,?,?)}");
             
             editarCur.setString(1, cur.getPkCursos());
             editarCur.setString(2, cur.getNewPkCursos());
             editarCur.setString(3, cur.getCoordenador());
             editarCur.setString(4, cur.getModalidade());
             editarCur.setString(5, cur.getNome());
             
             editarCur.executeUpdate();
             return true;
             
         } catch (SQLException e) {
             throw new Exception("Falha ao editar em curso: \n" + e.getMessage());
         }
     }
     
     //Buscar ------------------------------------------------------------------
     
     public boolean buscarCurso (Curso_VO cur) throws Exception{
         try {
             conex = new Conexao();
             
             Statement buscCur = conex.conectar().createStatement();
             
             ResultSet rs = buscCur.executeQuery("select * from cursos where PK_cursos = " + "'" + cur.getPkCursos() + "'");
             
             while (rs.next()){
                 cur.setPkCursos(rs.getString("PK_cursos"));
                 cur.setCoordenador(rs.getString("coordenador"));
                 cur.setModalidade(rs.getString("modalidade"));
                 cur.setNome(rs.getString("nome"));
                 return true;
             }
             
         } catch (SQLException e) {
             throw new Exception("Falha ao buscar em curso: \n" + e.getMessage());
         }
         return false;
     }
     
     // Excluir ----------------------------------------------------------------
     
     public boolean excluirCurso (Curso_VO cur) throws Exception{
         try {
             conex = new Conexao();
             
             PreparedStatement excluirCur = conex.conectar().prepareCall("{call dbo.p_cursos_delete(?)}");
             
             excluirCur.setString(1, cur.getPkCursos());
             
             excluirCur.executeUpdate();
             return true;
             
         } catch (SQLException e) {
             throw new Exception("Falha ao excluir do curso: \n" + e.getMessage());
         }
     }
}
