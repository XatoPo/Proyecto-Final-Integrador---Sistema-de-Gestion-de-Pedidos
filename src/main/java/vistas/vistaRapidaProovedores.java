package vistas;

import Formularios.*;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import controlador.*;
import javax.swing.JPanel;
import java.awt.event.*;


public class vistaRapidaProovedores extends javax.swing.JFrame {
    
    private int mouseX, mouseY;
    NegocioMass mass = new NegocioMass();
    public static String id_prov;
    
    public vistaRapidaProovedores() {
        initComponents();
        setSize(650, 515);  // Establecer el tamaño del JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        filtra("");
        
        // Agregar un MouseListener para permitir arrastrar y soltar el JFrame
        panelFondo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        panelFondo.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;

                vistaRapidaProovedores.this.setLocation(x, y);
            }
        });

        // Agregar ComponentListener para gestionar cambios en el tamaño de la ventana
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustar la escala de las imágenes al cambiar el tamaño de la ventana
                EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
                EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(650X515).png");
                EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
            }
        });
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTextoBsq = new javax.swing.JLabel();
        txtNomProovedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProovedores = new javax.swing.JTable();
        lblCerrar = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 120, 40));

        lblTextoBsq.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTextoBsq.setText("Busqueda de Proovedor:");
        panelFondo.add(lblTextoBsq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 160, 40));

        txtNomProovedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomProovedorKeyReleased(evt);
            }
        });
        panelFondo.add(txtNomProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 260, 40));

        tablaProovedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRE", "DESCRIPCIÓN", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProovedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProovedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProovedores);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 121, 600, 370));

        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 30, 30));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 515));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
       this.dispose();
       frmPedido.btnAyudaProovedor.setEnabled(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void txtNomProovedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProovedorKeyReleased
        filtra(txtNomProovedor.getText());
    }//GEN-LAST:event_txtNomProovedorKeyReleased

    private void tablaProovedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProovedoresMouseClicked
        int fila = tablaProovedores.getSelectedRow();
        frmPedido.txtIdProv.setText(tablaProovedores.getValueAt(fila, 0).toString());
        frmPedido.txtNomProv.setText(tablaProovedores.getValueAt(fila, 1).toString());
        frmPedido.txtIdProduc.setText("");
        frmPedido.btnAyudaProducto.setEnabled(true);
    }//GEN-LAST:event_tablaProovedoresMouseClicked

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
            java.util.logging.Logger.getLogger(vistaRapidaProovedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaRapidaProovedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaRapidaProovedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaRapidaProovedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaRapidaProovedores().setVisible(true);
            }
        });
    }
    
    private void EscaladoImagenesLabel(JLabel labelFondo, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(icon);
        this.repaint();
    }
    
    private void EscaladoImagenesButton(JButton botonFondo, String ruta){
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        botonFondo.setIcon(icon);
        this.repaint();
    }
    
    void filtra(String cad){
        DefaultTableModel dt = (DefaultTableModel)tablaProovedores.getModel();
        dt.setRowCount(0);
        mass.obtenerTodosLosProveedoresDatos().stream()
                .filter(x-> x.getNom_prov().toLowerCase().startsWith(cad.toLowerCase()))
                .forEach(x-> dt.addRow(new Object[]{
                    x.getId_prov(), x.getNom_prov(), x.getDescd_prov(), x.getDatos_contacto_prov().getTelef_contac()
                }));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTextoBsq;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tablaProovedores;
    private javax.swing.JTextField txtNomProovedor;
    // End of variables declaration//GEN-END:variables
}
