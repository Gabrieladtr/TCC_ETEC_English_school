/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronograma.Classes.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author wesley
 */
public class UtilDAO2 {
 
    public static Connection conexao(){

                Connection con = null;         
		try{
                String usuario="", host="", senha="", nome="", porta="";
                
                Properties p = new Properties();
                FileInputStream fis = new FileInputStream("propriedades/configuracoes.properties");
                p.load(fis);
                
                host = p.getProperty("bd.config.host");
                usuario= p.getProperty("bd.config.usuario");
                senha=p.getProperty("bd.config.senha");
                nome=p.getProperty("bd.config.nome");
                porta=p.getProperty("bd.config.porta");

                
			con = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+nome,usuario,senha);
		}
                catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null,"configurações de propriedades não encontrado. Verifique o erro.");
                } 
                
                catch(IOException ex){
                    JOptionPane.showMessageDialog(null,"IO -input - DEU ERRO. "
                            + "verifique o ''FileInputStream'' ");
                }

                catch (SQLException EX){                  
			JOptionPane.showMessageDialog(null,"Não conectou com o DB - SQLException");
			EX.printStackTrace();	
		}
	
		return con;	
	}
}
