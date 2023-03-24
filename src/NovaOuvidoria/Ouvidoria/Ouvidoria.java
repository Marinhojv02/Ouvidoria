package NovaOuvidoria.Ouvidoria;

import NovaOuvidoria.Feedback.FeedbackList;
import NovaOuvidoria.Usuario.UserList;

public class Ouvidoria {

    FeedbackList feedbackList;
    UserList userList;

    public Ouvidoria(){
        this.feedbackList = new FeedbackList();
        this.userList = new UserList();
    }

    public void addManifestacao(String type, String manifestacao, String matriculaAutor){
        feedbackList.addFeedback(type, manifestacao, matriculaAutor);
    }

    public void addUser(String tipo, String nome, String matricula, String senha){
        if(tipo.equals("Aluno")){
            userList.addAluno(nome, matricula, senha, tipo);
        } else if (tipo.equals("Funcionario")) {
            userList.addFuncionario(nome, matricula, senha, tipo);
        } else{
            System.out.println("Tipo de usuario não encontrado");
        }
    }

    public void removeUser(String matricula){
        userList.removeUser(matricula);
    }

    public FeedbackList getFeedbackList() {
        return feedbackList;
    }

    public UserList getUserList() {
        return userList;
    }


}
