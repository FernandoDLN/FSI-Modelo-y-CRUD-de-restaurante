
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Alimentos {

    static String todos = "SELECT * FROM alimentos ORDER BY idalimentos";
    static String idalimentos = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";

    String id_alimentos, nombre, descripcion, precio, foto, categoria, estado;

    public Alimentos() {

    }

    public Alimentos(String id_alimentos, String nombre, String descripcion, String precio, String foto, String categoria, String estado) {

        this.id_alimentos = id_alimentos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estado = estado;

    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO alimentos VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id_alimentos);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setString(4, precio);
            ps.setString(5, foto);
            ps.setString(6, categoria);
            ps.setString(7, estado);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Errror:" + e.getLocalizedMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM alimentos WHERE idalimentos =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id_alimentos);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, foto = ?, categoria = ?, estado =? WHERE idalimentos = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, precio);
            ps.setString(4, foto);
            ps.setString(5, categoria);
            ps.setString(6, estado);
            ps.setString(7, id_alimentos);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
