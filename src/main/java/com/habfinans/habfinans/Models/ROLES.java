package com.habfinans.habfinans.Models;

import javax.persistence.Table;

@Table(name = "rolesEmployee")
public enum ROLES {

    ADMIN,
    OPERARIO
/*     ADIMN ("Admin"),
    OPERARIO ("Operario");

    private final String name;

    ROLES(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    } */
    
}
