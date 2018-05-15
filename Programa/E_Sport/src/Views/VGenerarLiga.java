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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(906, 633));
        getContentPane().setLayout(null);

        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(bAceptar);
        bAceptar.setBounds(530, 530, 77, 25);

        pEspera.setBackground(new java.awt.Color(255, 255, 255));
        pEspera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Un momento por favor...");

        javax.swing.GroupLayout pEsperaLayout = new javax.swing.GroupLayout(pEspera);
        pEspera.setLayout(pEsperaLayout);
        pEsperaLayout.setHorizontalGroup(
            pEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEsperaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEsperaLayout.setVerticalGroup(
            pEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEsperaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(pEspera);
        pEspera.setBounds(290, 250, 300, 80);

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar);
        bCancelar.setBounds(720, 530, 83, 25);

        bGenerarCalendario.setText("Generar Calendario");
        bGenerarCalendario.setEnabled(false);
        bGenerarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarCalendarioActionPerformed(evt);
            }
        });
        getContentPane().add(bGenerarCalendario);
        bGenerarCalendario.setBounds(620, 140, 183, 25);

        jLabel5.setText("Seleccione fecha para el primer Partido: (Recuerde que 1 jornada consta de 7 Días)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 40, 767, 16);

        bBorrar.setText("Borrar Todo");
        bBorrar.setEnabled(false);
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(bBorrar);
        bBorrar.setBounds(320, 140, 118, 25);

        jLabel7.setText("Número de Jornada");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 200, 112, 16);

        jLabel8.setText("Número del Partido");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(290, 200, 514, 16);

        lPartido.setEnabled(false);
        lPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPartidoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lPartido);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(280, 230, 197, 326);

        lJornada.setEnabled(false);
        lJornada.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lJornadaValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lJornada);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(40, 230, 182, 326);

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
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(387, 387, 387)))
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
        jPanel1.setBounds(530, 230, 503, 293);

        jLabel10.setText("Borrar la LIGA actual: (Se borrará la liga actual)");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 140, 275, 16);

        ccCalendarioInicial.setEnabled(false);
        getContentPane().add(ccCalendarioInicial);
        ccCalendarioInicial.setBounds(40, 60, 188, 22);

        jLabel6.setText("Seleccione Hora último partido:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(530, 100, 180, 16);

        cbHoraI.setEnabled(false);
        cbHoraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraIActionPerformed(evt);
            }
        });
        getContentPane().add(cbHoraI);
        cbHoraI.setBounds(230, 100, 42, 22);

        jLabel11.setText("Seleccione Hora primer partido:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 100, 183, 16);

        cbHoraF.setEnabled(false);
        getContentPane().add(cbHoraF);
        cbHoraF.setBounds(720, 100, 42, 22);

        jLabel12.setText("Si La jornada comienza el lunes, acabará el domingo.");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(250, 70, 561, 16);

        jLabel13.setText("Fecha y Hora del Partido");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(530, 180, 140, 16);

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
            // mostrar pantalla de espera
            pEspera.setVisible(true);
            if(JOptionPane.showConfirmDialog(this, "Puede tardar unos minutos, ¿Desea continuar?","",2) == 0){
                generarCalendario();
            }
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
    private javax.swing.JLabel jLabel14;
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
