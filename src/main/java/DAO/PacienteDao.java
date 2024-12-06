/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PacienteDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nico
 */
public class PacienteDao implements Dao<PacienteDto> {
    private ConexionSql conexion;
    private List<PacienteDto> paciente;

    @Override
    public PacienteDto buscar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PacienteDto> listarPorCriterio(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insertar(PacienteDto dto) {
        this.conexion = new ConexionSql();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            con = this.conexion.getConnection();
            con.setAutoCommit(false); // Inicia una transacción

            // Paso 1: Insertar en la tabla personas
            String sqlPersonas = "INSERT INTO personas (nombre, apellido, tipo_dni, nro_dni, direccion, barrio, fecha_nacimiento) "
                               + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sqlPersonas, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, dto.getNombre());
            pstmt.setString(2, dto.getApellido());
            pstmt.setString(3, dto.getTipoDni());
            pstmt.setString(4, dto.getNroDni());
            pstmt.setString(5, dto.getDireccion());
            pstmt.setString(6, dto.getBarrio());
            pstmt.setString(7, dto.getFechaNacimiento());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new SQLException("Error al insertar en la tabla personas.");
            }

            // Obtener el ID generado
            int idPersona = 0;
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idPersona = rs.getInt(1);
            } else {
                throw new SQLException("Error al obtener el ID generado para personas.");
            }

            // Paso 2: Insertar en la tabla pacientes
            String sqlPacientes = "INSERT INTO pacientes (persona_id, nro_paciente, jefe_familia, obra_social, alergias, medicamentos_actuales, enfermedades_cronicas, contacto_emergencia_nombre, contacto_emergencia_telefono, contacto_emergencia_relacion, historial_cirugias, historial_hospitalizaciones) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sqlPacientes);

            pstmt.setInt(1, idPersona); // Relación con la tabla personas
            pstmt.setInt(2, dto.getNroPaciente());
            pstmt.setBoolean(3, dto.isJefeFamilia());
            pstmt.setString(4, dto.getObraSocial());
            pstmt.setString(5, String.join(",", dto.getAlergias()));
            pstmt.setString(6, String.join(",", dto.getMedicamentosActuales()));
            pstmt.setString(7, String.join(",", dto.getEnfermedadesCronicas()));
            pstmt.setString(8, dto.getContactoEmergenciaNombre());
            pstmt.setString(9, dto.getContactoEmergenciaTelefono());
            pstmt.setString(10, dto.getContactoEmergenciaRelacion());
            pstmt.setString(11, String.join(",", dto.getHistorialCirugias()));
            pstmt.setString(12, String.join(",", dto.getHistorialHospitalizaciones()));

            filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new SQLException("Error al insertar en la tabla pacientes.");
            }

            // Confirmar la transacción
            con.commit();
            resultado = true;

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback(); // Deshacer los cambios en caso de error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return resultado;
    }


    @Override
    public boolean modificar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean borrar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PacienteDto obtenerPorOrden(int orden) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PacienteDto> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
