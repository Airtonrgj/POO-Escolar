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

    public static void main(String[] args) { // UM AVISO: Percebi um comportamento anomalo que ainda nao vi como reparar
        int menu_op; /* Mas se trata do menu de disciplinas, se ele voltar para o menu principal, tudo que foi feito
        será descartado, logo, deve ser feito alguma forma de impedir isso (juntar todos os menus em um na main pode
        ser uma possível solução, mas deve ser visto como não quebrar os métodos usados dentro da classe
         CadastroDisciplinas caso for feito isso.*/
        do {
            menuPrincipal();
            CadastroDisciplinas disciplinas = new CadastroDisciplinas();
            Scanner input_menu = new Scanner(System.in);
            menu_op = input_menu.nextInt();
            switch (menu_op) {
                case 1:
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
