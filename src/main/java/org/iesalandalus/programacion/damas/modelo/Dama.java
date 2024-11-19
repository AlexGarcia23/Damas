package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Random;

public class Dama {
    //Atributos
    private static Color color;
    private static Posicion posicion;
    private static boolean esDamaEspecial;

    //constructor
    public Dama() {
        setColor(Color.BLANCO);
        setPosicion(crearPosicionAleatoria());
        esDamaEspecial = false;
    }

    public Dama(Color color){
        setColor(color);
        setPosicion(crearPosicionAleatoria());
        esDamaEspecial = false;
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
    public static void mover(Direccion direccion, int pasos) throws OperationNotSupportedException{
        if (direccion == null){
            throw new IllegalArgumentException("Tienes que poner una dirección");
        }
        if (pasos< 1)  {
            throw new IllegalArgumentException("Tienes que poner un número mayor que 0");
        }
        if (!esDamaEspecial && pasos > 1) {
            pasos = 1;
        }
        int Fila = posicion.getFila();
        char Columna = posicion.getColumna();

            switch (direccion){
                case NORESTE:
                    if (color == Color.NEGRO && !esDamaEspecial) {
                        throw new OperationNotSupportedException("La dama negra no puede moverse hacia el noreste.");
                    }
                    Fila += pasos;
                    Columna += pasos;
                    break;
                case SURESTE:
                    if (color == Color.BLANCO && !esDamaEspecial) {
                        throw new OperationNotSupportedException("La dama blanca no puede moverse hacia el sureste.");
                    }
                    Fila -= pasos;
                    Columna += pasos;
                    break;
                case SUROESTE:
                    if (color == Color.BLANCO && !esDamaEspecial) {
                        throw new OperationNotSupportedException("La dama blanca no puede moverse hacia el suroeste.");
                    }
                    Fila -= pasos;
                    Columna -= pasos;
                    break;
                case NOROESTE:
                    if (color == Color.NEGRO && !esDamaEspecial) {
                        throw new OperationNotSupportedException("La dama negra no puede moverse hacia el noroeste.");
                    }
                    Fila += pasos;
                    Columna -= pasos;
                    break;
            }

        if (Fila < 1 || Fila > 8 || Columna < 'A' || Columna > 'H') {
            throw new OperationNotSupportedException("El movimiento de la dama la saca fuera del tablero.");
        }

        posicion = new Posicion(Fila, Columna);

        if ((color == Color.BLANCO && Fila == 1) || (color == Color.NEGRO && Fila == 8)) {
            esDamaEspecial = true;
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
        return new Posicion(posicion);
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("La posición no puede ser nula.");
        }
        this.posicion = new Posicion(posicion);
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }

    //Metodo to string
    @Override
    public String toString() {
        return "Dama: color=" + color +
                ", posicion=" + posicion;
    }

}
