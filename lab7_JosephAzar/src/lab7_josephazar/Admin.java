/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josephazar;

/**
 *
 * @author joseph
 */
public class Admin extends Usuario{

    public Admin(String usuario, String contrasena, boolean activo, boolean admin, int id) {
        super(usuario, contrasena, activo, admin, id);
    }

    public Admin(String usuario, String contrasena, boolean activo, boolean admin) {
        super(usuario, contrasena, activo, admin);
    }

    public Admin() {
    }
    
    
}
