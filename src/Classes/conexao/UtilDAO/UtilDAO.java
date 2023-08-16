/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.conexao.UtilDAO;

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
 * @author Gabriel Rocha
 */

 //Essa classe testa a conexao com o banco de dados
 
public class UtilDAO {
    
     public static Connection conexao() {

Connection con = null;         
try{
String usuario="", host="", senha="", nome="", porta="";

Properties p = new Properties();
FileInputStream fis = new FileInputStream("propriedades/configuracoes.properties");
p.load(fis);

usuario= p.getProperty("bd.config.makeasy.usuario");
senha=p.getProperty("bd.config.makeasy.senha");
host = p.getProperty("bd.config.makeasy.host");
nome=p.getProperty("bd.config.makeasy.nome");
porta=p.getProperty("bd.config.makeasy.porta");
                
                
                //não esquecer de retirar os dados do driverManager e colocar as variaveis
                
                
			
                con = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+nome,usuario,senha);
                
                
		}
                catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null,"Arquivo não achado -"
                            + " se trata das configurações de propriedades. Verifique o erro.");
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
