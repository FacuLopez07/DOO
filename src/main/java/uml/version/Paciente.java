package uml.version;

public class Paciente {
    private int orden;
    private String nombre;
    private String apellido;
    private String dni;
    private String estado;

    public Paciente(int orden, String nombre, String apellido, String dni, String estado) {
        this.orden = orden;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
    }

    public Integer getOrden() {
        return orden;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEstado() {
        return estado;
    }
}
