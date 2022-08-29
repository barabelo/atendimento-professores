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
}
