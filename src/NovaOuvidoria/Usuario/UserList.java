package NovaOuvidoria.Usuario;

import java.util.ArrayList;

public class UserList {
    ArrayList<Usuario> UsersList;

    public UserList(){
        UsersList = new ArrayList<>();
    }

    public void addAluno(String nome, String matricula, String senha, String tipo){
        Aluno newStudent = new Aluno(nome, matricula, senha, tipo);
        UsersList.add(newStudent);
    }

    public void addFuncionario(String nome, String matricula, String senha, String tipo){
        Funcionario newFuncionario = new Funcionario(nome, matricula, senha, tipo);
        UsersList.add(newFuncionario);
    }
    public Usuario searchUser(String matricula){
        try{
            for (Usuario current : this.UsersList) {
                if (current.getMatricula().equals(matricula)) {
                    return current;
                }
            }
        }catch (Exception e){
            System.out.println("usuario não encontrado");
        }
        return null;
    }

    public void removeUser(String matricula) {
        try {
            for (Usuario current : this.UsersList) {
                if (current.getMatricula().equals(matricula)) {
                    this.UsersList.remove(current);
                }
            }
        } catch (Exception e) {
            System.out.println("usuario não encontrado");
        }
    }

    public ArrayList<Usuario> getUsersList() {
        return UsersList;
    }
}
