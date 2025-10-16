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
    public void menuDisciplina(){
        System.out.println("----------------------------");
        System.out.println("GESTÃO DE DISCIPLINAS - Escolha uma das opções:");
        System.out.println("1 -- Adicionar disciplina");
        System.out.println("2 -- Listar disciplinas");
        System.out.println("3 -- Remover disciplina");
        System.out.println("4 -- Sair");
        System.out.println("----------------------------");
    }
}