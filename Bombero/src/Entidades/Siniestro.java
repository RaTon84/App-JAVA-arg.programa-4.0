/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author Hernan
 */
public class Siniestro {
    
    private int codigo;
    private String tipo;
    private LocalDate fechaSiniestro;
    private Time horaSiniestro;
    private double coordX;
    private double coordY;
    private String detalles;
    private LocalDate fechaResolucion;
    private Time horaResolucion;
    private int puntuacion;
    private Brigada brigada;
    private boolean estado;

    public Siniestro() {
    }

    public Siniestro(int codigo, String tipo, LocalDate fechaSiniestro, Time horaSiniestro, double coordX, double coordY, String detalles, LocalDate fechaResolucion, Time horaResolucion, int puntuacion, Brigada brigada, boolean estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.horaSiniestro = horaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResolucion = fechaResolucion;
        this.horaResolucion = horaResolucion;
        this.puntuacion = puntuacion;
        this.brigada = brigada;
        this.estado = estado;
    }

    public Siniestro(String tipo, LocalDate fechaSiniestro, Time horaSiniestro, double coordX, double coordY, String detalles, LocalDate fechaResolucion, Time horaResolucion, int puntuacion, Brigada brigada, boolean estado) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.horaSiniestro = horaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResolucion = fechaResolucion;
        this.horaResolucion = horaResolucion;
        this.puntuacion = puntuacion;
        this.brigada = brigada;
        this.estado = estado;
    }

    

    public Time getHoraSiniestro() {
        return horaSiniestro;
    }

    public void setHoraSiniestro(Time horaSiniestro) {
        this.horaSiniestro = horaSiniestro;
    }

    public Time getHoraResolucion() {
        return horaResolucion;
    }

    public void setHoraResolucion(Time horaResolucion) {
        this.horaResolucion = horaResolucion;
    }

   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(LocalDate fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }



    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  tipo + ", "+fechaSiniestro;
    }

//    @Override
//    public String toString() {
//        return "Siniestro{" + "codigo=" + codigo + ", tipo=" + tipo + ", fechaSiniestro=" + fechaSiniestro + ", horaSiniestro=" + horaSiniestro + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", fechaResolucion=" + fechaResolucion + ", horaResolucion=" + horaResolucion + ", puntuacion=" + puntuacion + ", brigada=" + brigada + ", estado=" + estado + '}';
//    }

   

    
  
    
    
}
