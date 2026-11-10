
import java.sql.*;

public class Clientes {

    static String todos = "SELECT * FROM clientes ORDER BY nombrec DESC";
    static String codigos = "SELECT codigo FROM clientes ORDER BY codigo";
    String codigo, nombrec, rfc;

    public Clientes() {

    }

    public Clientes(String codigo, String nombrec, String rfc) {
        this.codigo = codigo;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO clientes VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, codigo);
            ps.setString(2, nombrec);
            ps.setString(3, rfc);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM clientes WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setString(3, codigo);

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return resultado;
        }
    }
}
