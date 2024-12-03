package DAO;

import DTO.OrdenDto;

public abstract class DaoFactory {

    // Factory Method para crear un Dao
    public abstract Dao<OrdenDto> createDao();

    // Método estático para obtener un Dao según la clase
    @SuppressWarnings("unchecked")
    public static <T> Dao<T> getDao(Class<T> clazz) {
        if (clazz == OrdenDto.class) {
            // Crear un Dao específico para PacienteDto
            return (Dao<T>) new OrdenDao();
        }
        throw new IllegalArgumentException("No se puede crear un DAO para la clase: " + clazz.getName());
    }
}
