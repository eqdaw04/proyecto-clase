/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import Excepciones.Excepcion;
import UML.Jornada;
import UML.Partido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Ventana para generar la liga.
 * Fecha de creación de la vista: 23/04/2018
 * @author eqdaw04
 */
public class VGenerarLiga extends javax.swing.JDialog {

    int n;
    Partido p;
    ArrayList<Jornada> listaJornada;
    ArrayList<Partido> listaPartido;
    /**
     * Creates new form VGenerarLiga
     * @param n
     */
    public VGenerarLiga(int n) {
        initComponents();
        cargarComponente(n);
    }
    
    /**
     * Metodo para la carga de componentes.
     * @param n int
     */

    private void cargarComponente(int n){
        this.n = n;
        setModal(true);
        setLocationRelativeTo(null);
        listaJornada = new ArrayList();
        listaPartido = new ArrayList();
        cargarDatos();
        setVisible(true);
    }
    
    /**
     * Metodo para rellenar las horas y minutos (carga de datos).
     */
    
    private void cargarDatos(){
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
        habilitarCampos();
        
    }
    
    /**
     * Metodo para habilitar los campos deshabilitados.
     */
    
    private void habilitarCampos(){
        try {
            listaJornada = Main.consultarTodasLasJornadas();
            if(listaJornada.isEmpty()){
                cbHoraI.setEnabled(true);
                bGenerarCalendario.setEnabled(true);
                ccCalendarioInicial.setEnabled(true);
                cbHoraI.setEnabled(true);
                cbHoraF.setEnabled(true);
            }
            else{
                cbHoraF.setEnabled(false);
                lJornada.setEnabled(true);
                cargarJornada(listaJornada);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }
    
    /**
     * Metodo para cargar las jornadas existentes.
     * @param listaJornada ArrayList de Jornada
     */
    
    private void cargarJornada(ArrayList <Jornada> listaJornada){
        // Rellenar el list con las jornadas existentes
        lJornada.removeAll();
        DefaultListModel <Integer> modelo = new DefaultListModel();
        listaJornada.forEach((j) -> {
            modelo.addElement(j.getIdJornada());
        });
        lJornada.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bGenerarCalendario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bBorrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lPartido = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lJornada = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfLocal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfVisitante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ccCalendario = new org.freixas.jcalendar.JCalendarCombo();
        jLabel4 = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        cbMinuto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfLugar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ccCalendarioInicial = new org.freixas.jcalendar.JCalendarCombo();
        jLabel6 = new javax.swing.JLabel();
        cbHoraI = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbHoraF = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bGenerarCalendario.setText("Generar Calendario");
        bGenerarCalendario.setEnabled(false);
        bGenerarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarCalendarioActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleccione fecha para el primer Partido: (Recuerde que 1 jornada consta de 7 Días)");

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
        lPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPartidoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lPartido);

        lJornada.setEnabled(false);
        lJornada.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lJornadaValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lJornada);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compiten"));

        jLabel1.setText("Equipo Local");

        tfLocal.setEditable(false);

        jLabel2.setText("Equipo Visitante");

        tfVisitante.setEditable(false);

        jLabel3.setText("Fecha celebración");

        ccCalendario.setEnabled(false);

        jLabel4.setText("Hora");

        cbHora.setEnabled(false);

        cbMinuto.setEnabled(false);

        jLabel9.setText("Lugar del partido:");

        tfLugar.setEditable(false);
        tfLugar.setText("MIKEL ES MUY LISTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLugar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfVisitante)))
                            .addComponent(jLabel3)
                            .addComponent(ccCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(tfLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Borrar la LIGA actual: (Se borrará la liga actual)");

        ccCalendarioInicial.setEnabled(false);

        jLabel6.setText("Seleccione Hora último partido:");

        cbHoraI.setEnabled(false);
        cbHoraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraIActionPerformed(evt);
            }
        });

        jLabel11.setText("Seleccione Hora primer partido:");

        cbHoraF.setEnabled(false);

        jLabel12.setText("Si La jornada comienza el lunes, acabará el domingo.");

        jLabel13.setText("Fecha y Hora del Partido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(bGenerarCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ccCalendarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbHoraF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(bAceptar)
                                            .addGap(115, 115, 115)
                                            .addComponent(bCancelar)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccCalendarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(cbHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGenerarCalendario)
                    .addComponent(jLabel10)
                    .addComponent(bBorrar))
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAceptar)
                            .addComponent(bCancelar)))
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBorrarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Main.cerrar(this);
    }//GEN-LAST:event_bCancelarActionPerformed

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
            Main.reabrir(this, "", 7);
        } 
        /*
        catch (Excepcion e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }*/
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bGenerarCalendarioActionPerformed

    private void cbHoraIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHoraIActionPerformed

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
              
    }//GEN-LAST:event_cbHoraIActionPerformed

    private void lJornadaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lJornadaValueChanged
        try {
            bAceptar.setEnabled(false);
            ccCalendario.setEnabled(false);
            cbHora.setEnabled(false);
            cbMinuto.setEnabled(false);
            listaPartido = Main.consultarPartidosPorJornada(lJornada.getSelectedValue());
            cargarPartido(listaPartido);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
        
    }//GEN-LAST:event_lJornadaValueChanged

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        try {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(ccCalendario.getDate());
            fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(cbHora.getSelectedItem().toString()));
            fecha.set(Calendar.MINUTE, Integer.parseInt(cbMinuto.getSelectedItem().toString()));
            p.setFecha(fecha);
            if(Main.modificarPartido(p)){
                JOptionPane.showMessageDialog(this, "Partido modificado correctamente.");
                Main.reabrir(this, "", 7);
            }
            else{
                throw new Excepcion(44);
            }
        } catch (Excepcion e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void lPartidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPartidoMouseClicked
        for(int x = 0 ; x<listaPartido.size(); x++){
            if(listaPartido.get(x).getIdPartido() == lPartido.getSelectedValue()){
                p = null;
                try {
                    p = Main.consultarMarcadorPorPartido(listaPartido.get(x));
                    x=listaPartido.size();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
                }
                cargarMarcador();
            }
        }
    }//GEN-LAST:event_lPartidoMouseClicked
    
    /**
     * Metodo para cargar el partido.
     * @param listaPartido ArrayList de Partido.
     */
    
    private void cargarPartido(ArrayList <Partido> listaPartido){
        lPartido.removeAll();
        DefaultListModel <Integer> modelo = new DefaultListModel();
        listaPartido.forEach((pa) -> {
            modelo.addElement(pa.getIdPartido());
        });
        lPartido.setModel(modelo);
        lPartido.setEnabled(true);
    }
    
    /**
     * Metodo para cargar el marcador.
     */
    
    private void cargarMarcador(){
        ccCalendario.setDate(p.getFecha().getTime());
        
        if(p.geteLocal() == null){
            tfLocal.setText("DESCANSO");
            tfLugar.setText("SE ENCUENTRA EN DESCANSO");
        }
        else{
            tfLocal.setText(p.geteLocal().getNombre());
            tfLugar.setText(p.geteLocal().getLugar());
        }
        if(p.geteVisitante() == null){
            tfVisitante.setText("DESCANSO");
            tfLugar.setText("SE ENCUENTRA EN DESCANSO");
        }
        else{
            tfVisitante.setText(p.geteVisitante().getNombre());
        }
        
        bAceptar.setEnabled(true);
        cbHora.setSelectedIndex(p.getFecha().get(Calendar.HOUR_OF_DAY));
        cbMinuto.setSelectedIndex(p.getFecha().get(Calendar.MINUTE));
        ccCalendario.setEnabled(true);
        cbHora.setEnabled(true);
        cbMinuto.setEnabled(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGenerarCalendario;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbHoraF;
    private javax.swing.JComboBox<String> cbHoraI;
    private javax.swing.JComboBox<String> cbMinuto;
    private org.freixas.jcalendar.JCalendarCombo ccCalendario;
    private org.freixas.jcalendar.JCalendarCombo ccCalendarioInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JList<Integer> lJornada;
    private javax.swing.JList<Integer> lPartido;
    private javax.swing.JTextField tfLocal;
    private javax.swing.JTextField tfLugar;
    private javax.swing.JTextField tfVisitante;
    // End of variables declaration//GEN-END:variables
}
