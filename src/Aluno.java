import java.util.List;
import java.util.stream.Collectors;

public class Aluno {
        private String nome;
        private String matricula;
        private List<Double> notas;

        public Aluno(String nome, String matricula) {
            if (nome == null || nome.isBlank() || matricula == null || matricula.isBlank()) {
                throw new IllegalArgumentException("Nome e matricula obrigatórios!");
            }
            this.nome = nome;
            this.matricula = matricula;
        }

        public String getNome() {
            return nome;
        }

        public String getMatricula() {
            return matricula;
        }

        public List<Double> getNotas() {
            return List.copyOf(notas);
        }

        public void adcionarNota(double nota) {
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("A nota deve ser entre 0 e 10!");
            }
            notas.add(nota);
        }

        public double calulaMedia() {
            if (notas.isEmpty()) {
                return 0.0;
            }
            double soma = 0.0;

            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        }

        public boolean aprovado(double mediaAprovacao) {
            return calulaMedia() >= mediaAprovacao;
        }

        @Override
        public String toString() {
            String notasStr = notas.isEmpty()
                    ? "Nenhuma nota no sistema!"
                    : notas.stream()
                    .map(n -> String.format("%.1f", n))
                    .collect(Collectors.joining(", "));

            return String.format("""
                Matrícula: %s
                Nome: %s
                Notas: [%s]
                Média: %.2f
                Aprovado (Média 7.0): %s
                """,
                    matricula,
                    nome,
                    notasStr,
                    calulaMedia(),
                    aprovado(7.0) ? "Sim" : "Não"
            );
        }
}
