/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Hernan
 */
public class Cuartel {
    private int codigo;
    private String nombre;
    private String direccion;
    private double coordX;
    private double coordY;
    private String telefono;
    private String correo;
    private boolean estado;

    public Cuartel() {
    }

    public Cuartel(String nombre) {
        this.nombre = nombre;
    }
    
    
    public Cuartel(int codigo, String nombre, String direccion, double coordX, double coordY, String telefono, String correo, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordX = coordX;
        this.coordY = coordY;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public Cuartel(String nombre, String direccion, double coordX, double coordY, String telefono, String correo, boolean estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordX = coordX;
        this.coordY = coordY;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

   

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  nombre+", " + direccion;
    }

   

   
    
    
    
}
