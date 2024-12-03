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
import DTO.OrdenDto;

/**
 *
 * @author facundito
 */
public class OrdenDao implements Dao<OrdenDto> {
    private ConexionSql conexion;
    private List<OrdenDto> ordenes;  // Definir la lista de pacientes

    @Override
    public OrdenDto buscar(OrdenDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<OrdenDto> listarPorCriterio(OrdenDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<OrdenDto> listarTodos() {
        this.conexion = new ConexionSql();
        Connection con;
        Statement sentencia = null;
        ResultSet rs = null;
        List<OrdenDto> lista = new ArrayList<>();

        try {
            con = this.conexion.getConnection();
            String sql = "select c.id, c.nombre, c.apellido, c.dni "
                    + "from cliente c "
                    + "order by c.nombre, c.apellido";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int id;
            String nombreCli, apellidoCli, dniCli;
            OrdenDto cliente;

            while (rs.next()) {
                id = rs.getInt("c.id");
                nombreCli = rs.getString("c.nombre");
                apellidoCli = rs.getString("c.apellido");
                dniCli = rs.getString("c.dni");
                cliente = new OrdenDto(id, nombreCli, apellidoCli, dniCli);
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
                // Manejo de excepciones
            }
        }
        ordenes = lista; // Asignar la lista de pacientes a la variable de instancia
        return lista;
    }

    @Override
    public boolean insertar(OrdenDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean modificar(OrdenDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean borrar(OrdenDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrdenDto obtenerPorOrden(int nro_orden) {
        if (ordenes == null) {
            // Si la lista es nula, cargar los pacientes
            listarTodos();
        }
        for (OrdenDto paciente : ordenes) {
            if (paciente.getId() == nro_orden) {
                return paciente;
            }
        }
        return null;
    }
}

