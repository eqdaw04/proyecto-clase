/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import javax.swing.JOptionPane;
import Excepciones.Excepcion;
import UML.Perfil;
import UML.Persona;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Vista de datos del usuario.
 * Fecha de creación de la vista: 24/04/2018
 * @author eqdaw04
 */

public class VPersona extends javax.swing.JDialog {
    private String tipo;
    private int n, contador;
    /**
     * Creates new form VUsuario
     */

    ArrayList <Persona> lPersona;
    
    public VPersona(String tipo, int n) {
        initComponents();
        //mostrar opciones según tipo de operaciones CRUD que se quiera realizar
        cargarDatos(tipo, n);
    }
    
    /**
     * Metodo para poder introducir datos de usuario.
     * @param tipo String
     * @param n int
     */
    
    private void cargarDatos(String tipo, int n){
        this.n = n;
        this.tipo = tipo;
        setModal(true);
        setLocationRelativeTo(null);
        try{
            cbPerfil.removeAllItems();
            ArrayList <Perfil> listaPerfil;
            listaPerfil = Main.consultarTodosLosPerfiles();
            listaPerfil.forEach((pa) -> {
                cbPerfil.addItem(pa.getNombre());
            });
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
        cbPerfil.setSelectedIndex(-1);
        lPersona = new ArrayList();
        bPrimero.setVisible(false);
        bAnterior.setVisible(false);
        bSiguiente.setVisible(false);
        bUltimo.setVisible(false);
        switch(tipo)
        {
            case "alta":
                tfNombre.setEditable(true);
                pfContrasenna.setEditable(true);
                tfApellido1.setEditable(true);
                tfApellido2.setEditable(true);
                tfEmail.setEditable(true);
                cbPerfil.setEnabled(true);
                bAceptar.setEnabled(true);
                bBuscar.setVisible(false);
                ccFechaAlta.setEditable(true);
                break;
            
            case "listado":
                bPrimero.setVisible(true);
                bAnterior.setVisible(true);
                bSiguiente.setVisible(true);
                bUltimo.setVisible(true);
                bAceptar.setVisible(false);
                bCancelar.setVisible(true);
                break;
        }
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        bPrimero = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        bUltimo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        ccFechaAlta = new org.freixas.jcalendar.JCalendarCombo();
        jLabel3 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfApellido1 = new javax.swing.JTextField();
        tfApellido2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pfContrasenna = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(459, 480));
        setMinimumSize(new java.awt.Dimension(459, 480));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel5.setText("E-mail:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(24, 240, 60, 21);

        tfEmail.setEditable(false);
        getContentPane().add(tfEmail);
        tfEmail.setBounds(156, 241, 212, 22);

        bAceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(bAceptar);
        bAceptar.setBounds(110, 350, 130, 27);

        bCancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar);
        bCancelar.setBounds(250, 350, 140, 27);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel8.setText("Fecha de alta:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(24, 270, 123, 21);

        bPrimero.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        bPrimero.setText("|<");
        bPrimero.setEnabled(false);
        bPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrimeroActionPerformed(evt);
            }
        });
        getContentPane().add(bPrimero);
        bPrimero.setBounds(110, 400, 60, 25);

        bAnterior.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        bAnterior.setText("<");
        bAnterior.setEnabled(false);
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(bAnterior);
        bAnterior.setBounds(180, 400, 50, 25);

        bSiguiente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        bSiguiente.setText(">");
        bSiguiente.setEnabled(false);
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(bSiguiente);
        bSiguiente.setBounds(240, 400, 50, 25);

        bUltimo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        bUltimo.setText(">|");
        bUltimo.setEnabled(false);
        bUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(bUltimo);
        bUltimo.setBounds(300, 400, 60, 25);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel1.setText("USUARIO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(138, 13, 230, 42);

        bBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        bBuscar.setBorderPainted(false);
        bBuscar.setContentAreaFilled(false);
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(bBuscar);
        bBuscar.setBounds(375, 88, 50, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(24, 88, 73, 21);
        getContentPane().add(tfUsuario);
        tfUsuario.setBounds(156, 89, 212, 22);
        getContentPane().add(ccFechaAlta);
        ccFechaAlta.setBounds(156, 271, 212, 22);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(24, 150, 76, 21);

        tfNombre.setEditable(false);
        getContentPane().add(tfNombre);
        tfNombre.setBounds(156, 151, 212, 22);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel4.setText("Apellido 1:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(24, 180, 90, 21);

        tfApellido1.setEditable(false);
        getContentPane().add(tfApellido1);
        tfApellido1.setBounds(156, 181, 212, 22);

        tfApellido2.setEditable(false);
        getContentPane().add(tfApellido2);
        tfApellido2.setBounds(156, 211, 212, 22);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(24, 120, 108, 21);

        pfContrasenna.setEditable(false);
        getContentPane().add(pfContrasenna);
        pfContrasenna.setBounds(156, 121, 212, 22);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel7.setText("Perfil:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(24, 300, 52, 21);

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Dueño", "Usuario" }));
        cbPerfil.setSelectedIndex(-1);
        getContentPane().add(cbPerfil);
        cbPerfil.setBounds(156, 301, 212, 22);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel10.setText("Apellido 2:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(24, 210, 90, 21);

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N
        imagen.setLabelFor(this);
        imagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imagen.setMaximumSize(new java.awt.Dimension(468, 445));
        imagen.setMinimumSize(new java.awt.Dimension(468, 445));
        getContentPane().add(imagen);
        imagen.setBounds(0, 0, 460, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        try
        {
            Persona p;
            switch(tipo){
                case "alta":
                    // comprobar todos los campos si los datos introducidos cumple con las validaciones 
                    comprobacion();
                    p = Main.consultarPersona(tfUsuario.getText());
                    // proceder al alta de la persona
                    alta(p);
                    break;
                    
                case "modificacion":
                    // comprobar todos los campos si los datos introducidos cumple con las validaciones
                    comprobacion();
                    p = Main.consultarPersona(tfUsuario.getText());
                    // proceder a la modificacion de la persona
                    modificacion(p);
                    break;
                    
                case "baja":
                    // proceder a la eliminación de la persona
                    p = Main.consultarPersona(tfUsuario.getText());
                    baja(p);
                    break;
            }
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }

    }//GEN-LAST:event_bAceptarActionPerformed

    /**
     * Metodo para comprobar todos los datos válidos.
     * @throws Exception 
     */
    
    private void comprobacion()throws Exception{
        
        Main.validar(7, tfUsuario);
        Main.validar(8, pfContrasenna);
        Main.validar(4, tfNombre);  
        Main.validar(5, tfApellido1);
        if(!tfApellido2.getText().equals("")){
            Main.validar(5, tfApellido2);
        }
        if(!tfEmail.getText().equals("")){
            Main.validar(6, tfEmail);
        }
        if(cbPerfil.getSelectedIndex() == -1){
            throw new Excepcion(9);
        }
    }
    
    /**
     * Metodo para dar de alta una persona, comprobando que no exista.
     * @param p Persona
     * @throws Exception 
     */
    
    private void alta(Persona p)throws Exception{
        if(p !=  null)
        {
            throw new Excepcion(15);
        }
        // mandar al main para proceder al alta
        Main.altaPersona(tfUsuario.getText(), String.valueOf(pfContrasenna.getPassword()), tfNombre.getText(), tfApellido1.getText(), tfApellido2.getText(), tfEmail.getText(), ccFechaAlta.getCalendar(), String.valueOf(cbPerfil.getSelectedItem()));
        JOptionPane.showMessageDialog(this, "El usuario se ha dado de alta correctamente.");
        Main.reabrir(this, tipo, n);
    }
    
    /**
     * Metodo para modificar una persona.
     * @param p Persona
     * @throws Exception 
     */
    
    private void modificacion(Persona p) throws Exception{
        //comprobar si existe la persona
        if(p == null)
        {
            throw new Excepcion(18);
        }
        //mandar al main para modificar el usuario con los nuevos datos
        Main.modificarPersona(p.getIdPersona(),tfUsuario.getText(), String.valueOf(pfContrasenna.getPassword()), tfNombre.getText(), tfApellido1.getText(), tfApellido2.getText(), tfEmail.getText(), String.valueOf(cbPerfil.getSelectedItem()), ccFechaAlta.getCalendar());
        JOptionPane.showMessageDialog(this, "El usuario se ha dado modificado correctamente.");
        Main.reabrir(this, tipo, n);
    }
    
    /**
     * Metodo para dar de baja una persona.
     * @param p Persona
     * @throws Exception 
     */
    
    private void baja(Persona p) throws Exception{
        try{
            // comprobar si existe la persona
            if(p == null)
            {
                throw new Excepcion(18);
            }
            // mandar al main para proceder a la baja
            Main.bajaPersona(tfUsuario.getText());
            JOptionPane.showMessageDialog(this, "El usuario se ha dado de baja correctamente.");
            Main.reabrir(this, tipo, n);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
            //JOptionPane.showMessageDialog(this, e.getMessage(), "No se ha podido eliminar el registro, la persona tiene vinculado otro registro.", 0);
        }
    }

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        Main.cerrar(this);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrimeroActionPerformed
        // cargar el primer registro
        contador = 0;
        mostrarDatos(lPersona.get(contador));
        bSiguiente.setEnabled(true);
        bUltimo.setEnabled(true);
        bPrimero.setEnabled(false);
        bAnterior.setEnabled(false);
        
        
    }//GEN-LAST:event_bPrimeroActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
        // retroceder un registro
        contador--;
        mostrarDatos(lPersona.get(contador));
        bSiguiente.setEnabled(true);
        bUltimo.setEnabled(true);
        if(contador == 0){
            bPrimero.setEnabled(false);
            bAnterior.setEnabled(false);
        }
        
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // avanzar un registro
        contador++;
        mostrarDatos(lPersona.get(contador));
        bPrimero.setEnabled(true);
        bAnterior.setEnabled(true);
        if(contador == lPersona.size()-1){
            bSiguiente.setEnabled(false);
            bUltimo.setEnabled(false);
        }
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUltimoActionPerformed
        // cargar el último registro
        contador = lPersona.size()-1;
        mostrarDatos(lPersona.get(contador));
        bSiguiente.setEnabled(false);
        bUltimo.setEnabled(false);
        bPrimero.setEnabled(true);
        bAnterior.setEnabled(true);
    }//GEN-LAST:event_bUltimoActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        //buscar persona
        try
        {
            if(tipo.equals("listado"))
            {
                // se habilita la edición del calendario para luego deshabilitarlo
                // ya que si no se habilita, no carga la vista del calendario, pero sí su dato
                // visualmente no se actualiza la fecha, pero al extraer la información sí se actualiza
                ccFechaAlta.setEditable(true);
                // comprobar si el administrador ha rellenado el campo Usuario y cargar únicamente ese usuario, en caso contrario, array de todos los usuarios.
                if(tfUsuario.getText().equals("")){
                    bSiguiente.setEnabled(true);
                    bUltimo.setEnabled(true);
                    lPersona = Main.consultarTodasLasPersonas();
                    contador = 0;
                    mostrarDatos(lPersona.get(0));
                }
                else{
                    Persona p = Main.consultarPersona(tfUsuario.getText());
                    if(p == null)
                    {
                        throw new Excepcion(14);
                    }
                    // mostrar datos de la persona
                    mostrarDatos(p);
                    bPrimero.setEnabled(false);
                    bAnterior.setEnabled(false);
                    bSiguiente.setEnabled(false);
                    bUltimo.setEnabled(false);
                }
                ccFechaAlta.setEditable(false);
            }
            else
            {
                Persona p = Main.consultarPersona(tfUsuario.getText());
                if(p == null)
                {
                    throw new Excepcion(14);
                }
                // mostrar datos de la persona
                mostrarDatos(p);
                // habilitar los campos si se ha accedido como modificación
                if(tipo.equals("modificacion")){
                    tfNombre.setEditable(true);
                    tfApellido1.setEditable(true);
                    tfApellido2.setEditable(true);
                    pfContrasenna.setEditable(true);
                    tfEmail.setEditable(true);
                    cbPerfil.setEnabled(true);
                    ccFechaAlta.setEditable(true);
                    tfUsuario.setEditable(false);
                }
                bAceptar.setEnabled(true);
            }
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    /**
     * Metodo para mostrar todos los datos de una persona. 
     * @param p Persona
     */
    
    private void mostrarDatos(Persona p) {
        try{
            // se habilita la edición del calendario para luego deshabilitarlo
            // ya que si no se habilita, no carga la vista del calendario, pero sí su dato
            // visualmente no se actualiza la fecha, pero al extraer la información sí se actualiza
            ccFechaAlta.setEditable(true);
            tfUsuario.setText(p.getUsuario());
            pfContrasenna.setText(p.getContrasenna());
            tfNombre.setText(p.getNombre());
            tfApellido1.setText(p.getApellido1());
            tfApellido2.setText(p.getApellido2());
            tfEmail.setText(p.getEmail());
            ccFechaAlta.setDate(p.getFechaAlta().getTime());
            ccFechaAlta.setEditable(false);
            cbPerfil.setSelectedItem(p.getPerfil().getNombre());
        }    
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bPrimero;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bUltimo;
    private javax.swing.JComboBox<String> cbPerfil;
    private org.freixas.jcalendar.JCalendarCombo ccFechaAlta;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField pfContrasenna;
    private javax.swing.JTextField tfApellido1;
    private javax.swing.JTextField tfApellido2;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

}
