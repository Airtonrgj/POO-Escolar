import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeEstudantes {
        private String nome;
        private String matricula;
        private List<Double> notas;

        public ListaDeEstudantes(String nome, String matricula) {
            if (nome == null || nome.trim().isEmpty() || matricula == null || matricula.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome e matricula obrigatórios!");
            }
            this.nome = nome;
            this.matricula = matricula;
            this.notas = new ArrayList<>();
        }
}
