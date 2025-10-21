import java.util.*;
import java.util.stream.Collectors;

public class ListaEstudantes {
    private List<Estudante> estudantes = new ArrayList<>(); // Implementação List

    public void adicionarEstudante(Estudante e) {
        this.estudantes.add(e);
    }

    // Corrigido para remover usando a matrícula String
    public boolean removerEstudantePorMatricula(String matricula) {
        return this.estudantes.removeIf(e -> e.getMatricula().equals(matricula));
    }

    public Estudante obterEstudantePorIndice(int indice) {
        if (indice >= 0 && indice < estudantes.size()) {
            return estudantes.get(indice);
        }
        return null;
    }

    public List<Estudante> buscarEstudantesPorNome(String substring) {
        String lowerCaseSubstring = substring.toLowerCase();
        return estudantes.stream()
                .filter(e -> e.getNome().toLowerCase().contains(lowerCaseSubstring)) // case-insensitive
                .collect(Collectors.toList());
    }

    public List<Estudante> ordenarEstudantesPorNome() {
        this.estudantes.sort(Comparator.comparing(Estudante::getNome)); // ordena a lista alfabeticamente
        return this.estudantes;
    }

    public List<Estudante> getEstudantes() {
        return this.estudantes;
    }

    public Estudante buscarEstudantePorMatricula(String matricula) {
        return estudantes.stream().filter(e -> e.getMatricula().equals(matricula)).findFirst().orElse(null);
    }
}