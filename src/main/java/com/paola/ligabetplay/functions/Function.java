package com.paola.ligabetplay.functions;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Equipo;
import com.paola.ligabetplay.models.Partido;

public class Function {
    ArrayList<Equipo> equipos = new ArrayList<>();
    ArrayList<Partido> partidos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int marcador1;
    int marcador2;

    public void registrarEquipo() {
        Equipo equipo = new Equipo();
        // sc.nextLine();
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
    }

    public void registrarPartido() {
        if (equipos.size() < 2) {
            System.out.println("No hay suficientes equipos registrados");
        } else {
            Boolean equipoExiste = false;
            Partido partido = new Partido();
            // sc.nextLine();
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
                marcador1 = sc.nextInt();
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
                marcador2 = sc.nextInt();
                if (marcador2 >= 0) {
                    partido.setMarcador2(marcador2);
                    valorValido = true;
                    break;
                } else {
                    System.out.println("Ingrese un valor válido");
                }
            } while (valorValido == false);
            partidos.add(partido);
            System.out.println(partido.getEquipo1() + partido.getEquipo2() + partido.getMarcador1() + partido.getMarcador2());
        }
    }

    public void calcularPuntos() {
        int golesEquipo1 = marcador1 - marcador2;
        int golesEquipo2 = marcador2 - marcador1;

    }
}
