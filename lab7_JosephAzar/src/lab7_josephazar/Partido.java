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
public class Partido {
    private Equipo local;
    private Equipo visita;
    private int golesl, golesv, posesionl, posesionv, tirosl, tirosv, faltasl, faltasv;
    private ArrayList<Jugador> faltas = new ArrayList<Jugador>();
    private ArrayList<Jugador> amarillas = new ArrayList<Jugador>();
    private ArrayList<Jugador> goles = new ArrayList<Jugador>();

    public Partido(Equipo local, Equipo visita, int golesl, int golesv, int posesionl, int posesionv, int tirosl, int tirosv, int faltasl, int faltasv) {
        this.local = local;
        this.visita = visita;
        this.golesl = golesl;
        this.golesv = golesv;
        this.posesionl = posesionl;
        this.posesionv = posesionv;
        this.tirosl = tirosl;
        this.tirosv = tirosv;
        this.faltasl = faltasl;
        this.faltasv = faltasv;
    }

    @Override
    public String toString() {
        return "Partido{" + "local=" + local + ", visita=" + visita + ", golesl=" + golesl + ", golesv=" + golesv + ", posesionl=" + posesionl + ", posesionv=" + posesionv + ", tirosl=" + tirosl + ", tirosv=" + tirosv + ", faltasl=" + faltasl + ", faltasv=" + faltasv + ", faltas=" + faltas + ", amarillas=" + amarillas + ", goles=" + goles + '}';
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisita() {
        return visita;
    }

    public void setVisita(Equipo visita) {
        this.visita = visita;
    }

    public int getGolesl() {
        return golesl;
    }

    public void setGolesl(int golesl) {
        this.golesl = golesl;
    }

    public int getGolesv() {
        return golesv;
    }

    public void setGolesv(int golesv) {
        this.golesv = golesv;
    }

    public int getPosesionl() {
        return posesionl;
    }

    public void setPosesionl(int posesionl) {
        this.posesionl = posesionl;
    }

    public int getPosesionv() {
        return posesionv;
    }

    public void setPosesionv(int posesionv) {
        this.posesionv = posesionv;
    }

    public int getTirosl() {
        return tirosl;
    }

    public void setTirosl(int tirosl) {
        this.tirosl = tirosl;
    }

    public int getTirosv() {
        return tirosv;
    }

    public void setTirosv(int tirosv) {
        this.tirosv = tirosv;
    }

    public int getFaltasl() {
        return faltasl;
    }

    public void setFaltasl(int faltasl) {
        this.faltasl = faltasl;
    }

    public int getFaltasv() {
        return faltasv;
    }

    public void setFaltasv(int faltasv) {
        this.faltasv = faltasv;
    }

    public ArrayList<Jugador> getFaltas() {
        return faltas;
    }

    public void setFaltas(ArrayList<Jugador> faltas) {
        this.faltas = faltas;
    }

    public ArrayList<Jugador> getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(ArrayList<Jugador> amarillas) {
        this.amarillas = amarillas;
    }

    public ArrayList<Jugador> getGoles() {
        return goles;
    }

    public void setGoles(ArrayList<Jugador> goles) {
        this.goles = goles;
    }
    
    
}
