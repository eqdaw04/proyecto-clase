package Views;

import Controladora.Main;
import Excepciones.Excepcion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class VAltasBajas extends javax.swing.JDialog {
    
    private boolean alta, baja;

    /**
     * Creates new form VAltasBajas
     */
    public VAltasBajas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarEquipo();
        mostrarPlantilla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgAltasBajas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfJugadorAlta = new javax.swing.JTextField();
        bBuscarAlta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ftfSueldo = new javax.swing.JFormattedTextField();
        rbAlta = new javax.swing.JRadioButton();
        rbBajas = new javax.swing.JRadioButton();
        tfJugadorBaja = new javax.swing.JTextField();
        bBuscarBaja = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfEquipo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taPlantilla = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ALTAS Y BAJAS");

        jLabel2.setText("Jugador:");

        tfJugadorAlta.setEnabled(false);

        bBuscarAlta.setText("Buscar");
        bBuscarAlta.setEnabled(false);
        bBuscarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarAltaActionPerformed(evt);
            }
        });

        jLabel3.setText("Sueldo:");

        ftfSueldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        ftfSueldo.setEnabled(false);

        bgAltasBajas.add(rbAlta);
        rbAlta.setText("Alta");
        rbAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAltaActionPerformed(evt);
            }
        });

        bgAltasBajas.add(rbBajas);
        rbBajas.setText("Baja");
        rbBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBajasActionPerformed(evt);
            }
        });

        tfJugadorBaja.setEnabled(false);

        bBuscarBaja.setText("Buscar");
        bBuscarBaja.setEnabled(false);
        bBuscarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarBajaActionPerformed(evt);
            }
        });

        jLabel4.setText("Jugador:");

        jLabel5.setText("Equipo:");

        tfEquipo.setEnabled(false);

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

        taPlantilla.setColumns(20);
        taPlantilla.setRows(5);
        taPlantilla.setEnabled(false);
        jScrollPane1.setViewportView(taPlantilla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbBajas))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbAlta)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(bAceptar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfJugadorBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bBuscarBaja))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfJugadorAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(ftfSueldo))
                                        .addGap(18, 18, 18)
                                        .addComponent(bBuscarAlta))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAlta)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfJugadorAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarAlta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ftfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(rbBajas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfJugadorBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarBaja))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAltaActionPerformed
        // TODO add your handling code here:
        alta=true;
        baja=false;
        tfJugadorAlta.setEnabled(true);
        bBuscarAlta.setEnabled(true);
        ftfSueldo.setEnabled(true);
        tfJugadorBaja.setEnabled(false);
        tfJugadorBaja.setText("");
        bBuscarBaja.setEnabled(false);
        bAceptar.setEnabled(false);
    }//GEN-LAST:event_rbAltaActionPerformed

    private void rbBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBajasActionPerformed
        // TODO add your handling code here:
        alta=false;
        baja=true;
        tfJugadorAlta.setEnabled(false);
        tfJugadorAlta.setText("");
        bBuscarAlta.setEnabled(false);
        ftfSueldo.setEnabled(false);
        ftfSueldo.setText("");
        tfJugadorBaja.setEnabled(true);
        bBuscarBaja.setEnabled(true);
        bAceptar.setEnabled(false);
    }//GEN-LAST:event_rbBajasActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:
        try
        {
            if(alta)
            {
                if(ftfSueldo.getText().equals("Unparseable number: \"\""))
                {
                    throw new Excepcion("No has introducido el sueldo del jugador.");
                }
                // Método para comprobar que no excede el límite salarial.
                // Main.tramitarAlta(tfJugadorAlta.getText(), ftfSalario.getText());
            }
            else
            {
                if(baja)
                {
                    // Main.tramitarBaja(tfJugadorBaja.getText());
                }
                else
                {
                    throw new Excepcion("No has seleccionado ni Alta ni Baja.");
                }
            }
            // Método para volver a abrir la ventana
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMensaje(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass(), "Error", 0);
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bBuscarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarAltaActionPerformed
        // TODO add your handling code here:
        try
        {
            validar(3, tfJugadorAlta.getText(), "^[A-Z0-9][0-9]{7}[A-Z]$");
            /*if(!Main.buscarDNI(tfJugadorAlta.getText()))
            {
                throw new Excepcion("No existe ningún jugador con ese DNI.");
            }*/
            /*if(!Main.esAgenteLibre(tfJugadorAlta.getText()))
            {
                throw new Excepcion("Ese jugador no es agente libre.");
            }*/
            bAceptar.setEnabled(true);
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass(), "Error", 0);
        }
    }//GEN-LAST:event_bBuscarAltaActionPerformed

    private void bBuscarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarBajaActionPerformed
        // TODO add your handling code here:
        try
        {
            validar(3, tfJugadorBaja.getText(), "^[A-Z0-9][0-9]{7}[A-Z]$");
            /*if(!Main.buscarDNI(tfJugadorBaja.getText()))
            {
                throw new Excepcion("No existe ningún jugador con ese DNI.");
            }*/
            // Método para comprobar que ese jugador pertenece al equipo
            bAceptar.setEnabled(true);
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass(), "Error", 0);
        }
    }//GEN-LAST:event_bBuscarBajaActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        // Main.cerrar(this);
    }//GEN-LAST:event_bCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VAltasBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VAltasBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VAltasBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VAltasBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VAltasBajas dialog = new VAltasBajas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bBuscarAlta;
    private javax.swing.JButton bBuscarBaja;
    private javax.swing.JButton bCancelar;
    private javax.swing.ButtonGroup bgAltasBajas;
    private javax.swing.JFormattedTextField ftfSueldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbAlta;
    private javax.swing.JRadioButton rbBajas;
    private javax.swing.JTextArea taPlantilla;
    private javax.swing.JTextField tfEquipo;
    private javax.swing.JTextField tfJugadorAlta;
    private javax.swing.JTextField tfJugadorBaja;
    // End of variables declaration//GEN-END:variables
    
    private void validar(int error, String campo, String patron) throws Exception {

        Pattern p=Pattern.compile(campo);
        Matcher m=p.matcher(patron);
        if(!m.matches())
        {
            throw new Excepcion(error);
        }
    }
    private void mostrarEquipo() {
        // Método para mostrar el equipo del dueño.
        /*tfEquipo.setText(Main.buscarEquipoDuenno());*/
    }

    private void mostrarPlantilla() {
        // Método para mostrar la plantilla del equipo.
        // En la última fila límite salarial.
        /*String mensaje=Main.mostrarPlantilla();
        taPlantilla.setText(mensaje);*/
    }
}
