/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import Excepciones.*;
import UML.Equipo;
import UML.Jugador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Vista para la modificacion de equipos.
 * Fecha de creación de la vista: 24/04/2018
 * @author eqdaw04
 */
public class VModificarEquipo extends javax.swing.JDialog {

    /**
     * Creates new form VModificarEquipo2
     */
    private static Equipo e;
    //array de jugadores integrantes del equipo
    private static ArrayList<Jugador> jEquipo;
    //array de jugadores disponibles
    private static ArrayList<Jugador> jDisp;
    
    public VModificarEquipo(String usu) throws Exception {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        e= Main.ConsultarEquipoPorUsuario(usu);
        nombeEquipo.setText(e.getNombre());
        rellenar();
        setVisible(true);
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
        nombeEquipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liJugEqui = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        liJugDisp = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        bEliminar = new javax.swing.JButton();
        bAnnadir = new javax.swing.JButton();
        bConsultar = new javax.swing.JButton();
        tfSueldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Equipo");

        nombeEquipo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        nombeEquipo.setForeground(new java.awt.Color(0, 153, 0));
        nombeEquipo.setText("NOMBREEQUIPO");

        liJugEqui.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liJugEqui.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        liJugEqui.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                liJugEquiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(liJugEqui);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Jugadores en el equipo:");

        liJugDisp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liJugDisp.setToolTipText("");
        liJugDisp.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                liJugDispValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(liJugDisp);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Sueldo del jugador:");

        bEliminar.setText("Eliminar Jugador");
        bEliminar.setEnabled(false);
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bAnnadir.setText("Añadir Jugador");
        bAnnadir.setEnabled(false);
        bAnnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnnadirActionPerformed(evt);
            }
        });

        bConsultar.setText("Consultar");
        bConsultar.setEnabled(false);
        bConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarActionPerformed(evt);
            }
        });

        tfSueldo.setText("Sueldo");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Jugadores Disponibles:");

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 68, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(jLabel1)
                            .addGap(11, 11, 11)
                            .addComponent(nombeEquipo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(317, 317, 317)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(tfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(330, 330, 330)
                            .addComponent(bAnnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(320, 320, 320)
                            .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 68, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 27, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(nombeEquipo))
                    .addGap(78, 78, 78)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(bConsultar))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel3))
                        .addComponent(tfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bEliminar)
                        .addComponent(bAnnadir))
                    .addGap(17, 17, 17)
                    .addComponent(bSalir)
                    .addGap(0, 27, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void liJugEquiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_liJugEquiValueChanged
        bEliminar.setEnabled(true);
        bConsultar.setEnabled(true);
        bAnnadir.setEnabled(false);
        liJugDisp.clearSelection();
        tfSueldo.setText(String.valueOf(jEquipo.get(liJugEqui.getSelectedIndex()).getSueldo()));
    }//GEN-LAST:event_liJugEquiValueChanged

    private void liJugDispValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_liJugDispValueChanged
        bEliminar.setEnabled(false);
        bConsultar.setEnabled(true);
        bAnnadir.setEnabled(true);
        liJugEqui.clearSelection();
        tfSueldo.setText(String.valueOf(jDisp.get(liJugDisp.getSelectedIndex()).getSueldo()));
    }//GEN-LAST:event_liJugDispValueChanged

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        if(Main.EliminarJugadorEquipo(liJugEqui.getSelectedValue())){
            JOptionPane.showMessageDialog(this, "Jugador eliminado exitosamente");
            try {
                rellenar();
            } catch (Exception ex) {
                Logger.getLogger(VModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ELIMINAR");
            }
            bEliminar.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "Error2");
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bAnnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnnadirActionPerformed
        try{
            if(Main.AnnadirJugadorEquipo(liJugDisp.getSelectedValue(),String.valueOf(e.getIdEquipo()))){
                JOptionPane.showMessageDialog(this, "Jugador añadido exitosamente");
                rellenar();
            }
        }  catch (SQLException e){
            switch(e.getErrorCode()){
                case 20001:
                JOptionPane.showMessageDialog(this, new Excepcion(28).getMessage());
                break;
                case 20002:
                JOptionPane.showMessageDialog(this, new Excepcion(29).getMessage());
                break;
            }
        }catch (Exception ex) {
            Logger.getLogger(VModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("AÑADIR");

        }
        bAnnadir.setEnabled(false);
    }//GEN-LAST:event_bAnnadirActionPerformed

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
        System.out.println(liJugEqui.getSelectedValue()+liJugDisp.getSelectedValue());
        if(liJugEqui.isSelectionEmpty()){
            try {
                liJugEqui.clearSelection();
                Main.abrirVJugador(Main.consultarJugadorNickname(liJugDisp.getSelectedValue()));
            } catch (Exception ex) {
                Logger.getLogger(VModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                liJugDisp.clearSelection();
                Main.abrirVJugador(Main.consultarJugadorNickname(liJugEqui.getSelectedValue()));
            } catch (Exception ex) {
                Logger.getLogger(VModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_bConsultarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        Main.cerrar(this);

    }//GEN-LAST:event_bSalirActionPerformed

    private void rellenar() throws Exception{
        //No entiendo muy bien porque, pero sipongo directamente el codigo el segundo modelo (sea cual sea) no funciona correctamente
        rellenar1();
        rellenar2();    
    }
    
    /**
     * Metodo para buscar los jugadores que forman el equipo y rellenar una lista con ellos. 
     */
    private void rellenar1(){
        try {
            jEquipo=new ArrayList();
            jEquipo=Main.obtenerJugEqui(String.valueOf(e.getIdEquipo()));
            DefaultListModel<String> model = new DefaultListModel();
            for (int x=0;x < jEquipo.size();x++){
                model.addElement(jEquipo.get(x).getNickname());
            }
            liJugEqui.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(VModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo para buscar jugadores sin equipo y rellenar una lista con ellos.
     */
    
    private void rellenar2(){
        try {
            jDisp=new ArrayList();
            jDisp=Main.consultarJugadoresDisponibles();
            DefaultListModel<String> modelo = new DefaultListModel();
            for (int y=0;y< jDisp.size();y++){
                modelo.addElement(jDisp.get(y).getNickname());
            }
            liJugDisp.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(VModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnnadir;
    private javax.swing.JButton bConsultar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> liJugDisp;
    private javax.swing.JList<String> liJugEqui;
    private javax.swing.JLabel nombeEquipo;
    private javax.swing.JTextField tfSueldo;
    // End of variables declaration//GEN-END:variables
}
