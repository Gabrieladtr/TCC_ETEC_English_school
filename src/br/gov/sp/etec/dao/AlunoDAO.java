 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;

import br.gov.sp.etec.model.Aluno;
import br.gov.sp.etec.model.Endereco;
import br.gov.sp.etec.model.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edson
 */
public class AlunoDAO {
    int lastIdAluno = 0;
    int lastIdAResp = 0;
    int lastIdTelefone = 0;
    int lastIdTR = 0;
      
	
        ////////////////////////RESPONSAVEL////////////////////
        //                                                   // 
        //                                                   //
        //                  CREDITOS:                        //  
        //                                                   //
        //                    EDSON                          //
        //                     AND                           //
        //                    EVERTON                        //
        //                                                   //
        //                                                   //
        //                                                   //
        //////////////////////////////////////////////////////
        public Responsavel insertResponsavel(Responsavel r) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into responsavel (nome, sobrenome, sexo, rg, cpf, dt_nasc, tel_fixo, tel_celular) values (?,?,?,?,?,?,?,?)";
		try {
                        con = UtilDAO.conectar();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, r.getNome());
			ps.setString(2, r.getSobrenome());
			ps.setString(3, r.getSexo());
                        ps.setString(4, r.getRg());
			ps.setString(5, r.getCpf());
                        ps.setString(6, r.getDt_nasc());
			ps.setString(7, r.getTel_fixo());
			ps.setString(8, r.getTel_celular());
			
			
                        ps.executeUpdate();
                        
                        ResultSet rs = ps.getGeneratedKeys();
                        if (rs.next()) {
                        lastIdAResp = rs.getInt(1); 
                        }   
                        
                        
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
                }
                
                return r;
	}
      
     
        public void insertEndResponsavel(Endereco e){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into endereco(numero, cidade, cep, uf, rua, bairro, complemento, fk_cod_resp) values (?,?,?,?,?,?,?,?)";
                
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
			ps.setInt(8, lastIdAResp);
		
			
			
			ps.execute();
			ps.close();
			
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
     
        ////////////////////////ALUNO/////////////////////////
        //                                                   // 
        //                                                   //
        //                  CREDITOS:                        //  
        //                                                   //
        //                    EDSON                          //
        //                     AND                           //
        //                    EVERTON                        //
        //                                                   //
        //                                                   //
        //                                                   //
        //////////////////////////////////////////////////////
        
        public Aluno insert(Aluno a) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into cad_aluno (nome, sobrenome, sexo, cpf, dt_nasc, nivel_ingles,rg, tel_fixo, tel_celular, fk_cod_resp) values (?,?,?,?,?,?,?,?,?,?)";
		try {
                        con = UtilDAO.conectar();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getSobrenome());
                        ps.setString(3, a.getSexo());
			ps.setString(4, a.getCpf());
			ps.setString(5, a.getData_nasc());
			ps.setString(6, a.getNivelI());
			ps.setString(7, a.getRg());
			ps.setString(8, a.getTel_fixo());
			ps.setString(9, a.getTel_celular());
			ps.setInt(10, lastIdAResp);
                        ps.executeUpdate();
                        
                        ResultSet rs = ps.getGeneratedKeys();
                        if (rs.next()) {
                        lastIdAluno = rs.getInt(1); 
                        }   
                        
                        
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
                }
                
                return a;
	}
      
     
        public void insertEnd(Endereco e){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into endereco(numero, cidade, cep, uf, rua, bairro, complemento, fk_alun_ra) values (?,?,?,?,?,?,?,?)";
                
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
			ps.setInt(8, lastIdAluno);
		
			
			
			ps.execute();
			ps.close();
			
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
        
        
       
}
    