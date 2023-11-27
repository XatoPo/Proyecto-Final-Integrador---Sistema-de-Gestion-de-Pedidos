package Formularios;

import clases.contacto;
import clases.proovedor;
import clases.ubigeo;
import controlador.NegocioMass;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import login.frmMenú;



public class frmProveedor extends javax.swing.JFrame {
    
    public frmProveedor() {
        initComponents();
        setLocationRelativeTo(null);
        EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
        EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
        EscaladoImagenesButton(btnGrabarProovedor, "src\\main\\java\\recursos\\proveedor_(1).png");
        EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
        muestraProv();
        bloquear2();
        bloquear();
    }
    List<proovedor> lista; 
    NegocioMass obj=new NegocioMass();
    
    void muestraProv(){
        DefaultTableModel dt = (DefaultTableModel)tablap.getModel();
        dt.setRowCount(0);
        
        for(proovedor x : obj.lisProv()){
            Object v[]={x.getId_prov(),x.getNom_prov(),x.getDescd_prov(), 
            x.getDatos_ubigeo_prov().getId_ubigeo(), x.getDatos_contacto_prov().getId_contac()};
        dt.addRow(v);
        }
    }
    public void limpiar(){
        txtnombre.setText("");     
        txtdescripcion.setText("");        
        
        cmbtipo.setSelectedIndex(0);
        txttelefono.setText("");
        txtcorreo.setText("");

        txtdistrito.setText("");
        txtprovincia.setText("");
        txtcalle.setText("");
        txtcallenumero.setText("");
        txtreferencia.setText("");
        
        //  Desmarcar los checkboxes
        CBmasTelefono.setSelected(false);  
        CBmasUbigeo.setSelected(false); 
        bloquear();
        bloquear2();
    }
    
    public void desbloquear(){
        for(Component a: JPDireccion.getComponents()){
            a.setEnabled(true);
        }
    }
    
    public void bloquear(){
        for(Component a: JPDireccion.getComponents()){
            a.setEnabled(false);            
        }
    }
    
    public void desbloquear2(){
        for(Component a: JPTelefono.getComponents()){
            a.setEnabled(true);
        }
    }
    
    public void bloquear2(){
        for(Component a: JPTelefono.getComponents()){
            a.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablap = new javax.swing.JTable();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        CBmasUbigeo = new javax.swing.JCheckBox();
        JPDireccion = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcallenumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtprovincia = new javax.swing.JTextField();
        txtdistrito = new javax.swing.JTextField();
        CBmasTelefono = new javax.swing.JCheckBox();
        JPTelefono = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        btnGrabarProovedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setUndecorated(true);
        setResizable(false);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 40, 40));

        tablap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Nombre", "Descripción", "ID Ubigeo", "ID Contacto"
            }
        ));
        jScrollPane2.setViewportView(tablap);

        panelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 97, 507, 530));
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 15, 108, 39));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel1.setText("Registro de Proveedor");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, 38));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Proveedor");
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 56, -1, -1));

        txtnombre.addKeyListener(new KeyListener() {
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
        panelFondo.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 78, 455, 30));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel4.setText("Descripción");
        panelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 114, -1, -1));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        txtdescripcion.addKeyListener(new KeyListener() {
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
        jScrollPane1.setViewportView(txtdescripcion);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 136, 455, 73));

        CBmasUbigeo.setBackground(new java.awt.Color(255, 255, 255));
        CBmasUbigeo.setText("Agregar Infornación de Ubigeo");
        CBmasUbigeo.setContentAreaFilled(false);
        CBmasUbigeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBmasUbigeoMouseClicked(evt);
            }
        });
        panelFondo.add(CBmasUbigeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 215, 207, 30));

        JPDireccion.setBackground(new java.awt.Color(8, 77, 166));
        JPDireccion.setEnabled(false);
        JPDireccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Calle / Avenida");
        JPDireccion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 64, -1, -1));

        txtcalle.addKeyListener(new KeyListener() {
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
        JPDireccion.add(txtcalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 86, 250, 30));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Número");
        JPDireccion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 64, -1, -1));

        txtcallenumero.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtcallenumero.getText().length() >= 5) {
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
        JPDireccion.add(txtcallenumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 86, 92, 30));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Referencia");
        JPDireccion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 128, -1, -1));
        JPDireccion.add(txtreferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 150, 417, 30));

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Provincia");
        JPDireccion.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, -1, -1));

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Distrito");
        JPDireccion.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 6, -1, -1));

        txtprovincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprovinciaActionPerformed(evt);
            }
        });
        txtprovincia.addKeyListener(new KeyListener() {
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
        JPDireccion.add(txtprovincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 28, 180, 30));

        txtdistrito.addKeyListener(new KeyListener() {
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
        JPDireccion.add(txtdistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 28, 180, 30));

        panelFondo.add(JPDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 251, 455, 191));

        CBmasTelefono.setText("Agregar Información de Contacto");
        CBmasTelefono.setContentAreaFilled(false);
        CBmasTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBmasTelefonoMouseClicked(evt);
            }
        });
        panelFondo.add(CBmasTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 448, 218, 30));

        JPTelefono.setBackground(new java.awt.Color(8, 77, 166));
        JPTelefono.setDoubleBuffered(false);
        JPTelefono.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tipo de Contacto");

        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----SELECCIONAR-----", "Gerente", "Ventas", "Atencion al Cliente" }));

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Correo Electronico");

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Telefono");

        txttelefono.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txttelefono.getText().length() >= 9) {
                    e.consume(); // Ignora la entrada si no es un dígito o si ya hay 9 dígitos
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

        javax.swing.GroupLayout JPTelefonoLayout = new javax.swing.GroupLayout(JPTelefono);
        JPTelefono.setLayout(JPTelefonoLayout);
        JPTelefonoLayout.setHorizontalGroup(
            JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTelefonoLayout.createSequentialGroup()
                .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTelefonoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel18))
                    .addGroup(JPTelefonoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addGroup(JPTelefonoLayout.createSequentialGroup()
                                .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                            .addComponent(txtcorreo))))
                .addGap(18, 18, 18))
        );
        JPTelefonoLayout.setVerticalGroup(
            JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTelefonoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addGap(2, 2, 2)
                .addGroup(JPTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        panelFondo.add(JPTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 484, -1, -1));

        btnGrabarProovedor.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        btnGrabarProovedor.setText("Agregar Proveedor");
        btnGrabarProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarProovedorActionPerformed(evt);
            }
        });
        panelFondo.add(btnGrabarProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 639, 255, 39));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel2.setText("Proveedores registrados:");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 180, 30));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
        frmMenú menu = new frmMenú();
        menu.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void CBmasUbigeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBmasUbigeoMouseClicked
        if(CBmasUbigeo.isSelected()){
            desbloquear();
        }else{
            txtcalle.setText("");
            txtreferencia.setText("");
            txtcallenumero.setText("");
            bloquear();
        }
    }//GEN-LAST:event_CBmasUbigeoMouseClicked

    private void txtprovinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprovinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprovinciaActionPerformed

    private void CBmasTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBmasTelefonoMouseClicked
        if(CBmasTelefono.isSelected()){
            desbloquear2();
        }else{
            bloquear2();
        }
    }//GEN-LAST:event_CBmasTelefonoMouseClicked

    private void btnGrabarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarProovedorActionPerformed
        proovedor p = new proovedor();
        p.setNom_prov(txtnombre.getText());
        p.setDescd_prov(txtdescripcion.getText());
        // Agregar empleado
        obj.adiProveedor(p);

        //Registrar datos de contacto de empleado con if para que pueda ser NULL
        if (CBmasTelefono.isSelected()) {

            // Llamada al método de la clase de negocios para obtener el último id_emp
            contacto c = new contacto();
            // Asignar valores a las propiedades del objeto contacto
            c.setTipo_contac(cmbtipo.getSelectedItem().toString());
            c.setTelef_contac(txttelefono.getText());
            c.setEmail_contac(txtcorreo.getText());

            // Asignar el objeto contacto al proveedor
            p.setDatos_contacto_prov(c);

            // Agregar contacto asociado al id_prov
            obj.adiContactoProv(c);
        }

        //Registrar datos de ubigeo de empleado con if para que pueda ser NULL
        if (CBmasUbigeo.isSelected()) {
            ubigeo u = new ubigeo();
            // Asignar valores a las propiedades del objeto ubigeo
            u.setDistrito_ubi(txtdistrito.getText());
            u.setProvincia_ubi(txtprovincia.getText());
            u.setCalle_avend_ubi(txtcalle.getText());
            u.setNum_calle_ubi(Integer.parseInt(txtcallenumero.getText()));
            u.setReferencia_ubi(txtreferencia.getText());

            // Asignar el objeto ubigeo al proveedor
            p.setDatos_ubigeo_prov(u);

            // Agregar ubigeo asociado al id_prov
            obj.adiUbigeoProv(u);
        }

        muestraProv();//Actualizar datos de la tabla empleado

        limpiar();
    }//GEN-LAST:event_btnGrabarProovedorActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProveedor().setVisible(true);
            }
        });
    }
    
    private void EscaladoImagenesLabel(JLabel labelFondo, String ruta){
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
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
    private javax.swing.JCheckBox CBmasTelefono;
    private javax.swing.JCheckBox CBmasUbigeo;
    private javax.swing.JPanel JPDireccion;
    private javax.swing.JPanel JPTelefono;
    private javax.swing.JButton btnGrabarProovedor;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tablap;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtcallenumero;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtdistrito;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprovincia;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
