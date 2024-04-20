package com.example.entities.util;

import com.example.entities.usuarios.Usuario;

public class Auth {
    private static Auth instance;
    private Usuario currentActive;

    // Private constructor to prevent instantiation outside this class
    private Auth() {
        // Initialize any necessary setup here
    }

    public static Auth getInstance() {
        if (instance == null) {
            instance = new Auth();
        }
        return instance;
    }

    public Usuario getCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(Usuario currentActive) {
        this.currentActive = currentActive;
    }
}
