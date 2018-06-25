/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa3_dominio;

/**
 *
 * @author Antonio AB
 */
public class LineaPedido {

    private int lineaPedidoCodigo;
    private int cantidad;
    private Producto Producto;
    private String estado;
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";

    public LineaPedido() {
    }

    public int getLineaPedidoCodigo() {
        return lineaPedidoCodigo;
    }

    public void setLineaPedidoCodigo(int lineaPedidoCodigo) {
        this.lineaPedidoCodigo = lineaPedidoCodigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //reglas de negocio
    public double calcularSubTotal() {
        return cantidad * Producto.getProductoPrecio();
    }

}
