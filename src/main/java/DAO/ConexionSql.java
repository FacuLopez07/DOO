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
    private static final String URL = "jdbc:sqlite:baseDeDatos.db";// Cambia esto a la ubicación de tu archivo SQLite
    private Connection connection = null;

    public ConexionSql() {
        abrir();
    }

    private void abrir() {
        try {
            this.connection = DriverManager.getConnection(URL);
            System.out.println("ATR");
        } catch (SQLException e) {
            this.connection = null;
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    public void cerrar() {
        try {
            if (this.connection != null) {
                this.connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            this.connection = null;
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}
