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
public class Relatorios {
 private String categoria;    
 private String tipo;    
 private String dataformatada1;    
 private String dataformatada2;    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataformatada1() {
        return dataformatada1;
    }

    public void setDataformatada1(String dataformatada1) {
        this.dataformatada1 = dataformatada1;
    }

    public String getDataformatada2() {
        return dataformatada2;
    }

    public void setDataformatada2(String dataformatada2) {
        this.dataformatada2 = dataformatada2;
    }
 private String subcategoria;    
 private String descricao;   
 private double valor;    
 private String data_lancamento;    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
}
