/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.OrdenDto;

/**
 *
 * @author facundito
 */
public class OrdenDaoFactory extends DaoFactory {
    @Override
    public Dao<OrdenDto> createDao() {
        // Crea y retorna un nuevo PacienteDao
        return new OrdenDao();
    }
}

