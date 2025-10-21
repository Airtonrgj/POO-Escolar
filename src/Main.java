import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Main {

    // Instâncias das classes de gerenciamento (devem ser persistentes)
    private static final ListaEstudantes listaEstudantes = new ListaEstudantes();
    private static final CadastroDisciplinas cadastroDisciplinas = new CadastroDisciplinas();
    private static final HistoricoNotas historicoNotas = new HistoricoNotas(listaEstudantes);

    public static void menuPrincipal() {
        System.out.println("***********************************************");
        System.out.println("Menu da Escola (POO - Coleções Java):");
        System.out.println("1 - Gerenciar Estudantes (Parte A)");
        System.out.println("2 - Gerenciar Disciplinas (Parte B)"); // Alterado para Menu Interativo
        System.out.println("3 - Gerar Consultas e Relatórios (Parte D)"); // Sua função
        System.out.println("4 - Sair");
        System.out.println("***********************************************");
    }

    public static void main(String[] args) {

        carregarDadosIniciais();

        // Scanner central
        Scanner inputMenu = new Scanner(System.in);
        int menuOp;

        do {
            menuPrincipal();

            if (inputMenu.hasNextInt()) {
                menuOp = inputMenu.nextInt();
                inputMenu.nextLine();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                inputMenu.nextLine();
                menuOp = 0;
                continue;
            }

            switch (menuOp) {
                case 1:
                    // Se o grupo criar um menu interativo para Estudantes, chamaria aqui
                    System.out.println("Funcionalidade Gerenciar Estudantes em desenvolvimento.");
                    listaEstudantes.getEstudantes().forEach(System.out::println);
                    break;
                case 2:
                    // CHAMA O NOVO MENU DE INTERAÇÃO PARA DISCIPLINAS
                    menuGerenciarDisciplinas(inputMenu);
                    break;
                case 3:
                    // SUA FUNÇÃO PRINCIPAL: Gerar os Relatórios
                    gerarRelatorios();
                    break;
                case 4:
                    System.out.println("Saindo do Sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente.");
            }
        } while (menuOp != 4);

        inputMenu.close();
    }

    // NOVO MÉTODO: Lógica de Interação para a Parte B (Disciplinas)
    public static void menuGerenciarDisciplinas(Scanner input) {
        int op;

        do {
            System.out.println("\n--- GERENCIAMENTO DE DISCIPLINAS (Parte B) ---");
            System.out.println("1. Adicionar Nova Disciplina");
            System.out.println("2. Listar Todas as Disciplinas");
            System.out.println("3. Remover Disciplina por Código");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            if (input.hasNextInt()) {
                op = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                input.nextLine();
                op = 0;
                continue;
            }

            switch (op) {
                case 1:
                    System.out.print("Nome da Disciplina: ");
                    String nome = input.nextLine();
                    System.out.print("Código da Disciplina (ex: PRG201): ");
                    String codigo = input.nextLine().toUpperCase();

                    // Validação básica de entrada de dados
                    if(nome.isEmpty() || codigo.isEmpty() || !codigo.matches("^[A-Z]{3}[0-9]{3}$")){
                        System.out.println("Dados inválidos. Use o formato XXX999 e preencha o nome.");
                    } else {
                        // Adiciona a disciplina (a lógica de Set garante que duplicatas sejam ignoradas)
                        cadastroDisciplinas.adicionarDisciplina(new Disciplina(codigo, nome));
                    }
                    break;
                case 2:
                    System.out.println("\n--- Disciplinas Cadastradas ---");
                    cadastroDisciplinas.obterTodasDisciplinas().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Digite o CÓDIGO da disciplina para remover: ");
                    String codRemover = input.nextLine();
                    if (cadastroDisciplinas.removerDisciplina(codRemover)) {
                        System.out.println("Disciplina " + codRemover + " removida com sucesso.");
                    } else {
                        System.out.println("Erro: Disciplina com código " + codRemover + " não encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (op != 4);
    }

    // Método para Carregar o Dataset de Exemplo
    private static void carregarDadosIniciais() {
        System.out.println("\n*** Carregando Dados Iniciais do Dataset de Exemplo ***");

        // Estudantes (IDs são String)
        listaEstudantes.adicionarEstudante(new Estudante("Ana", "1"));
        listaEstudantes.adicionarEstudante(new Estudante("Bruno", "2"));
        listaEstudantes.adicionarEstudante(new Estudante("Carla", "3"));
        listaEstudantes.adicionarEstudante(new Estudante("Diego", "4"));
        listaEstudantes.adicionarEstudante(new Estudante("Elisa", "5"));
        listaEstudantes.adicionarEstudante(new Estudante("Fabricio", "6"));
        listaEstudantes.adicionarEstudante(new Estudante("Fernanda", "7"));
        listaEstudantes.adicionarEstudante(new Estudante("Gabriel", "8"));
        listaEstudantes.adicionarEstudante(new Estudante("Helena", "9"));
        listaEstudantes.adicionarEstudante(new Estudante("Igor", "10"));
        listaEstudantes.adicionarEstudante(new Estudante("Joana", "11"));
        listaEstudantes.adicionarEstudante(new Estudante("Kevin", "12"));
        listaEstudantes.adicionarEstudante(new Estudante("Lívia", "13"));
        listaEstudantes.adicionarEstudante(new Estudante("Gerivaldo", "14"));
        listaEstudantes.adicionarEstudante(new Estudante("Nicole", "15"));
        listaEstudantes.adicionarEstudante(new Estudante("Osvaldo", "16"));
        listaEstudantes.adicionarEstudante(new Estudante("Patrícia", "17"));
        listaEstudantes.adicionarEstudante(new Estudante("Rafael", "18"));
        listaEstudantes.adicionarEstudante(new Estudante("Sofia", "19"));
        listaEstudantes.adicionarEstudante(new Estudante("Thiago", "20"));

        // Disciplinas
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("BD301", "Banco de Dados"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("EDF210", "Educação Física"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("ING310", "Inglês"));
        cadastroDisciplinas.adicionarDisciplina(new Disciplina("EGS410", "Engenharia de Software"));

        // Matrículas/Notas (IDs são String)
        historicoNotas.adicionarMatricula("1", "MAT101", 8.5); // Ana
        historicoNotas.adicionarMatricula("1", "PRG201", 9.0);
        historicoNotas.adicionarMatricula("1", "ING310", 6.0);

        historicoNotas.adicionarMatricula("2", "PRG201", 7.0); // Bruno
        historicoNotas.adicionarMatricula("2", "MAT101", 5.0);
        historicoNotas.adicionarMatricula("2", "EGS410", 9.0);

        historicoNotas.adicionarMatricula("3", "BD301", 6.5);  // Carla
        historicoNotas.adicionarMatricula("3", "MAT101", 7.5);
        historicoNotas.adicionarMatricula("3", "EGS410", 9.5);

        historicoNotas.adicionarMatricula("4", "PRG201", 8.0); // Diego

        historicoNotas.adicionarMatricula("5", "EDF110", 10.0); // Elisa

        historicoNotas.adicionarMatricula("6", "MAT101", 7.8);
        historicoNotas.adicionarMatricula("6", "PRG201", 8.5); // Fabricio

        historicoNotas.adicionarMatricula("7", "PRG201", 5.5);
        historicoNotas.adicionarMatricula("7", "BD301", 4.0); // Fernanda

        historicoNotas.adicionarMatricula("8", "BD301", 8.8);
        historicoNotas.adicionarMatricula("8", "EDF110", 9.0); // Gabriel

        historicoNotas.adicionarMatricula("9", "MAT101", 6.5);
        historicoNotas.adicionarMatricula("9", "BD301", 6.8); // Helena

        historicoNotas.adicionarMatricula("10", "MAT101", 6.0);
        historicoNotas.adicionarMatricula("10", "PRG201", 5.9); // Igor

        historicoNotas.adicionarMatricula("11", "BD301", 9.0);
        historicoNotas.adicionarMatricula("11", "EDF110", 9.5); // Joana

        historicoNotas.adicionarMatricula("12", "MAT101", 10.0);
        historicoNotas.adicionarMatricula("12", "PRG201", 9.8); // Kevin

        historicoNotas.adicionarMatricula("13", "BD301", 2.0);
        historicoNotas.adicionarMatricula("13", "EDF110", 7.0); // Lívia

        historicoNotas.adicionarMatricula("14", "PRG201", 8.0);
        historicoNotas.adicionarMatricula("14", "BD301", 8.0); // Gerivaldo

        historicoNotas.adicionarMatricula("15", "MAT101", 6.0);
        historicoNotas.adicionarMatricula("15", "PRG201", 6.0); // Nicole

        historicoNotas.adicionarMatricula("16", "BD301", 3.5);
        historicoNotas.adicionarMatricula("16", "EDF110", 3.5); // Osvaldo

        historicoNotas.adicionarMatricula("17", "BD301", 8.5);
        historicoNotas.adicionarMatricula("17", "EDF110", 6.5); // Patrícia

        historicoNotas.adicionarMatricula("18", "PRG201", 9.7);
        historicoNotas.adicionarMatricula("18", "BD301", 9.9); // Rafael

        historicoNotas.adicionarMatricula("19", "BD301", 7.0);
        historicoNotas.adicionarMatricula("19", "EDF110", 7.0); // Sofia

        historicoNotas.adicionarMatricula("20", "MAT101", 5.0);
        historicoNotas.adicionarMatricula("20", "PRG201", 5.5); // Thiago

        System.out.println("*** Dados carregados com sucesso. ***\n");
    }

    // O coração da sua função: Geração dos Relatórios (Consultas)
    private static void gerarRelatorios() {
        System.out.println("\n========= RELATÓRIOS E CONSULTAS (PARTE D) =========");

        // 2. Exibir todos os estudantes ordenados por nome
        System.out.println("\n== Lista de Estudantes Ordenada por Nome ==");
        List<Estudante> estudantesOrdenados = listaEstudantes.ordenarEstudantesPorNome();
        estudantesOrdenados.forEach(System.out::println);

        // 3. Exibir todas as disciplinas (ordem de inserção)
        System.out.println("\n== Disciplinas Cadastradas (Ordem de Inserção) ==");
        cadastroDisciplinas.obterTodasDisciplinas().forEach(System.out::println);

        // 4. Para cada estudante, exibir suas disciplinas e notas (Map)
        System.out.println("\n== Matrículas, Notas e Médias dos Alunos ==");
        for (Estudante estudante : listaEstudantes.getEstudantes()) {
            System.out.printf("  %s: ", estudante.getNome());
            // Chama getMatriculas com a matrícula String
            List<Matricula> matriculas = historicoNotas.getNotasPorEstudante().getOrDefault(estudante.getMatricula(), List.of());

            if (matriculas.isEmpty()) {
                System.out.println("Nenhuma matrícula.");
                continue;
            }

            // Exibição no formato: DISC(Nota), DISC(Nota) Média: X.XX
            String notasStr = matriculas.stream()
                    .map(m -> String.format("%s(%.1f)", m.getCodigoDisciplina(), m.getNota()))
                    .collect(java.util.stream.Collectors.joining(", "));

            // Chama mediaDoEstudante com a matrícula String
            double media = historicoNotas.mediaDoEstudante(estudante.getMatricula());
            System.out.printf("%s Média: %.2f%n", notasStr, media);
        }

        // Média por Disciplina (Pré-requisito para o ponto 5)
        System.out.println("\n== Médias por Disciplina ==");
        for (Disciplina d : cadastroDisciplinas.obterTodasDisciplinas()) {
            double media = historicoNotas.mediaDaDisciplina(d.getCodigo());
            System.out.printf("  %s: %.2f%n", d.getCodigo(), media);
        }

        // 5a. Top N Estudantes por Média (Sua função)
        System.out.println("\n== Top 3 Alunos por Média ==");
        List<Estudante> topAlunos = historicoNotas.topNEstudantesPorMedia(3);
        for (int i = 0; i < topAlunos.size(); i++) {
            Estudante aluno = topAlunos.get(i);
            // Chama mediaDoEstudante com a matrícula String
            double media = historicoNotas.mediaDoEstudante(aluno.getMatricula());
            System.out.printf("  %d) %s - %.2f%n", i + 1, aluno.getNome(), media);
        }

        // 5b. Alunos com média >= 8.0
        System.out.println("\n== Alunos com Média Global >= 8.0 ==");
        listaEstudantes.getEstudantes().stream()
                .filter(e -> historicoNotas.mediaDoEstudante(e.getMatricula()) >= 8.0)
                .forEach(e -> System.out.printf("  %s (%.2f)%n", e.getNome(), historicoNotas.mediaDoEstudante(e.getMatricula())));

        // 5c. Disciplinas com média < 6.0
        System.out.println("\n== Disciplinas com Média Global < 6.0 ==");
        cadastroDisciplinas.obterTodasDisciplinas().stream()
                .filter(d -> historicoNotas.mediaDaDisciplina(d.getCodigo()) < 6.0)
                .forEach(d -> System.out.printf("  %s (Média: %.2f)%n", d.getNome(), historicoNotas.mediaDaDisciplina(d.getCodigo())));

        System.out.println("=========================================\n");
    }
}