import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDisciplinas {
    public ArrayList<String> lista_disciplina = new ArrayList<>();

    public void addDisciplina(String nome_disciplina) {
        lista_disciplina.add(nome_disciplina);
    }
    public ArrayList<String> ListarDisciplinas(){
        return lista_disciplina;
    }
    public void removeDisciplina(String nome_disciplina){
        lista_disciplina.remove(nome_disciplina);
    }

    public void menuDisciplina() {
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
                    System.out.println("Insira o nome da nova matéria");
                    String novadisciplina = input_menudiscip.nextLine();
                    if(novadisciplina.isEmpty()){
                        System.out.println("Nome da disciplina está vazio. Tente novamente");
                        break;
                    }
                    if (lista_disciplina.contains(novadisciplina)){
                        System.out.println("A matéria já existe dentro da lista.");
                        System.out.println("A lista se mantêm inalterada.");
                    } else {
                        addDisciplina(novadisciplina);
                        System.out.println("Nova Disciplina: " + novadisciplina);
                        break;}
                case 2:
                    System.out.println("Disciplinas: " + ListarDisciplinas());
                    break;
                case 3:
                    System.out.println("Digite o nome da disciplina");
                    String disciplina_removida = input_menudiscip.nextLine();
                    if (lista_disciplina.contains(disciplina_removida)){
                        System.out.println("Removendo disciplina . . .");
                        removeDisciplina(disciplina_removida);
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
                    System.out.println("RETORNANDO . . .");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente!");
            }
        } while (menu_disciplina_op != 4);
    }
}