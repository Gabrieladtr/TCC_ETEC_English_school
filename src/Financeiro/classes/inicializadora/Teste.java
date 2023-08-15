/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro.classes.inicializadora;

import Financeiro.classes.modeladora.CadastroContas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Rocha
 */
public class Teste {
    public static void main(String [] args){
        
        
    
        CadastroContas cc = new CadastroContas();
    
        Date date = new Date();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            
            date = sdt.parse("12/12/2000");
            
        } catch (ParseException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Minha data " + sdt.format(date));
        
    
    }
}
