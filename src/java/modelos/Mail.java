/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import beans.BMail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Desarrollo de sistem
 */

public class Mail {
//parametros  destinatario, y quien envia, objeto con  cuerpo 

    public boolean sendMail(BMail beanMail, String from, String to, String pass, boolean link) {
//        BMail beanMail = new BMail();
boolean  retorno = false;
//        String from = "aspirantes@ittoluca.edu.mx";
//        String pass = "11280672";
//        String[] to = {
//            "11280392@ittoluca.edu.mx",
//            "desacad@ittoluca.edu.mx",
//            "chava_dalu5@hotmail.com"
//        };
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
            InternetAddress toAddress = new InternetAddress(to);

//            for (int i = 0; i < to.length; i++) {
//                System.out.println(to[i]);
//            }
//            for (int i = 0; i < to.length; i++) {
//                toAddress[i] = new InternetAddress(to);
//                System.out.println("Destinatario - " + (i + 1) + " .- " + toAddress[i]);
//            }
//            for (int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress);
//            }
            message.setSubject("Contacto aspirantes");
            message.setText("Cuerpo");
            if (link == true) {
                message.setText(beanMail.getCuerpo(), "ISO-8859-1", "html");
            } else {
                message.setText(beanMail.getCuerpo());
            }
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            try {
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                System.out.println("Se envió mensaje");
                retorno=true;
            } catch (MessagingException ex) {
            }
        } catch (MessagingException me) {
            me.printStackTrace();
            System.out.println(me);
            System.out.println("No se  envió correo");
            retorno=false;
        }
        return retorno;
    }
}
