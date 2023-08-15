/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;
import br.gov.sp.etec.model.CadastroContas;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Edson
 */
public class CadastroPassivoDAO {
    int lastIdPassivo = 0;
    public void insert(CadastroContas c){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into passivo (valor, descricao, data_lancamento, categoria, subcategoria) values (?,?,?,?,?)";
		try {
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, c.getValor());
			ps.setString(2, c.getDescricaoA());
			ps.setString(3, c.getData_lancamento());
			ps.setString(4, c.getCategoria());
			ps.setString(5, c.getSubcategoria());
//			ps.setInt(4, c.getCategoria().getId_cat());
			ps.executeUpdate();
                        
                        ResultSet rs = ps.getGeneratedKeys();
                        if (rs.next()) {
                        lastIdPassivo = rs.getInt(1); 
                        }  
                        System.out.println(lastIdPassivo);
			ps.close();
			
			con.close();
                        JOptionPane.showMessageDialog(null, "Cadastro efeituado com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
      
}
