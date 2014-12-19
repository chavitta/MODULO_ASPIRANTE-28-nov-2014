/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

//import com.google.common.collect.ArrayListMultimap;
import java.util.ArrayList;
import java.util.List;
import beans.fecha;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class LlenaFecha {

    public List<fecha> llenames() {
        List<fecha> mes = new ArrayList<>();
        int i = 0;
        while (i < 13) {

            switch (i) {
                case 0: {
                    fecha f = new fecha();
                    f.setClave("--");
                    f.setDma("--");
                    mes.add(f);
                    i++;
                }
                break;
                case 1: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Ene");
                    mes.add(f);
                    i++;
                }
                break;
                case 2: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Feb");
                    mes.add(f);
                    i++;
                }
                break;
                case 3: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Mar");
                    mes.add(f);
                    i++;
                }
                break;
                case 4: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Abr");
                    mes.add(f);
                    i++;
                }
                break;
                case 5: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("May");
                    mes.add(f);
                    i++;
                }
                break;
                case 6: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Jun");
                    mes.add(f);
                    i++;
                }
                break;
                case 7: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Jul");
                    mes.add(f);
                    i++;
                }
                break;
                case 8: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Ago");
                    mes.add(f);
                    i++;
                }
                break;
                case 9: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Sep");
                    mes.add(f);
                    i++;
                }
                break;
                case 10: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Oct");
                    mes.add(f);
                    i++;
                }
                break;
                case 11: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Nov");
                    mes.add(f);
                    i++;
                }
                break;
                case 12: {
                    fecha f = new fecha();
                    f.setClave(String.valueOf(i));
                    f.setDma("Dic");
                    mes.add(f);
                    i++;
                }
                break;

            }

        }
       
        return mes;
    }

    public List<fecha> llenadia() {
        List<fecha> dia = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (i == 0) {
                fecha f = new fecha();
                f.setClave("--");
                f.setDma("--");
                dia.add(f);

            } else {
                fecha f = new fecha();
                f.setClave(String.valueOf(i));
                f.setDma(String.valueOf(i));
                dia.add(f);
            }
        }
        return dia;
    }

    public List<fecha> llenaaño() {
        List<fecha> anio = new ArrayList<>();
        for (int i = 1924; i < 2014; i++) {
            if (i == 1924) {
                fecha f = new fecha();
                f.setClave("--");
                f.setDma("--");
                anio.add(f);
            } else {
                fecha f = new fecha();
                f.setClave(String.valueOf(i));
                f.setDma(String.valueOf(i));
                anio.add(f);
            }
        }
        return anio;
    }

    public List<fecha> llenapromedio() {
        List<fecha> prom = new ArrayList<>();
        for (int i = 59; i < 101; i++) {
            if (i == 59) {
                fecha f = new fecha();
                f.setClave("0");
                f.setDma("--");
                prom.add(f);
            } else {
                fecha f = new fecha();
                f.setClave(String.valueOf(i));
                f.setDma(String.valueOf(i));
                prom.add(f);
            }
        }
        return prom;
    }
}
