import java.util.Objects;

public class Estudante {
    private String nome;
    private String matricula; // ID é String (matricula) para compatibilidade

    public Estudante(String nome, String matricula) {
        if (nome == null || nome.isBlank() || matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Nome e matricula obrigatórios!");
        }
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; } // Usado como ID em HistoricoNotas

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudante)) return false;
        Estudante that = (Estudante) o;
        return Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() { return Objects.hash(matricula); }

    @Override
    public String toString() { return "Matrícula: " + matricula + ", Nome: " + nome; }
}