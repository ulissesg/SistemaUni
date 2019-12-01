/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class Aluno_RN {
    
       //declarando uma conexao 
       Conexao conex;

       public Aluno_RN()
       {
              conex = new Conexao();
       }

//CADASTROS---------------------------------------------------------------------
       public boolean inserirAluno(Aluno_VO obj)throws Exception
       {   
              try
              {
                    //cria uma nova conexao
                     conex = new Conexao();
                     //prepara uma nova chamada
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_aluno_insert(?,?,?,?)}");
                     
                     //insere os valores da chamada na chamada
                     ps2.setString (1, obj.getPk_grr());
                     ps2.setString(3, obj.getNome());
                     ps2.setString(2, obj.getCpf());
                     ps2.setString (4, obj.getSenha());
                     
                     //executa a chamada
                     ps2.executeUpdate();
                     return true;
              }
              catch (SQLException e)
              {
                     throw new Exception("Falha ao cadastrar Gerente:\n"+ e.getMessage());
              }
       }
//------------------------------------------------------------------------------
       
       
//EDITAR------------------------------------------------------------------------
       public boolean editarAluno(Aluno_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement  ps2 = conex.conectar().prepareCall("{call dbo.p_Aluno_update(?,?,?,?,?)}");
                     
                     ps2.setString (1, obj.getPk_grr());
                     ps2.setString(2, obj.getNewPKGrr());
                     ps2.setString(4, obj.getNome());
                     ps2.setString(3, obj.getCpf());
                     ps2.setString (5, obj.getSenha());
                     
                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
//------------------------------------------------------------------------------
       
       
//EXCLUIR------------------------------------------------------------------------
       public boolean excluirAluno(Aluno_VO obj) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     PreparedStatement ps2 = conex.conectar().prepareCall("{call dbo.p_aluno_delete(?)}");
                     
                     ps2.setString (1, obj.getPk_grr());

                     ps2.executeUpdate();
                     return true;
              }
              catch (Exception e)
              {
                     throw new Exception("Falha ao editar acessos do gerente:\n" + e.getMessage());
              }
       }
//------------------------------------------------------------------------------
       
       
//LOGINS------------------------------------------------------------------------
       public boolean logar(Aluno_VO obj) throws Exception
       {
              Aluno_VO alunoVO = obj;
              try
              {
                     conex = new Conexao();
                     Statement stm = conex.conectar().createStatement();

                     ResultSet rs = stm.executeQuery("Select * from Aluno where PK_GRR = " + "'" + alunoVO.getPk_grr() + "'");
                     while (rs.next())
                     {
                            if (alunoVO.getSenha().equals(rs.getString("SENHA")))
                            {
                                   alunoVO.setNome(rs.getString("NOME"));
                                   alunoVO.setCpf(rs.getString("CPF"));
                                   alunoVO.setSenha(rs.getString("SENHA"));
                                   
                                   return true;
                            }
                            throw new Exception("Senha incorreta");
                     }
              }
              catch (SQLException e)
              {
                     throw new Exception("Falha no login do Gerente:\n"+e.getMessage());
              }
              return false;
       }
//------------------------------------------------------------------------------   
       
//SELECT------------------------------------------------------------------------
       public boolean selectAluno(Aluno_VO obj) throws Exception
       {
              Aluno_VO alunoVO = obj;
              try
              {
                     conex = new Conexao();
                     Statement stm = conex.conectar().createStatement();

                     ResultSet rs = stm.executeQuery("Select * from Aluno where PK_GRR = " + "'" + alunoVO.getPk_grr() + "'");
                     while (rs.next())
                     {
                        alunoVO.setNome(rs.getString("NOME"));
                        alunoVO.setCpf(rs.getString("CPF"));
                        alunoVO.setSenha(rs.getString("SENHA"));
                        alunoVO.setPk_grr(rs.getString("PK_GRR"));
                        return true;

                     }
              }
              catch (SQLException e)
              {
                     throw new Exception("Falha na busca de gerente:\n"+e.getMessage());
              }
              return false;
       }
//------------------------------------------------------------------------------
//       Lista alunos
       public boolean listaAlunos(List<Aluno_VO> Alunos) throws Exception
       {
              try
              {
                     conex = new Conexao();
                     Statement stm = conex.conectar().createStatement();

                     ResultSet rs = stm.executeQuery("p_aluno_selectall");
                     while (rs.next())
                     {
                        Aluno_VO alunoVO = new Aluno_VO();
                        alunoVO.setNome(rs.getString("NOME"));
                        alunoVO.setCpf(rs.getString("CPF"));
                        alunoVO.setSenha(rs.getString("SENHA"));
                        alunoVO.setPk_grr(rs.getString("PK_GRR"));
                        Alunos.add(alunoVO);
                     }
                     return true;
              }
              catch (SQLException e)
              {
                     throw new Exception("Falha na busca de gerente:\n"+e.getMessage());
              }
       }
}
