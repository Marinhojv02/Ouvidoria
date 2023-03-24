package NovaOuvidoria.Ouvidoria;

import NovaOuvidoria.Feedback.FeedbackList;
import NovaOuvidoria.Usuario.Aluno;
import NovaOuvidoria.Usuario.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ouvidoria OuvidoriaTeste = new Ouvidoria();

        OuvidoriaTeste.addUser("Aluno", "joao", "0001", "1234");

        OuvidoriaTeste.getUserList().getUsersList().get(0);
    }
}
