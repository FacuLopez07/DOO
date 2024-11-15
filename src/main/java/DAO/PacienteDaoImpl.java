/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PacienteDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author facundito
 */
public class PacienteDaoImpl implements Dao<PacienteDto> {
    
    private final List<PacienteDto> pacientes = new ArrayList<>();

    // Constructor simulado para añadir datos iniciales
    public PacienteDaoImpl() {
        pacientes.add(new PacienteDto(1, "Juan", "Pérez", "1111111"));
        pacientes.add(new PacienteDto(2, "Maria", "Gonzalez", "2222222"));
    }

    @Override
    public PacienteDto buscar(PacienteDto dto) {
        for (PacienteDto paciente : pacientes) {
            if (paciente.getId() == dto.getId()) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public List<PacienteDto> listarPorCriterio(PacienteDto dto) {
        // Implementación de ejemplo, puedes ajustarla
        return new ArrayList<>();
    }

    @Override
    public List<PacienteDto> listarTodos() {
        return pacientes;
    }

    @Override
    public boolean insertar(PacienteDto dto) {
        return pacientes.add(dto);
    }

    @Override
    public boolean modificar(PacienteDto dto) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() == dto.getId()) {
                pacientes.set(i, dto);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean borrar(PacienteDto dto) {
        return pacientes.removeIf(paciente -> paciente.getId() == dto.getId());
    }

    // Método adicional para obtener por "Orden"
    public PacienteDto obtenerPorOrden(int orden) {
        for (PacienteDto paciente : pacientes) {
            if (paciente.getId() == orden) {
                return paciente;
            }
        }
        return null;
    }
    
}
