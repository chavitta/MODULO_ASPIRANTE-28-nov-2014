/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Procedimientos;
import beans.BaseDatos;
import beans.Bdatos_aspirante;
import beans.Carrera;
import beans.Carreras;
import beans.Catalogos;
import beans.fecha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.LlenaFecha;
import modelos.llenarBD;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Socioeconomicos extends HttpServlet {

    LlenaFecha fe = new LlenaFecha();
    llenarBD bd = new llenarBD();

    List<BaseDatos> estado;
    List<BaseDatos> NivelEstudios;
    List<BaseDatos> Dependencia;
    List<BaseDatos> Ocupaciones;
    List<BaseDatos> cuartos = bd.llenaNumCuartos();
    List<BaseDatos> casa = bd.llenaCasaEs();
    List<BaseDatos> numero = bd.llenaNumero();
    List<BaseDatos> Ingresos = bd.llenaIngresos();
    List<BaseDatos> zona = bd.llenaZonaProcedencia();

    Catalogos catalogo = new Catalogos();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = "desarrollo";
        String pass = "d3s4rr0ll0";
       
        Bdatos_aspirante b = new Bdatos_aspirante();
        String correo = request.getParameter("correo");
        String curp = request.getParameter("curp");
//        String DatosAsp=request.getParameter("datper");
//        String nombre = request.getParameter("DatosAsp");
//        System.out.println("Objeto:"+DatosAsp);
        Bdatos_aspirante aspirante = new Bdatos_aspirante();
        aspirante.setEmail(correo);
        aspirante.setCurp(curp);
        HttpSession session = request.getSession(true);
        session.setAttribute("aspirante", aspirante);
//        int pk = 0;
        System.out.println(usuario + "/" + pass);
        Procedimientos p = new Procedimientos();
        PrintWriter out = response.getWriter();

//validar que  curp no existe  para  dejar pasar  
        int existeCurp = p.GetValidaCurp(curp);
        System.out.println("Retorno de procedimiento " + existeCurp);
        switch (existeCurp) {
            case 0:
                //no se ha registrado
                try {
                    estado = p.getCatalogos( 2, 0);
                    estado = catalogo.AgregaS(estado);
                    NivelEstudios = p.getCatalogos( 4, 0);
                    NivelEstudios = catalogo.AgregaS(NivelEstudios);
                    Ocupaciones = p.getCatalogos(6, 0);
                    Ocupaciones = catalogo.AgregaS(Ocupaciones);
                    Dependencia = p.getCatalogos( 5, 0);
                    Dependencia = catalogo.AgregaS(Dependencia);
                } catch (SQLException ex) {
                    Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("estado", estado);
                session.setAttribute("numero", numero);
                session.setAttribute("Ingresos", Ingresos);
                session.setAttribute("Dependencia", Dependencia);
                session.setAttribute("Ocupaciones", Ocupaciones);
                session.setAttribute("NivelEstudios", NivelEstudios);
                session.setAttribute("cuartos", cuartos);
                session.setAttribute("casa", casa);
                session.setAttribute("zona", zona);
                out.println(0);
                break;
            case 1:
                //ya esta registrado
                out.println(existeCurp);
                break;
            case -1:
                //ocurrio  error inesperado
                out.println(existeCurp);
                break;

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}
