
package login;

import controlador.NegocioMass;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class frmMenú extends javax.swing.JFrame {
    
    public static String idEmp;
    public static String nomEmp;
    public static String cargoEmp;
    private int mouseX, mouseY;
    
    public frmMenú() {
        initComponents();
        
        setSize(555, 820);  // Cambiar a tamaño de frame
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblTitulo.setText("Bienvenido " + nomEmp);
        
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

                frmMenú.this.setLocation(x, y);
            }
        });

        // Agregar ComponentListener para gestionar cambios en el tamaño de la ventana
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustar la escala de las imágenes al cambiar el tamaño de la ventana
                EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
                EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMenu.png");
                EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
            }
        });
        
        habilitarPorCargo();
    }
    
    void habilitarPorCargo() {
        switch (cargoEmp) {
            case "Gerente":
                //Habilitar todos los botones
                break;
            case "Reponedor":
                //Habilitar ciertos botones
                break;
            case "Vendedor":
                //Habilitar ciertos botones
                break;
            case "Cajero":
                //Habilitar ciertos botones
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo.setMinimumSize(new java.awt.Dimension(555, 820));
        panelFondo.setPreferredSize(new java.awt.Dimension(555, 820));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 60));

        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 20, 40, 40));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(3, 57, 166));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelFondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 540, 50));

        lblFondo.setMaximumSize(new java.awt.Dimension(555, 820));
        lblFondo.setMinimumSize(new java.awt.Dimension(555, 820));
        lblFondo.setPreferredSize(new java.awt.Dimension(555, 820));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 555, 820));

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
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

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
            java.util.logging.Logger.getLogger(frmMenú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenú().setVisible(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
}
