/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.util.Comparator;

/**
 *
 * @author Juan
 */
public class OrdenarCuartelesAsc implements Comparator<Double>{

    @Override
    public int compare(Double t, Double t1) {
     return t.compareTo(t1);
    }
    
}
