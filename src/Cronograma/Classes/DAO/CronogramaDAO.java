/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronograma.Classes.DAO;

import Classes.conexao.UtilDAO.UtilDAO1;
import Cronograma.Classes.Modelagem.Cronograma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wesley
 */

public class CronogramaDAO {
    
    
    //eh mais facil criar um metodo que recebe os dois valores da Matriz
    
    public String trazTurmasPirmeiroDiaHorario(String dia_semana1, String horario1/*, String dia_semana2, String horario2*/){
       //esse metodo vai receber os indices desejados pelo ser humano
       
       //pode-se usar esse mesmo metodo para buscar as turmas pelo segundo dia e horario. 
       //Basta colocar "null" como valores nos locais omitidos.
       
        Cronograma c = new Cronograma();
        /*Vamos precisar de uma matriz que preecnhe um objeto com os valores do banco de dados
        com base na hora e no dia da semana(caso nao haja dois ou caso haja).
        
        Esses dados sao os nomes das turmas. Que sera usado para preencher um cronograma semanal da escola.
        
        entao, deve-se retornar uma String, que eh o nome da turma, que sera usada para preencher a
        celula especifica em que ha os dados de dia e nome inseridos no banco.
        
        Desta maneira, quando o usuario quiser chamar alguma turma especifica, ele apenas coloca os indices
        desejados e usa o metodo criado. O metodo vai retornar o nome da turma.
        */
        
        /*Com os dados abaixo, conseguimos trazer as turmas desejadas com base nos campos de dia e horario*/
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            String sql = "select div_turma.nome_turma from div_turma where div_turma.dia_semana=? and div_turma.horario_dia =?";
            
            
            
            con = UtilDAO1.conexao();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, dia_semana1);
            stm.setString(2, horario1);
            /*stm.setString(3, dia_semana2);
            stm.setString(4, horario2);*/
            
            ResultSet rs = stm.executeQuery();
            
            //String  turmaEspecifica[][] = new String[6][14];
          
            //turmaEspecifica[valorLinha][valorColuna] = "dado";
            
            
            while(rs.next()){
                
               c.setNomeTurma(rs.getString("NOME_TURMA"));
               
            }
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return c.getNomeTurma();
        
    }
    
    public String trazTurmasSegundoDieSemanaHorario( String dia_semana2, String horario2){

        Cronograma c = new Cronograma();
        
        Connection con = null;
        PreparedStatement stm = null;
       
        try{
            String sql = "select div_turma.nome_turma from div_turma where div_turma.SegundoDia_semana=? and div_turma.SegundoHorario_dia =?";
            
            //TEMOS QUE CONSERTAR 
            
            con = UtilDAO1.conexao();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, dia_semana2);
            stm.setString(2, horario2);
            
            ResultSet rs = stm.executeQuery();
             
            while(rs.next()){
                
               c.setNomeTurma(rs.getString("NOME_TURMA"));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return c.getNomeTurma();
        
    }
    
    public String trazTurmasBaseQuatro(String dia_semana1, String horario1, String dia_semana2, String horario2){
       //esse metodo vai receber os indices desejados pelo ser humano
       
       //pode-se usar esse mesmo metodo para buscar as turmas pelo segundo dia e horario. 
       //Basta colocar "null" como valores nos locais omitidos.
       
        Cronograma c = new Cronograma();
        /*Vamos precisar de uma matriz que preecnhe um objeto com os valores do banco de dados
        com base na hora e no dia da semana(caso nao haja dois ou caso haja).
        
        Esses dados sao os nomes das turmas. Que sera usado para preencher um cronograma semanal da escola.
        
        entao, deve-se retornar uma String, que eh o nome da turma, que sera usada para preencher a
        celula especifica em que ha os dados de dia e nome inseridos no banco.
        
        Desta maneira, quando o usuario quiser chamar alguma turma especifica, ele apenas coloca os indices
        desejados e usa o metodo criado. O metodo vai retornar o nome da turma.
        */
        
        /*Com os dados abaixo, conseguimos trazer as turmas desejadas com base nos campos de dia e horario*/
        
        Connection con = null;
        PreparedStatement stm = null;
        String sql = null;
        
        try{

            if(dia_semana1 != null && horario1 != null){
                
                sql = "select * from div_turma where div_turma.dia_semana = ? and div_turma.horario_dia = ? ";
                
            }else if(dia_semana1 == null && horario1 == null){
                
                sql = "select * from div_turma where div_turma.SegundoDia_semana = ? and div_turma.SegundoHorario_dia = ?";
                
            }
            
            con = UtilDAO1.conexao();
            stm = con.prepareStatement(sql);
            
            if(dia_semana1 != null && horario1 != null){
                
            stm.setString(1, dia_semana1);
            stm.setString(2, horario1);
            
            }else if(dia_semana1 == null && horario1 == null){
                
            stm.setString(1, dia_semana2);
            stm.setString(2, horario2);
            
            }
            
            ResultSet rs = stm.executeQuery();
           
            while(rs.next()){
                
               c.setNomeTurma(rs.getString("NOME_TURMA"));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return c.getNomeTurma();
        
    }
    
    
    public String trazTurmasArraList(String dia_semana1, String horario1){
        Cronograma c = new Cronograma();

        Connection con = null;
        PreparedStatement stm = null;
        String sql = null;
        
        /*vamos tentar colocar todas as turmas numa ArrayList e tentar preenchê-la
        e depois vamos colocar os dados na tabela/cronograma*/

        return c.getNomeTurma();
        
    }
    
    public void insert(Cronograma c){
        Connection con = null;
        PreparedStatement stm = null;
        
        String sql = "INSERT INTO ADD_CONTEUDO VALUES (DEFAULT,?)";

        
        try{
            
			con = UtilDAO1.conexao();
			stm = con.prepareStatement(sql);

			stm.setString(1, c.getCaminho_dado());
			
                        
			stm.execute();
			stm.close();
                        JOptionPane.showMessageDialog(null,"conteudos inseridos com sucesso.");
			con.close();
			
		}catch (SQLException e){
			e.printStackTrace();
                         JOptionPane.showMessageDialog(null,"Conteudo não adicionado. Verifique a conexão com o banco.");
		}
        
    }
     
    public void update(Cronograma c){
        Connection con = null;
		
		try{
			PreparedStatement ps = null;
			String sql = "UPDATE ADD_CONTEUDO SET CAMINHO_DADO=?";
			con = UtilDAO1.conexao();
			ps = con.prepareStatement(sql);
			
                        ps.setString(1, c.getCaminho_dado());
			
                        
                      
			
                        
			ps.executeUpdate();
			
			ps.close();
			JOptionPane.showMessageDialog(null,"conteudos alterados com sucesso");
			con.close();
		
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar dados dos conteudos" );
			ex.printStackTrace();
		}
    }
    
    public void delete(Cronograma c){
        
        Connection con = null;
		
		try{
			PreparedStatement ps = null;
			String sql = "DELETE FROM ADD_CONTEUDO WHERE CAMINHO_DADO=?";
			con = UtilDAO1.conexao();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, c.getCaminho_dado());
			
                        
			ps.execute();
			
			ps.close();
                    JOptionPane.showMessageDialog(null,"dados deletados com sucesso");		
                    
                    con.close();
		
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar conteudo" );
			ex.printStackTrace();
                }
    }
    
}


