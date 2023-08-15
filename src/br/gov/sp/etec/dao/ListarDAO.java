/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;

import br.gov.sp.etec.model.CadastroContas;
import br.gov.sp.etec.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Edson
 */
public class ListarDAO {
    
    public List<CadastroContas> selectAtivo(){
		Connection con = UtilDAO.conectar();
                List<CadastroContas> listaAtivo = new ArrayList<>();
		try {
			PreparedStatement ps = null;
			String sql = "select  categoria.tipo, categoria.descricao,  ativo.descricao as adesc, ativo.valor, ativo.data_lancamento  from ativo\n" +
"	inner join categoria on\n " +
"	(categoria.id_cat = ativo.id_cat)\n " +
"	group by ativo.descricao; ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                            
                                CadastroContas c = new CadastroContas();
                                Categoria categoria = new Categoria();
                                categoria.setTipo(rs.getString("tipo"));
                                categoria.setDescricaoC(rs.getString("descricao"));
                                
                                
                                c.setDescricaoA(rs.getString("adesc"));
				c.setValor(rs.getDouble("valor"));
                                c.setData_lancamento(rs.getString("data_lancamento"));
//                                c.setCategoria(categoria);
                               
				listaAtivo.add(c);
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			                 JOptionPane.showMessageDialog(null, "Erro ao tentar buscar a conta");
			ex.printStackTrace();
		}
		return listaAtivo;
	}
    
     public List<CadastroContas> selectPassivo(){
		Connection con = UtilDAO.conectar();
                List<CadastroContas> listaPassivo = new ArrayList<>();
		try {
			PreparedStatement ps = null;
			String sql = "select  categoria.tipo, categoria.descricao,  passivo.descricao as adesc, passivo.valor, passivo.data_lancamento  from passivo\n " +
                                "	inner join categoria on\n " +
                                "	(categoria.id_cat = passivo.id_cat)\n " +
                                "	group by passivo.descricao; ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                            
                                CadastroContas c = new CadastroContas();
                                Categoria categoria = new Categoria();
                                categoria.setTipo(rs.getString("tipo"));
                                categoria.setDescricaoC(rs.getString("descricao"));
                                
                                
                                c.setDescricaoA(rs.getString("adesc"));
				c.setValor(rs.getDouble("valor"));
                                c.setData_lancamento(rs.getString("data_lancamento"));
//                                c.setCategoria(categoria);
                               
				listaPassivo.add(c);
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			                 JOptionPane.showMessageDialog(null, "Erro ao tentar buscar a conta");
			ex.printStackTrace();
		}
		return listaPassivo;
	}
     
}
