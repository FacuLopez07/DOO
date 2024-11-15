package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DTO.PacienteDto;

public class PacienteDao implements Dao<PacienteDto> {
    
    private ConexionSql conexion;
    private List<PacienteDto> pacientes;  // Definir la lista de pacientes

    @Override
    public PacienteDto buscar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PacienteDto> listarPorCriterio(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
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
                // Manejo de excepciones
            }
        }
        pacientes = lista; // Asignar la lista de pacientes a la variable de instancia
        return lista;
    }

    @Override
    public boolean insertar(PacienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        if (pacientes == null) {
            // Si la lista es nula, cargar los pacientes
            listarTodos();
        }
        for (PacienteDto paciente : pacientes) {
            if (paciente.getId() == orden) {
                return paciente;
            }
        }
        return null;
    }
}
