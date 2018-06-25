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
import restaurant.capa3_dominio.Mozo;

/**
 *
 * @author Antonio AB
 */
public class MozoDAOPostgre {

    GestorJDBC gestorJDBC;

    public MozoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public List<Mozo> buscarNombre(String nombre) throws SQLException {
        ArrayList<Mozo> listaMozos = new ArrayList();
        Mozo mozo;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT mozoSexo, mozoPaterno, mozoNombre, mozoMaterno, mozoDni, mozoDireccion, mozoCodigo, mozoEstado"
                + "	FROM Mozo where mozoNombre like '%" + nombre + "%' order by mozoNombre";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            mozo = new Mozo();
            mozo.setMozoCodigo(resultado.getInt("mozoCodigo"));
            mozo.setMozoPaterno(resultado.getString("mozoPaterno"));
            mozo.setMozoMaterno(resultado.getString("mozoMaterno"));
            mozo.setMozoNombre(resultado.getString("fechapenalizada"));
            mozo.setMozoSexo(resultado.getString("mozoSexo"));
            mozo.setMozoDireccion(resultado.getString("mozoDireccion"));
            mozo.setMozoDni(resultado.getString("mozoDni"));
            mozo.setMozoEstado(resultado.getString("mozoEstado"));
            listaMozos.add(mozo);
        }
        resultado.close();
        return listaMozos;
    }

    public Mozo buscarPorDNI(String dni) throws Exception {
        Mozo mozo = null;

        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT mozopaterno, mozomaterno, mozonombre, mozodni, mozodireccion, mozocodigo, mozoestado FROM mozo where mozodni= '" + dni + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mozo = new Mozo();
            mozo.setMozoCodigo(resultado.getInt("mozocodigo"));
            mozo.setMozoPaterno(resultado.getString("mozopaterno"));
            mozo.setMozoMaterno(resultado.getString("mozomaterno"));
            mozo.setMozoNombre(resultado.getString("mozonombre"));
            mozo.setMozoDireccion(resultado.getString("mozodireccion"));
            mozo.setMozoDni(resultado.getString("mozodni"));
            mozo.setMozoEstado(resultado.getString("mozoestado"));
        }
        resultado.close();

        return mozo;
    }

    public Mozo buscarCodigo(int mozoId) throws SQLException {
        Mozo mozo = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT mozoSexo, mozoPaterno, mozoNombre, mozoMaterno, mozoDni, mozoDireccion, mozoCodigo, mozoEstado"
                + "	FROM Mozo where mozoCodigo= " + mozoId;

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mozo = new Mozo();
            mozo.setMozoCodigo(resultado.getInt("mozoCodigo"));
            mozo.setMozoPaterno(resultado.getString("mozoPaterno"));
            mozo.setMozoMaterno(resultado.getString("mozoMaterno"));
            mozo.setMozoNombre(resultado.getString("fechapenalizada"));
            mozo.setMozoSexo(resultado.getString("mozoSexo"));
            mozo.setMozoDireccion(resultado.getString("mozoDireccion"));
            mozo.setMozoDni(resultado.getString("mozoDni"));
            mozo.setMozoEstado(resultado.getString("mozoEstado"));
        }
        resultado.close();
        return mozo;
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
    public int ingresar(Mozo mozo) throws SQLException {
        String sentenciaSQL = "INSERT INTO Mozo(mozoCodigo, mozoSexo, mozoPaterno, mozoNombre, mozoMaterno, mozoDni, mozoDireccion, mozoEstado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mozo.getMozoCodigo());
        sentencia.setString(2, mozo.getMozoSexo());
        sentencia.setString(3, mozo.getMozoPaterno());
        sentencia.setString(4, mozo.getMozoMaterno());
        sentencia.setString(5, mozo.getMozoNombre());
        sentencia.setString(6, mozo.getMozoDni());
        sentencia.setString(2, mozo.getMozoDireccion());
        sentencia.setString(2, mozo.getMozoEstado());
        return sentencia.executeUpdate();
    }

    public int modificar(Mozo mozo) throws SQLException {
        String sentenciaSQL = "UPDATE Mozo SET mozoSexo=?, mozoPaterno=?, mozoNombre=?, mozoMaterno=?, mozoDni=?, mozoDireccion=?, mozoCodigo=?, mozoEstado=? WHERE mozoCodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);

        sentencia.setString(1, mozo.getMozoSexo());
        sentencia.setString(2, mozo.getMozoPaterno());
        sentencia.setString(3, mozo.getMozoMaterno());
        sentencia.setString(4, mozo.getMozoNombre());
        sentencia.setString(5, mozo.getMozoDni());
        sentencia.setString(6, mozo.getMozoDireccion());
        sentencia.setString(7, mozo.getMozoEstado());
        sentencia.setInt(8, mozo.getMozoCodigo());
        return sentencia.executeUpdate();
    }

    public int eliminar(Mozo mozo) throws SQLException {
        String sentenciaSQL = "delete from Mozo where mozoCodigo= ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, mozo.getMozoCodigo());
        return sentencia.executeUpdate();
    }

}
