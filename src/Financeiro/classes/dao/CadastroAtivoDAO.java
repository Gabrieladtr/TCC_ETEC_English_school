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
public class CadastroAtivoDAO {
    
    /*Deve haver um insert para alunos com mensalidade e sem mensalidade*/
    
    /*Precisamos de um metodo que converte para o padrao sql toda vez que pegarmos uma data*/
    
     public void insert(CadastroContas c){
		
                
                //INSERT INTO ATIVO () VALUES 
                
		try {
            Connection con = null;
            PreparedStatement ps = null;
            String sql = "insert into ativo (valor, descricao, data_lancamento, categoria) values (?,?,?,?)";

			con = UtilDAO.conectar();
			ps = con.prepareStatement(sql);
                        
			ps.setDouble(1, c.getValor());
			ps.setString(2, c.getDescricaoA());
			ps.setString(3, c.getData_lancamento());
			ps.setString(4, c.getCategoria());
		
			/*  id_ativo int primary key auto_increment,
                            
                            valor double not null,
                            descricao varchar(300) not null,
                            data_lancamento date not null,
                            categoria varchar(100)*/
			
			ps.execute();
			ps.close();
			
			con.close();
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
     
}
