/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Procedimientos;
import beans.BaseDatos;
import beans.Carrera;
import beans.Carreras;
import beans.Catalogos;
import com.google.gson.Gson;
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

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class CargaEstado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<BaseDatos> municipio;
    List<BaseDatos> Localidad;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opc = request.getParameter("opcion");
        System.out.println(opc);
        Catalogos cat = new Catalogos();
        String pk = request.getParameter("pk");
        int foranea = Integer.parseInt(pk);
        System.out.println(foranea);
        String usuario = "desarrollo";
        String pass = "d3s4rr0ll0";
        Procedimientos p = new Procedimientos();
        if ("Mun".equals(opc)) {
            try {
                System.out.println("Entroa sevlet estado");
                response.setContentType("text/html;charset=UTF-8");
                municipio = p.getCatalogos(usuario, pass, 3, foranea);
                municipio = cat.AgregaS(municipio);
                String json = null;
                json = new Gson().toJson(municipio);
                System.out.println("json" + json);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

            } catch (SQLException ex) {
                Logger.getLogger(CargaEstado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CargaEstado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("Loc".equals(opc)) {
            try {
            response.setContentType("text/html;charset=UTF-8");
           Localidad = p.getCatalogos(usuario, pass, 3, foranea);
            Localidad = cat.AgregaS(Localidad);
            String json = null;
            json = new Gson().toJson(Localidad);
            System.out.println("json" + json);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        
        }catch (SQLException ex) {
                Logger.getLogger(CargaEstado.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(CargaEstado.class.getName()).log(Level.SEVERE, null, ex);
            }}
    }



// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
