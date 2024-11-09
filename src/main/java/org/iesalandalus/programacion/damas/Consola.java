package org.iesalandalus.programacion.damas;

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



}
