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
public class Cliente {

    private int clienteCodigo;
    private String clientePaterno;
    private String clienteMaterno;
    private String clienteNombre;
    private String clienteDni;
    private String clienteEstado;

    public Cliente() {
    }

    public Cliente(int clienteCodigo, String clientePaterno, String clienteMaterno, String clienteNombre, String clienteDni, String clienteEstado) {
        this.clienteCodigo = clienteCodigo;
        this.clientePaterno = clientePaterno;
        this.clienteMaterno = clienteMaterno;
        this.clienteNombre = clienteNombre;
        this.clienteDni = clienteDni;
        this.clienteEstado = clienteEstado;
    }

    public int getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(int clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public String getClientePaterno() {
        return clientePaterno;
    }

    public void setClientePaterno(String clientePaterno) {
        this.clientePaterno = clientePaterno;
    }

    public String getClienteMaterno() {
        return clienteMaterno;
    }

    public void setClienteMaterno(String clienteMaterno) {
        this.clienteMaterno = clienteMaterno;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    public String getClienteEstado() {
        return clienteEstado;
    }

    public void setClienteEstado(String clienteEstado) {
        this.clienteEstado = clienteEstado;
    }

}
