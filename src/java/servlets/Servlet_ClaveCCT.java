/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Conexion;
import ConexionBD.Procedimientos;
import beans.BaseDatos;
import beans.Bdatos_aspirante;
import beans.Carrera;
import beans.Carreras;
import beans.Catalogos;
import beans.fecha;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "Servlet_ClaveCCT", urlPatterns = {"/Servlet_ClaveCCT"})
public class Servlet_ClaveCCT extends HttpServlet {

    private static final long serialVersionUID = 1L;

    List<BaseDatos> ClaveCCT;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Procedimientos p = new Procedimientos();
        String opc = request.getParameter("municipio");

        int pk =Integer.parseInt(opc);
        try {

            ClaveCCT = p.getCatalogos("desarrollo", "d3s4rr0ll0", 7, pk);
//            ClaveCCT = p.getCatalogos("fichas", "fichas", 7);

            System.out.println(ClaveCCT);
        } catch (SQLException ex) {
            Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Catalogos.class.getName()).log(Level.SEVERE, null, ex);
        }

        String json = null;

        json = new Gson().toJson(ClaveCCT);

        System.out.println("json" + json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

//        HttpSession session = request.getSession(true);
//        session.setAttribute("ClaveCCT", ClaveCCT);
//        out.print(ClaveCCT);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}
