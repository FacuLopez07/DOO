package DAO;

import DTO.OrdenDto;
import DTO.PacienteDto;

public abstract class DaoFactory {

    // Factory Method para crear un Dao
    public abstract Dao<OrdenDto> createDao();

    // Método estático para obtener un Dao según la clase
    @SuppressWarnings("unchecked")
    public static <T> Dao<T> getDao(Class<T> clazz) {
        if (clazz == OrdenDto.class) {
            // Crear un Dao específico para OrdenDto
            return (Dao<T>) new OrdenDao();
        }
        throw new IllegalArgumentException("No se puede crear un DAO para la clase: " + clazz.getName());
    }
    
    // Factory Method para crear un Dao
    public abstract Dao<PacienteDto> createPacienteDao();

    // Método estático para obtener un Dao según la clase
    @SuppressWarnings("unchecked")
    public static <T> Dao<T> getPacienteDao(Class<T> clazz) {
        if (clazz == PacienteDto.class) {
            // Crear un Dao específico para PacienteDto
            return (Dao<T>) new PacienteDao();
        }
        throw new IllegalArgumentException("No se puede crear un DAO para la clase: " + clazz.getName());
    }
}
