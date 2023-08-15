/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.chamada;

import br.gov.sp.etec.dao.UtilDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Edson
 */
public class ChamadaDAO {
    public void insertChamada(Chamada c){    
        try{  
                        Connection con;
                        PreparedStatement stm;
                        String sql = "insert into chamada (chamada.data_chamada, chamada.presenca, chamada.status_felicidade, chamada.observacao, chamada.nome_turma, chamada.nome_aluno) "
                                + "values (?,?,?,?,?,?);";
                        //PODE DAR ERRO QUANTO AO DEFAULT. NAO DEU.
			con = UtilDAO.conectar();
			stm = con.prepareStatement(sql);
			
			stm.setString(1, c.getData_chamada());
			stm.setBoolean(2, c.isPrensenca());
			stm.setString(3, c.getStatus());
			stm.setString(4, c.getObservacao());
			stm.setString(5, c.getNomeTurma());
			stm.setString(6, c.getNome());
			
			stm.execute();
			stm.close();
                        
			con.close();
			
		}catch (SQLException e){
			e.printStackTrace();
                         JOptionPane.showMessageDialog(null,"Dados não salvos. Verifique a conexão com o banco.");
		}
        
    }
    
    
    public List<Chamada> selectFrequencia(Chamada c){
		Connection con = UtilDAO.conectar();
                List<Chamada> listar= new ArrayList<>();
		try {
			PreparedStatement ps = null;
			String sql = "select chamada.nome_aluno, sum(chamada.presenca) * 100/ 4 as pres from chamada where chamada.nome_turma = ? group by chamada.nome_aluno;";
			ps = con.prepareStatement(sql);
                        ps.setString(1, c.getNomeTurma());
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                            
                              
                                c.setNome(rs.getString("nome"));
                                c.setFrequencia(rs.getDouble("nome"));
				listar.add(c);
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			                 JOptionPane.showMessageDialog(null, "Erro ao tentar buscar os valores");
			ex.printStackTrace();
		}
		return listar;
	}
                
}
