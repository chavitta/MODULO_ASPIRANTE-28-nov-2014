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
public class Carreras {
//llenar  esta con  una consulta  al catalogo  de  carrera  

//    List<Carrera> carreras = new ArrayList<Carrera>();
    public List<Carrera> llenaCarrera() {
        List<Carrera> Carrera = new ArrayList<>();
        Carrera bd;
        bd = new Carrera();
        bd.setClave("--");
        bd.setNombre("--Seleccione--");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("1");
        bd.setNombre("Ingeniería Electrónica");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("2");
        bd.setNombre("Ingeniería Electromecánica");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("3");
        bd.setNombre("Ingeniería Industrial");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("4");
        bd.setNombre("Ingeniería Química");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("5");
        bd.setNombre("Ingeniería en Sistemas Computacionales");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("6");
        bd.setNombre("Ingeniería Mecatrónica");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("7");
        bd.setNombre("Ingeniería en Gestión Empresarial");
        Carrera.add(bd);
        bd = new Carrera();
        bd.setClave("8");
        bd.setNombre("Ingeniería Industrial a Distancia");
        return Carrera;
    }

    public void Comparar(List<Carrera> opciones, List<Carrera> op, String clave) {
        for (int i = 0; i < opciones.size(); i++) {
            if (clave == opciones.get(i).getClave()) {
                op.add(opciones.get(i));
            }
        }
    }

    public void SinRepetir(List<Carrera> opciones, List<Carrera> op, String clave, String clave2) {
        for (int j = 0; j < opciones.size(); j++) {
            if (opciones.get(j).getClave() != op.get(0).getClave()) {
                if (clave != opciones.get(j).getClave() && clave2 != opciones.get(j).getClave()) {
                    op.add(opciones.get(j));
                }
            }
        }
    }

    public String ConvertirJson(List<BaseDatos> carreras) {
        String lista = "\"" + "Municipios"  + "\":" + "[";
        for (int i = 0; i < carreras.size(); i++) {
            lista += "{" + "\"" + "id" + "\"" + ":" + carreras.get(i).getClave() + ","
                    + "\"" + "TNAME" + "\"" + ":" + " \"" + carreras.get(i).getNombre() + "\"" + "}" + ",";;
        }
        lista = lista.substring(0, lista.length() - 1);
        return lista;

    }
}
