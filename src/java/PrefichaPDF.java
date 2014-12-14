
import ConexionBD.ConexionOracle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
            System.out.println("Esta es la curp: "+curp);
            
            
            
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
//                carrerabd = rset.getString("carrera");
//                modalidadbd = rset.getString("modalidad");
            }
            carrerabd="INDUSTRIAL";
            modalidadbd="ESCOLARIZADO";
            
            try {
                Document documento = new Document();
                PdfWriter writer = PdfWriter.getInstance(documento, response.getOutputStream());
                documento.open();
//encabezado
//encabezado
//encabezado
//encabezado
                Paragraph vacio = new Paragraph("  ", FontFactory.getFont("arial", 10, Font.BOLD));
                vacio.setAlignment(Element.ALIGN_CENTER);
                documento.add(vacio);
                documento.add(vacio);
                documento.add(vacio);
                
                Paragraph depto = new Paragraph("Departamento de servicios escolares", FontFactory.getFont("arial", 20, Font.BOLD));
                depto.setAlignment(Element.ALIGN_CENTER);
                documento.add(depto);
                
                documento.add(vacio);
                documento.add(vacio);
//cuerpo
//cuerpo
//cuerpo
//cuerpo
//cuerpo
                
                Paragraph periodo_text = new Paragraph("Convocatoria de nuevo ingreso periodo: " + periodobd, FontFactory.getFont("arial", 10, Font.BOLD));
                periodo_text.setAlignment(Element.ALIGN_CENTER);
                documento.add(periodo_text);
                
                documento.add(vacio);
                documento.add(vacio);
                
                Paragraph prueba = new Paragraph("prueba texto", FontFactory.getFont("arial", 10, Font.BOLD));
                prueba.setAlignment(Element.ALIGN_CENTER);
                documento.add(prueba);
                
                PdfContentByte rectangulo_general = writer.getDirectContentUnder();
                rectangulo_general.rectangle(50, 170, 500, 540);
                rectangulo_general.fill();
                drawRectangleSC(rectangulo_general, 50, 170, 500, 540);
                
                PdfContentByte rectangulo_periodo = writer.getDirectContentUnder();
                rectangulo_periodo.rectangle(125, 680, 350, 20);
                rectangulo_periodo.fill();
                drawRectangle(rectangulo_periodo, 125, 680, 350, 20);
                
                PdfContentByte espacio_imagen = writer.getDirectContentUnder();
                espacio_imagen.rectangle(255, 580, 85, 80);
                espacio_imagen.fill();
                drawRectangleSC(espacio_imagen, 255, 580, 85, 80);
                
                documento.add(vacio);
                documento.add(vacio);
                documento.add(vacio);
                documento.add(vacio);
                documento.add(vacio);
                
                Paragraph no_preficha = new Paragraph("Preficha N°: " + prefichabd, FontFactory.getFont("arial", 20, Font.BOLD));
                no_preficha.setAlignment(Element.ALIGN_CENTER);
                documento.add(no_preficha);
                
                documento.add(vacio);
                documento.add(vacio);
                
                PdfContentByte rectangulo_preficha_no = writer.getDirectContentUnder();
                rectangulo_preficha_no.rectangle(85, 530, 430, 25);
                rectangulo_preficha_no.fill();
                drawRectangle(rectangulo_preficha_no, 85, 530, 430, 25);
                
                PdfContentByte rectangulo_datos = writer.getDirectContentUnder();
                rectangulo_datos.rectangle(85, 350, 430, 165);
                rectangulo_datos.fill();
                drawRectangleSC(rectangulo_datos, 85, 350, 430, 165);
                
//////////////////////////////
                Paragraph nombre = new Paragraph("                                                                              Nombre:   " + nombrebd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                nombre.setAlignment(Element.ALIGN_LEFT);
                documento.add(nombre);
                
                documento.add(vacio);
                
                Paragraph apellidos = new Paragraph("                                                                           Apellidos:   " + apellidosbd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                apellidos.setAlignment(Element.ALIGN_LEFT);
                documento.add(apellidos);
                
                documento.add(vacio);
                
                Paragraph CURP = new Paragraph("                                                                                 CURP:   " + curpbd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                CURP.setAlignment(Element.ALIGN_LEFT);
                documento.add(CURP);
                
                documento.add(vacio);
                
                Paragraph carrera = new Paragraph("                                                            Carrera Solicitada:   " + carrerabd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                carrera.setAlignment(Element.ALIGN_LEFT);
                documento.add(carrera);
                
                documento.add(vacio);
                
                Paragraph modalidad = new Paragraph("                                                                          Modalidad:   " + modalidadbd,
                        FontFactory.getFont("arial", 10, Font.BOLD));
                modalidad.setAlignment(Element.ALIGN_LEFT);
                documento.add(modalidad);
                
                documento.add(vacio);
                documento.add(vacio);
                
                Paragraph atencion = new Paragraph("Atención", FontFactory.getFont("arial", 15, Font.BOLD));
                atencion.setAlignment(Element.ALIGN_CENTER);
                documento.add(atencion);
                
                PdfContentByte rectangulo_atencion = writer.getDirectContentUnder();
                rectangulo_atencion.rectangle(245, 310, 100, 25);
                rectangulo_atencion.fill();
                drawRectangle(rectangulo_atencion, 245, 310, 100, 25);
                
                PdfContentByte rectangulo_info = writer.getDirectContentUnder();
                rectangulo_info.rectangle(85, 195, 430, 100);
                rectangulo_info.fill();
                drawRectangle(rectangulo_info, 85, 180, 430, 120);
                
                documento.add(vacio);
                documento.add(vacio);
                
                Paragraph informacion = new Paragraph(
                        "                             Para completar el proceso de preinscripción:\n"
                                + "                           - Realiza el pago para tu examen de admisión\n"
                                + "                              Con el voucher de pago impreso realiza tu pago en cualquier sucursal BANAMEX.\n"
                                + "                           - Acude a las instalaciones del ITToluca para el canje del recibo oficial.\n"
                                + "                              Acude al depto. de RECURSOS FINANCIEROS (Edif. \"A\") de lunes a viernes  de 9:00 a 18:00 hrs. y canjea el recibo bancario \n"
                                + "                              por el recibo oficial de pago.\n"
                                + "                           - Acude a las instalaciones del ITToluca para entregar tu documentación.\n"
                                + "                              En el depto. de SERVICIOS ESCOLARES (edif. \"B4\" planta baja Ing. Logistica) de lunes a viernes  de 9:00 a 18:00 hors. \n"
                                + "                              Entrega tu recibo oficial y tu preficha.", FontFactory.getFont("arial", 7, Font.BOLD));
                informacion.setAlignment(Element.ALIGN_LEFT);
                documento.add(informacion);
//  pie
//  pie
//  pie
//  pie
//  pie
                documento.add(vacio);
                documento.add(vacio);
                
                documento.addTitle("Preficha");
                documento.addSubject("Instituto Tecnologico de Toluca");
                documento.addKeywords("Instituto Tecnologico de Toluca");
                documento.addAuthor("Departamento de Servisios escolares");
                documento.addCreator("Departamento de Servisios escolares");
                
                documento.close();
                
                documento.close();
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
        content.setRGBColorFill(0xD8, 0xD8, 0xFA);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public static void drawRectangleSC(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
//        state.setFillOpacity(0.6f);
        content.setGState(state);
        content.setRGBColorFill(0xFF, 0xFF, 0xFA);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public static void drawRectangleText(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
        content.setGState(state);
        content.setRGBColorFill(0xFE, 0x2E, 0x64);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }
}
