/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DTO.OrdenDto;

/**
 *
 * @author facundito
 */
public class OrdenDao implements Dao<OrdenDto> {
    private ConexionSql conexion;
    private List<OrdenDto> ordenes;

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
            String sql = "SELECT c.nro_orden, c.servicio, c.turno, c.diagnostico, c.fecha_consulta, c.estado, c.paciente_id "
                       + "FROM orden c "
                       + "ORDER BY c.fecha_consulta";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int nroOrden, pacienteId;
            String servicio, turno, diagnostico, fechaConsulta, estado;
            OrdenDto orden;

            while (rs.next()) {
                nroOrden = rs.getInt("c.nro_orden");
                servicio = rs.getString("c.servicio");
                turno = rs.getString("c.turno");
                diagnostico = rs.getString("c.diagnostico");
                fechaConsulta = rs.getString("c.fecha_consulta");
                estado = rs.getString("c.estado");
                pacienteId = rs.getInt("c.paciente_id");

                orden = new OrdenDto(nroOrden, servicio, turno, diagnostico, fechaConsulta, estado, pacienteId);
                lista.add(orden);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (sentencia != null) sentencia.close();
                this.conexion.cerrar();
            } catch (Exception ex) {
                // Manejo de excepciones
            }
        }
        ordenes = lista;
        return lista;
    }

    @Override
    public boolean insertar(OrdenDto dto) {
        this.conexion = new ConexionSql();
        Connection con;
        PreparedStatement pstmt = null;
        boolean resultado = false;

        try {
            con = this.conexion.getConnection();
            String sql = "INSERT INTO orden (nro_orden, servicio, turno, diagnostico, fecha_consulta, estado, paciente_id) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, dto.getNroOrden());
            pstmt.setString(2, dto.getServicio());
            pstmt.setString(3, dto.getTurno());
            pstmt.setString(4, dto.getDiagnostico());
            pstmt.setString(5, dto.getFechaConsulta());
            pstmt.setString(6, dto.getEstado());
            pstmt.setInt(7, dto.getPacienteId());

            resultado = pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                this.conexion.cerrar();
            } catch (Exception ex) {
                // Manejo de excepciones
            }
        }

        return resultado;
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
            listarTodos();
        }
        for (OrdenDto orden : ordenes) {
            if (orden.getNroOrden() == nro_orden) {
                return orden;
            }
        }
        return null;
    }
}
