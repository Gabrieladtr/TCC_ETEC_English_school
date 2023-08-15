/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronograma.Classes.Modelagem;

import java.sql.Array;

/**
 *
 * @author wesley
 */
public class Cronograma {
    
    //podemos criar diversos campos ou fazer uma matriz.   
   
/*
    
    public String[][] getTurmaEspecifica() {
        return turmaEspecifica;
    }

    public void setTurmaEspecifica(String[][] turmaEspecifica) {
        this.turmaEspecifica = turmaEspecifica;
    }
  */
    String  turmaEspecifica[][] = new String[6][14];
    
    public void preencheCronograma(int valorLinha, int valorColuna, String dado){
        //Cronograma c = new Cronograma();
        
          String  turmaEspecifica[][] = new String[6][14];
          
          turmaEspecifica[valorLinha][valorColuna] = dado;

    }
    
    private String caminho_dado;

    public String getCaminho_dado() {
        return caminho_dado;
    }

    public void setCaminho_dado(String caminho_dado) {
        this.caminho_dado = caminho_dado;
    }
    
    private String nomeTurma;

    public String[][] getTurmaEspecifica() {
        return turmaEspecifica;
    }

    public void setTurmaEspecifica(String[][] turmaEspecifica) {
        this.turmaEspecifica = turmaEspecifica;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    
   
    
}