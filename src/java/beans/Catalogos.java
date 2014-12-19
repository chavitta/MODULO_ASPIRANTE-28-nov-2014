/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Catalogos {

    public List<BaseDatos> AgregaS(List<BaseDatos> respuestabd) {
        List<BaseDatos> catalogo= new  ArrayList<>();
        BaseDatos B;
        B = new BaseDatos();
        B.setClave("--");
        B.setNombre("--Selecione--");
        catalogo.add(B);
        for(int  i=0;i<respuestabd.size(); i++){
            catalogo.add( respuestabd.get(i));        
        }        
        return catalogo;
    }

}
