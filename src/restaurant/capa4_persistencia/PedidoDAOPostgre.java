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
import restaurant.capa3_dominio.Cliente;
import restaurant.capa3_dominio.LineaPedido;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Mozo;
import restaurant.capa3_dominio.Pedido;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class PedidoDAOPostgre {

    GestorJDBC gestorJDBC;

    public PedidoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int ingresar(Pedido pedido) throws SQLException {
        int registros_afectados;
        int resgistro_afectado_mesa = -1;
        pedido.getMesa().setMesaEstado(Mesa.ESTADO_OCUPADO);
        String sentenciaSQL = "INSERT INTO pedido (pedidocodigo, mozocodigo, mesacodigo, clientecodigo,pedidofecha, pedidoestado)"
                + "	VALUES (?, ?, ?, ?, ?, ?)";
        String sentenciaSQLlineaDePedido = "INSERT INTO lineapedido(linepedidocodigo, lineapedidocantidad, productocodigo, lineapedidoestado, lineapedidoprecio) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, obtenerUltimoCodigo() + 1);
            sentencia.setInt(2, pedido.getMozo().getMozoCodigo());
            sentencia.setInt(3, pedido.getMesa().getMesaCodigo());
            sentencia.setInt(4, pedido.getCliente().getClienteCodigo());
            sentencia.setDate(5, pedido.getPedidoFecha());
            sentencia.setString(6, pedido.getPedidoEstado());
            registros_afectados = sentencia.executeUpdate();
            if (registros_afectados == 1) {
                ///ahora pasaremos a ingresar en la table de la base de datos linea pedido 
                for (LineaPedido lineaPedido : pedido.getListaLineaPedido()) {
                    int registros_afectados_lineadepedido = 0;
                    PreparedStatement sentencialineadepedido = gestorJDBC.prepararSentencia(sentenciaSQLlineaDePedido);
                    LineaPedidoDAOPostgres lineaPedidoPostgres = new LineaPedidoDAOPostgres(gestorJDBC);
                    sentencialineadepedido.setInt(1, lineaPedidoPostgres.obtenerUltimoCodigo() + 1);
                    sentencialineadepedido.setInt(2, lineaPedido.getCantidad());
                    sentencialineadepedido.setDouble(3, lineaPedido.getProducto().getProductoCodigo());
                    sentencialineadepedido.setString(4, lineaPedido.getEstado());
                    sentencialineadepedido.setDouble(5, lineaPedido.getProducto().getProductoPrecio());
                    registros_afectados_lineadepedido = sentencialineadepedido.executeUpdate();
                    //---------------  Actualizacion de stock ------------------------------
                    if (registros_afectados_lineadepedido == 1) {
                        //actualizar stock
                        ProductoDAOPostgre productoDAO = new ProductoDAOPostgre(gestorJDBC);
                        productoDAO.actualizarStock(lineaPedido.getProducto());
                        MesaDAOPostgre mesaDAOPostgre = new MesaDAOPostgre(gestorJDBC);
                        mesaDAOPostgre.modificar(pedido.getMesa());

                    }
                }

            }
            return registros_afectados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
    }

    public int obtenerUltimoCodigo() throws SQLException {

        ResultSet resultado;
        String sentenciaSQL;
        int codigo = -1;
        sentenciaSQL = "Select  max(pedidocodigo) as codigo from pedido ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {

            codigo = (resultado.getInt("codigo"));

        }
        resultado.close();
        return codigo;
    }

    public Pedido buscarPedido(int pedidoCodigo) throws SQLException {
        Pedido pedido = null;
        ResultSet resultSetPedido, resultSetLinea;

        String sentenciaSQL_Pedido = "select p.pedidocodigo,p.pedidofecha,p.pedidoestado,p.clientecodigo,p.mesacodigo,p.mozocodigo from Pedido p inner join Mozo mo on p.pedidoCodigo=mo.mozoCodigo"
                + "inner join Mesa me on me.mesaCodigo=p.mesaCodigo inner join Cliente cl on cli.clienteCodigo=p.clienteCodigo"
                + "where p.pedidocodigo=" + pedidoCodigo + "";
        String sentenciaSQL_lineas = "select *from LineaPedido li inner join producto pr on pr.productocodigo=li.productdocodigo"
                + "inner join pedido p on p.pedidocodigo=li.pedidocodigo"
                + "where p.pedidoCodigo=";

        resultSetPedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_Pedido);
        if (resultSetPedido.next()) {
            pedido = new Pedido();
            pedido.setPedidoCodigo(resultSetPedido.getInt("p.pedidocodigo"));
            pedido.setPedidoFecha(resultSetPedido.getDate("p.pedidofecha"));

            ClienteDAOPostgre clienteDAO = new ClienteDAOPostgre(gestorJDBC);
            MesaDAOPostgre mesaDao = new MesaDAOPostgre(gestorJDBC);
            MozoDAOPostgre mozoDAO = new MozoDAOPostgre(gestorJDBC);

            Mesa mesa = mesaDao.buscarCodigo(resultSetPedido.getInt("p.mesadodigo"));
            Mozo mozo = mozoDAO.buscarCodigo(resultSetPedido.getInt("p.mozocodigo"));
            Cliente cliente = clienteDAO.buscarPorCodigo(resultSetPedido.getInt("p.clientecodigo"));

            pedido.setCliente(cliente);
            pedido.setMesa(mesa);
            pedido.setMozo(mozo);

            sentenciaSQL_lineas = sentenciaSQL_lineas + pedido.getPedidoCodigo(); //hasta qui el pedido ya debe tener un id
            resultSetLinea = gestorJDBC.ejecutarConsulta(sentenciaSQL_lineas + pedido.getPedidoCodigo());
            while (resultSetLinea.next()) {
                Producto producto = new Producto();
                producto.setProductoCodigo(resultSetLinea.getInt("productocodigo"));
                producto.setProductoNombre(resultSetLinea.getString("productonombre"));
                producto.setProductoDescripcion(resultSetLinea.getString("productodescripcion"));
                producto.setProdcutoStock(resultSetLinea.getInt("productostock"));
                TipoProductoDAOPostgre tipoProductoDAO = new TipoProductoDAOPostgre(gestorJDBC);
                TipoProducto tipoProducto = tipoProductoDAO.buscar(resultSetLinea.getInt("tipoproductocodigo"));
                producto.setTipoDeProducto(tipoProducto);
                producto.setProductoFechaRegistro(resultSetLinea.getDate("productofecharegistro"));
                producto.setProductoEstado(resultSetLinea.getString("`prodcutoestado"));
            }
        }
        resultSetPedido.close();
        return pedido;

    }

    public List<Pedido> listaPedidos() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList();
        Pedido pedido;
        ResultSet resultado;
        String sentenciaSQL;

        String sentenciaSQL_Pedido = "select p.pedidocdigo,p.pedidofecha,p.pedidoestado,p.clientecodigo,p.mesacodigo,p.mozocodigo from pedido p inner join mozo mo on p.pedidocodigo=mo.mozocodigo "
                + "inner join Cliente cl on cli.clienteCodigo=p.clienteCodigo";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL_Pedido);
        while (resultado.next()) {
            pedido = new Pedido();
            pedido.setPedidoCodigo(resultado.getInt("p.pedidocodigo"));
            pedido.setPedidoFecha(resultado.getDate("p.pedidofecha"));

            ClienteDAOPostgre clienteDAO = new ClienteDAOPostgre(gestorJDBC);
            MozoDAOPostgre mozoDAO = new MozoDAOPostgre(gestorJDBC);

            Mozo mozo = mozoDAO.buscarCodigo(resultado.getInt("p.mozocodigo"));
            Cliente cliente = clienteDAO.buscarPorCodigo(resultado.getInt("p.clientecodigo"));
            pedido.setCliente(cliente);
            pedido.setMozo(mozo);
            pedidos.add(pedido);
        }
        resultado.close();
        return pedidos;
    }

}
