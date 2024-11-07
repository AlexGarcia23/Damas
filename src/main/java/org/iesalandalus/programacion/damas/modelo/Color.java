package org.iesalandalus.programacion.damas.modelo;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    //Atributos
    private String cadenaAMostrar;

    //Constructor
    Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }

}
