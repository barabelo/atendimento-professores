package br.inatel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaProfessor {
    ProfessorService professorService;

    public BuscaProfessor(ProfessorService professorService) {
        this.professorService = professorService;
    }

    public Professor buscaProfessor(String nome) throws InvalidPersonNameException {
        String iniJson = professorService.busca(nome);
        JsonObject jsonObject = JsonParser.parseString(iniJson).getAsJsonObject();

        return new Professor(jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString());
    }
}
