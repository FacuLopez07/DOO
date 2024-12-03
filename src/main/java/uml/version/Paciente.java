package uml.version;

public class Paciente {
    private int orden;
    private Persona persona;
    private boolean jefe_familia;

    public Paciente(int orden, String nombre, String apellido, String dni) {
        this.orden = orden;
        
    }

    // Métodos de acceso para obtener los atributos de Paciente
    public int getOrden() {
        return orden;
    }

    public boolean isJefeFamilia() {
        return jefe_familia;
    }

    // Métodos de acceso para obtener los datos de la persona
    public String getNombre() {
        return persona != null ? persona.getNombre() : null;
    }

    public String getApellido() {
        return persona != null ? persona.getApellido() : null;
    }

    public String getTipoDni() {
        return persona != null ? persona.getTipoDni() : null;
    }
    
    public String getNroDni() {
        return persona != null ? persona.getNroDni() : null;
    }

    public String getDireccion() {
        return persona != null ? persona.getDireccion() : null;
    }

    public String getFechaNacimiento() {
        return persona != null ? persona.getFechaNacimiento() : null;
    }
}
