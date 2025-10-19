import java.util.*;

public class GerenciarAlunos {
    private List<Aluno> listaAlunos;
    private Map<String, Aluno> mapaAlunos;

    public GerenciarAlunos() {
        this.listaAlunos = new ArrayList<>();
        this.mapaAlunos = new HashMap<>();
    }

    public void incluirAluno(Aluno aluno) {
        Objects.requireNonNull(aluno, "O aluno não pode ser nulo.");

        if (mapaAlunos.containsKey(aluno.getMatricula())) {
            System.out.printf("Já existe um aluno com a matrícula %s!%n", aluno.getMatricula());
            return;
        }

        listaAlunos.add(aluno);
        mapaAlunos.put(aluno.getMatricula(), aluno);
        System.out.printf("Aluno '%s' incluído com sucesso!%n", aluno.getNome());
    }

    public void removerAluno(String matricula) {
        Aluno removeAluno = mapaAlunos.get(matricula);

        if (removeAluno != null) {
            listaAlunos.remove(removeAluno);
            mapaAlunos.remove(matricula);
            System.out.println("Aluno " + removeAluno.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Erro: Aluno com a matrícula " + matricula + " não encontrado.");
        }
    }

    public Aluno buscarAluno(String matricula) {
        return mapaAlunos.get(matricula);
    }

    public void adicionarNotaDoAluno(String matricula, double nota) {
        Aluno aluno = buscarAluno(matricula);
        if (aluno != null) {
            aluno.adcionarNota(nota);
            System.out.println("Nota adicionada ao aluno " + aluno.getNome());
        } else {
            System.out.println("Erro: Aluno com a matrícula " + matricula + " não encontrado para adicionar nota.");
        }
    }

    public void listarAlunos() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE ALUNOS ---");
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno);
        }
        System.out.println("------------------------\n");
    }

    public void ordenarPorNome() {
        Collections.sort(listaAlunos, Comparator.comparing(Aluno::getNome));
        System.out.println("Lista de alunos ordenada por nome.");
    }

    public void ordenarPorMedia() {
        Collections.sort(listaAlunos, Comparator.comparingDouble(Aluno::calulaMedia).reversed());
        System.out.println("Lista de alunos ordenada por média.");
    }
}
