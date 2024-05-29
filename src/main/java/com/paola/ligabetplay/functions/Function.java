package com.paola.ligabetplay.functions;

import java.util.ArrayList;
import java.util.Scanner;

import com.paola.ligabetplay.models.Equipo;
import com.paola.ligabetplay.models.Partido;

public class Function {
    ArrayList<Equipo> equipos = new ArrayList<>();
    ArrayList<Partido> partidos = new ArrayList<>();
    int marcador1;
    int marcador2;

    public ArrayList<Equipo> registrarEquipo() {
        Scanner sc = new Scanner(System.in);
        Equipo equipo = new Equipo();
        Boolean existe = false;
        if (equipos.isEmpty()) {
            System.out.println("Ingrese el nombre del equipo: ");
            String nombre = sc.nextLine();
            equipo.setNombre(nombre);
            equipo.setPj(0);
            equipo.setPg(0);
            equipo.setPp(0);
            equipo.setPe(0);
            equipo.setGf(0);
            equipo.setGc(0);
            equipo.setTp(0);
            equipos.add(equipo);
        } else {
            do {
                System.out.println("Ingrese el nombre del equipo: ");
                String nombre = sc.nextLine();
                for (int indice = 0; indice <= equipos.size() - 1; indice++) {
                    Equipo equi = equipos.get(indice);
                    String nombreEqui = equi.getNombre();
                    if (nombreEqui.equals(nombre)) {
                        System.out.println("---");
                        System.out.println("El equipo ya se encuentra registrado");
                        System.out.println("---");
                        existe = true;
                        break;
                    } else if (indice == equipos.size() - 1) {
                        equipo.setNombre(nombre);
                        equipo.setPj(0);
                        equipo.setPg(0);
                        equipo.setPp(0);
                        equipo.setPe(0);
                        equipo.setGf(0);
                        equipo.setGc(0);
                        equipo.setTp(0);
                        equipos.add(equipo);
                        existe = true;
                        break;
                    }
                }
            } while (existe == false);
        }
        return equipos;
    }

    public int buscarEquipo(int numEquipo, String nombre, Partido partido) {
        int indice;
        for (indice = 0; indice <= equipos.size() - 1; indice++) {
            Equipo equi = equipos.get(indice);
            String nombreEqui = equi.getNombre();
            if (nombreEqui.equals(nombre)) {
                if (numEquipo == 1) {
                    partido.setEquipo1(nombre);
                } else if (partido.getEquipo1().equals(nombre)) {
                    System.out.println("---");
                    System.out.println("Un equipo no puede enfrentarse consigo mismo");
                    System.out.println("---");
                    indice = -1;
                } else {
                    partido.setEquipo2(nombre);
                }
                break;
            } else if (indice == equipos.size() - 1) {
                System.out.println("---");
                System.out.println("El equipo no se encuentra registrado");
                System.out.println("---");
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
            System.out.println("---");
            System.out.println("Ingrese un valor válido");
            System.out.println("---");
            valorValido = false;
        }
        return valorValido;
    }

    public ArrayList<Partido> registrarPartido() {
        Scanner sc = new Scanner(System.in);
        if (equipos.size() < 2) {
            System.out.println("---");
            System.out.println("No hay suficientes equipos registrados");
            System.out.println("---");
        } else {
            int indice1;
            int indice2;
            Partido partido = new Partido();
            System.out.println("Ingrese la fecha del partido: ");
            partido.setFecha(sc.nextLine());
            do {
                System.out.println("Ingrese el nombre del equipo local: ");
                String nombre = sc.nextLine();
                indice1 = buscarEquipo(1, nombre, partido);
            } while (indice1 == -1);
            do {
                System.out.println("Ingrese el nombre del equipo visitante: ");
                String nombre = sc.nextLine();
                indice2 = buscarEquipo(2, nombre, partido);
            } while (indice2 == -1);
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
            calcularPuntos(indice1, indice2);
        }
        return partidos;
    }

    public void calcularPuntos(int indice1, int indice2) {
        int difGoles = marcador1 - marcador2;
        Equipo indiceE1 = equipos.get(indice1);
        Equipo indiceE2 = equipos.get(indice2);
        if (difGoles == 0) {
            indiceE1.setPj(indiceE1.getPj() + 1);
            indiceE1.setPe(indiceE1.getPe() + 1);
            indiceE1.setGt(indiceE1.getGt() + marcador1);
            indiceE1.setTp(indiceE1.getTp() + 1);
            indiceE2.setPj(indiceE2.getPj() + 1);
            indiceE2.setPe(indiceE2.getPe() + 1);
            indiceE2.setGt(indiceE2.getGt() + marcador2);
            indiceE2.setTp(indiceE2.getTp() + 1);
        } else if (difGoles > 0) {
            indiceE1.setPj(indiceE1.getPj() + 1);
            indiceE1.setPg(indiceE1.getPg() + 1);
            indiceE1.setGt(indiceE1.getGt() + marcador1);
            indiceE1.setGf(indiceE1.getGf() + difGoles);
            indiceE1.setTp(indiceE1.getTp() + 3);
            indiceE2.setPj(indiceE2.getPj() + 1);
            indiceE2.setPp(indiceE2.getPp() + 1);
            indiceE2.setGt(indiceE2.getGt() + marcador2);
            indiceE2.setGc(indiceE2.getGc() + difGoles);
        } else {
            indiceE2.setPj(indiceE2.getPj() + 1);
            indiceE2.setPg(indiceE2.getPg() + 1);
            indiceE2.setGt(indiceE2.getGt() + marcador2);
            indiceE2.setGf(indiceE2.getGf() + (-1)*difGoles);
            indiceE2.setTp(indiceE2.getTp() + 3);
            indiceE1.setPj(indiceE1.getPj() + 1);
            indiceE1.setPp(indiceE1.getPp() + 1);
            indiceE1.setGt(indiceE1.getGt() + marcador1);
            indiceE1.setGc(indiceE1.getGc() + (-1)*difGoles);
        }
        System.out.println("*******************");
        System.out.println("TABLA DE POSICIONES");
        System.out.println("*******************");
        System.out.println(indiceE1.getNombre());
        System.out.println("PJ " + indiceE1.getPj());
        System.out.println("PG " + indiceE1.getPg());
        System.out.println("PP " + indiceE1.getPp());
        System.out.println("PE " + indiceE1.getPe());
        System.out.println("GF " + indiceE1.getGf());
        System.out.println("GC " + indiceE1.getGc());
        System.out.println("TP " + indiceE1.getTp());
        System.out.println(indiceE2.getNombre());
        System.out.println("PJ " + indiceE2.getPj());
        System.out.println("PG " + indiceE2.getPg());
        System.out.println("PP " + indiceE2.getPp());
        System.out.println("PE " + indiceE2.getPe());
        System.out.println("GF " + indiceE2.getGf());
        System.out.println("GC " + indiceE2.getGc());
        System.out.println("TP " + indiceE2.getTp());
    }

    public void equipoMasGoles(ArrayList<Equipo> equipos) {
        String nombreEquipo = "";
        int refGoles = 0;
        int i = 0;
        do {
            Equipo equi = equipos.get(i);
            int golesF = equi.getGf();
            if (golesF > refGoles) {
                refGoles = golesF;
                nombreEquipo = equi.getNombre();
            }
            i++;
        } while (i <= equipos.size() - 1);
        System.out.println("---");
        System.out.println("Equipo con más goles: " + nombreEquipo);
        System.out.println("---");
    }

    public void equipoMasPuntos(ArrayList<Equipo> equipos) {
        String nombreEquipo = "";
        int refPuntos = 0;
        int i = 0;
        do {
            Equipo equi = equipos.get(i);
            int totalPuntos = equi.getTp();
            if (totalPuntos > refPuntos) {
                refPuntos = totalPuntos;
                nombreEquipo = equi.getNombre();
            }
            i++;
        } while (i <= equipos.size() - 1);
        System.out.println("---");
        System.out.println("Equipo con más puntos: " + nombreEquipo);
        System.out.println("---");
    }

    public void equipoMasPartidosGanados(ArrayList<Equipo> equipos) {
        String nombreEquipo = "";
        int refPartidosGanados = 0;
        int i = 0;
        do {
            Equipo equi = equipos.get(i);
            int partidosGanados = equi.getPg();
            if (partidosGanados > refPartidosGanados) {
                refPartidosGanados = partidosGanados;
                nombreEquipo = equi.getNombre();
            }
            i++;
        } while (i <= equipos.size() - 1);
        System.out.println("---");
        System.out.println("Equipo con más partidos ganados: " + nombreEquipo);
        System.out.println("---");
    }

    public int totalGoles(ArrayList<Equipo> equipos) {
        int sumaGoles = 0;
        int goles;
        for (int indice = 0; indice <= equipos.size() - 1; indice++) {
            Equipo equi = equipos.get(indice);
            goles = equi.getGt();
            sumaGoles = sumaGoles + goles;
        }
        return sumaGoles;
    }

    public void promedioGoles(ArrayList<Equipo> equipos, int numeroGoles) {
        float promedioGoles = numeroGoles/equipos.size();
        System.out.println("---");
        System.out.println("El promedio de goles es: " + promedioGoles);
        System.out.println("---");
    }
}