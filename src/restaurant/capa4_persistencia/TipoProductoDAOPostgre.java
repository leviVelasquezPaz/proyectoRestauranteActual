/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.capa4_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import restaurant.capa3_dominio.TipoProducto;

/**
 *
 * @author Antonio AB
 */
public class TipoProductoDAOPostgre {

    GestorJDBC gestorJDBC;

    public TipoProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public TipoProducto buscar(int tipoProductoCodigo) throws SQLException {
        TipoProducto tipoProducto = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT * FROM tipoproducto where tipoproductocodigo= " + tipoProductoCodigo;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            tipoProducto = new TipoProducto();
            tipoProducto.setTipoProductoCodigo(resultado.getInt("tipoproductocodigo"));
            tipoProducto.setTipoProductoNombre(resultado.getString("tipoproductonombre"));
            tipoProducto.setTipoProductoDescripcion(resultado.getString("tipoproductodescripcion"));
            tipoProducto.setTipoProductoEstado(resultado.getString("tipoproductoestado"));

        }
        resultado.close();
        return tipoProducto;
    }

    public List<TipoProducto> mostrar() throws SQLException {

        List<TipoProducto> listaProductos = new ArrayList<>();
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT tipoproductocodigo, tipoproductonombre, tipoproductodescripcion, tipoproductoestado from tipoproducto";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto.setTipoProductoCodigo(resultado.getInt("tipoproductocodigo"));
            tipoProducto.setTipoProductoNombre(resultado.getString("tipoproductonombre"));
            tipoProducto.setTipoProductoDescripcion(resultado.getString("tipoproductodescripcion"));
            tipoProducto.setTipoProductoEstado(resultado.getString("tipoproductoestado"));
            listaProductos.add(tipoProducto);

        }
        resultado.close();
        return listaProductos;
    }

}
