/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Bombero;
import Entidades.Brigada;
import Entidades.Cuartel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan
 */
public class BrigadaData {

    private Connection con = null;
    private CuartelData cd;

    public BrigadaData() {
        con = Conexion.getConexion();
        cd = new CuartelData();

    }

    public void guardarBrigada(Brigada brigada) {
        String sql = "INSERT INTO brigada(nombre_br, especialidad, libre, nro_cuartel, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombre());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getCuartel().getCodigo());
            ps.setBoolean(5, brigada.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Brigada creada con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la brigada.");
        }
    }

    public Brigada buscarBrigada(int id) {
        Brigada br = new Brigada();
        Cuartel cuartel = new Cuartel();
        try {
            String query = "SELECT * FROM brigada WHERE cod_brigada=" + id;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                br.setCodigo(id);
                br.setNombre(rs.getString("nombre_br"));
                br.setEspecialidad(rs.getString("especialidad"));
                br.setLibre(rs.getBoolean("libre"));
                br.setCuartel(cd.buscarCuartel(rs.getInt("nro_cuartel")));
                br.setEstado(rs.getBoolean("estado"));        
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la brigada.");
        }
        return br;
    }   

    public void modificarBrigada(Brigada brigada) {

        String sql = "UPDATE brigada SET nombre_br=?, especialidad=?, libre=?, nro_cuartel=?, estado=? WHERE cod_brigada=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, brigada.getNombre());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getCuartel().getCodigo());
            ps.setBoolean(5, brigada.isEstado());
            ps.setInt(6, brigada.getCodigo());
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
            } else {
                JOptionPane.showMessageDialog(null, "La brigada no se pudo modificar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer modificar la brigada");
        }
    }

    public ArrayList listarBrigada() {
        ArrayList<Brigada> brigadas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM brigada";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()) {
                Brigada b = new Brigada();
                cont++;
                b.setCodigo(rs.getInt("cod_brigada"));
                b.setNombre(rs.getString("nombre_br"));
                b.setEspecialidad(rs.getString("especialidad"));
                b.setLibre(rs.getBoolean("libre"));
                b.setCuartel(cd.buscarCuartel(rs.getInt("nro_cuartel")));
                b.setEstado(rs.getBoolean("estado"));
                brigadas.add(b);
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna brigada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer listar las brigadas" + ex.getMessage());
        }
        return brigadas;
    }
    
    public ArrayList listarBrigadasPorCuartel(int idCuartel){
      ArrayList<Brigada> aux = listarBrigada();
       ArrayList<Brigada> brigadasPorCuartel= new ArrayList<>();
            for(Brigada brigada:aux){
             if (brigada.getCuartel().getCodigo()== idCuartel && brigada.isEstado()){
             brigadasPorCuartel.add(brigada);
             }
          }
    return  brigadasPorCuartel;
    }
    
    public ArrayList listarBrigadasLibres(){
      ArrayList<Brigada> aux = listarBrigada();
       ArrayList<Brigada> brigadasLibres= new ArrayList<>();
       
            for(Brigada brigada:aux){
             if (brigada.isLibre()){
               
             brigadasLibres.add(brigada);
             
             }
          }
    return  brigadasLibres;
    }
    
    public ArrayList listarBrigadasOcupadas(){
      ArrayList<Brigada> aux = listarBrigada();
       ArrayList<Brigada> brigadasOcupadas= new ArrayList<>();       
            for(Brigada brigada:aux){
             if (brigada.isLibre()==false){               
             brigadasOcupadas.add(brigada);             
             }
          }
    return  brigadasOcupadas;
    }
    
    public boolean comprobarCapacidadBrigada(int h){
        boolean confirmacion= false; 
     try {
          
         String sql = "SELECT * FROM bombero WHERE estado = 1 AND cod_brigada ="+h;
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            ArrayList<Bombero> bomberos = new ArrayList<>(); 
            
            while (rs.next()) {
                Bombero b = new Bombero();
                b.setIdBombero(rs.getInt("id_bombero"));
                b.setDni(rs.getString("dni"));
                b.setNombre(rs.getString("nombre"));
                b.setApellido(rs.getString("apellido"));
                b.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
                b.setCelular(rs.getString("celular"));
                b.setBrigada(buscarBrigada(rs.getInt("cod_brigada")));
                b.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                b.setEstado(rs.getBoolean("estado"));
                bomberos.add(b);
            }
            
            if (bomberos.size()<5) {
            confirmacion = true;
         }else{
               confirmacion = false; 
            }
            ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al buscar la capacidad de la Brigada " + ex.getMessage());
        }
    
 return confirmacion; 
    }
    
    public void darDeBaja(int id) {

        String sql = "UPDATE brigada SET estado=0 WHERE cod_brigada=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
 
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Brigada dada de baja.");
            } else {
                JOptionPane.showMessageDialog(null, "La brigada no se pudo dar de baja.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer dar de baja la brigada");
        }
    }
    public void darDeAlta(int id) {

        String sql = "UPDATE brigada SET estado=1 WHERE cod_brigada=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
 
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Brigada dada de alta.");
            } else {
                JOptionPane.showMessageDialog(null, "La brigada no se pudo dar de alta.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer dar de alta la brigada");
        }
    }
    
    
}
