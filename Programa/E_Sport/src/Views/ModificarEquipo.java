/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import static Controladora.Main.*;
import UML.Equipo;
import UML.Jugador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author usuario
 */
public class ModificarEquipo extends javax.swing.JFrame {

    /**
     * Creates new form ModificarEquipo
     */
    private static Equipo e;
            
    public ModificarEquipo(String usu) throws Exception {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        e= ConsultarEquipoPorUsuario(usu);
        nombeEquipo.setText(e.getNombre());
        rellenar();
    }

    private ModificarEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(853, 503));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Equipo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(275, 31, 179, 32);

        nombeEquipo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        nombeEquipo.setForeground(new java.awt.Color(0, 153, 0));
        nombeEquipo.setText("NOMBREEQUIPO");
        getContentPane().add(nombeEquipo);
        nombeEquipo.setBounds(472, 31, 197, 32);

        liJugEqui.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(liJugEqui);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(62, 170, 259, 214);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Jugadores en el equipo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(62, 142, 133, 16);

        liJugDisp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liJugDisp.setToolTipText("");
        jScrollPane2.setViewportView(liJugDisp);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(509, 170, 259, 214);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Jugadores Disponibles:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(502, 142, 132, 16);

        jButton1.setText("Eliminar Jugador");
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 430, 150, 25);

        jButton2.setText("Añadir Jugador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(570, 430, 150, 25);

        jButton3.setText("Consultar");
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 250, 110, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rellenar() throws Exception{
        ArrayList<Jugador> j=obtenerJugEqui(String.valueOf(e.getIdEquipo()));
        DefaultListModel<String> model = new DefaultListModel<>();
        for (int x=0;x < j.size();x++){
            model.addElement(j.get(x).getNickname());
        }
        liJugEqui.setModel(model);

        ArrayList<Jugador> jug=consultarJugadoresDisponibles();
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (int x=0;x< jug.size();x++){
            modelo.addElement(jug.get(x).getNickname());
        }
        liJugDisp.setModel(modelo);
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> liJugDisp;
    private javax.swing.JList<String> liJugEqui;
    private javax.swing.JLabel nombeEquipo;
    // End of variables declaration//GEN-END:variables
}
