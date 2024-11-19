package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {
    NORESTE("Noreste"),
    NOROESTE("Noroeste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste");

    //Atributos
    private String cadenaAMostrar;

    //Constructor
    Direccion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}

