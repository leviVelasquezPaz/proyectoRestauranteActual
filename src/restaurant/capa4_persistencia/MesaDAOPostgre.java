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
import restaurant.capa3_dominio.Mesa;
import restaurant.capa3_dominio.Mozo;

/**
 *
 * @author Antonio AB
 */
public class MesaDAOPostgre {

    GestorJDBC gestorJDBC;

    public MesaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public Mesa buscarPorNumero(int numero) throws SQLException {

        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL;
        sentenciaSQL = "SELECT mesacodigo, mesacapacidad, mesanumero, mesapiso, mesaestado\n"
                + "	FROM mesa where mesanumero=" + numero + "";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaCodigo(resultado.getInt("mesaCodigo"));
            mesa.setMesaCapacidad(resultado.getInt("mesaCapacidad"));
            mesa.setMesaNumero(resultado.getInt("mesaNumero"));
            mesa.setMesaPiso(resultado.getInt("mesaPiso"));
            mesa.setMesaEstado(resultado.getString("mesaEstado"));
        }
        resultado.close();
        return mesa;
    }

    public Mesa buscarCodigo(int mesaCodigo) throws SQLException {
        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT mesaCodigo, mesaCapacidad, mesaNumero, mesaPiso, mesaEstado"
                + "FROM Mozo where mesaCodigo= " + mesaCodigo;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaCodigo(resultado.getInt("mesaCodigo"));
            mesa.setMesaCapacidad(resultado.getInt("mesaCapacidad"));
            mesa.setMesaNumero(resultado.getInt("mesaNumero"));
            mesa.setMesaPiso(resultado.getInt("mesaPiso"));
            mesa.setMesaEstado(resultado.getString("mesaEstado"));
        }
        resultado.close();
        return mesa;
    }

//
//    public Mozo buscarPorDNI(String dni) throws SQLException {
//        Mozo lector = null;
//        Prestamo prestamo = null;
//        ResultSet resultadoLector, resultadoPrestamos;
//        String sentenciaSQL;
//
//        sentenciaSQL = "select lectorid, nombre, dni, fechapenalizada, direccion, correoe "
//                + "from lector where dni = '" + dni + "'";
//
//        resultadoLector = gestorJDBC.ejecutarConsulta(sentenciaSQL);
//        if (resultadoLector.next()) {
//            lector = new Lector();
//            lector.setLectorid(resultadoLector.getInt("lectorid"));
//            lector.setNombre(resultadoLector.getString("nombre"));
//            lector.setDni(resultadoLector.getString("dni"));
//            lector.setFechapenalizada(resultadoLector.getDate("fechapenalizada"));
//            lector.setDireccion(resultadoLector.getString("direccion"));
//            lector.setCorreoe(resultadoLector.getString("correoe"));
//        }
//        resultadoLector.close();
//
//        if (lector != null) {
//            sentenciaSQL = "select fechalimite from prestamo "
//                    + "where lectorid = " + lector.getLectorid() + " and fechadevolucion is null";
//            resultadoPrestamos = gestorJDBC.ejecutarConsulta(sentenciaSQL);
//            while (resultadoPrestamos.next()) {
//                prestamo = new Prestamo();
//                prestamo.setFechalimite(resultadoPrestamos.getDate("fechalimite"));
//                lector.agregarPrestamoVigente(prestamo);
//            }
//            resultadoPrestamos.close();
//        }
//        return lector;
//    }
    public int ingresar(Mesa mesa) throws SQLException {
        String sentenciaSQL = "INSERT INTO Mesa (mesaCodigo, mesaCapacidad, mesaNumero, mesaPiso, mesaEstado)"
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mesa.getMesaCodigo());
        sentencia.setInt(2, mesa.getMesaCapacidad());
        sentencia.setInt(3, mesa.getMesaNumero());
        sentencia.setInt(4, mesa.getMesaPiso());
        sentencia.setString(5, mesa.getMesaEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(Mesa mesa) throws SQLException {
        String sentenciaSQL = "UPDATE mesa SET mesacapacidad=?, mesanumero=?, mesapiso=?, mesaestado=? WHERE mesacodigo=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mesa.getMesaCapacidad());
        sentencia.setInt(2, mesa.getMesaNumero());
        sentencia.setInt(3, mesa.getMesaPiso());
        sentencia.setString(4, mesa.getMesaEstado());
        sentencia.setInt(5, mesa.getMesaCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(Mozo mozo) throws SQLException {
        String sentenciaSQL = "delete from Mesa where mesaCodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mozo.getMozoCodigo());
        return sentencia.executeUpdate();
    }

}
