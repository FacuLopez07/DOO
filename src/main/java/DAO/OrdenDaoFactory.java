/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.OrdenDto;
import DTO.PacienteDto;

/**
 *
 * @author facundito
 */
public class OrdenDaoFactory extends DaoFactory {
    @Override
    public Dao<OrdenDto> createDao() {
        // Crea y retorna un nuevo Orden
        return new OrdenDao();
    }

    @Override
    public Dao<PacienteDto> createPacienteDao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

