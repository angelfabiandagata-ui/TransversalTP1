package Persistencia;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import org.mariadb.jdbc.client.result.Result;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

//Atributos alumnodatos
public class AlumnoDatos {

    private Connection con = null;

    public AlumnoDatos(Connection conexion) {
        this.con = conexion;
    }

    public void guardarAlumno(Alumno a) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(a.getFechadenacimiento()));
            ps.setBoolean(5, a.getEstado());

            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno guardado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al guardar alumno: " + ex.getMessage());
        }
    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado` FROM `alumno` WHERE `idAlumno` = ?";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                System.out.println("Id: " + resultado.getInt("idAlumno"));
                System.out.println("Dni:" + resultado.getInt("dni"));
                System.out.println("Apellido: " + resultado.getString("apellido"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Fecha nacimiento: " + resultado.getDate("FechaNacimiento"));
                System.out.println("-----------------------------------------------------------");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Alumno no encontrado");
        }
        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        String sql = "SELECT * FROM `alumno` WHERE `estado` = true";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                System.out.println("Id: " + resultado.getInt("idAlumno"));
                System.out.println("Dni:" + resultado.getInt("dni"));
                System.out.println("Apellido: " + resultado.getString("apellido"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Fecha nacimiento: " + resultado.getDate("FechaNacimiento"));
                System.out.println("-----------------------------------------------------------");
            }

        } catch (SQLException ex) {
            System.out.println("");
        }

        return null;
    }

    public void actualizarAlumno(Alumno alumno) {
        try {
            String sql = "UPDATE `alumno` SET dni = ?,apellido= ?,nombre=?,fechaNacimiento=? WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(alumno.getFechadenacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno actualizado correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el alumno" + ex.getMessage()
            );
        }

    }

    public void bajaLogica(int id) {
        try {
            String sql = "UPDATE `alumno` SET `estado`='0' WHERE `idAlumno` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno dado de baja correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al dar de baja el alumno" + ex.getMessage()
            );
        }
    }

    public void altaLogica(int id) {
        try {
            String sql = "UPDATE `alumno` SET `estado`='1' WHERE `idAlumno` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno dado de alta correctamente!!");
        } catch (SQLException ex) {
            System.out.println("Error al dar de alta el alumno" + ex.getMessage()
            );
        }
    }

    public void borrarAlumno(int id) {
        try {
            String sql = "DELETE FROM `alumno` WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Alumno borrado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al borrar el alumno" + ex.getMessage());
        }

    }
}
