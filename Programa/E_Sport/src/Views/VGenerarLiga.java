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
import java.util.Date;
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

    int n, segundos;
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
        pEspera.setVisible(false);
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
                bBorrar.setEnabled(true);
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
        pEspera = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1004, 711));
        setMinimumSize(new java.awt.Dimension(964, 709));
        getContentPane().setLayout(null);

        bAceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(bAceptar);
        bAceptar.setBounds(600, 620, 120, 27);

        pEspera.setBackground(new java.awt.Color(255, 255, 255));
        pEspera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Un momento por favor...");

        javax.swing.GroupLayout pEsperaLayout = new javax.swing.GroupLayout(pEspera);
        pEspera.setLayout(pEsperaLayout);
        pEsperaLayout.setHorizontalGroup(
            pEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEsperaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEsperaLayout.setVerticalGroup(
            pEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEsperaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(pEspera);
        pEspera.setBounds(320, 270, 300, 80);

        bCancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar);
        bCancelar.setBounds(790, 620, 120, 27);

        bGenerarCalendario.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        bGenerarCalendario.setText("Generar Calendario");
        bGenerarCalendario.setEnabled(false);
        bGenerarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarCalendarioActionPerformed(evt);
            }
        });
        getContentPane().add(bGenerarCalendario);
        bGenerarCalendario.setBounds(620, 190, 183, 25);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel5.setText("Seleccione fecha para el primer partido:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 30, 410, 21);

        bBorrar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        bBorrar.setText("Borrar Todo");
        bBorrar.setEnabled(false);
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(bBorrar);
        bBorrar.setBounds(290, 180, 170, 25);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel7.setText("Número de Jornada");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 260, 200, 21);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel8.setText("Número del Partido");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(290, 260, 240, 21);

        lPartido.setEnabled(false);
        lPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPartidoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lPartido);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(290, 290, 197, 326);

        lJornada.setEnabled(false);
        lJornada.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lJornadaValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lJornada);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(50, 290, 182, 326);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compiten"));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Equipo Local");

        tfLocal.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Equipo Visitante");

        tfVisitante.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Fecha celebración");

        ccCalendario.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Hora");

        cbHora.setEnabled(false);

        cbMinuto.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Lugar del partido:");

        tfLugar.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(387, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addComponent(ccCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(144, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(530, 280, 380, 301);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel10.setText("Borrar la LIGA actual:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 180, 240, 21);

        ccCalendarioInicial.setEnabled(false);
        getContentPane().add(ccCalendarioInicial);
        ccCalendarioInicial.setBounds(40, 100, 189, 22);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setText("Seleccione hora del último partido:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(490, 140, 330, 21);

        cbHoraI.setEnabled(false);
        cbHoraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraIActionPerformed(evt);
            }
        });
        getContentPane().add(cbHoraI);
        cbHoraI.setBounds(370, 140, 42, 22);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Seleccione hora del primer partido:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 140, 287, 20);

        cbHoraF.setEnabled(false);
        getContentPane().add(cbHoraF);
        cbHoraF.setBounds(820, 140, 42, 22);

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel12.setText("Si La jornada comienza el lunes, acabará el domingo.");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(250, 96, 561, 30);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setText("Fecha y hora del partido");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(580, 243, 300, 30);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel15.setText("(Recuerde que 1 jornada consta de 7 días)");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(70, 60, 330, 17);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel16.setText("(Se borrará la liga actual)");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(80, 210, 230, 17);

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(img);
        img.setBounds(0, 0, 970, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(this, "¿Realmente desea borrar toda la Liga?\nAtención: Esto implica borrar todos los marcadores, partidos y jornadas actuales.","Borrar toda la Liga",2) == 0){
                if(Main.borrarLiga()){
                    JOptionPane.showMessageDialog(this, "Liga borrada correctamente.");
                    Main.reabrir(this, "", n);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VGenerarLiga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bBorrarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Main.cerrar(this);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bGenerarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarCalendarioActionPerformed
        try {
            Date hoy = new Date();
            if(ccCalendarioInicial.getDate().after(hoy)){
                // mostrar pantalla de espera
                pEspera.setVisible(true);
                if(JOptionPane.showConfirmDialog(this, "Dependiendo de la cantidad de equipos y la velocidad de conexión a la base de datos, puede tardar unos minutos\n¿Desea continuar?","",2) == 0){
                    generarCalendario();
                }
                Main.reabrir(this, "", 7);
            }
            else{
                
                throw new Excepcion(34);
            }
        }
        catch (Excepcion e){
            pEspera.setVisible(false);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bGenerarCalendarioActionPerformed

    private void generarCalendario() throws Exception{
        //Generar calendario
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(ccCalendarioInicial.getDate());
        fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(cbHoraI.getSelectedItem().toString()));
        fecha.set(Calendar.MINUTE, 0);
        fecha.set(Calendar.SECOND, 0);
        fecha.set(Calendar.MILLISECOND, 0);
        JOptionPane.showMessageDialog(this, Main.generarCalendario(fecha, Integer.parseInt(cbHoraF.getSelectedItem().toString())));
    }
    
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
            for(int x = 0; x<listaJornada.size(); x++){
                if(lJornada.getSelectedValue() == listaJornada.get(x).getIdJornada()){
                    Jornada j = listaJornada.get(x);
                    Date hoy = new Date();
                    if(ccCalendario.getDate().before(j.getFechaInicio()) || ccCalendario.getDate().after(j.getFechaFinal())  || ccCalendario.getDate().before(hoy)){
                           throw new Excepcion(35);
                    }
                    
                    x=listaJornada.size();
                }
            }
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
        cbHora.setSelectedIndex(p.getFecha().get(Calendar.HOUR_OF_DAY));
        cbMinuto.setSelectedIndex(p.getFecha().get(Calendar.MINUTE));
        ccCalendario.setEnabled(true);
        bAceptar.setEnabled(true);
        cbHora.setEnabled(true);
        cbMinuto.setEnabled(true);
        Date hoy = new Date();
        if(p.getFecha().getTime().before(hoy)){
            ccCalendario.setEnabled(false);
            bAceptar.setEnabled(false);
            cbHora.setEnabled(false);
            cbMinuto.setEnabled(false);
            JOptionPane.showMessageDialog(this, "El partido ya se ha celebrado.\nNo se permite ninguna modificación.");
        }
            
        
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
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel pEspera;
    private javax.swing.JTextField tfLocal;
    private javax.swing.JTextField tfLugar;
    private javax.swing.JTextField tfVisitante;
    // End of variables declaration//GEN-END:variables
}
