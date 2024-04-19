package com.example.entities.usuarios;

public abstract class Usuario{
    private String Nome;
    private String Telefone;
    private String DataDeNascimento;

    public Usuario(String Nome, String Telefone, String DataDeNascimento){
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.DataDeNascimento = DataDeNascimento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }
}
