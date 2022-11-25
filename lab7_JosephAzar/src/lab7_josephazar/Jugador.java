/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josephazar;

import javax.swing.JOptionPane;

/**
 *
 * @author joseph
 */
public class Jugador {
    private String nombre, posicion;
    private int dorsal, goles, cantPartidos, asistencias, amarillas, rojas, faltas, faltas_Recibidas, porterias;

    public Jugador(String nombre, String posicion, int dorsal, int goles, int cantPartidos, int asistencias, int amarillas, int rojas, int faltas, int faltas_Recibidas) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.goles = goles;
        this.cantPartidos = cantPartidos;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.faltas = faltas;
        this.faltas_Recibidas = faltas_Recibidas;
    }

    public Jugador(String nombre, String posicion, int dorsal, int goles, int cantPartidos, int asistencias, int amarillas, int rojas, int faltas, int faltas_Recibidas, int porterias) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.goles = goles;
        this.cantPartidos = cantPartidos;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.faltas = faltas;
        this.faltas_Recibidas = faltas_Recibidas;
        this.porterias = porterias;
    }

    public Jugador() {
    }

    public int getPorterias() {
        return porterias;
    }

    public void setPorterias(int porterias) {
        this.porterias = porterias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        if (dorsal > 26 || dorsal < 1 ) {
            JOptionPane.showMessageDialog(null, "Numero tiene que ser entre 1 a 26");
        } else  {
        this.dorsal = dorsal;
        }
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getCantPartidos() {
        return cantPartidos;
    }

    public void setCantPartidos(int cantPartidos) {
        this.cantPartidos = cantPartidos;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public int getRojas() {
        return rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getFaltas_Recibidas() {
        return faltas_Recibidas;
    }

    public void setFaltas_Recibidas(int faltas_Recibidas) {
        this.faltas_Recibidas = faltas_Recibidas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", posicion=" + posicion + ", dorsal=" + dorsal + ", goles=" + goles + ", cantPartidos=" + cantPartidos + ", asistencias=" + asistencias + ", amarillas=" + amarillas + ", rojas=" + rojas + ", faltas=" + faltas + ", faltas_Recibidas=" + faltas_Recibidas + '}';
    }
        
    
}
