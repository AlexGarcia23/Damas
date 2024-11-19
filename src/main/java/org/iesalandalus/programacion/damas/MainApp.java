package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;

import com.sun.tools.javac.Main;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.damas.modelo.Posicion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Dama dama;
    private Consola consola;
    private Direccion direccion;

    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public MainApp() {
        dama = null;
        consola = new Consola();
    }

    public static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedirse();
                break;
        }
    }

    public static void crearDamaDefecto(){
        dama = new Dama();
        mostrarMensaje("Dama creada con éxito");
    }

    public static void crearDamaColor(){
        try {
            Color color = Consola.elegirColor();
            dama = new Dama(color);
            mostrarMensaje("Se ha creado la dama de color " + color);
        } catch (IllegalArgumentException | NullPointerException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public static void mover() {
        if (dama == null) {
            mostrarMensaje("No tienes damas para mover");
            return;
        }
        Consola.mostrarMenuDirecciones();
        Direccion direccion = Consola.elegirDirección();

        int pasos = 1;
        if (dama.isEsDamaEspecial()) {
            pasos = Consola.elegirPasos();
        }
        try {
            Dama.mover(direccion, pasos);
            System.out.println("Dama movida a: " + dama);
        } catch (Exception e) {
            System.out.println("No se pudo mover la dama: " + e.getMessage());
        }
    }

    public static void mostrarDama(){
        if (dama != null){
            mostrarMensaje(dama.toString());
        } else {
            mostrarMensaje("No tienes ninguna dama");
        }
    }

    public static void main(String[] args) {
        mostrarMensaje("===== MENÚ PRINCIPAL =====");
        int opcion;
        try {
            do {
                Consola.mostrarMenu();
                opcion = Consola.elegirOpcionMenu();
                ejecutarOpcion(opcion);
                mostrarDama();
            } while (opcion != 4);

        } catch (IllegalArgumentException | NullPointerException e) {
            mostrarMensaje(e.getMessage());
        }

    }

}