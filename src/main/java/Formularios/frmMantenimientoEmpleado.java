// COMENTARIO 
package Formularios;

import static Formularios.frmPedido.btnAgregarProducto;
import static Formularios.frmPedido.btnAyudaEmpleado;
import static Formularios.frmPedido.btnAyudaProducto;
import static Formularios.frmPedido.btnAyudaProovedor;
import clases.*;
import controlador.*;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import login.frmMenú;
public class frmMantenimientoEmpleado extends javax.swing.JFrame {

    private int mouseX, mouseY;
    
    public frmMantenimientoEmpleado() {
        initComponents();
        setSize(756, 787);  // Establecer el tamaño del JFrame
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

                frmMantenimientoEmpleado.this.setLocation(x, y);
            }
        });
        
        // Agregar ComponentListener para gestionar cambios en el tamaño de la ventana
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustar la escala de las imágenes al cambiar el tamaño de la ventana
                EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
                EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
                EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
                EscaladoImagenesButton(btnModificarEmpleado, "src\\main\\java\\recursos\\AgregarEmpleado_(2).png");
                EscaladoImagenesButton(btnEliminar, "src\\main\\java\\recursos\\limpieza-de-datos_(1).png");
            }
        });
        
        
        llenarEmpleados();
        muestra();
        bloquear();
        bloquear2();
    }
    List<empleado> lista; 
    
    NegocioMass obj=new NegocioMass();
    void llenarEmpleados(){
        lista = obj.lisEmp();
        // Llenar el ComboBox con la lista de códigos de empleados        
        for (empleado empleado : lista) {
            cmbEmpleado.addItem(empleado.getId_emp());
        }
    }
    void llenarCamposEmpleados(){
        String codEmpleado = cmbEmpleado.getSelectedItem().toString();
        empleado e = obj.obtenerDatosUnEmpleado(codEmpleado);       
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date FechaNacimiento=null;
        try {
            FechaNacimiento = sd.parse(e.getFech_nac_emp());
        } catch (ParseException ex) {
            Logger.getLogger(frmMantenimientoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        dcFechaNacEmp.setDate(FechaNacimiento);    
        txtPrimerNomEmp.setText(e.getNom_pat_emp());
        txtSegNombEmp.setText(e.getNom_mat_emp());
        txtPrimerApeEmp.setText(e.getApe_pat_emp());
        txtSegApeEmp.setText(e.getApe_mat_emp());
        
        String cargo = e.getCargo_emp();
        if(cargo.equalsIgnoreCase("Gerente")){
            cmbCargoEmp.setSelectedIndex(3);
        }else if(cargo.equalsIgnoreCase("Reponedor")){
            cmbCargoEmp.setSelectedIndex(2);
        }else if(cargo.equalsIgnoreCase("Vendedor")){
            cmbCargoEmp.setSelectedIndex(1);
        }else{
            cmbCargoEmp.setSelectedIndex(0);            
        }
        txtPasswordEmp.setText(e.getPassword_emp());  
        
        String tipoContacto = e.getDatos_contacto_emp().getTipo_contac();
        if(tipoContacto.equalsIgnoreCase("Personal")){
            cmbTipoContactoEmp.setSelectedIndex(1);
        }else if(tipoContacto.equalsIgnoreCase("Casa")){
            cmbTipoContactoEmp.setSelectedIndex(2);
        }
        else if(tipoContacto.equalsIgnoreCase("Contacto de Emergencia")){
            cmbTipoContactoEmp.setSelectedIndex(3);
        }else{
            cmbTipoContactoEmp.setSelectedIndex(0);            
        }
        txtTelEmp.setText(e.getDatos_contacto_emp().getTelef_contac());
        txtCorreoEmp.setText(e.getDatos_contacto_emp().getEmail_contac());
        txtDistEmp.setText(e.getDatos_ubigeo_emp().getDistrito_ubi());
        txtCalleEmp.setText(e.getDatos_ubigeo_emp().getCalle_avend_ubi());
        txtProvEmp.setText(e.getDatos_ubigeo_emp().getProvincia_ubi());
        txtNroCalleEmp.setText(String.valueOf(e.getDatos_ubigeo_emp().getNum_calle_ubi()));
        txtRefUbigeoEmp.setText(e.getDatos_ubigeo_emp().getReferencia_ubi());
    }

    void muestra(){
        DefaultTableModel dt = (DefaultTableModel)tablaEmp.getModel();
        dt.setRowCount(0);
        
        for(empleado x : obj.lisEmp()){
            Object v[]={x.getId_emp(),x.getNom_pat_emp(),x.getApe_pat_emp(),
                x.getApe_mat_emp(), x.getCargo_emp(), x.getFech_nac_emp()};

        dt.addRow(v);
        }
    }
    
    public void limpiar(){            
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
        btnModificarEmpleado = new javax.swing.JButton();
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
        btnEliminar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        panelFondo.setMaximumSize(new java.awt.Dimension(756, 787));
        panelFondo.setMinimumSize(new java.awt.Dimension(756, 787));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("MANTENIMIENTO EMPLEADO");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 6, -1, 41));

        btnModificarEmpleado.setText("MODIFICAR");
        btnModificarEmpleado.setToolTipText("");
        btnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleadoActionPerformed(evt);
            }
        });
        panelFondo.add(btnModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 476, 133, 37));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Primer Nombre");
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 129, 101, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Segundo Nombre");
        panelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 177, 109, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Primer Apellido");
        panelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 225, 109, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Segundo Apellido");
        panelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 268, 109, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Cargo");
        panelFondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 322, 109, -1));
        panelFondo.add(dcFechaNacEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 369, 118, -1));

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
        panelFondo.add(txtPrimerNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 124, 118, -1));

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
        panelFondo.add(txtSegNombEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 172, 118, -1));

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
        panelFondo.add(txtPrimerApeEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 220, 118, -1));

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
        panelFondo.add(txtSegApeEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 263, 118, -1));

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

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 552, 586, 207));

        cmbCargoEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Vendedor", "Reponedor", "Cajero" }));
        panelFondo.add(cmbCargoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 312, 118, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Fecha de Nacimiento");
        panelFondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 377, 117, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Contraseña");
        panelFondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 426, 117, -1));
        panelFondo.add(txtPasswordEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 421, 118, -1));

        cbActivaContactoEmp.setText("Agregar Informacion de Contacto");
        cbActivaContactoEmp.setContentAreaFilled(false);
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
        panelFondo.add(cbActivaContactoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 66, -1, -1));

        jPanelContactoEmp.setBackground(new java.awt.Color(8, 66, 177));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telefono");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo");

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

        panelFondo.add(jPanelContactoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 104, 367, -1));

        cbActivaUbigeoEmp.setText("Agregar Informacion de Ubigeo");
        cbActivaUbigeoEmp.setContentAreaFilled(false);
        cbActivaUbigeoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbActivaUbigeoEmpMouseClicked(evt);
            }
        });
        panelFondo.add(cbActivaUbigeoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 260, -1, -1));

        jPanelUbigeoEmp.setBackground(new java.awt.Color(8, 66, 177));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Distrito");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Provincia");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Calle/Avenida");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nro Calle");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
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

        panelFondo.add(jPanelUbigeoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 286, -1, -1));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelFondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 475, 114, 39));
        panelFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 117, 41));

        cmbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpleadoActionPerformed(evt);
            }
        });
        panelFondo.add(cmbEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 68, 201, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Codigo de Empleado");
        panelFondo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, -1, -1));

        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        panelFondo.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 6, 40, 41));

        lblFondo.setPreferredSize(new java.awt.Dimension(756, 787));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 756, 787));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        empleado e = new empleado();
        String fec1 = sd.format(dcFechaNacEmp.getDate());
        e.setId_emp(cmbEmpleado.getSelectedItem().toString());
        e.setNom_pat_emp(txtPrimerNomEmp.getText());
        e.setNom_mat_emp(txtSegNombEmp.getText());
        e.setApe_pat_emp(txtPrimerApeEmp.getText());
        e.setApe_mat_emp(txtSegApeEmp.getText());
        e.setCargo_emp(cmbCargoEmp.getSelectedItem().toString());
        e.setFech_nac_emp(fec1);
        e.setPassword_emp(txtPasswordEmp.getText());
        //Modificar empleado
        obj.editEmpleado(e);

        //Registrar datos de contacto de empleado con if para que pueda ser NULL
        if (cbActivaContactoEmp.isSelected()) {
            String codEmpleado = cmbEmpleado.getSelectedItem().toString();
            empleado ec = obj.obtenerDatosUnEmpleado(codEmpleado);
            // Llamada al método de la clase de negocios para obtener el último id_emp
            contacto c = new contacto();
            // Asignar valores a las propiedades del objeto contacto
            c.setId_contac(ec.getDatos_contacto_emp().getId_contac());
            c.setTipo_contac(cmbTipoContactoEmp.getSelectedItem().toString());
            c.setTelef_contac(txtTelEmp.getText());
            c.setEmail_contac(txtCorreoEmp.getText());

            // Asignar el objeto contacto al empleado
            e.setDatos_contacto_emp(c);

            // Agregar contacto asociado al id_emp
            obj.modificarContacto(c);
        }

        //Registrar datos de ubigeo de empleado con if para que pueda ser NULL
        if (cbActivaUbigeoEmp.isSelected()) {
            String codEmpleado = cmbEmpleado.getSelectedItem().toString();
            empleado eu = obj.obtenerDatosUnEmpleado(codEmpleado);
            ubigeo u = new ubigeo();
            // Asignar valores a las propiedades del objeto ubigeo
            u.setId_ubigeo(eu.getDatos_ubigeo_emp().getId_ubigeo());
            u.setDistrito_ubi(txtDistEmp.getText());
            u.setProvincia_ubi(txtProvEmp.getText());
            u.setCalle_avend_ubi(txtCalleEmp.getText());
            u.setNum_calle_ubi(Integer.parseInt(txtNroCalleEmp.getText()));
            u.setReferencia_ubi(txtRefUbigeoEmp.getText());

            // Asignar el objeto ubigeo al empleado
            e.setDatos_ubigeo_emp(u);

            // Agregar ubigeo asociado al id_emp
            obj.modificarUbigeo(u);
        }

        muestra();//Actualizar datos de la tabla empleado
        limpiar();
    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    private void cbActivaContactoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbActivaContactoEmpMouseClicked
        if(cbActivaContactoEmp.isSelected()){
            desbloquear();
        }else{
            bloquear();
        }
    }//GEN-LAST:event_cbActivaContactoEmpMouseClicked

    private void cbActivaContactoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivaContactoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActivaContactoEmpActionPerformed

    private void cbActivaUbigeoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbActivaUbigeoEmpMouseClicked
        if(cbActivaUbigeoEmp.isSelected()){
            desbloquear2();
        }else{
            bloquear2();
        }
    }//GEN-LAST:event_cbActivaUbigeoEmpMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codEmpleado = cmbEmpleado.getSelectedItem().toString();
        obj.eliminarEmpleado(codEmpleado);
        cmbEmpleado.removeItem(codEmpleado);
        muestra();//Actualizar datos de la tabla empleado
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpleadoActionPerformed
        llenarCamposEmpleados();
    }//GEN-LAST:event_cmbEmpleadoActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
        frmMenú menu = new frmMenú();
        menu.setVisible(true);
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
            java.util.logging.Logger.getLogger(frmMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMantenimientoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenimientoEmpleado().setVisible(true);
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JCheckBox cbActivaContactoEmp;
    private javax.swing.JCheckBox cbActivaUbigeoEmp;
    private javax.swing.JComboBox<String> cmbCargoEmp;
    private javax.swing.JComboBox<String> cmbEmpleado;
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
    private javax.swing.JLabel jLabel17;
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
