/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa2_aplicacion;

import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.Cliente;
import restaurant.capa3_dominio.LineaPedido;
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Mozo;
import restaurant.capa3_dominio.Pedido;
import restaurant.capa3_dominio.Producto;
import restaurant.capa3_dominio.TipoProducto;
import restaurant.capa4_persistencia.ClienteDAOPostgre;
import restaurant.capa4_persistencia.GestorJDBC;
import restaurant.capa4_persistencia.GestorJDBCPostgre;
import restaurant.capa4_persistencia.MesaDAOPostgre;
import restaurant.capa4_persistencia.MozoDAOPostgre;
import restaurant.capa4_persistencia.PedidoDAOPostgre;
import restaurant.capa4_persistencia.ProductoDAOPostgre;
import restaurant.capa4_persistencia.TipoProductoDAOPostgre;

/**
 *
 * @author Antonio AB
 */
public class RegistrarPedidoServicio {

    private GestorJDBC gestorJDBC;
    private PedidoDAOPostgre pedidoDAOPostgre;
    private MozoDAOPostgre mozoDAOPostgre;
    private TipoProductoDAOPostgre tipoProductoDAOPostgre;

    private ClienteDAOPostgre clienteDAOPostgre;
    private MesaDAOPostgre mesaDAOPostgre;

    public RegistrarPedidoServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        pedidoDAOPostgre = new PedidoDAOPostgre(gestorJDBC);
        mozoDAOPostgre = new MozoDAOPostgre(gestorJDBC);
        mesaDAOPostgre = new MesaDAOPostgre(gestorJDBC);
        tipoProductoDAOPostgre = new TipoProductoDAOPostgre(gestorJDBC);
        clienteDAOPostgre = new ClienteDAOPostgre(gestorJDBC);
    }

    public Mozo buscarMozoDNI(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        Mozo mozo = mozoDAOPostgre.buscarPorDNI(dni);
        gestorJDBC.cerrarConexion();
        return mozo;
    }

    public Mesa buscarMesa(int numero) throws Exception {
        gestorJDBC.abrirConexion();
        Mesa mesa = mesaDAOPostgre.buscarPorNumero(numero);
        if (mesa != null) {
            if (mesa.getMesaEstado().equals(Mesa.ESTADO_NO_DISPONIBLE)) {
                JOptionPane.showMessageDialog(null, "La mesa no esta disponible");
                mesa = null;
            } else if (mesa.getMesaEstado().equals(Mesa.ESTADO_OCUPADO)) {
                JOptionPane.showMessageDialog(null, "mesa  ocupada ");
                mesa = null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "La mesa no existe");
        }

        gestorJDBC.cerrarConexion();
        return mesa;
    }

    public List<TipoProducto> mostrarTipoProducto() throws Exception {
        gestorJDBC.abrirConexion();
        List<TipoProducto> listaTipoProducto = tipoProductoDAOPostgre.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }

    public Cliente bsucarClientePorDNI(String dni) throws Exception {
        Cliente cliente = null;

        gestorJDBC.abrirConexion();
        cliente = clienteDAOPostgre.buscarDni(dni);
        gestorJDBC.cerrarConexion();

        return cliente;
    }

    public int crearPedido(Pedido pedido) throws Exception {

        gestorJDBC.abrirConexion();
        List<LineaPedido> listaPedidos = pedido.getListaLineaPedido();
        try {
            gestorJDBC.iniciarTransaccion();
            for (LineaPedido lineaPedido : listaPedidos) {
                Producto producto = lineaPedido.getProducto();
                producto.restarStock(lineaPedido.getCantidad());
            }

            int resgistros_afectador = pedidoDAOPostgre.ingresar(pedido);
            gestorJDBC.terminarTransaccion();
            return resgistros_afectador;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }

    }

    public List<Pedido> listadoPedidos() throws Exception {
        try {
            gestorJDBC.abrirConexion();
            List<Pedido> listaPedidos = pedidoDAOPostgre.listaPedidos();
            gestorJDBC.cerrarConexion();
            return listaPedidos;
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

//      public List<Cliente> listaClientes() throws Exception{
//        gestorJDBC.abrirConexion();
//        List<Cliente> listaClientes = clienteDAOPostgre.();
//        gestorJDBC.cerrarConexion();
//        return listaClientes;
//    }
    public Pedido buscarPedido(int idPedido) throws Exception {
        gestorJDBC.abrirConexion();
        Pedido pedido = pedidoDAOPostgre.buscarPedido(idPedido);
        gestorJDBC.cerrarConexion();
        return pedido;
    }
}
