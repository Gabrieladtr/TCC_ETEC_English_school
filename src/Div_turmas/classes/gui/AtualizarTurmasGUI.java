/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Div_turmas.classes.gui;

import Div_turmas.classes.dao.DivTurmasDAO;
import br.gov.sp.etec.dao.UtilDAO;
import Div_turmas.classes.modelagem.DivTurmas;
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
public class AtualizarTurmasGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form TesteFormAtualizaTurma
     */
    public AtualizarTurmasGUI() {
        initComponents();
        //this.PopulaComboBox();
        this.populaComboBox2();
        this.populaComboBoxTodosOsProfessor();
        this.populaComboBoxAlunoSemTurma();
        jComboBox4_add_prof_atualiza.setSelectedItem(null);
        jComboBox5_add_aluno_atualiza.setSelectedItem(null);
        jComboBox6_escolha_turma.setSelectedItem(null);
    }

     String horarioGlobal;
     String retornoComboBoxAlunoSemTurma; 

    public String getRetornoComboBoxAlunoSemTurma() {
        return retornoComboBoxAlunoSemTurma;
    }

    public void setRetornoComboBoxAlunoSemTurma(String retornoComboBoxAlunoSemTurma) {
        this.retornoComboBoxAlunoSemTurma = retornoComboBoxAlunoSemTurma;
    }
     
     //METODO QUE REMOVE TODOS OS ITENS DA COMBOBOX
    public void removeItemComboBox(){
        //esse metodo popula a comboBox de turmas para busca de dados, no formulario de atualizacao.
        
        String sql = "SELECT DISTINCT NOME_TURMA FROM DIV_TURMA ORDER BY NOME_TURMA";
        
        try{
            Connection con = null;      
            con = UtilDAO.conectar();
            PreparedStatement stm = null;
            //ResultSet rs = ps.executeQuery();
            
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            
            
            
            while(rs.next()){
                jComboBox6_escolha_turma.removeItem(rs.getString("NOME_TURMA"));
            }
            
            
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }
        
    }
     
    public void removeItemComboBoxAlunos(){
        //esse metodo popula a comboBox de turmas para busca de dados, no formulario de atualizacao.
        
        String sql = "SELECT CAD_ALUNO.NOME FROM CAD_ALUNO WHERE CAD_ALUNO.RA\n" +
                            "NOT IN\n" +
                                "(SELECT DIV_TURMA.FK_ALUNO_RA FROM DIV_TURMA WHERE DIV_TURMA.FK_ALUNO_RA)";
        
        try{
            Connection con = null;      
            con = UtilDAO.conectar();
            PreparedStatement stm = null;
            //ResultSet rs = ps.executeQuery();
            
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            
            
            
            while(rs.next()){
                jComboBox5_add_aluno_atualiza.removeItem(rs.getString("CAD_ALUNO.NOME"));
            }
            
            
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }
        
    }
    
    //metodo que popula a comboBox
    
    public void populaComboBox2(){
        //esse metodo popula a comboBox de turmas para busca de dados, no formulario de atualizacao.
        
        String sql = "SELECT DISTINCT NOME_TURMA FROM DIV_TURMA ORDER BY NOME_TURMA";
        
        try{
            Connection con = null;      
            con = UtilDAO.conectar();
            PreparedStatement stm = null;
            //ResultSet rs = ps.executeQuery();
            
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            
            
            
            while(rs.next()){
                jComboBox6_escolha_turma.addItem(rs.getString("NOME_TURMA"));
            }
            
            
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }
        
    }
    
    public void populaComboBoxTodosOsProfessor(){
        DivTurmas d = new DivTurmas();
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = UtilDAO.conectar();
            String sql = "SELECT * FROM CADASTRO_PROF";     
            stm = con.prepareStatement(sql);    
            ResultSet rs = stm.executeQuery();  
            while(rs.next()){
                jComboBox4_add_prof_atualiza.addItem(rs.getString("CADASTRO_PROF.NOME" ));         
            }

        } catch (SQLException ex) {
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void populaComboBoxAlunoSemTurma(){
    
        Connection con = null;
        
        try{
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "SELECT CAD_ALUNO.NOME FROM CAD_ALUNO WHERE CAD_ALUNO.RA\n" +
                            "NOT IN\n" +
                                "(SELECT DIV_TURMA.FK_ALUNO_RA FROM DIV_TURMA WHERE DIV_TURMA.FK_ALUNO_RA)";
            
            stm = con.prepareStatement(sql);            
            ResultSet rs = stm.executeQuery();                       
            while(rs.next()){
                
                jComboBox5_add_aluno_atualiza.addItem(rs.getString("CAD_ALUNO.NOME"));
            }
            
            rs.close();	
            stm.close();
            con.close();
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void trasDadosParaAComboBox(String nomeTurma){
        //Esse metodo sera usado para puxar os dados do banco nas comboBoxs
        //As comboBox do formulario de atualizacao, na area de "estrutura da turma"
        
        //EH BEM PROVAVEL QUE NAO USAREI ESSE METODO...
            
            //vamos popular as seguintes comboBox:
            jComboBox1_dia_semana_atualiza.addItem("");

            //jComboBox2_horario_turma_atualiza.addItem("");

            jComboBox3_modalidade_atualiza.addItem("");
            
            
        try {
            Connection con;
            con = UtilDAO.conectar();
            PreparedStatement stm = null;
            
            String sql = "SELECT DISTINCT DIA_SEMANA, HORARIO_DIA, MODALIDADE FROM DIV_TURMA WHERE NOME_TURMA = ?";
            //Select  distinct DIA_SEMANA, horario_dia, modalidade from div_turma where nome_turma = "Turma A";
            
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            stm.setString(1, nomeTurma);
            
            /*
            
            Connection con = null;
            con = UtilDAO.conexao();
            PreparedStatement stm = null;
            
            //ResultSet rs = ps.executeQuery();
            
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();*/
            
            while(rs.next()){
                //jComboBox6_escolha_turma.addItem(rs.getString("NOME_TURMA"));
                
                jComboBox1_dia_semana_atualiza.addItem(rs.getString("DIA_SEMANA"));
                //jComboBox2_horario_turma_atualiza.addItem(rs.getString("HORARIO_DIA"));
                jComboBox3_modalidade_atualiza.addItem(rs.getString("MODALIDADE"));
                
            }
            
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                /*
                jComboBoxCliente.addItem("");
                Connection conn;  
                conn = conexaoBD.getConexao();//classse de conexao com banco
                Statement st = conn.createStatement();  
                ResultSet rs = st.executeQuery("SELECT cliente.nome FROM cliente ORDER BY nome" );  
                */
        
    }

    
    
    
    //metodo que pega um professor e retorna o seu RP:
    public int retornaRPdeAlgumProfessor(DivTurmas d, String nomeProfessor){
        
        Connection con = null;
        
        try{
            String sql = "SELECT CADASTRO_PROF.RP FROM CADASTRO_PROF WHERE CADASTRO_PROF.NOME = ?";
            con = UtilDAO.conectar();
            PreparedStatement stm = null;
            
            stm = con.prepareStatement(sql);
            
            stm.setString(1, nomeProfessor);

            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                d.setFk_prof_rp(rs.getInt("CADASTRO_PROF.RP"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(d.getFk_prof_rp());
        return d.getFk_prof_rp();
    }
    
    //metodo que pega um aluno e retorna o seu RA:
    public int retornaRA(DivTurmas d, String nomeAluno){
        
        Connection con = null;
        
        try{
        
            con = UtilDAO.conectar();
            PreparedStatement stm = null;
            String sql = "SELECT CAD_ALUNO.RA FROM CAD_ALUNO WHERE CAD_ALUNO.NOME = ?";
            
            stm = con.prepareStatement(sql);
            
            stm.setString(1, nomeAluno);
            
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                d.setFk_aluno_ra(rs.getInt("CAD_ALUNO.RA"));
            }
            
            
        
        
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(d.getFk_aluno_ra());
        
        return d.getFk_aluno_ra();
    }
    
    //metodo que retorna o RP do professor cadastrado com base no nome da turma
    public int retornaRPcadastradoEmAlgumaTurma(DivTurmas d, String nomeProf){
        //Sendo assim, precisamos de um metodo que retorne o professor cadastrado, com base no
        //nome0 da turma. Ou seja, pegamos o nome da turma e retornamos um int, que significa
        //o professor da cadastrado naquela turma. Depois, so cadastramos.
    
        
        try{
            Connection con;
            PreparedStatement stm;
            con = UtilDAO.conectar();
            String sql = "SELECT *  FROM CADASTRO_PROF WHERE CADASTRO_PROF.NOME = ?";
           /*+ "INNER JOIN DIV_TURMA ON (CADASTRO_PROF.RP = DIV_TURMA.FK_PROF_RP) WHERE DIV_TURMA.NOME_TURMA = ?";*/
           
            stm = con.prepareStatement(sql);
            
            stm.setString(1, nomeProf);
            
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
    
    //Metodo que converte rp para nome.
    public String retornaNomePorRP(DivTurmas d, String nomeTurma){
    
        
        
        Connection con = null;
        try{
            PreparedStatement stm = null;
            String sql = "SELECT *  FROM CADASTRO_PROF INNER JOIN DIV_TURMA ON (CADASTRO_PROF.RP = DIV_TURMA.FK_PROF_RP) WHERE DIV_TURMA.NOME_TURMA = ?";
            con = UtilDAO.conectar();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, nomeTurma);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                d.setNomeProfessor(rs.getString("CADASTRO_PROF.NOME"));
                d.setFk_prof_rp(rs.getInt("CADASTRO_PROF.RP"));
            }
        
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return d.getNomeProfessor();
    }
    
    //metodo que escolhe a query correta para a atualizacao da turma
    
    public void insertQuerysCorretasTurmas(DivTurmas d, String nomeTurmaSelecionada){

	Connection con = null;

	try{
	
	DivTurmasDAO dao = new DivTurmasDAO();
	//DivTurmas d = new DivTurmas();
	
	con = UtilDAO.conectar();
	PreparedStatement stm = null;
	String sql;
	String nomeTurma = nomeTurmaSelecionada;
	
	//depois disso, a unica coisa que vamos precisar eh do trecho sql, 
	
	if(dao.verificaEstado(d, nomeTurma).equals("notProf_notAluno")){
		
		
                //-----------------------------------------PRIMEIRA PARTE DO SUPER IF------------------------------------------------------------------------
				
				
					
                //JOptionPane.showMessageDialog(null, "test3");   
                //caso nao haja professor nem aluno na turma
    
                /*------------------novo codigo------------------*/
                dao.Select2(d, nomeTurma);
                
                String selecaoProf, selecaoAluno;
                
                selecaoProf = String.valueOf(jComboBox4_add_prof_atualiza.getSelectedItem());
                selecaoAluno = String.valueOf(jComboBox5_add_aluno_atualiza.getSelectedItem());
                //Colocar os valores buscados dentro de uma variavel do tipo String, pode adulterar o dado.
                
                    //jComboBox4_add_prof_atualiza.getSelectedItem()                
                    //jComboBox5_add_aluno_atualiza.getSelectedItem()
                
                if(jComboBox4_add_prof_atualiza.getSelectedItem() != null){
	
						if(jComboBox5_add_aluno_atualiza.getSelectedItem() != null){
			
						sql = "UPDATE DIV_TURMA SET FK_PROF_RP=?, FK_ALUNO_RA=? WHERE NOME_TURMA=?";
						stm = con.prepareStatement(sql);
						
						//acho que devemos avisar das possiblidades para o prof - nesta parte;
						int rpProfessorSelecionado = this.retornaRPdeAlgumProfessor(d, String.valueOf(jComboBox4_add_prof_atualiza.getSelectedItem()));
						d.setFk_prof_rp(rpProfessorSelecionado);
						stm.setInt(1, d.getFk_prof_rp());  
						
						int raAlunoSelecionado1 = this.retornaRA(d, String.valueOf(jComboBox5_add_aluno_atualiza.getSelectedItem()));
						d.setRa_aluno1(raAlunoSelecionado1);
						stm.setInt(2, d.getRa_aluno1());
						
						stm.setString(3, nomeTurma);
						stm.execute();
						stm.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Professor e aluno inseridos com sucesso em turma que nao possuia os dois itens.");
			
					}else{
			
						//JOptionPane.showMessageDialog(null, "Chegamos no if - proYes");
						sql = "UPDATE DIV_TURMA SET FK_PROF_RP = ? WHERE NOME_TURMA = ?";
						
						
						dao.Select2(d, nomeTurma);
						stm = con.prepareStatement(sql);

						int rpProfessorSelecionado = this.retornaRPdeAlgumProfessor(d, selecaoProf);
						//JOptionPane.showMessageDialog(null, "O valor do rp do professor informado: " + rpProfessorSelecionado);
						d.setFk_prof_rp(rpProfessorSelecionado);
						stm.setInt(1, d.getFk_prof_rp());

						stm.setString(2, nomeTurma);

						stm.execute();
						stm.close();
						con.close();

						JOptionPane.showMessageDialog(null,"O professor inserido em turma sem professor e sem aluno.");
			
					}

				}else if(jComboBox5_add_aluno_atualiza.getSelectedItem() != null){
	
				sql = "UPDATE DIV_TURMA SET FK_ALUNO_RA=? WHERE NOME_TURMA=?";
				dao.Select2(d, nomeTurma);
				stm = con.prepareStatement(sql);

				int alunoRA = this.retornaRA(d, String.valueOf(jComboBox5_add_aluno_atualiza.getSelectedItem()));
				d.setFk_aluno_ra(alunoRA);
				stm.setInt(1, d.getFk_aluno_ra());

				stm.setString(2, nomeTurma);

				stm.execute();
				stm.close();
				con.close();

				JOptionPane.showMessageDialog(null,"Aluno inserido em turma sem professor ou aluno.");
	
	
	
					}else{
						JOptionPane.showMessageDialog(null,"Escolha um professor ou um aluno para prosseguir.");
					}
				
            }else if(dao.verificaEstado(d, nomeTurma).equals("yesProf_yesAluno")){
				
				
	//-------------------------------------------------------SEGUNDA PARTE DO SUPER IF-------------------------------------------------------------------------------
				
				    //Caso ja haja aluno e professor nesta turma
                    
                    //deve haver um if, quanto a escolha do usuario. Aqui, igual ao ultimo techo deste if.
                    
					//O PROBLEMA: O MESMO ALUNO EH INSERIDO VARIAS VEZES NA MESMA TURMA.
					
					//se a turma ja possuir prof, entao ela so podera adicionar aluno. 
					//entao, aqui, so adicionaremos alunos em turmas que ja possuem alunos e um professor.
					
					//O professor deve ser clonado, os aluno nao. Em cada insert, o aluno deve ser diferente.
								
					
                 //aqui!
                
                sql = "INSERT INTO DIV_TURMA VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
                
                dao.Select2(d, nomeTurma);
                
                stm = con.prepareStatement(sql);
                
                stm.setString(1,d.getNome_turma());
                stm.setString(2, d.getDia_semana());
                stm.setTime(3, d.getHorario_dia());
                stm.setString(4, d.getModalidade());
                
                d.setSegudoDia_semana(String.valueOf(jComboBox1_dia_semana_atualiza2.getSelectedItem()));
                stm.setString(5, d.getSegudoDia_semana());
                
                if(jTextField2_horario_turma_atualiza2.getText() == null){
                    d.setSegundoHorario_dia(null);
                    
                }else{
                    
                    try {
                        d.setSegundoHorario_dia(d.formatarHora(jTextField2_horario_turma_atualiza2.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                stm.setTime(6, d.getSegundoHorario_dia());
                
				//Ate aqui, ok.
				
                //problema avistado:
                //Devemos ter alguns metodos aqui...
				
                //um para RP e outro para RA.
                
                int rpProfessorCadastrado = dao.retornaRPcadastrado(d, nomeTurma);
                
                d.setFk_prof_rp(rpProfessorCadastrado);
                stm.setInt(7, d.getFk_prof_rp());
                /*Vai retornar o rp do professor que esta cadastrado nesta mesma turma*/
				
                int alunoRA = this.retornaRA(d, String.valueOf(jComboBox5_add_aluno_atualiza.getSelectedItem()));
                d.setFk_aluno_ra(alunoRA);
                stm.setInt(8, d.getFk_aluno_ra());
                /*Retorna o ra do aluno selecionado e inserimos ele na turma.*/
				
				
                stm.execute();
                stm.close();
                JOptionPane.showMessageDialog(null,"Foi inserido um novo aluno nesta mesma turma.");  
                con.close();
				
                    }else if(dao.verificaEstado(d, nomeTurma).equals("yesProf_notAluno")){
                   
				   
	//--------------------------------------------------------TERCEIRA PARTE DO SUPER IF-------------------------------------------------------------------------------
				   
				   
                    //caso haja professor e nao haja aluno na turma
                    
                    //deveria haver um if aqui, que trava o comboBox do professor.
                    
                sql = "UPDATE DIV_TURMA SET FK_ALUNO_RA=? WHERE NOME_TURMA=?";
                dao.Select2(d, nomeTurma);
                
                //JOptionPane.showMessageDialog(null,"1 - será inserido um aluno nesta turma. "
                //                               + "yesProf_notAluno  - DEU CERTO MEU REI ");
                
                stm = con.prepareStatement(sql);
                
                int alunoRA = this.retornaRA(d, String.valueOf(jComboBox5_add_aluno_atualiza.getSelectedItem()));
                d.setFk_aluno_ra(alunoRA);
                stm.setInt(1, d.getFk_aluno_ra());
                
                stm.setString(2, nomeTurma);

                stm.execute();
                stm.close();
                con.close();
                
                JOptionPane.showMessageDialog(null,"Foi inserido um aluno nesta turma.");
                
                
            }else if(dao.verificaEstado(d, nomeTurma).equals("notProf_yesAluno")){
                
				
	//--------------------------------------------------------QUARTA PARTE DO SUPER IF--------------------------------------------------------------------------------------
				
				
		//caso nao haja professor mas haja aluno
                
                //JOptionPane.showMessageDialog(null,"2 - Sera inserido um professor nesta turma. "
                //                                    + "notProf_yesAluno - A TURMA TERÁ UM REI");
                
                
                sql = "UPDATE DIV_TURMA SET FK_PROF_RP=? WHERE NOME_TURMA=?";
                dao.Select2(d, nomeTurma);
                stm = con.prepareStatement(sql);
                
                int rpProfessorSelecionado = this.retornaRPdeAlgumProfessor(d, String.valueOf(jComboBox4_add_prof_atualiza.getSelectedItem()));
                d.setFk_prof_rp(rpProfessorSelecionado);
                stm.setInt(1, d.getFk_prof_rp());
                
                stm.setString(2, nomeTurma);

                stm.execute();
                stm.close();
                con.close();
                
                JOptionPane.showMessageDialog(null,"Foi inserido um professor nesta turma.");

                
            }else{
				
//-----------------------------------------------------------------QUINTA PARTE DO SUPER IF----------------------------------------------------------------------------------
				
				JOptionPane.showMessageDialog(null,"Escolha um aluno e/ou professor para prosseguir");
				
			}
			
			
	}catch (SQLException ex) {
            
            Logger.getLogger(DivTurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null,"Verifique o trecho sql usado. ");
        }




    }
DivTurmas d1 = new DivTurmas();    
/*DivTurmas d2 = new DivTurmas();
DivTurmas d3 = new DivTurmas();
DivTurmas d4 = new DivTurmas();
DivTurmas d5 = new DivTurmas();
DivTurmas d6 = new DivTurmas();*/
    

public void preencheTextFieldsComAlunos(DivTurmas d, String nomeTurma){
    /*Nest metodo, nos preenchemos as textFields com os dados dos alunos. 
    Eh simples, vamos apenas preencher as textFields.
    Temos as textFields dos nomes e temos as texFields do rp, de cada aluno.
    Todas deve estar preenchidas.
    A do professor também. Mas, isso, podemos dar um jeito em outra ocasiao.*/
    Connection con;
    try{
         DivTurmasDAO dao = new DivTurmasDAO();
         
         PreparedStatement stm = null;
         con = UtilDAO.conectar();
         /* 
        opcoes possiveis:

        yesProf_yesAluno
        yesProf_notAluno
        notProf_yesAluno
        notProf_notAluno
        */
         
         if(dao.verificaEstado(d, nomeTurma).equals("notProf_notAluno")){  
             //se nao haver nem prof e nem aluno, nao podemos fazer nada. 
             
         }else if(dao.verificaEstado(d, nomeTurma).equals("yesProf_yesAluno")){
             String sql = "SELECT DISTINCT * FROM DIV_TURMA INNER JOIN CADASTRO_PROF ON (DIV_TURMA.FK_PROF_RP = CADASTRO_PROF.RP) "
                        + "INNER JOIN CAD_ALUNO ON (DIV_TURMA.FK_ALUNO_RA = CAD_ALUNO.RA) WHERE DIV_TURMA.NOME_TURMA = ?";
                
                stm = con.prepareStatement(sql);
                //aqui buscamos alunos e professores
                stm.setString(1, nomeTurma);
                ResultSet rs = stm.executeQuery();
                
                    /*while(rs.next()){
                     if(rs.next()){
                    
                    }
                    
                    Se os campos do objeto estiverem fora do if, ele ate mostra todos os alunos. 
                    O problema fica na hora de excluir os dados. Da erro e todos os campos sao excluidos.
                    
                    Se estiver dentro do if, nao mostra ate o ultimo cadastro. 
                    Ele meio que nao mostra os novos cadastros ate o ultimo espaco estiver preenchido, ai,
                    mostra-se todos os alunos cadastrados.
                      
   
                    
                    if(rs.next()){
                     d.setNomeAluno1(rs.getString("CAD_ALUNO.NOME"));
                     d.setRa_aluno1(rs.getInt("CAD_ALUNO.RA"));
                     }
                             
                    if(rs.next()){
                        d.setNomeAluno2(rs.getString("CAD_ALUNO.NOME"));
                        d.setRa_aluno2(rs.getInt("CAD_ALUNO.RA"));    
                    }    
                    
                    if(rs.next()){
                    
                     d.setNomeAluno3(rs.getString("CAD_ALUNO.NOME"));
                     d.setRa_aluno3(rs.getInt("CAD_ALUNO.RA"));
                    }      
                    
                    if( rs.next()){

                               d.setNomeAluno4(rs.getString("CAD_ALUNO.NOME")); 
                               d.setRa_aluno4(rs.getInt("CAD_ALUNO.RA"));
                    }                   
                    if(rs.next()){

                            d.setNomeAluno5(rs.getString("CAD_ALUNO.NOME"));
                            d.setRa_aluno5(rs.getInt("CAD_ALUNO.RA"));
                    }                           
                    if(  rs.next()){

                        d.setNomeAluno6(rs.getString("CAD_ALUNO.NOME"));
                        d.setRa_aluno6(rs.getInt("CAD_ALUNO.RA"));
                    }         
                                                            
                       
                    }*/
                        
                        if(rs.next()){

                        d.setNomeAluno1(rs.getString("CAD_ALUNO.NOME"));
                        d.setRa_aluno1(rs.getInt("CAD_ALUNO.RA"));
                        
                        }  

                        if(rs.next()){
                            d.setNomeAluno2(rs.getString("CAD_ALUNO.NOME"));
                            d.setRa_aluno2(rs.getInt("CAD_ALUNO.RA"));    
                        }    

                        if(rs.next()){

                         d.setNomeAluno3(rs.getString("CAD_ALUNO.NOME"));
                         d.setRa_aluno3(rs.getInt("CAD_ALUNO.RA"));
                        }      

                        if( rs.next()){

                                   d.setNomeAluno4(rs.getString("CAD_ALUNO.NOME")); 
                                   d.setRa_aluno4(rs.getInt("CAD_ALUNO.RA"));
                        }                   
                        if(rs.next()){

                                d.setNomeAluno5(rs.getString("CAD_ALUNO.NOME"));
                                d.setRa_aluno5(rs.getInt("CAD_ALUNO.RA"));
                        }                           
                        if(  rs.next()){

                            d.setNomeAluno6(rs.getString("CAD_ALUNO.NOME"));
                            d.setRa_aluno6(rs.getInt("CAD_ALUNO.RA"));
                        }         

               System.out.println("Aluno 1: " + d.getNomeAluno1() + " e seu RA:"+ d.getRa_aluno1() + "\n"+
                                  "Aluno 2: " + d.getNomeAluno2()+ " e seu RA:"+ d.getRa_aluno2() + "\n"+
                                  "Aluno 3: " + d.getNomeAluno3()+ " e seu RA:"+ d.getRa_aluno3() + "\n"+
                                  "Aluno 4: " + d.getNomeAluno4()+ " e seu RA:"+ d.getRa_aluno4() + "\n"+
                                  "Aluno 5: " + d.getNomeAluno5()+ " e seu RA:"+ d.getRa_aluno5() + "\n"+
                                  "Aluno 6: " + d.getNomeAluno6() + " e seu RA:"+ d.getRa_aluno6());
                rs.close();	
                rs.close();
                con.close();
             
         }else if(dao.verificaEstado(d, nomeTurma).equals("yesProf_notAluno")){
             
                //nesse caso, temos uma outra parte, fora deste metodo que faz isso.
             
             
         }else if(dao.verificaEstado(d, nomeTurma).equals("notProf_yesAluno")){
             
                String sql = "SELECT DISTINCT * FROM DIV_TURMA INNER JOIN CAD_ALUNO ON (DIV_TURMA.FK_ALUNO_RA = CAD_ALUNO.RA) WHERE DIV_TURMA.NOME_TURMA = ?";
                stm = con.prepareStatement(sql);
                //aqui buscamos alunos e professores
                stm.setString(1, nomeTurma);
                
                ResultSet rs = stm.executeQuery();
                
                if(rs.next()){

                        d.setNomeAluno1(rs.getString("CAD_ALUNO.NOME"));
                        d.setRa_aluno1(rs.getInt("CAD_ALUNO.RA"));
                        
                        }  

                        if(rs.next()){
                            d.setNomeAluno2(rs.getString("CAD_ALUNO.NOME"));
                            d.setRa_aluno2(rs.getInt("CAD_ALUNO.RA"));    
                        }    

                        if(rs.next()){

                         d.setNomeAluno3(rs.getString("CAD_ALUNO.NOME"));
                         d.setRa_aluno3(rs.getInt("CAD_ALUNO.RA"));
                        }      

                        if( rs.next()){

                                   d.setNomeAluno4(rs.getString("CAD_ALUNO.NOME")); 
                                   d.setRa_aluno4(rs.getInt("CAD_ALUNO.RA"));
                        }                   
                        if(rs.next()){

                                d.setNomeAluno5(rs.getString("CAD_ALUNO.NOME"));
                                d.setRa_aluno5(rs.getInt("CAD_ALUNO.RA"));
                        }                           
                        if(  rs.next()){

                            d.setNomeAluno6(rs.getString("CAD_ALUNO.NOME"));
                            d.setRa_aluno6(rs.getInt("CAD_ALUNO.RA"));
                        }
                    
                    System.out.println("Aluno 1: " + d.getNomeAluno1() + " e seu RA:"+ d.getRa_aluno1() + "\n"+
                                  "Aluno 2: " + d.getNomeAluno2()+ " e seu RA:"+ d.getRa_aluno2() + "\n"+
                                  "Aluno 3: " + d.getNomeAluno3()+ " e seu RA:"+ d.getRa_aluno3() + "\n"+
                                  "Aluno 4: " + d.getNomeAluno4()+ " e seu RA:"+ d.getRa_aluno4() + "\n"+
                                  "Aluno 5: " + d.getNomeAluno5()+ " e seu RA:"+ d.getRa_aluno5() + "\n"+
                                  "Aluno 6: " + d.getNomeAluno6() + " e seu RA:"+ d.getRa_aluno6());
                
                    rs.close();	
                    rs.close();
                    con.close();
             
         }else{
             
             
         }
         
         
         
         
         
         
         
         
         
         
         
        
    }   catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}






    
    
    //terminar esse metodo
    
    //variaveis globais
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton3_buscar_turma = new javax.swing.JButton();
        jButton2_excluir_turma = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox6_escolha_turma = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2_aluno1 = new javax.swing.JTextField();
        jTextField14_aluno_ra1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField3_aluno2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField16_aluno_ra2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField4_aluno3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField17_aluno_ra3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField5_aluno4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField18_aluno_ra4 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField6_aluno5 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField19_aluno_ra5 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField7_aluno6 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField20_aluno_ra6 = new javax.swing.JTextField();
        rbAluno1 = new javax.swing.JRadioButton();
        rbAluno3 = new javax.swing.JRadioButton();
        rbAluno2 = new javax.swing.JRadioButton();
        rbAluno6 = new javax.swing.JRadioButton();
        rbAluno5 = new javax.swing.JRadioButton();
        rbAluno4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_nome_turma_atualiza = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1_dia_semana_atualiza = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField2_horario_turma_atualiza = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3_modalidade_atualiza = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jButton3_atualiza_estrutura = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1_dia_semana_atualiza2 = new javax.swing.JComboBox<>();
        jTextField2_horario_turma_atualiza2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField8_nome_prof = new javax.swing.JTextField();
        jTextField21_rp_prof = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        rbProf = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox5_add_aluno_atualiza = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4_add_prof_atualiza = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jButton1_atualiza_prof_e_ou_aluno_ao_banco = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Atualização de turmas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca de turma\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton3_buscar_turma.setText("Buscar Turma e atualizar página");
        jButton3_buscar_turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_buscar_turmaActionPerformed(evt);
            }
        });

        jButton2_excluir_turma.setBackground(new java.awt.Color(255, 153, 153));
        jButton2_excluir_turma.setText("Excluir Turma");
        jButton2_excluir_turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_excluir_turmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton3_buscar_turma)
                .addGap(62, 62, 62)
                .addComponent(jButton2_excluir_turma)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3_buscar_turma)
                    .addComponent(jButton2_excluir_turma))
                .addGap(19, 19, 19))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setText("Escolha a turma");

        jComboBox6_escolha_turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6_escolha_turmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jComboBox6_escolha_turma, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox6_escolha_turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da turma pesquisada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados básicos dos alunos\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel15.setText("Nome");

        jTextField2_aluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_aluno1ActionPerformed(evt);
            }
        });

        jLabel16.setText("RA");

        jLabel18.setText("Nome");

        jTextField3_aluno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3_aluno2ActionPerformed(evt);
            }
        });

        jLabel19.setText("RA");

        jLabel20.setText("Nome");

        jTextField4_aluno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4_aluno3ActionPerformed(evt);
            }
        });

        jLabel21.setText("RA");

        jLabel22.setText("Nome");

        jTextField5_aluno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5_aluno4ActionPerformed(evt);
            }
        });

        jLabel23.setText("RA");

        jLabel24.setText("Nome");

        jTextField6_aluno5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6_aluno5ActionPerformed(evt);
            }
        });

        jLabel25.setText("RA");

        jLabel26.setText("Nome");

        jTextField7_aluno6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7_aluno6ActionPerformed(evt);
            }
        });

        jLabel27.setText("RA");

        rbAluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAluno1ActionPerformed(evt);
            }
        });

        jButton1.setText("Remover itens selecionados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7_aluno6, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField20_aluno_ra6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6_aluno5, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField19_aluno_ra5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5_aluno4, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField18_aluno_ra4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4_aluno3, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField17_aluno_ra3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3_aluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField16_aluno_ra2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2_aluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField14_aluno_ra1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAluno1)
                            .addComponent(rbAluno3)
                            .addComponent(rbAluno2)
                            .addComponent(rbAluno4)
                            .addComponent(rbAluno5)
                            .addComponent(rbAluno6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2_aluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14_aluno_ra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(rbAluno1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField3_aluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16_aluno_ra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(rbAluno2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField4_aluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17_aluno_ra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(rbAluno3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField5_aluno4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18_aluno_ra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(rbAluno4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField6_aluno5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19_aluno_ra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(rbAluno5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField7_aluno6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20_aluno_ra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(rbAluno6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estrutura da Turma", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome da turma");

        jTextField1_nome_turma_atualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_nome_turma_atualizaActionPerformed(evt);
            }
        });

        jLabel2.setText("1° dia da semana");

        jComboBox1_dia_semana_atualiza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", " ", " " }));

        jLabel3.setText("1° horario da turma");

        jLabel4.setText("Modalidade ");

        jComboBox3_modalidade_atualiza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inglês Básico", "Inglês Intermediário", "Inglês Avançado", "Inglês para Viagem", "Inglês para Conversação" }));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton3_atualiza_estrutura.setText("Atualizar estrutura");
        jButton3_atualiza_estrutura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_atualiza_estruturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton3_atualiza_estrutura)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3_atualiza_estrutura)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("2°  horário da turma");

        jLabel9.setText("2° dia da semana");

        jComboBox1_dia_semana_atualiza2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", " ", " " }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1_dia_semana_atualiza2, 0, 224, Short.MAX_VALUE)
                    .addComponent(jTextField2_horario_turma_atualiza2))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1_dia_semana_atualiza2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2_horario_turma_atualiza2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1_nome_turma_atualiza)
                    .addComponent(jComboBox1_dia_semana_atualiza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2_horario_turma_atualiza)
                    .addComponent(jComboBox3_modalidade_atualiza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1_nome_turma_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1_dia_semana_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2_horario_turma_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3_modalidade_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados básicos do professor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel14.setText("Nome");

        jTextField8_nome_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8_nome_profActionPerformed(evt);
            }
        });

        jLabel28.setText("RP");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel5.setText("*Se estiver em branco = turma sem professor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField8_nome_prof, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField21_rp_prof, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbProf)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTextField8_nome_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField21_rp_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addComponent(rbProf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atualização de Turma \n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Aluno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel7.setText("Alunos sem turma");

        jComboBox5_add_aluno_atualiza.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jComboBox5_add_aluno_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox5_add_aluno_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Professor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel6.setText("Todos os professores");

        jComboBox4_add_prof_atualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4_add_prof_atualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jComboBox4_add_prof_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4_add_prof_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1_atualiza_prof_e_ou_aluno_ao_banco.setText("Adicionar professor e/ou aluno(s) na turma");
        jButton1_atualiza_prof_e_ou_aluno_ao_banco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_atualiza_prof_e_ou_aluno_ao_bancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton1_atualiza_prof_e_ou_aluno_ao_banco)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1_atualiza_prof_e_ou_aluno_ao_banco)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox6_escolha_turmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6_escolha_turmaActionPerformed
        // TODO add your handling code here:

        
    
        
        
    }//GEN-LAST:event_jComboBox6_escolha_turmaActionPerformed

    private void jTextField1_nome_turma_atualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_nome_turma_atualizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_nome_turma_atualizaActionPerformed

    private void jTextField2_aluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_aluno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_aluno1ActionPerformed

    private void jTextField3_aluno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_aluno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_aluno2ActionPerformed

    private void jTextField4_aluno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4_aluno3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4_aluno3ActionPerformed

    private void jTextField5_aluno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5_aluno4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5_aluno4ActionPerformed

    private void jTextField6_aluno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6_aluno5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6_aluno5ActionPerformed

    private void jTextField7_aluno6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7_aluno6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7_aluno6ActionPerformed

    private void jTextField8_nome_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8_nome_profActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8_nome_profActionPerformed

    private void jButton3_atualiza_estruturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_atualiza_estruturaActionPerformed
        // Esse botao, confirma a atualizacao dos dados 
        
        DivTurmasDAO dao = new DivTurmasDAO();
        
        DivTurmas dt = new DivTurmas();
        
        /*jTextField1_nome_turma_atualiza
        jComboBox1_dia_semana_atualiza
        jTextField2_horario_turma_atualiza
        jComboBox3_modalidade_atualiza*/
        
        String itemEscolhido = jComboBox6_escolha_turma.getSelectedItem().toString();
        
        
        String nome  = jTextField1_nome_turma_atualiza.getText();
        dt.setNome_turma(nome);
        
        String dia = jComboBox1_dia_semana_atualiza.getSelectedItem().toString();
        dt.setDia_semana(dia);
        
        String horario = jTextField2_horario_turma_atualiza.getText();
        
        try {
            //usar o formataHora
            dt.setHorario_dia(dt.formatarHora(horario));
            
        } catch (ParseException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String modalidade = jComboBox3_modalidade_atualiza.getSelectedItem().toString();
        dt.setModalidade(modalidade);
        
        //--
        dt.setSegudoDia_semana(jComboBox1_dia_semana_atualiza2.getSelectedItem().toString());
        
        try {
            
            dt.setSegundoHorario_dia(dt.formatarHora(jTextField2_horario_turma_atualiza2.getText()));
            
        } catch (ParseException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-
        
        
        dao.updateSegundoDia(dt, itemEscolhido);

    }//GEN-LAST:event_jButton3_atualiza_estruturaActionPerformed

    
    
    private void jButton3_buscar_turmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_buscar_turmaActionPerformed
        // AQUI NOS PODEMOS BUSCAR A TURMA ESCOLHIDA NO COMBOBOX

        //novissimo codigo: deve ser um codigo simples que puxe apenas a estrutura(por enquanto).
        DivTurmasDAO dao = new DivTurmasDAO();
        DivTurmas d = new DivTurmas();
        
        String nomeTurma = String.valueOf(jComboBox6_escolha_turma.getSelectedItem());
        
        dao.Select2(d, String.valueOf(jComboBox6_escolha_turma.getSelectedItem()));
        
        jTextField1_nome_turma_atualiza.setText(d.getNome_turma());
        jComboBox1_dia_semana_atualiza.setSelectedItem(d.getDia_semana());
        jTextField2_horario_turma_atualiza.setText(String.valueOf(d.getHorario_dia()));
        jComboBox3_modalidade_atualiza.setSelectedItem(d.getModalidade());
        
        if(d.getSegudoDia_semana() != null){
            jComboBox1_dia_semana_atualiza2.setSelectedItem(d.getSegudoDia_semana());
        }else{
            jComboBox1_dia_semana_atualiza2.setSelectedItem(null);
        }
        
        if(d.getSegundoHorario_dia() != null){
            jTextField2_horario_turma_atualiza2.setText(d.getSegundoHorario_dia().toString());
        }else{
            jTextField2_horario_turma_atualiza2.setText(null);
        }
        
        
        
        
        
        jComboBox4_add_prof_atualiza.setSelectedItem(this.retornaNomePorRP(d, String.valueOf(jComboBox6_escolha_turma.getSelectedItem())));
        
        //sobre os professores:
        jTextField8_nome_prof.setText(this.retornaNomePorRP(d, nomeTurma));
        jTextField21_rp_prof.setText(String.valueOf(d.getFk_prof_rp()));
        
        
        this.preencheTextFieldsComAlunos(d, nomeTurma);
        
        jTextField2_aluno1.setText(d.getNomeAluno1()); jTextField14_aluno_ra1.setText(String.valueOf(d.getRa_aluno1()));
        jTextField3_aluno2.setText(d.getNomeAluno2()); jTextField16_aluno_ra2.setText(String.valueOf(d.getRa_aluno2()));
        jTextField4_aluno3.setText(d.getNomeAluno3()); jTextField17_aluno_ra3.setText(String.valueOf(d.getRa_aluno3()));
        jTextField5_aluno4.setText(d.getNomeAluno4()); jTextField18_aluno_ra4.setText(String.valueOf(d.getRa_aluno4()));
        jTextField6_aluno5.setText(d.getNomeAluno5()); jTextField19_aluno_ra5.setText(String.valueOf(d.getRa_aluno5()));
        jTextField7_aluno6.setText(d.getNomeAluno6()); jTextField20_aluno_ra6.setText(String.valueOf(d.getRa_aluno6()));
   
        //precisamos de um metodo que preenche todas as textFields com seus respectivos valores. Esta ok!
        
        //aqui embaixom nos populamos novamente as comboBox, pois, este eh um botao de atualizacao.
        this.removeItemComboBox();
        this.populaComboBox2();
        this.removeItemComboBoxAlunos();
        this.populaComboBoxAlunoSemTurma();
        jComboBox5_add_aluno_atualiza.setSelectedItem(null);

    }//GEN-LAST:event_jButton3_buscar_turmaActionPerformed

    private void jButton1_atualiza_prof_e_ou_aluno_ao_bancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_atualiza_prof_e_ou_aluno_ao_bancoActionPerformed
        /*String professor = String.valueOf(jComboBox4_add_prof_atualiza.getSelectedItem());
        JOptionPane.showMessageDialog(null,"Nome escolhido:  " + professor);

        String nomeTurma = String.valueOf(jComboBox6_escolha_turma.getSelectedItem());
        dt.setFk_prof_rp(dt.getRp_prof());
        dt.setFk_aluno_ra(dt.getRa_aluno1());   
        dt.setNomeProfessor(professor); 
        dao.update2(dt, nomeTurma);  
        jTextField8_nome_prof.setText(professor);  
        Desta maneira nos poderemos adicionar um professor nas variaveis.
        //O codigo deu erro. Nao consegui atualizar */
        
        DivTurmas d = new DivTurmas();
        DivTurmasDAO dao = new DivTurmasDAO();
        
        String valor = String.valueOf(jComboBox6_escolha_turma.getSelectedItem());
        
        this.insertQuerysCorretasTurmas(d, valor);
        
          
    }//GEN-LAST:event_jButton1_atualiza_prof_e_ou_aluno_ao_bancoActionPerformed

    private void jComboBox4_add_prof_atualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4_add_prof_atualizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4_add_prof_atualizaActionPerformed

    private void jButton2_excluir_turmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_excluir_turmaActionPerformed
        // TODO add your handling code here:
        DivTurmasDAO dao = new DivTurmasDAO();
        DivTurmas d = new DivTurmas();
        
        String nomeTurma = String.valueOf(jComboBox6_escolha_turma.getSelectedItem());
        dao.delete(d, nomeTurma);
                
    }//GEN-LAST:event_jButton2_excluir_turmaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    // Esse botao, remove da turma todos os itens selecionados.
    Connection con = null;
    DivTurmasDAO dao = new DivTurmasDAO();
    DivTurmas d = new DivTurmas();
    String nomeTurma = String.valueOf(jComboBox6_escolha_turma.getSelectedItem());
    
    
    //seria bom fazer um metodo? 

    
    if(rbProf.isSelected()){

        try{
            
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "UPDATE DIV_TURMA SET DIV_TURMA.FK_PROF_RP = NULL WHERE DIV_TURMA.FK_PROF_RP = ?";
            
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, dao.retornaRPcadastrado(d, nomeTurma));
            
            stm.executeUpdate();
            stm.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"O professor desta turma foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outro professor.");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
    }
    
    
    /*Agora os alunos*/
    
    if(rbAluno1.isSelected()){
        try{
            dao.Select2(d, nomeTurma);
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "DELETE FROM DIV_TURMA WHERE FK_ALUNO_RA = ?";
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, this.retornaRA(d, jTextField2_aluno1.getText()));
            
            stm.executeUpdate();
            stm.close();
            con.close();

            JOptionPane.showMessageDialog(null,"O aluno 1 foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outros alunos nesta turma ou excluí-la.");
            rbAluno1.setSelected(false);
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
        
    if(rbAluno2.isSelected()){
         try{
            
            dao.Select2(d, nomeTurma);
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "DELETE FROM DIV_TURMA WHERE FK_ALUNO_RA = ?";

            stm = con.prepareStatement(sql);

            stm.setInt(1, this.retornaRA(d, jTextField3_aluno2.getText()));

            stm.executeUpdate();
            stm.close();
            con.close();

            JOptionPane.showMessageDialog(null,"O aluno 2 foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outros alunos nesta turma ou excluí-la.");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    if(rbAluno3.isSelected()){
         try{
            
            dao.Select2(d, nomeTurma);
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "DELETE FROM DIV_TURMA WHERE FK_ALUNO_RA = ?";

            stm = con.prepareStatement(sql);

            stm.setInt(1, this.retornaRA(d, jTextField4_aluno3.getText()));

            stm.executeUpdate();
            stm.close();
            con.close();

            JOptionPane.showMessageDialog(null,"O aluno 3 foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outros alunos nesta turma ou excluí-la.");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    if(rbAluno4.isSelected()){
         try{
            
            dao.Select2(d, nomeTurma);
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "DELETE FROM DIV_TURMA WHERE FK_ALUNO_RA = ?";

            stm = con.prepareStatement(sql);

            stm.setInt(1, this.retornaRA(d, jTextField5_aluno4.getText()));

            stm.executeUpdate();
            stm.close();
            con.close();

            JOptionPane.showMessageDialog(null,"O aluno 4 foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outros alunos nesta turma ou excluí-la.");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    if(rbAluno5.isSelected()){
         try{
            
            dao.Select2(d, nomeTurma);
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "DELETE FROM DIV_TURMA WHERE FK_ALUNO_RA = ?";

            stm = con.prepareStatement(sql);

            stm.setInt(1, this.retornaRA(d, jTextField6_aluno5.getText()));

            stm.executeUpdate();
            stm.close();
            con.close();

            JOptionPane.showMessageDialog(null,"O aluno 5 foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outros alunos nesta turma ou excluí-la.");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
    if(rbAluno6.isSelected()){

         try{
            
            dao.Select2(d, nomeTurma);
            PreparedStatement stm = null;
            con = UtilDAO.conectar();
            String sql = "DELETE FROM DIV_TURMA WHERE FK_ALUNO_RA = ?";

            stm = con.prepareStatement(sql);

            stm.setInt(1, this.retornaRA(d, jTextField7_aluno6.getText()));

            stm.executeUpdate();
            stm.close();
            con.close();

            JOptionPane.showMessageDialog(null,"O aluno 6 foi removido. "
                                        +"\n"+ "Agora já você pode adicionar outros alunos nesta turma ou excluí-la.");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarTurmasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }                  
         
         
        //precisamos desmarcar os radioSbutons
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbAluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAluno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAluno1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1_atualiza_prof_e_ou_aluno_ao_banco;
    private javax.swing.JButton jButton2_excluir_turma;
    private javax.swing.JButton jButton3_atualiza_estrutura;
    private javax.swing.JButton jButton3_buscar_turma;
    private javax.swing.JComboBox<String> jComboBox1_dia_semana_atualiza;
    private javax.swing.JComboBox<String> jComboBox1_dia_semana_atualiza2;
    private javax.swing.JComboBox<String> jComboBox3_modalidade_atualiza;
    private javax.swing.JComboBox<String> jComboBox4_add_prof_atualiza;
    private javax.swing.JComboBox<String> jComboBox5_add_aluno_atualiza;
    private javax.swing.JComboBox<String> jComboBox6_escolha_turma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField14_aluno_ra1;
    private javax.swing.JTextField jTextField16_aluno_ra2;
    private javax.swing.JTextField jTextField17_aluno_ra3;
    private javax.swing.JTextField jTextField18_aluno_ra4;
    private javax.swing.JTextField jTextField19_aluno_ra5;
    private javax.swing.JTextField jTextField1_nome_turma_atualiza;
    private javax.swing.JTextField jTextField20_aluno_ra6;
    private javax.swing.JTextField jTextField21_rp_prof;
    private javax.swing.JTextField jTextField2_aluno1;
    private javax.swing.JTextField jTextField2_horario_turma_atualiza;
    private javax.swing.JTextField jTextField2_horario_turma_atualiza2;
    private javax.swing.JTextField jTextField3_aluno2;
    private javax.swing.JTextField jTextField4_aluno3;
    private javax.swing.JTextField jTextField5_aluno4;
    private javax.swing.JTextField jTextField6_aluno5;
    private javax.swing.JTextField jTextField7_aluno6;
    private javax.swing.JTextField jTextField8_nome_prof;
    private javax.swing.JRadioButton rbAluno1;
    private javax.swing.JRadioButton rbAluno2;
    private javax.swing.JRadioButton rbAluno3;
    private javax.swing.JRadioButton rbAluno4;
    private javax.swing.JRadioButton rbAluno5;
    private javax.swing.JRadioButton rbAluno6;
    private javax.swing.JRadioButton rbProf;
    // End of variables declaration//GEN-END:variables
}
