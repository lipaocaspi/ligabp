package com.paola.ligabetplay.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.functions.Function;
import com.paola.ligabetplay.models.Equipo;
import com.paola.ligabetplay.models.Partido;

public class Menu {

    static String listaMenuP = """
        1. Registrar Equipo
        2. Registrar Partido
        3. Reportes
        4. Salir
        """;

    static String listaMenuR = """
        1. Equipo con más goles
        2. Equipo con más puntos
        3. Equipo con más partidos ganados
        4. Total de goles del torneo
        5. Promedio de goles anotados
        6. Salir al menú principal
        """;

    public void mostrarMenuP() {
        Scanner sc = new Scanner(System.in);
        Function funciones = new Function();
        int eleccion;
        do {
            mostrarP();
            System.out.println("Ingrese la opción: ");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    funciones.registrarEquipo();
                    break;
                case 2:
                    funciones.registrarPartido();
                    break;
                case 3:
                    System.out.println("3");
                    mostrarMenuR();
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (eleccion != 4);
        sc.close();
    }

    private void mostrarP() {
        System.out.println("LIGA BET PLAY");
        System.out.println(listaMenuP);
    }

    public void mostrarMenuR() {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        do {
            mostrarR();
            System.out.println("Ingrese la opción de reporte: ");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (eleccion != 6);
        // sc.close();
    }

    private void mostrarR() {
        System.out.println("LIGA BET PLAY");
        System.out.println(listaMenuR);
    }
}