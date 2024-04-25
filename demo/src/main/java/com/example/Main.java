package com.example;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.example.entities.manifestaçoes.*;
import com.example.entities.usuarios.*;
import com.example.entities.util.*;

public class Main {
    public static void main(String[] args) {
        displayStartingPage();
    }

    private static void displayStartingPage() {
        try{
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
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void showAuthPage() {
        try{
            String[] options = { "Login", "Create New User" };
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Authentication", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
            if (choice == 0) {
                handleLogin();
            } else if (choice == 1) {
                handleCreateNewUser();
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void handleLogin() {
        try{
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
                handleLogin();
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void handleCreateNewUser() {
        try{
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
                    displayStartingPage();
                    break;
                case "Colaborador":
                    addColaborador();
                    displayStartingPage();
                    break;
                case "Aluno":
                    addAluno();
                    displayStartingPage();
                    break;
                default:
                    displayStartingPage();
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void addProfessor() {
        try{
            BancoUsuarios userList = BancoUsuarios.getInstance();

            String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do usuário:");
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");
            String CargaHoraria = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");

            Usuario usuario = new Professor(nome, telefone, dataNascimento, CargaHoraria);

            userList.addUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso:\n" + usuario.getNome());
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void addColaborador() {
        try{
            BancoUsuarios userList = BancoUsuarios.getInstance();

            String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do usuário:");
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");
            String CargaHoraria = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (YYYY-MM-DD):");

            Colaborador usuario = new Colaborador(nome, telefone, dataNascimento, CargaHoraria);

            userList.addUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso:\n" + usuario.getNome());
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void addAluno() {
        try{
            BancoUsuarios userList = BancoUsuarios.getInstance();

            String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do aluno:");
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno (YYYY-MM-DD):");
            String mediaStr = JOptionPane.showInputDialog("Digite a média do aluno:");

            double media = Double.parseDouble(mediaStr);

            Aluno usuario = new Aluno(nome, telefone, dataNascimento, media);

            userList.addUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso:\n" + usuario.getNome() + "\nMédia: " + usuario.getMedia());
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void showStudentScreen() {
        try{
            String[] studentOptions = { "Create Manifestacao", "View My Manifestacoes" };
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Student Screen",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, studentOptions, studentOptions[0]);

            if (choice == 0) {
                createManifestacao();
                displayStartingPage();
            } else if (choice == 1) {
                viewMyManifestacoes();
                displayStartingPage();
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void createManifestacao() {
        try{
            BancoManifestacoes manifestacoes = BancoManifestacoes.getInstance();
            Auth auth = Auth.getInstance();

            String descricao = JOptionPane.showInputDialog(null, "Enter description:", "Create Manifestacao", JOptionPane.PLAIN_MESSAGE);
            TipoManifestacao[] values = TipoManifestacao.values();
            TipoManifestacao selectedOption = (TipoManifestacao) JOptionPane.showInputDialog(
                    null, 
                    "Escolha o tipo de manifestação:", 
                    "Criar Manifestação",
                    JOptionPane.PLAIN_MESSAGE, 
                    null, 
                    values, 
                    values[0]
            );

            if (descricao != null && !descricao.isEmpty() && selectedOption != null) {
                Manifestacao manifestacao = new Manifestacao(descricao, auth.getCurrentActive(), selectedOption, LocalDate.now());
                manifestacoes.addManifestacao(manifestacao);
                JOptionPane.showMessageDialog(null, "Manifestacao created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid description. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                createManifestacao();
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void viewMyManifestacoes() {
        try{
            Auth auth = Auth.getInstance();
            BancoManifestacoes manifestacoes = BancoManifestacoes.getInstance();
            Usuario currentUser = auth.getCurrentActive();
            ArrayList<Manifestacao> myManifestacoes = manifestacoes.getManifestacoesByUsuario(currentUser.getNome());

            StringBuilder message = new StringBuilder("My Manifestacoes:\n");
            for (Manifestacao manifestacao : myManifestacoes) {
                message.append("- ").append(manifestacao.getDescricao()).append("\n");
            }

            JOptionPane.showMessageDialog(null, message.toString(), "My Manifestacoes", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void showWorkerScreen() {
        try{
            String[] options = { "Student Manifestacoes", "Create Manifestacao", "View Manifestacoes by Date", "View All Manifestacoes" };
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Worker Screen",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    viewStudentManifestacoes();
                    displayStartingPage();
                    break;
                case 1:
                    createManifestacao();
                    displayStartingPage();
                    break;
                case 2:
                    viewManifestacoesByDate();
                    displayStartingPage();
                    break;
                case 3:
                    viewAllManifestacoes();
                    displayStartingPage();
                    break;
                default:
                    displayStartingPage();
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void viewManifestacoesByDate() {
        try{
            BancoManifestacoes manifestacoes = BancoManifestacoes.getInstance();
            String dateStr = JOptionPane.showInputDialog(null, "Enter date (yyyy-MM-dd):", "View Manifestacoes by Date",
                    JOptionPane.PLAIN_MESSAGE);

            if (dateStr != null && !dateStr.isEmpty()) {
                LocalDate date = LocalDate.parse(dateStr); // Parse input date string to LocalDate
                ArrayList<Manifestacao> manifestacoesByDate = manifestacoes.getManifestacoesByCreatedAt(date);

                StringBuilder message = new StringBuilder("Manifestacoes on " + dateStr + ":\n");
                for (Manifestacao manifestacao : manifestacoesByDate) {
                    message.append("- ").append(manifestacao.getDescricao()).append("\n");
                }

                JOptionPane.showMessageDialog(null, message.toString(), "Manifestacoes by Date", JOptionPane.PLAIN_MESSAGE);
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void viewAllManifestacoes() {
        try{
            BancoManifestacoes manifestacoes = BancoManifestacoes.getInstance();
            ArrayList<Manifestacao> allManifestacoes = manifestacoes.getManifestacoes();

            StringBuilder message = new StringBuilder("All Manifestacoes:\n");
            for (Manifestacao manifestacao : allManifestacoes) {
                message.append("- ").append(manifestacao.getDescricao()).append("\n");
            }

            JOptionPane.showMessageDialog(null, message.toString(), "All Manifestacoes", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }

    private static void viewStudentManifestacoes() {
        try{
            BancoManifestacoes manifestacoes = BancoManifestacoes.getInstance();
            BancoUsuarios userList = BancoUsuarios.getInstance();
            
            String username = JOptionPane.showInputDialog(null, "Enter student's username:", "View Student Manifestacoes",
                    JOptionPane.PLAIN_MESSAGE);

            if (username != null && !username.isEmpty()) {
                if(userList.searchUser(username) == null){
                    JOptionPane.showMessageDialog(null, "Invalid username. Please try again.", "User not found",
                        JOptionPane.ERROR_MESSAGE);
                    showWorkerScreen();
                }
                else{
                    ArrayList<Manifestacao> studentManifestacoes = manifestacoes.getManifestacoesByUsuario(username);

                    StringBuilder message = new StringBuilder("Manifestacoes of Student " + username + ":\n");
                    for (Manifestacao manifestacao : studentManifestacoes) {
                        message.append("- ").append(manifestacao.getDescricao()).append("\n");
                    }
        
                    JOptionPane.showMessageDialog(null, message.toString(), "Student Manifestacoes", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println(e);
            displayStartingPage();
        }
    }
}