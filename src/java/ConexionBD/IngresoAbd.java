/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import beans.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class IngresoAbd {

    Connection con;
    private Statement sentencia;
    private ResultSet result;
    private PreparedStatement Statement;
    String user;
    String pass;
    String BaseDeDatos;
    private String errorInsert;

    public IngresoAbd(String user, String pass) {
        this.user = user;
        this.pass = pass;

    }

    public boolean insertarRegistro(String cadena) throws SQLException, ClassNotFoundException {
        boolean ba = false;
        Conexion laConexion = new Conexion(user, pass);
        try {
            con = laConexion.getConnection();

            Statement sentencia;
            // conexion = DriverManager.getConnection(BaseDeDatos, user, pass);
            sentencia = con.createStatement();
            sentencia.executeUpdate(cadena);
            System.out.println("Se inserto correctamente");
            con.close();
        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(null, ex.getMessage());
            setErrorInsert(ex.getMessage());
            ba = true;
        }
        if (ba == false) {
            // JOptionPane.showMessageDialog(null, "Operacion Correcta");
            setErrorInsert("Operación Correcta");
        }

        return ba;
    }

    public List<BaseDatos> getResult(String cadena) throws SQLException {
        //Crear sentencia para hacer consulta
        BaseDatos bd = new BaseDatos();
        List<BaseDatos> datos = new ArrayList<>();
        Conexion laConexion = new Conexion(user, pass);
        try {
            con = laConexion.getConnection();
            Statement = con.prepareStatement(cadena);
            result = Statement.executeQuery();
            ResultSetMetaData rsMetaData = result.getMetaData();
            int i = rsMetaData.getColumnCount();

            while (result.next()) {
                bd = new BaseDatos();
                bd.setClave(result.getString(i));
                bd.setNombre(result.getString(i - 1));
                datos.add(bd);

            }

            con.close();
        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(null, ex.getMessage());
            setErrorInsert(ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoAbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    /**
     * @return the errorInsert
     */
    public String getErrorInsert() {
        return errorInsert;
    }

    /**
     * @param errorInsert the errorInsert to set
     */
    public void setErrorInsert(String errorInsert) {
        this.errorInsert = errorInsert;
    }

}
