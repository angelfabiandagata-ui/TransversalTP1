/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ema
 */
public class Materia {
    
    //atributos
    private int idmateria;
    private String nombre;
    private String anio;   
    private boolean estado;

    //constructor completo
    public Materia(int idmateria, String nombre, String anio, boolean estado) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }
   
   
    //getters y setters
    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
//final    
}
