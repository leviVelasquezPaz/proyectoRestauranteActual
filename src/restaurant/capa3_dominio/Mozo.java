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
public class Mozo {

    private int mozoCodigo;
    private String mozoPaterno;
    private String mozoMaterno;
    private String mozoNombre;
    private String mozoSexo;
    private String mozoDni;
    private String mozoDireccion;
    private String mozoEstado;

    public Mozo() {
    }

    public Mozo(int mozoCodigo, String mozoPaterno, String mozoMaterno, String mozoNombre, String mozoSexo, String mozoDni, String mozoDireccion, String mozoEstado) {
        this.mozoCodigo = mozoCodigo;
        this.mozoPaterno = mozoPaterno;
        this.mozoMaterno = mozoMaterno;
        this.mozoNombre = mozoNombre;
        this.mozoSexo = mozoSexo;
        this.mozoDni = mozoDni;
        this.mozoDireccion = mozoDireccion;
        this.mozoEstado = mozoEstado;
    }

    public int getMozoCodigo() {
        return mozoCodigo;
    }

    public void setMozoCodigo(int mozoCodigo) {
        this.mozoCodigo = mozoCodigo;
    }

    public String getMozoPaterno() {
        return mozoPaterno;
    }

    public void setMozoPaterno(String mozoPaterno) {
        this.mozoPaterno = mozoPaterno;
    }

    public String getMozoMaterno() {
        return mozoMaterno;
    }

    public void setMozoMaterno(String mozoMaterno) {
        this.mozoMaterno = mozoMaterno;
    }

    public String getMozoNombre() {
        return mozoNombre;
    }

    public void setMozoNombre(String mozoNombre) {
        this.mozoNombre = mozoNombre;
    }

    public String getMozoSexo() {
        return mozoSexo;
    }

    public void setMozoSexo(String mozoSexo) {
        this.mozoSexo = mozoSexo;
    }

    public String getMozoDni() {
        return mozoDni;
    }

    public void setMozoDni(String mozoDni) {
        this.mozoDni = mozoDni;
    }

    public String getMozoDireccion() {
        return mozoDireccion;
    }

    public void setMozoDireccion(String mozoDireccion) {
        this.mozoDireccion = mozoDireccion;
    }

    public String getMozoEstado() {
        return mozoEstado;
    }

    public void setMozoEstado(String mozoEstado) {
        this.mozoEstado = mozoEstado;
    }

}
