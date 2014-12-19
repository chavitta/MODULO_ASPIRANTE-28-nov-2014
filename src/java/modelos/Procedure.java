/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import ConexionBD.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Procedure {
String usuario,pass;
    public String getContactPrior(int domainId, int prior) throws SQLException, ClassNotFoundException {
        String result = "";
        int msgCodeError = -1;
        String msgDescError = "";
        CallableStatement cs = null;
        Conexion con = new Conexion(usuario, pass);
        try {  								//PQ_INFOMOVIL.SP_GETPHONEMAILPRIOR
            cs = con.getConnection().prepareCall("{call PQ_INFOGET_PG3.SP_GETPHONEMAILPRIOR (?,?,?,?,?)}");
            cs.setInt(1, domainId);
            cs.setInt(2, prior);//setea  parametro  para  enviar  al procedimiento parametro de  entrada
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);//tomas  parametro de salida de  la  base de datos
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.executeUpdate();//ejecuta  la  sentencia 
            String d = cs.getString(2);//obtener  salida del parametro  2
            
            result = cs.getString(3) != null ? cs.getString(3) : "";

            if (!result.equals("")) {
                result = (result.substring(6, result.length() - 1));
            }
            if (cs.getInt(4) != 0) {
                msgDescError = "Error de Base de Datos";
                msgCodeError = cs.getInt(4);
            } else {
                msgDescError = "Terminacion Normal";
                msgCodeError = 0;
            };
            con.getConnection().close();
            if (cs != null) {
                cs.close();
            }

            if (con != null) {
                con.getConnection().close();
            }
        } catch (SQLException sqle) {
//            log.info("Error method GeneradorPaginaDAO.getContactPrior:" + sqle.getErrorCode() + " SQL mjeCodeError:" + sqle.getMessage() + " Description error mjeDescError:" + msgDescError);
            con.getConnection().close();
        } finally {
//            log.info("Finally method GeneradorPaginaDAO.getContactPrior");
        }
        return result;
    }
}
