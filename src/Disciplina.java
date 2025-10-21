import java.util.Objects;

public class Disciplina implements Comparable<Disciplina> {
    private String codigo; // Atributo código
    private String nome; // Atributo nome

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(codigo, that.codigo); // Unicidade baseada no código
    }

    @Override
    public int hashCode() { return Objects.hash(codigo); }
    @Override
    public int compareTo(Disciplina o) { return this.codigo.compareTo(o.codigo); }
    @Override
    public String toString() { return codigo + " - " + nome; }
}