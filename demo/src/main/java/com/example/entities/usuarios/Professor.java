package com.example.entities.usuarios;

public class Professor extends Usuario{
    private String CargaHoraria;

    public Professor(String Nome, String Telefone, String DataDeNascimento, String CargaHoraria) {
        super(Nome, Telefone, DataDeNascimento);
        this.CargaHoraria = CargaHoraria;
    }
    
    public String getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(String CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }
}