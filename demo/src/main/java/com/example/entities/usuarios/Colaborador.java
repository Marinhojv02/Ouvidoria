package com.example.entities.usuarios;

public class Colaborador extends Usuario {
    private String Setor;

    public Colaborador(String Nome, String Telefone, String DataDeNascimento, String Setor) {
        super(Nome, Telefone, DataDeNascimento);
        this.Setor = Setor;
    }
    
    public String getSetor() {
        return Setor;
    }

    public void setSetor(String setor) {
        Setor = setor;
    }
}