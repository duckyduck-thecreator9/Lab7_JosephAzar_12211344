/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josephazar;

import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class Equipo {
    private String nombre;
    private int partidos, pg, pe, pp, gf, gc, dif;
    private ArrayList<Jugador> Jugadores;

    public Equipo(String nombre, int partidos, int pg, int pe, int pp, int gf, int gc, int dif) {
        this.nombre = nombre;
        this.partidos = partidos;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.dif = dif;
    }

    public Equipo(String nombre, int partidos, int pg, int pe, int pp, int gf, int gc, int dif, ArrayList Jugadores) {
        this.nombre = nombre;
        this.partidos = partidos;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.dif = dif;
        this.Jugadores = Jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", partidos=" + partidos + ", pg=" + pg + ", pe=" + pe + ", pp=" + pp + ", gf=" + gf + ", gc=" + gc + ", dif=" + dif + ", Jugadores=" + Jugadores + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }

    public ArrayList getJugadores() {
        return Jugadores;
    }

    public void setJugadores(ArrayList Jugadores) {
        this.Jugadores = Jugadores;
    }
    
    
}
