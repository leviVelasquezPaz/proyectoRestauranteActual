/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa4_persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class ProductoDAOPostgre {

    GestorJDBC gestorJDBC;

    public ProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public Producto buscar(int productoCodigo) throws SQLException {
        Producto producto = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "Select productocodigo, productonombre, productodescripcion, productoprecio, productostock, productofecharegistro, tipoproductocodigo, productoestado FROM producto where productocodigo='" + productoCodigo + "'";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            producto = new Producto();
            producto.setProductoCodigo(resultado.getInt("productocodigo"));
            producto.setProductoNombre(resultado.getString("productonombre"));
            producto.setProductoDescripcion(resultado.getString("productodescripcion"));
            producto.setProductoPrecio(resultado.getDouble("productoprecio"));
            producto.setProdcutoStock(resultado.getInt("productostock"));
            TipoProductoDAOPostgre tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
            TipoProducto tipoProducto = tipoProductoDAOPostgre.buscar(resultado.getInt("tipoproductocodigo"));
            producto.setTipoDeProducto(tipoProducto);
            producto.setProductoEstado(resultado.getString("productoestado"));

        }
        resultado.close();
        return producto;
    }

    public List<Producto> mostrar(String tipoProductos) throws SQLException {

        ResultSet resultado;
        String sentenciaSQL;
        List<Producto> listaProducto = new ArrayList<>();
        sentenciaSQL = "Select  p.productocodigo, p.productonombre, p.productodescripcion, p.productoprecio, p.productostock, p.productofecharegistro, p.tipoproductocodigo, p.productoestado FROM producto p inner join tipoproducto tp  on p.tipoproductocodigo=tp.tipoproductocodigo where tp.tipoproductonombre='" + tipoProductos + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            Producto producto = new Producto();
            producto.setProductoCodigo(resultado.getInt("productocodigo"));
            producto.setProductoNombre(resultado.getString("productonombre"));
            producto.setProductoDescripcion(resultado.getString("productodescripcion"));
            producto.setProductoPrecio(resultado.getDouble("productoprecio"));
            producto.setProdcutoStock(resultado.getInt("productostock"));
            producto.setProductoFechaRegistro(resultado.getDate("productofecharegistro"));
            TipoProductoDAOPostgre tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
            TipoProducto tipoProducto = tipoProductoDAOPostgre.buscar(resultado.getInt("tipoproductocodigo"));
            producto.setTipoDeProducto(tipoProducto);
            producto.setProductoEstado(resultado.getString("productoestado"));
            listaProducto.add(producto);
            JOptionPane.showMessageDialog(null, "paso");
        }
      
        resultado.close();
        return listaProducto;
    }

    public int actualizarStock(Producto producto) throws Exception {
        String sentenciaSQL = "UPDATE producto SET productostock=? WHERE productocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDouble(1, producto.getProdcutoStock());
        sentencia.setInt(2, producto.getProductoCodigo());
        return sentencia.executeUpdate();
    }

}
