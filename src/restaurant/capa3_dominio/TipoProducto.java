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
public class TipoProducto {

    private int tipoProductoCodigo;
    private String tipoProductoNombre;
    private String tipoProductoDescripcion;
    private String tipoProductoEstado;

    public TipoProducto() {
    }

    
    
    
    
    
    public TipoProducto(int tipoProductoCodigo, String tipoProductoNombre, String tipoProductoDescripcion, String tipoProductoEstado) {
        this.tipoProductoCodigo = tipoProductoCodigo;
        this.tipoProductoNombre = tipoProductoNombre;
        this.tipoProductoDescripcion = tipoProductoDescripcion;
        this.tipoProductoEstado = tipoProductoEstado;
    }

    public int getTipoProductoCodigo() {
        return tipoProductoCodigo;
    }

    public void setTipoProductoCodigo(int tipoProductoCodigo) {
        this.tipoProductoCodigo = tipoProductoCodigo;
    }

    public String getTipoProductoNombre() {
        return tipoProductoNombre;
    }

    public void setTipoProductoNombre(String tipoProductoNombre) {
        this.tipoProductoNombre = tipoProductoNombre;
    }

    public String getTipoProductoDescripcion() {
        return tipoProductoDescripcion;
    }

    public void setTipoProductoDescripcion(String tipoProductoDescripcion) {
        this.tipoProductoDescripcion = tipoProductoDescripcion;
    }

    public String getTipoProductoEstado() {
        return tipoProductoEstado;
    }

    public void setTipoProductoEstado(String tipoProductoEstado) {
        this.tipoProductoEstado = tipoProductoEstado;
    }

}
