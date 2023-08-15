/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronograma.Classes.Iniciadora;

import Cronograma.Classes.DAO.CronogramaDAO;
import javax.swing.JOptionPane;



/**
 *
 * @author Gabriel Rocha
 */
public class Teste {
    public static void main(String [] args){
        
        
        String teste[][] = new String[7][14];
        
        /*
        
        
        //6 = 0,1,2,3,4,5
        //14 = 0,1,2...13
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 14; j++){
                
                teste[i][j] = JOptionPane.showInputDialog(null, teste[i][j] = "teste" );
                
            }
            
        }
        
        
        
        
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 14; j++){
             
                System.out.println("Dados da matriz: " + teste[i][j] + " - posicao da matriz: " + i +","+ j);   

            }
            
        }
        */
        
        CronogramaDAO cd = new CronogramaDAO();
        
       // System.out.println("Nome da turma: " + cd.trazTurmasPirmeiroDiaHorario("Segunda-feira", "10:00:00"));
        
        /*
        
        for(int i = 8; i< 22; i++){
            
            String hora = i + ":00";
            
            System.out.println("Horario + " + hora);
            
        }
        
        String valorEntrada1 = "Segunda-feira";
        
        if(valorEntrada1 == "Segunda-feira"){
            
            for(int i = 8; i < 22; i++){
                
            String hora = i + ":00:00";
            
            System.out.println("Horario + " + hora);
            
            }
            
        }
        
        */
/*        
        for(int i = 8; i < 22; i++){
                
                String hora = i + ":00:00";
     
                for(int l = 0; l < 14; l++){
                //linhas = horarios
                //coluans - dias
                
                    for(int co = 1; co < 7; co++){
                    //System.out.println("turma: + " + hora +"-"+ l +"-" +co);
                    
                    System.out.println("nome da turma: " + cd.trazTurmasSegundoDieSemanaHorario("Segunda-feira", hora) + " | horario: " + hora + " | dia da semana: " + "Segunda-feira " + " | linha: " + l + " | coluna: " + co);
      
                    }
                }
        }
*/

           /*
            for(int i = 8; i < 22; i++){
               
                String hora = " hora: " +i + ":00:00";
                
                System.out.println(hora);
                
                for(int l = 0; l < 14; l++){
                    
                    System.out.println("linha: " + l + hora);
                    
                }
                
            }
            */
           /*
          int hora = 8; 
            int linha = 0;
            //int coluna = 0;
            String horaCerta = null;
            while(hora < 22 && linha < 14 ){
                
                System.out.println("linha: " + linha + " | hora: "+ hora + " | horaCerta: " + horaCerta);
                horaCerta = hora + ":00:00";
                //dtm.setValueAt(horaCerta, linha, 0);
                
                hora = hora + 1;
                
                linha = linha + 1;
                
                
                
            }
           */
            /*
            if(hora < 22 && linha <14){
                hora = hora + 1;
                linha = linha + 1;
                
                System.out.println("linha: " + linha + " | hora: "+ hora);
                        
            }
            */
            
            //Object nullo= null;
            
             System.out.println(cd.trazTurmasBaseQuatro("Segunda-feira", "08:00:00", null, null));
             System.out.println(cd.trazTurmasBaseQuatro(null, null , "Terça-feira", "20:00:00"));
             
             //System.out.println(cd.trazTurmasBaseQuatro("Segunda-feira", "20:00:00", null, null));
             //System.out.println(cd.trazTurmasBaseQuatro(null, null , "Terça-feira" , "10:00:00"));
             
             System.out.println(cd.trazTurmasPirmeiroDiaHorario("Segunda-feira", "08:00:00"));
             System.out.println(cd.trazTurmasSegundoDieSemanaHorario("Segunda-feira", "10:00:00"));
             
             
             
            
            //3	Turma da Galera	Segunda-feira	08:00:00	Inglês Intermediário	Terça-feira	08:00:00
        
    }
}
