package DAO;

import DTO.PacienteDto;

public abstract class DaoFactory {

    // Factory Method para crear un Dao
    public abstract Dao<PacienteDto> createDao();

    // Método estático para obtener un Dao según la clase
    @SuppressWarnings("unchecked")
    public static <T> Dao<T> getDao(Class<T> clazz) {
        if (clazz == PacienteDto.class) {
            // Crear un Dao específico para PacienteDto
            return (Dao<T>) new PacienteDao();
        }
        throw new IllegalArgumentException("No se puede crear un DAO para la clase: " + clazz.getName());
    }
}
