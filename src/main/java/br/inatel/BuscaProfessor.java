package br.inatel;

import com.google.gson.Gson;

public class BuscaProfessor {
    ProfessorService professorService;

    public BuscaProfessor(ProfessorService professorService) {
        this.professorService = professorService;
    }

    public Professor buscaProfessor(String nome) throws InvalidPersonNameException {
        String iniJson = professorService.busca(nome);
        return new Gson().fromJson(iniJson, Professor.class);
    }
}
