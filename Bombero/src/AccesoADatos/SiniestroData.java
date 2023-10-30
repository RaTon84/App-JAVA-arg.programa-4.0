/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Brigada;
import Entidades.Cuartel;
import Entidades.Siniestro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan
 */
public class SiniestroData {
    private Connection con = null;
    private BrigadaData bd;
    private CuartelData cd;
    
    public SiniestroData() {
        con = Conexion.getConexion();
        bd= new BrigadaData();
        cd= new CuartelData();
    }
    
    public void guardarSiniestro(Siniestro siniestro){
        String sql = "INSERT INTO `siniestro`(`tipo`, `fecha_siniestro`, "
                + "`hora_siniestro`, `coord_X`, `coord_Y`, `detalles`, `fecha_resol`, `hora_resol`, "
                + "`puntuacion`, `cod_brigada`, `estado`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, siniestro.getTipo());
            ps.setDate(2, Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setTime(3, siniestro.getHoraSiniestro());
            ps.setDouble(4, siniestro.getCoordX());
            ps.setDouble(5, siniestro.getCoordY());
            ps.setString(6, siniestro.getDetalles());
            if (siniestro.getFechaResolucion()!=null) {
                ps.setDate(7, Date.valueOf(siniestro.getFechaResolucion()));
            }else{
                ps.setDate(7, null);
            }            
            ps.setTime(8, siniestro.getHoraResolucion());
            ps.setInt(9, siniestro.getPuntuacion());
            if (siniestro.getBrigada()!=null) {
                ps.setInt(10, siniestro.getBrigada().getCodigo());
            }else{
                ps.setObject(10, null);
            }       
            ps.setBoolean(11, siniestro.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Siniestro creado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el siniestro.");
        }
    }
    
    public void resolverSiniestro(Siniestro siniestro){
        //agregar en el boton . traer el objeto y completarlo con estos datos 
        // falta probar la brigada
        String sql = "UPDATE siniestro SET fecha_resol=?, hora_resol=?, puntuacion=?, estado=?  WHERE codigo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(siniestro.getFechaResolucion()));
            ps.setTime(2, siniestro.getHoraResolucion());
            ps.setInt(3, siniestro.getPuntuacion());            
            ps.setBoolean(4, siniestro.isEstado());    
            ps.setInt(5, siniestro.getCodigo());          
            int resultado = ps.executeUpdate();     
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Siniestro resuelto");
            } else {
                JOptionPane.showMessageDialog(null, "Siniestro resuelto no cargado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer resolver el siniestro");
        }       
    }
    
    public void asignarBrigada(Brigada brigada, int codSiniestro){
        //agregar en el boton . traer el objeto y completarlo con estos datos 
        // falta probar la brigada
        String sql = "UPDATE siniestro SET cod_brigada=? WHERE codigo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, brigada.getCodigo());
            ps.setInt(2, codSiniestro);           
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Brigada asignada");
            } else {
                JOptionPane.showMessageDialog(null, "La brigada no se púdo asignar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer asignar brigada");
        }       
    }
    
    public ArrayList listarSiniestros(){        
        ArrayList<Siniestro> siniestros= new ArrayList();
        try {
            String sql = "SELECT * FROM siniestro";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()) {
                Siniestro s = new Siniestro();
                cont++;
                s.setCodigo(rs.getInt("codigo"));
                s.setTipo(rs.getString("tipo"));
                s.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
                s.setHoraSiniestro(rs.getTime("hora_siniestro"));
                s.setCoordX(rs.getDouble("coord_X"));
                s.setCoordY(rs.getDouble("coord_Y"));
                s.setDetalles(rs.getString("detalles"));                
                 if (rs.getDate("fecha_resol")!=null) {
                    s.setFechaResolucion(rs.getDate("fecha_resol").toLocalDate());
                }else{
                    s.setFechaResolucion(null);
                }                 
                s.setHoraResolucion(rs.getTime("hora_resol"));
                s.setPuntuacion(rs.getInt("puntuacion"));
              
                if (bd.buscarBrigada(rs.getInt("cod_brigada")).getCodigo()!=0) {
                    s.setBrigada(bd.buscarBrigada(rs.getInt("cod_brigada")));
                }else {
                    s.setBrigada(null);
                } 
                s.setEstado(rs.getBoolean("estado"));
                siniestros.add(s);                
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun siniestro");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer listar los siniestros" + ex.getMessage());
        }
        return siniestros;
    }
    
    public ArrayList listarSiniestrosNoResueltosConBrigada(){
       // listarSiniestros(){        
        ArrayList<Siniestro> siniestros= listarSiniestros();
        ArrayList<Siniestro> siniestros2= new ArrayList();
        for (Siniestro siniestro : siniestros) {
            if(siniestro.getBrigada()!=null && siniestro.getFechaResolucion()==null){
                siniestros2.add(siniestro); 
            }
        }        
        return siniestros2;   
    }
    
            
    public Cuartel calcularDistanciaDelCuartel(Siniestro siniestro) {
        ArrayList<Cuartel> cuarteles = cd.listarCuartel();
        Cuartel cuartelesMasCercano = new Cuartel();
        double aux = 1000000000;
        for (Cuartel cuartel : cuarteles) {
            //coordenadas del cuartel
            double x1 = cuartel.getCoordX();
            double y1 = cuartel.getCoordY();
            //coordenadas del siniestro
            double x2 = siniestro.getCoordX();
            double y2 = siniestro.getCoordY();
            double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (dis < aux) {
                cuartelesMasCercano = cuartel;
                aux = dis;
            }
        }
        double aux1 = (aux/1)*95;       
        return cuartelesMasCercano;
    }    
    
    public double calcularDistancia(double x1, double y1, double x2, double y2){
     
        double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double distancia = (dis/1)*95;
        
    return distancia;
    }
    
    public TreeMap cuartelesMasCercanos(Siniestro siniestro) {
        ArrayList<Cuartel> cuarteles = cd.listarCuartel();
        HashMap<Double, Cuartel> cuartelesMasCercanos = new HashMap<>();
        HashMap<Double, Cuartel> c = new HashMap <>();
        for (Cuartel cuartel : cuarteles) {
            //coordenadas del cuartel
            double x1 = cuartel.getCoordX();
            double y1 = cuartel.getCoordY();            
            //coordenadas del siniestro
            double x2 = siniestro.getCoordX();
            double y2 = siniestro.getCoordY();            
            double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
         dis = calcularDistancia(x1, y1, x2, y2);
            c.put(dis, cuartel);
        }
        TreeMap<Double, Cuartel> tree = new TreeMap<>(new OrdenarCuartelesAsc());
        tree.putAll(c);        
        for (Map.Entry<Double, Cuartel> entry : tree.entrySet()) {
            Double key = entry.getKey();
            Cuartel value = entry.getValue();          
           /// cuartelesMasCercanos.add(value);
        }  
        return tree;
    }

    public TreeMap cuartelesDisponiblesCompleto(Siniestro siniestro) {
        ArrayList<Cuartel> cuarteles = cd.listarCuartel();
        HashMap<Double, Cuartel> cuartelesMasCercanos = new HashMap<>();
        HashMap<Double, Cuartel> c = new HashMap <>(); 
        for (Cuartel cuartel : cuarteles) {
            //coordenadas del cuartel
            double x1 = cuartel.getCoordX();
            double y1 = cuartel.getCoordY();   
            //coordenadas del siniestro
            double x2 = siniestro.getCoordX();
            double y2 = siniestro.getCoordY();
            double dis = calcularDistancia(x1, y1, x2, y2);            
            c.put(dis, cuartel);
        }
        TreeMap<Double, Cuartel> tree = new TreeMap<>(new OrdenarCuartelesAsc());
        tree.putAll(c);        
        for (Map.Entry<Double, Cuartel> entry : tree.entrySet()) {
            Double key = entry.getKey();
            Cuartel value = entry.getValue();          
           /// cuartelesMasCercanos.add(value);
        }        
        return tree;
    }

    public ArrayList mostrarIncidenteEntreAyerYHoy(){
        ArrayList<Siniestro> siniestrosAyeryHoy= new ArrayList<>();
        LocalDate fechaAyer= LocalDate.now().minusDays(1);        
        ArrayList<Siniestro> siniestros= listarSiniestros();         
           for (Siniestro siniestro : siniestros) {
               if(siniestro.getFechaSiniestro().equals(LocalDate.now())|| siniestro.getFechaSiniestro().equals(fechaAyer)){
                    siniestrosAyeryHoy.add(siniestro);
               } 
        }
        return siniestrosAyeryHoy;
    }
     
      public ArrayList listarSiniestrosNoResultos(){
        ArrayList<Siniestro> siniestros= new ArrayList();
      try {
            String sql = "SELECT * FROM siniestro WHERE fecha_resol is null and cod_brigada is null";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()) {
                Siniestro s = new Siniestro();
                cont++;
                s.setCodigo(rs.getInt("codigo"));
                s.setTipo(rs.getString("tipo"));
                s.setFechaSiniestro(rs.getDate("fecha_siniestro").toLocalDate());
                s.setHoraSiniestro(rs.getTime("hora_siniestro"));
                s.setCoordX(rs.getDouble("coord_X"));
                s.setCoordY(rs.getDouble("coord_Y"));
                s.setDetalles(rs.getString("detalles"));                
                 if (rs.getDate("fecha_resol")!=null) {
                    s.setFechaResolucion(rs.getDate("fecha_resol").toLocalDate());
                }else{
                    s.setFechaResolucion(null);
                }                 
                s.setHoraResolucion(rs.getTime("hora_resol"));
                s.setPuntuacion(rs.getInt("puntuacion"));
              
                if (bd.buscarBrigada(rs.getInt("cod_brigada")).getCodigo()!=0) {
                    s.setBrigada(bd.buscarBrigada(rs.getInt("cod_brigada")));
                }else {
                    s.setBrigada(null);
                } 
                s.setEstado(rs.getBoolean("estado"));
                siniestros.add(s);            
            }
            if (cont == 0) {
                //JOptionPane.showMessageDialog(null, "No se encontro ningun siniestro");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al querer listar los siniestros" + ex.getMessage());
        }
        return siniestros;
    }
    }
 
 
        
    
 

    
    

