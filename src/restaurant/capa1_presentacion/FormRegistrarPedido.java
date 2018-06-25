/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import restaurant.capa1_presentacion.util.ConfiguradorDeTabla;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;
import restaurant.capa2_aplicacion.RegistrarPedidoServicio;
import restaurant.capa3_dominio.Cliente;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Mozo;
import restaurant.capa3_dominio.Pedido;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class FormRegistrarPedido extends javax.swing.JDialog {

    Cliente cliente;
    Mozo mozo;
    Mesa mesa;
    Producto producto;
    Pedido pedido;
    RegistrarPedidoServicio registrarPedidoServicio;

    public FormRegistrarPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        producto = null;
        pedido = new Pedido();
        registrarPedidoServicio = new RegistrarPedidoServicio();
        this.txtDniCliente.requestFocusInWindow();
        llenarComboboxProducto();
        inicializarTabla();
        limpiarCampos();

    }

    void limpiarCampos() {
        txtCantidadProductos.setText("");
        txtProducto.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        panelCantidad.setVisible(false);

    }

    void inicializarPedido() {
        cbxTipoProducto.setSelectedIndex(0);
      
        cliente = null;
        mesa = null;
        mozo = null;
        producto = null;
    }

    void inicializarTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla.agregarColumna(new Columna("cantidad", "java.lang.Integer"));

        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPedidos.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPedidos, 0, 250, 100, 100);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPedidos, 1, 250, 100, 100);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPedidos, 2, 250, 100, 100);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPedidos, 3, 100, 100, 50);

    }

    void estadoBotonRegistro(boolean estado) {
        btnRegistrar.setEnabled(estado);
    }

    void limpiarTabla() {
        DefaultTableModel temp;
        temp = (DefaultTableModel) tablaPedidos.getModel();
        int a = temp.getRowCount() - 1;
        for (int i = 0; i < a; i++) {
            temp.removeRow(i);
        }
    }

    void llenarComboboxProducto() {
        try {
            cbxTipoProducto.removeAllItems();

            List<TipoProducto> listaTipoProducto = registrarPedidoServicio.mostrarTipoProducto();
            for (TipoProducto tipoProducto : listaTipoProducto) {
                cbxTipoProducto.addItem(tipoProducto.getTipoProductoNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error comuniquese con el administrador");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etiDni = new javax.swing.JLabel();
        botBucarCliente = new javax.swing.JButton();
        txtDniCliente = new javax.swing.JTextField();
        etiNombre = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        etiFecha = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        botCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbxTipoProducto = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDniMozo = new javax.swing.JTextField();
        btnMozo = new javax.swing.JButton();
        txtNombreMozo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMesa = new javax.swing.JTextField();
        btnMeza = new javax.swing.JButton();
        txtPiso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        etiiCodigo = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        etiiCodigo1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botBuscarEjemplar = new javax.swing.JButton();
        cantidad = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        panelCantidad = new javax.swing.JPanel();
        txtCantidadProductos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("“SOFTWARE DE RESTAURANT CON DISEÑO ARQUITECTURAL N-CAPAS”");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registrar Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 160, -1));

        etiDni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiDni.setText("DNI del Cliente:");
        getContentPane().add(etiDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 47, 100, -1));

        botBucarCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botBucarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/buscar.png"))); // NOI18N
        botBucarCliente.setText("Buscar Cliente");
        botBucarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBucarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(botBucarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 170, 40));

        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });
        getContentPane().add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 44, 115, -1));

        etiNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiNombre.setText("Nombre:");
        getContentPane().add(etiNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 80, 60, -1));

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setForeground(new java.awt.Color(0, 51, 204));
        txtNombreCliente.setFocusable(false);
        txtNombreCliente.setOpaque(false);
        getContentPane().add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 77, 317, -1));

        etiFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiFecha.setText("Fecha de Pedido:");
        getContentPane().add(etiFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        txtFechaRegistro.setEditable(false);
        txtFechaRegistro.setForeground(new java.awt.Color(0, 51, 204));
        txtFechaRegistro.setFocusable(false);
        getContentPane().add(txtFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 138, -1));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/save.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, 40));

        botCerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/cerrar.png"))); // NOI18N
        botCerrar.setText("Cerrar");
        botCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(botCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 453, -1, 20));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 440, 140));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tipo Producto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, -1));

        cbxTipoProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " ", " " }));
        getContentPane().add(cbxTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 115, 115, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 200, 149), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Dni del Mozo:");

        txtDniMozo.setText("60196417");
        txtDniMozo.setToolTipText("");
        txtDniMozo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniMozoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniMozoKeyTyped(evt);
            }
        });

        btnMozo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/buscar.png"))); // NOI18N
        btnMozo.setText("Buscar Mozo");
        btnMozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMozoActionPerformed(evt);
            }
        });

        txtNombreMozo.setEditable(false);
        txtNombreMozo.setForeground(new java.awt.Color(0, 51, 204));
        txtNombreMozo.setFocusable(false);
        txtNombreMozo.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nombre Mozo:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Mesa:");

        txtMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMesaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesaKeyTyped(evt);
            }
        });

        btnMeza.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMeza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/buscar.png"))); // NOI18N
        btnMeza.setText("Buscar Mesa");
        btnMeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMezaActionPerformed(evt);
            }
        });

        txtPiso.setEditable(false);
        txtPiso.setForeground(new java.awt.Color(0, 51, 204));
        txtPiso.setFocusable(false);
        txtPiso.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Piso:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(txtPiso))
                .addGap(18, 18, 18)
                .addComponent(btnMeza, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDniMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMozo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNombreMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDniMozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreMozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 430, 220));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 3));
        jPanel3.setForeground(new java.awt.Color(0, 255, 255));

        etiiCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiiCodigo.setText("Producto:");

        txtProducto.setEnabled(false);
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });

        etiiCodigo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiiCodigo1.setText("Precio:");

        txtPrecio.setEnabled(false);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre");

        botBuscarEjemplar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botBuscarEjemplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/buscar.png"))); // NOI18N
        botBuscarEjemplar.setText("Buscar Producto");
        botBuscarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarEjemplarActionPerformed(evt);
            }
        });

        cantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cantidad.setText("Stock:");

        txtStock.setEnabled(false);
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiiCodigo1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiiCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidad, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botBuscarEjemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(etiiCodigo))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botBuscarEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiiCodigo1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cantidad))
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 410, 170));

        panelCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(51, 255, 255)));

        txtCantidadProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProductosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad:");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/capa1_presentacion/util/AgregarProducto.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCantidadLayout = new javax.swing.GroupLayout(panelCantidad);
        panelCantidad.setLayout(panelCantidadLayout);
        panelCantidadLayout.setHorizontalGroup(
            panelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantidadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelCantidadLayout.setVerticalGroup(
            panelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantidadLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(panelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 300, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Lista de Pedidos del Cliente ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botBucarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBucarClienteActionPerformed

        if (!txtDniCliente.getText().equals("")) {

            try {
                cliente = registrarPedidoServicio.bsucarClientePorDNI(txtDniCliente.getText());
                if (cliente != null) {
                    txtNombreCliente.setText(cliente.getClienteNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no se ha encontrado");
                    txtNombreCliente.setText("");

                }
            } catch (Exception ex) {
                Logger.getLogger(FormRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar dni del cliente ");
        }

//        txtNombre.setText("");
//        try{
//            PrestarLibroServicio prestarLibroServicio = new PrestarLibroServicio();
//            lector = prestarLibroServicio.buscarLector(txtDniCliente.getText().trim());
//            if(lector != null)
//            txtNombre.setText(lector.getNombre());
//            else
//            Mensaje.mostrarAdvertencia(this, "El lector no se encuentra registrado");
//            activarBotonPrestar();
//        }
//        catch(Exception e){
//            Mensaje.mostrarErrorDeConsulta(this);
//        }
    }//GEN-LAST:event_botBucarClienteActionPerformed

    private void txtDniClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyReleased
//        if(lector != null){
//            lector = null;
//            txtNombre.setText("");
//            botPrestar.setEnabled(false);
//        }
    }//GEN-LAST:event_txtDniClienteKeyReleased

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDniCliente.getText().length() == 8
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniClienteKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int registros_afectados = 0;
        Date fecha = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        txtFechaRegistro.setText(format.format(java.sql.Date.valueOf(LocalDate.now())));
        if (cliente != null) {
            if (mesa != null) {
                if (mozo != null) {
                    pedido.setImporte(pedido.calcularTotal());
                    pedido.setCliente(cliente);
                    pedido.setMesa(mesa);
                    pedido.setMozo(mozo);
                    pedido.setPedidoEstado(Pedido.ESTADO_ACTIVO);

                    ///actualemtente estamos probando el codigo para el pedido despues lo obtendremos
                    //el ultimo codigo para poder ponerle al suguiente registro de pedido
                    pedido.setPedidoCodigo(6);
                    try {
                        RegistrarPedidoServicio pedidoServicio = new RegistrarPedidoServicio();
                        registros_afectados = pedidoServicio.crearPedido(pedido);
                        if (registros_afectados == 1) {
                            JOptionPane.showMessageDialog(null, "Se realizo con exito el registro");
                            inicializarPedido();
                            limpiarTabla();
                        } else{
                            JOptionPane.showMessageDialog(null, "No se pudo registrar");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Falta ingresar el dni del mozo");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Falta ingresar el numero de mesa");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar el dni del cliente");
        }

//        int registros_afectados;
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
//        Prestamo prestamo = new Prestamo(ejemplar,lector);
//        try{
//            PrestarLibroServicio prestarLibroServicio = new PrestarLibroServicio();
//            registros_afectados = prestarLibroServicio.crearPrestamo(prestamo);
//            if(registros_afectados == 1){
//                txtFechaLimite.setText(formatoFecha.format(prestamo.getFechalimite()));
//                Mensaje.mostrarAfirmacionDeCreacion(this);
//                inicializar();
//            }
//            else
//            Mensaje.mostrarAdvertenciaDeCreacion(this);
//        }
//        catch(Exception e){
//            Mensaje.mostrarError(this, e.getMessage());
//        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void botCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botCerrarActionPerformed

    private void botBuscarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarEjemplarActionPerformed

        try {
            String tipoProducto = cbxTipoProducto.getSelectedItem().toString();
            FromGestionarProducto fromGestionarProducto = new FromGestionarProducto(null, true, tipoProducto);
            fromGestionarProducto.setVisible(true);
            producto = fromGestionarProducto.productoSeleccionado;
            if (producto != null) {
                txtProducto.setText(producto.getProductoNombre());
                txtPrecio.setText(String.valueOf(producto.getProductoPrecio()));
                txtStock.setText(String.valueOf(producto.getProdcutoStock()));
                panelCantidad.setVisible(true);
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_botBuscarEjemplarActionPerformed

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped

    }//GEN-LAST:event_txtProductoKeyTyped

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
//        if(ejemplar != null){
//            ejemplar = null;
//            txtLibro.setText("");
//            activarBotonPrestar();
//        }
    }//GEN-LAST:event_txtProductoKeyReleased

    private void txtCantidadProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadProductosKeyTyped

    private void txtCantidadProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadProductosKeyReleased

    private void txtDniMozoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniMozoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniMozoKeyReleased

    private void txtDniMozoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniMozoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniMozoKeyTyped

    private void txtMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesaKeyReleased

    private void txtMesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesaKeyTyped

    private void btnMozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMozoActionPerformed

        if (!txtDniMozo.getText().equals("")) {

            try {
                mozo = registrarPedidoServicio.buscarMozoDNI(txtDniMozo.getText());
                if (mozo != null) {
                    txtNombreMozo.setText(mozo.getMozoNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "El mozo no se ha encontrado");
                    txtNombreMozo.setText("");

                }
            } catch (Exception ex) {
                Logger.getLogger(FormRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar dni del mozo ");
        }


    }//GEN-LAST:event_btnMozoActionPerformed

    private void btnMezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMezaActionPerformed

        if (!txtMesa.getText().equals("")) {

            try {
                mesa = registrarPedidoServicio.buscarMesa(Integer.parseInt(txtMesa.getText()));
                if (mesa != null) {
                    txtPiso.setText(String.valueOf(mesa.getMesaPiso()));
                }
            } catch (Exception ex) {
                Logger.getLogger(FormRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero de mesa ");
        }
    }//GEN-LAST:event_btnMezaActionPerformed

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyReleased

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ModeloTabla modeloTabla = (ModeloTabla) tablaPedidos.getModel();
        Fila filaTabla;
        int cantidad = 0;
        if (!txtCantidadProductos.getText().equals("")) {
            cantidad = Integer.parseInt(txtCantidadProductos.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Aun debe seleccionar la cantidad de productos ");
        }

        if (pedido.agregarLineaPedido(cantidad, producto)) {
            filaTabla = new Fila();
            filaTabla.agregarValorCelda(producto.getProductoCodigo());
            filaTabla.agregarValorCelda(producto.getProductoNombre());
            filaTabla.agregarValorCelda(producto.getProductoPrecio());
            filaTabla.agregarValorCelda(cantidad);
            modeloTabla.agregarFila(filaTabla);
            modeloTabla.refrescarDatos();
            limpiarCampos();
            estadoBotonRegistro(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficientes stock ");
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCantidadProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductosKeyPressed
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProductosKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botBucarCliente;
    private javax.swing.JButton botBuscarEjemplar;
    private javax.swing.JButton botCerrar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMeza;
    private javax.swing.JButton btnMozo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel cantidad;
    private javax.swing.JComboBox<String> cbxTipoProducto;
    private javax.swing.JLabel etiDni;
    private javax.swing.JLabel etiFecha;
    private javax.swing.JLabel etiNombre;
    private javax.swing.JLabel etiiCodigo;
    private javax.swing.JLabel etiiCodigo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCantidad;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField txtCantidadProductos;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtDniMozo;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtMesa;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreMozo;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
