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
        mostrarMensaje("4. Salir dama");
    }

    public static int elegirOpcionMenu() {
        int opcion;
        do{
            mostrarMensaje("Escoge entre las opciones (1 - 4)");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    public static Color elegirOpcion() {
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

    public static Direccion mostrarMenuDirecciones(){
        Direccion direccion = null;
        while (direccion == null){
            mostrarMensaje("Selecciona una dirección: ");
            mostrarMensaje("1.Noroeste, 2.Noreste, 3.Sureste, 4.Suroeste");
            int mover = Entrada.entero();
            switch (mover){
                case 1:
                    direccion = Direccion.NOROESTE;
                    break;
                case 2:
                    direccion = Direccion.NORESTE;
                    break;
                case 3:
                    direccion = Direccion.SURESTE;
                    break;
                case 4:
                    direccion = Direccion.SUROESTE;
                    break;
            }
            if (mover < 1 || mover > 4){
                throw new IllegalArgumentException("Solo puedes elegir entre esas 4 opciones");
            }
        }
        return direccion;
    }

}
