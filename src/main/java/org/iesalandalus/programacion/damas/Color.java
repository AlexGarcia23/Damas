package org.iesalandalus.programacion.damas;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    //Atributos
    private String cadenaAMostrar;

    //Constructor
    Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }
}
