



import servlets.*;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMail extends HttpServlet {

    public static void main(String[] args) {
        String from = "aspirantes@ittoluca.edu.mx"; //quien envia
        String pass = "11280672";           //contraseña de la cuenta
        String[] to = {
            "11280392@ittoluca.edu.mx",
            "chava_dalu5@hotmail.com"
        }; //a quien va..
        String subject = "Probando la aplicación con los acentos";  //asunto
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

        sendFromMail(from, pass, to, subject, body);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = "aspirantes@ittoluca.edu.mx";
        String pass = "11280672";
        String[] to = {
            "11280392@ittoluca.edu.mx",
            "chava_dalu5@hotmail.com"
        };
        String asunto = "Contacto aspirantes";
        String correo = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8");
        String nombre = new String(request.getParameter("txtEmail").getBytes("ISO-8859-1"), "UTF-8");
        String texto = new String(request.getParameter("txtDescripcion").getBytes("ISO-8859-1"), "UTF-8");
        String cuerpo = "Correo: " + correo + "\n" + "Nombre: " + nombre + "\n" + "\n" + "\n" + "Mensaje" + "\n" + texto + "\n";
        sendFromMail(from, pass, to, asunto, cuerpo);
    }
    private static void sendFromMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        props.setProperty("mail.mime.charset", "ISO-8859-1");
        String host = "mail.ittoluca.edu.mx"; //itt
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.localhost", "sia.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "mail.ittoluca.edu.mx");
        props.put("mail.smtp.ehlo", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            for (int i = 0; i < to.length; i++) {
                System.out.println(to[i]);
            }
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
                System.out.println("Destinatario - " + (i + 1) + " .- " + toAddress[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            System.out.println(body);
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            try {
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            } catch (MessagingException ex) {
            }
        } catch (MessagingException me) {
            me.printStackTrace();
            System.out.println(me);
        }
    }
}
