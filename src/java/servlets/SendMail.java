package servlets;



//import .*;
import beans.BMail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Mail;

public class SendMail extends HttpServlet {

    public static void main(String[] args) {
        String body = "Prueba desde aplicación java.\nPrueba desde aplicación java."; //cuerpo del mensaje
        body = body + "\nrevisando los acentos ´ por que no quieren enviarse correctamente. prueba número no se cuál";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        body = body + "\nhola!";
        System.out.println(body);
      Mail m = new Mail();
//      m.sendMail();
     
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8");
        String nombre = new String(request.getParameter("txtEmail").getBytes("ISO-8859-1"), "UTF-8");
        String texto = new String(request.getParameter("txtDescripcion").getBytes("ISO-8859-1"), "UTF-8");
        String cuerpo = "Correo: " + correo + "\n" + "Nombre: " + nombre + "\n" + "\n" + "\n" + "Mensaje" + "\n" + texto + "\n";
//        
        System.out.println(cuerpo);
//        
        BMail beanMail = new BMail();
        beanMail.setCuerpo(cuerpo);
//        
        Mail m = new Mail();
//        m.sendMail();  MODIFICAR !!!! 
        
////        beanMail.setCorreo(new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8"));
//        beanMail.setCorreo(correo);
////        beanMail.setNombre(new String(request.getParameter("txtEmail").getBytes("ISO-8859-1"), "UTF-8"));
//        beanMail.setNombre(nombre);
////        beanMail.setTexto(new String(request.getParameter("txtDescripcion").getBytes("ISO-8859-1"), "UTF-8"));
//        beanMail.setTexto(texto);
        
//        Mail eMail = new Mail();
//        eMail.sendMail(beanMail.contenido());
    }
}
