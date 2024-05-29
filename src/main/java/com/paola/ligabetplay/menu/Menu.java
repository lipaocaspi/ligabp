package com.paola.ligabetplay.menu;
import java.util.ArrayList;
import java.util.Scanner;
import com.paola.ligabetplay.functions.Function;
import com.paola.ligabetplay.models.Equipo;
import com.paola.ligabetplay.models.Partido;

public class Menu {
    ArrayList<Equipo> equipos = new ArrayList<>();
    ArrayList<Partido> partidos = new ArrayList<>();
    int numeroGoles;

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
    
    static String titulo = """
            ************
            LIGA BETPLAY
            ************
            """;

    public void mostrarMenuP() {
        Function funciones = new Function();
        int eleccion;
        Boolean partidosIguales;
        do {
            mostrarP();
            eleccion = funciones.verificarValor("Ingrese la opción: ");
            switch (eleccion) {
                case 1:
                    equipos = funciones.registrarEquipo();
                    break;
                case 2:
                    partidos = funciones.registrarPartido();
                    break;
                case 3:
                    partidosIguales = funciones.verificarPartidos(equipos);
                    if (equipos.isEmpty() || partidos.isEmpty()) {
                        System.out.println("---");
                        System.out.println("No se encuentran equipos/partidos registrados");
                        System.out.println("---");
                    } else if (partidosIguales == false) {
                        System.out.println("---");
                        System.out.println("Deben haber el mismo número de partidos registrados para cada equipo");
                        System.out.println("---");
                    } else {
                        mostrarMenuR(equipos, partidos);
                    }
                    break;
                case 4:
                    System.out.println("****************************");
                    System.out.println("GRACIAS POR USAR EL SERVICIO");
                    System.out.println("****************************");
                    break;
                default:
                    System.out.println("---");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("---");
                    break;
            }
        } while (eleccion != 4);
    }

    private void mostrarP() {
        System.out.println(titulo);
        System.out.println(listaMenuP);
    }

    public void mostrarMenuR(ArrayList<Equipo> equipos, ArrayList<Partido> partidos) {
        Scanner sc = new Scanner(System.in);
        Function funciones = new Function();
        int eleccion;
        do {
            mostrarR();
            eleccion = funciones.verificarValor("Ingrese la opción de reporte: ");
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
                    numeroGoles = funciones.totalGoles(equipos);
                    System.out.println("---");
                    System.out.println("Número de goles anotados en el torneo: " + numeroGoles);
                    System.out.println("---");
                    break;
                case 5:
                    funciones.promedioGoles(equipos, numeroGoles);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("---");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("---");
                    break;
            }
        } while (eleccion != 6);
    }

    private void mostrarR() {
        System.out.println(titulo);
        System.out.println(listaMenuR);
    }
}