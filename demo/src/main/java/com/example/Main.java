package com.example;
import javax.swing.JOptionPane;

import com.example.entities.usuarios.*;
import com.example.entities.util.*;

public class Main {
    public static void main(String[] args) {
        displayStartingPage();
    }

    private static void displayStartingPage() {
        Auth auth = Auth.getInstance();
        if (auth.getCurrentActive() == null) {
            showAuthPage();
        } else {
            Usuario currentUser = auth.getCurrentActive();
            if (currentUser instanceof Aluno) {
                showStudentScreen();
            } else{
                showWorkerScreen();
            }
        }
    }

    private static void showAuthPage() {
        String[] options = { "Login", "Create New User" };
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Authentication", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            handleLogin();
        } else if (choice == 1) {
            handleCreateNewUser();
        }
    }

    private static void handleLogin() {
        Auth auth = Auth.getInstance();
        BancoUsuarios userList = BancoUsuarios.getInstance();

        String username = JOptionPane.showInputDialog(null, "Enter your username:", "Login",
                JOptionPane.PLAIN_MESSAGE);

        if (username != null && !username.isEmpty()) {
            Usuario authenticatedUser = userList.searchUser(username);
            auth.setCurrentActive(authenticatedUser);

            displayStartingPage();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username. Please try again.", "Login Error",
                    JOptionPane.ERROR_MESSAGE);
            handleLogin(); // Prompt login again if username is invalid or empty
        }
    }

    private static void handleCreateNewUser() {
        String[] options = { "Funcionario", "Aluno", "Colaborador" };

        String selectedOption = (String) JOptionPane.showInputDialog(
            null, 
            "Escolha o tipo de usuário a adicionar:", 
            "Adicionar Usuário",
            JOptionPane.PLAIN_MESSAGE, 
            null, 
            options, 
            options[0]
        );


        switch (selectedOption) {
            case "Funcionario":
                addProfessor();
                break;
            case "Colaborador":
                addColaborador();
                    break;
            case "Aluno":
                addAluno();
                break;
            default:
                displayStartingPage();
                break;
        }
    }

    private static void addProfessor() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do usuário:");
        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");
        String CargaHoraria = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");

        Usuario usuario = new Professor(nome, telefone, dataNascimento, CargaHoraria);

        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso:\n" + usuario.getNome());
    }

    private static void addColaborador() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do usuário:");
        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");
        String CargaHoraria = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");

        Colaborador usuario = new Colaborador(nome, telefone, dataNascimento, CargaHoraria);

        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso:\n" + usuario.getNome());
    }

    private static void addAluno() {
        String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do aluno:");
        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno (YYYY-MM-DD):");
        String mediaStr = JOptionPane.showInputDialog("Digite a média do aluno:");

        double media = Double.parseDouble(mediaStr);

        Aluno aluno = new Aluno(nome, telefone, dataNascimento, media);

        JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso:\n" + aluno.getNome() + "\nMédia: " + aluno.getMedia());
    }

    private static void showStudentScreen() {
        JOptionPane.showMessageDialog(null, "Welcome to Student Screen!");
        // Implement student screen functionality (e.g., display student-specific options)
    }

    private static void showWorkerScreen() {
        JOptionPane.showMessageDialog(null, "Welcome to Worker Screen!");
        // Implement worker screen functionality (e.g., display worker-specific options)
    }
}