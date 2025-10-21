public class Matricula {
    private String codigoDisciplina; // Atributo códigoDisciplina
    private double nota; // Atributo nota

    public Matricula(String codigoDisciplina, double nota) {
        this.codigoDisciplina = codigoDisciplina;
        this.nota = nota;
    }

    public String getCodigoDisciplina() { return codigoDisciplina; }
    public double getNota() { return nota; }
}