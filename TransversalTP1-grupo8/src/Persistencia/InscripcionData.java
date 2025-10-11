/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import Modelo.Inscripcion;
import java.security.interfaces.RSAKey;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author user
 */
public class InscripcionData {

    private Connection con = null;

    public InscripcionData(Connection conexion) {
        this.con = conexion;
    }

   public void guardarInscripcion(Inscripcion insc) { 
       String sql = "INSERT INTO inscripcion(idAlumno,idMateria, nota) VALUES (?,?,?)";
       try {
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, insc.getAlumno().getIdAlumno());
           ps.setInt(2, insc.getMateria().getIdmateria());
           ps.setDouble(3, insc.getNota());
           ps.executeUpdate();
           ResultSet rs = ps.getGeneratedKeys();
           if (rs.next()) {
               insc.setIdInscripcion(rs.getInt(1));
               System.out.println("Inscripto registrada");
           }
           rs.close();
           ps.close();
       } catch (SQLException ex) {
           System.out.println("Ocurrio un error al inscribir" + ex.getMessage());
       }
   }
//
//    public List<Inscripcion> obtenerInscripciones() {
//
//    }
//
//    public List<Inscripcion> obtenerinscripcionesPorAlumno(int id) {
//
//    }
//    public List<Materia> obtenerMateriasCursadas(int id) {
//
//    }
//
//    public List<Materia> obtenerMateriasNOCursadas(int id) {
//
//    }
//
//    public void borrarinscripcionMateriaAlumno(int idAlumno, int idMateria) {
//
//    }
//
    public void actualizarNota(int idAlumno, int idMateria, double nota) {

   
        try {
            String sql = "UPDATE `inscripcion` SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int resultado = ps.executeUpdate();
            
            if(resultado > 0){
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }else{
             JOptionPane.showMessageDialog(null, "No se actualizo ninguna nota");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erorr al hacer conexion");
        }
    //fin acNot
    }
//    
   
//    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
//
//    }

}
