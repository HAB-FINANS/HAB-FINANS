package com.habfinans.habfinans.Models;

public enum ROLES {
    ADIMN ("Admin"),
    OPERARIO ("Operario");

    private final String name;

    ROLES(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
