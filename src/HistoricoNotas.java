import java.util.*;
import java.util.stream.Collectors;

public class HistoricoNotas {
    // CORRIGIDO: Chave é String (Matrícula) para compatibilidade
    private Map<String, List<Matricula>> notasPorEstudante = new HashMap<>(); // Implementação Map
    private ListaEstudantes listaEstudantes;

    public HistoricoNotas(ListaEstudantes listaEstudantes) {
        this.listaEstudantes = listaEstudantes;
    }

    // ID alterado para String matricula
    public void adicionarMatricula(String matriculaEstudante, String codigoDisciplina, double nota) {
        Matricula novaMatricula = new Matricula(codigoDisciplina, nota);
        notasPorEstudante.computeIfAbsent(matriculaEstudante, k -> new ArrayList<>()).add(novaMatricula);
    }

    public List<Matricula> obterMatriculas(String matriculaEstudante) { return notasPorEstudante.getOrDefault(matriculaEstudante, Collections.emptyList()); }
    public Optional<Double> obterNota(String matriculaEstudante, String codigoDisciplina) {
        return notasPorEstudante.getOrDefault(matriculaEstudante, Collections.emptyList()).stream()
                .filter(m -> m.getCodigoDisciplina().equals(codigoDisciplina))
                .map(Matricula::getNota)
                .findFirst();
    }
    public boolean removerMatricula(String matriculaEstudante, String codigoDisciplina) {
        List<Matricula> matriculas = notasPorEstudante.get(matriculaEstudante);
        if (matriculas == null) return false;
        return matriculas.removeIf(m -> m.getCodigoDisciplina().equals(codigoDisciplina));
    }

    // Sua Função: Média do Estudante
    public double mediaDoEstudante(String matriculaEstudante) {
        List<Matricula> matriculas = obterMatriculas(matriculaEstudante);
        if (matriculas.isEmpty()) return 0.0;
        return matriculas.stream().mapToDouble(Matricula::getNota).average().orElse(0.0);
    }

    // Sua Função: Média da Disciplina
    public double mediaDaDisciplina(String codigoDisciplina) {
        List<Matricula> todasMatriculas = notasPorEstudante.values().stream()
                .flatMap(List::stream) // Achatando todas as listas de matrículas
                .filter(m -> m.getCodigoDisciplina().equalsIgnoreCase(codigoDisciplina))
                .collect(Collectors.toList());
        if (todasMatriculas.isEmpty()) return 0.0;
        return todasMatriculas.stream().mapToDouble(Matricula::getNota).average().orElse(0.0);
    }

    // Sua Função: Top N Estudantes
    public List<Estudante> topNEstudantesPorMedia(int N) {
        Map<Estudante, Double> medias = listaEstudantes.getEstudantes().stream()
                .collect(Collectors.toMap(
                        estudante -> estudante,
                        // Chama mediaDoEstudante com a matrícula String
                        estudante -> mediaDoEstudante(estudante.getMatricula())
                ));

        return medias.entrySet().stream()
                .sorted(Map.Entry.<Estudante, Double>comparingByValue().reversed()) // Decrescente
                .limit(N)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public Map<String, List<Matricula>> getNotasPorEstudante() { return notasPorEstudante; }
}