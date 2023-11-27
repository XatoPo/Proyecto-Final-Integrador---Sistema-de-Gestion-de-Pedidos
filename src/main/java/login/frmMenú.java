
package login;

import Formularios.frmEmpleado;
import Formularios.frmMantenimientoEmpleado;
import Formularios.frmMantenimientoPedido;
import Formularios.frmMantenimientoProducto;
import Formularios.frmMantenimientoProveedor;
import Formularios.frmPedido;
import Formularios.frmProducto;
import Formularios.frmProveedor;
import java.awt.Color;
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
        
        String bienvenida = "Bienvenido " + nomEmp;
        lblTitulo.setText(textoHTML(bienvenida));
        
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
        
        // Cambio de color al pasar el mouse sobre el botón Registro de Productos
        btnRegistroProductos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnRegistroProductos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnRegistroProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistroProductos.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnRegistroProductos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistroProductos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnRegistroProductos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnRegistroEmpleados.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnRegistroEmpleados.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnRegistroEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistroEmpleados.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnRegistroEmpleados.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistroEmpleados.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnRegistroEmpleados.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnRegistroPedidos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnRegistroPedidos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnRegistroPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistroPedidos.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnRegistroPedidos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistroPedidos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnRegistroPedidos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnRegistroProveedores.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnRegistroProveedores.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnRegistroProveedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistroProveedores.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnRegistroProveedores.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistroProveedores.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnRegistroProveedores.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnMantenimientoEmpleados.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnMantenimientoEmpleados.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnMantenimientoEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnMantenimientoEmpleados.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnMantenimientoEmpleados.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMantenimientoEmpleados.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnMantenimientoEmpleados.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnMantenimientoPedidos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnMantenimientoPedidos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnMantenimientoPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnMantenimientoPedidos.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnMantenimientoPedidos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMantenimientoPedidos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnMantenimientoPedidos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnMantenimientoProductos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnMantenimientoProductos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnMantenimientoProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnMantenimientoProductos.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnMantenimientoProductos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMantenimientoProductos.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnMantenimientoProductos.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        btnMantenimientoProveedores.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
        btnMantenimientoProveedores.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
        btnMantenimientoProveedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnMantenimientoProveedores.setBackground(new Color(3,57,166)); // Cambiar el color al pasar el mouse sobre el botón
                btnMantenimientoProveedores.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMantenimientoProveedores.setBackground(new Color(174, 36, 155)); // Restaurar el color original al salir del botón
                btnMantenimientoProveedores.setForeground(new Color(221, 221, 221)); // Cambiar el color del texto
            }
        });
        
        habilitarPorCargo();
    }
    
    void habilitarPorCargo() {
        switch (cargoEmp) {
            case "Gerente":
                btnMantenimientoEmpleados.setEnabled(true);
                btnMantenimientoPedidos.setEnabled(true);
                btnMantenimientoProductos.setEnabled(true);
                btnMantenimientoProveedores.setEnabled(true);
                btnRegistroEmpleados.setEnabled(true);
                btnRegistroPedidos.setEnabled(true);
                btnRegistroProductos.setEnabled(true);
                btnRegistroProveedores.setEnabled(true);
                break;
            case "Reponedor":
                btnMantenimientoEmpleados.setEnabled(false);
                btnMantenimientoPedidos.setEnabled(false);
                btnMantenimientoProductos.setEnabled(true);
                btnMantenimientoProveedores.setEnabled(true);
                btnRegistroEmpleados.setEnabled(false);
                btnRegistroPedidos.setEnabled(false);
                btnRegistroProductos.setEnabled(true);
                btnRegistroProveedores.setEnabled(true);
                break;
            case "Vendedor":
                btnMantenimientoEmpleados.setEnabled(false);
                btnMantenimientoPedidos.setEnabled(true);
                btnMantenimientoProductos.setEnabled(true);
                btnMantenimientoProveedores.setEnabled(true);
                btnRegistroEmpleados.setEnabled(false);
                btnRegistroPedidos.setEnabled(true);
                btnRegistroProductos.setEnabled(true);
                btnRegistroProveedores.setEnabled(true);
                break;
            case "Cajero":
                btnMantenimientoEmpleados.setEnabled(false);
                btnMantenimientoPedidos.setEnabled(false);
                btnMantenimientoProductos.setEnabled(false);
                btnMantenimientoProveedores.setEnabled(false);
                btnRegistroEmpleados.setEnabled(false);
                btnRegistroPedidos.setEnabled(false);
                btnRegistroProductos.setEnabled(false);
                btnRegistroProveedores.setEnabled(false);
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

        btnRegistroProductos.setBackground(new java.awt.Color(221, 221, 221));
        btnRegistroProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistroProductos.setText("PRODUCTOS");
        btnRegistroProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroProductos.setEnabled(false);
        btnRegistroProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroProductosActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 140, 50));

        btnRegistroEmpleados.setBackground(new java.awt.Color(221, 221, 221));
        btnRegistroEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistroEmpleados.setText("EMPLEADOS");
        btnRegistroEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroEmpleados.setEnabled(false);
        btnRegistroEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroEmpleadosActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 140, 50));

        btnRegistroProveedores.setBackground(new java.awt.Color(221, 221, 221));
        btnRegistroProveedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistroProveedores.setText("PROVEEDORES");
        btnRegistroProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroProveedores.setEnabled(false);
        btnRegistroProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroProveedoresActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 140, 50));

        btnRegistroPedidos.setBackground(new java.awt.Color(221, 221, 221));
        btnRegistroPedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistroPedidos.setText("PEDIDOS");
        btnRegistroPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroPedidos.setEnabled(false);
        btnRegistroPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPedidosActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistroPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 140, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 160, 50));

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
        panelFondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 540, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANTENIMIENTO");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 220, 40));

        btnMantenimientoEmpleados.setBackground(new java.awt.Color(221, 221, 221));
        btnMantenimientoEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoEmpleados.setText("EMPLEADOS");
        btnMantenimientoEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimientoEmpleados.setEnabled(false);
        btnMantenimientoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoEmpleadosActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 140, 50));

        btnMantenimientoProductos.setBackground(new java.awt.Color(221, 221, 221));
        btnMantenimientoProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoProductos.setText("PRODUCTOS");
        btnMantenimientoProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimientoProductos.setEnabled(false);
        btnMantenimientoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoProductosActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 140, 50));

        btnMantenimientoProveedores.setBackground(new java.awt.Color(221, 221, 221));
        btnMantenimientoProveedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoProveedores.setText("PROVEEDORES");
        btnMantenimientoProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimientoProveedores.setEnabled(false);
        btnMantenimientoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoProveedoresActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 140, 50));

        btnMantenimientoPedidos.setBackground(new java.awt.Color(221, 221, 221));
        btnMantenimientoPedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoPedidos.setText("PEDIDOS");
        btnMantenimientoPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimientoPedidos.setEnabled(false);
        btnMantenimientoPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoPedidosActionPerformed(evt);
            }
        });
        panelFondo.add(btnMantenimientoPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 140, 50));

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
    
    public String textoHTML(String texto) {
        return "<html><div style='text-align: center; width: 100%;'>" + texto.replace("\n", "<br>") + "</div></html>";
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
