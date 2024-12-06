package uml.version;

/**
 * Clase que representa la vista simplificada de un paciente para el TableView.
 */
public class VistaPaciente {
    private final int nroPaciente;
    private final String tipoDni;
    private final String nroDni;
    private final String nombre;
    private final String apellido;
    private final String direccion;
    private final String barrio;
    private final boolean jefeFamilia;
    private final String fechaNacimiento;
    private final String obraSocial;
    private final String alergias;
    private final String medicamentosActuales;
    private final String enfermedadesCronicas;
    private final String contactoEmergenciaNombre; // Opcional
    private final String contactoEmergenciaTelefono; // Opcional
    private final String contactoEmergenciaRelacion; // Opcional
    private final String historialCirugias; // Opcional
    private final String historialHospitalizaciones; // Opcional

    public VistaPaciente(int nroPaciente,String tipoDni, String nroDni, String nombre, String apellido, 
                         String direccion, String barrio, boolean jefeFamilia, String fechaNacimiento, 
                         String obraSocial, String alergias, String medicamentosActuales, 
                         String enfermedadesCronicas, String contactoEmergenciaNombre, 
                         String contactoEmergenciaTelefono, String contactoEmergenciaRelacion, 
                         String historialCirugias, String historialHospitalizaciones) {
        this.nroPaciente = nroPaciente;
        this.tipoDni = tipoDni;
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.barrio = barrio;
        this.jefeFamilia = jefeFamilia;
        this.fechaNacimiento = fechaNacimiento;
        this.obraSocial = obraSocial;
        this.alergias = alergias;
        this.medicamentosActuales = medicamentosActuales;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.contactoEmergenciaNombre = contactoEmergenciaNombre;
        this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
        this.contactoEmergenciaRelacion = contactoEmergenciaRelacion;
        this.historialCirugias = historialCirugias;
        this.historialHospitalizaciones = historialHospitalizaciones;
    }

    // Getters para las columnas del TableView
    public int getNroPaciente() {
        return nroPaciente;
    }
    
     public String getTipoDni() {
        return tipoDni;
    }


    public String getNroDni() {
        return nroDni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public boolean getJefeFamilia() {
        return jefeFamilia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getMedicamentosActuales() {
        return medicamentosActuales;
    }

    public String getEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }

    public String getContactoEmergenciaNombre() {
        return contactoEmergenciaNombre;
    }

    public String getContactoEmergenciaTelefono() {
        return contactoEmergenciaTelefono;
    }

    public String getContactoEmergenciaRelacion() {
        return contactoEmergenciaRelacion;
    }

    public String getHistorialCirugias() {
        return historialCirugias;
    }

    public String getHistorialHospitalizaciones() {
        return historialHospitalizaciones;
    }
}
