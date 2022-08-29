package br.inatel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteBuscaProfessor {

    private ProfessorService service;
    private BuscaProfessor buscaProfessor;

    @Before
    public void setup() {
        service = new MockProfessorService();
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testeBuscaProfessorJoaquimSilva() {
        Professor joaquimSilva = buscaProfessor.buscaProfessor("Joaquim Silva");
        assertEquals("Joaquim Silva", joaquimSilva.getNomeDoProfessor());
        assertEquals("Quarta das 13h30min às 17h10min", joaquimSilva.getHorarioDeAtendimento());
        assertEquals("integral", joaquimSilva.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorMarcosPereira() {
        Professor marcosPereira = buscaProfessor.buscaProfessor("Marcos Pereira");
        assertEquals("Marcos Pereira", marcosPereira.getNomeDoProfessor());
        assertEquals("Terça das 19h30min às 21h10min", marcosPereira.getHorarioDeAtendimento());
        assertEquals("noturno", marcosPereira.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorCarlosMagno() {
        Professor carlosMagno = buscaProfessor.buscaProfessor("Carlos Magno");
        assertEquals("Carlos Magno", carlosMagno.getNomeDoProfessor());
        assertEquals("Quinta das 10h às 11h40min", carlosMagno.getHorarioDeAtendimento());
        assertEquals("integral", carlosMagno.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorNaoCadastradoNoServidorRemoto() {
        Professor fulanoBeltrano = buscaProfessor.buscaProfessor("Fulano Beltrano");
        assertEquals("Não Encontrado", fulanoBeltrano.getNomeDoProfessor());
        assertEquals("Não Encontrado", fulanoBeltrano.getHorarioDeAtendimento());
        assertEquals("Não Encontrado", fulanoBeltrano.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorComNomeInvalido() {
        Professor professorComNomeInvalido = buscaProfessor.buscaProfessor("12345");
        assertEquals("Nome Inválido", professorComNomeInvalido.getNomeDoProfessor());
        assertEquals("Nome Inválido", professorComNomeInvalido.getHorarioDeAtendimento());
        assertEquals("Nome Inválido", professorComNomeInvalido.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorComNomeVazio() {
        Professor professorComNomeVazio = buscaProfessor.buscaProfessor("");
        assertEquals("Nome Vazio", professorComNomeVazio.getNomeDoProfessor());
        assertEquals("Nome Vazio", professorComNomeVazio.getHorarioDeAtendimento());
        assertEquals("Nome Vazio", professorComNomeVazio.getPeriodo());
    }
}

