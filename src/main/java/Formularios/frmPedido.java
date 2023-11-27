package Formularios;

import clases.*;
import controlador.NegocioMass;
import java.awt.Image;
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
import javax.swing.table.DefaultTableModel;
import login.frmMenú;
import vistas.*;


import java.awt.HeadlessException;
import java.awt.Point;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;
import util.MySQLConexion;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;





public class frmPedido extends javax.swing.JFrame {
    
    private int mouseX, mouseY;
    NegocioMass mass = new NegocioMass();
    public static String id_emp;
    public static String id_prov;
    public static String id_produc;
    public static String id_ctg;
    List<detalle_pedido> list_detalle_pedido;
    String codigoPedido;

    public frmPedido() {
        initComponents();  
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

                frmPedido.this.setLocation(x, y);
            }
        });

        // Agregar ComponentListener para gestionar cambios en el tamaño de la ventana
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustar la escala de las imágenes al cambiar el tamaño de la ventana
                EscaladoImagenesLabel(lblLogo, "src\\main\\java\\recursos\\logoMass.png");
                EscaladoImagenesLabel(lblFondo, "src\\main\\java\\recursos\\fondoMass(920X1020).png");
                EscaladoImagenesLabel(lblCerrar, "src\\main\\java\\recursos\\cerrar.png");
                EscaladoImagenesButton(btnNuevaFactura, "src\\main\\java\\recursos\\nueva_factura.png");
                EscaladoImagenesButton(btnAyudaEmpleado, "src\\main\\java\\recursos\\lupa.png");
                EscaladoImagenesButton(btnAyudaProovedor, "src\\main\\java\\recursos\\lupa.png");
                EscaladoImagenesButton(btnAyudaProducto, "src\\main\\java\\recursos\\lupa.png");
                EscaladoImagenesButton(btnAgregarProducto, "src\\main\\java\\recursos\\agregar_producto.png");
                EscaladoImagenesButton(btnQuitarProducto, "src\\main\\java\\recursos\\quitar_producto.png");
                EscaladoImagenesButton(btnRegistrarPedido, "src\\main\\java\\recursos\\registrar_pedido.png");
            }
        });
        
        tablaPedidos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt){
               JTable table = (JTable) Mouse_evt.getSource();
               Point point = Mouse_evt.getPoint();
               int row = table.rowAtPoint(point);
               if(Mouse_evt.getClickCount()==1){
                   codigoPedido=tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(), 0).toString();
                   txtCodigoPed_Guia.setText(codigoPedido);
                   System.out.println(codigoPedido);
               }
           } 
        });
        
        muestraPedidos();
        
        
    }
    
    public void muestraPedidos(){
        DefaultTableModel dt = (DefaultTableModel)tablaPedidos.getModel();
        dt.setRowCount(0);
        for(pedido pedi: mass.obtenerDatosPedidosParaLista()){
            Object f[] = {pedi.getId_pedi(), pedi.getFech_pedi(), pedi.getHora_pedi(), pedi.getNom_prov_pedi(), pedi.getNom_emp_pedi(), pedi.getEstado_pedi(), pedi.getTotal_precio_pedi()};
            dt.addRow(f);
        }
    }
    
    public void muestraDetallePedido(){
        DefaultTableModel dt = (DefaultTableModel)tablaProductosParaPedido.getModel();
        dt.setRowCount(0);
        double totalPedido = 0;
        for(detalle_pedido detalle : list_detalle_pedido){
            Object v[] = {detalle.getId_produc(), detalle.getNom_produc(), detalle.getTipo_empq_produc(), detalle.getCant_produc_pedi(), detalle.precio_tot_x_produc()};
            totalPedido = Math.round((totalPedido + detalle.precio_tot_x_produc()) * 100.0) / 100.0;
            dt.addRow(v);
        }
        txtTotalPedido.setText("" + totalPedido);
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
        lblTotalPedido = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCodPedido = new javax.swing.JLabel();
        btnNuevaFactura = new javax.swing.JButton();
        btnImprimeGuia = new javax.swing.JButton();
        txtIdPedido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        lblPedidosRegistrados = new javax.swing.JLabel();
        panelDatosPedido = new javax.swing.JPanel();
        lblNomEmp = new javax.swing.JLabel();
        lblIdEmp = new javax.swing.JLabel();
        lblIdProv = new javax.swing.JLabel();
        lblNomProv = new javax.swing.JLabel();
        btnAyudaProovedor = new javax.swing.JButton();
        btnAyudaEmpleado = new javax.swing.JButton();
        txtIdProv = new javax.swing.JTextField();
        txtIdEmp = new javax.swing.JTextField();
        txtNomEmp = new javax.swing.JLabel();
        txtNomProv = new javax.swing.JLabel();
        lblIdProduc = new javax.swing.JLabel();
        txtIdProduc = new javax.swing.JTextField();
        btnAyudaProducto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblCantidadProducto = new javax.swing.JLabel();
        spnCantidadProducto = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        lblTipoEmpaque = new javax.swing.JLabel();
        txtTipoEmpaque = new javax.swing.JLabel();
        lblNomCategoria = new javax.swing.JLabel();
        txtNomCategoria = new javax.swing.JLabel();
        lblCantXEmpaque = new javax.swing.JLabel();
        txtCantXEmpaque = new javax.swing.JLabel();
        lblPrecioEmpaque = new javax.swing.JLabel();
        txtPrecioEmpaque = new javax.swing.JLabel();
        lblMarcaProduc = new javax.swing.JLabel();
        lblNomProduc = new javax.swing.JLabel();
        txtMarcaProduc = new javax.swing.JLabel();
        txtNomProduc = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosParaPedido = new javax.swing.JTable();
        txtTotalPedido = new javax.swing.JLabel();
        btnRegistrarPedido = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        txtCodigoPed_Guia = new javax.swing.JTextField();
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

        lblTotalPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalPedido.setText("Total Pedido:");
        panelFondo.add(lblTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 100, 40));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("REGISTRO DE PEDIDO");
        panelFondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 290, 50));

        lblCodPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCodPedido.setText("Código de Pedido:");
        panelFondo.add(lblCodPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 40));

        btnNuevaFactura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevaFactura.setText("NUEVA FACTURA");
        btnNuevaFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaFacturaActionPerformed(evt);
            }
        });
        panelFondo.add(btnNuevaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 210, 40));

        btnImprimeGuia.setText("IMPRIMIR GUIA");
        btnImprimeGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimeGuiaActionPerformed(evt);
            }
        });
        panelFondo.add(btnImprimeGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 630, 130, 40));

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
        tablaPedidos.setFocusable(false);
        jScrollPane1.setViewportView(tablaPedidos);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 880, 120));

        lblPedidosRegistrados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPedidosRegistrados.setText("Pedidos Registrados:");
        panelFondo.add(lblPedidosRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 150, 40));

        panelDatosPedido.setBackground(new java.awt.Color(8, 77, 166));
        panelDatosPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomEmp.setForeground(new java.awt.Color(255, 255, 255));
        lblNomEmp.setText("Nombre Empleado:");
        panelDatosPedido.add(lblNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 40));

        lblIdEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdEmp.setForeground(new java.awt.Color(255, 255, 255));
        lblIdEmp.setText("Código Empleado:");
        panelDatosPedido.add(lblIdEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 40));

        lblIdProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdProv.setForeground(new java.awt.Color(255, 255, 255));
        lblIdProv.setText("Código Proovedor:");
        panelDatosPedido.add(lblIdProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, 40));

        lblNomProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomProv.setForeground(new java.awt.Color(255, 255, 255));
        lblNomProv.setText("Nombre Proovedor:");
        panelDatosPedido.add(lblNomProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, 40));

        btnAyudaProovedor.setText("AYUDA");
        btnAyudaProovedor.setEnabled(false);
        btnAyudaProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaProovedorActionPerformed(evt);
            }
        });
        panelDatosPedido.add(btnAyudaProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 120, 40));

        btnAyudaEmpleado.setText("AYUDA");
        btnAyudaEmpleado.setEnabled(false);
        btnAyudaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaEmpleadoActionPerformed(evt);
            }
        });
        panelDatosPedido.add(btnAyudaEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 120, 40));

        txtIdProv.setEditable(false);
        txtIdProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdProv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelDatosPedido.add(txtIdProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 150, 40));

        txtIdEmp.setEditable(false);
        txtIdEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelDatosPedido.add(txtIdEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 150, 40));

        txtNomEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNomEmp.setForeground(new java.awt.Color(255, 255, 255));
        txtNomEmp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelDatosPedido.add(txtNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 270, 40));

        txtNomProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNomProv.setForeground(new java.awt.Color(255, 255, 255));
        txtNomProv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelDatosPedido.add(txtNomProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 270, 40));

        lblIdProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIdProduc.setForeground(new java.awt.Color(255, 255, 255));
        lblIdProduc.setText("Código Producto:");
        panelDatosPedido.add(lblIdProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 40));

        txtIdProduc.setEditable(false);
        txtIdProduc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelDatosPedido.add(txtIdProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, 40));

        btnAyudaProducto.setText("AYUDA");
        btnAyudaProducto.setEnabled(false);
        btnAyudaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaProductoActionPerformed(evt);
            }
        });
        panelDatosPedido.add(btnAyudaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 120, 40));

        panelFondo.add(panelDatosPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 460, 260));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCantidadProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantidadProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadProducto.setText("Seleccione la Cantidad de Paquetes a Pedir:");
        jPanel2.add(lblCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 50));

        spnCantidadProducto.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        spnCantidadProducto.setEnabled(false);
        jPanel2.add(spnCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 130, 30));

        panelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 470, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTipoEmpaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipoEmpaque.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoEmpaque.setText("Tipo de Empaque:");
        jPanel1.add(lblTipoEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 40));

        txtTipoEmpaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTipoEmpaque.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtTipoEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 230, 40));

        lblNomCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblNomCategoria.setText("Categoria de Producto:");
        jPanel1.add(lblNomCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 40));

        txtNomCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNomCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtNomCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, 40));

        lblCantXEmpaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantXEmpaque.setForeground(new java.awt.Color(255, 255, 255));
        lblCantXEmpaque.setText("Cantidad de Productos en Empaque:");
        jPanel1.add(lblCantXEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 40));

        txtCantXEmpaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCantXEmpaque.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCantXEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 110, 40));

        lblPrecioEmpaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecioEmpaque.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioEmpaque.setText("Precio de Empaque:");
        jPanel1.add(lblPrecioEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 40));

        txtPrecioEmpaque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrecioEmpaque.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtPrecioEmpaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 220, 40));

        lblMarcaProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarcaProduc.setForeground(new java.awt.Color(255, 255, 255));
        lblMarcaProduc.setText("Marca Producto:");
        jPanel1.add(lblMarcaProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 40));

        lblNomProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomProduc.setForeground(new java.awt.Color(255, 255, 255));
        lblNomProduc.setText("Nombre Producto:");
        jPanel1.add(lblNomProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 40));

        txtMarcaProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMarcaProduc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtMarcaProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 220, 40));

        txtNomProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNomProduc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtNomProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 220, 40));

        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarProducto.setText("AGREGAR PRODUCTO");
        btnAgregarProducto.setEnabled(false);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 380, 50));

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 410, 320));

        tablaProductosParaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRE", "TIPO DE EMPAQUE", "CANTIDAD SELECCIONADA", "SUB TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductosParaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosParaPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductosParaPedido);

        panelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 880, 150));

        txtTotalPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalPedido.setText("0.0");
        panelFondo.add(txtTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 90, 40));

        btnRegistrarPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarPedido.setText("REGISTRAR PEDIDO");
        btnRegistrarPedido.setEnabled(false);
        btnRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPedidoActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegistrarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 600, 190, 40));

        btnQuitarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnQuitarProducto.setText("QUITAR PRODUCTO");
        btnQuitarProducto.setEnabled(false);
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });
        panelFondo.add(btnQuitarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 600, 220, 40));

        txtCodigoPed_Guia.setEditable(false);
        panelFondo.add(txtCodigoPed_Guia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 632, 130, 40));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 820));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
        frmMenú menu = new frmMenú();
        menu.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaFacturaActionPerformed
        list_detalle_pedido = new ArrayList();
        String new_id_pedi = mass.generarNuevoIDPedido();
        txtIdPedido.setText(new_id_pedi);
        btnAyudaEmpleado.setEnabled(true);
        btnAyudaProovedor.setEnabled(true);
        btnAyudaProducto.setEnabled(false);
        limpiaTodosLosCampos();
    }//GEN-LAST:event_btnNuevaFacturaActionPerformed

    private void btnAyudaProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaProovedorActionPerformed
        vistaRapidaProovedores.id_prov = id_prov;
        vistaRapidaProovedores proovedores = new vistaRapidaProovedores();
        proovedores.setLocationRelativeTo(null);
        proovedores.setVisible(true);
        btnAyudaProovedor.setEnabled(false);
    }//GEN-LAST:event_btnAyudaProovedorActionPerformed

    private void btnAyudaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaEmpleadoActionPerformed
        vistaRapidaEmpleados.id_emp = id_emp;
        vistaRapidaEmpleados empleados = new vistaRapidaEmpleados();
        empleados.setLocationRelativeTo(null);
        empleados.setVisible(true);
        btnAyudaEmpleado.setEnabled(false);
    }//GEN-LAST:event_btnAyudaEmpleadoActionPerformed

    private void btnAyudaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaProductoActionPerformed
        vistaRapidaProductos.id_produc = id_produc;
        vistaRapidaProductos.marca_produc = txtNomProv.getText();
        vistaRapidaProductos productos = new vistaRapidaProductos();
        productos.setLocationRelativeTo(null);
        productos.setVisible(true);
        btnAyudaProducto.setEnabled(false);
    }//GEN-LAST:event_btnAyudaProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        String idProducNuevo = txtIdProduc.getText();

        for (detalle_pedido detalle_p : list_detalle_pedido) {
            if (detalle_p.getId_produc().equals(idProducNuevo)) {
                // Si ya existe un detalle con el mismo ID de producto, actualiza la cantidad
                detalle_p.setCant_produc_pedi((Integer) spnCantidadProducto.getValue());
                muestraDetallePedido();
                limpiaCamposProducto();
                return;
            }
        }

        // Si no se encontró un detalle existente con el mismo ID de producto, agrega uno nuevo
        detalle_pedido detalle = new detalle_pedido();
        detalle.setId_produc(idProducNuevo);
        detalle.setNom_produc(txtNomProduc.getText());
        detalle.setMarca_produc(txtMarcaProduc.getText());
        detalle.setPrecio_empaq_produc(Double.parseDouble(txtPrecioEmpaque.getText()));
        detalle.setCant_x_empaq_produc(Integer.parseInt(txtCantXEmpaque.getText()));
        detalle.setTipo_empq_produc(txtTipoEmpaque.getText());
        detalle.setId_ctg(id_ctg);
        detalle.setNom_ctg(txtNomCategoria.getText());
        detalle.setCant_produc_pedi((Integer) spnCantidadProducto.getValue());
        list_detalle_pedido.add(detalle);

        muestraDetallePedido();
        limpiaCamposProducto();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void tablaProductosParaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosParaPedidoMouseClicked
        btnQuitarProducto.setEnabled(true);
    }//GEN-LAST:event_tablaProductosParaPedidoMouseClicked

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        int fila = tablaProductosParaPedido.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null,"SELECIONE UN PRODUCTO A BORRAR") ;
            return;
        }
        list_detalle_pedido.remove(fila);
        muestraDetallePedido();
        btnQuitarProducto.setEnabled(false);
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void btnRegistrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPedidoActionPerformed
        //HORA
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = hora.format(formatoHora);
        LocalDate fecha = LocalDate.now();
        //FECHA
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fechaFormateada = fecha.format(formatoFecha);
        
        pedido pedi = new pedido();
        pedi.setId_pedi(txtIdPedido.getText());
        pedi.setFech_pedi(fechaFormateada);
        pedi.setHora_pedi(horaFormateada);
        pedi.setId_prov(txtIdProv.getText());
        pedi.setId_emp(txtIdEmp.getText());
        pedi.setEstado_pedi("Pendiente");
        
        mass.registrarPedido(pedi);
        
        for (detalle_pedido deta : list_detalle_pedido) {
            mass.registrarDetallePedido(pedi.getId_pedi(), deta);
        }
        
        btnRegistrarPedido.setEnabled(false);
        limpiaTodosLosCampos();
        muestraPedidos();
    }//GEN-LAST:event_btnRegistrarPedidoActionPerformed

    private void btnImprimeGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimeGuiaActionPerformed
        
        LocalDate fecha = LocalDate.now();
        //FECHA
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fechaFormateada = fecha.format(formatoFecha);
        gui_entrega guia = new gui_entrega();
        guia.setFech_entrg(fechaFormateada);
        guia.setId_pedi(codigoPedido);
        mass.adiGuia(guia);
        
        MySQLConexion obj = new MySQLConexion();
        String RutaLocal = System.getProperty("user.dir");
        try {
        String rutaInforme = RutaLocal + "/src/main/java/reportes/Reporte_GuiaEntrega.jasper";
        System.out.println("Ruta del informe: " + rutaInforme); // Probando

        Map parametros = new HashMap<>();
        //parametros.put("cod", jTextField1.getText());
        parametros.put("cod", codigoPedido);
        JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros, obj.getConexion());

        JasperViewer ventanavisor = new JasperViewer(informe, false);
        ventanavisor.setTitle("INFORME");
        ventanavisor.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_btnImprimeGuiaActionPerformed

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
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPedido().setVisible(true);
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
    
    private void limpiaTodosLosCampos() {
        txtIdEmp.setText("");
        txtNomEmp.setText("");
        txtIdProv.setText("");
        txtNomProv.setText("");
        txtIdProduc.setText("");
        txtNomProduc.setText("");
        txtMarcaProduc.setText("");
        txtPrecioEmpaque.setText("");
        txtCantXEmpaque.setText("");
        id_ctg = null;
        txtNomCategoria.setText("");
        spnCantidadProducto.setValue(1);
        txtTipoEmpaque.setText("");
        btnRegistrarPedido.setEnabled(false);
        btnQuitarProducto.setEnabled(false);
        muestraDetallePedido();
        muestraPedidos();
    }
    
    private void limpiaCamposProducto() {
        txtIdProduc.setText("");
        txtNomProduc.setText("");
        txtMarcaProduc.setText("");
        txtPrecioEmpaque.setText("");
        txtCantXEmpaque.setText("");
        id_ctg = null;
        txtNomCategoria.setText("");
        spnCantidadProducto.setValue(1);
        txtTipoEmpaque.setText("");
        btnAgregarProducto.setEnabled(false);
        btnRegistrarPedido.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregarProducto;
    public static javax.swing.JButton btnAyudaEmpleado;
    public static javax.swing.JButton btnAyudaProducto;
    public static javax.swing.JButton btnAyudaProovedor;
    private javax.swing.JButton btnImprimeGuia;
    private javax.swing.JButton btnNuevaFactura;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnRegistrarPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantXEmpaque;
    private javax.swing.JLabel lblCantidadProducto;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblCodPedido;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIdEmp;
    private javax.swing.JLabel lblIdProduc;
    private javax.swing.JLabel lblIdProv;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMarcaProduc;
    private javax.swing.JLabel lblNomCategoria;
    private javax.swing.JLabel lblNomEmp;
    private javax.swing.JLabel lblNomProduc;
    private javax.swing.JLabel lblNomProv;
    private javax.swing.JLabel lblPedidosRegistrados;
    private javax.swing.JLabel lblPrecioEmpaque;
    private javax.swing.JLabel lblTipoEmpaque;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalPedido;
    private javax.swing.JPanel panelDatosPedido;
    private javax.swing.JPanel panelFondo;
    public static javax.swing.JSpinner spnCantidadProducto;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaProductosParaPedido;
    public static javax.swing.JLabel txtCantXEmpaque;
    private javax.swing.JTextField txtCodigoPed_Guia;
    public static javax.swing.JTextField txtIdEmp;
    public static javax.swing.JLabel txtIdPedido;
    public static javax.swing.JTextField txtIdProduc;
    public static javax.swing.JTextField txtIdProv;
    public static javax.swing.JLabel txtMarcaProduc;
    public static javax.swing.JLabel txtNomCategoria;
    public static javax.swing.JLabel txtNomEmp;
    public static javax.swing.JLabel txtNomProduc;
    public static javax.swing.JLabel txtNomProv;
    public static javax.swing.JLabel txtPrecioEmpaque;
    public static javax.swing.JLabel txtTipoEmpaque;
    private javax.swing.JLabel txtTotalPedido;
    // End of variables declaration//GEN-END:variables
}
