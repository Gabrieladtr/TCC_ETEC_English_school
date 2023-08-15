/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financeiro.classes.modeladora;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class CadastroContas {
    
    /*Essa classe sera usada para cadastrar as contas*/
    
    private int id_conta;
    private double valor;
    private String descricaoA;
    private String data_lancamento;
    private String tipo;
    private String categoria;
    

        //FORMATA DATA - nao sei se vou continuar esse method aqui
     public java.util.Date formataData(String data) throws ParseException{

        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return new java.util.Date(formatador.parse(data).getDate());
        
    }
    
     
    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }


    public String getDescricaoA() {
        return descricaoA;
    }

    public void setDescricaoA(String descricaoA) {
        this.descricaoA = descricaoA;
    }
    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
   
}
