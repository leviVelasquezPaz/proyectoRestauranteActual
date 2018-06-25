/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa1_presentacion;

import restaurant.capa1_presentacion.util.ConfiguradorDeTabla;
import java.util.List;
import javax.imageio.spi.RegisterableService;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;
import restaurant.capa2_aplicacion.GestionarProductoServicio;
import restaurant.capa2_aplicacion.RegistrarPedidoServicio;
import restaurant.capa3_dominio.Producto;

/**
 *
 * @author Antonio AB
 */
public class FromGestionarProducto extends javax.swing.JDialog {

    GestionarProductoServicio gestionarProductoServicio;
    public Producto productoSeleccionado;

    public FromGestionarProducto(java.awt.Frame parent, boolean modal, String tipoProducto) {
        super(parent, modal);
        initComponents();

        gestionarProductoServicio = new GestionarProductoServicio();
        inicializarTabla();
        obtenerDatosTabla(tipoProducto);
    }

    void inicializarTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Tipo producto", "java.lang.String"));
        tabla.agregarColumna(new Columna("Estado", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaProductos.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaProductos, 0, 250, 100, 100);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaProductos, 1, 250, 100, 100);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaProductos, 2, 250, 100, 100);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaProductos, 3, 100, 100, 50);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaProductos, 4, 100, 100, 50);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaProductos, 5, 100, 100, 50);

    }

    private void obtenerDatosTabla(String tipoProducto) {
        Fila filaTabla;
        try {
            List<Producto> listaProducto = gestionarProductoServicio.mostrarProducto(tipoProducto);
            ModeloTabla modeloTabla = (ModeloTabla) tablaProductos.getModel();
            if (listaProducto.size() == 0) {
                JOptionPane.showMessageDialog(null, "No existen productos de la categoria " + tipoProducto);
                this.dispose();
            } else {
                for (Producto producto : listaProducto) {
                    filaTabla = new Fila();
                    filaTabla.agregarValorCelda(producto.getProductoCodigo());
                    filaTabla.agregarValorCelda(producto.getProductoNombre());
                    filaTabla.agregarValorCelda(producto.getProductoPrecio());
                    filaTabla.agregarValorCelda(producto.getProdcutoStock());
                    filaTabla.agregarValorCelda(producto.getTipoDeProducto().getTipoProductoNombre());
                    filaTabla.agregarValorCelda(producto.getProductoEstado());
                    modeloTabla.agregarFila(filaTabla);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        botBuscar = new javax.swing.JButton();
        scrLectores = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("“SOFTWARE DE RESTAURANT CON DISEÑO ARQUITECTURAL N-CAPAS”");

        jLabel2.setText("Nombre del Producto:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });

        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaProductos.setName("tablaProductos"); // NOI18N
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        scrLectores.setViewportView(tablaProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrLectores))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(scrLectores, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == 10) { // es verdad cuando se presiona enter (codigo: 10)

            // buscar();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void botBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarActionPerformed
        // buscar();
    }//GEN-LAST:event_botBuscarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed

        int fila = tablaProductos.getSelectedRow();
        String codigo = tablaProductos.getValueAt(fila, 0).toString();
        GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
        try {
            productoSeleccionado = gestionarProductoServicio.buscarProductoCodigo(Integer.parseInt(codigo.trim()));
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tablaProductosMousePressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FromGestionarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FromGestionarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FromGestionarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FromGestionarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FromGestionarProducto dialog = new FromGestionarProducto(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scrLectores;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
