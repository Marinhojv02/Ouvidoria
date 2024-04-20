package com.example.entities.util;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.entities.manifestaçoes.Manifestacao;

public class BancoManifestacoes {
    private static BancoManifestacoes instance;
    
    private ArrayList<Manifestacao> manifestacoes = new ArrayList<>();
    
    private BancoManifestacoes() {
    }

    public static BancoManifestacoes getInstance() {
        if (instance == null) {
            instance = new BancoManifestacoes();
        }
        return instance;
    }

    public void addManifestacao(Manifestacao manifestacao) {
        this.manifestacoes.add(manifestacao);
    }

    public ArrayList<Manifestacao> getManifestacoes() {
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
