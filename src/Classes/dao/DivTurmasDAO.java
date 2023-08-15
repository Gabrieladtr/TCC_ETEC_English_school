/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.dao;
import br.gov.sp.etec.dao.UtilDAO;
import Classes.gui.AtualizarTurmasGUI;
import Classes.modelagem.DivTurmas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Rocha
 */
public class DivTurmasDAO {
 
    //se precisar de novos metodos, crie.
    
    //DivTurmasDAO dao = new DivTurmasDAO();
    
    AtualizarTurmasGUI atg = new AtualizarTurmasGUI();
    
    public void insertCriaTurma(DivTurmas d){    
        try{  
                        Connection con;
                        PreparedStatement stm;
                        String sql = "INSERT INTO DIV_TURMA VALUES (DEFAULT,?,?,?,?,NULL,NULL)";
                        //PODE DAR ERRO QUANTO AO DEFAULT. NAO DEU.
			con = UtilDAO.conectar();
			stm = con.prepareStatement(sql);
			
			stm.setString(1, d.getNome_turma());
			stm.setString(2, d.getDia_semana());
			stm.setTime(3, d.getHorario_dia() );
			stm.setString(4, d.getModalidade());
			
			stm.execute();
			stm.close();
                        JOptionPane.showMessageDialog(null,"Dados salvos.");
			con.close();
			
		}catch (SQLException e){
			e.printStackTrace();
                         JOptionPane.showMessageDialog(null,"Dados não salvos. Verifique a conexão com o banco.");
		}
        
    }
    //serve para criar uma turma. 
    //esta funcionado    
    
    public DivTurmas Select2(DivTurmas d,String nomeTurma){
    
        //esse metodo sera usado para buscar todos os dados do banco/div_turma. 
        //todos os dados trazidos serao usados.
        
        //Se houvesse um inner join aqui, poderiamos preencher o nome do prof/aluno. 
        //Assim, poderiamos usar na estrutura e usar no jTextField...
        
        Connection con = null;
        
        try{
            
            String sql = "SELECT * FROM DIV_TURMA WHERE NOME_TURMA = ?";
            
            PreparedStatement ps = null;
            con = UtilDAO.conectar();
            ps = con.prepareStatement(sql);
            
            //String nomeTurma = JOptionPane.showInputDialog(null,"Escreva o nome da turma desejada");
            
            ps.setString(1, nomeTurma);
            
            ResultSet rs = ps.executeQuery();
            
            
            
            if(rs.next()){
                d.setNome_turma(rs.getString("NOME_TURMA"));
                d.setDia_semana(rs.getString("DIA_SEMANA"));
                d.setHorario_dia(rs.getTime("HORARIO_DIA"));
                d.setModalidade(rs.getString("MODALIDADE"));
                d.setFk_prof_rp(rs.getInt("FK_PROF_RP"));
                d.setFk_aluno_ra(rs.getInt("FK_ALUNO_RA"));
            }
            
            rs.close();	
            ps.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        return null;
    }
    //funcionado - puxa apenas dados da estrutura
    public DivTurmas Select(DivTurmas d,String nomeTurma){        
        Connection con = null;
        try{                       
            String sql = null;
            
            sql = "SELECT * FROM DIV_TURMA "
                        + "INNER JOIN CADASTRO_PROF ON (DIV_TURMA.FK_PROF_RP = CADASTRO_PROF.RP)"
                        + "WHERE NOME_TURMA = ?";
            /*A string sql acima, só puxara turmas se elas estiverem atrelados com professores.*/
                                    
            
            PreparedStatement ps = null;
            con = UtilDAO.conectar();
            ps = con.prepareStatement(sql);                        
            
            ps.setString(1, nomeTurma);
            
            ResultSet rs = ps.executeQuery();            
                        
            if(rs.next()){
                d.setNome_turma(rs.getString("DIV_TURMA.NOME_TURMA"));
                d.setDia_semana(rs.getString("DIV_TURMA.DIA_SEMANA"));
                d.setHorario_dia(rs.getTime("DIV_TURMA.HORARIO_DIA"));
                d.setModalidade(rs.getString("DIV_TURMA.MODALIDADE"));
                d.setFk_prof_rp(rs.getInt("DIV_TURMA.FK_PROF_RP"));
                d.setFk_aluno_ra(rs.getInt("DIV_TURMA.FK_ALUNO_RA"));
                d.setNomeProfessor(rs.getString("CADASTRO_PROF.NOME"));
                d.setSobrenomeProf(rs.getString("CADASTRO_PROF.SOBRENOME"));
            }
            
            rs.close();	
            ps.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        return null;
    }
    //esta funcionando - puxa apenas turmas atreladas a professores
    public boolean verificaProfessorEmTurmas(DivTurmas d, String nomeTurma){
    
         /*Esse metodo verificara se uma turma possui professor.
           Metodo que vê se a turma possui professor.	*/
        
         Connection con = null;
         boolean valorRetorno = false;
         
         try{
             
             PreparedStatement stm = null;
             String sql = "SELECT * FROM DIV_TURMA "
                        + "INNER JOIN CADASTRO_PROF ON (DIV_TURMA.FK_PROF_RP = CADASTRO_PROF.RP)"
                     + "   WHERE NOME_TURMA = ?";
             con = UtilDAO.conectar();
             stm = con.prepareStatement(sql);
             
             d.setNome_turma(nomeTurma);
             stm.setString(1, d.getNome_turma());
             
             ResultSet rs = stm.executeQuery();
             
             if(rs.next()){
                 d.setRp_prof(rs.getInt("CADASTRO_PROF.RP"));
                 d.setFk_prof_rp(rs.getInt("DIV_TURMA.FK_PROF_RP"));            
                 
                  if(d.getRp_prof() != 0 && d.getFk_prof_rp() != 0 && d.getFk_prof_rp() == d.getRp_prof()){
                    valorRetorno = true;
                 }else{
                      valorRetorno = false;
                  }
             }
                 
                 
             
             
            

         } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(valorRetorno);
        
        return valorRetorno;
    }
    //verifica se a turma possui professor
    public boolean verificaAlunosEmTurmas(DivTurmas d, String nomeTurma){
        
        boolean valorRetorno = false;
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            String sql = "SELECT * FROM DIV_TURMA INNER JOIN CAD_ALUNO ON (DIV_TURMA.FK_ALUNO_RA = CAD_ALUNO.RA) WHERE DIV_TURMA.NOME_TURMA = ?";
            
            d.setNome_turma(nomeTurma);
            con = UtilDAO.conectar();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, nomeTurma);
            
            ResultSet rs = stm.executeQuery();
            
            
            if(rs.next()){
                d.setFk_aluno_ra(rs.getInt("DIV_TURMA.FK_ALUNO_RA"));
                d.setRa_verifica(rs.getInt("CAD_ALUNO.RA"));
                
                if(d.getFk_aluno_ra() != 0 && d.getRa_verifica() != 0 && d.getRa_verifica() == d.getFk_aluno_ra()){
                    valorRetorno = true;
                }else{
                    valorRetorno = false;
                }
                
                
            }
            
            
            
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println(valorRetorno);
        return true;
    }
    //verifica se a turma possui alunos
    public void verificaEspacoTurma(DivTurmas d){
        String nomeTurma;
        try{
            String sql = "SELECT * FROM DIV_TURMA \n" +
                            "INNER JOIN CADASTRO_PROF\n" +
                            "ON (DIV_TURMA.FK_PROF_RP = CADASTRO_PROF.RP) WHERE cadastro_prof.rp = ?";
            
            AtualizarTurmasGUI atg = new AtualizarTurmasGUI();            
            nomeTurma = atg.getRetornoComboBoxAlunoSemTurma();
            
            Connection con = null;            
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            stm = con.prepareStatement(sql);
            
            
            
            
            String rpProf = JOptionPane.showInputDialog(null,"Digite o rp do professor");
            int rpProf2 = Integer.parseInt(rpProf);
            stm.setInt(1, rpProf2);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                d.setNome_turma(rs.getString("DIV_TURMA.NOME_TURMA"));
                d.setRp_prof(rs.getInt("CADASTRO_PROF.RP"));
            }
            
            
            if(d.getNome_turma() != null){
                JOptionPane.showMessageDialog(null,"O nome da turma é: " + d.getNome_turma() + ". O RA do aluno é:" + d.getRp_prof());
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void update(DivTurmas d,String nomeTurma){
        
                        Connection con = null;
		try{
			PreparedStatement ps = null;
                        
			String sql = "UPDATE DIV_TURMA SET NOME_TURMA=?,"
                                + " DIA_SEMANA=?, HORARIO_DIA=?, MODALIDADE=?, "
                                + " FK_ALUNO_RA=?, FK_PROF_RP=? WHERE NOME_TURMA=? ";
                        
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			
                        ps.setString(1, d.getNome_turma());
			ps.setString(2, d.getDia_semana());
			ps.setTime(3, d.getHorario_dia() );
			ps.setString(4, d.getModalidade());
                        ps.setInt(5, d.getFk_prof_rp());
                        ps.setInt(6, d.getFk_aluno_ra());
                        
                        ps.setString(7, nomeTurma);
			
                        ps.executeUpdate();
                        
                        
			
			
			ps.close();
			con.close();
                        
                        JOptionPane.showMessageDialog(null,"dados alterados com sucesso");
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar dados. " );
			ex.printStackTrace();
		}
    }
    //atualiza     
    public void update2(DivTurmas d, String nomeTurma){
                        
                        Connection con = null;
		try{
			PreparedStatement ps = null;
			String sql = "UPDATE DIV_TURMA SET FK_ALUNO_RP=?, FK_PROF_RA=? WHERE NOME_TURMA=? "; 
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);

                        ps.setInt(1, d.getFk_prof_rp());
                        ps.setInt(2, d.getFk_aluno_ra());
                        ps.setString(3, nomeTurma);
			
                        ps.executeUpdate();

			ps.close();
			con.close();
                        
                        JOptionPane.showMessageDialog(null,"dados alterados com sucesso");
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar dados. " );
			ex.printStackTrace();
		}
        
    }
    //ATUALIZAR ESSE CODIGO
    public void delete(DivTurmas d,String nomeTurma){
        
        Connection con = null;
		
		try{
			PreparedStatement ps = null;
			String sql = "DELETE FROM DIV_TURMA WHERE NOME_TURMA=?";
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nomeTurma);
			
			ps.execute();
			
			ps.close();
                    JOptionPane.showMessageDialog(null,"dados deletados com sucesso");			con.close();
		
			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar dados de tabela contato" );
			ex.printStackTrace();
		}
        
    }
    //deleta
    public String verificaEstado(DivTurmas div,String nomeTurma){
        /*esse metodo deve retornar o estado da classe.
		
		O metodo deve pegar o nome da turma, trazer os dados do banco
		e verificar se ha um professor e/ou aluno na turma. Dependendo
		do estado em que estiver a turma, o retorno deve ser adequado.
		
		Eh simples o o bjetivo deste metodo.
		*/

		/*Variaveis*/
		
		String retorno = "";
		
		Connection con = null;
        try{       
            String sql = "SELECT * FROM DIV_TURMA WHERE NOME_TURMA = ?"; 
            PreparedStatement ps = null;
            con = UtilDAO.conectar();
            ps = con.prepareStatement(sql);
			
            ps.setString(1, nomeTurma);            
            ResultSet rs = ps.executeQuery();                                  
			
            if(rs.next()){
                div.setNome_turma(rs.getString("NOME_TURMA"));
                div.setDia_semana(rs.getString("DIA_SEMANA"));
                div.setHorario_dia(rs.getTime("HORARIO_DIA"));
                div.setModalidade(rs.getString("MODALIDADE"));
                div.setFk_prof_rp(rs.getInt("FK_PROF_RP"));
                div.setFk_aluno_ra(rs.getInt("FK_ALUNO_RA"));
                
            }
			/*Se existir dados no campo ra e/ou rp diferentes de 0, 
			entao ha uma relacao entre turma e/ou cadastro_prof e aluno.
			*/
			
			/*A busca dos nomes/rp's dos professes/alunos, devera ser feita depois.
			Nao se preocupar com isso.*/
			
			if(div.getFk_prof_rp() != 0){
				retorno += "yesProf_";
			}else{
				retorno += "notProf_";
			}
			
			
			if(div.getFk_aluno_ra() != 0){
				retorno += "yesAluno";
			}else{
				retorno += "notAluno";
			}
			/*
                        opcoes possiveis:
                        
                        yesProf_yesAluno
                        yesProf_notAluno
                        notProf_yesAluno
                        notProf_notAluno
                        */
            rs.close();	
            ps.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }                
        
		System.out.println(retorno);
		
		return retorno;
                
    }
    //Esta funcionando
    //conseguimos buscar certo.
   
    public int retornaRPcadastrado(DivTurmas d, String nomeTurma){
        /*Sendo assim, precisamos de um metodo que retorne o professor cadastrado, com base no
        nome da turma. Ou seja, pegamos o nome da turma e retornamos um int, que significa
        o professor da cadastrado naquela turma. Depois, so cadastramos.*/
    
            Connection con = null;
        try{
            String sql = "SELECT *  FROM CADASTRO_PROF INNER JOIN DIV_TURMA ON (CADASTRO_PROF.RP = DIV_TURMA.FK_PROF_RP) WHERE DIV_TURMA.NOME_TURMA = ?";      
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            stm = con.prepareStatement(sql);      
            stm.setString(1, nomeTurma);       
            ResultSet rs = stm.executeQuery();       
            if(rs.next()){
                d.setFk_prof_rp(rs.getInt("CADASTRO_PROF.RP"));
            }
            rs.close();	
            stm.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    System.out.println(d.getFk_prof_rp());   
    return d.getFk_prof_rp();
    }
    
    
    
}
