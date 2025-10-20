import java.util.*;

public class CadastroDisciplinas { // O problema de fazer o trabalho cegamente... nao sabia tao bem dos requisitos
    private String nome_disciplina; // My bad meu povo, errei fui mt mlk
    private String codigo_disciplina;
    private Set<Disciplina> disciplinas = new LinkedHashSet<>();


    public CadastroDisciplinas(){ // Construtor da classe
        this.nome_disciplina = nome_disciplina;
        this.codigo_disciplina = codigo_disciplina;
    }

    public String getNome_disciplina(){ // Getters
        return nome_disciplina;
    }

    public String getCodigo_disciplina() {
        return codigo_disciplina;
    }

    public void adicionarDisciplina(Disciplina d) { // Add Disciplina
        if (!disciplinas.add(d)) {
            System.out.println("A disciplina com código '" + d.getCodigo() + "' já existe. Ignorada.");
        } else {
            System.out.println("Disciplina adicionada: " + d);
        }
    }

    public void removerDisciplina(String codigo) { // Remove Disciplina por Código
        Disciplina removerDisciplina = disciplinas.stream()
                .filter(d -> d.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
        if (removerDisciplina != null) {
            disciplinas.remove(removerDisciplina);
            System.out.println("Disciplina removida: " + removerDisciplina);
        } else {
            System.out.println("Disciplina com código '" + codigo + "' não encontrada.");
        }
    }

    public Set<Disciplina> obterTodasDisciplinas() {
        return new LinkedHashSet<>(disciplinas);
    }

    public void menuDisciplina() { // Função do Menu
        Scanner input_menudiscip = new Scanner(System.in);
        int menu_disciplina_op;
        do{
            System.out.println("----------------------------");
            System.out.println("GESTÃO DE DISCIPLINAS - Escolha uma das opções:");
            System.out.println("1 -- Adicionar disciplina");
            System.out.println("2 -- Listar disciplinas");
            System.out.println("3 -- Remover disciplina");
            System.out.println("4 -- Retornar ao Menu Principal");
            System.out.println("----------------------------");
            menu_disciplina_op = input_menudiscip.nextInt();
            input_menudiscip.nextLine();
            switch (menu_disciplina_op) {
                case 1:
                    System.out.println("Insira o nome da nova disciplina");
                    String nome_disc = input_menudiscip.nextLine();
                    System.out.println("Insira o codigo da nova disciplina");
                    String codigo_disc = input_menudiscip.nextLine();
                    codigo_disc = codigo_disc.toUpperCase();
                    if(nome_disc.isEmpty() || codigo_disc.isEmpty()){
                        System.out.println("Nome ou código inválido. Tente novamente");
                        break;
                    }
                    else if (!codigo_disc.matches("^[A-Z]{3}[0-9]{3}$")) {
                        System.out.println("Código inválido, use o formato de 3 letras seguidas de 3 números (ex: MAT101).");
                        break;
                    } else {
                        adicionarDisciplina(new Disciplina(nome_disc, codigo_disc));
                        System.out.println("Nova Disciplina: " + nome_disc + "(" + codigo_disc + ")");
                        break;}
                case 2:
                        Set<Disciplina> lista = obterTodasDisciplinas();
                        System.out.println("Disciplinas Cadastradas:");
                        if (lista.isEmpty()) {
                            System.out.println("NÃO há disciplinas cadastradas.");
                        } else {
                            lista.forEach(System.out::println);
                        }
                    break;
                case 3:
                    System.out.print("Digite o código da disciplina a remover: ");
                    String codigo = input_menudiscip.nextLine();
                    removerDisciplina(codigo);
                        break;
                case 4:
                    System.out.println("RETORNANDO . . .");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente!");
            }
        } while (menu_disciplina_op != 4);
    }
}