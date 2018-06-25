/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Producto;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.ProductoDAOPostgre;

/**
 *
 * @author levi
 */
public class GestionarProductoServicio {

    private GestorJDBC gestorJDBC;
    private ProductoDAOPostgre productoDAOPostgre;

    public GestionarProductoServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        productoDAOPostgre = new ProductoDAOPostgre(gestorJDBC);
    }

    public List<Producto> mostrarProducto(String tipoProducto) {
        List<Producto> listaProducto = null;
        try {
            gestorJDBC.abrirConexion();
            listaProducto = productoDAOPostgre.mostrar(tipoProducto);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaProducto;
    }

    public Producto buscarProductoCodigo(int productoCodigo) throws Exception {
        gestorJDBC.abrirConexion();
        Producto producto = productoDAOPostgre.buscar(productoCodigo);
        gestorJDBC.cerrarConexion();
        return producto;
    }

}
