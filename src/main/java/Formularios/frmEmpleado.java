// COMENTARIO 
package Formularios;

import clases.*;
import controlador.*;
import java.awt.Component;
import java.awt.Image;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class frmEmpleado extends javax.swing.JFrame {


    public frmEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\mass_(1).png");
        EscaladoImagenesButton(btnGabarEmpleado, "src\\main\\java\\recursos\\AgregarEmpleado_(2).png");
        EscaladoImagenesButton(btnNuevoEmp, "src\\main\\java\\recursos\\limpieza-de-datos_(1).png");
        muestra();
        bloquear();
        bloquear2();
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

        jLabel1 = new javax.swing.JLabel();
        btnGabarEmpleado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dcFechaNacEmp = new com.toedter.calendar.JDateChooser();
        txtPrimerNomEmp = new javax.swing.JTextField();
        txtSegNombEmp = new javax.swing.JTextField();
        txtPrimerApeEmp = new javax.swing.JTextField();
        txtSegApeEmp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmp = new javax.swing.JTable();
        cmbCargoEmp = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPasswordEmp = new javax.swing.JPasswordField();
        cbActivaContactoEmp = new javax.swing.JCheckBox();
        jPanelContactoEmp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelEmp = new javax.swing.JTextField();
        cmbTipoContactoEmp = new javax.swing.JComboBox<>();
        txtCorreoEmp = new javax.swing.JTextField();
        cbActivaUbigeoEmp = new javax.swing.JCheckBox();
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
        btnNuevoEmp = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRO EMPLEADO");

        btnGabarEmpleado.setText("GRABAR");
        btnGabarEmpleado.setToolTipText("");
        btnGabarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGabarEmpleadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Primer Nombre");

        jLabel4.setText("Segundo Nombre");

        jLabel5.setText("Primer Apellido");

        jLabel6.setText("Segundo Apellido");

        jLabel7.setText("Cargo");

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

        cmbCargoEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Vendedor", "Reponedor", "Cajero" }));

        jLabel10.setText("Fecha de Nacimiento");

        jLabel11.setText("Contraseña");

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

        jPanelContactoEmp.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("Tipo");

        jLabel8.setText("Telefono");

        jLabel9.setText("Correo");

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
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCorreoEmp)
                    .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelContactoEmpLayout.setVerticalGroup(
            jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContactoEmpLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContactoEmpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContactoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoContactoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbActivaUbigeoEmp.setText("Agregar Informacion de Ubigeo");
        cbActivaUbigeoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbActivaUbigeoEmpMouseClicked(evt);
            }
        });

        jPanelUbigeoEmp.setBackground(new java.awt.Color(255, 255, 204));

        jLabel12.setText("Distrito");

        jLabel13.setText("Provincia");

        jLabel14.setText("Calle/Avenida");

        jLabel15.setText("Nro Calle");

        jLabel16.setText("Referencia");

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
                .addContainerGap(22, Short.MAX_VALUE))
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

        btnNuevoEmp.setText("NUEVO");
        btnNuevoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbActivaContactoEmp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPrimerNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnGabarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dcFechaNacEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtPasswordEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSegNombEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSegApeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtPrimerApeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbCargoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnNuevoEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanelContactoEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelUbigeoEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cbActivaUbigeoEmp)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbActivaContactoEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrimerNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPrimerApeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtSegApeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSegNombEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbCargoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtPasswordEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dcFechaNacEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGabarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelContactoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbActivaUbigeoEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelUbigeoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        muestra();
        
        
    }//GEN-LAST:event_btnGabarEmpleadoActionPerformed

    private void cbActivaContactoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbActivaContactoEmpMouseClicked
        if(cbActivaContactoEmp.isSelected()){
            desbloquear();
        }else{
            bloquear();
        }
    }//GEN-LAST:event_cbActivaContactoEmpMouseClicked

    private void cbActivaUbigeoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbActivaUbigeoEmpMouseClicked
        if(cbActivaUbigeoEmp.isSelected()){
            desbloquear2();
        }else{
            bloquear2();
        }
    }//GEN-LAST:event_cbActivaUbigeoEmpMouseClicked

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

    private void cbActivaContactoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivaContactoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActivaContactoEmpActionPerformed

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelContactoEmp;
    private javax.swing.JPanel jPanelUbigeoEmp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
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
