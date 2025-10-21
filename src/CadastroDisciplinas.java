import java.util.*;
import java.util.stream.Collectors;

public class CadastroDisciplinas {
    // LinkedHashSet para manter a ordem de inserção (requisito do PDF)
    private Set<Disciplina> disciplinas = new LinkedHashSet<>();

    public CadastroDisciplinas() {
        // Construtor limpo
    }

    // Método obrigatório: adicionarDisciplina (ignorar duplicadas)
    public void adicionarDisciplina(Disciplina d) {

        // 1. CHECAGEM POR CÓDIGO (Set garante a unicidade, mas verificamos a existência antes)
        if (disciplinas.contains(d)) {
            System.out.println("[Duplicata Detectada] Disciplina com código " + d.getCodigo() + " já existe. Ignorada.");
            return;
        }

        // 2. CHECAGEM POR NOME (Correção para o erro de runtime)
        // Verifica se já existe alguma disciplina com o mesmo nome (case-insensitive)
        if (disciplinas.stream().anyMatch(disc -> disc.getNome().equalsIgnoreCase(d.getNome()))) {
            System.out.println("[Duplicata Detectada] Disciplina com nome '" + d.getNome() + "' já existe. Ignorada.");
            return;
        }

        // 3. Adiciona ao Set (se passou nas duas checagens)
        if (disciplinas.add(d)) {
            // Mensagem opcional de sucesso
        }
    }

    // Método obrigatório: verificarDisciplina
    public boolean verificarDisciplina(String codigo) {
        return disciplinas.stream().anyMatch(d -> d.getCodigo().equals(codigo));
    }

    // Método obrigatório: removerDisciplina
    public boolean removerDisciplina(String codigo) {
        return disciplinas.removeIf(d -> d.getCodigo().equals(codigo));
    }

    // Método obrigatório: obterTodasDisciplinas
    public Set<Disciplina> obterTodasDisciplinas() {
        // Retorna uma nova instância para proteger a lista interna e manter a ordem
        return new LinkedHashSet<>(disciplinas);
    }
}