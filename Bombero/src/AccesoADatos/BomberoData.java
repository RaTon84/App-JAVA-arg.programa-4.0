/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Bombero;
import Entidades.Brigada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class BomberoData {
       private Connection con = null;
       private BrigadaData bd;       
       
    public BomberoData() {
        con = Conexion.getConexion();
        bd = new BrigadaData();
    }
    
    public void guardarBombero(Bombero bombero){    
    String sql = "INSERT INTO bombero(dni,nombre, apellido, fecha_nac, celular, cod_brigada, grupo_sanguineo, estado) VALUES (?,?,?,?,?,?,?,?)";
           try {
               PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               // ps.setInt(1, alumno.getDni());    ps.setDate(4, Date.valueOf(alumno.getFechaNacimento()));
               //
               ps.setString(1, bombero.getDni());
               ps.setString(2, bombero.getNombre());
               ps.setString(3, bombero.getApellido());
               ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
               ps.setString(5, bombero.getCelular());
               ps.setInt(6, bombero.getBrigada().getCodigo());
               ps.setString(7, bombero.getGrupoSanguineo());
               ps.setBoolean(8, bombero.isEstado());
               ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
               if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bombero añadido con exito.");
            }
            ps.close();
           } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "No se pudo añadir el bombero.");
           }
    }
    
    public Bombero buscarBombero(int id){
            Bombero b= new Bombero();
            Brigada br= new Brigada();
           try {               
               String query= "SELECT * FROM bombero WHERE id_bombero=?";
               PreparedStatement ps = con.prepareStatement(query);
               ps.setInt(1, id);
               ResultSet rs= ps.executeQuery();
               if(rs.next()){                    
                   b.setIdBombero(id);
                   b.setDni(rs.getString("dni"));
                   b.setNombre(rs.getString("nombre"));
                   b.setApellido(rs.getString("apellido"));
                   b.setFechaNac(rs.getDate("fecha_nac").toLocalDate());                   
                   b.setCelular(rs.getString("celular"));                   
                   b.setBrigada(bd.buscarBrigada(rs.getInt("cod_brigada")));
                   b.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                   b.setEstado(rs.getBoolean("estado"));                   
               ///    JOptionPane.showMessageDialog(null, "Bombero encontrado.");
               }else{
                   JOptionPane.showMessageDialog(null, "No se encontro al bombero con el id:"+id);
                }                 
               ps.close();  
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "No se encontro al bombero.");
           }
        return b;
    }

    public Bombero buscarBomberoPorDni(String dni) {
        Bombero b = new Bombero();
        Brigada br = new Brigada();
        try {
            String query = "SELECT * FROM bombero WHERE dni=" + dni;
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setIdBombero(rs.getInt("id_bombero"));
                b.setDni(dni);
                b.setNombre(rs.getString("nombre"));
                b.setApellido(rs.getString("apellido"));
                b.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
                b.setCelular(rs.getString("celular"));
                b.setBrigada(bd.buscarBrigada(rs.getInt("cod_brigada")));
                b.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                b.setEstado(rs.getBoolean("estado"));
              ///  JOptionPane.showMessageDialog(null, "Bombero encontrado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro al bombero con el DNI:" + dni);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro al bombero.");
        }
        return b;
    }

    public void darDeBajaBombero(int id) {        
        try {
            String sql = "UPDATE bombero SET estado=0 WHERE id_bombero=" + id;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Bombero dado de baja.");
            } else {
                JOptionPane.showMessageDialog(null, "Bombero no encontrado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo dar de baja al bombero.");
        }
    }
    
    public void darDeAltaBombero(int id) {        
        try {
            String sql = "UPDATE bombero SET estado=1 WHERE id_bombero=" + id;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Bombero dado de alta.");
            } else {
                JOptionPane.showMessageDialog(null, "Bombero no encontrado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo dar de alta al bombero.");
        }
    }
    
    public void modificarBombero(Bombero bombero){
        
        String sql = "UPDATE bombero SET dni=?, nombre=?, apellido=?, fecha_nac=?, celular=?, cod_brigada=?, grupo_sanguineo=?, estado=? WHERE id_bombero=?";
        try {            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);            
            ps.setString(1, bombero.getDni());
            ps.setString(2, bombero.getNombre());
            ps.setString(3, bombero.getApellido());
            ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
            ps.setString(5, bombero.getCelular());          
            ps.setInt(6, bombero.getBrigada().getCodigo());                    
            ps.setString(7, bombero.getGrupoSanguineo());
            ps.setBoolean(8,bombero.isEstado());
            ps.setInt(9, bombero.getIdBombero());
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado==1) {               
                JOptionPane.showMessageDialog(null, "Bombero modificado.");
            } else {
                JOptionPane.showMessageDialog(null, "Bombero no se pudo modificar.");
            }          
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer modificar bombero");
        }
    }
    
    public ArrayList listarBombero() {
        ArrayList<Bombero> bomberos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM bombero";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()) {
                Bombero b = new Bombero();
                cont++;
                b.setIdBombero(rs.getInt("id_bombero"));
                b.setDni(rs.getString("dni"));
                b.setNombre(rs.getString("nombre"));
                b.setApellido(rs.getString("apellido"));
                b.setFechaNac(rs.getDate("fecha_nac").toLocalDate());
                b.setCelular(rs.getString("celular"));
                b.setBrigada(bd.buscarBrigada(rs.getInt("cod_brigada")));
                b.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                b.setEstado(rs.getBoolean("estado"));
                bomberos.add(b);
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun bombero");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer listar los bomberos" + ex.getMessage());
        }
        return  bomberos;
    }
    
    public ArrayList listarBomberosPorBrigadas(int idBrigada){
      ArrayList<Bombero> aux = listarBombero();
       ArrayList<Bombero> bomberosPorBrigadas= new ArrayList<>();
            for(Bombero bombero:aux){
             if (bombero.getBrigada().getCodigo() == idBrigada){
             bomberosPorBrigadas.add(bombero);
             }
          }
    return bomberosPorBrigadas;
    }
    
    public ArrayList listarBomberosPorCuartel(int idCuartel){
      ArrayList<Bombero> aux = listarBombero();
       ArrayList<Bombero> bomberosPorCuartel= new ArrayList<>();
            for(Bombero bombero:aux){
             if (bombero.getBrigada().getCuartel().getCodigo() == idCuartel){
             bomberosPorCuartel.add(bombero);
             }
          }
    return bomberosPorCuartel;
    }
}
