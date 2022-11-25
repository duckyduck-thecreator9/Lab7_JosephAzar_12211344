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
public class Usuario {
    private String usuario;
    private String contrasena;
    private boolean activo;
    private boolean admin;
    private int id;

    public Usuario(String usuario, String contrasena, boolean activo, boolean admin, int id) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.activo = activo;
        this.admin = admin;
        this.id = id;
    }

    public Usuario(String usuario, String contrasena, boolean activo, boolean admin) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.activo = activo;
        this.admin = admin;
    }

    public Usuario() {
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", activo=" + activo + ", admin=" + admin + ", id=" + id + '}';
    }

    
}