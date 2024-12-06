/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.OrdenDto;
import DTO.PacienteDto;

/**
 *
 * @author Nico
 */
public class PacienteDaoFactory extends DaoFactory {
    @Override
    public Dao<PacienteDto> createPacienteDao() {
        // Crea y retorna un nuevo Paciente
        return new PacienteDao();
    }

    @Override
    public Dao<OrdenDto> createDao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
