package com.paola.ligabetplay.menu;

import java.util.ArrayList;
import java.util.Scanner;
import com.paola.ligabetplay.functions.Function;
import com.paola.ligabetplay.models.Equipo;
import com.paola.ligabetplay.models.Partido;

public class Menu {
    ArrayList<Equipo> equipos = new ArrayList<>();
    ArrayList<Partido> partidos = new ArrayList<>();

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
                    equipos = funciones.registrarEquipo();
                    break;
                case 2:
                    partidos = funciones.registrarPartido();
                    break;
                case 3:
                    if (equipos.isEmpty() || partidos.isEmpty()) {
                        System.out.println("No se encuentran equipos/partidos registrados");
                    } else {
                        mostrarMenuR(equipos, partidos);
                    }
                    break;
                case 4:
                    System.out.println("GRACIAS POR USAR EL SERVICIO");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (eleccion != 4);
    }

    private void mostrarP() {
        System.out.println("LIGA BET PLAY");
        System.out.println(listaMenuP);
    }

    public void mostrarMenuR(ArrayList<Equipo> equipos, ArrayList<Partido> partidos) {
        // System.out.println("Tamaño equipos: " + equipos.size());
        // System.out.println("Tamaño partidos: " + partidos.size());
        Scanner sc = new Scanner(System.in);
        Function funciones = new Function();
        int eleccion;
        do {
            mostrarR();
            System.out.println("Ingrese la opción de reporte: ");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    funciones.equipoMasGoles(equipos);
                    break;
                case 2:
                    funciones.equipoMasPuntos(equipos);
                    break;
                case 3:
                    funciones.equipoMasPartidosGanados(equipos);
                    break;
                case 4:
                    funciones.totalGoles(equipos);
                    break;
                case 5:
                    funciones.promedioGoles(equipos);
                    break;
                case 6:
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