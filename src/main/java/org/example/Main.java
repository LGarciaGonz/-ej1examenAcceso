package org.example;

import database.ConexionSGBD;
import database.EstructuraDB;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // DECLARACIONES
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String opcion = "";

        // BUCLE PARA MOSTRAR EL MENÚ DE OPCIONES
        while (!salir) {

            System.out.println("""
                    \n----------------------------------------------
                    1. Listar maquinaria, operario y obra asignados
                    2. Insertar nuevos Empleados (archivo .xml)
                    0. Salir
                    ----------------------------------------------""");

            opcion = sc.nextLine();                                                                         // Leer y guardar la opción del usuario.

            // ESTRUCTURA PARA LA LLAMADA A LOS MÉTODOS
            switch (opcion) {
                case "0" -> salir = true;                                                                   // Fin de la ejecución del menú.

                case "1" -> code.listarElementos.listarElementos();

                case "2" -> code.anadirEmps.leerXML();

                default ->
                        System.out.println("\n>>>OPCIÓN NO VÁLIDA: Introduzca una opción del menú");        // Informar al usuario de un error cometido.
            }
        }
    }

}