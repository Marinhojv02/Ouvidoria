package com.example.entities.usuarios;

public class Aluno extends Usuario {
    private Double Media;

    public Aluno(String Nome, String Telefone, String DataDeNascimento, Double Media) {
        super(Nome, Telefone, DataDeNascimento);
        this.Media = Media;
    }

    public Double getMedia() {
        return Media;
    }

    public void setMedia(Double media) {
        Media = media;
    }
}