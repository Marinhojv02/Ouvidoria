package com.example.entities.util;

import java.util.ArrayList;

import com.example.entities.usuarios.Usuario;

public class BancoUsuarios {
    private static BancoUsuarios instance;
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private BancoUsuarios() {
    }

    public static BancoUsuarios getInstance() {
        if (instance == null) {
            instance = new BancoUsuarios();
        }
        return instance;
    }
    
    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public Usuario searchUser(String username) {
        for (Usuario current : this.usuarios) {
            if (current.getNome().equals(username)) {
                return current;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }
}
