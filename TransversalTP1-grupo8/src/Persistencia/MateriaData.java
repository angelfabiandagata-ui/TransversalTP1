package Persistencia;

import Modelo.Alumno;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ema
 */
public class MateriaData {
    
     private Connection con = null;

    public MateriaData (Connection conexion) {
        this.con = conexion;
    }

    public void guardarMateria(Materia a) {
        String sql = "INSERT INTO materia(idMateria, nombre, anio, estado) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdmateria());
            ps.setString(2, a.getNombre());
            ps.setInt(3, a.getAnio());
            ps.setBoolean(4,a.getEstado());
            ps.setBoolean(5, a.getEstado());

            ps.executeUpdate();
            ps.close();
            System.out.println("Materia guardado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al guardar la Materia: " + ex.getMessage());
        }
    }

    public Materia buscarMateria(int id) {
        String sql = "SELECT `idMateria`, `nombre`, `anio`, `estado` FROM `materia` WHERE `idMateria` = ?";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                System.out.println("Id: " + resultado.getInt("idMateria"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Anio: " + resultado.getString("anio"));
                System.out.println("Estado: " + resultado.getBoolean("estado"));
                System.out.println("-----------------------------------------------------------");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Materia no encontrada");
        }
        return materia;
    }
    public void actualizarMateria(Materia materia) {
        try {
            String sql = "UPDATE `materia` SET `nombre`=?,`anio`=?,`estado`=? WHERE idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.getEstado());
            ps.setInt(4, materia.getIdmateria());
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia actualizado correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la materia" + ex.getMessage()
            );
        }

    }
    public List<Materia> listarMaterias() {
        String sql = "SELECT * FROM `materias`";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                System.out.println("idmateria: " + resultado.getInt("idMateria"));
                System.out.println("nombre:" + resultado.getString("nombre"));
                System.out.println("año: " + resultado.getInt("anio"));
                System.out.println("estado: " + resultado.getBoolean("estado"));
                System.out.println("-----------------------------------------------------------");
            }

        } catch (SQLException ex) {
            System.out.println("");
        }

        return null;
    }

    
//    public void actualizarAlumno(Alumno a) {
//
//    }
    
   public void bajaLogica(int id){
       try {
           String sql = "UPDATE `materia` SET `estado`='0' WHERE `idMateria` = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           ps.close();
           System.out.println("Materia dada de baja correctamente!!");
       } catch (SQLException ex) {
           System.out.println("Error al dar de baja la materia" + ex.getMessage()
           );
       }
}
        public void altaLogica(int id){
              try {
           String sql = "UPDATE `materia` SET `estado`='1' WHERE `idMateria` = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           ps.close();
           System.out.println("Materia dada de alta correctamente!!");
       } catch (SQLException ex) {
           System.out.println("Error al dar de alta la materia" + ex.getMessage()
           );
       }
}
    public void borrarMateria(int id) {
        try {
            String sql = "DELETE FROM `materia` WHERE idmateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia borrada con exito");
        } catch (SQLException ex) {
            System.out.println("Error al borrar la materia" + ex.getMessage());
        }

    }
}
   
