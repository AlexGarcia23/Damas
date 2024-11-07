package org.iesalandalus.programacion.damas;

public class Posicion {

    //Atributos
    private int fila;
    private char columna;

    //Constructor
    public Posicion(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
    }

    //Metodos
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila < 1 || fila > 8){
            throw new IllegalArgumentException("El valor de la fila tiene que estar en el rango de valores 1 - 8");
        }
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h'){
            throw new IllegalArgumentException("El valor de la columna tiene que estar en el rango de valores de a - h ");
        }
        this.columna = columna;
    }
}
