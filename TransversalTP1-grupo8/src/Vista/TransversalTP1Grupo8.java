package Vista;

import Modelo.Alumno;
import Modelo.Conexion;
import Modelo.Materia;
import Persistencia.AlumnoDatos;
import Persistencia.MateriaData;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class TransversalTP1Grupo8 {

    public static void main(String[] args) {
        
        Menu pantalla = new Menu();
        pantalla.setVisible(true);
        Conexion c = new Conexion("jdbc:mariadb://localhost:3306/sgulp_equipo_8", "root", "");
        Connection con = c.buscarConexion();
        AlumnoDatos al = new AlumnoDatos(con);
        
        
        //CREACION DE ALUMNOS
        Alumno alumno1 = new Alumno(47267078, "Serrano", "Lucas", LocalDate.of(2006, Month.MARCH, 31), true);
        
        Alumno alumno2 = new Alumno(36881187, "D'Agata", "Fabian", LocalDate.of(1991, Month.NOVEMBER, 29), true);
        
        Alumno alumno3 = new Alumno(45886408, "Amaya", "Leandro", LocalDate.of(2004, Month.SEPTEMBER, 21), true);
        
        Alumno alumno4 = new Alumno(37296838, "Sosa", "Daiana", LocalDate.of(1993, Month.MAY, 31), true);
        
        Alumno alumno5 = new Alumno(44953034, "Miranda", "Teo", LocalDate.of(2003, Month.JUNE, 30), true);

        //CREACION DE MATERIAS
        Materia materia1 = new Materia(1,"Web",2025,true);
        
        Materia materia2 = new Materia(2,"Laboratorio",2025,true);
        
        Materia materia3 = new Materia(3,"Base de Datos",2025,true);
        
        MateriaData md = new MateriaData(con);
        
//agregar materia       
//md.guardarMateria(materia3);
//Baja Logica
//md.bajaLogica(3);
//AltaLogica
//md.altaLogica(3);
//elimar materia
//md.borrarMateria(1);
        
        //BUSCAR ALUMNO  
md.buscarAlumno(2);
        // al.buscarAlumno(13);

//GUARDAR ALUMNO

//        al.guardarAlumno(alm);

//BORRAR ALUMNO

        //al.borrarAlumno();
        
//LISTAR ALUMNOS

        //al.listarAlumnos();
        
//BAJA LOGICA

        //al.bajaLogica(11);
        
//ALTA LOGICA

        //al.altaLogica(11);
        
//BUSCAR ALUMNO  

        // al.buscarAlumno(13);
//ACTUALIZAR ALUMNO

//Alumno alumnoActualizado = new Alumno(
//        47267078, 
//        "Velez", 
//        "Damian", 
//        LocalDate.of(2006, Month.MARCH, 31), 
//        true);
//alumnoActualizado.setIdAlumno(11);
//        al.actualizarAlumno(alumnoActualizado);
    }
    

}
