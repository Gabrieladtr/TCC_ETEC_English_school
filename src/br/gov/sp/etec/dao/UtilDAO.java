/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author Edson
 */


//Essa classe tenta estabelecer a conexao com o servidor sql

public class UtilDAO
{

     public static Connection conectar()
     {
	    Connection con = null;

	    try{

            String host = "";
            int porta = 0;
            String nome = "";
            String usuario = "";
            String senha = "";
            
            try {
                Properties p = new Properties();
                FileInputStream fis = new FileInputStream("propriedades/config.properties");
                p.load(fis);
                host = p.getProperty("bd.config.host");
                usuario = p.getProperty("bd.config.user");
                senha = p.getProperty("bd.config.senha");
                porta = Integer.parseInt(p.getProperty("bd.config.porta"));
                nome = p.getProperty("bd.config.nome");
                }

                catch (FileNotFoundException ex)
                {
                    System.out.println("Arquivo não encontrado na propriedades/config.properties");

                }
                
                catch (IOException ex)
                {
                    System.out.println("falha na leitura do arquivo propriedades/config.properties ");
                }
                
                //con = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ porta +"/"+ nome, usuario, senha);
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + nome + "?characterEncoding=utf8", usuario, senha);
                //con = DriverManager.getConnection("jdbc:mysql://"+ "localhost" +":"+ "3306" +"/"+ "makeasy", "root", "");

                
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Não conectou com o banco de dados. V2");
            ex.printStackTrace();
        }

        return con;
    }
     
}
