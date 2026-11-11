
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ferna
 */
public class Mesa {

    static String todos = "SELECT * FROM mesas ORDER BY numero";
    static String num_mesas = "SELECT numero FROM mesas ORDER BY numero";

    String numero, estadom, capacidad;

    public Mesa() {

    }

    public Mesa(String numero, String estadom, String capacidad) {
        this.numero = numero;
        this.estadom = estadom;
        this.capacidad = capacidad;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO mesas VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, numero);
            ps.setString(2, estadom);
            ps.setString(3, capacidad);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Errror:" + e.getLocalizedMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM mesas WHERE numero =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, numero);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE mesas SET estadom = ?, capacidad = ? WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estadom);
            ps.setString(2, capacidad);
            ps.setString(3, numero);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
