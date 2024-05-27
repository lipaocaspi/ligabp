package com.paola.ligabetplay.menu;

import java.util.ArrayList;
import java.util.Scanner;

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
        4. Total de goles de cada equipo
        5. Promedio de goles anotados
        6. Salir al menú principal
        """;

    public void mostrarMenuP() {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        do {
            mostrarP();
            System.out.println("Ingrese la opción: ");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    Equipo equipo = new Equipo();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del equipo: ");
                    equipo.setNombre(sc.nextLine());
                    equipo.setPj(0);
                    equipo.setPg(0);
                    equipo.setPp(0);
                    equipo.setPe(0);
                    equipo.setGf(0);
                    equipo.setGc(0);
                    equipo.setTp(0);
                    equipos.add(equipo);
                    // System.out.println(equipo.getNombre());
                    // System.out.println(equipos);
                    break;
                case 2:
                    if (equipos.size() < 2) {
                        System.out.println("No hay suficientes equipos registrados");
                    } else {
                        Boolean equipoExiste = false;
                        Partido partido = new Partido();
                        sc.nextLine();
                        System.out.println("Ingrese la fecha del partido: ");
                        partido.setFecha(sc.nextLine());
                        do {
                            System.out.println("Ingrese el nombre del equipo local: ");
                            String nombre = sc.nextLine();
                            for (int i = 0; i <= equipos.size() - 1; i++) {
                                Equipo equi = equipos.get(i);
                                String nombreEqui = equi.getNombre();
                                if (nombreEqui.equals(nombre)) {
                                    partido.setEquipo1(nombre);
                                    equipoExiste = true;
                                    break;
                                } else if (i == equipos.size() - 1) {
                                    System.out.println("El equipo no se encuentra registrado");
                                }
                            }
                        } while (equipoExiste == false);
                        equipoExiste = false;
                        do {
                            System.out.println("Ingrese el nombre del equipo visitante: ");
                            String nombre = sc.nextLine();
                            for (int i = 0; i <= equipos.size() - 1; i++) {
                                Equipo equi = equipos.get(i);
                                String nombreEqui = equi.getNombre();
                                if (nombreEqui.equals(nombre)) {
                                    partido.setEquipo2(nombre);
                                    equipoExiste = true;
                                    break;
                                } else if (i == equipos.size() - 1) {
                                    System.out.println("El equipo no se encuentra registrado");
                                }
                            }
                        } while (equipoExiste == false);
                        Boolean valorValido = false;
                        do {
                            System.out.println("Ingrese el número de goles del equipo local: ");
                            int marcador1 = sc.nextInt();
                            if (marcador1 >= 0) {
                                partido.setMarcador1(marcador1);
                                valorValido = true;
                                break;
                            } else {
                                System.out.println("Ingrese un valor válido");
                            }
                        } while (valorValido == false);
                        valorValido = false;
                        do {
                            System.out.println("Ingrese el número de goles del equipo visitante: ");
                            int marcador2 = sc.nextInt();
                            if (marcador2 >= 0) {
                                partido.setMarcador2(marcador2);
                                valorValido = true;
                                break;
                            } else {
                                System.out.println("Ingrese un valor válido");
                            }
                        } while (valorValido == false);
                        partidos.add(partido);
                    }
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