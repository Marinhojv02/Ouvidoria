package com.example.entities.manifestaçoes;

import java.time.LocalDate;
import java.util.ArrayList;

public class BancoManifestacoes {
    private ArrayList<Manifestacao> manifestacoes = new ArrayList<>();
    
    public BancoManifestacoes(){
    }

    public void addManifestacao(Manifestacao manifestacao){
        this.manifestacoes.add(manifestacao);
    }

    public ArrayList<Manifestacao> getManifestacoes(){
        return this.manifestacoes;
    }

    public ArrayList<Manifestacao> getManifestacoesByUsuario(String username) {
        ArrayList<Manifestacao> manifestacoesByUsuario = new ArrayList<>();

        for (Manifestacao manifestacao : manifestacoes) {
            if (manifestacao.getUsuario() != null && manifestacao.getUsuario().getNome().equals(username)) {
                manifestacoesByUsuario.add(manifestacao);
            }
        }

        return manifestacoesByUsuario;
    }

    public ArrayList<Manifestacao> getManifestacoesByCreatedAt(LocalDate createdAt) {
        ArrayList<Manifestacao> manifestacoesByCreatedAt = new ArrayList<>();

        for (Manifestacao manifestacao : manifestacoes) {
            if (manifestacao.getCreatedAt().equals(createdAt)) {
                manifestacoesByCreatedAt.add(manifestacao);
            }
        }

        return manifestacoesByCreatedAt;
    }
}