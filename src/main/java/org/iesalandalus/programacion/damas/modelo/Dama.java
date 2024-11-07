package org.iesalandalus.programacion.damas.modelo;

import java.util.Random;

public class Dama {
    //Atributos
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    //constructor
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionAleatoria();
        esDamaEspecial = false;
    }

    public Dama(Color color){
        this.color = color;

    }

    //Metodo crearPosicionAleatoria
    private Posicion crearPosicionAleatoria(){
        Random random = new Random();

        int filaInicio = (color == Color.BLANCO) ? 3:6;
        int fila = random.nextInt(3) + filaInicio;
        int columna;
        char columnaChar;
        do {
            columnaChar = (char) ('A' + random.nextInt(8));
            columna = columnaChar - 'A';
        } while ((fila + columna) % 2 == 0);

        return new Posicion(fila, columnaChar);

    }

    //Metodos

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }
}
