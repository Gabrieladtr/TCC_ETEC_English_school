/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;


import br.gov.sp.etec.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edson
 */
public class EnderecoDAO {
     public void insertProf(Endereco e){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into endereco(numero, cidade, cep, uf, rua, bairro, complemento, fk_prof_rp) "
                        + "values (?,?,?,?,?,?,?,?);";
                
		try {
                        
                       
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getCep());
			ps.setString(2, e.getUf());
			ps.setString(3, e.getCidade());
			ps.setString(4, e.getRua());
			ps.setString(5, e.getBairro());
			ps.setString(6, e.getNumero());
			ps.setString(7, e.getComplemento());
			ps.setInt(8, e.getRp().getRp());
		
			
			
			ps.execute();
			ps.close();
			
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
