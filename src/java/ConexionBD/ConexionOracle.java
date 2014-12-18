package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleDriver;

public class ConexionOracle {

//    private final String USUARIO = "desarrollo";
//    private final String PASS = "d3s4rr0ll0 ";
//    private final String SID = "SIA";
//    private final String HOST = "192.168.40.103";
//    private final int PUERTO = 1521;
//    ************************************
    private final String USUARIO = "pruebas";
    private final String PASS = "pruebas";
    private final String SID = "xe";
    private final String HOST = "localhost";
    private final int PUERTO = 1521;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void registrarDriver() throws SQLException {
        OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(oracleDriver);
    }

    public void conectar() throws SQLException {
        if (connection == null || connection.isClosed() == true) {
            String cadenaConexion = "jdbc:oracle:thin:@" + HOST + ":" + PUERTO + ":" + SID;
            registrarDriver();
            connection = DriverManager.getConnection(cadenaConexion, USUARIO, PASS);
        }
    }

    public void cerrar() throws SQLException {
        if (connection != null && connection.isClosed() == false) {
            connection.close();
        }
    }

    public static void main(String args[]) {

        ConexionOracle conexionOracle = new ConexionOracle();
        try {
            conexionOracle.conectar();
            Connection conn = conexionOracle.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
            while (rset.next()) {
                System.out.println(rset.getString(1));   // Print col 1
            }
            stmt.close();
            conexionOracle.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
