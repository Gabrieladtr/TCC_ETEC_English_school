/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.model;

/**
 *
 * @author Edson
 */
public class Categoria {
    
    private int id_cat;
    private String descricaoC;
    private String tipo;
   
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricaoC() {
        return descricaoC;
    }

    public void setDescricaoC(String descricaoC) {
        this.descricaoC = descricaoC;
    }
     public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    @Override
    public String toString() {
        return getDescricaoC(); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
