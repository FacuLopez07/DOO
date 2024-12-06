package uml.version;

import java.util.List;

public class Paciente extends Persona {
    private int nro_paciente; // Obligatorio
    private boolean jefe_familia; // Opcional
    private String obra_social;
    private String alergias; // Opcional
    private String medicamentosActuales; // Opcional
    private String enfermedadesCronicas; // Opcional
    private String contactoEmergenciaNombre; // Opcional
    private String contactoEmergenciaTelefono; // Opcional
    private String contactoEmergenciaRelacion; // Opcional
    private String historialCirugias; // Opcional
    private String historialHospitalizaciones; // Opcional

    // Constructor privado
    private Paciente(PacienteBuilder builder) {
        super(builder.nombre, builder.apellido, builder.tipo_dni, builder.nro_dni, builder.direccion, builder.barrio, builder.fecha_nacimiento);
        this.nro_paciente = builder.nro_paciente;
        this.jefe_familia = builder.jefe_familia;
        this.obra_social = builder.obra_social;
        this.medicamentosActuales = builder.medicamentosActuales;
        this.enfermedadesCronicas = builder.enfermedadesCronicas;
        this.contactoEmergenciaNombre = builder.contactoEmergenciaNombre;
        this.contactoEmergenciaTelefono = builder.contactoEmergenciaTelefono;
        this.contactoEmergenciaRelacion = builder.contactoEmergenciaRelacion;
        this.historialCirugias = builder.historialCirugias;
        this.historialHospitalizaciones = builder.historialHospitalizaciones;   
    }

    // Métodos de acceso
    public int getNroPaciente() {
        return nro_paciente;
    }

    public boolean isJefeFamilia() {
        return jefe_familia;
    }
    
    public String getObraSocial() {
       return obra_social;
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

    // Clase interna estática Builder
    public static class PacienteBuilder {
        // Atributos obligatorios
        private final String nombre;
        private final String apellido;
        private final String tipo_dni;
        private final String nro_dni;
        private final String direccion; 
        private final String barrio;
        private final String fecha_nacimiento;
        private final int nro_paciente; // Valor predeterminado
        
        // Atributos opcionales
        private boolean jefe_familia = false; // Valor predeterminado
        private String obra_social = "";
        private String alergias; // Opcional
        private String medicamentosActuales; // Opcional
        private String enfermedadesCronicas; // Opcional
        private String contactoEmergenciaNombre; // Opcional
        private String contactoEmergenciaTelefono; // Opcional
        private String contactoEmergenciaRelacion; // Opcional
        private String historialCirugias; // Opcional
        private String historialHospitalizaciones; // Opcional
        
        // Constructor del Builder con atributos obligatorios
        public PacienteBuilder(String nombre, String apellido, String tipo_dni, String nro_dni, String direccion,String barrio, String fecha_nacimiento, int nro_paciente) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.tipo_dni = tipo_dni;
            this.nro_dni = nro_dni;
            this.direccion = direccion;
            this.barrio = barrio;
            this.fecha_nacimiento = fecha_nacimiento;
            this.nro_paciente = nro_paciente;
        }

        public PacienteBuilder setJefeFamilia(boolean jefe_familia) {
            this.jefe_familia = jefe_familia;
            return this;
        }
        
        public PacienteBuilder setObraSocial(String obra_social) {
            this.obra_social = obra_social;
            return this;
        }
        
        
        public PacienteBuilder setAlergias(String alergias) {
            this.alergias = alergias;
            return this;
        }

        public PacienteBuilder setMedicamentosActuales(String medicamentosActuales) {
            this.medicamentosActuales = medicamentosActuales;
            return this;
        }

        public PacienteBuilder setEnfermedadesCronicas(String enfermedadesCronicas) {
            this.enfermedadesCronicas = enfermedadesCronicas;
            return this;
        }
        
        public PacienteBuilder setContactoEmergenciaNombre(String contactoEmergenciaNombre) {
            this.contactoEmergenciaNombre = contactoEmergenciaNombre;
            return this;
        }

        public PacienteBuilder setContactoEmergenciaTelefono(String contactoEmergenciaTelefono) {
            this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
            return this;
        }

        public PacienteBuilder setContactoEmergenciaRelacion(String contactoEmergenciaRelacion) {
            this.contactoEmergenciaRelacion = contactoEmergenciaRelacion;
            return this;
        }

        public PacienteBuilder setHistorialCirugias(String historialCirugias) {
            this.historialCirugias = historialCirugias;
            return this;
        }

        public PacienteBuilder setHistorialHospitalizaciones(String historialHospitalizaciones) {
            this.historialHospitalizaciones = historialHospitalizaciones;
            return this;
        }

        // Método para construir el objeto
        public Paciente build() {
            return new Paciente(this);
        }
    }
}
