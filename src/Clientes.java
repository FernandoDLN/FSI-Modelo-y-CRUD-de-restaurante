
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ferna
 */
public class Clientes {

    static String todos = "SELECT * FROM clientes ORDER BY codigoc";
    static String codigosc = "SELECT codigoc FROM clientes ORDER BY codigoc";

    String codigo_c, nombrec, rfc;

    public Clientes() {

    }

    public Clientes(String codigo_c, String nombrec, String rfc) {
        this.codigo_c = codigo_c;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO clientes VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo_c);
            ps.setString(2, nombrec);
            ps.setString(3, rfc);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Errror:" + e.getLocalizedMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM clientes WHERE codigoc =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo_c);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setString(3, codigo_c);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
