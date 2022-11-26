/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josephazar;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joseph
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() throws IOException {
        initComponents();
        Llenar_Usuarios();
        Llenar_Equipos();
        this.setLocationRelativeTo(this);
        this.setVisible(false);
        System.out.println(Usuarios.size());
        aparecer_login();
    }

    private void aparecer_login() {
     jD_Login.setModal(true);
     jD_Login.pack();
     jD_Login.setLocationRelativeTo(this);
     jD_Login.setVisible(rootPaneCheckingEnabled);
     tx_contrasena.setText("");
    }
    
    public void escribir_equipo(Equipo e) {              

        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        Scanner sc = null;
        try {
            String jugadores = "";
            ArrayList<Jugador> ju = e.getJugadores();
            for (int i = 0; i < e.getJugadores().size(); i++) {
               jugadores += ju.get(i).getNombre() + ";";
            }
            archivo = new File("./Equipos.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);

            bw.append( e.getNombre() + ", " + e.getPartidos() + ", " + e.getPg()+ ", " + e.getPe() + ", " + e.getPp() + ", " + e.getGf() + ", " + e.getGc() + ", " + e.getDif() + ", " + jugadores);
            bw.append("\n");
            bw.flush();
            System.out.println(e.getNombre());

            sc = new Scanner(archivo);

        } catch (IOException a) {
            a.printStackTrace();
        }
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            
        }

    }  
    
    public void escribir_equipos(ArrayList<Equipo> e) {              

        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        Scanner sc = null;
        try {
            for (int i = 0; i < e.size(); i++) {
                
            String jugadores = "";
//            ArrayList<Jugador> ju = e.get(i).getJugadores();
//            for (int j = 0; j < e.get(i).getJugadores().size(); i++) {
//               jugadores += (String)ju.get(j).toString();
//            }
            
            archivo = new File("./Equipos.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);

            bw.append( e.get(i).getNombre() + ", " + e.get(i).getPartidos() + ", " + e.get(i).getPg()+ ", " + e.get(i).getPe() + ", " + e.get(i).getPp() + ", " + e.get(i).getGf() + ", " + e.get(i).getGc() + ", " + e.get(i).getDif() + ", " + e.get(i).getJugadores());
            bw.append("\n");
            bw.flush();
            System.out.println(e.get(i).getNombre());
            
            }

        } catch (IOException a) {
            a.printStackTrace();
        }
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            
        }

    }  
    
    private void Vaciar_Usuario() {
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{

    FileWriter fw = new FileWriter("usuarios", false);

    PrintWriter pw = new PrintWriter(fw, false);

    pw.flush();

    pw.close();

    fw.close();

    }catch(Exception exception){

        System.out.println("Exception have been caught");

    }
    }
    
    private void Llenar_Equipos() throws IOException {
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File ("./Equipos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = "";
            
            
            while ( (linea = br.readLine()) != null) {
                String[] tokens = linea.split(", ");
                ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
                Equipo n = new Equipo( tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), jugadores );
                equipos.add(n);   
                String[] lista = tokens[8].split("]");
                for (int j = 0; j < lista.length; j++) {
                    String[] jugador = lista[j].split(";");
                    Jugador p = new Jugador(jugador[0], jugador[1], Integer.parseInt(jugador[2]), Integer.parseInt(jugador[3]), Integer.parseInt(jugador[4]), Integer.parseInt(jugador[5]), Integer.parseInt(jugador[6]), Integer.parseInt(jugador[7]), Integer.parseInt(jugador[8]), Integer.parseInt(jugador[9]) );
                    jugadores.add(p);
                }
                
                System.out.println(equipos);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        br.close();
        fr.close();
    }
    
    private void Llenar_Usuarios() throws IOException {
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File ("./usuarios.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = "";
            
            
            while ( (linea = br.readLine()) != null) {
                String[] tokens = linea.split(", ");
                Usuario n = new Usuario(tokens[0], tokens[1], false, false, Integer.parseInt(tokens[2]) );
                Usuarios.add(n);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        br.close();
        fr.close();
    }
    public void aparecer_menu () {
     jP_menu.setModal(true);
     jP_menu.pack();
     jP_menu.setLocationRelativeTo(this);
     jP_menu.setVisible(rootPaneCheckingEnabled);
}
    
    private void aparecer_registrarse() {
     jD_Registrarse.setModal(true);
     jD_Registrarse.pack();
     jD_Registrarse.setLocationRelativeTo(this);
     jD_Registrarse.setVisible(rootPaneCheckingEnabled);
    }
    
    private void aparecer_Ingresar() {
     Ingresar_equipo.setModal(true);
     Ingresar_equipo.pack();
     Ingresar_equipo.setLocationRelativeTo(this);
     Ingresar_equipo.setVisible(rootPaneCheckingEnabled);
    }
    
    private void aparecer_Jugadores() {
     Ingresar_jugadores.setModal(true);
     Ingresar_jugadores.pack();
     Ingresar_jugadores.setLocationRelativeTo(this);
     Ingresar_jugadores.setVisible(rootPaneCheckingEnabled);
    }
    
    private void aparecer_crear() {
     crear_ediitar.setModal(true);
     crear_ediitar.pack();
     crear_ediitar.setLocationRelativeTo(this);
     crear_ediitar.setVisible(rootPaneCheckingEnabled);
    }
    
    private void login (String usuario, String contrasena) {
        boolean falso = false;
        for (int i = 0; i < Usuarios.size(); i++) {
            System.out.println(Usuarios.get(i).getUsuario());
            System.out.println(Usuarios.get(i).isAdmin());
            if (usuario.contentEquals(Usuarios.get(i).getUsuario()) && contrasena.contentEquals(Usuarios.get(i).getContrasena()) ) {
                Usuarios.get(i).setActivo(true);
                JOptionPane.showMessageDialog(this, "Se ha ingresado correctamente");
                falso = true;
                
                if (Usuarios.get(i) instanceof Admin) {
                    System.out.println("ADMIS");
                    this.setVisible(true);
                    jD_Login.setVisible(false);
                } else if (Usuarios.get(i) instanceof Usuario) {
                    
                    jD_Login.setVisible(false);
                    aparecer_menu();
                    System.out.println("usuario");
                    this.setVisible(false);
                }
                break;
            }
         
        }
        if (falso == false) {
         JOptionPane.showMessageDialog(this, "Usuario o contrasena incorrecto");
        }
    }
    
    public void logout() {
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).isActivo() == true) {
                Usuarios.get(i).setActivo(false);
                jD_Login.setVisible(true);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jD_Login = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jT_usuario = new javax.swing.JTextField();
        tx_contrasena = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jD_Registrarse = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jt_registrou = new javax.swing.JTextField();
        jt_registroc = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jP_menu = new javax.swing.JDialog();
        jP_menu1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        crear_ediitar = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jc_grupo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jc_el = new javax.swing.JComboBox<>();
        jc_ev = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jt_pl = new javax.swing.JTextField();
        jt_rl = new javax.swing.JTextField();
        jt_fl = new javax.swing.JTextField();
        jt_tl = new javax.swing.JTextField();
        jt_pv = new javax.swing.JTextField();
        jt_rv = new javax.swing.JTextField();
        jt_fv = new javax.swing.JTextField();
        jt_tv = new javax.swing.JTextField();
        Ingresar_equipo = new javax.swing.JDialog();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nm_equipo = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        Ingresar_jugadores = new javax.swing.JDialog();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Equipos = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        dorsal = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        posicion = new javax.swing.JComboBox<>();
        p1 = new javax.swing.JRadioButton();
        p13 = new javax.swing.JRadioButton();
        p26 = new javax.swing.JRadioButton();
        numer_portero = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jD_Login.setBackground(java.awt.Color.yellow);
        jD_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jD_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jD_LoginMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Ingrese sus credenciales");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Contrasena");

        jButton7.setBackground(java.awt.Color.blue);
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Login");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jT_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_usuarioActionPerformed(evt);
            }
        });
        jT_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_usuarioKeyPressed(evt);
            }
        });

        tx_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_contrasenaActionPerformed(evt);
            }
        });
        tx_contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_contrasenaKeyPressed(evt);
            }
        });

        jButton4.setBackground(java.awt.Color.blue);
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Registrarse");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jD_LoginLayout = new javax.swing.GroupLayout(jD_Login.getContentPane());
        jD_Login.getContentPane().setLayout(jD_LoginLayout);
        jD_LoginLayout.setHorizontalGroup(
            jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jD_LoginLayout.createSequentialGroup()
                .addGroup(jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jD_LoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jD_LoginLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jD_LoginLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218))
                            .addGroup(jD_LoginLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jT_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jD_LoginLayout.createSequentialGroup()
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tx_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jD_LoginLayout.setVerticalGroup(
            jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jD_LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tx_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jD_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jD_Registrarse.setBackground(new java.awt.Color(255, 102, 102));
        jD_Registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jD_RegistrarseMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Lenar campos requeridos  para ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Usuario");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contrasena");

        jButton8.setBackground(new java.awt.Color(102, 102, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Registrarse");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jt_registrou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_registrouActionPerformed(evt);
            }
        });
        jt_registrou.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_registrouKeyPressed(evt);
            }
        });

        jt_registroc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_registrocActionPerformed(evt);
            }
        });
        jt_registroc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_registrocKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Crear usuario");

        javax.swing.GroupLayout jD_RegistrarseLayout = new javax.swing.GroupLayout(jD_Registrarse.getContentPane());
        jD_Registrarse.getContentPane().setLayout(jD_RegistrarseLayout);
        jD_RegistrarseLayout.setHorizontalGroup(
            jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jD_RegistrarseLayout.createSequentialGroup()
                .addGroup(jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jD_RegistrarseLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel8))
                    .addGroup(jD_RegistrarseLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jD_RegistrarseLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(218, 218, 218))
                                .addGroup(jD_RegistrarseLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jt_registrou, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jt_registroc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                            .addComponent(jLabel5))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jD_RegistrarseLayout.setVerticalGroup(
            jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jD_RegistrarseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(45, 45, 45)
                .addGroup(jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_registrou, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jD_RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jt_registroc, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab2", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab3", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab4", jPanel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Bienvenido");

        javax.swing.GroupLayout jP_menu1Layout = new javax.swing.GroupLayout(jP_menu1);
        jP_menu1.setLayout(jP_menu1Layout);
        jP_menu1Layout.setHorizontalGroup(
            jP_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(jP_menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_menu1Layout.setVerticalGroup(
            jP_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jP_menuLayout = new javax.swing.GroupLayout(jP_menu.getContentPane());
        jP_menu.getContentPane().setLayout(jP_menuLayout);
        jP_menuLayout.setHorizontalGroup(
            jP_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(jP_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_menuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jP_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jP_menuLayout.setVerticalGroup(
            jP_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
            .addGroup(jP_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_menuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jP_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Crear Partido");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Grupo");

        jLabel12.setText("Equipo local");

        jLabel13.setText("Equipo visitante");

        jLabel14.setText("Posesion");

        jLabel15.setText("Resultado");

        jLabel16.setText("Faltas");

        jLabel17.setText("Tiros");

        jc_ev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_evActionPerformed(evt);
            }
        });

        jButton5.setBackground(java.awt.Color.white);
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(java.awt.Color.blue);
        jButton5.setText("Ingresar al sistema");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jt_pl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_plActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crear_ediitarLayout = new javax.swing.GroupLayout(crear_ediitar.getContentPane());
        crear_ediitar.getContentPane().setLayout(crear_ediitarLayout);
        crear_ediitarLayout.setHorizontalGroup(
            crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crear_ediitarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crear_ediitarLayout.createSequentialGroup()
                        .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jc_el, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(crear_ediitarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jc_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 40, Short.MAX_VALUE))
                            .addGroup(crear_ediitarLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(jc_ev, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(crear_ediitarLayout.createSequentialGroup()
                        .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt_pl)
                            .addComponent(jt_rl)
                            .addComponent(jt_fl)
                            .addComponent(jt_tl))
                        .addGap(28, 28, 28)
                        .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(crear_ediitarLayout.createSequentialGroup()
                                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jt_fv, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(jt_tv)))
                            .addGroup(crear_ediitarLayout.createSequentialGroup()
                                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crear_ediitarLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(crear_ediitarLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(11, 11, 11)))
                                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jt_rv, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(jt_pv))))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, crear_ediitarLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        crear_ediitarLayout.setVerticalGroup(
            crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crear_ediitarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jc_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(crear_ediitarLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(crear_ediitarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jc_el, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jc_ev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jt_pl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_pv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jt_rl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_rv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jt_fl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_fv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(crear_ediitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jt_tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_tv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Creacion de seleccion");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Nombre");

        nm_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nm_equipoActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Crear seleccion");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Ingresar_equipoLayout = new javax.swing.GroupLayout(Ingresar_equipo.getContentPane());
        Ingresar_equipo.getContentPane().setLayout(Ingresar_equipoLayout);
        Ingresar_equipoLayout.setHorizontalGroup(
            Ingresar_equipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingresar_equipoLayout.createSequentialGroup()
                .addGroup(Ingresar_equipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Ingresar_equipoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Ingresar_equipoLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Ingresar_equipoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Ingresar_equipoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nm_equipo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        Ingresar_equipoLayout.setVerticalGroup(
            Ingresar_equipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingresar_equipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nm_equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Agregar jugador a seleccion");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Seleccion a la que pertenece");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Nombre");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Dorsal");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Posicion");

        jNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNombreActionPerformed(evt);
            }
        });

        jButton9.setText("Agregar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        posicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Defensa", "Medio campista", "Delantero", "Portero" }));
        posicion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                posicionItemStateChanged(evt);
            }
        });

        numer_portero.add(p1);
        p1.setText("1");

        numer_portero.add(p13);
        p13.setText("13");

        numer_portero.add(p26);
        p26.setText("26");

        javax.swing.GroupLayout Ingresar_jugadoresLayout = new javax.swing.GroupLayout(Ingresar_jugadores.getContentPane());
        Ingresar_jugadores.getContentPane().setLayout(Ingresar_jugadoresLayout);
        Ingresar_jugadoresLayout.setHorizontalGroup(
            Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                        .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Ingresar_jugadoresLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(35, 35, 35)
                                .addComponent(jNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addComponent(Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(34, 34, 34)
                        .addComponent(posicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41))
                    .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(dorsal)
                        .addGap(18, 18, 18)
                        .addComponent(p1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                        .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        Ingresar_jugadoresLayout.setVerticalGroup(
            Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingresar_jugadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(Equipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(dorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1)
                    .addComponent(p13)
                    .addComponent(p26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Ingresar_jugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(posicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Menu Principal");

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(java.awt.Color.blue);
        jButton1.setText("Crear/Editar partido");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.white);
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(java.awt.Color.blue);
        jButton2.setText("Ingresar seleccion");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(java.awt.Color.white);
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(java.awt.Color.blue);
        jButton3.setText("Ingresar Jugadores");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       this.setVisible(false);
       aparecer_crear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setForeground(Color.white);
        jButton1.setBackground(Color.blue);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setForeground(Color.blue);
        jButton1.setBackground(Color.white);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(Color.white);
        jButton2.setBackground(Color.blue);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.blue);
        jButton2.setBackground(Color.white);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setForeground(Color.white);
        jButton3.setBackground(Color.blue);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setForeground(Color.blue);
        jButton3.setBackground(Color.white);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jButton7.setBackground(Color.white);
        jButton7.setForeground(Color.blue);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        jButton7.setBackground(Color.blue);
        jButton7.setForeground(Color.white);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        login(jT_usuario.getText(), tx_contrasena.getText());
        this.setVisible(false);
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jT_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_usuarioActionPerformed

    private void jT_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_usuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            login(jT_usuario.getText(), tx_contrasena.getText());
            this.setVisible(true);
        }
    }//GEN-LAST:event_jT_usuarioKeyPressed

    private void tx_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_contrasenaActionPerformed

    private void tx_contrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_contrasenaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            login(jT_usuario.getText(), tx_contrasena.getText());
            this.setVisible(true);
        }
    }//GEN-LAST:event_tx_contrasenaKeyPressed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(Color.white);
        jButton1.setForeground(Color.blue);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(Color.blue);
        jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        aparecer_registrarse();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jD_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jD_LoginMouseClicked
        // TODO add your handling code here:
        if (evt.isMetaDown()) {

        }
    }//GEN-LAST:event_jD_LoginMouseClicked

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        jButton8.setBackground(Color.white);
        jButton8.setForeground(Color.blue);
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
        jButton8.setBackground(Color.blue);
        jButton8.setForeground(Color.white);
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Usuario u = new Usuario(jt_registrou.getText(), jt_registroc.getText(), false, false);
        u.setId(182934 + Usuarios.size());
        
        Usuarios.add(u);
        System.out.println(Usuarios);
        jD_Registrarse.setVisible(false);

        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        Scanner sc = null;
        try {
            archivo = new File("./usuarios.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            bw.append("\n");
            bw.append(u.getUsuario() + ", " + u.getContrasena() + ", " + u.getId());
            bw.flush();
            System.out.println(u.getUsuario());

            sc = new Scanner(archivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jt_registrouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_registrouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_registrouActionPerformed

    private void jt_registrouKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_registrouKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            login(jT_usuario.getText(), tx_contrasena.getText());
        }
    }//GEN-LAST:event_jt_registrouKeyPressed

    private void jt_registrocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_registrocActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jt_registrocActionPerformed

    private void jt_registrocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_registrocKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            login(jT_usuario.getText(), tx_contrasena.getText());
        }
    }//GEN-LAST:event_jt_registrocKeyPressed

    private void jD_RegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jD_RegistrarseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jD_RegistrarseMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        aparecer_Ingresar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        for (int i = 0; i < equipos.size(); i++) {
            Equipos.addItem(equipos.get(i).getNombre());
        }
        p1.setVisible(false);
        p13.setVisible(false);
        p26.setVisible(false);
        aparecer_Jugadores();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jt_plActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_plActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_plActionPerformed

    private void jc_evActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_evActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_evActionPerformed

    private void nm_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nm_equipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nm_equipoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ArrayList jugadores = new ArrayList();
        Equipo e = new Equipo(nm_equipo.getText(), 0, 0, 0, 0, 0, 0, 0, jugadores);
        equipos.add(e);
        escribir_equipo(e);
        Ingresar_equipo.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNombreActionPerformed

    private void posicionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_posicionItemStateChanged
        // TODO add your handling code here:
        dorsal.setVisible(false);
        if ( posicion.getSelectedItem().equals("Portero") ) {
        p1.setVisible(true);
        p13.setVisible(true);
        p26.setVisible(true);
        posicion.setVisible(true);
        } else {
            dorsal.setVisible(true);
            posicion.setVisible(true);
        }
    }//GEN-LAST:event_posicionItemStateChanged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int dorsal = 0;
        if ( posicion.getSelectedItem().equals("Portero") ) {
            if(p1.isSelected()) {
                dorsal = Integer.parseInt(p1.getText());
                Jugador j = new Jugador(jNombre.getText(), (String)posicion.getSelectedItem(), dorsal);
                
                for (int i = 0; i < equipos.size(); i++) {
                    if ( equipos.get(i).getNombre().equals((String)Equipos.getSelectedItem()) ) {
                    equipos.get(i).getJugadores().add(j);
            }
        }
            } else if(p13.isSelected()) {
                dorsal = Integer.parseInt(p13.getText());
                Jugador j = new Jugador(jNombre.getText(), (String)posicion.getSelectedItem(), dorsal);
                for (int i = 0; i < equipos.size(); i++) {
            if ( equipos.get(i).getNombre().equals((String)Equipos.getSelectedItem()) ) {
                equipos.get(i).getJugadores().add(j);
            }
        }
            } else if(p26.isSelected()) {
                dorsal = Integer.parseInt(p26.getText());
                Jugador j = new Jugador(jNombre.getText(), (String)posicion.getSelectedItem(), dorsal);
                for (int i = 0; i < equipos.size(); i++) {
            if ( equipos.get(i).getNombre().equals((String)Equipos.getSelectedItem()) ) {
                equipos.get(i).getJugadores().add(j);
            }
        }
            }
        }  else {
        Jugador j = new Jugador(jNombre.getText(), (String)posicion.getSelectedItem(), dorsal);       
        for (int i = 0; i < equipos.size(); i++) {
            if ( equipos.get(i).getNombre().equals((String)Equipos.getSelectedItem()) ) {
                equipos.get(i).getJugadores().add(j);
            }
        }
        }
        System.out.println(equipos);
        escribir_equipos(equipos);
        
        Ingresar_jugadores.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Equipos;
    private javax.swing.JDialog Ingresar_equipo;
    private javax.swing.JDialog Ingresar_jugadores;
    private javax.swing.JDialog crear_ediitar;
    private javax.swing.JTextField dorsal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jD_Login;
    private javax.swing.JDialog jD_Registrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNombre;
    private javax.swing.JDialog jP_menu;
    private javax.swing.JPanel jP_menu1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jT_usuario;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> jc_el;
    private javax.swing.JComboBox<String> jc_ev;
    private javax.swing.JComboBox<String> jc_grupo;
    private javax.swing.JTextField jt_fl;
    private javax.swing.JTextField jt_fv;
    private javax.swing.JTextField jt_pl;
    private javax.swing.JTextField jt_pv;
    private javax.swing.JPasswordField jt_registroc;
    private javax.swing.JTextField jt_registrou;
    private javax.swing.JTextField jt_rl;
    private javax.swing.JTextField jt_rv;
    private javax.swing.JTextField jt_tl;
    private javax.swing.JTextField jt_tv;
    private javax.swing.JTextField nm_equipo;
    private javax.swing.ButtonGroup numer_portero;
    private javax.swing.JRadioButton p1;
    private javax.swing.JRadioButton p13;
    private javax.swing.JRadioButton p26;
    private javax.swing.JComboBox<String> posicion;
    private javax.swing.JPasswordField tx_contrasena;
    // End of variables declaration//GEN-END:variables
static ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
static Random r = new Random();
static ArrayList<Usuario> admins = new ArrayList<Usuario>();
static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
}
