package Persistencia;

import Modelo.Alumno;
import Modelo.Conexion;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.security.interfaces.RSAKey;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private MateriaData md= new MateriaData();
    private AlumnoDatos ad= new AlumnoDatos();
    
    public InscripcionData(Connection conexion) {
        this.con = conexion;
    }

    public InscripcionData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public List<Inscripcion> obtenerInscripciones() {
    
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = con.prepareStatement(sql);
        
            ResultSet rs = ps.executeQuery();
        
            while(rs.next()){
            Inscripcion insc = new Inscripcion();
            insc.setIdInscripcion(rs.getInt("idInscripto"));
            Materia mat = md.buscarMateria(rs.getInt("idMateria"));
            Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            cursadas.add(insc);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar // obtener Inscripciones");
        }
        return cursadas;
    }
//
  public List<Inscripcion> obtenerinscripcionesPorAlumno(int id) {
 
    List<Inscripcion> inscripciones = new ArrayList<>();
    String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        AlumnoDatos aluData = new AlumnoDatos(con);
        MateriaData matData = new MateriaData(con);

        while (rs.next()) {
            Inscripcion ins = new Inscripcion();
            ins.setIdInscripcion(rs.getInt("idInscripcion"));
            ins.setNota(rs.getDouble("nota"));

            // Traemos el alumno y la materia asociados
            Alumno a = aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia m = matData.buscarMateria(rs.getInt("idMateria"));

            ins.setAlumno(a);
            ins.setMateria(m);

            inscripciones.add(ins);
        }

        ps.close();

    } catch (SQLException ex) {
        System.out.println("❌ Error al obtener inscripciones: " + ex.getMessage());
    }

    return inscripciones;
}
      

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        
        List<Materia> materias = new ArrayList<>();
         String sql = "SELECT m.* FROM materia m "
               + "JOIN inscripcion i ON m.idMateria = i.idMateria "
               + "WHERE i.idAlumno = ? AND i.nota >= 7";
         
         try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ResultSet rs = ps.executeQuery();
     while (rs.next()) {
            Materia m = new Materia();
            m.setIdmateria(rs.getInt("idMateria"));
            m.setNombre(rs.getString("nombre"));
            m.setAnio(rs.getInt("anio"));
            m.setEstado(rs.getBoolean("estado"));
            materias.add(m);
        }

        ps.close();

    } catch (SQLException ex) {
        System.out.println("Error al obtener materias cursadas: " + ex.getMessage());
    }

    return materias;
}
    
//
public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
    List<Materia> materias = new ArrayList<>();
    String sql = "SELECT * FROM materia WHERE idMateria NOT IN "
               + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Materia m = new Materia();
            m.setIdmateria(rs.getInt("idMateria"));
            m.setNombre(rs.getString("nombre"));
            m.setAnio(rs.getInt("anio"));
            m.setEstado(rs.getBoolean("estado"));
            materias.add(m);
        }

        ps.close();

    } catch (SQLException ex) {
        System.out.println(" Error al obtener materias no cursadas: " + ex.getMessage());
    }

    return materias;
}


    public void borrarinscripcionMateriaAlumno(int idAlumno, int idMateria) {

        try {                     
            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
           int filas = ps.executeUpdate();
           
           if(filas > 0){JOptionPane.showMessageDialog(null, "Inscripcion Borrada");}
            
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "erorr al hacer conexion // borrar inscripcion");
        }
//fin borrMat        
    }
//
    public void actualizarNota(int idAlumno, int idMateria, double nota) {

   
        try {
            String sql = "UPDATE `inscripcion` SET nota = ? WHERE idAlumno = ? and idMateria = ?";
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
           JOptionPane.showMessageDialog(null, "erorr al hacer conexion //actualzar nota");
        }
    //fin acNot
    }
//    
   
    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
  List<Alumno> alumnos = new ArrayList<>();
    
    String sql = "SELECT alumno.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
               + "FROM inscripcion "
               + "JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno) "
               + "WHERE inscripcion.idMateria = ? AND alumno.estado = 1";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idMateria);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setFechadenacimiento(rs.getDate("fechadenacimiento").toLocalDate());
            alumno.setEstado(rs.getBoolean("estado"));
            alumnos.add(alumno);
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
    }
    
    return alumnos;
}
   
}


