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
}