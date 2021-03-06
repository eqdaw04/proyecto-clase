/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import Excepciones.Excepcion;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Vista para la carga del login.
 * Fecha de creación de la vista: 23/04/2018
 * @author eqdaw04
 */
public class VLogin extends javax.swing.JFrame {

    int error, cont = 0;
    
    public VLogin(int n) {
        initComponents();
        CrearImagenes(n);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        bAcceder = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        pfContrasenna = new javax.swing.JPasswordField();
        imgusu = new javax.swing.JLabel();
        imgpassw = new javax.swing.JLabel();
        logotipo = new javax.swing.JLabel();
        imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 66, 255));
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(562, 496));
        setMinimumSize(new java.awt.Dimension(562, 496));
        setPreferredSize(new java.awt.Dimension(562, 496));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel1.setText("¡Bienvenidos a E-Sport!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 450, 70);

        tfUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(tfUsuario);
        tfUsuario.setBounds(190, 150, 150, 30);

        bAcceder.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        bAcceder.setText("Acceder");
        bAcceder.setAutoscrolls(true);
        bAcceder.setPreferredSize(new java.awt.Dimension(67, 31));
        bAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAccederActionPerformed(evt);
            }
        });
        getContentPane().add(bAcceder);
        bAcceder.setBounds(110, 300, 120, 40);

        bSalir.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        getContentPane().add(bSalir);
        bSalir.setBounds(290, 300, 120, 40);

        pfContrasenna.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pfContrasenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContrasennaActionPerformed(evt);
            }
        });
        getContentPane().add(pfContrasenna);
        pfContrasenna.setBounds(190, 230, 150, 30);
        getContentPane().add(imgusu);
        imgusu.setBounds(130, 150, 40, 40);
        getContentPane().add(imgpassw);
        imgpassw.setBounds(130, 220, 40, 40);

        logotipo.setAlignmentX(0.5F);
        getContentPane().add(logotipo);
        logotipo.setBounds(480, 390, 80, 70);
        getContentPane().add(imgfondo);
        imgfondo.setBounds(0, 0, 560, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
    private  void CrearImagenes(int n){
        try{
            setLocationRelativeTo(null);
            this.getContentPane().setBackground(new Color(70, 130, 180));

            setTitle("Bienvenido a E-Sport");

            ImageIcon usuario = new ImageIcon("imagenes/user.png");
            Icon icono = new ImageIcon (usuario.getImage().getScaledInstance(imgusu.getWidth(), imgusu.getHeight(), Image.SCALE_DEFAULT));
            imgusu.setIcon(icono);
            this.repaint();

            ImageIcon passw = new ImageIcon("imagenes/contrasenna.png");
            Icon icono2 = new ImageIcon (passw.getImage().getScaledInstance(imgpassw.getWidth(), imgpassw.getHeight(), Image.SCALE_DEFAULT));
            imgpassw.setIcon(icono2);
            this.repaint();

            ImageIcon logo = new ImageIcon("imagenes/4fan.png");
            Icon icono3 = new ImageIcon(logo.getImage().getScaledInstance(logotipo.getWidth(), logotipo.getHeight(), Image.SCALE_DEFAULT));
            logotipo.setIcon(icono3);
            this.repaint();

            ImageIcon fondo = new ImageIcon("imagenes/fondo2.jpg");
            Icon icono4 = new ImageIcon (fondo.getImage().getScaledInstance(imgfondo.getWidth(), imgfondo.getHeight(), Image.SCALE_DEFAULT));
            imgfondo.setIcon(icono4);
            this.repaint();

            if(n==0){
                // cambiar a 3000 a la entrega de la app
                Thread.sleep(1500);
            }
            setVisible(true);
        }
        catch (InterruptedException e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
        
    }
    
    public JPasswordField getPfContrasenna() {
        return pfContrasenna;
    }
    
    /**
     * Metodo para obtener el usuario.
     * @return devuelve el usuario
     */

    public JTextField getTfUsuario() {
        return tfUsuario;
    }
    
    /**
     * Metodo para obtener errores.
     * @return devuelve un error
     */

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        Main.salirDelPrograma(this);
    }//GEN-LAST:event_bSalirActionPerformed

    private void bAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAccederActionPerformed
        try
        {
            if (tfUsuario.getText().isEmpty())
            {
                throw new Excepcion(1);
            }
            else if (String.copyValueOf(pfContrasenna.getPassword()).isEmpty())
            {
                throw new Excepcion(2);
            }
            else{

                Main.accederPrincipal(tfUsuario.getText(), pfContrasenna.getPassword());
            }
        }
        catch (Excepcion e)
        {
            pfContrasenna.setText("");
            pfContrasenna.grabFocus();
            JOptionPane.showMessageDialog(this, e.getMessage() + "(" + cont + "/3)", "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
        finally{
            if(cont == 3){
                Main.salir(this);
            }
        }
    }//GEN-LAST:event_bAccederActionPerformed

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void pfContrasennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContrasennaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfContrasennaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAcceder;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JLabel imgpassw;
    private javax.swing.JLabel imgusu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logotipo;
    private javax.swing.JPasswordField pfContrasenna;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
