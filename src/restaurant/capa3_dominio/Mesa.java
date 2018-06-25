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
public class Mesa {

    private int mesaCodigo;
    private int mesaCapacidad;
    private int mesaNumero;
    private int mesaPiso;
    private String mesaEstado;

    public static final String ESTADO_DISPONIBLE = "A";
    public static final String ESTADO_NO_DISPONIBLE = "I";
    public static final String ESTADO_OCUPADO = "O";

    public Mesa() {
    }

    public Mesa(int mesaCodigo, int mesaCapacidad, int mesaNumero, int mesaPiso, String mesaEstado) {
        this.mesaCodigo = mesaCodigo;
        this.mesaCapacidad = mesaCapacidad;
        this.mesaNumero = mesaNumero;
        this.mesaPiso = mesaPiso;
        this.mesaEstado = mesaEstado;
    }

    public int getMesaCodigo() {
        return mesaCodigo;
    }

    public void setMesaCodigo(int mesaCodigo) {
        this.mesaCodigo = mesaCodigo;
    }

    public int getMesaCapacidad() {
        return mesaCapacidad;
    }

    public void setMesaCapacidad(int mesaCapacidad) {
        this.mesaCapacidad = mesaCapacidad;
    }

    public int getMesaNumero() {
        return mesaNumero;
    }

    public void setMesaNumero(int mesaNumero) {
        this.mesaNumero = mesaNumero;
    }

    public int getMesaPiso() {
        return mesaPiso;
    }

    public void setMesaPiso(int mesaPiso) {
        this.mesaPiso = mesaPiso;
    }

    public String getMesaEstado() {
        return mesaEstado;
    }

    public void setMesaEstado(String mesaEstado) {
        this.mesaEstado = mesaEstado;
    }

    public boolean estaDisponible() {
        boolean estado = false;
        if (mesaEstado == ESTADO_DISPONIBLE) {
            estado = true;
        }
        return estado;
    }

}
