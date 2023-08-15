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
public class Login {
    
    private String email;
    private String senha;
    private String nivel;
    private Professor rp;
    
    public Professor getRp() {
        return rp;
    }

    public void setRp(Professor rp) {
        this.rp = rp;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
   
}
