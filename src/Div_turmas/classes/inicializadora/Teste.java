/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Div_turmas.classes.inicializadora;

import Div_turmas.classes.dao.DivTurmasDAO;
import Div_turmas.classes.gui.AtualizarTurmasGUI;
import Div_turmas.classes.modelagem.DivTurmas;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Gabriel Rocha
 */
public class Teste {
    
    public static void main(String [] args) throws ParseException{
        
        //TESTANDO OS CONSTRUTORES/METODOS DE FORMATACAO
        
        DivTurmasDAO dao = new DivTurmasDAO();
        
        DivTurmas d = new DivTurmas();
        DivTurmas t = new DivTurmas();
        
        /*
        DivTurmas d = new DivTurmas();

        String data = "1/2/1990";
        d.formataData(data);  
        
        String hora = "08:00";
        
        d.setHorario_dia(d.formatarHora(hora));
        System.out.println("horario cadastrado: " + d.getHorario_dia());
        
        
        //outra maneira de inserir dados com construtores e metodos
        DivTurmas d2 = new DivTurmas("","",d.formatarHora(hora),"", 1, 2);
        */
        //_____________________________________________________________

        
        
        //TESTANDO OS METODOS DE CRUD - COM O BANCO DE DADOS
       

       
        /*

        
        //Time tempo = "08:00";
        String tempo2 = "09:00";
       
        d.setNome_turma("Turma A");
        d.setDia_semana("Segunda-feira");
        d.setHorario_dia(d.formatarHora(tempo2));
        d.setModalidade("Inglês básico");
        d.setFk_prof_rp(1);
        d.setFk_aluno_ra(2);
        
        
        //dao.insert(d);
        
        //dao.select(d);
        
        dao.delete(d);
        
        */
        
        
        
        /*
        d.setNome_turma("Turma 77");
        d.setDia_semana("Segunda-feira");
        d.setHorario_dia(d.formatarHora("08:00"));
        d.setModalidade("Inglês básico");
        
        dao.insertCriaTurma(d);
        
        */
        
       //d.setNome_turma("Turma A");
       
       /*
       
        dao.selectDadosTurma(d);
        
        System.out.println("Nome: " + d.getNome_turma());
        
        //System.out.println("Dia: " +  d.getDia_semana());
       
        System.out.println("Horario: " + d.getHorario_dia());
        
        //System.out.println("Modalidade: " +d.getModalidade() );
        
        //System.out.println("Prof: " +d.getFk_prof_rp() );
        
        //System.out.println("Aluno: " + d.getFk_aluno_ra());
        
       */

       /*
       
        dao.Select(d, "Marivone");
        
        System.out.println("Nome: " + d.getNome_turma());
        
        System.out.println("Dia: " +  d.getDia_semana());
       
        System.out.println("Horario: " + d.getHorario_dia());
        
        System.out.println("Modalidade: " +d.getModalidade() );
        
        System.out.println("Prof: " +d.getFk_prof_rp() );
        
        System.out.println("Aluno: " + d.getFk_aluno_ra());
        
        
       
       
       dao.verificaProfessorEmTurmas(d, "Turma A");
       
       dao.verificaAlunosEmTurmas(d, "Turma A");
       
        //dao.verificaEspacoTurma(d, "Dayana");
       
        */
       
        
        //dao.retornaRP(d, "José");
        //dao.retornaRPcadastrado(d, "Turma X");
        //d.getFk_prof_rp();
        
        //dao.preencheTextFieldsComAlunos(d, "Turma 1");
        AtualizarTurmasGUI atg = new AtualizarTurmasGUI();
        
        atg.preencheTextFieldsComAlunos(d, "Turma Primeira");
        
        
        
    }
    
}
