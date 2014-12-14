/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Carrera;
import beans.Carreras;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class ServletActualizarListas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String op1 = request.getParameter("opcion1");
        String op2 = request.getParameter("opcion2");
        String op3 = request.getParameter("opcion3");
        String num = request.getParameter("num");
        System.out.println(num);
        Carreras carr = new Carreras();
        List<Carrera> opciones = carr.llenaCarrera();
        List<Carrera> opciones1 = new ArrayList<>();
        List<Carrera> opciones2 = new ArrayList<>();
        List<Carrera> opciones3 = new ArrayList<>();

        carr.Comparar(opciones, opciones1, op1);
        carr.Comparar(opciones, opciones2, op2);
        carr.Comparar(opciones, opciones3, op3);

        carr.SinRepetir(opciones, opciones1, op2, op3);
        carr.SinRepetir(opciones, opciones2, op1, op3);
        carr.SinRepetir(opciones, opciones3, op2, op1);

        HttpSession session = request.getSession(true);

        //formatear a  json
//        String carrera1 = carr.ConvertirJson(opciones1, 1);
//        String carrera2 = carr.ConvertirJson(opciones2, 2);
//        String carrera3 = carr.ConvertirJson(opciones3, 3);

//        PrintWriter out = response.getWriter();
//        if ("1".equals(num)) {
//            out.println("{" + carrera2 + "]}");
//        }
//        if ("2".equals(num)) {
//            out.println("{" + carrera3 + "]}");
//        }
//        if ("3".equals(num)) {
//            out.println("{" + carrera1 + "]}");
//            System.out.println(carrera1);
//        }
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
