package Persistencia;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
            System.out.println("Alumno guardado con éxito");
        } catch (SQLException ex) {
            System.out.println("Error al guardar alumno: " + ex.getMessage());
        }
    }

    /* public alumno buscarAlumno(int id) {

    }

    public List<Alumno> listarAlumnos() {

    }

    public void actualizarAlumno(Alumno a) {

    }
     */
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
