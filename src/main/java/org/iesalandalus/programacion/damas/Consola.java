package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    public static void mostrarMensaje (String mensaje){
        System.out.println(mensaje);
    }

    public Consola() {
        throw new UnsupportedOperationException("Clase de utilidades, no se puede instanciar.");
    }
    public static void mostrarMenu() {
        mostrarMensaje("Escoge entre las opciones: ");
        mostrarMensaje("1. Crear dama por defecto");
        mostrarMensaje("2. Crear dama eligiendo color");
        mostrarMensaje("3. Mover dama");
        mostrarMensaje("4. Salir");
    }

    public static int elegirOpcionMenu() {
        int opcion;
        do{
            mostrarMensaje("Escoge entre las opciones (1 - 4)");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    public static Color elegirColor() {
        Color color = null;
        while (color == null) {
            mostrarMensaje("Seleccione el color (1: Blanco, 2: Negro):");
            int opcion = Entrada.entero();
            if (opcion == 1) {
                color = Color.BLANCO;
            } else if (opcion == 2) {
                color = Color.NEGRO;
            } else {
                mostrarMensaje("Opción no válida, por favor elija 1 o 2.");
            }
        }
        return color;
    }

    public static void mostrarMenuDirecciones(){
            mostrarMensaje("Selecciona una dirección: ");
            mostrarMensaje("1.Noroeste");
            mostrarMensaje("2.Noreste");
            mostrarMensaje("3.Sureste");
            mostrarMensaje("4.Suroeste");
    }

    public static Direccion elegirDirección(){
        int mover;
        do {
            mostrarMensaje("Elige una dirección (1 - 4): ");
            mover = Entrada.entero();
        } while (mover < 1 || mover > 4);
        Direccion direccion = null;
        switch (mover){
            case 1:
                return Direccion.NOROESTE;
            case 2:
                return Direccion.NORESTE;
            case 3:
                return Direccion.SURESTE;
            case 4:
                return Direccion.SUROESTE;
        }
        if (mover < 1 || mover > 4){
            throw new IllegalArgumentException("Solo puedes elegir entre esas 4 opciones");
        }
        return direccion;
    }

    public static int elegirPasos() {
        int pasos = 0;
            mostrarMensaje("Introduzca el número de pasos (mínimo 1): ");
                pasos = Entrada.entero();
                if (pasos < 1){
                    mostrarMensaje("Como mínimo tienes que dar un paso");
                }
                return pasos;
    }

    public static void despedirse() {
        mostrarMensaje("Gracias por jugar!");
        System.exit(0);
    }

}
