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

    //Metodo mover
    public void mover (Direccion direccion, int pasos_fila, char pasos_columna){
        if (direccion == null){
            throw new IllegalArgumentException("Tienes que poner una dirección");
        }
        if (esDamaEspecial){
            switch (direccion){
                case NORESTE:
                    posicion = new Posicion(posicion.getFila() + pasos_fila, (char) (posicion.getColumna() + pasos_columna));
                    break;
                case NOROESTE:
                    posicion = new Posicion(posicion.getFila() + pasos_fila, (char) (posicion.getColumna() - pasos_columna));
                    break;
                case SURESTE:
                    posicion = new Posicion(posicion.getFila() - pasos_fila, (char) (posicion.getColumna() + pasos_columna));
                    break;
                case SUROESTE:
                    posicion = new Posicion(posicion.getFila() - pasos_fila, (char) (posicion.getColumna() - pasos_columna));
                    break;
            }
            if (color == Color.BLANCO){
                if (direccion == Direccion.NORESTE){
                    posicion = new Posicion(posicion.getFila() + pasos_fila, (char) (posicion.getColumna() + pasos_columna));
                } else if (direccion == Direccion.NOROESTE){
                    posicion = new Posicion(posicion.getFila() + pasos_fila, (char) (posicion.getColumna() - pasos_columna));
                } else {
                    throw new IllegalArgumentException("La dama blanca solo puede moverse al noreste y al noroeste");
                }
            }
            if (color == Color.NEGRO){
                if (direccion == Direccion.SURESTE){
                    posicion = new Posicion(posicion.getFila() - pasos_fila, (char) (posicion.getColumna() + pasos_columna));
                } else if (direccion == Direccion.SUROESTE){
                    posicion = new Posicion(posicion.getFila() - pasos_fila, (char) (posicion.getColumna() - pasos_columna));
                } else {
                    throw new IllegalArgumentException("La dama negra solo puede moverse al sureste y al suroeste");
                }
            }
        }
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
