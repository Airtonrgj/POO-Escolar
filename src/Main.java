import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CadastroDisciplinas disciplinas = new CadastroDisciplinas();
        int menu_disciplina_op;
        do{
            disciplinas.menuDisciplina();
            menu_disciplina_op = input.nextInt();
            input.nextLine();
            switch (menu_disciplina_op) { // Provável que tudo isso abaixo terá que virar um method so para
                case 1: // Conseguir portar um menu principal, e esse menu. Ainda vou ver isso.
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
                    System.out.println("SAINDO . . .");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente!");
            }
        } while (menu_disciplina_op != 4);
    }


}
