/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PacienteDto;

/**
 *
 * @author facundito
 */
public class PacienteDaoFactory extends DaoFactory {
    
    @Override
    public Dao<PacienteDto> createDao() {
        // Crea y retorna un nuevo PacienteDao
        return new PacienteDao();
    }
}
