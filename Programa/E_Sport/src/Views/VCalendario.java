/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author usuario
 */
public class VCalendario extends javax.swing.JDialog {

    /**
     * Creates new form VCalendario
     */
    public VCalendario() {
        initComponents();
        initComopnents2();
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
        Njornada = new javax.swing.JLabel();
        pPartido1 = new javax.swing.JPanel();
        lbE1 = new javax.swing.JLabel();
        lbE2 = new javax.swing.JLabel();
        VS = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Jornada");

        Njornada.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Njornada.setText("X");

        pPartido1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbE1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbE1.setText("Equipo1");

        lbE2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbE2.setText("Equipo2");

        VS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        VS.setText("VS");

        lbFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbFecha.setText("Fechaaaaaaa");

        javax.swing.GroupLayout pPartido1Layout = new javax.swing.GroupLayout(pPartido1);
        pPartido1.setLayout(pPartido1Layout);
        pPartido1Layout.setHorizontalGroup(
            pPartido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartido1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbE1)
                .addGap(32, 32, 32)
                .addComponent(VS)
                .addGap(32, 32, 32)
                .addComponent(lbE2)
                .addGap(70, 70, 70)
                .addComponent(lbFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPartido1Layout.setVerticalGroup(
            pPartido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPartido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbE1)
                    .addComponent(lbE2)
                    .addComponent(VS)
                    .addComponent(lbFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Njornada))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(pPartido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Njornada))
                .addGap(48, 48, 48)
                .addComponent(pPartido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Njornada;
    private javax.swing.JLabel VS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbE1;
    private javax.swing.JLabel lbE2;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JPanel pPartido1;
    // End of variables declaration//GEN-END:variables

    private void initComopnents2() {
        javax.swing.GroupLayout pPartido1Layout = new javax.swing.GroupLayout(pPartido1);
        pPartido1.setLayout(pPartido1Layout);
        pPartido1Layout.setHorizontalGroup(
            pPartido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartido1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbE1)
                .addGap(32, 32, 32)
                .addComponent(VS)
                .addGap(32, 32, 32)
                .addComponent(lbE2)
                .addGap(70, 70, 70)
                .addComponent(lbFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPartido1Layout.setVerticalGroup(
            pPartido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPartido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbE1)
                    .addComponent(lbE2)
                    .addComponent(VS)
                    .addComponent(lbFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Njornada))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(pPartido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }
}
