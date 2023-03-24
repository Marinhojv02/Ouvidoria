package NovaOuvidoria.Usuario;

import NovaOuvidoria.Feedback.Feedback;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String matricula;
    private String senha;
    private String tipo;

    public Usuario(String nome, String matricula, String senha, String tipo) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
