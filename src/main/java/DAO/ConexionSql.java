/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author facundito
 */
public class ConexionSql {
    private static final String URL = "jdbc:mysql://localhost:3306/ejemplo-completo-fx-2024?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "doo-2024";
    private static final String PASSWORD = "doo-2024";
    private Connection connection = null;

    public ConexionSql() {
        abrir();
    }

    private void abrir() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            this.connection = null;
        } 
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    public void cerrar() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            this.connection = null;
        }
    }
}
