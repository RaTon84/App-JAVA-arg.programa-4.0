package Entidades;

public class Brigada {
    private int codigo;
    private String nombre;
    private String especialidad;
    private boolean libre;
    private Cuartel cuartel;
    private boolean estado;

    public Brigada() {
    }

    public Brigada(String nombre) {
        this.nombre = nombre;
    }

    
    
    public Brigada(int codigo, String nombre, String especialidad, boolean libre, Cuartel cuartel, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
        this.estado = estado;
    }

    public Brigada(String nombre, String especialidad, boolean libre, Cuartel cuartel, boolean estado) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo+", "+nombre ;
    }

    
   
}
