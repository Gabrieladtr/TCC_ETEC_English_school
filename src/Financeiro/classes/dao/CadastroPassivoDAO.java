/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro.classes.dao;

import br.gov.sp.etec.dao.UtilDAO;
import Financeiro.classes.modeladora.CadastroContas;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Edson
 */
public class CadastroPassivoDAO {
    public void insert(CadastroContas c){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into passivo (valor, descricao, data_lancamento, categoria) values (?,?,?,?)";
		try {
			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, c.getValor());
			ps.setString(2, c.getDescricaoA());
			ps.setString(3,  c.getData_lancamento());
			ps.setString(4, c.getCategoria());

			ps.execute();
			ps.close();
			
			con.close();
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
