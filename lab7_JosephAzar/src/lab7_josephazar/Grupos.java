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
public class Grupos {
    private int posivion;
    ArrayList<Equipo> equipos;

    public Grupos(int posivion, ArrayList<Equipo> equipos) {
        this.posivion = posivion;
        this.equipos = equipos;
    }

    public int getPosivion() {
        return posivion;
    }

    public void setPosivion(int posivion) {
        this.posivion = posivion;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Grupos{" + "posivion=" + posivion + ", equipos=" + equipos + '}';
    }
    
}
