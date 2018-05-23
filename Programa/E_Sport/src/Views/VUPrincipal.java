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
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 * Vista para el usuario.
 * Fecha de la creación de la vista: 16/05/2018
 * @author eqdaw04
 */
public class VUPrincipal extends javax.swing.JFrame {

    DefaultTableModel mJornada, mClasificacion, mCurso;
    ArrayList<Jornada> listaJornada;
    /**
     * Creates new form VUPrincipal
     * @param usuario usuario
     */
    public VUPrincipal(String usuario) {
        initComponents();
        cargarDatos(usuario);
    }
    
    public VUPrincipal(String usuario, boolean estado) {
        initComponents();
        cargarDatos(usuario);
    }

    private void cargarDatos(String usuario){
        setLocationRelativeTo(null);
        crearImagenes();
        setTitle("Bienvenido a E-Sport");
        lNombre.setText(usuario);
        modelarTabla();
        borrarTabla();
        pGraficoEvolucionEquipo.setVisible(false);
        try {
            cargarJornadas();
            cargarTodoClasificacion();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
        
        setVisible(true);
    }
    
    /**
     * Metodo para cargar los datos de la última jornada.
     * @throws Exception lanza excepcion
     */

    private void cargarJornadas() throws Exception{
        
        try {
            pGraficoEvolucionEquipo.setVisible(false);
            ArrayList<Jornada> lista = Main.saxLiga();
            if(lista.isEmpty()){
                throw new Excepcion(56);
            }
            else{
                cargarPartidos(lista);
            }
            
        } 
        catch(IOException ex){
            
                Main.domLiga();
                cargarJornadas();
            
        }
        catch(Excepcion ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atención", 1);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
        
        
    }
    
    private void cargarPartidos(ArrayList<Jornada> lista) throws Exception{
        listaJornada = new ArrayList();
        listaJornada = lista;
        graficoJornadas(lista);
        cargarJornadas(lista);
        pGraficoEvolucionEquipo.setVisible(false);
    }
    
    private void cargarJornadas(ArrayList <Jornada> partidos) throws Exception{
        lJornada.removeAll();
        Date hoy = new Date();
        
        DefaultListModel <Integer> modelo = new DefaultListModel();    
        for(int x = 0; x < partidos.size(); x++){
            
            if(hoy.after(partidos.get(x).getFechaFinal())){
                modelo.addElement(partidos.get(x).getIdJornada());
            }
            else{
                
                x = partidos.size();
            }
        }
        lJornada.setModel(modelo);
    }
    
    private void graficoJornadas(ArrayList<Jornada> lista){
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        // cargar los datos reales
        for(int x =0; x< lista.size(); x++){
            // el objeto tiene los siguientes datos según su puesto en el array 0 jornada, 1 equipo 2 puntos
            for(int y = 0; y<lista.get(x).getListaPartidos().size(); y++){
                line_chart_dataset.addValue(lista.get(x).getIdJornada(), lista.get(x).getListaPartidos().get(y).geteLocal().getNombre(), String.valueOf(lista.get(x).getListaPartidos().get(y).getmLocal()));
                line_chart_dataset.addValue(lista.get(x).getIdJornada(), lista.get(x).getListaPartidos().get(y).geteVisitante().getNombre(), String.valueOf(lista.get(x).getListaPartidos().get(y).getmVisitante()));
                
            }
            
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
    
    private void cargarUltimaJornada() throws Exception{
        try {
            pGraficoCurso.setVisible(false);
            ArrayList <Partido> partidos = Main.saxUltimaJornada();
            if(partidos.isEmpty()){
                throw new Excepcion(54);
            }
            else{
                cargarUltimoPartido(partidos);
            }
        } 
        catch(IOException ex){
                Main.domUltimaJornada(Main.consultarUltimaJornadaActual());
                cargarUltimaJornada();
            
        }
        catch(Excepcion ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atención", 1);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }
    
    /**
     * Metodo para cargar los datos del último partido.
     * Guardaremos los equipos que han jugado en el partido y su puntuación.
     * @param partidos Partido
     * @throws Exception lanza excepcion
     */
    
    private void cargarUltimoPartido(ArrayList <Partido> partidos) throws Exception{
        for (int x=0;x<partidos.size();x++){
            Object[] fila =new Object[3];
            fila[0]= partidos.get(x).getIdPartido();
            fila[1]= partidos.get(x).geteLocal().getNombre()+" vs "+partidos.get(x).geteVisitante().getNombre();
            fila[2]= partidos.get(x).getmLocal()+" | "+partidos.get(x).getmVisitante();
            mCurso.addRow(fila);
        }
        graficoCurso(partidos);
    }
    
    /**
     * Metodo para generar el gráfico de clasificación. (Se verán los mismo datos que escrito)
     * @throws Exception lanza excepcion
     */
    
    private void cargarTodoClasificacion() throws Exception{
        try {
            pGraficoClasificacion.setVisible(false);
            ArrayList<Object> lista = Main.saxClasificacion();
            cargarUltimaJornada();
            if(lista.isEmpty()){
                throw new Excepcion(39);
            }
            else{
                cargarClasificacion(lista);
            }
            
        } 
        catch(IOException ex){
                Main.domClasificacion();
                cargarTodoClasificacion();
            
            
        }
        catch(Excepcion ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atención", 1);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }
    
    /**
     * Metodo para ajustar el tamaño de la tabla de partidos de la jornada.
     */
 
    
    private void modelarTabla(){
        
        mClasificacion = new DefaultTableModel();
	Object[] vec2 = {"Posición","Equipo","Marcador"};
	mClasificacion.setColumnIdentifiers(vec2);
	tClasificacion.setModel(mClasificacion);
	tClasificacion.getColumnModel().getColumn(0).setPreferredWidth(125);
	tClasificacion.getColumnModel().getColumn(1).setPreferredWidth(255);
	tClasificacion.getColumnModel().getColumn(2).setPreferredWidth(125);
        tClasificacion.setRowHeight(40);
        tClasificacion.setShowVerticalLines(false);
        tClasificacion.setGridColor(Color.BLUE);
        
        mCurso = new DefaultTableModel();
	Object[] vec3 = {"Partido","Equipo","Marcador"};
	mCurso.setColumnIdentifiers(vec3);
	tCurso.setModel(mCurso);
	tCurso.getColumnModel().getColumn(0).setPreferredWidth(125);
	tCurso.getColumnModel().getColumn(1).setPreferredWidth(255);
	tCurso.getColumnModel().getColumn(2).setPreferredWidth(125);
        tCurso.setRowHeight(40);
        tCurso.setShowVerticalLines(false);
        tCurso.setGridColor(Color.BLUE);
        
        
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        tClasificacion.getColumnModel().getColumn(0).setCellRenderer(centrar);
        tClasificacion.getColumnModel().getColumn(1).setCellRenderer(centrar);
        tClasificacion.getColumnModel().getColumn(2).setCellRenderer(centrar);
        tCurso.getColumnModel().getColumn(0).setCellRenderer(centrar);
        tCurso.getColumnModel().getColumn(1).setCellRenderer(centrar);
        tCurso.getColumnModel().getColumn(2).setCellRenderer(centrar);
        
        tClasificacion.getColumnModel().getColumn(0).setHeaderRenderer(centrar);
        tClasificacion.getColumnModel().getColumn(1).setHeaderRenderer(centrar);
        tClasificacion.getColumnModel().getColumn(2).setHeaderRenderer(centrar);
        
        tCurso.getColumnModel().getColumn(0).setHeaderRenderer(centrar);
        tCurso.getColumnModel().getColumn(1).setHeaderRenderer(centrar);
        tCurso.getColumnModel().getColumn(2).setHeaderRenderer(centrar);
    }
    
    private void crearImagenes(){
        
        ImageIcon logo = new ImageIcon("../../imagenes/4fan.png");
        Icon icono3 = new ImageIcon(logo.getImage().getScaledInstance(logotipo.getWidth(), logotipo.getHeight(), Image.SCALE_DEFAULT));
        logotipo.setIcon(icono3);
        this.repaint();
        this.repaint();
    }
    
    private void cargarClasificacion(ArrayList<Object> lista){
        Calendar hoy = Calendar.getInstance();
        SimpleDateFormat ff = new SimpleDateFormat("dd-MM-yyyy");
        lFechaActualizacion.setText(ff.format(hoy.getTime()));
        graficoClasificacion(lista);
        pGraficoClasificacion.setVisible(false);
    }
    
    private void graficoClasificacion(ArrayList<Object> lista){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for(int x =0; x< lista.size(); x++){
            Object[] fila = (Object[]) lista.get(x);
            pieDataset.setValue(String.valueOf(fila[1]), new Integer(Integer.parseInt(fila[2].toString())));
            mClasificacion.addRow(fila);
        }
        JFreeChart chart = ChartFactory.createPieChart("",pieDataset, true, true, false);
        
        //Mostramos la grafica en pantalla
        ChartPanel panel = new ChartPanel(chart);
        pGraficoClasificacion.setLayout(new java.awt.BorderLayout());
        pGraficoClasificacion.add(panel);
        pGraficoClasificacion.validate();
        
    }
    
    private void graficoCurso(ArrayList<Partido> partidos){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for(int x =0; x< partidos.size(); x++){
            Partido p = partidos.get(x);
            if(p.geteLocal() != null){
                pieDataset.setValue(p.geteLocal().getNombre(), p.getmLocal());
            }
            if(p.geteVisitante() != null){
                pieDataset.setValue(p.geteVisitante().getNombre(), p.getmVisitante());
            }
        }
        JFreeChart chart = ChartFactory.createPieChart("",pieDataset, true, true, false);
        
        //Mostramos la grafica en pantalla
        ChartPanel panel = new ChartPanel(chart);
        pGraficoCurso.setLayout(new java.awt.BorderLayout());
        pGraficoCurso.add(panel);
        pGraficoCurso.validate();
        
    }
    
    private void graficosEvolucion(ArrayList<Object> lista) throws Exception{
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for(int x =0; x< lista.size(); x++){
            Object[] fila = (Object[]) lista.get(x);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tJornada = new javax.swing.JTable();
        pGraficoEvolucionEquipo = new javax.swing.JPanel();
        pGraficoCurso = new javax.swing.JPanel();
        pGraficoClasificacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tCurso = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lNombre = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lJornada = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bEvolucion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bGraficoClasificacion = new javax.swing.JButton();
        jBotonUltima = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lFechaActualizacion = new javax.swing.JLabel();
        logotipo = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tClasificacion = new javax.swing.JTable();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1163, 823));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        tJornada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Partido", "Local VS Visitante", "Marcador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tJornada.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tJornada);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 490, 570, 280);

        pGraficoEvolucionEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pGraficoEvolucionEquipoLayout = new javax.swing.GroupLayout(pGraficoEvolucionEquipo);
        pGraficoEvolucionEquipo.setLayout(pGraficoEvolucionEquipoLayout);
        pGraficoEvolucionEquipoLayout.setHorizontalGroup(
            pGraficoEvolucionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        pGraficoEvolucionEquipoLayout.setVerticalGroup(
            pGraficoEvolucionEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        getContentPane().add(pGraficoEvolucionEquipo);
        pGraficoEvolucionEquipo.setBounds(30, 90, 1080, 310);

        pGraficoCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pGraficoCursoLayout = new javax.swing.GroupLayout(pGraficoCurso);
        pGraficoCurso.setLayout(pGraficoCursoLayout);
        pGraficoCursoLayout.setHorizontalGroup(
            pGraficoCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        pGraficoCursoLayout.setVerticalGroup(
            pGraficoCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        getContentPane().add(pGraficoCurso);
        pGraficoCurso.setBounds(30, 130, 530, 270);

        pGraficoClasificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pGraficoClasificacionLayout = new javax.swing.GroupLayout(pGraficoClasificacion);
        pGraficoClasificacion.setLayout(pGraficoClasificacionLayout);
        pGraficoClasificacionLayout.setHorizontalGroup(
            pGraficoClasificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        pGraficoClasificacionLayout.setVerticalGroup(
            pGraficoClasificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        getContentPane().add(pGraficoClasificacion);
        pGraficoClasificacion.setBounds(580, 130, 530, 270);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Partidos de la Jornada ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 460, 560, 22);

        tCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Posición", "Local VS Visitante", "Marcador"
            }
        ));
        tCurso.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tCurso);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 130, 530, 269);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Jornada en Curso:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 270, 30);

        lNombre.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lNombre.setForeground(new java.awt.Color(0, 153, 255));
        lNombre.setText("Hola ");
        getContentPane().add(lNombre);
        lNombre.setBounds(130, 40, 350, 30);

        lJornada.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lJornadaValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lJornada);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(30, 490, 182, 280);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("Jornada número");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 460, 180, 23);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel9.setText("Hola ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 40, 90, 30);

        bEvolucion.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        bEvolucion.setText("<html><center>Ver gráfico<br></br>evolución de Equipos</center></html>");
        bEvolucion.setActionCommand("");
        bEvolucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEvolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEvolucionActionPerformed(evt);
            }
        });
        getContentPane().add(bEvolucion);
        bEvolucion.setBounds(840, 570, 240, 60);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton3.setText("Cerrar Sesión");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(840, 730, 240, 40);

        bGraficoClasificacion.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        bGraficoClasificacion.setText("Ver en Gráfico de la Liga actual");
        bGraficoClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGraficoClasificacionActionPerformed(evt);
            }
        });
        getContentPane().add(bGraficoClasificacion);
        bGraficoClasificacion.setBounds(480, 409, 310, 40);

        jBotonUltima.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jBotonUltima.setText("Ver en Gráfico la jornada en curso");
        jBotonUltima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonUltimaActionPerformed(evt);
            }
        });
        getContentPane().add(jBotonUltima);
        jBotonUltima.setBounds(30, 409, 340, 40);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Última actualización de la Liga");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(800, 490, 320, 18);

        lFechaActualizacion.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lFechaActualizacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lFechaActualizacion.setText("12/12/2018");
        getContentPane().add(lFechaActualizacion);
        lFechaActualizacion.setBounds(840, 530, 240, 17);
        getContentPane().add(logotipo);
        logotipo.setBounds(1030, 10, 80, 70);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton4.setText("Ver El Calendario");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(840, 640, 240, 40);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("Clasificación Actual:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(580, 90, 270, 30);

        tClasificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Posición", "Local VS Visitante", "Marcador"
            }
        ));
        tClasificacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tClasificacion);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(580, 130, 530, 269);

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"))); // NOI18N
        getContentPane().add(img);
        img.setBounds(0, 0, 1170, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Main.cerrarSesion(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Main.abrirVentana(8, "1");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void bEvolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEvolucionActionPerformed
        try {
            if(bEvolucion.getText().equals("<html><center>Ver gráfico<br></br>evolución de Equipos</center></html>")){
                pGraficoEvolucionEquipo.setVisible(true);
                bEvolucion.setText("<html><center>Ocultar Gráfigo Evolución</center></html>");
            }
            else{
                pGraficoEvolucionEquipo.setVisible(false);
                bEvolucion.setText("<html><center>Ver gráfico<br></br>evolución de Equipos</center></html>");
            }
            graficosEvolucion(Main.resultadosTodosLosPartidos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getClass() + " \n " + ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_bEvolucionActionPerformed

    private void bGraficoClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGraficoClasificacionActionPerformed
        if(bGraficoClasificacion.getText().equals("Ver en Gráfico de la Liga actual")){
            pGraficoClasificacion.setVisible(true);
            bGraficoClasificacion.setText("Ocultar Gráfigo Liga Actual");
        }
        else{
            pGraficoClasificacion.setVisible(false);
            bGraficoClasificacion.setText("Ver en Gráfico de la Liga actual");
        }
    }//GEN-LAST:event_bGraficoClasificacionActionPerformed

    private void jBotonUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonUltimaActionPerformed
        if(jBotonUltima.getText().equals("Ver en Gráfico la jornada en curso")){
            pGraficoCurso.setVisible(true);
            jBotonUltima.setText("Ocultar Gráfico la jornada en curso");
        }
        else{
            pGraficoCurso.setVisible(false);
            jBotonUltima.setText("Ver en Gráfico la jornada en curso");
        }
    }//GEN-LAST:event_jBotonUltimaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing
    private void borrarTabla(){
        mJornada = new DefaultTableModel();
	Object[] vec1 = {"Partido","Local VS Visitante","Marcador"};
	mJornada.setColumnIdentifiers(vec1);
	tJornada.setModel(mJornada);
	tJornada.getColumnModel().getColumn(0).setPreferredWidth(75);
	tJornada.getColumnModel().getColumn(1).setPreferredWidth(360);
	tJornada.getColumnModel().getColumn(2).setPreferredWidth(75);
        tJornada.setRowHeight(40);
        tJornada.setShowVerticalLines(false);
        tJornada.setGridColor(Color.BLUE);
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tJornada.getColumnModel().getColumn(0).setCellRenderer(centrar);
        tJornada.getColumnModel().getColumn(1).setCellRenderer(centrar);
        tJornada.getColumnModel().getColumn(2).setCellRenderer(centrar);
    }
    private void lJornadaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lJornadaValueChanged
        borrarTabla();
        for (int x=0;x<listaJornada.get(lJornada.getSelectedValue()-1).getListaPartidos().size();x++){
            Partido partidos = listaJornada.get(lJornada.getSelectedValue()-1).getListaPartidos().get(x);
            Object[] fila =new Object[3];
            fila[0]= partidos.getIdPartido();
            fila[1]= partidos.geteLocal().getNombre()+" vs "+partidos.geteVisitante().getNombre();
            fila[2]= partidos.getmLocal()+" | "+partidos.getmVisitante();
            mJornada.addRow(fila);
        }
    }//GEN-LAST:event_lJornadaValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEvolucion;
    private javax.swing.JButton bGraficoClasificacion;
    private javax.swing.JLabel img;
    private javax.swing.JButton jBotonUltima;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lFechaActualizacion;
    private javax.swing.JList<Integer> lJornada;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel logotipo;
    private javax.swing.JPanel pGraficoClasificacion;
    private javax.swing.JPanel pGraficoCurso;
    private javax.swing.JPanel pGraficoEvolucionEquipo;
    private javax.swing.JTable tClasificacion;
    private javax.swing.JTable tCurso;
    private javax.swing.JTable tJornada;
    // End of variables declaration//GEN-END:variables
}
