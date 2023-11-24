// COMENTARIO 
package Formularios;

import clases.*;
import controlador.*;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class frmEmpleado extends javax.swing.JFrame {
    private int mouseX, mouseY;

    public frmEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
        EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
        EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
        EscaladoImagenesButton(btnGabarEmpleado, "src\\main\\java\\recursos\\AgregarEmpleado_(2).png");
        EscaladoImagenesButton(btnNuevoEmp, "src\\main\\java\\recursos\\limpieza-de-datos_(1).png");
        muestra();
        bloquear();
        bloquear2();
        setResizable(false);
        setLocationRelativeTo(null);
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

                frmEmpleado.this.setLocation(x, y);
            }
        });
    }
    List<empleado> lista; 
    
    NegocioMass obj=new NegocioMass();

    void muestra(){
        DefaultTableModel dt = (DefaultTableModel)tablaEmp.getModel();
        dt.setRowCount(0);
        
        for(empleado x : obj.lisEmp()){
            Object v[]={x.getId_emp(),x.getNom_pat_emp(),x.getApe_pat_emp(),
                x.getApe_mat_emp(), x.getCargo_emp(), x.getFech_nac_emp()};

        dt.addRow(v);
        }
    }
    
        public void bloquear(){
        for(Component a: jPanelContactoEmp.getComponents()){
            a.setEnabled(false);            
        }
    }
    
    public void desbloquear(){
        for(Component a: jPanelContactoEmp.getComponents()){
            a.setEnabled(true);
        }
    }


    public void bloquear2(){
        for(Component a: jPanelUbigeoEmp.getComponents()){
            a.setEnabled(false);
        }
    }
    
    public void desbloquear2(){
        for(Component a: jPanelUbigeoEmp.getComponents()){
            a.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGabarEmpleado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        dcFechaNacEmp = new com.toedter.calendar.JDateChooser();
        txtPrimerNomEmp = new javax.swing.JTextField();
        txtSegNombEmp = new javax.swing.JTextField();
        txtPrimerApeEmp = new javax.swing.JTextField();
        txtSegApeEmp = new javax.swing.JTextField();
        cmbCargoEmp = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPasswordEmp = new javax.swing.JPasswordField();
        cbActivaContactoEmp = new javax.swing.JCheckBox();
        jPanelContactoEmp = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtTelEmp = new javax.swing.JTextField();
        cmbTipoContactoEmp = new javax.swing.JComboBox<>();
        txtCorreoEmp = new javax.swing.JTextField();
        cbActivaUbigeoEmp = new javax.swing.JCheckBox();
        btnNuevoEmp = new javax.swing.JButton();
        jPanelUbigeoEmp = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRefUbigeoEmp = new javax.swing.JTextField();
        txtDistEmp = new javax.swing.JTextField();
        txtProvEmp = new javax.swing.JTextField();
        txtCalleEmp = new javax.swing.JTextField();
        txtNroCalleEmp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRO EMPLEADO");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        btnGabarEmpleado.setText("GRABAR");
        btnGabarEmpleado.setToolTipText("");
        btnGabarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGabarEmpleadoActionPerformed(evt);
            }
        });
        panelFondo.add(btnGabarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, -1, -1));

        jLabel3.setText("Primer Nombre");
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setText("Segundo Nombre");
        panelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel5.setText("Primer Apellido");
        panelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel6.setText("Segundo Apellido");
        panelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel7.setText("Cargo");
        panelFondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 40));
        panelFondo.add(dcFechaNacEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 150, -1));

        txtPrimerNomEmp.addKeyListener(new KeyListener() {
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
        panelFondo.add(txtPrimerNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, -1));

        txtSegNombEmp.addKeyListener(new KeyListener() {
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
        panelFondo.add(txtSegNombEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 150, -1));

        txtPrimerApeEmp.addKeyListener(new KeyListener() {
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
        panelFondo.add(txtPrimerApeEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 150, -1));

        txtSegApeEmp.addKeyListener(new KeyListener() {
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
        panelFondo.add(txtSegApeEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, -1));

        cmbCargoEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Vendedor", "Reponedor", "Cajero" }));
        panelFondo.add(cmbCargoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 150, -1));

        jLabel10.setText("Fecha de Nacimiento");
        panelFondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jLabel11.setText("Contraseña");
        panelFondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        panelFondo.add(txtPasswordEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 150, -1));

        cbActivaContactoEmp.setText("Agregar Informacion de Contacto");
        cbActivaContactoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbActivaContactoEmpMouseClicked(evt);
            }
        });
        cbActivaContactoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivaContactoEmpActionPerformed(evt);
            }
        });
        panelFondo.add(cbActivaContactoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        jPanelContactoEmp.setBackground(new java.awt.Color(255, 255, 204));

        jLabel51.setText("Tipo");

        jLabel52.setText("Telefono");

        jLabel53.setText("Correo");

        txtTelEmp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtTelEmp.getText().length() >= 9) {
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

        cmbTipoContactoEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Personal", "Casa", "Contacto de Emergencia" }));

        javax.swing.GroupLayout jPanelContactoEmpLayout = new javax.swing.GroupLayout(jPanelContactoEmp);
        jPanelContactoEmp.setLayout(jPanelContactoEmpLayout);
        jPanelContactoEmpLayout.setHorizontalGroup(
            jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                        .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoContactoEmp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCorreoEmp)
                    .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelContactoEmpLayout.setVerticalGroup(
            jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContactoEmpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel52)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoContactoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelFondo.add(jPanelContactoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        cbActivaUbigeoEmp.setText("Agregar Informacion de Ubigeo");
        cbActivaUbigeoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbActivaUbigeoEmpMouseClicked(evt);
            }
        });
        panelFondo.add(cbActivaUbigeoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        btnNuevoEmp.setText("NUEVO");
        btnNuevoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpActionPerformed(evt);
            }
        });
        panelFondo.add(btnNuevoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, -1, -1));

        jPanelUbigeoEmp.setBackground(new java.awt.Color(255, 255, 204));

        jLabel12.setText("Distrito");

        jLabel13.setText("Provincia");

        jLabel14.setText("Calle/Avenida");

        jLabel15.setText("Nro Calle");

        jLabel16.setText("Referencia");

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

        javax.swing.GroupLayout jPanelUbigeoEmpLayout = new javax.swing.GroupLayout(jPanelUbigeoEmp);
        jPanelUbigeoEmp.setLayout(jPanelUbigeoEmpLayout);
        jPanelUbigeoEmpLayout.setHorizontalGroup(
            jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbigeoEmpLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUbigeoEmpLayout.createSequentialGroup()
                        .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProvEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtRefUbigeoEmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelUbigeoEmpLayout.createSequentialGroup()
                            .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDistEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCalleEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNroCalleEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUbigeoEmpLayout.setVerticalGroup(
            jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbigeoEmpLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDistEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProvEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUbigeoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalleEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroCalleEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRefUbigeoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panelFondo.add(jPanelUbigeoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, -1));

        tablaEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Emp", "Nombre", "Apellido Pat", "Apellido Mat", "Cargo", "Fec Nacimiento"
            }
        ));
        jScrollPane1.setViewportView(tablaEmp);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, 630, 180));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Empleados registrados:");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 200, 30));

        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 40, 40));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpActionPerformed

        dcFechaNacEmp.setDate(null);
        txtPrimerNomEmp.setText("");
        txtSegNombEmp.setText("");
        txtPrimerApeEmp.setText("");
        txtSegApeEmp.setText("");
        cmbCargoEmp.setSelectedIndex(0);
        txtPasswordEmp.setText("");

        cmbTipoContactoEmp.setSelectedIndex(0);
        txtTelEmp.setText("");
        txtCorreoEmp.setText("");

        txtDistEmp.setText("");
        txtProvEmp.setText("");
        txtCalleEmp.setText("");
        txtNroCalleEmp.setText("");
        txtRefUbigeoEmp.setText("");

        //  Desmarcar los checkboxes
        cbActivaContactoEmp.setSelected(false);
        cbActivaUbigeoEmp.setSelected(false);
        bloquear();
        bloquear2();
    }//GEN-LAST:event_btnNuevoEmpActionPerformed

    private void cbActivaUbigeoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbActivaUbigeoEmpMouseClicked
        if(cbActivaUbigeoEmp.isSelected()){
            desbloquear2();
        }else{
            bloquear2();
        }
    }//GEN-LAST:event_cbActivaUbigeoEmpMouseClicked

    private void cbActivaContactoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivaContactoEmpActionPerformed
        
    }//GEN-LAST:event_cbActivaContactoEmpActionPerformed

    private void cbActivaContactoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbActivaContactoEmpMouseClicked
        if(cbActivaContactoEmp.isSelected()){
            desbloquear();
        }else{
            bloquear();
        }
    }//GEN-LAST:event_cbActivaContactoEmpMouseClicked

    private void btnGabarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGabarEmpleadoActionPerformed

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        empleado e = new empleado();
        String fec1 = sd.format(dcFechaNacEmp.getDate());
        e.setNom_pat_emp(txtPrimerNomEmp.getText());
        e.setNom_mat_emp(txtSegNombEmp.getText());
        e.setApe_pat_emp(txtPrimerApeEmp.getText());
        e.setApe_mat_emp(txtSegApeEmp.getText());
        e.setCargo_emp(cmbCargoEmp.getSelectedItem().toString());
        e.setFech_nac_emp(fec1);
        e.setPassword_emp(txtPasswordEmp.getText());
        // Agregar empleado
        obj.adiEmpleado(e);

        //Registrar datos de contacto de empleado con if para que pueda ser NULL
        if (cbActivaContactoEmp.isSelected()) {

            // Llamada al método de la clase de negocios para obtener el último id_emp
            contacto c = new contacto();
            // Asignar valores a las propiedades del objeto contacto
            c.setTipo_contac(cmbTipoContactoEmp.getSelectedItem().toString());
            c.setTelef_contac(txtTelEmp.getText());
            c.setEmail_contac(txtCorreoEmp.getText());

            // Asignar el objeto contacto al empleado
            e.setDatos_contacto_emp(c);

            // Agregar contacto asociado al id_emp
            obj.adiContactoEmp(c);
        }

        //Registrar datos de ubigeo de empleado con if para que pueda ser NULL
        if (cbActivaUbigeoEmp.isSelected()) {
            ubigeo u = new ubigeo();
            // Asignar valores a las propiedades del objeto ubigeo
            u.setDistrito_ubi(txtDistEmp.getText());
            u.setProvincia_ubi(txtProvEmp.getText());
            u.setCalle_avend_ubi(txtCalleEmp.getText());
            u.setNum_calle_ubi(Integer.parseInt(txtNroCalleEmp.getText()));
            u.setReferencia_ubi(txtRefUbigeoEmp.getText());

            // Asignar el objeto ubigeo al empleado
            e.setDatos_ubigeo_emp(u);

            // Agregar ubigeo asociado al id_emp
            obj.adiUbigeoEmp(u);
        }

        muestra();//Actualizar datos de la tabla empleado
    }//GEN-LAST:event_btnGabarEmpleadoActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
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
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmpleado().setVisible(true);
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
    private javax.swing.JButton btnGabarEmpleado;
    private javax.swing.JButton btnNuevoEmp;
    private javax.swing.JCheckBox cbActivaContactoEmp;
    private javax.swing.JCheckBox cbActivaUbigeoEmp;
    private javax.swing.JComboBox<String> cmbCargoEmp;
    private javax.swing.JComboBox<String> cmbTipoContactoEmp;
    private com.toedter.calendar.JDateChooser dcFechaNacEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelContactoEmp;
    private javax.swing.JPanel jPanelUbigeoEmp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tablaEmp;
    private javax.swing.JTextField txtCalleEmp;
    private javax.swing.JTextField txtCorreoEmp;
    private javax.swing.JTextField txtDistEmp;
    private javax.swing.JTextField txtNroCalleEmp;
    private javax.swing.JPasswordField txtPasswordEmp;
    private javax.swing.JTextField txtPrimerApeEmp;
    private javax.swing.JTextField txtPrimerNomEmp;
    private javax.swing.JTextField txtProvEmp;
    private javax.swing.JTextField txtRefUbigeoEmp;
    private javax.swing.JTextField txtSegApeEmp;
    private javax.swing.JTextField txtSegNombEmp;
    private javax.swing.JTextField txtTelEmp;
    // End of variables declaration//GEN-END:variables
}
