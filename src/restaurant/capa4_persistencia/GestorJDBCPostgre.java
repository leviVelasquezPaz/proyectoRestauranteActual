package restaurant.capa4_persistencia;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Lain
 */
public class GestorJDBCPostgre extends GestorJDBC {

    @Override
    public void abrirConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/BaseRestaurant";
            conexion = DriverManager.getConnection(url, "postgres", "123");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
