/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import beans.BaseDatos;
import java.sql.CallableStatement;
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

    BaseDatos bd;

    public List<BaseDatos> getCatalogos(String user, String pass, int opc, int pk) throws SQLException, ClassNotFoundException {
        String result = "";
        int msgCodeError = -1;
        String msgDescError = "";
        CallableStatement cs = null;
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
//DESARROLLO.PQ_CHECK_ASPIRANTE_1 recibe   curp
    //retorna  
    // number
    public int GetValidaCurp(String user, String pass, String curp) {
        int retorna = 0;
        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";
            CallableStatement cs = null;
            List<BaseDatos> Estados;
            Estados = new ArrayList<>();

            Conexion con = new Conexion(user, pass);
            cs = con.getConnection().prepareCall("{?=call DESARROLLO.PQ_CHECK_ASPIRANTE_1.CHECK_EXIST_REG_ASP_FN(?)}");
            cs.setString(2, curp);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();
            retorna = cs.getInt(1);
           
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
    public int GetValidaCorreo(String user, String pass, String correo, String liga) {
        int existe = 0;
        String existeDes;
        try {
            String result = "";
            int msgCodeError = -1;
            String msgDescError = "";
            CallableStatement cs = null;
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
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    public static void main(String[] args) {
        String pass = "d3s4rr0ll0";
        String usuario = "desarrollo";
        List<BaseDatos> pais;
      int pk = 0;
        Procedimientos p = new Procedimientos();
        try {
            pais = p.getCatalogos(usuario, pass, 1, pk);
            System.out.println("");
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
