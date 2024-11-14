/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DTO.PacienteDto;


/**
 *
 * @author facundito
 */
public class PacienteDao implements Dao<PacienteDto> {
    
    private ConexionSql conexion;

    @Override
    public PacienteDto buscar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PacienteDto> listarPorCriterio(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PacienteDto> listarTodos() {
        this.conexion = new ConexionSql();
        Connection con;
        Statement sentencia = null;
        ResultSet rs = null;
        List<PacienteDto> lista = new ArrayList<>();

        try {
            con = this.conexion.getConnection();
            String sql = "select c.id, c.nombre, c.apellido, c.dni "
                    + "from cliente c "
                    + "order by c.nombre, c.apellido";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int id;
            String nombreCli, apellidoCli, dniCli;
            PacienteDto cliente;

            while (rs.next()) {
                id = rs.getInt("c.id");
                nombreCli = rs.getString("c.nombre");
                apellidoCli = rs.getString("c.apellido");
                dniCli = rs.getString("c.dni");
                cliente = new PacienteDto(id, nombreCli, apellidoCli, dniCli);
                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
                this.conexion.cerrar();
            } catch (Exception ex) {

            }
        }
        return lista;
    }

    @Override
    public boolean insertar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
