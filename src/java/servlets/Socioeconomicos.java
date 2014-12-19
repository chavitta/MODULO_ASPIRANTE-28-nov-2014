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
//        String usuario = "fichas";
//        String pass = "fichas";
//        String usuario = request.getParameter("usuario");
//        String pass = request.getParameter("pass");
        int pk=0;
        System.out.println(usuario + "/" + pass);
        Procedimientos p = new Procedimientos();

        try {
            estado = p.getCatalogos(usuario, pass, 2,0);
            estado = catalogo.AgregaS(estado);
            NivelEstudios = p.getCatalogos(usuario, pass, 4,0);
            NivelEstudios = catalogo.AgregaS(NivelEstudios);
            Ocupaciones = p.getCatalogos(usuario, pass, 6,0);
            Ocupaciones = catalogo.AgregaS(Ocupaciones);
            Dependencia = p.getCatalogos(usuario, pass, 5,0);
            Dependencia = catalogo.AgregaS(Dependencia);
//            c.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession session = request.getSession(true);

        session.setAttribute("estado", estado);
        session.setAttribute("numero", numero);
        session.setAttribute("Ingresos", Ingresos);
        session.setAttribute("Dependencia", Dependencia);
        session.setAttribute("Ocupaciones", Ocupaciones);
        session.setAttribute("NivelEstudios", NivelEstudios);
        session.setAttribute("cuartos", cuartos);
        session.setAttribute("casa", casa);
        session.setAttribute("zona", zona);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}
