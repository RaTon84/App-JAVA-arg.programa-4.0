/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Conexion {
      private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "bomberogrupo6";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public Conexion() {
    }

    public static Connection getConexion() {

        if (connection == null) {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                //JOptionPane.showMessageDialog(null,"Drivers conectado");
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
                //JOptionPane.showMessageDialog(null,"Conectado a la base de datos");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error a la carga de drivers" + ex.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD" + ex.getMessage());

            }

        }
        return connection;
    }
}
