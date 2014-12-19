/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ConexionBD.ConexionOracle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrefichaPDF extends HttpServlet {

    String fichabd = null;
    String periodobd = null;
    String fechapdf = null;
    String prefichabd = null;
    String nombrebd = null;
    String apellidosbd = null;
    String curpbd = null;
    String carrerabd = null;
    String modalidadbd = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("application/pdf");

            String curp = new String(request.getParameter("curp").getBytes("ISO-8859-1"), "UTF-8");

            ConexionOracle conexionOracle = new ConexionOracle();

            String sql = "select * from PERSONALDATA_ASP_TAB where curp=" + "'" + curp + "'";
            System.out.println(sql);
            System.out.println("Esta es la curp: " + curp);

            conexionOracle.conectar();
            Connection conn = conexionOracle.getConnection();
            // driver@machineName:port:SID           ,  userid,  password
            Statement stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {

                fichabd = rset.getString("id_aspirante");
                periodobd = rset.getString("periodo_solicitud");
                prefichabd = rset.getString("preficha");
                nombrebd = rset.getString("nombre");
                String appat = rset.getString("apellido_pat");
                String apmat = rset.getString("apellido_mat");
                apellidosbd = appat + " " + apmat;
                curpbd = rset.getString("curp");
                carrerabd = rset.getString("carrera");
                modalidadbd = rset.getString("modalidad");
            }

            try {

                Document preficha = new Document();
                PdfWriter writer = PdfWriter.getInstance(preficha, response.getOutputStream());
                preficha.open();
//encabezado
//encabezado
//encabezado
//encabezado

//                documento.add(vacio);
//                documento.add(vacio);
//                documento.add(vacio);
                Paragraph depto = new Paragraph("Departamento de servicios escolares", FontFactory.getFont("arial", 20, Font.BOLD));
                depto.setAlignment(Element.ALIGN_CENTER);

                preficha.add(depto);

                Paragraph vacio = new Paragraph("  ", FontFactory.getFont("arial", 10, Font.BOLD));
                vacio.setAlignment(Element.ALIGN_CENTER);
                preficha.add(vacio);
                preficha.add(vacio);
//                preficha.add(vacio);
//cuerpo
//cuerpo
//cuerpo
//cuerpo
//cuerpo

                Paragraph periodo_text = new Paragraph("Convocatoria de nuevo ingreso periodo: " + periodobd, FontFactory.getFont("arial", 10, Font.BOLD));
                periodo_text.setAlignment(Element.ALIGN_CENTER);
                preficha.add(periodo_text);

                preficha.add(vacio);
                preficha.add(vacio);

                Paragraph fotografia = new Paragraph("Fotografía", FontFactory.getFont("arial", 10, Font.BOLD));
                fotografia.setAlignment(Element.ALIGN_CENTER);
                preficha.add(fotografia);

                PdfContentByte rectangulo_general = writer.getDirectContentUnder();
                rectangulo_general.rectangle(50, 48, 500, 710);
                rectangulo_general.fill();
                drawRectangleSC(rectangulo_general, 50, 48, 500, 710);

                PdfContentByte rectangulo_periodo = writer.getDirectContentUnder();
                rectangulo_periodo.rectangle(125, 725, 350, 20);
                rectangulo_periodo.fill();
                drawRectangleSC(rectangulo_periodo, 125, 725, 350, 20);
 
                String url_logo = "/Imagenes/itt_logo_opt.jpg";
                String absolute_url_logo = getServletContext().getRealPath(url_logo);
                Image itt_logo = Image.getInstance(absolute_url_logo);

                String url_logo_bnmx = "/Imagenes/bnmx_color_opt.jpg";
                String absolute_url_logo_bnmx = getServletContext().getRealPath(url_logo_bnmx);
                Image bnmx_logo = Image.getInstance(absolute_url_logo_bnmx);

                Image Logo_itt = Image.getInstance(itt_logo);
                Logo_itt.setAbsolutePosition(140f, 640f);
                preficha.add(Logo_itt);

                Image Logo_banco = Image.getInstance(bnmx_logo);
                Logo_banco.setAbsolutePosition(380f, 340f);
                preficha.add(Logo_banco);
                
                PdfContentByte espacio_imagen = writer.getDirectContentUnder();
                espacio_imagen.rectangle(255, 635, 85, 80);
                espacio_imagen.fill();
                drawRectangleSC(espacio_imagen, 255, 635, 85, 80);

//                preficha.add(vacio);
                preficha.add(vacio);

                PdfContentByte fechaimpr = writer.getDirectContentUnder();
                fechaimpr.rectangle(416, 635, 100, 35);
                fechaimpr.fill();
                drawRectangleSC(fechaimpr, 416, 635, 100, 35);
//            drawRectangle(fechaimpr, 85, 530, 430, 25);

                Paragraph fechapdf = new Paragraph("\tFecha de impresión                ", FontFactory.getFont("arial", 10, com.itextpdf.text.Font.BOLD));
                fechapdf.setAlignment(Element.ALIGN_RIGHT);
                preficha.add(fechapdf);

                Paragraph fechapdf_fec = new Paragraph("\t" + fecha_hoy() + "                          ", FontFactory.getFont("arial", 10, com.itextpdf.text.Font.BOLD));
                fechapdf_fec.setAlignment(Element.ALIGN_RIGHT);
                preficha.add(fechapdf_fec);

                preficha.add(vacio);

                Paragraph no_preficha = new Paragraph("Preficha N°: " + prefichabd, FontFactory.getFont("arial", 20, Font.BOLD));
                no_preficha.setAlignment(Element.ALIGN_CENTER);
                preficha.add(no_preficha);

                preficha.add(vacio);
//                preficha.add(vacio);

                PdfContentByte rectangulo_preficha_no = writer.getDirectContentUnder();
                rectangulo_preficha_no.rectangle(85, 590, 430, 25);
                rectangulo_preficha_no.fill();
                drawRectangleSC(rectangulo_preficha_no, 85, 590, 430, 25);

                PdfContentByte rectangulo_datos = writer.getDirectContentUnder();
                rectangulo_datos.rectangle(85, 500, 430, 80);
//                rectangulo_datos.rec
                rectangulo_datos.fill();
                drawRectangleSC(rectangulo_datos, 85, 500, 430, 80);

//////////////////////////////
                Paragraph nombre = new Paragraph("                                                                              Nombre:   " + nombrebd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                nombre.setAlignment(Element.ALIGN_LEFT);
                preficha.add(nombre);

//                preficha.add(vacio);
                Paragraph apellidos = new Paragraph("                                                                                               " + apellidosbd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                apellidos.setAlignment(Element.ALIGN_LEFT);
                preficha.add(apellidos);

//                preficha.add(vacio);
                Paragraph CURP = new Paragraph("                                                                                 CURP:   " + curpbd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                CURP.setAlignment(Element.ALIGN_LEFT);
                preficha.add(CURP);

//                preficha.add(vacio);
                Paragraph carrera = new Paragraph("                                                            Carrera Solicitada:   " + carrerabd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                carrera.setAlignment(Element.ALIGN_LEFT);
                preficha.add(carrera);

//                preficha.add(vacio);
                Paragraph modalidad = new Paragraph("                                                                          Modalidad:   " + modalidadbd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                modalidad.setAlignment(Element.ALIGN_LEFT);
                preficha.add(modalidad);

                preficha.add(vacio);
//                preficha.add(vacio);

                Paragraph formatoBanamex = new Paragraph("FORMATO UNIVERSAL PARA DEPÓSITOS EN SUCURSALES BANAMEX", FontFactory.getFont("arial", 10, Font.BOLD));
                formatoBanamex.setAlignment(Element.ALIGN_CENTER);
                preficha.add(formatoBanamex);

                PdfContentByte rectanguloDepositoB = writer.getDirectContentUnder();
                rectanguloDepositoB.rectangle(85, 470, 430, 20);
                rectanguloDepositoB.fill();
                drawRectangle(rectanguloDepositoB, 85, 470, 430, 20);

                PdfContentByte rectanguloPago = writer.getDirectContentUnder();
                rectanguloPago.rectangle(85, 280, 430, 190);
                rectanguloPago.fill();
                drawRectangleSC(rectanguloPago, 85, 280, 430, 190);

                preficha.add(vacio);

                PdfContentByte rectanguloConcepto = writer.getDirectContentUnder();
                rectanguloConcepto.rectangle(150, 425, 295, 35);
//                rectangulo_datos.rec
                rectanguloConcepto.fill();
                drawRectangleSC(rectanguloConcepto, 150, 425, 295, 35);

                Paragraph formatoConceptoPre = new Paragraph("CONCEPTO: PAGO DE DERECHO A EXAMEN DE ADMISIÓN", FontFactory.getFont("arial", 10, Font.BOLD));
                formatoConceptoPre.setAlignment(Element.ALIGN_CENTER);
                preficha.add(formatoConceptoPre);

                Paragraph fechaEmision = new Paragraph("FECHA DE EMISIÓN: 18/12/2014", FontFactory.getFont("arial", 10, Font.BOLD));
                fechaEmision.setAlignment(Element.ALIGN_CENTER);
                preficha.add(fechaEmision);

                preficha.add(vacio);
//                preficha.add(vacio);
//                preficha.add(vacio);
                preficha.add(vacio);

                Paragraph importe = new Paragraph("IMPORTE A PAGAR: $1,500.°°", FontFactory.getFont("arial", 15, Font.BOLD));
                importe.setAlignment(Element.ALIGN_CENTER);
                preficha.add(importe);

                preficha.add(vacio);
                preficha.add(vacio);
                preficha.add(vacio);
//                preficha.add(vacio);
//                preficha.add(vacio);

                String ref = "44353452342353464765634523434";

                Paragraph referencia = new Paragraph("                                                   REFERENCIA (B): " + ref, FontFactory.getFont("arial", 10, Font.BOLD));
                referencia.setAlignment(Element.ALIGN_LEFT);
                preficha.add(referencia);

                preficha.add(vacio);

                Paragraph descrConcepto = new Paragraph("DESCRIPCIÓN DEL CONCEPTO: CUOTA POR CONCEPTO DE PREINCRIPCIÓN.", FontFactory.getFont("arial", 10, Font.BOLD));
                descrConcepto.setAlignment(Element.ALIGN_CENTER);
                preficha.add(descrConcepto);

                preficha.add(vacio);
                preficha.add(vacio);
//                preficha.add(vacio);
//                preficha.add(vacio);
//                preficha.add(vacio);
//                preficha.add(vacio);

                Paragraph atencion = new Paragraph("Atención", FontFactory.getFont("arial", 15, Font.BOLD));
                atencion.setAlignment(Element.ALIGN_CENTER);
                preficha.add(atencion);

                PdfContentByte rectangulo_atencion = writer.getDirectContentUnder();
                rectangulo_atencion.rectangle(245, 229, 100, 25);
                rectangulo_atencion.fill();
                drawRectangle(rectangulo_atencion, 245, 229, 100, 25);

                PdfContentByte rectangulo_info = writer.getDirectContentUnder();
                rectangulo_info.rectangle(85, 94, 430, 100);
                rectangulo_info.fill();
                drawRectangle(rectangulo_info, 85, 94, 430, 120);

                preficha.add(vacio);
                preficha.add(vacio);

                Paragraph informacion = new Paragraph(
                        "                             Para completar el proceso de preinscripción:\n"
                        + "                           - Realiza el pago para tu examen de admisión\n"
                        + "                              Con el voucher de pago impreso realiza tu pago en cualquier sucursal BANAMEX.\n"
                        + "                           - Acude a las instalaciones del ITToluca para el canje del recibo oficial.\n"
                        + "                              Acude al Depto. de RECURSOS FINANCIEROS (Edif. \"A\") de lunes a viernes  de 9:00 a 18:00 hrs. y canjea el recibo bancario \n"
                        + "                              por el recibo oficial de pago.\n"
                        + "                           - Acude a las instalaciones del ITToluca para entregar tu documentación.\n"
                        + "                              En el Depto. de SERVICIOS ESCOLARES (Edif. \"B4\" planta baja Ing. Logistica) de lunes a viernes  de 9:00 a 18:00 hrs. \n"
                        + "                              Entrega tu recibo oficial y tu preficha.", FontFactory.getFont("arial", 7, Font.BOLD));
                informacion.setAlignment(Element.ALIGN_LEFT);
                preficha.add(informacion);
//  pie
//  pie
//  pie
//  pie
//  pie
                preficha.add(vacio);
                preficha.add(vacio);

                preficha.addTitle("Preficha");
                preficha.addSubject("Instituto Tecnológico de Toluca");
                preficha.addKeywords("Instituto Tecnológico de Toluca");
                preficha.addAuthor("Departamento de Servicios escolares");
                preficha.addCreator("Departamento de Servicios escolares");

                preficha.close();

                preficha.close();
            } catch (DocumentException de) {
                throw new IOException(de.getMessage());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrefichaPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void drawRectangle(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
        content.setGState(state);
        content.setRGBColorFill(232, 232, 232);
        content.setColorStroke(BaseColor.LIGHT_GRAY);
//        content.setr
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }
//    public static void drawRectangleWhite(PdfContentByte content, float x, float y, float width, float height) {
//        content.saveState();
//        PdfGState state = new PdfGState();
//        content.setGState(state);
//        content.setRGBColorFill(255, 255, 2);
//        content.setColorStroke(BaseColor.CYAN);
////        content.setr
//        content.setLineWidth((float) .5);
//        content.rectangle(x, y, width, height);
//        content.fillStroke();
//        content.restoreState();
//    }

    public static void drawRectangleSC(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
//        state.setFillOpacity(0.6f);
        content.setGState(state);
        content.setRGBColorFill(0xFF, 0xFF, 0xFA);
        content.setColorStroke(BaseColor.LIGHT_GRAY);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public static void drawRectangleText(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
        content.setGState(state);
        content.setRGBColorFill(0, 230, 255);
        content.setColorStroke(BaseColor.LIGHT_GRAY);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public static String fecha_hoy() {
        Calendar fec = new GregorianCalendar();
        int año = fec.get(Calendar.YEAR);
        int mes = fec.get(Calendar.MONDAY);
        int dia = fec.get(Calendar.DAY_OF_MONTH);
        String fech = dia + "/" + (mes + 1) + "/" + año;

        return fech;
    }
}
