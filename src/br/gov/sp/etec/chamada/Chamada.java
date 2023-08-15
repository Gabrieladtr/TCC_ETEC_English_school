/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.chamada;

/**
 *
 * @author Edson
 */
public class Chamada {
    
     
    private String nome;
    private String nomeTurma;
    private String nomeAluno1, nomeAluno2, nomeAluno3, nomeAluno4, nomeAluno5, nomeAluno6;
    private String data_chamada;
    private double frequencia;

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public String getData_chamada() {
        return data_chamada;
    }

    public void setData_chamada(String data_chamada) {
        this.data_chamada = data_chamada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isPrensenca() {
        return prensenca;
    }

    public void setPrensenca(boolean prensenca) {
        this.prensenca = prensenca;
    }
    private String status;
    private String observacao;
    private boolean prensenca;
    

    public String getNomeAluno1() {
        return nomeAluno1;
    }

    public void setNomeAluno1(String nomeAluno1) {
        this.nomeAluno1 = nomeAluno1;
    }

    public String getNomeAluno2() {
        return nomeAluno2;
    }

    public void setNomeAluno2(String nomeAluno2) {
        this.nomeAluno2 = nomeAluno2;
    }

    public String getNomeAluno3() {
        return nomeAluno3;
    }

    public void setNomeAluno3(String nomeAluno3) {
        this.nomeAluno3 = nomeAluno3;
    }

    public String getNomeAluno4() {
        return nomeAluno4;
    }

    public void setNomeAluno4(String nomeAluno4) {
        this.nomeAluno4 = nomeAluno4;
    }

    public String getNomeAluno5() {
        return nomeAluno5;
    }

    public void setNomeAluno5(String nomeAluno5) {
        this.nomeAluno5 = nomeAluno5;
    }

    public String getNomeAluno6() {
        return nomeAluno6;
    }

    public void setNomeAluno6(String nomeAluno6) {
        this.nomeAluno6 = nomeAluno6;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNomeTurma(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
