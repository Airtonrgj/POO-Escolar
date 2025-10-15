import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CadastroDisciplinas disciplinas = new CadastroDisciplinas();
        System.out.println("----------------------------");
        System.out.println("Menu Escolar - Escolha uma das opções:");
        System.out.println("1 -- Adicionar disciplina");
        System.out.println("2 -- Listar disciplinas");
        System.out.println("3 -- Remover disciplina");
        System.out.println("6 -- Sair");
        System.out.println("----------------------------");
        int menuop;
        do{
            menuop = input.nextInt();
            input.nextLine();
            switch (menuop) {
                case 1:
                    System.out.println("Insira o nome da nova matéria");
                    String novadisciplina = input.nextLine();
                    if(novadisciplina.isEmpty()){
                        System.out.println("Nome da disciplina está vazio. Tente novamente");
                        break;
                    }
                    if (disciplinas.lista_disciplina.contains(novadisciplina)){
                        System.out.println("A matéria já existe dentro da lista.");
                        System.out.println("A lista se mantêm inalterada.");
                    } else {
                    disciplinas.addDisciplina(novadisciplina);
                        System.out.println("Nova Disciplina: " + novadisciplina);
                    break;}
                case 2:
                    System.out.println("Disciplinas: " + disciplinas.ListarDisciplinas());
                    break;
                case 3:
                    System.out.println("Digite o nome da disciplina");
                    String disciplina_removida = input.nextLine();
                    if (disciplinas.lista_disciplina.contains(disciplina_removida)){
                        System.out.println("Removendo disciplina . . .");
                        disciplinas.removeDisciplina(disciplina_removida);
                        System.out.println("Disciplina ''"+disciplina_removida+"'' removida com sucesso.");
                        break;
                    }
                    else if (disciplina_removida.isEmpty()){
                        System.out.println("O nome está vazio. Tente novamente.");
                        break;
                    }else{
                        System.out.println("O nome está errado. Tente novamente.");
                    }
                    break;
                case 4:
                    System.out.println("wip");
                    break;
                case 5:
                    System.out.println("wip");
                    break;
                case 6:
                    System.out.println("SAINDO . . .");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente!");
                    continue;
            }
        } while (menuop != 6);
    }


}
