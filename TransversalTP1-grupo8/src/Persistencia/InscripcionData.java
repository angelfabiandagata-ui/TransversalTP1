/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import Modelo.Inscripcion;
import java.util.List;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author user
 */
public class InscripcionData {

    private Connection con = null;

    public InscripcionData(Connection conexion) {
        this.con = conexion;
    }

//    public void guardarInscripcion(Inscripcion insc) {
//
//    }
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
//    public void actualizarNota(int idAlumno, int idMateria, double nota) {
//
//    }
//    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
//
//    }

}
