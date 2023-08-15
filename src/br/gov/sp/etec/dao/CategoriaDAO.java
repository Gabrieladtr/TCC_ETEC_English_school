/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;
import br.gov.sp.etec.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Edson
 */
public class CategoriaDAO {
 
    public void insert(Categoria c){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into categoria(descricao, tipo) values (?,?)";
		try {
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getDescricaoC());
			ps.setString(2, c.getTipo());
		
			
			
			ps.execute();
			ps.close();
			
			con.close();
                        JOptionPane.showMessageDialog(null, "Cadastro efeituado com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
    public List<Categoria> selectAtivo(){
		Connection con = UtilDAO.conectar();
                List<Categoria> listaCat = new ArrayList<>();
		try {
			PreparedStatement ps = null;
			String sql = "SELECT * FROM categoria where tipo = 'Ativo'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                            Categoria cat = new Categoria();
                                cat.setId_cat(rs.getInt("id_cat"));
                                cat.setDescricaoC(rs.getString("descricao"));
				cat.setTipo(rs.getString("tipo"));
				listaCat.add(cat);
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			                 JOptionPane.showMessageDialog(null, "Erro404");
			ex.printStackTrace();
		}
		return listaCat;
	}
        
        public List<Categoria> selectPassivo(){
		Connection con = UtilDAO.conectar();
                List<Categoria> listaCat = new ArrayList<>();
		try {
			PreparedStatement ps = null;
			String sql = "SELECT * FROM categoria where tipo = 'Passivo'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                            Categoria cat = new Categoria();
                                cat.setId_cat(rs.getInt("id_cat"));
                                cat.setDescricaoC(rs.getString("descricao"));
				cat.setTipo(rs.getString("tipo"));
				listaCat.add(cat);
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			                 JOptionPane.showMessageDialog(null, "Erro404");
			ex.printStackTrace();
		}
		return listaCat;
	}
    
}
