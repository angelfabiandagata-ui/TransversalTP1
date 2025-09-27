package Modelo;

import java.time.LocalDate;

public class alumno {

     private int idAlumno;//int
     private int dni;//int
     private String apellido;//varchar
     private String nombre;//varchar
     private LocalDate fechadenacimiento;//date
     private boolean estado;//tinyint

    public alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechadenacimiento, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechadenacimiento = fechadenacimiento;
        this.estado = estado;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
 }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(LocalDate fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "-AlumnoDatos- " + " idAlumno: " + idAlumno + ", dni: " + dni + ", apellido: " + apellido + ", nombre: " + nombre + ", fechadenacimiento: " + fechadenacimiento + ", estado: " + estado;
    }
    
}