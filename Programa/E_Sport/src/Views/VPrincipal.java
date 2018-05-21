/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controladora.Main;
import UML.Jornada;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Ventana principal.
 * Fecha de creación de la vista: 24/04/2018
 * @author eqdaw04
 */
public class VPrincipal extends javax.swing.JFrame {

    
    public VPrincipal(int tipo,String usuario) {
        initComponents();
        cargarDatos(tipo, usuario);
    }
    
    private void cargarDatos(int tipo, String usuario){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Bienvenido a E-Sport");
        setVisible(true);
        lNombreUsu.setText(usuario);
        // obtener el tamaño de la ventana y asignarle como valor mínimo para no perder la forma de la pantalla
        this.setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        crearImagenes();
        switch(tipo)
        {
            case 1:
                equipos.setVisible(false);
                break;
            case 2:
                comprobarJornada();
                administracion.setVisible(false);
                bAlta.setVisible(false);
                bModificar.setVisible(false);
                bBaja.setVisible(false);
                bConsulta.setVisible(false);
                bMarcador.setVisible(false);
                break;
            case 3:
                administracion.setVisible(false);
                equipos.setVisible(false);                
                break;
        }
    }
    
    private void comprobarJornada(){
        //comprobar si ha comenzado la liga
        try{
            Date hoy = new Date();
            Jornada j = Main.consultarInicioJornada();
            if(j != null){
                if(hoy.after(j.getFechaInicio()) || hoy.compareTo(j.getFechaInicio()) == 1 ){
                    equipos.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Se ha deshabilitado la opción de Editar Equipo, ya que la liga ha comenzado ya.");
                }
            }
        }
        catch( Exception ex){
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }
    
    private void crearImagenes(){
        try{
            ImageIcon logo = new ImageIcon("../../imagenes/4fan.png");
            Icon icono3 = new ImageIcon(logo.getImage().getScaledInstance(logotipo.getWidth(), logotipo.getHeight(), Image.SCALE_DEFAULT));
            logotipo.setIcon(icono3);
            this.repaint();
            logotipo.setLocation(this.getWidth()-(logotipo.getWidth()+50), this.getHeight()-(logotipo.getHeight()+100));
            imgfondo.setSize(this.getWidth(), this.getHeight());
            Image img = new ImageIcon ("../../imagenes/fondo2.jpg").getImage();
            ImageIcon img2 = new ImageIcon(img.getScaledInstance( imgfondo.getWidth(), imgfondo.getHeight(), Image.SCALE_DEFAULT));
            imgfondo.setIcon(img2);
            this.repaint();

            bCerrarSesion.setLocation(this.getWidth()- (bCerrarSesion.getWidth()+50), 50 );
            lBienvenido.setLocation(20, 50);
            lNombreUsu.setLocation(20 + lBienvenido.getSize().width, 50);
            graficoClasificacion(Main.resultados());
            graficosEvolucion(Main.resultadosTodosLosPartidos());
        }
        catch( Exception ex){
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }
    private void graficosEvolucion(ArrayList<Object> lista) throws Exception{
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(int x =0; x< lista.size(); x++){
            Object[] fila = (Object[]) lista.get(x);
            // 0 jornada, 1 equipo 2 puntos
            line_chart_dataset.addValue(Integer.valueOf(fila[2].toString()), fila[1].toString(), fila[0].toString());
        }
        // Creando el Grafico
        JFreeChart chart=ChartFactory.createLineChart("",
                "Jornada","Marcador",line_chart_dataset,PlotOrientation.VERTICAL, true, true, true);
        ChartPanel chartPanel = new ChartPanel(chart);
        pGraficoEvolucionEquipo.setLayout(new java.awt.BorderLayout());
        pGraficoEvolucionEquipo.removeAll();
        pGraficoEvolucionEquipo.add(chartPanel);
        pGraficoEvolucionEquipo.validate();
    }
    
    private void graficoClasificacion(ArrayList<Object> lista){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for(int x =0; x< lista.size(); x++){
            Object[] fila = (Object[]) lista.get(x);
            pieDataset.setValue(String.valueOf(fila[1]), new Integer(Integer.parseInt(fila[2].toString())));
        }
        JFreeChart chart = ChartFactory.createPieChart("",pieDataset, true, true, false);
        
        //Mostramos la grafica en pantalla
        ChartPanel panel = new ChartPanel(chart);
        pGraficoClasificacion.setLayout(new java.awt.BorderLayout());
        pGraficoClasificacion.removeAll();
        pGraficoClasificacion.add(panel);
        pGraficoClasificacion.validate();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bVerGrande = new javax.swing.JButton();
        pGraficoEvolucionEquipo = new javax.swing.JPanel();
        bActualizarGráfico = new javax.swing.JButton();
        bCerrarSesion = new javax.swing.JButton();
        pGraficoClasificacion = new javax.swing.JPanel();
        lBienvenido = new javax.swing.JLabel();
        lNombreUsu = new javax.swing.JLabel();
        logotipo = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        bMarcador = new javax.swing.JButton();
        bAlta = new javax.swing.JButton();
        bBaja = new javax.swing.JButton();
        bConsulta = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        imgfondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        administracion = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        crearJugador = new javax.swing.JMenuItem();
        crearEquipo = new javax.swing.JMenuItem();
        crearUsuario = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        modificarJugador = new javax.swing.JMenuItem();
        modificarEquipo = new javax.swing.JMenuItem();
        modificarUsuario = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        eliminarJugador = new javax.swing.JMenuItem();
        eliminarEquipo = new javax.swing.JMenuItem();
        eliminarUsuario = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        verJugador = new javax.swing.JMenuItem();
        verEquipo = new javax.swing.JMenuItem();
        verUsuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        generarCalendario = new javax.swing.JMenuItem();
        introducirResultados = new javax.swing.JMenuItem();
        equipos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        ver = new javax.swing.JMenu();
        verCalendario = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(988, 691));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        bVerGrande.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bVerGrande.setText("Ver Evolución en grande");
        bVerGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerGrandeActionPerformed(evt);
            }
        });
        getContentPane().add(bVerGrande);
        bVerGrande.setBounds(430, 450, 280, 40);

        pGraficoEvolucionEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pGraficoEvolucionEquipoLayout = new javax.swing.GroupLayout(pGraficoEvolucionEquipo);
        pGraficoEvolucionEquipo.setLayout(pGraficoEvolucionEquipoLayout);
        pGraficoEvolucionEquipoLayout.setHorizontalGroup(
            pGraficoEvolucionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
        pGraficoEvolucionEquipoLayout.setVerticalGroup(
            pGraficoEvolucionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        getContentPane().add(pGraficoEvolucionEquipo);
        pGraficoEvolucionEquipo.setBounds(430, 130, 760, 310);

        bActualizarGráfico.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bActualizarGráfico.setText("Actualizar Los Gráficos");
        bActualizarGráfico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarGráficoActionPerformed(evt);
            }
        });
        getContentPane().add(bActualizarGráfico);
        bActualizarGráfico.setBounds(720, 450, 240, 40);

        bCerrarSesion.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        bCerrarSesion.setText("Cerrar sesión");
        bCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(bCerrarSesion);
        bCerrarSesion.setBounds(1030, 30, 160, 50);

        pGraficoClasificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pGraficoClasificacionLayout = new javax.swing.GroupLayout(pGraficoClasificacion);
        pGraficoClasificacion.setLayout(pGraficoClasificacionLayout);
        pGraficoClasificacionLayout.setHorizontalGroup(
            pGraficoClasificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        pGraficoClasificacionLayout.setVerticalGroup(
            pGraficoClasificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        getContentPane().add(pGraficoClasificacion);
        pGraficoClasificacion.setBounds(430, 500, 530, 340);

        lBienvenido.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        lBienvenido.setText("Bienvenido");
        getContentPane().add(lBienvenido);
        lBienvenido.setBounds(50, 490, 220, 47);

        lNombreUsu.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        lNombreUsu.setForeground(new java.awt.Color(0, 153, 255));
        lNombreUsu.setText("Nombre");
        getContentPane().add(lNombreUsu);
        lNombreUsu.setBounds(270, 490, 170, 47);
        getContentPane().add(logotipo);
        logotipo.setBounds(280, 580, 80, 70);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton7.setText("Ver el Calendario");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(990, 550, 200, 40);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton6.setText("Ver Resultados");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(990, 500, 200, 40);

        bMarcador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bMarcador.setText("Insertar Marcador");
        bMarcador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMarcadorActionPerformed(evt);
            }
        });
        getContentPane().add(bMarcador);
        bMarcador.setBounds(990, 800, 200, 40);

        bAlta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bAlta.setText("Alta de Usuario");
        bAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaActionPerformed(evt);
            }
        });
        getContentPane().add(bAlta);
        bAlta.setBounds(990, 600, 200, 40);

        bBaja.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bBaja.setText("Baja de Usuario");
        bBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaActionPerformed(evt);
            }
        });
        getContentPane().add(bBaja);
        bBaja.setBounds(990, 700, 200, 40);

        bConsulta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bConsulta.setText("Consulta de Usuario");
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(bConsulta);
        bConsulta.setBounds(990, 750, 200, 40);

        bModificar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bModificar.setText("Modificar Usuario");
        bModificar.setActionCommand("");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar);
        bModificar.setBounds(990, 650, 200, 40);
        getContentPane().add(imgfondo);
        imgfondo.setBounds(0, 0, 950, 640);

        administracion.setText("Administración");
        administracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu4.setText("Crear");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        crearJugador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        crearJugador.setText("Jugador");
        crearJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearJugadorActionPerformed(evt);
            }
        });
        jMenu4.add(crearJugador);

        crearEquipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        crearEquipo.setText("Equipo");
        crearEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEquipoActionPerformed(evt);
            }
        });
        jMenu4.add(crearEquipo);

        crearUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        crearUsuario.setText("Usuario");
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(crearUsuario);

        administracion.add(jMenu4);

        jMenu5.setText("Modificar");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        modificarJugador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificarJugador.setText("Jugador");
        modificarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarJugadorActionPerformed(evt);
            }
        });
        jMenu5.add(modificarJugador);

        modificarEquipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificarEquipo.setText("Equipo");
        modificarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEquipoActionPerformed(evt);
            }
        });
        jMenu5.add(modificarEquipo);

        modificarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificarUsuario.setText("Usuario");
        modificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioActionPerformed(evt);
            }
        });
        jMenu5.add(modificarUsuario);

        administracion.add(jMenu5);

        jMenu6.setText("Eliminar");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        eliminarJugador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarJugador.setText("Jugador");
        eliminarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJugadorActionPerformed(evt);
            }
        });
        jMenu6.add(eliminarJugador);

        eliminarEquipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarEquipo.setText("Equipo");
        eliminarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEquipoActionPerformed(evt);
            }
        });
        jMenu6.add(eliminarEquipo);

        eliminarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarUsuario.setText("Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
            }
        });
        jMenu6.add(eliminarUsuario);

        administracion.add(jMenu6);

        jMenu7.setText("Ver");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        verJugador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        verJugador.setText("Jugador");
        verJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verJugadorActionPerformed(evt);
            }
        });
        jMenu7.add(verJugador);

        verEquipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        verEquipo.setText("Equipo");
        verEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEquipoActionPerformed(evt);
            }
        });
        jMenu7.add(verEquipo);

        verUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        verUsuario.setText("Usuario");
        verUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verUsuarioActionPerformed(evt);
            }
        });
        jMenu7.add(verUsuario);

        administracion.add(jMenu7);
        administracion.add(jSeparator1);

        generarCalendario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        generarCalendario.setText("Generar Liga");
        generarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarCalendarioActionPerformed(evt);
            }
        });
        administracion.add(generarCalendario);

        introducirResultados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        introducirResultados.setText("Introducir resultados");
        introducirResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introducirResultadosActionPerformed(evt);
            }
        });
        administracion.add(introducirResultados);

        jMenuBar1.add(administracion);

        equipos.setText("Equipos");
        equipos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Modificar Equipo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        equipos.add(jMenuItem1);

        jMenuBar1.add(equipos);

        ver.setText("Ver");
        ver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        verCalendario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        verCalendario.setText("Calendario");
        verCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCalendarioActionPerformed(evt);
            }
        });
        ver.add(verCalendario);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setText("Resultados y Clasificación");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        ver.add(jMenuItem2);

        jMenuBar1.add(ver);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearJugadorActionPerformed
        try {
            Main.abrirVentana(1, "alta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_crearJugadorActionPerformed

    private void crearEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEquipoActionPerformed
        try {
            Main.abrirVentana(2, "alta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_crearEquipoActionPerformed

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed
        try {
            Main.abrirVentana(3, "alta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void modificarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJugadorActionPerformed
        try {
            Main.abrirVentana(1, "modificacion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_modificarJugadorActionPerformed

    private void modificarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEquipoActionPerformed
        try {
            Main.abrirVentana(2, "modificacion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_modificarEquipoActionPerformed

    private void modificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioActionPerformed
        try {
            Main.abrirVentana(3, "modificacion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_modificarUsuarioActionPerformed

    private void eliminarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJugadorActionPerformed
        try {
            Main.abrirVentana(1, "baja");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_eliminarJugadorActionPerformed

    private void eliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEquipoActionPerformed
        try {
            Main.abrirVentana(2, "baja");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_eliminarEquipoActionPerformed

    private void eliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioActionPerformed
        try {
            Main.abrirVentana(3, "baja");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_eliminarUsuarioActionPerformed

    private void verJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verJugadorActionPerformed
        try {
            Main.abrirVentana(1, "listado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_verJugadorActionPerformed

    private void verEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEquipoActionPerformed
        try {
            Main.abrirVentana(2, "listado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_verEquipoActionPerformed

    private void verUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verUsuarioActionPerformed
        try {
            Main.abrirVentana(3, "listado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_verUsuarioActionPerformed

    private void introducirResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_introducirResultadosActionPerformed
        // Abrir la ventana para la introduccion de los resultados de los partidos        
        try {
            Main.abrirVentana(6, "");
        } catch (Exception ex) {
            //Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_introducirResultadosActionPerformed

    private void verCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCalendarioActionPerformed
        try {
            // TODO add your handling code here:
            // Abrir ventana
            Main.abrirVentana(8, "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_verCalendarioActionPerformed

    private void bCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarSesionActionPerformed
        Main.cerrarSesion(this);
    }//GEN-LAST:event_bCerrarSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            Main.abrirVentana(5, lNombreUsu.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void generarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarCalendarioActionPerformed
        try {
            Main.abrirVentana(7, "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_generarCalendarioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            Main.abrirVentana(9, lNombreUsu.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void bBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBajaActionPerformed
        try {
            Main.abrirVentana(3, "baja");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bBajaActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        try {
            Main.abrirVentana(3, "modificacion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaActionPerformed
        try {
            Main.abrirVentana(3, "alta");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bAltaActionPerformed

    private void bConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaActionPerformed
        try {
            Main.abrirVentana(3, "listado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bConsultaActionPerformed

    private void bMarcadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMarcadorActionPerformed
        try {
            Main.abrirVentana(6, "");
        } catch (Exception ex) {
            //Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bMarcadorActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            Main.abrirVentana(9, lNombreUsu.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            // Abrir ventana
            Main.abrirVentana(8, "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void bVerGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerGrandeActionPerformed
        if(bVerGrande.getText().equals("Reducir el tamaño")){
            bVerGrande.setLocation(430, 450);
            pGraficoEvolucionEquipo.setLocation(430, 130);
            pGraficoEvolucionEquipo.setSize(760, 310);
            bVerGrande.setText("Ver Evolución en grande");
            pGraficoEvolucionEquipo.validate();
        }    
        else{
            bVerGrande.setLocation((this.getWidth()-bVerGrande.getWidth())/2, logotipo.getY()+20);
            pGraficoEvolucionEquipo.setLocation(0, 0);
            pGraficoEvolucionEquipo.setSize(this.getWidth()-10, bVerGrande.getY()- 40);
            bVerGrande.setText("Reducir el tamaño");
            pGraficoEvolucionEquipo.validate();
        }
            
        
        
    }//GEN-LAST:event_bVerGrandeActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void bActualizarGráficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarGráficoActionPerformed
        
        try {
            graficoClasificacion(Main.resultados());
            graficosEvolucion(Main.resultadosTodosLosPartidos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bActualizarGráficoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu administracion;
    private javax.swing.JButton bActualizarGráfico;
    private javax.swing.JButton bAlta;
    private javax.swing.JButton bBaja;
    private javax.swing.JButton bCerrarSesion;
    private javax.swing.JButton bConsulta;
    private javax.swing.JButton bMarcador;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bVerGrande;
    private javax.swing.JMenuItem crearEquipo;
    private javax.swing.JMenuItem crearJugador;
    private javax.swing.JMenuItem crearUsuario;
    private javax.swing.JMenuItem eliminarEquipo;
    private javax.swing.JMenuItem eliminarJugador;
    private javax.swing.JMenuItem eliminarUsuario;
    private javax.swing.JMenu equipos;
    private javax.swing.JMenuItem generarCalendario;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JMenuItem introducirResultados;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lBienvenido;
    private javax.swing.JLabel lNombreUsu;
    private javax.swing.JLabel logotipo;
    private javax.swing.JMenuItem modificarEquipo;
    private javax.swing.JMenuItem modificarJugador;
    private javax.swing.JMenuItem modificarUsuario;
    private javax.swing.JPanel pGraficoClasificacion;
    private javax.swing.JPanel pGraficoEvolucionEquipo;
    private javax.swing.JMenu ver;
    private javax.swing.JMenuItem verCalendario;
    private javax.swing.JMenuItem verEquipo;
    private javax.swing.JMenuItem verJugador;
    private javax.swing.JMenuItem verUsuario;
    // End of variables declaration//GEN-END:variables
}
