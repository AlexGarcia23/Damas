package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {

    //Atributos
    private int fila;
    private char columna;

    //Constructor
    public Posicion(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
    }

    //Constructor copia
    public Posicion(Posicion otra) {
        this.fila = otra.fila;
        this.columna = otra.columna;
    }

    //Metodo equals y hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }

    //Metodos
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila < 1 || fila > 8){
            throw new IllegalArgumentException("El valor de la fila tiene que estar en el rango de valores 1 - 8");
        } else {
            this.fila = fila;
        }
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h'){
            throw new IllegalArgumentException("El valor de la columna tiene que estar en el rango de valores de a - h ");
        } else {
            this.columna = columna;
        }
    }
}
