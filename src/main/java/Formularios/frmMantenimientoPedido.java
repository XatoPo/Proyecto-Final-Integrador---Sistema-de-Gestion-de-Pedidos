package Formularios;

import clases.*;
import controlador.NegocioMass;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import login.frmMenú;
import vistas.*;

public class frmMantenimientoPedido extends javax.swing.JFrame {
    
    private int mouseX, mouseY;
    NegocioMass mass = new NegocioMass();
    public static String id_emp;
    public static String id_prov;
    public static String id_produc;
    public static String id_ctg;
    List<detalle_pedido> list_detalle_pedido;
    
    public frmMantenimientoPedido() {
        initComponents();
          // Establecer el tamaño del JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        btnEliminarPedido.setEnabled(false);
        btnModificarEstado.setEnabled(false);
        cbEstado.setEnabled(false);
        tablaPedidos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if(Mouse_evt.getClickCount()==1){
                    String id_pedi = tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(),0).toString();
                    txtIdPedido.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(),0).toString());
                    empleado emp = mass.obtenerCodigoEmpleadoPorCodigoPedido(id_pedi);
                    txtIdEmp.setText(emp.getId_emp());
                    txtNomEmp.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(),4).toString());
                    String idPro = mass.obtenerCodigoProveedorPorCodigoPedido(id_pedi);
                    txtIdProv.setText(idPro);
                    txtNomProv.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(),3).toString());
                    txtFecha.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 1).toString());
                    txtHora.setText(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 2).toString());
                    cbEstado.setSelectedItem(tablaPedidos.getValueAt(row, 5).toString());
                    btnEliminarPedido.setEnabled(true);
                    btnModificarEstado.setEnabled(true);
                    cbEstado.setEnabled(true);
                }
            }
          
        });
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

                frmMantenimientoPedido.this.setLocation(x, y);
            }
        });

        // Agregar ComponentListener para gestionar cambios en el tamaño de la ventana
        this.addComponentListener(new ComponentAdapter() {
           
            public void componentResized(ComponentEvent e) {
                // Ajustar la escala de las imágenes al cambiar el tamaño de la ventana
                EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
                EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
                EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
                EscaladoImagenesButton(btnEliminarPedido, "src\\main\\java\\recursos\\eliminarpedido.png");
                EscaladoImagenesButton(btnModificarEstado, "src\\main\\java\\recursos\\modificapedido.png");
                
            }
        });
        
        muestraPedidos();
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
    
    public void muestraPedidos(){
        DefaultTableModel dt = (DefaultTableModel)tablaPedidos.getModel();
        dt.setRowCount(0);
        for(pedido pedi: mass.obtenerDatosPedidosParaLista()){
            Object f[] = {pedi.getId_pedi(), pedi.getFech_pedi(), pedi.getHora_pedi(), pedi.getNom_prov_pedi(), pedi.getNom_emp_pedi(), pedi.getEstado_pedi(), pedi.getTotal_precio_pedi()};
            dt.addRow(f);
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCodPedido = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        lblPedidosRegistrados = new javax.swing.JLabel();
        panelDatosPedido = new javax.swing.JPanel();
        lblNomEmp = new javax.swing.JLabel();
        lblIdEmp = new javax.swing.JLabel();
        lblIdProv = new javax.swing.JLabel();
        lblNomProv = new javax.swing.JLabel();
        txtIdProv = new javax.swing.JTextField();
        txtIdEmp = new javax.swing.JTextField();
        txtNomEmp = new javax.swing.JLabel();
        txtNomProv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        btnEliminarPedido = new javax.swing.JButton();
        btnModificarEstado = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo.setMinimumSize(new java.awt.Dimension(920, 1020));
        panelFondo.setPreferredSize(new java.awt.Dimension(920, 1020));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 50));

        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 40, 40));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("MANTENIMIENTO DE PEDIDO");
        panelFondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 290, 50));

        lblCodPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCodPedido.setText("Código de Pedido:");
        panelFondo.add(lblCodPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 40));

        txtIdPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIdPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelFondo.add(txtIdPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 120, 40));

        tablaPedidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "FECHA", "HORA", "PROOVEDOR", "EMPLEADO", "ESTADO", "PRECIO TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedidos);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 880, 160));

        lblPedidosRegistrados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPedidosRegistrados.setText("Pedidos Registrados:");
        panelFondo.add(lblPedidosRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 150, 40));

        panelDatosPedido.setBackground(new java.awt.Color(8, 77, 166));
        panelDatosPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomEmp.setForeground(new java.awt.Color(255, 255, 255));
        lblNomEmp.setText("Nombre Empleado:");
        panelDatosPedido.add(lblNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 140, 40));

        lblIdEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdEmp.setForeground(new java.awt.Color(255, 255, 255));
        lblIdEmp.setText("Código Empleado:");
        panelDatosPedido.add(lblIdEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 40));

        lblIdProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdProv.setForeground(new java.awt.Color(255, 255, 255));
        lblIdProv.setText("Código Proovedor:");
        panelDatosPedido.add(lblIdProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, 40));

        lblNomProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomProv.setForeground(new java.awt.Color(255, 255, 255));
        lblNomProv.setText("Nombre Proovedor:");
        panelDatosPedido.add(lblNomProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 140, 40));

        txtIdProv.setEditable(false);
        txtIdProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdProv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdProv.setFocusable(false);
        panelDatosPedido.add(txtIdProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, 40));

        txtIdEmp.setEditable(false);
        txtIdEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEmp.setFocusable(false);
        txtIdEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpActionPerformed(evt);
            }
        });
        panelDatosPedido.add(txtIdEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 150, 40));

        txtNomEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNomEmp.setForeground(new java.awt.Color(255, 255, 255));
        txtNomEmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelDatosPedido.add(txtNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 270, 40));

        txtNomProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNomProv.setForeground(new java.awt.Color(255, 255, 255));
        txtNomProv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelDatosPedido.add(txtNomProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 270, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha:");
        panelDatosPedido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 60, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hora:");
        panelDatosPedido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 70, 50));

        txtFecha.setEditable(false);
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setFocusable(false);
        panelDatosPedido.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 180, 40));

        txtHora.setEditable(false);
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setFocusable(false);
        panelDatosPedido.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 180, 40));

        txtEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(255, 255, 255));
        txtEstado.setText("Estado:");
        panelDatosPedido.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 120, 40));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Pendiente", "Terminado", "Cancelado" }));
        panelDatosPedido.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 200, 40));

        panelFondo.add(panelDatosPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 740, 350));

        btnEliminarPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarPedido.setText("ELIMINAR PEDIDO");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });
        panelFondo.add(btnEliminarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 700, 250, 40));

        btnModificarEstado.setText("MODIFICAR ESTADO DE PEDIDO");
        btnModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEstadoActionPerformed(evt);
            }
        });
        panelFondo.add(btnModificarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 700, 260, 40));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 760));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 761, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
        frmMenú menu = new frmMenú();
        menu.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    NegocioMass obj = new NegocioMass();
    
    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        String idPedido = txtIdPedido.getText();
        obj.eliminarPedido(idPedido);
        muestraPedidos();
        limpiar();
        btnEliminarPedido.setEnabled(false);
        btnModificarEstado.setEnabled(false);
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEstadoActionPerformed
        pedido p = new pedido();
        p.setId_pedi(txtIdPedido.getText());
        p.setFech_pedi(txtFecha.getText());
        p.setHora_pedi(txtHora.getText());
        p.setId_prov(txtIdProv.getText());
        p.setId_emp(txtIdEmp.getText());
        p.setEstado_pedi(cbEstado.getSelectedItem().toString());
        obj.editEstadoPedido(p);
        muestraPedidos();
        limpiar();
        cbEstado.setEnabled(false);
        btnEliminarPedido.setEnabled(false);
        btnModificarEstado.setEnabled(false);
    }//GEN-LAST:event_btnModificarEstadoActionPerformed

    private void txtIdEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpActionPerformed

    public void limpiar(){
        txtIdPedido.setText("");
        txtIdEmp.setText("");
        txtNomEmp.setText("");
        txtIdProv.setText("");
        txtNomProv.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        cbEstado.setSelectedIndex(0);
    }
    
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
            java.util.logging.Logger.getLogger(frmMantenimientoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenimientoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnModificarEstado;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblCodPedido;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIdEmp;
    private javax.swing.JLabel lblIdProv;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNomEmp;
    private javax.swing.JLabel lblNomProv;
    private javax.swing.JLabel lblPedidosRegistrados;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelDatosPedido;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtIdEmp;
    public static javax.swing.JLabel txtIdPedido;
    public static javax.swing.JTextField txtIdProv;
    public static javax.swing.JLabel txtNomEmp;
    public static javax.swing.JLabel txtNomProv;
    // End of variables declaration//GEN-END:variables
}
