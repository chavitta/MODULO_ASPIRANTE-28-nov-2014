/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

<<<<<<< HEAD
=======
import ConexionBD.Procedimientos;
>>>>>>> origin/master
import beans.BMail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Encripta;
import modelos.Mail;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class EnviaEmailInicio extends HttpServlet {

    Encripta e = new Encripta();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD
        String correo = request.getParameter("correo");
        PrintWriter out = response.getWriter();
        // valida  que no exista si existe  no continua retorna  false  
        // Si no  existe envia  link con  correo encriptado  
        int existe = 0;
        if (existe != 0) {
            out.print("Ya existe un registro con este correo.");
        } else {
            String  CorreoEnc = e.encryptURL(correo);
            String url = "http://localhost:8080/MODULO_ASPIRANTE/Datos_Aspirante.jsp?correo=" + CorreoEnc;
            BMail beanMail = new BMail();
            beanMail.setCuerpo("Éste es un correo de verificación. Por favor haga click en el siguiente enlace\n"
                    + "para que pueda continuar con su registro."
                    + "<a href=" + url
                    + ">Enlace</a>");
            Mail m = new Mail();
            m.sendMail(beanMail,"aspirantes@ittoluca.edu.mx" ,correo,"11280672", true);
            out.print("Se ha enviado a tu correo  una  liga  para continuar con el registro. Si no logras visualizar el correo en tu Bandeja de entrada debes verificar en la bandeja de Correo no deseado");
        }

=======
             String correo = request.getParameter("correo");
        PrintWriter out = response.getWriter();
        Procedimientos p = new Procedimientos();
        String Url = "http://localhost:8080/MODULO_ASPIRANTE/Datos_Aspirante.jsp";
        String CorreoEnc = e.encryptURL(correo);
        String UrlEnc = e.encryptURL(Url);
        String liga = Url + "?correo=" + CorreoEnc;
        int existe = p.GetValidaCorreo(correo, UrlEnc);

        switch (existe) {
            case 0:
                // envia correo
                BMail beanMail = new BMail();
                beanMail.setCuerpo("Éste es un correo de verificación. Por favor haga click en el siguiente enlace\n"
                        + "para que pueda continuar con su registro."
                        + "<a href=" + liga
                        + ">Enlace</a>");
                Mail m = new Mail();
                boolean ret = m.sendMail(beanMail, "aspirantes@ittoluca.edu.mx", correo, "11280672", true);
                if (ret) {
                    out.print("Se ha enviado un enlace a su correo para continuar con el registro. Si no  logras  visualizar el correo en tu bandeja  de  entrada no  olvide consultar  la  bandeja de correo no deseado");
                } else {
                    out.print("No se  pudo enviar el correo. Por favor vuelva a intentarlo");
                }
                                
                break;
            case 1:
                // retorna  que ya existe correo  
                out.print("El correo  ya  fue registrado en esta convocatoria");
                break;
            case 2:
                // error  inesperado al crear  la liga
                out.print("Ha ocurrido un error. Por favor  vuelve intentarlo.");
                break;
        }


>>>>>>> origin/master
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>}
}
