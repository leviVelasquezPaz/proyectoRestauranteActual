/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Antonio AB
 */
public class Pedido {

    private int pedidoCodigo;
    private Double importe;
    private Mozo mozo;
    private Mesa mesa;
    private Cliente cliente;
    private Date pedidoFecha;
    private String pedidoEstado;
    private List<LineaPedido> listaLineaPedido;
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";

    public Pedido() {
        listaLineaPedido = new ArrayList<>();
    }

    public Pedido(int pedidoCodigo, Double importe, Mozo mozo, Mesa mesa, Cliente cliente, Date pedidoFecha, String pedidoEstado) {
        this.pedidoCodigo = pedidoCodigo;
        this.importe = importe;
        this.mozo = mozo;
        this.mesa = mesa;
        this.cliente = cliente;
        this.pedidoFecha = pedidoFecha;
        this.pedidoEstado = pedidoEstado;
        listaLineaPedido = new ArrayList<>();
    }

    public int getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(int pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getPedidoFecha() {
        return pedidoFecha;
    }

    public void setPedidoFecha(Date pedidoFecha) {
        this.pedidoFecha = pedidoFecha;
    }

    public String getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(String pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public List<LineaPedido> getListaLineaPedido() {
        return listaLineaPedido;
    }

    public void setListaLineaPedido(List<LineaPedido> listaLineaPedido) {
        this.listaLineaPedido = listaLineaPedido;
    }

    ///reglas de negocion
    public boolean agregarLineaPedido(int cantidad, Producto producto) {
        if (producto.stockDisponible(cantidad)) {
            LineaPedido lineaPedido = new LineaPedido();
            lineaPedido.setCantidad(cantidad);
            lineaPedido.setProducto(producto);
            lineaPedido.setEstado(LineaPedido.ESTADO_ACTIVO);
            listaLineaPedido.add(lineaPedido);
            return true;
        } else {
            return false;
        }

    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido lineaPedido : listaLineaPedido) {
            total += lineaPedido.calcularSubTotal();
        }
        return total;
    }

}
