package org.iesalandalus.programacion.damas.modelo;

public class Dama {
    //Atributos
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    //constructor
    public Dama(Color color, Posicion posicion) {
        this.color = color;
        this.posicion = posicion;
        esDamaEspecial = false;
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
