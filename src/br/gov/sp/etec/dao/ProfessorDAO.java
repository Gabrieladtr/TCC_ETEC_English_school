/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;

import br.gov.sp.etec.model.Endereco;
import br.gov.sp.etec.model.Login;
import br.gov.sp.etec.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author etecja
 */
public class ProfessorDAO {
       int lastIdProf = 0;
    int lastIdTelefone = 0;
    public void insert(Professor p) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into cadastro_prof (nome, sobrenome, cpf, rg, dt_nascimento, sexo, pergunta, tel_fixo, tel_celular, resposta) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getSobrenome());
			ps.setString(3, p.getCpf());
			ps.setString(4, p.getRg());
			ps.setString(5, p.getDt_nasc());
			ps.setString(6, p.getSexo());
			ps.setString(7, p.getPergunta());
			ps.setString(8, p.getTel_fixo());
			ps.setString(9, p.getTel_fixo());
			ps.setString(10, p.getResposta());
			ps.executeUpdate();
                        
                         ResultSet rs = ps.getGeneratedKeys();
                        if (rs.next()) {
                        lastIdProf = rs.getInt(1); 
                        }  
                        
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
     
        public void insertLoginProf(Login l){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into Login(email, senha, nivel, fk_prof_rp) values (?,?,?,?)";
                
		try {
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, l.getEmail());
			ps.setString(2, l.getSenha());
			ps.setString(3, l.getNivel());
			ps.setInt(4, lastIdProf);
                        
			ps.execute();
			ps.close();
			
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
}
        public void insertProfEnd(Endereco e){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into endereco(numero, cidade, cep, uf, rua, bairro, complemento, fk_prof_rp) "
                        + "values (?,?,?,?,?,?,?,?);";
                
		try {
                        
                       
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getNumero());
			ps.setString(2, e.getCidade());
			ps.setString(3, e.getCep());
			ps.setString(4, e.getUf());
			ps.setString(5, e.getRua());
			ps.setString(6, e.getBairro());
			ps.setString(7, e.getComplemento());
			ps.setInt(8, lastIdProf);
		
			
			
			ps.execute();
			ps.close();
			
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
