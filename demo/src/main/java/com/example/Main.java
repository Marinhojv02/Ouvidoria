package com.example;
import javax.swing.JOptionPane;

import com.example.entities.usuarios.*;


public class Main {
    public static void main(String[] args) {
        String[] options = { "Usuario", "Aluno" };
        int choice = JOptionPane.showOptionDialog(null, "Escolha o tipo de usuário a adicionar:", "Adicionar Usuário",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Add a regular Usuario
            addProfessor();
        } else if (choice == 1) {
            // Add an Aluno
            addAluno();
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

    private static void addAluno() {
        String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do aluno:");
        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno (YYYY-MM-DD):");
        String mediaStr = JOptionPane.showInputDialog("Digite a média do aluno:");

        double media = Double.parseDouble(mediaStr);

        Aluno aluno = new Aluno(nome, telefone, dataNascimento, media);

        JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso:\n" + aluno.getNome() + "\nMédia: " + aluno.getMedia());
    }
}