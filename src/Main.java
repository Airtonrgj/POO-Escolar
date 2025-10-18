import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void menuPrincipal(){
        System.out.println("***********************************************");
        System.out.println("Menu da Escola FulanoDeTal - Escolha uma opção:");
        System.out.println("1 - Gerenciamento de Disciplinas");
        System.out.println("2 - Gerenciamento de Alunos (WIP)");
        System.out.println("3 - Sair");
        System.out.println("***********************************************");
    }

    public static void main(String[] args) {
        int menu_op;
        do {
            menuPrincipal();
            Scanner input_menu = new Scanner(System.in);
            menu_op = input_menu.nextInt();
            switch (menu_op) {
                case 1:
                    CadastroDisciplinas disciplinas = new CadastroDisciplinas();
                    disciplinas.menuDisciplina();
                    break;
                case 2:
                    System.out.println("EM PROGRESSO (W.I.P.)");
                case 3:
                    System.out.println("SAINDO . . .");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente.");
            }
        } while (menu_op != 3);
    }


}
