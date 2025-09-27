package Modelo;

import java.time.LocalDate;

public class alumno {

    private int id = -1;
    private String nombre; //Varchar
    private LocalDate fechaNac; // datetime
    private boolean activo; //tinyint

    public alumno(String nombre, LocalDate fechaNac, boolean activo) {
        this.id = -1;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
