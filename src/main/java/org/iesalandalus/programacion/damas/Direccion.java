package org.iesalandalus.programacion.damas;

public enum Direccion {
    NORESTE("Noreste"),
    NOROESTE("Noroeste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste");

    //Atributos
    private String cadenaAMostrar;

    Direccion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }
}

