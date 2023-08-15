/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;

import br.gov.sp.etec.gui.TelaAdminGUI;
import br.gov.sp.etec.model.EsqueciMinhaSenha;
import br.gov.sp.etec.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edson
 */
public class EsqueciMinhaSenhaDAO {
    
    public EsqueciMinhaSenha Altetica (EsqueciMinhaSenha ems){
        Connection con = null;
        
        try{
        PreparedStatement ps = null;
        
        String sql = " select login.senha as pass from login\n" +
        "inner join cadastro_prof on (login.fk_prof_rp = cadastro_prof.rp)\n" +
        "where cadastro_prof.cpf = ? and cadastro_prof.pergunta = ? and cadastro_prof.resposta = ?;"; 
        con = UtilDAO.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, ems.getCpf());
        ps.setString(2, ems.getPergunta());
        ps.setString(3, ems.getResposta());
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
				
				ems.setSenha(rs.getString("pass"));
			}
        
        rs.close();
        ps.close();
        con.close();
       
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro");
        }
        return ems;
    }
    
    public Login Chamar (Login l){
    Connection con = null;
   
    try{
        PreparedStatement ps = null;
        String sql = "select login.senha from login \n" +
                     "inner join cadastro_prof on (login.fk_prof_rp = cadastro_prof.rp)\n" +
                     "where cadastro_prof.rp = ?;";
        
        con = UtilDAO.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, l.getSenha());
        ResultSet rs = ps.executeQuery();
    
        JOptionPane.showMessageDialog(null, "Senha :" +l.getSenha());
        System.out.println("Senha = " +l.getSenha());
        
        rs.close();
        ps.close();
        con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro");
        }
        return l;
    }
    
}
