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

    public int buscarEquipo(int numEquipo, String nombre, Partido partido) {
        int indice;
        for (indice = 0; indice <= equipos.size() - 1; indice++) {
            Equipo equi = equipos.get(indice);
            String nombreEqui = equi.getNombre();
            if (nombreEqui.equals(nombre)) {
                if (numEquipo == 1) {
                    partido.setEquipo1(nombre);
                } else {
                    partido.setEquipo2(nombre);
                }
                break;
            } else if (indice == equipos.size() - 1) {
                System.out.println("El equipo no se encuentra registrado");
                indice = -1;
                break;
            }
        }
        return indice;
    }

    public boolean verificarValor(int numEquipo, Boolean valorValido, Partido partido, int valor) {
        if (valor >= 0) {
            if (numEquipo == 1) {
                partido.setMarcador1(valor);
            } else {
                partido.setMarcador2(valor);
            }
            valorValido = true;
        } else {
            System.out.println("Ingrese un valor válido");
            valorValido = false;
        }
        return valorValido;
    }

    public void registrarPartido() {
        if (equipos.size() < 2) {
            System.out.println("No hay suficientes equipos registrados");
        } else {
            int indice;
            Partido partido = new Partido();
            System.out.println("Ingrese la fecha del partido: ");
            partido.setFecha(sc.nextLine());
            do {
                System.out.println("Ingrese el nombre del equipo local: ");
                String nombre = sc.nextLine();
                indice = buscarEquipo(1, nombre, partido);
            } while (indice == -1);
            indice = -1;
            do {
                System.out.println("Ingrese el nombre del equipo visitante: ");
                String nombre = sc.nextLine();
                indice = buscarEquipo(2, nombre, partido);
            } while (indice == -1);
            Boolean valorValido = false;
            do {
                System.out.println("Ingrese el número de goles del equipo local: ");
                marcador1 = sc.nextInt();
                valorValido = verificarValor(1, valorValido, partido, marcador1);
            } while (valorValido == false);
            valorValido = false;
            do {
                System.out.println("Ingrese el número de goles del equipo visitante: ");
                marcador2 = sc.nextInt();
                valorValido = verificarValor(2, valorValido, partido, marcador2);
            } while (valorValido == false);
            partidos.add(partido);
            // System.out.println(partido.getEquipo1() + partido.getEquipo2() + partido.getMarcador1() + partido.getMarcador2());
        }
    }

    public void calcularPuntos() {
        int golesEquipo1 = marcador1 - marcador2;
        int golesEquipo2 = marcador2 - marcador1;

    }
}
