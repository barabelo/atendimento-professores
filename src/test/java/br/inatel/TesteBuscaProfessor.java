package br.inatel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaProfessor {

    @Mock
    private ProfessorService service;
    private BuscaProfessor buscaProfessor;

    @Before
    public void setup() {
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void buscaProfessorJoaquimSilva() {
        Mockito.when(service.busca("Joaquim Silva")).thenReturn(ProfessorConst.JOAQUIM_SILVA);
        Professor joaquimSilva = buscaProfessor.buscaProfessor("Joaquim Silva");
        assertEquals("Joaquim Silva", joaquimSilva.getNomeDoProfessor());
        assertEquals("Quarta das 13h30min às 17h10min", joaquimSilva.getHorarioDeAtendimento());
        assertEquals("integral", joaquimSilva.getPeriodo());
    }

    @Test
    public void buscaProfessorMarcosPereira() {
        Mockito.when(service.busca("Marcos Pereira")).thenReturn(ProfessorConst.MARCOS_PEREIRA);
        Professor marcosPereira = buscaProfessor.buscaProfessor("Marcos Pereira");
        assertEquals("Marcos Pereira", marcosPereira.getNomeDoProfessor());
        assertEquals("Terça das 19h30min às 21h10min", marcosPereira.getHorarioDeAtendimento());
        assertEquals("noturno", marcosPereira.getPeriodo());
    }

    @Test
    public void buscaProfessorCarlosMagno() {
        Mockito.when(service.busca("Carlos Magno")).thenReturn(ProfessorConst.CARLOS_MAGNO);
        Professor carlosMagno = buscaProfessor.buscaProfessor("Carlos Magno");
        assertEquals("Carlos Magno", carlosMagno.getNomeDoProfessor());
        assertEquals("Quinta das 10h às 11h40min", carlosMagno.getHorarioDeAtendimento());
        assertEquals("integral", carlosMagno.getPeriodo());
    }

    @Test
    public void buscaProfessorNaoCadastradoNoServidorRemoto() {
        Mockito.when(service.busca("Júlio Cesar")).thenReturn(ProfessorConst.NAO_ENCONTRADO);
        Professor julioCesar = buscaProfessor.buscaProfessor("Júlio Cesar");
        assertEquals("Não Encontrado", julioCesar.getNomeDoProfessor());
        assertEquals("Não Encontrado", julioCesar.getHorarioDeAtendimento());
        assertEquals("Não Encontrado", julioCesar.getPeriodo());
    }

    @Test
    public void buscaProfessorComNomeInvalido() {
        Mockito.when(service.busca("12345")).thenReturn(ProfessorConst.NOME_INVALIDO);
        Professor professorComNomeInvalido = buscaProfessor.buscaProfessor("12345");
        assertEquals("Nome Inválido", professorComNomeInvalido.getNomeDoProfessor());
        assertEquals("Nome Inválido", professorComNomeInvalido.getHorarioDeAtendimento());
        assertEquals("Nome Inválido", professorComNomeInvalido.getPeriodo());
    }

    @Test
    public void buscaProfessorComNomeVazio() {
        Mockito.when(service.busca("")).thenReturn(ProfessorConst.NOME_VAZIO);
        Professor professorComNomeVazio = buscaProfessor.buscaProfessor("");
        assertEquals("Nome Vazio", professorComNomeVazio.getNomeDoProfessor());
        assertEquals("Nome Vazio", professorComNomeVazio.getHorarioDeAtendimento());
        assertEquals("Nome Vazio", professorComNomeVazio.getPeriodo());
    }
}

class ProfessorConst {
    public static String JOAQUIM_SILVA =
            "{ \"nomeDoProfessor\": \"Joaquim Silva\", \n " +
                    "\"horarioDeAtendimento\": \"Quarta das 13h30min às 17h10min\", \n " +
                    "\"periodo\": \"integral\" }";

    public static String MARCOS_PEREIRA =
            "{ \"nomeDoProfessor\": \"Marcos Pereira\", \n " +
                    "\"horarioDeAtendimento\": \"Terça das 19h30min às 21h10min\", \n " +
                    "\"periodo\": \"noturno\" }";

    public static String CARLOS_MAGNO =
            "{ \"nomeDoProfessor\": \"Carlos Magno\", \n " +
                    "\"horarioDeAtendimento\": \"Quinta das 10h às 11h40min\", \n " +
                    "\"periodo\": \"integral\" }";

    public static String NAO_ENCONTRADO =
            "{ \"nomeDoProfessor\": \"Não Encontrado\", \n " +
                    "\"horarioDeAtendimento\": \"Não Encontrado\", \n " +
                    "\"periodo\": \"Não Encontrado\" }";

    public static String NOME_INVALIDO =
            "{ \"nomeDoProfessor\": \"Nome Inválido\", \n " +
                    "\"horarioDeAtendimento\": \"Nome Inválido\", \n " +
                    "\"periodo\": \"Nome Inválido\" }";

    public static String NOME_VAZIO =
            "{ \"nomeDoProfessor\": \"Nome Vazio\", \n " +
                    "\"horarioDeAtendimento\": \"Nome Vazio\", \n " +
                    "\"periodo\": \"Nome Vazio\" }";
}
