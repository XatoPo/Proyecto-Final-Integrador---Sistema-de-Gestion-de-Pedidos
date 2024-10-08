package Formularios;

import static Formularios.frmPedido.id_produc;
import clases.producto;
import controlador.NegocioMass;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import login.frmMenú;
import vistas.vistaRapidaMarcas2;


public class frmMantenimientoProducto extends javax.swing.JFrame {
    NegocioMass mass = new NegocioMass();
    private int mouseX, mouseY;
    
    public frmMantenimientoProducto() {
        initComponents();
        muestra();
        setResizable(false);
        setLocationRelativeTo(null);
        bloquear();
        tbProductos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if(Mouse_evt.getClickCount()==1){
                    txtIdProducto.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(),0).toString());
                    txtNombreProducto.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(),1).toString());
                    txtMarcaPro.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(),2).toString());
                    txtPrecioEmpaque.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(),3).toString());
                    txtCantidadEmpaque.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(),4).toString());
                    String idCategoria = tbProductos.getValueAt(row,5).toString();
                    cbTipoEmpaque.setSelectedItem(tbProductos.getValueAt(row, 6).toString());
                    seleccionarCategoriaEnComboBox(idCategoria);
                    desbloquear();
                }
            }
            
            private void seleccionarCategoriaEnComboBox(String idCategoria) {
                String nombreCategoria = obtenerNombreCategoriaDesdeId(idCategoria);
                cbNombreCategoria.setSelectedItem(nombreCategoria);
            }

            private String obtenerNombreCategoriaDesdeId(String idCategoria) {
                switch (idCategoria) {
                    case "CTG01":
                        return "Bebidas";
                    case "CTG02":
                        return "Panadería";
                    case "CTG03":
                        return "Snacks";
                    case "CTG04":
                        return "Lácteos";
                    case "CTG05":
                        return "Limpieza";
                    case "CTG06":
                        return "Frutas y Verduras";
                    case "CTG07":
                        return "Carnes y Aves";
                    case "CTG08":
                        return "Congelados";
                    case "CTG09":
                        return "Cuidado Personal";
                    default:
                        return null;
                }
            }
        });
        
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

                frmMantenimientoProducto.this.setLocation(x, y);
            }
        });
        
        this.addComponentListener(new ComponentAdapter() {
            
            public void componentResized(ComponentEvent e) {
                // Ajustar la escala de las imágenes al cambiar el tamaño de la ventana
                EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
                EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
                EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
                EscaladoImagenesButton(btnAyudaMarca, "src\\main\\java\\recursos\\lupa.png");
                EscaladoImagenesButton(btnEliminaProducto, "src\\main\\java\\recursos\\quitar_producto.png");
                EscaladoImagenesButton(btnModificaProducto, "src\\main\\java\\recursos\\modificaproducto.png");
                EscaladoImagenesButton(btnEliminaProducto, "src\\main\\java\\recursos\\quitar_producto.png");
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
    
    NegocioMass obj = new NegocioMass();
    
    void muestra(){
        DefaultTableModel dt = (DefaultTableModel)tbProductos.getModel();
        dt.setRowCount(0);
        
        for(producto x : obj.obtenerProductos()){
            Object p[]={x.getId_produc(),x.getNom_produc(),x.getMarca_produc(),
                x.getPrecio_empaq_produc(), x.getCant_x_empaq_produc(), x.getId_ctg(),
                x.getTipo_empq_produc()};
        dt.addRow(p);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnModificaProducto = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioEmpaque = new javax.swing.JTextField();
        txtMarcaPro = new javax.swing.JTextField();
        txtCantidadEmpaque = new javax.swing.JTextField();
        cbNombreCategoria = new javax.swing.JComboBox<>();
        btnAyudaMarca = new javax.swing.JButton();
        btnEliminaProducto = new javax.swing.JButton();
        cbTipoEmpaque = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        lblCerrar = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO DE PRODUCTO");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 310, 50));
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 50));

        jPanel1.setBackground(new java.awt.Color(8, 77, 166));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 40));

        txtIdProducto.setEditable(false);
        txtIdProducto.setFocusable(false);
        jPanel1.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 150, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre del producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Marca del producto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 150, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio del empaque:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad por empaquetado:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre de categoría:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tipo de empaquetado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 180, 40));

        btnModificaProducto.setText("MODIFICAR PRODUCTO");
        btnModificaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 230, 40));

        txtNombreProducto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || c == ' ')) {
                    e.consume(); // Ignora la entrada si no es una letra o un espacio
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // No es necesario implementar esto, pero debe estar presente debido a la interfaz KeyListener
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar esto, pero debe estar presente debido a la interfaz KeyListener
            }
        });
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 240, 40));

        txtPrecioEmpaque.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Verifica si es un dígito
                if (Character.isDigit(c)) {
                    // Verifica si ya hay 10 dígitos
                    if (txtPrecioEmpaque.getText().length() >= 10) {
                        e.consume(); // Ignora la entrada si ya hay 10 dígitos
                    }
                } else if (c == '.') {
                    // Verifica si ya hay un punto
                    if (txtPrecioEmpaque.getText().contains(".")) {
                        e.consume(); // Ignora la entrada si ya hay un punto
                    }
                } else {
                    e.consume(); // Ignora la entrada si no es un dígito ni un punto
                }
            }
        });
        jPanel1.add(txtPrecioEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 240, 40));

        txtMarcaPro.setEditable(false);
        txtMarcaPro.setFocusable(false);
        txtMarcaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaProActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarcaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 250, 40));

        txtCantidadEmpaque.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtCantidadEmpaque.getText().length() >= 5) {
                    e.consume(); // Ignora la entrada si no es un dígito o si ya hay 5 dígitos
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // No es necesario implementar esto, pero debe estar presente debido a la interfaz KeyListener
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar esto, pero debe estar presente debido a la interfaz KeyListener
            }
        });
        jPanel1.add(txtCantidadEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 220, 40));

        cbNombreCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Bebidas", "Panadería", "Snacks", "Lácteos", "Limpieza", "Frutas y verduras", "Carnes y aves", "Congelados", "Cuidado personal" }));
        cbNombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(cbNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 240, 40));

        btnAyudaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAyudaMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 40, 40));

        btnEliminaProducto.setText("ELIMINAR PRODUCTO");
        btnEliminaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 220, 40));

        cbTipoEmpaque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Palet", "Caja", "Pack", "Cesta", "Paquete" }));
        jPanel1.add(cbTipoEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 240, 40));

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 910, 340));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Productos registrados:");
        panelFondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 190, 40));

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID del producto", "Nombre", "Marca", "Precio", "Cantidad por empaquetado", "ID de categoría", "Tipo de empaquetado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 910, 340));

        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 40, 40));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 820));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaProductoActionPerformed
        producto pro = new producto();
        pro.setId_produc(txtIdProducto.getText());
        pro.setNom_produc(txtNombreProducto.getText());
        pro.setMarca_produc(txtMarcaPro.getText());
        pro.setPrecio_empaq_produc(Double.parseDouble(txtPrecioEmpaque.getText()));
        pro.setCant_x_empaq_produc(Integer.parseInt(txtCantidadEmpaque.getText()));
        pro.setNom_ctg(cbNombreCategoria.getSelectedItem().toString());
        pro.setId_ctg(obj.ObtenerCategoriaID(cbNombreCategoria.getSelectedItem().toString()));
        pro.setTipo_empq_produc(cbTipoEmpaque.getSelectedItem().toString());
        obj.editProducto(pro);
        muestra();
        limpiar();
    }//GEN-LAST:event_btnModificaProductoActionPerformed
    
    private void btnAyudaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaMarcaActionPerformed
        vistaRapidaMarcas2.id_produc = id_produc;
        vistaRapidaMarcas2 p = new vistaRapidaMarcas2();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }//GEN-LAST:event_btnAyudaMarcaActionPerformed

    private void btnEliminaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaProductoActionPerformed
        String idProducto = txtIdProducto.getText();
        obj.eliminarProducto(idProducto);
        muestra();
        limpiar();
        bloquear();
    }//GEN-LAST:event_btnEliminaProductoActionPerformed

    public void limpiar(){
        txtIdProducto.setText("");
        txtNombreProducto.setText("");
        txtNombreProducto.setText("");
        txtMarcaPro.setText("");
        txtPrecioEmpaque.setText("");
        txtCantidadEmpaque.setText("");
        cbNombreCategoria.setSelectedIndex(0);
        cbTipoEmpaque.setSelectedIndex(0);
    }
    
    public void bloquear(){
      for(Component a: jPanel1.getComponents()){
            a.setEnabled(false);            
      }
    }
    
    public void desbloquear(){
        for(Component a: jPanel1.getComponents()){
            a.setEnabled(true);
        }
    }
    
    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
        frmMenú menu = new frmMenú();
        menu.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void cbNombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNombreCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNombreCategoriaActionPerformed

    private void txtMarcaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaProActionPerformed

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
            java.util.logging.Logger.getLogger(frmMantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenimientoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyudaMarca;
    private javax.swing.JButton btnEliminaProducto;
    private javax.swing.JButton btnModificaProducto;
    private javax.swing.JComboBox<String> cbNombreCategoria;
    private javax.swing.JComboBox<String> cbTipoEmpaque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtCantidadEmpaque;
    private javax.swing.JTextField txtIdProducto;
    public static javax.swing.JTextField txtMarcaPro;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioEmpaque;
    // End of variables declaration//GEN-END:variables
}
