/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import javax.swing.JOptionPane;
import Excepciones.Excepcion;
import UML.Equipo;
import UML.Persona;
import java.util.ArrayList;

/**
 * Ventana equipo.
 * Fecha de creación de la vista: 24/04/2018
 * @author eqdaw04
 */

public class VEquipo extends javax.swing.JDialog {
    
    private ArrayList<Equipo> listaEquipos;
    private String tipo;
    private int posicion, n;

    /**
     * Metodo para mostrar las opciones según el CRUD que se quiera realizar.
     * @param tipo String
     * @param n int
     */

    public VEquipo(String tipo, int n) {
        initComponents();
        cargarDatos(tipo, n);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bUltimo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taComentario = new javax.swing.JTextArea();
        bBuscar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bPrimero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bAnterior = new javax.swing.JButton();
        bSiguiente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taPlantilla = new javax.swing.JTextArea();
        cFechaCreacion = new org.freixas.jcalendar.JCalendarCombo();
        jLabel5 = new javax.swing.JLabel();
        cbDuenno = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfLugar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bUltimo.setText(">|");
        bUltimo.setEnabled(false);
        bUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUltimoActionPerformed(evt);
            }
        });

        jLabel6.setText("Comentarios:");

        taComentario.setEditable(false);
        taComentario.setColumns(20);
        taComentario.setRows(5);
        jScrollPane1.setViewportView(taComentario);

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
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
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bPrimero.setText("|<");
        bPrimero.setEnabled(false);
        bPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrimeroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EQUIPO");

        jLabel2.setText("Nombre:");

        jLabel4.setText("Fecha de creación:");

        bAnterior.setText("<");
        bAnterior.setEnabled(false);
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });

        bSiguiente.setText(">");
        bSiguiente.setEnabled(false);
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Plantilla:");

        taPlantilla.setEditable(false);
        taPlantilla.setColumns(20);
        taPlantilla.setRows(5);
        jScrollPane2.setViewportView(taPlantilla);

        cFechaCreacion.setEnabled(false);

        jLabel5.setText("Dueño:");

        cbDuenno.setEnabled(false);

        jLabel7.setText("Lugar:");

        tfLugar.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bPrimero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bAnterior)
                                .addGap(28, 28, 28)
                                .addComponent(bSiguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bUltimo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(bAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cFechaCreacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDuenno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfLugar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(bBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDuenno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bSiguiente)
                        .addComponent(bUltimo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bPrimero)
                        .addComponent(bAnterior)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        try
        {
            // Comprobar si se ha accedido con la opción de lsiatado, en caso afirmativo, cargar un list interno para poder recorrer con los botones de dirección
            if(tipo.equals("listado"))
            {
                // Habilitar botones de recorrer si el nombre está vacío, en caso contrario, localizar el equipo en concreto.
                if(tfNombre.getText().isEmpty())
                {
                    posicion=0;
                    listaEquipos = Main.buscarEquipo();
                    if(listaEquipos.size()>1)
                    {
                        bSiguiente.setEnabled(true);
                        bUltimo.setEnabled(true);
                    }
                    else
                    {
                        if(listaEquipos.isEmpty())
                        {
                            throw new Excepcion(28);
                        }
                    }
                    seleccionarEquipo();
                }
                else
                {
                    // Validar si el nombre escrito es correcto y si existe en la bbdd
                    validarNombre();
                    buscarEquipo(tfNombre.getText());
                    bPrimero.setEnabled(false);
                    bAnterior.setEnabled(false);
                    bSiguiente.setEnabled(false);
                    bUltimo.setEnabled(false);
                }
            }
            else
            {
                // Validar si el nombre escrito es correcto y si existe en la bbdd, si existe, mostrar datos y permitir su modificación
                validarNombre();
                buscarEquipo(tfNombre.getText());
                if(tipo.equals("modificacion"))
                {
                    taComentario.setEditable(true);
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

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:
        try
        {
            switch(tipo)
            {
                case "alta":
                    // Validar nombre y si no existe en la BD, proceder al alta
                    validarNombre();
                    // Validar el dueño del equipo
                    validarDuenno();
                    // Insertar el equipo         
                    Main.altaEquipo(tfNombre.getText(),String.valueOf(cbDuenno.getSelectedItem()), cFechaCreacion.getDate(), taComentario.getText());
                    JOptionPane.showMessageDialog(this, "El equipo se ha dado de alta correctamente.");
                    break;
                case "baja":
                    // Validar nombre y si no existe en la BD, proceder a la eliminación
                    validarNombre();
                    // Eliminar el equipo
                    Main.bajaEquipo();
                    JOptionPane.showMessageDialog(this, "El equipo se dado de baja correctamente.");
                    break;
                case "modificacion":
                    // Validar nombre y si no existe en la BD, proceder a la modificación
                    validarNombre();
                    // Modificar el equipo
                    Main.modificarEquipo(tfNombre.getText(), taComentario.getText());
                    JOptionPane.showMessageDialog(this, "El equipo se ha modificado correctamente.");
                    break;
            }
            Main.reabrir(this, tipo, n);
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

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        Main.cerrar(this);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrimeroActionPerformed
        // TODO add your handling code here:
        try
        {
            posicion=0;
            seleccionarEquipo();
            bSiguiente.setEnabled(true);
            bUltimo.setEnabled(true);
            bPrimero.setEnabled(false);
            bAnterior.setEnabled(false);
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bPrimeroActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed
        // TODO add your handling code here:
        try
        {
            posicion=posicion-1;
            seleccionarEquipo();
            bSiguiente.setEnabled(true);
            bUltimo.setEnabled(true);
            if(posicion==0)
            {
                bPrimero.setEnabled(false);
                bAnterior.setEnabled(false);
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
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        try
        {
            posicion=posicion+1;
            seleccionarEquipo();
            bAnterior.setEnabled(true);
            bPrimero.setEnabled(true);
            if(posicion==(listaEquipos.size()-1))
            {
                bSiguiente.setEnabled(false);
                bUltimo.setEnabled(false);
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
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUltimoActionPerformed
        // TODO add your handling code here:
        try
        {
            posicion=listaEquipos.size()-1;     
            seleccionarEquipo();
            bAnterior.setEnabled(true);
            bPrimero.setEnabled(true);
            bSiguiente.setEnabled(false);
            bUltimo.setEnabled(false);
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bUltimoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bPrimero;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JButton bUltimo;
    private org.freixas.jcalendar.JCalendarCombo cFechaCreacion;
    private javax.swing.JComboBox<String> cbDuenno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taComentario;
    private javax.swing.JTextArea taPlantilla;
    private javax.swing.JTextField tfLugar;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
    
       /**
     * Metodo para cargar datos de la ventana.
     * @param tipo String
     * @param n int
     */ 
    
    private void cargarDatos(String tipo, int n) {
        this.n=n;
        this.tipo=tipo;
        setModal(true);
        this.setLocationRelativeTo(null);
        listaEquipos = new ArrayList();
        try
        {
            relllenarLista();
        }
        catch (Excepcion e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getClass() + " \n " + e.getMessage(), "Error", 0);
        }
        bPrimero.setVisible(false);
        bAnterior.setVisible(false);
        bSiguiente.setVisible(false);
        bUltimo.setVisible(false);
        switch(tipo)
        {
            case "alta":
                cbDuenno.setEnabled(true);
                taComentario.setEditable(true);
                bAceptar.setEnabled(true);
                bBuscar.setVisible(false);
                break;
            case "listado":
                bPrimero.setVisible(true);
                bAnterior.setVisible(true);
                bSiguiente.setVisible(true);
                bUltimo.setVisible(true);
                bAceptar.setVisible(false);
                bCancelar.setVisible(false);
                break;
        }
        setVisible(true);
    }
    
     /**
     * Metodo para validar el nombre.
     * @throws Exception 
     */
    
    private void validarNombre() throws Exception {
        // Validar nombre para ver si existe algún equipo con ese nombre
        if(tfNombre.getText().isEmpty())
        {
            throw new Excepcion(50);
        }
        if(tipo.equals("alta"))
        {
            // Comprobar si existe un equipo con ese nombre
            if(Main.buscarEquipo(tfNombre.getText()) != null)
            {
                throw new Excepcion(19);
            }
        }
    }
    
       /**
     * Metodo para buscar equipo por nombre.
     * @param equipo String
     * @throws Exception 
     */ 
    
    private void buscarEquipo(String equipo) throws Exception {
        Equipo e = Main.buscarEquipo(equipo);
        if(e==null)
        {
            throw new Excepcion(20);
        }
        mostrarDatos(e);
    }
    
       /**
     * Metodo para seleccionar un equipo de toda la lista.
     * @throws Exception 
     */ 
    
    private void seleccionarEquipo() throws Exception {
        Equipo e;
        if(listaEquipos.size()>1)
        {
            e=listaEquipos.get(posicion);
        }
        else
        {
            e=listaEquipos.get(0);
        }
        mostrarDatos(e);
    }
    
        /**
     * Metodo para mostrar los datos de un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    private void mostrarDatos(Equipo e) throws Exception {
        tfNombre.setText(e.getNombre());  
        cFechaCreacion.setDate(e.getFechaCreacion());
        taPlantilla.setText(Main.buscarPlantilla(e));
        cbDuenno.setSelectedItem(e.getPersona().getUsuario());
        taComentario.setText(e.getComentario());
    }
    
    /**
     * Metodo para rellenar la lista de dueños.
     * @throws Exception 
     */
    
    private void relllenarLista() throws Exception {
        cbDuenno.removeAllItems();
        ArrayList<Persona> listaDuennos=Main.buscarUsuariosDuennos();
        
        for(int x=0;x<listaDuennos.size();x++)
        {
            cbDuenno.addItem(listaDuennos.get(x).getUsuario());
        }
        cbDuenno.setSelectedIndex(-1);
    }
    
    /**
     * Metodo para validar el dueño.
     * @throws Exception 
     */
    
    private void validarDuenno() throws Exception {
        if(cbDuenno.getSelectedIndex()==-1)
        {
            throw new Excepcion(51);
        }
        if(Main.duennoTieneEquipo(String.valueOf(cbDuenno.getSelectedItem())))
        {
            throw new Excepcion(52);
        }
    }
}
