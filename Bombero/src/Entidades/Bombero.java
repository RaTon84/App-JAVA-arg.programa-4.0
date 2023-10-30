/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author Juan
 */
public class Bombero {
    
    private int idBombero;
    private String dni; // (Chequear en la vista que sea solo numero)
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String celular; // (Chequear en la vista que sea solo numero)
    private Brigada brigada;
    private String grupoSanguineo; // Se agrego a la bace de datos
    private boolean estado;     //Se agregar estado a bd
                                
    public Bombero() {
    }

    public Bombero(int idBombero, String dni, String nombre, String apellido, LocalDate fechaNac, String celular, Brigada brigada, String grupoSanguineo, boolean estado) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.brigada = brigada;
        this.grupoSanguineo = grupoSanguineo;
        this.estado = estado;
    }

    public Bombero(String dni, String nombre, String apellido, LocalDate fechaNac, String celular, Brigada brigada, String grupoSanguineo, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.brigada = brigada;
        this.grupoSanguineo = grupoSanguineo;
        this.estado = estado;
    }
    

    public int getIdBombero() {
        return idBombero;
    }

    public void setIdBombero(int idBombero) {
        this.idBombero = idBombero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
  
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    } 

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Bombero{" + "idBombero=" + idBombero + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", celular=" + celular + ", brigada=" + brigada + ", grupoSanguineo=" + grupoSanguineo + ", estado=" + estado + '}';
    }

  

    
 
}
