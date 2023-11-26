package Formularios;

import clases.contacto;
import clases.proovedor;
import clases.ubigeo;
import controlador.NegocioMass;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import login.frmMenú;



public class frmMantenimientoProveedor extends javax.swing.JFrame {
    
    private int mouseX, mouseY;
    
    public frmMantenimientoProveedor() {
        initComponents();
        setSize(1047, 704);  // Establecer el tamaño del JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        
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

                frmMantenimientoProveedor.this.setLocation(x, y);
            }
        });
        
        EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
        EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
        EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
        EscaladoImagenesButton(btnModificarProovedor, "src\\main\\java\\recursos\\proveedor_(1).png");
        
        setLocationRelativeTo(null);
        
        llenarProveedores();
        muestraProv();
        bloquear2();
        bloquear();
    }
    
    List<proovedor> lista; 
    NegocioMass obj=new NegocioMass();
    void llenarProveedores(){
        lista = obj.lisProv();
        // Llenar el ComboBox con la lista de códigos de empleados        
        for (proovedor prov : lista) {
            cmbProveedor.addItem(prov.getId_prov());
        }
    }
    
    void muestraProv(){
        DefaultTableModel dt = (DefaultTableModel)tablap.getModel();
        dt.setRowCount(0);
        
        for(proovedor x : obj.lisProv()){
            Object v[]={x.getId_prov(),x.getNom_prov(),x.getDescd_prov(), 
            x.getDatos_ubigeo_prov().getId_ubigeo(), x.getDatos_contacto_prov().getId_contac()};
        dt.addRow(v);
        }
    }
    void llenarCamposProveedor(){
        String codProveedor = cmbProveedor.getSelectedItem().toString();
        proovedor p = obj.obtenerDatosProveedor(codProveedor);       
       
        txtnombreProveedor.setText(p.getNom_prov());
        txtdescripcionProv.setText(p.getDescd_prov());
        
        String tipoContacto = p.getDatos_contacto_prov().getTipo_contac();
        if(tipoContacto.equalsIgnoreCase("Gerente")){
            cmbTipoContactoEmp.setSelectedIndex(1);
        }else if(tipoContacto.equalsIgnoreCase("Ventas")){
            cmbTipoContactoEmp.setSelectedIndex(2);
        }
        else if(tipoContacto.equalsIgnoreCase("Atencion al Cliente")){
            cmbTipoContactoEmp.setSelectedIndex(3);
        }else{
            cmbTipoContactoEmp.setSelectedIndex(0);            
        }
        txtTelProv.setText(p.getDatos_contacto_prov().getTelef_contac());
        txtCorreoEmp.setText(p.getDatos_contacto_prov().getEmail_contac());
        txtDistEmp.setText(p.getDatos_ubigeo_prov().getDistrito_ubi());
        txtCalleEmp.setText(p.getDatos_ubigeo_prov().getCalle_avend_ubi());
        txtProvEmp.setText(p.getDatos_ubigeo_prov().getProvincia_ubi());
        txtNroCalleEmp.setText(String.valueOf(p.getDatos_ubigeo_prov().getNum_calle_ubi()));
        txtRefUbigeoEmp.setText(p.getDatos_ubigeo_prov().getReferencia_ubi());
    }
    public void limpiar(){
        txtnombreProveedor.setText("");     
        txtdescripcionProv.setText("");        
        
        cmbTipoContactoEmp.setSelectedIndex(0);
        txtTelProv.setText("");
        txtCorreoEmp.setText("");

        txtDistEmp.setText("");
        txtProvEmp.setText("");
        txtCalleEmp.setText("");
        txtNroCalleEmp.setText("");
        txtRefUbigeoEmp.setText("");
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombreProveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JPDireccion = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCalleEmp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNroCalleEmp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRefUbigeoEmp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtProvEmp = new javax.swing.JTextField();
        txtDistEmp = new javax.swing.JTextField();
        JPTelefono = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbTipoContactoEmp = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTelProv = new javax.swing.JTextField();
        txtCorreoEmp = new javax.swing.JTextField();
        btnModificarProovedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcionProv = new javax.swing.JTextArea();
        CBmasTelefono = new javax.swing.JCheckBox();
        CBmasUbigeo = new javax.swing.JCheckBox();
        lblLogo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablap = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        btnEliminarProovedor = new javax.swing.JButton();
        lblCerrar = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(1047, 704));
        setMinimumSize(new java.awt.Dimension(1047, 704));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setPreferredSize(new java.awt.Dimension(1047, 704));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel1.setText("Registro de Proveedor");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 15, -1, 38));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Proveedor");
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 63, -1, -1));

        txtnombreProveedor.addKeyListener(new KeyListener() {
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
        panelFondo.add(txtnombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 99, 467, 30));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel4.setText("Descripción");
        panelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 135, -1, -1));

        JPDireccion.setBackground(new java.awt.Color(204, 204, 255));
        JPDireccion.setEnabled(false);
        JPDireccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel9.setText("Calle / Avenida");
        JPDireccion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 64, -1, -1));

        txtCalleEmp.addKeyListener(new KeyListener() {
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
        JPDireccion.add(txtCalleEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 86, 250, 30));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel10.setText("Número");
        JPDireccion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 64, -1, -1));

        txtNroCalleEmp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtNroCalleEmp.getText().length() >= 5) {
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
        JPDireccion.add(txtNroCalleEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 86, 92, 30));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel11.setText("Referencia");
        JPDireccion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 128, -1, -1));
        JPDireccion.add(txtRefUbigeoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 150, 417, 30));

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel16.setText("Provincia");
        JPDireccion.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, -1, -1));

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel17.setText("Distrito");
        JPDireccion.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 6, -1, -1));

        txtProvEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvEmpActionPerformed(evt);
            }
        });
        txtProvEmp.addKeyListener(new KeyListener() {
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
        JPDireccion.add(txtProvEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 28, 180, 30));

        txtDistEmp.addKeyListener(new KeyListener() {
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
        JPDireccion.add(txtDistEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 28, 180, 30));

        panelFondo.add(JPDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 275, 459, 191));

        JPTelefono.setBackground(new java.awt.Color(204, 204, 255));
        JPTelefono.setDoubleBuffered(false);
        JPTelefono.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel14.setText("Tipo de Contacto");

        cmbTipoContactoEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----SELECCIONAR-----", "Gerente", "Ventas", "Atencion al Cliente", " " }));

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel15.setText("Correo Electronico");

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel18.setText("Telefono");

        txtTelProv.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtTelProv.getText().length() >= 9) {
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
                                .addComponent(cmbTipoContactoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtTelProv, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                            .addComponent(txtCorreoEmp))))
                .addContainerGap(22, Short.MAX_VALUE))
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
                    .addComponent(cmbTipoContactoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        panelFondo.add(JPTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 508, -1, -1));

        btnModificarProovedor.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        btnModificarProovedor.setText("MODIFICAR");
        btnModificarProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProovedorActionPerformed(evt);
            }
        });
        panelFondo.add(btnModificarProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 659, 191, 39));

        txtdescripcionProv.setColumns(20);
        txtdescripcionProv.setRows(5);
        txtdescripcionProv.addKeyListener(new KeyListener() {
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
        jScrollPane1.setViewportView(txtdescripcionProv);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 160, 467, 73));

        CBmasTelefono.setText("Agregar Información de Contacto");
        CBmasTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBmasTelefonoMouseClicked(evt);
            }
        });
        panelFondo.add(CBmasTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 472, -1, 30));

        CBmasUbigeo.setText("Agregar Infornación de Ubigeo");
        CBmasUbigeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBmasUbigeoMouseClicked(evt);
            }
        });
        panelFondo.add(CBmasUbigeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 239, -1, 30));
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 6, 108, 39));

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

        panelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 114, 500, 542));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel2.setText("Codigos de Proveedores");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 64, -1, -1));

        cmbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedorActionPerformed(evt);
            }
        });
        panelFondo.add(cmbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 63, 185, 30));

        btnEliminarProovedor.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        btnEliminarProovedor.setText("ELIMINAR");
        btnEliminarProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProovedorActionPerformed(evt);
            }
        });
        panelFondo.add(btnEliminarProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 659, 191, 39));

        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 35, 34));

        lblFondo.setMaximumSize(new java.awt.Dimension(1047, 704));
        lblFondo.setMinimumSize(new java.awt.Dimension(1047, 704));
        lblFondo.setName(""); // NOI18N
        lblFondo.setPreferredSize(new java.awt.Dimension(1047, 704));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1047, 704));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1047, 704));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBmasTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBmasTelefonoMouseClicked
        if(CBmasTelefono.isSelected()){
            desbloquear2();
        }else{
            bloquear2();
        }
    }//GEN-LAST:event_CBmasTelefonoMouseClicked

    private void CBmasUbigeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBmasUbigeoMouseClicked
        if(CBmasUbigeo.isSelected()){
            desbloquear();
        }else{
            txtCalleEmp.setText("");
            txtRefUbigeoEmp.setText("");
            txtNroCalleEmp.setText("");
            bloquear();
        }
    }//GEN-LAST:event_CBmasUbigeoMouseClicked

    private void txtProvEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvEmpActionPerformed

    private void btnModificarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProovedorActionPerformed
        proovedor p = new proovedor();
        p.setId_prov(cmbProveedor.getSelectedItem().toString());
        p.setNom_prov(txtnombreProveedor.getText());
        p.setDescd_prov(txtdescripcionProv.getText());
        // Agregar empleado
        obj.editProveedor(p);

        //Registrar datos de contacto de empleado con if para que pueda ser NULL
        if (CBmasTelefono.isSelected()) {
            String codProveedor = cmbProveedor.getSelectedItem().toString();
            proovedor pc = obj.obtenerDatosProveedor(codProveedor); 
            // Llamada al método de la clase de negocios para obtener el último id_emp
            contacto c = new contacto();
            // Asignar valores a las propiedades del objeto contacto
            c.setId_contac(pc.getDatos_contacto_prov().getId_contac());
            c.setTipo_contac(cmbTipoContactoEmp.getSelectedItem().toString());
            c.setTelef_contac(txtTelProv.getText());
            c.setEmail_contac(txtCorreoEmp.getText());

            // Asignar el objeto contacto al proveedor
            p.setDatos_contacto_prov(c);

            // Agregar contacto asociado al id_prov
            obj.modificarContacto(c);
        }
        
        //Registrar datos de ubigeo de empleado con if para que pueda ser NULL
        if (CBmasUbigeo.isSelected()) {
            String codProveedor = cmbProveedor.getSelectedItem().toString();
            proovedor pu = obj.obtenerDatosProveedor(codProveedor); 
            ubigeo u = new ubigeo();
            // Asignar valores a las propiedades del objeto ubigeo
            u.setId_ubigeo(pu.getDatos_ubigeo_prov().getId_ubigeo());
            u.setDistrito_ubi(txtDistEmp.getText());
            u.setProvincia_ubi(txtProvEmp.getText());
            u.setCalle_avend_ubi(txtCalleEmp.getText());
            u.setNum_calle_ubi(Integer.parseInt(txtNroCalleEmp.getText()));
            u.setReferencia_ubi(txtRefUbigeoEmp.getText());

            // Asignar el objeto ubigeo al proveedor
            p.setDatos_ubigeo_prov(u);

            // Agregar ubigeo asociado al id_prov
            obj.modificarUbigeo(u);
        }
        
        muestraProv();//Actualizar datos de la tabla empleado
        
        limpiar();
    }//GEN-LAST:event_btnModificarProovedorActionPerformed

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
        llenarCamposProveedor();
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void btnEliminarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProovedorActionPerformed
        String codProveedor = cmbProveedor.getSelectedItem().toString();
        obj.eliminarProveedor(codProveedor);
        cmbProveedor.removeItem(codProveedor);
        muestraProv();//Actualizar datos de la tabla empleado
        limpiar();
    }//GEN-LAST:event_btnEliminarProovedorActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
        frmMenú menu = new frmMenú();
        menu.setVisible(true); 
    }//GEN-LAST:event_lblCerrarMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenimientoProveedor().setVisible(true);
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
    private javax.swing.JButton btnEliminarProovedor;
    private javax.swing.JButton btnModificarProovedor;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JComboBox<String> cmbTipoContactoEmp;
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
    private javax.swing.JTextField txtCalleEmp;
    private javax.swing.JTextField txtCorreoEmp;
    private javax.swing.JTextField txtDistEmp;
    private javax.swing.JTextField txtNroCalleEmp;
    private javax.swing.JTextField txtProvEmp;
    private javax.swing.JTextField txtRefUbigeoEmp;
    private javax.swing.JTextField txtTelProv;
    private javax.swing.JTextArea txtdescripcionProv;
    private javax.swing.JTextField txtnombreProveedor;
    // End of variables declaration//GEN-END:variables
}
