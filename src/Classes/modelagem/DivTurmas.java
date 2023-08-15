/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.modelagem;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gabriel Rocha
 */
public class DivTurmas {
    //modelagem
    
    //serializable
    //utildao
    //construtor
    
    
    //1° CONSTRUTOR
    public DivTurmas(String nome_turma, String dia_semana, 
            Time horario_dia, String modalidade,
            int fk_prof_rp, int fk_aluno_ra  ){
        this.nome_turma = nome_turma;
        this.dia_semana = dia_semana;
        this.horario_dia = horario_dia;
        this.modalidade = modalidade;
        this.fk_prof_rp = fk_prof_rp;
        this.fk_aluno_ra = fk_aluno_ra;
    }
    
    //2° CONSTRUTOR
    public DivTurmas(){
    }
    
    
    
    //FORMATA DATA - nao sei se vou continuar esse method aqui
     public Date formataData(String data) throws ParseException{
        
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Data formatada: "  + data);
        
        return new Date(formatador.parse(data).getTime());
        
    }
    //FORMATA HORA
     
    public Time formatarHora(String hora) throws ParseException{

    DateFormat formatter = new SimpleDateFormat("HH:mm");
    return new Time(formatter.parse(hora).getTime());
 
    }
    
    
    /*abaixo o campo para preencher com o RA do aluno*/
    
    private int ra_verifica, ra_aluno1, ra_aluno2, ra_aluno3, ra_aluno4, ra_aluno5, ra_aluno6;

    public int getRa_verifica() {
        return ra_verifica;
    }

    public void setRa_verifica(int ra_verifica) {
        this.ra_verifica = ra_verifica;
    }

    public int getRa_aluno1() {
        return ra_aluno1;
    }

    public void setRa_aluno1(int ra_aluno1) {
        this.ra_aluno1 = ra_aluno1;
    }

    public int getRa_aluno2() {
        return ra_aluno2;
    }

    public void setRa_aluno2(int ra_aluno2) {
        this.ra_aluno2 = ra_aluno2;
    }

    public int getRa_aluno3() {
        return ra_aluno3;
    }

    public void setRa_aluno3(int ra_aluno3) {
        this.ra_aluno3 = ra_aluno3;
    }

    public int getRa_aluno4() {
        return ra_aluno4;
    }

    public void setRa_aluno4(int ra_aluno4) {
        this.ra_aluno4 = ra_aluno4;
    }

    public int getRa_aluno5() {
        return ra_aluno5;
    }

    public void setRa_aluno5(int ra_aluno5) {
        this.ra_aluno5 = ra_aluno5;
    }

    public int getRa_aluno6() {
        return ra_aluno6;
    }

    public void setRa_aluno6(int ra_aluno6) {
        this.ra_aluno6 = ra_aluno6;
    }
    
    
    /*Abaixo, o nome do professor e os nomes dos alunos.*/
    
    private String nomeProfessor, nomeAluno1, nomeAluno2, nomeAluno3, nomeAluno4, nomeAluno5, nomeAluno6;
    private String sobrenomeProf, sobrenomeAluno1, sobrenomeAluno2, sobrenomeAluno3, sobrenomeAluno4, sobrenomeAluno5, sobrenomeAluno6;

    /*Abaixo, temos o famoso RP, que sera usado em algum metodo na verificacao de dados*/
    
    private int rp_prof;

    public int getRp_prof() {
        return rp_prof;
    }

    public void setRp_prof(int rp_prof) {
        this.rp_prof = rp_prof;
    }
    
    public String getSobrenomeProf() {
        return sobrenomeProf;
    }

    public void setSobrenomeProf(String sobrenomeProf) {
        this.sobrenomeProf = sobrenomeProf;
    }

    public String getSobrenomeAluno1() {
        return sobrenomeAluno1;
    }

    public void setSobrenomeAluno1(String sobrenomeAluno1) {
        this.sobrenomeAluno1 = sobrenomeAluno1;
    }

    public String getSobrenomeAluno2() {
        return sobrenomeAluno2;
    }

    public void setSobrenomeAluno2(String sobrenomeAluno2) {
        this.sobrenomeAluno2 = sobrenomeAluno2;
    }

    public String getSobrenomeAluno3() {
        return sobrenomeAluno3;
    }

    public void setSobrenomeAluno3(String sobrenomeAluno3) {
        this.sobrenomeAluno3 = sobrenomeAluno3;
    }

    public String getSobrenomeAluno4() {
        return sobrenomeAluno4;
    }

    public void setSobrenomeAluno4(String sobrenomeAluno4) {
        this.sobrenomeAluno4 = sobrenomeAluno4;
    }

    public String getSobrenomeAluno5() {
        return sobrenomeAluno5;
    }

    public void setSobrenomeAluno5(String sobrenomeAluno5) {
        this.sobrenomeAluno5 = sobrenomeAluno5;
    }

    public String getSobrenomeAluno6() {
        return sobrenomeAluno6;
    }

    public void setSobrenomeAluno6(String sobrenomeAluno6) {
        this.sobrenomeAluno6 = sobrenomeAluno6;
    }
    
    
    
    
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

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

    public void setNomeAluno4(String nomeAluno34) {
        this.nomeAluno4 = nomeAluno34;
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
    
    
    
    
    
    
    
    
    
    /*private int cod_turma;
    
    Nao vamos usar o cod_turma. Ele eh apenas faxada para
    podermos criar a tabela e usar como PK o nome da turma.
    */
    
    private String nome_turma, dia_semana, modalidade;
    private Time horario_dia;
    private int fk_prof_rp, fk_aluno_ra;

    
    public String getNome_turma() {
        return nome_turma;
    }

    public void setNome_turma(String nome_turma) {
        this.nome_turma = nome_turma;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Time getHorario_dia() {
        return horario_dia;
    }

    public void setHorario_dia(Time horario_dia) {
        this.horario_dia = horario_dia;
    }

    public int getFk_prof_rp() {
        return fk_prof_rp;
    }

    public void setFk_prof_rp(int fk_prof_rp) {
        this.fk_prof_rp = fk_prof_rp;
    }

    public int getFk_aluno_ra() {
        return fk_aluno_ra;
    }

    public void setFk_aluno_ra(int fk_aluno_ra) {
        this.fk_aluno_ra = fk_aluno_ra;
    }
    
    
    
    
}
