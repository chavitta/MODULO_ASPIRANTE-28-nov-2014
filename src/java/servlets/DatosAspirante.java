/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Procedimientos;
import beans.Bdatos_aspirante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.llenarBD;

/**
 *
 * @author Desarrollo de sistem
 */
@WebServlet(name = "DatosAspirante", urlPatterns = {"/DatosAspirante"})
public class DatosAspirante extends HttpServlet {

    Bdatos_aspirante datos = new Bdatos_aspirante();
    llenarBD b = new llenarBD();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //        try {
            response.setContentType("text/html;charset=UTF-8");
            Procedimientos p = new Procedimientos();
            PrintWriter out = response.getWriter();
            String DatosPersonales = request.getParameter("DatosFormu1");
            System.out.println("Datos" + DatosPersonales);

            ArrayList<String> DatosPersonalesAsp = b.Formatea(DatosPersonales);

            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fecNac = formatoDeFecha.parse(DatosPersonalesAsp.get(4));
            System.out.println("Fecha" + fecNac);
            java.sql.Date sqlDate = new java.sql.Date(fecNac.getTime());
            
                System.out.println("Probando..........");
            System.out.println(DatosPersonalesAsp.get(0));
            System.out.println(DatosPersonalesAsp.get(1));
            System.out.println(DatosPersonalesAsp.get(2));
            System.out.println(DatosPersonalesAsp.get(3));
            System.out.println(sqlDate);
            System.out.println(DatosPersonalesAsp.get(5));
            System.out.println(DatosPersonalesAsp.get(6));
            System.out.println(DatosPersonalesAsp.get(7));
            System.out.println(DatosPersonalesAsp.get(9).charAt(0));
            System.out.println(DatosPersonalesAsp.get(10));
            System.out.println(DatosPersonalesAsp.get(11));
            System.out.println(DatosPersonalesAsp.get(12));
            System.out.println(DatosPersonalesAsp.get(DatosPersonalesAsp.size() - 1).charAt(0));
            System.out.println(DatosPersonalesAsp.get(13));
            System.out.println("Insertando..................................");
               System.out.println(DatosPersonalesAsp.get(0));
            System.out.println(DatosPersonalesAsp.get(1));
            System.out.println(DatosPersonalesAsp.get(2));
            System.out.println(DatosPersonalesAsp.get(3));
            System.out.println(sqlDate);
            System.out.println(DatosPersonalesAsp.get(5));
            System.out.println(DatosPersonalesAsp.get(6));
            System.out.println(DatosPersonalesAsp.get(7));
            System.out.println(DatosPersonalesAsp.get(9).charAt(0));
            System.out.println(DatosPersonalesAsp.get(10));
            System.out.println(DatosPersonalesAsp.get(11));
            System.out.println(DatosPersonalesAsp.get(12));
            System.out.println(DatosPersonalesAsp.get(DatosPersonalesAsp.size() - 1).charAt(0));
            System.out.println(DatosPersonalesAsp.get(13));
            if(!"null".equals(DatosPersonalesAsp.get(6))){
            int res = p.InsertaPersonales(DatosPersonalesAsp.get(0), DatosPersonalesAsp.get(1), DatosPersonalesAsp.get(2), DatosPersonalesAsp.get(3),
                    DatosPersonalesAsp.get(4), DatosPersonalesAsp.get(5),Integer.parseInt(DatosPersonalesAsp.get(6)),DatosPersonalesAsp.get(7), DatosPersonalesAsp.get(9).charAt(0), DatosPersonalesAsp.get(10),
                    DatosPersonalesAsp.get(11), DatosPersonalesAsp.get(12), DatosPersonalesAsp.get(DatosPersonalesAsp.size()-1).charAt(0), DatosPersonalesAsp.get(13));
            System.out.println(res+"********************");
            }else{
             int res = p.InsertaPersonales(DatosPersonalesAsp.get(0), DatosPersonalesAsp.get(1), DatosPersonalesAsp.get(2), DatosPersonalesAsp.get(3),
                     DatosPersonalesAsp.get(4), DatosPersonalesAsp.get(5), 2,DatosPersonalesAsp.get(7), DatosPersonalesAsp.get(9).charAt(0), DatosPersonalesAsp.get(10),
                    DatosPersonalesAsp.get(11), DatosPersonalesAsp.get(12), DatosPersonalesAsp.get(DatosPersonalesAsp.size()-1).charAt(0), DatosPersonalesAsp.get(13));
            System.out.println(res+"********************");
            
            }
        } catch (ParseException ex) {
            Logger.getLogger(DatosAspirante.class.getName()).log(Level.SEVERE, null, ex);
        }

//       
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
