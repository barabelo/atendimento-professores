package br.inatel;

public class MockProfessorService implements ProfessorService {
    @Override
    public String busca(String nome) {
        if (nome.equals("Joaquim Silva")) {
            return ProfessorConst.JOAQUIM_SILVA;
        } else if (nome.equals("Marcos Pereira")) {
            return ProfessorConst.MARCOS_PEREIRA;
        } else if (nome.equals("Carlos Magno")) {
            return ProfessorConst.CARLOS_MAGNO;
        } else if (nome.equals("Fulano Beltrano")) {
            return ProfessorConst.NAO_ENCONTRADO;
        } else if (nome.equals("12345")) {
            return ProfessorConst.NOME_INVALIDO;
        } else if (nome.equals("")) {
            return ProfessorConst.NOME_VAZIO;
        } else {
            throw new RuntimeException();
        }
    }
}
