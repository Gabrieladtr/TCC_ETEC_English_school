/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;

import br.gov.sp.etec.gui.EsqueciMinhaSenhaGUI;
import br.gov.sp.etec.gui.TelaAdminGUI;
import br.gov.sp.etec.gui.TelaProfessorGUI;
import br.gov.sp.etec.model.Login;
import br.gov.sp.etec.model.Professor;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author etecja
 */

public class LoginDAO {
    
    public static int id_prof;
    
    public Login Altetica (Login l){
        Connection con = null;
        Professor p= new Professor();
        
        try{
        PreparedStatement ps = null;
        String sql = "select * from login where login.email = ? and login.senha = ?;";
        con = UtilDAO.conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, l.getEmail());
        ps.setString(2, l.getSenha());
       TelaAdminGUI admG = new TelaAdminGUI();
       TelaProfessorGUI profG = new TelaProfessorGUI();
        ResultSet rs = ps.executeQuery();
       
        if(rs.next()){
            //abre a tela de adm
     
            l.setNivel(rs.getString("nivel"));
            String nivel = l.getNivel();
            
            if(nivel.equals("ADM")){
              JOptionPane.showMessageDialog(null, "Bem vindo administrador ! ");
              admG.setExtendedState(admG.MAXIMIZED_BOTH);
           admG.setVisible(true);
            
            }if(nivel.equals("PRO")){
                JOptionPane.showMessageDialog(null, "Bem vindo professor ! ");
            new TelaProfessorGUI().setVisible(true);
            profG.setExtendedState(profG.MAXIMIZED_BOTH);
            profG.setVisible(true);
            }
        }else{
        JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos ! ");
        }
        rs.close();
        ps.close();
        con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no login");
        }
        return l;
    }
    /*Esqueci minha senha*/
}
