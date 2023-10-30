/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

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
public class CuartelData {
    
     private Connection con = null;
    
    public CuartelData() {
       con = Conexion.getConexion();
    }
    
    
    public void guardarCuartel(Cuartel cuartel) {
        String sql = "INSERT INTO cuartel(nombre_cuartel, direccion, coord_X, coord_Y, telefono, correo, estado) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cuartel.getNombre());
            ps.setString(2, cuartel.getDireccion());
            ps.setDouble(3, cuartel.getCoordX());
            ps.setDouble(4, cuartel.getCoordY());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setBoolean(7, cuartel.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Cuartel guardado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el cuartel.");
        }
    }

    public Cuartel buscarCuartel(int id) {
        Cuartel cuartel = new Cuartel();
        try {
            String query = "SELECT * FROM cuartel WHERE cod_cuartel=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuartel.setCodigo(id);
                cuartel.setNombre(rs.getString("nombre_cuartel"));
                cuartel.setDireccion(rs.getString("direccion"));
                cuartel.setCoordX(rs.getDouble("coord_X"));
                cuartel.setCoordY(rs.getDouble("coord_Y"));
                cuartel.setTelefono(rs.getString("telefono"));
                cuartel.setCorreo(rs.getString("correo"));
                cuartel.setEstado(rs.getBoolean("estado"));
                //JOptionPane.showMessageDialog(null, "Cuartel encontrado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el cuartel con el id:" + id);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el cuartel.");
        }
        return cuartel;
    }

    public void darDeBajaCuartel(int id) {
        try {
            String sql = "UPDATE cuartel SET estado=0 WHERE cod_cuartel=" + id;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel dado de baja.");
            } else {
                JOptionPane.showMessageDialog(null, "Cuartel no encontrado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo dar de baja el cuartel.");
        }
    }
    public void darDeAltaCuartel(int id) {
        try {
            String sql = "UPDATE cuartel SET estado=1 WHERE cod_cuartel=" + id;
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel dado de alta.");
            } else {
                JOptionPane.showMessageDialog(null, "Cuartel no encontrado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo dar de alta el Cuartel.");
        }
    }

    public void modificarCuartel(Cuartel cuartel) {

        String sql = "UPDATE cuartel SET nombre_cuartel=?, direccion=?, coord_X=?, coord_Y=?, telefono=?, correo=?, estado=? WHERE cod_cuartel=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cuartel.getNombre());
            ps.setString(2, cuartel.getDireccion());
            ps.setDouble(3, cuartel.getCoordX());
            ps.setDouble(4, cuartel.getCoordY());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setBoolean(7, cuartel.isEstado());
            ps.setInt(8, cuartel.getCodigo());
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel modificado.");
            } else {
                JOptionPane.showMessageDialog(null, "El cuartel no se pudo modificar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer modificar el cuartel");
        }
    }
    
      public ArrayList listarCuartel(){
        ArrayList<Cuartel>cuarteles=new ArrayList<>();        
        try {
            String sql = "SELECT * FROM cuartel";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet rs = ps.executeQuery(); 
            int cont=0;
            while (rs.next()) {
               Cuartel ct = new Cuartel();
                cont++;
               ct.setCodigo(rs.getInt("cod_cuartel"));
               ct.setNombre(rs.getString("nombre_cuartel"));
               ct.setDireccion(rs.getString("direccion"));
               ct.setCoordX(rs.getDouble("coord_X"));
               ct.setCoordY(rs.getDouble("coord_Y")); 
               ct.setTelefono(rs.getString("telefono"));
               ct.setCorreo(rs.getString("correo"));
               ct.setEstado(rs.getBoolean("estado"));
                cuarteles.add(ct);
            }
            if (cont==0) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun cuartel");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer buscar un cuartel" + ex.getMessage());
        }
        return cuarteles;
    }
      
      
}

