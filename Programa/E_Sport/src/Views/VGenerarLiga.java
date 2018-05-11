/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import UML.Jornada;
import UML.Partido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class VGenerarLiga extends javax.swing.JDialog {

    int n;
    /**
     * Creates new form VGenerarLiga
     */
    public VGenerarLiga(int n) {
        initComponents();
        cargarComponente(n);
    }

    private void cargarComponente(int n){
        this.n = n;
        setModal(true);
        setLocationRelativeTo(null);
        cargarDatos();
        setVisible(true);
    }
    
    private void cargarDatos(){
        // rellenar las horas y minutos
        for(int x = 0; x<60; x++){
            if(x<24){
                if(x<10){
                    cbHora.addItem("0" + x);
                    cbHoraI.addItem("0" + x);
                    cbMinuto.addItem("0" + x);
                    cbHoraF.addItem("0" + x);
                }
                else{
                    cbHora.addItem(String.valueOf(x));
                    cbMinuto.addItem(String.valueOf(x));
                    cbHoraI.addItem(String.valueOf(x));
                    cbHoraF.addItem(String.valueOf(x));
                }
            }
            else{
                cbMinuto.addItem(String.valueOf(x));
            }
        }
        cbHoraI.setSelectedIndex(-1);
        if(cbHoraI.getSelectedIndex() == -1){
            bGenerarCalendario.setEnabled(false);
            cbHoraF.setEnabled(false);
        }
        habilitarCampos();
        
    }
    
    private void habilitarCampos(){
        try {
            ArrayList <Jornada> listaJornada = Main.consultarTodasLasJornadas();
            if(listaJornada.size()==0){
                cbHoraI.setEnabled(true);
                bGenerarCalendario.setEnabled(true);
                ccCalendarioInicial.setEnabled(true);
            }
            else{
                lJornada.setEnabled(true);
                cargarJornada(listaJornada);
            }
        } catch (Exception ex) {
            Logger.getLogger(VGenerarLiga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarJornada(ArrayList <Jornada> listaJornada){
        // Rellenar el list con las jornadas existentes
        lJornada.removeAll();
        DefaultListModel <Integer> modelo = new DefaultListModel();
        for(Jornada j : listaJornada){
            modelo.addElement(j.getIdJornada());
        }
        lJornada.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bGenerarCalendario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bBorrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lPartido = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lJornada = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ccCalendario = new org.freixas.jcalendar.JCalendarCombo();
        jLabel4 = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        cbMinuto = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ccCalendarioInicial = new org.freixas.jcalendar.JCalendarCombo();
        jLabel6 = new javax.swing.JLabel();
        cbHoraI = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbHoraF = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Aceptar");
        jButton1.setEnabled(false);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bGenerarCalendario.setText("Generar Calendario");
        bGenerarCalendario.setEnabled(false);
        bGenerarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarCalendarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleccione fecha para el primer Partido:");

        bBorrar.setText("Borrar Todo");
        bBorrar.setEnabled(false);
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        jLabel7.setText("Número de Jornada");

        jLabel8.setText("Número del Partido");

        lPartido.setEnabled(false);
        jScrollPane3.setViewportView(lPartido);

        lJornada.setEnabled(false);
        lJornada.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lJornadaValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lJornada);

        jButton5.setText("Vista Global");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Vista General de todo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compiten"));

        jLabel1.setText("Equipo Local");

        jTextField1.setEditable(false);

        jLabel2.setText("Equipo Visitante");

        jTextField2.setEditable(false);

        jLabel3.setText("Fecha celebración");

        ccCalendario.setEnabled(false);

        jLabel4.setText("Hora");

        cbHora.setEnabled(false);

        cbMinuto.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)))
                    .addComponent(jLabel3)
                    .addComponent(ccCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ccCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Borrar la LIGA actual");

        ccCalendarioInicial.setEnabled(false);

        jLabel6.setText("Seleccione Hora último partido:");

        cbHoraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraIActionPerformed(evt);
            }
        });

        jLabel11.setText("Seleccione Hora primer partido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ccCalendarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10)
                                        .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbHoraF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bGenerarCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ccCalendarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(cbHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bGenerarCalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5)
                                .addComponent(bBorrar))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2)))
                        .addComponent(jScrollPane4))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBorrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Main.cerrar(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bGenerarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarCalendarioActionPerformed
        try {
            //Generar calendario
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(ccCalendarioInicial.getDate());
            fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(cbHoraI.getSelectedItem().toString()));
            fecha.set(Calendar.MINUTE, 0);
            fecha.set(Calendar.SECOND, 0);
            fecha.set(Calendar.MILLISECOND, 0);
            JOptionPane.showMessageDialog(this, Main.generarCalendario(fecha, Integer.parseInt(cbHoraF.getSelectedItem().toString())));
        } 
        /*
        catch (Excepcion e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }*/
        catch (Exception ex) {
            Logger.getLogger(VGenerarLiga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bGenerarCalendarioActionPerformed

    private void cbHoraIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHoraIActionPerformed
        if(cbHoraI.getSelectedIndex() != -1){
            bGenerarCalendario.setEnabled(true);
            cbHoraF.setEnabled(true);
            cbHoraF.removeAllItems();
            for(int x = Integer.parseInt(cbHoraI.getSelectedItem().toString()); x<24; x++){
                if(x<10){
                    cbHoraF.addItem("0" + x);
                }
                else{
                    cbHoraF.addItem(String.valueOf(x));
                }
            }
        }
        
    }//GEN-LAST:event_cbHoraIActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lJornadaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lJornadaValueChanged
        try {
            ArrayList <Partido> listaPartido = Main.consultarPartidosPorJornada(lJornada.getSelectedValue());
            cargarPartido(listaPartido);
        } catch (Exception ex) {
            Logger.getLogger(VGenerarLiga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lJornadaValueChanged
    
    private void cargarPartido(ArrayList <Partido> listaPartido){
        lPartido.removeAll();
        DefaultListModel <Integer> modelo = new DefaultListModel();
        for(Partido p : listaPartido){
            modelo.addElement(p.getIdPartido());
        }
        lJornada.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bGenerarCalendario;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbHoraF;
    private javax.swing.JComboBox<String> cbHoraI;
    private javax.swing.JComboBox<String> cbMinuto;
    private org.freixas.jcalendar.JCalendarCombo ccCalendario;
    private org.freixas.jcalendar.JCalendarCombo ccCalendarioInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList<Integer> lJornada;
    private javax.swing.JList<Integer> lPartido;
    // End of variables declaration//GEN-END:variables
}
