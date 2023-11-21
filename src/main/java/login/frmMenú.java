
package login;

import Formularios.frmEmpleado;
import Formularios.frmMantenimientoEmpleado;
import Formularios.frmMantenimientoPedido;
import Formularios.frmMantenimientoProducto;
import Formularios.frmMantenimientoProveedor;
import Formularios.frmPedido;
import Formularios.frmProducto;
import Formularios.frmProveedor;
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
        btnRegistroProductos = new javax.swing.JButton();
        btnRegistroEmpleados = new javax.swing.JButton();
        btnRegistroProveedores = new javax.swing.JButton();
        btnRegistroPedidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMantenimientoEmpleados = new javax.swing.JButton();
        btnMantenimientoProductos = new javax.swing.JButton();
        btnMantenimientoProveedores = new javax.swing.JButton();
        btnMantenimientoPedidos = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo.setMinimumSize(new java.awt.Dimension(555, 820));
        panelFondo.setPreferredSize(new java.awt.Dimension(555, 820));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 60));

        btnRegistroProductos.setText("PRODUCTOS");
        btnRegistroProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroProductosActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 140, 50));

        btnRegistroEmpleados.setText("EMPLEADOS");
        btnRegistroEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroEmpleadosActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, 50));

        btnRegistroProveedores.setText("PROVEEDORES");
        btnRegistroProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroProveedoresActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 140, 50));

        btnRegistroPedidos.setText("PEDIDOS");
        btnRegistroPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPedidosActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 140, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 160, 50));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANTENIMIENTO");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 220, 40));

        btnMantenimientoEmpleados.setText("EMPLEADOS");
        btnMantenimientoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoEmpleadosActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 140, 50));

        btnMantenimientoProductos.setText("PRODUCTOS");
        btnMantenimientoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoProductosActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 140, 50));

        btnMantenimientoProveedores.setText("PROVEEDORES");
        btnMantenimientoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoProveedoresActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 140, 50));

        btnMantenimientoPedidos.setText("PEDIDOS");
        btnMantenimientoPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoPedidosActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 140, 50));

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
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnRegistroEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroEmpleadosActionPerformed
        this.dispose();
        frmEmpleado emp = new frmEmpleado();
        emp.setVisible(true);
        emp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistroEmpleadosActionPerformed

    private void btnRegistroProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroProductosActionPerformed
        this.dispose();
        frmProducto pro = new frmProducto();
        pro.setVisible(true);
        pro.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistroProductosActionPerformed

    private void btnRegistroProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroProveedoresActionPerformed
        this.dispose();
        frmProveedor prov = new frmProveedor();
        prov.setVisible(true);
        prov.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistroProveedoresActionPerformed

    private void btnRegistroPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPedidosActionPerformed
        this.dispose();
        frmPedido ped = new frmPedido();
        ped.setVisible(true);
        ped.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistroPedidosActionPerformed

    private void btnMantenimientoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoEmpleadosActionPerformed
        this.dispose();
        frmMantenimientoEmpleado manemp = new frmMantenimientoEmpleado();
        manemp.setVisible(true);
        manemp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMantenimientoEmpleadosActionPerformed

    private void btnMantenimientoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoProductosActionPerformed
        this.dispose();
        frmMantenimientoProducto manpro = new frmMantenimientoProducto();
        manpro.setVisible(true);
        manpro.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMantenimientoProductosActionPerformed

    private void btnMantenimientoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoProveedoresActionPerformed
        this.dispose();
        frmMantenimientoProveedor manprov = new frmMantenimientoProveedor();
        manprov.setVisible(true);
        manprov.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMantenimientoProveedoresActionPerformed

    private void btnMantenimientoPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoPedidosActionPerformed
        this.dispose();
        frmMantenimientoPedido manped = new frmMantenimientoPedido();
        manped.setVisible(true);
        manped.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMantenimientoPedidosActionPerformed

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
    private javax.swing.JButton btnMantenimientoEmpleados;
    private javax.swing.JButton btnMantenimientoPedidos;
    private javax.swing.JButton btnMantenimientoProductos;
    private javax.swing.JButton btnMantenimientoProveedores;
    private javax.swing.JButton btnRegistroEmpleados;
    private javax.swing.JButton btnRegistroPedidos;
    private javax.swing.JButton btnRegistroProductos;
    private javax.swing.JButton btnRegistroProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
}
