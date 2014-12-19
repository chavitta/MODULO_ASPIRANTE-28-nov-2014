/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import beans.BaseDatos;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleTypes;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Procedimientos {

    String user = "desarrollo";
    String pass = "d3s4rr0ll0";
    BaseDatos bd;
    CallableStatement cs = null;

    public List<BaseDatos> getCatalogos(int opc, int pk) throws SQLException, ClassNotFoundException {
        String result = "";
        int msgCodeError = -1;
        String msgDescError = "";

        List<BaseDatos> Estados;
        Estados = new ArrayList<>();

        Conexion con = new Conexion(user, pass);
        try {

            cs = con.getConnection().prepareCall("{call CATALOGOS_ASPIRANTES_PQ.GET_CATALOGO_SP(?,?,?,?,?)}");
            cs.setInt(1, opc);//pasar  atributos  para  where o insertar 
            cs.setInt(2, pk);
            cs.registerOutParameter(3, OracleTypes.CURSOR);//tomas  parametro de salida de  la  base de datos           
            cs.registerOutParameter(4, OracleTypes.NUMBER);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.execute();
            result = cs.getString(4);//#error
            ResultSet rs = (ResultSet) cs.getObject(3);

//CONVERTIR EL  CURSOR  A  UN ARRAY LIST
            while (rs.next()) {
                bd = new BaseDatos();
                bd.setClave(rs.getObject(1).toString());
                bd.setNombre(rs.getObject(2).toString());
                Estados.add(bd);
            }
            cs.close();

        } catch (SQLException e) {
            System.out.println("Error" + e);
            con.getConnection().close();

        } finally {
        }
        return Estados;
    }
//DESARROLLO.PQ_CHECK_ASPIRANTE_1 recibe   curp ****LLamando  funciones*** 
    //retorna  
    // numbern 

    public int GetValidaCurp(String curp) {
        int retorna = 0;
        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";

            List<BaseDatos> Estados;
            Estados = new ArrayList<>();

            Conexion con = new Conexion(user, pass);
            cs = con.getConnection().prepareCall("{?=call DESARROLLO.PQ_CHECK_ASPIRANTE_1.CHECK_EXIST_REG_ASP_FN(?)}");
            cs.setString(2, curp);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();
            retorna = cs.getInt(1);
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorna;
    }

    //CHECK_CORREO_CLIGA_SP  revibe  liga y  correo  encriptados
    //retorna int
//    0 No tenemos registro de ese correo 
//    1 Ya existe registro con ese correo
//    2 Ocurrio un error al generar la liga
    public int GetValidaCorreo(String correo, String liga) {
        int existe = 0;
        String existeDes;
        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";

            List<BaseDatos> Estados;
            Estados = new ArrayList<>();
            Conexion con = new Conexion(user, pass);
            cs = con.getConnection().prepareCall("{call DESARROLLO.PQ_CHECK_ASPIRANTE_1.CHECK_CORREO_CLIGA_SP(?,?,?,?,?)}");
            cs.setString(1, correo);
            cs.setString(2, liga);
            cs.registerOutParameter(3, OracleTypes.NUMBER);
            cs.registerOutParameter(4, OracleTypes.NUMBER);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.execute();
            existe = cs.getInt(3);
            existeDes = cs.getString(5);
            cs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
///respuesta 
    //

    public int InsertaPersonales(String curp, String nombre, String Apaterno, String Amaterno, String FecNac,
            String Pais, int Estado, String CdNac, char sexo, String EdoCivil, String sangre, String capacidad,
            char Curso, String correo) {
        int IdAspirante = 0;
        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";
            Conexion con = new Conexion(user, pass);
            cs = con.getConnection().prepareCall("{call PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_PERSONALDATA_SP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, curp);
            cs.setString(2, nombre);
            cs.setString(3, Apaterno);
            cs.setString(4, Amaterno);
            cs.setString(5, FecNac);
            cs.setString(6, Pais);
            cs.setInt(7, Estado);
            cs.setString(8, CdNac);
            cs.setString(9, String.valueOf(sexo));
            cs.setString(10, EdoCivil);
            cs.setString(11, sangre);
            cs.setString(12, capacidad);
            cs.setString(13, String.valueOf(Curso));
            cs.setString(14, correo);
            cs.registerOutParameter(15, OracleTypes.NUMBER);
            cs.registerOutParameter(16, OracleTypes.NUMBER);
            cs.registerOutParameter(17, OracleTypes.VARCHAR);
            cs.execute();
            IdAspirante = cs.getInt(15);
            System.out.println("***** " + cs.getInt(16));
            System.out.println("****************Error************************ " + cs.getString(17));
            cs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IdAspirante;
    }

    public int InsertaDireccion(int IdAsp, int Estado, String Ciudad, String calle, int NumInt, int NumExt,
            String colonia, int CodPost, int TelFijo, int TelCel) {
        int Exitoso = 0;
        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";
            Conexion con = new Conexion(user, pass);
            cs = con.getConnection().prepareCall("{call PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_DOMICILIO_ASP_SP(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, IdAsp);
            cs.setInt(2, Estado);
            cs.setString(3, Ciudad);
            cs.setString(4, calle);
            cs.setInt(5, NumInt);
            cs.setInt(6, NumExt);
            cs.setString(7, colonia);
            cs.setInt(8, CodPost);
            cs.setInt(9, TelFijo);
            cs.setInt(10, TelCel);
            cs.registerOutParameter(11, OracleTypes.NUMBER);
            cs.registerOutParameter(12, OracleTypes.NUMBER);
            cs.execute();
            Exitoso = cs.getInt(11);
            System.out.println("Error***** " + cs.getNString(12));
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Exitoso;
    }

    public void InsertaEscProcedencia() {

        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";
            Conexion con = new Conexion(user, pass);
            try {
                cs = con.getConnection().prepareCall("{call PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_CARRERA_ASP_SP(?,?,?,?,?)}");
                
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        String pass = "d3s4rr0ll0";
        String usuario = "desarrollo";
        List<BaseDatos> pais;
        int pk = 0;
        Procedimientos p = new Procedimientos();
        try {
            pais = p.getCatalogos(1, pk);
            System.out.println("");
//            System.out.println("***********"+new java.sql.Date(90,10 , 1));
            p.InsertaPersonales("B", "E", "B", "M", "12/11/90", "M", 3, "4", 'F', "S", "A", "V", 'Y', "e");
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
