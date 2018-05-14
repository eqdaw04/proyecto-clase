/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import Excepciones.Excepcion;
import Recurso.ValidacionDeDatosDeEntrada;
import UML.Partido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class VIntroducirResultado extends javax.swing.JDialog {

    int n;
    ArrayList<Partido> listaPartido;
    Partido p;
    /**
     * Creates new form VIntroducirResultado
     */
    public VIntroducirResultado(int n) {
        initComponents();
        // cargar los datos secundarios necesarios para operar
        cargarDatos(n);
    }
    
    private void cargarDatos(int n){
        this.n = n;
        setModal(true);
        setLocationRelativeTo(null);
        // Cargar los partidos del día de hoy, si existe
        cargarPartido();
        ccFecha.setEnabled(false);
        setVisible(true);
    }

    private void cargarPartido(){
        try{
            listaPartido = new ArrayList();
            listaPartido = Main.consultarLosPartidosPorFecha(ccFecha.getDate());
            cbPartido.removeAllItems();
            for(Partido p : listaPartido){
                cbPartido.addItem(String.valueOf(p.getIdPartido()));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLocal = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taVisitante = new javax.swing.JTextArea();
        tfPuntosLocal = new javax.swing.JTextField();
        tfPuntosVisitante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfHora = new javax.swing.JTextField();
        tfLugar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ccFecha = new org.freixas.jcalendar.JCalendarCombo();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbPartido = new javax.swing.JComboBox<>();
        bModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Inserción de los Resultados del Partido");

        taLocal.setEditable(false);
        taLocal.setColumns(20);
        taLocal.setRows(5);
        jScrollPane1.setViewportView(taLocal);

        taVisitante.setEditable(false);
        taVisitante.setColumns(20);
        taVisitante.setRows(5);
        jScrollPane2.setViewportView(taVisitante);

        tfPuntosLocal.setEditable(false);

        tfPuntosVisitante.setEditable(false);

        jLabel3.setText("Equipo Local:");

        jLabel4.setText("Equipo Visitante:");

        jLabel5.setText("Puntuaciones");

        jLabel6.setText("Modificar Resultado Anterior: Click Modificar Partido y seleccione la fecha");

        jLabel7.setText("Hora del Partido:");

        tfHora.setEditable(false);
        tfHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfHora.setText("10:00");

        tfLugar.setEditable(false);

        jLabel8.setText("Lugar del Partido:");

        ccFecha.setEditable(true);
        ccFecha.setEnabled(false);
        ccFecha.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                ccFechaDateChanged(evt);
            }
        });
        ccFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccFechaActionPerformed(evt);
            }
        });

        bAceptar.setText("Aceptar");
        bAceptar.setEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.setEnabled(false);
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Partido número: ");

        cbPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartidoActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar Partido");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfPuntosLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(52, 52, 52)
                                                .addComponent(tfPuntosVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel5)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(cbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ccFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPuntosLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPuntosVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        ccFecha.setEnabled(true);
    }//GEN-LAST:event_bModificarActionPerformed

    private void cbPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartidoActionPerformed
        p = null;
        for(int x = 0 ; x < listaPartido.size() ; x++){
            p = listaPartido.get(x);
            if(p.getIdPartido() == Integer.valueOf(cbPartido.getSelectedItem().toString())){
                SimpleDateFormat f = new SimpleDateFormat("hh:mm");
                tfHora.setText(f.format(p.getFecha().getTime()));
                tfLugar.setText(p.geteLocal().getLugar());
                tfPuntosLocal.setText(String.valueOf(p.getmLocal()));
                tfPuntosVisitante.setText(String.valueOf(p.getmLocal()));
                String dato = "";
                if(!p.geteLocal().getComentario().equals("")){
                    dato = p.geteLocal().getComentario();
                }
                taLocal.setText(p.geteLocal().getNombre() + "\n" + dato);
                if(p.geteVisitante().getComentario().equals("")){
                    dato = p.geteVisitante().getComentario();
                }
                taVisitante.setText(p.geteVisitante().getNombre() + "\n" + p.geteVisitante().getComentario());
                tfPuntosLocal.setEditable(true);
                tfPuntosVisitante.setEditable(true);
                x = listaPartido.size();
            }
        }
    }//GEN-LAST:event_cbPartidoActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
            
        try{
            p.setmLocal(Integer.valueOf(tfPuntosLocal.getText()));
            p.setmVisitante(Integer.parseInt(tfPuntosVisitante.getText()));
            ValidacionDeDatosDeEntrada.validar(46, tfPuntosLocal);
            ValidacionDeDatosDeEntrada.validar(46, tfPuntosVisitante);
            if(!Main.modificarMarcador(p)){
                throw new Excepcion(47);
            }
            
        }
        catch(Excepcion e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
            
    }//GEN-LAST:event_bAceptarActionPerformed

    private void ccFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccFechaActionPerformed
        
    }//GEN-LAST:event_ccFechaActionPerformed

    private void ccFechaDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_ccFechaDateChanged
        cargarPartido();
    }//GEN-LAST:event_ccFechaDateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bModificar;
    private javax.swing.JComboBox<String> cbPartido;
    private org.freixas.jcalendar.JCalendarCombo ccFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taLocal;
    private javax.swing.JTextArea taVisitante;
    private javax.swing.JTextField tfHora;
    private javax.swing.JTextField tfLugar;
    private javax.swing.JTextField tfPuntosLocal;
    private javax.swing.JTextField tfPuntosVisitante;
    // End of variables declaration//GEN-END:variables
}
