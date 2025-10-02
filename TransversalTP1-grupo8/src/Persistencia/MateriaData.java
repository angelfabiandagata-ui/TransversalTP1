/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Atributos
public class MateriaData {
    private int idMateria;
    private String Materia;
//Constructor
    public MateriaData(int idMateria, String Materia) {
        this.idMateria = idMateria;
        this.Materia = Materia;
    }
//Getter and setter
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    @Override
    public String toString() {
        return "MateriaData" + "idMateria:" + idMateria + ", Materia:" + Materia;
    }
}
    
//     private Connection con = null;
//
//    public MateriaData (Connection conexion) {
//        this.con = conexion;
//    }
//
//    public void guardarMateria(materia a) {
//        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, a.getDni());
//            ps.setString(2, a.getApellido());
//            ps.setString(3, a.getNombre());
//            ps.setDate(4, java.sql.Date.valueOf(a.getFechadenacimiento()));
//            ps.setBoolean(5, a.getEstado());
//
//            ps.executeUpdate();
//            ps.close();
//            System.out.println("Alumno guardado con exito");
//        } catch (SQLException ex) {
//            System.out.println("Error al guardar alumno: " + ex.getMessage());
//        }
//    }
//
//    /* public alumno buscarAlumno(int id) {
//
//    }
//     */
//    public List<Alumno> listarAlumnos() {
//        String sql = "SELECT * FROM `alumno` WHERE `estado` = true";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet resultado = ps.executeQuery();
//
//            while (resultado.next()) {
//                System.out.println("Id: " + resultado.getInt("idAlumno"));
//                System.out.println("Dni:" + resultado.getInt("dni"));
//                System.out.println("Apellido: " + resultado.getString("apellido"));
//                System.out.println("Nombre: " + resultado.getString("nombre"));
//                System.out.println("Fecha nacimiento: " + resultado.getDate("FechaNacimiento"));
//                System.out.println("-----------------------------------------------------------");
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("");
//        }
//
//        return null;
//    }
//
//    /*
//    public void actualizarAlumno(Alumno a) {
//
//    }
//     */
//   public void bajaLogica(int id){
//       try {
//           String sql = "UPDATE `alumno` SET `estado`='0' WHERE `idAlumno` = ?";
//           PreparedStatement ps = con.prepareStatement(sql);
//           ps.setInt(1, id);
//           ps.executeUpdate();
//           ps.close();
//           System.out.println("Alumno dado de baja correctamente!!");
//       } catch (SQLException ex) {
//           System.out.println("Error al dar de baja el alumno" + ex.getMessage()
//           );
//       }
//}
//        public void altaLogica(int id){
//              try {
//           String sql = "UPDATE `alumno` SET `estado`='1' WHERE `idAlumno` = ?";
//           PreparedStatement ps = con.prepareStatement(sql);
//           ps.setInt(1, id);
//           ps.executeUpdate();
//           ps.close();
//           System.out.println("Alumno dado de alta correctamente!!");
//       } catch (SQLException ex) {
//           System.out.println("Error al dar de alta el alumno" + ex.getMessage()
//           );
//       }
//}
//    public void borrarMateria(int id) {
//        try {
//            String sql = "DELETE FROM `materia` WHERE idAlumno = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            ps.close();
//            System.out.println("Alumno borrado con exito");
//        } catch (SQLException ex) {
//            System.out.println("Error al borrar el alumno" + ex.getMessage());
//        }
//
//    }

   
