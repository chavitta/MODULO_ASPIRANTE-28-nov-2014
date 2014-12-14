/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Conexion {

    // private Connection conexion;
    private String user;
    private String pass;
//     private String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
    private String BaseDeDatos = "jdbc:oracle:thin:@192.168.40.103:1521:SIA";
    private String error;
    private boolean b = false;

    public Conexion(String usuario, String password) {
        this.pass = password;
        this.user = usuario;

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        setB(false);

        Connection conexion = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try {
                conexion = DriverManager.getConnection(getBaseDeDatos(), getUser(), getPass());
                System.out.println("se  hizo conexion");
            } catch (SQLException a) {
//                JOptionPane.showMessageDialog(null, "  " + a.getMessage());
                System.out.println("///" + a.getMessage() + "///");
                setError(a.getMessage());
                conexion = null;
            } finally {
//                conexion.close();
            }
        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Error en el driver " + e.getMessage());
            setError(e.getMessage());
            conexion = null;
        }
        return conexion;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the BaseDeDatos
     */
    public String getBaseDeDatos() {
        return BaseDeDatos;
    }

    /**
     * @param BaseDeDatos the BaseDeDatos to set
     */
    public void setBaseDeDatos(String BaseDeDatos) {
        this.BaseDeDatos = BaseDeDatos;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the b
     */
    public boolean isB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(boolean b) {
        this.b = b;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Conexion c=new  Conexion("fichas", "fichas");
//        c.getConnection();
        System.out.println( c.getConnection());
        System.out.println(c);
        System.out.println(c.getError());
    }
}
