/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberogrupo6;

import AccesoADatos.BomberoData;
import AccesoADatos.BrigadaData;
import AccesoADatos.Conexion;
import AccesoADatos.CuartelData;
import AccesoADatos.SiniestroData;
import Entidades.Brigada;
import Entidades.Cuartel;
import Vistas.MenuView;
import java.sql.Connection;

/**
 *
 * @author Juan
 */
public class BomberoGrupo6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CuartelData cd = new CuartelData();
        BrigadaData bd = new BrigadaData();
        BomberoData bomd = new BomberoData();
        SiniestroData sd= new SiniestroData();
 
       MenuView escr = new MenuView();
       escr.setVisible(true);
       Connection con = Conexion.getConexion();
        
        
// CREACION DE BRIGADA
//
//        Brigada br1 = new Brigada(1,"FUEGITOS DEL SUR", "Incendios en viviendas e industrias", true, cd.buscarCuartel(1), true);
//        Brigada br2 = new Brigada("DERRUMBES DEL SUR", "Salvamento en derrumbes", true, cd.buscarCuartel(2), true);
//        bd.modificarBrigada(br1);
//        bd.guardarBrigada(br2);

// CREACION DE BOMBEROS

//        Bombero bom1 = new Bombero("20147835", "Marcos Fernado", "Leyria", LocalDate.of(1982, Month.NOVEMBER, 1), "2612243222", bd.buscarBrigada(1), "a+", true);
//        Bombero bom2 = new Bombero("35045789", "Maria Jose", "Orellano", LocalDate.of(1992, Month.JUNE, 21), "3511478655", bd.buscarBrigada(2), "b+", true);
//        bomd.guardarBombero(bom1);
//        bomd.guardarBombero(bom2);

// CREACION DE CUARTELES
//
//        Cuartel cuartel1 = new Cuartel("Santa Teresa", "Rt. Los Pescadores", -33.29498919318194, -66.34584462106838, "2664525497", "SantateresaSL@gmail.com", true);
//        Cuartel cuartel2 = new Cuartel("El Colibri", "AV. Presidente Peron", -33.29996967022411, -66.32757794978103, "2665294835", "CuartelcolibriesSL@gmail.com", true); 
//        
//        cd.guardarCuartel(cuartel1);
//        cd.guardarCuartel(cuartel2);

//GUARDAR SINIESTRO
// -31.31543484449304, -64.21539722294976
//    Siniestro sin= new Siniestro("Incendios en viviendas e industrias", LocalDate.now(), Time.valueOf(LocalTime.now())
//            , -31.31543484449304, -64.21539722294976, "Incendio en la torre de control", null, null, 8, null, true);
//    sd.guardarSiniestro(sin);
   // sd.resolverSiniestro(sin);
   // sd.calcularDistancia(sin);
   //    System.out.println("El cuartel Mas cercano es: "+sd.calcularDistancia(sin).toString());
        
// CUARTEL LISTAR

//        for (Cuartel cuartel : (ArrayList<Cuartel>) cd.listarCuartel()) {
//            System.out.println(cuartel.toString());
//        }

// BRIGADA LISTAR

//  >>>>>>>> PRIMERO ESPANDIR LA CANTIDAD (A 100) LOS VARCHAR EN LA BACE DE DATOS <<<<<<<<<<<

//        for (Brigada brigada : (ArrayList<Brigada>) bd.listarBrigada()) {
//            System.out.println(brigada.toString());
//        }

// BOMBERO LISTAR

//      for(Bombero bombero:(ArrayList<Bombero>) bomd.listarBombero()){
//             System.out.println(bombero.toString());            
//          }

// LISTAR BOMBERO POR BRIGADA

//      for(Bombero bombero:(ArrayList<Bombero>) bomd.listarBomberosPorBrigadas(2)){
//             System.out.println(bombero.toString());            
//          }

// LISTAR BOMBERO POR CUARTEL

//      for(Bombero bombero:(ArrayList<Bombero>) bomd.listarBomberosPorCuartel(1)){
//             System.out.println(bombero.toString());            
//          }
//

// LISTAR BRIGADAS POR CUARTEL

//      for(Brigada brigada:(ArrayList<Brigada>) bd.listarBrigadasPorCuartel(2)){
//             System.out.println(brigada.toString());            
//          }
//

// LISTAR SINIESTROS

//        for (Siniestro siniestro : (ArrayList<Siniestro>) sd.listarSiniestros()) {
//            System.out.println(siniestro.toString());
//        }


 }
}


