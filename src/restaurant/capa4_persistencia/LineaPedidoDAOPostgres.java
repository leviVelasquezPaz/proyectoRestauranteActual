/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa4_persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import restaurant.capa3_dominio.LineaPedido;
import restaurant.capa3_dominio.Producto;

/**
 *
 * @author Antonio AB
 */
public class LineaPedidoDAOPostgres {

    GestorJDBC gestorJDBC;

    public LineaPedidoDAOPostgres(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public LineaPedido buscar(int lineapedidoCodigo) throws SQLException {
        LineaPedido lineaPedido = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "Select lineaPedidoCodigo, lineaPedidoCantidad,ProductoCodigo,lineaPeidoCodigoEstado"
                + "from lineapedido where lineaPedidoCodigo= " + lineapedidoCodigo;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            lineaPedido = new LineaPedido();
            lineaPedido.setLineaPedidoCodigo(resultado.getInt("lineaPedidoCodigo"));
            lineaPedido.setCantidad(resultado.getInt("lineaPedidoCantidad"));
            ProductoDAOPostgre productoDAOPostgre = new ProductoDAOPostgre(gestorJDBC);
            Producto producto = productoDAOPostgre.buscar(resultado.getInt("ProductoCodigo"));
            lineaPedido.setProducto(producto);
            lineaPedido.setEstado(resultado.getString("lineaPeidoCodigoEstado"));

        }
        resultado.close();
        return lineaPedido;
    }

    public int obtenerUltimoCodigo() throws SQLException {

        ResultSet resultado;
        String sentenciaSQL;
        int codigo = -1;
        sentenciaSQL = "Select  max(linepedidocodigo) as codigo from lineapedido ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            codigo = (resultado.getInt("codigo"));

        }
        resultado.close();
        return codigo;
    }

    public int ingresar(LineaPedido lineaPedido) throws SQLException {
        String sentenciaSQL = "INSERT INTO LineaPedido(lineaPedidoCodigo, lineaPedidoCantidad, ProductoCodigo, lineaPedidoCodigoEstado)"
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, lineaPedido.getLineaPedidoCodigo());
        sentencia.setInt(2, lineaPedido.getCantidad());
        sentencia.setInt(3, lineaPedido.getProducto().getProductoCodigo());
        sentencia.setString(4, lineaPedido.getEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(LineaPedido lineaPedido) throws SQLException {
        String sentenciaSQL = "UPDATE LineaPedido SET lineaPedidoCantidad=?, ProductoCodigo=?, lineaPedidoCodigoEstado=? where lineaPedidoCodigo=?";

        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, lineaPedido.getCantidad());
        sentencia.setInt(2, lineaPedido.getProducto().getProductoCodigo());
        sentencia.setString(3, lineaPedido.getEstado());
        sentencia.setInt(4, lineaPedido.getLineaPedidoCodigo());

        return sentencia.executeUpdate();
    }

    public int eliminar(LineaPedido lineaPedido) throws SQLException {
        String sentenciaSQL = "delete from LineaPedido where lineaPedidoCodigo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, lineaPedido.getLineaPedidoCodigo());
        return sentencia.executeUpdate();
    }

}
