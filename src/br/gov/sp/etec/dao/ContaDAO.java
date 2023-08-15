/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;
import br.gov.sp.etec.model.Conta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Edson
 */
public class ContaDAO {
    public void insert(Conta c) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into conta(descricao) values(?)";

		try {
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getDescricao());
			ps.execute();
			ps.close();

			con.close();
JOptionPane.showMessageDialog(null,"Conta cadastrada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Conta> select(){
		Connection con = UtilDAO.conectar();
                List<Conta> listaConta = new ArrayList<>();
		try {
			PreparedStatement ps = null;
			String sql = "SELECT * FROM conta";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
                            Conta c = new Conta();
                                c.setId_conta(rs.getInt("id_conta"));
                                c.setDescricao(rs.getString("descricao"));
				c.setValor(rs.getDouble("valor"));
				listaConta.add(c);
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			                 JOptionPane.showMessageDialog(null, "Erro ao tentar buscar a conta");
			ex.printStackTrace();
		}
		return listaConta;
	}
        /*
        public Conta somarConta(Conta c ){
		Connection con = null;
		try {
			PreparedStatement ps = null;
			String sql = "insert into conta(valor) where id_conta=?";
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setLong(1, c.getId_conta());
			ResultSet rs = ps.executeQuery();
			int soma; 
			if (rs.next()){
				c.setNome(rs.getString("nome"));
				c.setDescricao(rs.getString("descricao"));
				c.setHabilidade(rs.getString("habilidade"));
				c.setAtivAnterior(rs.getString("ativAnterior"));
				c.setRecompensa(rs.getDouble("recompensa"));
				c.setIdade(rs.getInt("idade"));
				
			
				
			}
			rs.close();
			
			ps.close();
			con.close();
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o pirata ");
			ex.printStackTrace();
		}
		return c;
	}*/
        
        public void UpdateCB(Conta c){
            PreparedStatement ps = null;
            Connection con = null;
			
                try {
                    String sql = "update conta set valor=?, data_lancamento=? where id_conta=?";
			con = UtilDAO.conectar();
                        
			ps = con.prepareStatement(sql);
			ps = con.prepareStatement(sql);
                        
			ps.setDouble(1, c.getValor());
			ps.setString(2, c.getData());
                        ps.setInt(3, c.getId_conta());
                        
			ps.execute();
			ps.close();

			con.close();
JOptionPane.showMessageDialog(null,"Valor e data cadastrado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        }
}
