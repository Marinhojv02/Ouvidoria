package com.example.entities.manifestaçoes;

import java.time.LocalDate;

import com.example.entities.usuarios.Usuario;
public class Manifestacao{
    private String descricao;
    private Usuario usuario;
    private TipoManifestacao tipo;
    private LocalDate createdAt;

    public Manifestacao(String descricao, Usuario usuario, TipoManifestacao tipo, LocalDate createdAt){
        this.descricao = descricao;
        this.usuario = usuario;
        this.tipo = tipo;
        this.createdAt = createdAt;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public TipoManifestacao getTipo(){
        return tipo;
    }

    public void setTipo(TipoManifestacao tipo){
        this.tipo = tipo;
    }

    public LocalDate getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt){
        this.createdAt = createdAt;
    }
}