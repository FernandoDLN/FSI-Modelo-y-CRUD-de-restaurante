
import java.io.Serializable;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;

public class FMenu implements Serializable{
 private String clave,titulo, descripcion, precio, categoria, estado;
    private ImageIcon cartel;
    public FMenu(String clave, String titulo, String descripcion, String precio, ImageIcon cartel, String categoria, String estado){
        this.clave = clave;
        this.titulo = titulo;
        this.cartel = cartel;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria=categoria;
        this.estado = estado;
    }
   public int insertar(Conexion cnx){
 try{       
 String sql = "INSERT INTO alimentos (idalimentos, nombre, descripcion, precio, foto, categoria, estado) VALUES(?,?,?,?,?,?,?)";
     PreparedStatement ps = cnx.con.prepareStatement(sql);
     ps.setString(1,clave);
     ps.setString(2,titulo);
     ps.setString(3, descripcion);
     ps.setFloat(4, Float.parseFloat(precio));
     ps.setBinaryStream(5, cnx.ImagenBytes(cartel));
     ps.setString(6, categoria);
     ps.setString(7, estado);
     
     return ps.executeUpdate();
 }catch (Exception e){
     System.out.print("error al insertar:"+e.getMessage());
     return 0;
 }
            
    }
    
}
