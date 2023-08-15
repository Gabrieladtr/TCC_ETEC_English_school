/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.etec.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Edson
 */
public class Aluno {
    
    
  private int ra;  
  private String nome;  
  private String sobrenome;
  private String sexo;
  private String cpf;
  private String rg;
  private String nivelI;
  private String data_nasc;  
  private String tel_fixo;
  private String tel_celular;

    public String getTel_fixo() {
        return tel_fixo;
    }

    public void setTel_fixo(String tel_fixo) {
        this.tel_fixo = tel_fixo;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }
    
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNivelI() {
        return nivelI;
    }

    public void setNivelI(String nivelI) {
        this.nivelI = nivelI;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    
public static int calculaIdade(java.util.Date dataNasc){
Calendar dateOfBirth = new GregorianCalendar();
dateOfBirth.setTime(dataNasc);
// Cria um objeto calendar com a data atual
Calendar today = Calendar.getInstance();
// Obtém a idade baseado no ano
int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
dateOfBirth.add(Calendar.YEAR, age);
//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
if (today.before(dateOfBirth)) {
age--;

}
return age;
}
    }
