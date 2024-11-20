package DTO;

import java.util.Date;

/**
 *
 * @author facundito
 */
public class DiagnosticoDto {
    private PacienteDto paciente;
    private String diagnostico;
    private String observaciones;
    private Date fechaDiagnostico;
    
    // Constructor privado, solo accesible desde el Builder
    private DiagnosticoDto(Builder builder) {
        this.paciente = builder.paciente;
        this.diagnostico = builder.diagnostico;
        this.observaciones = builder.observaciones;
        this.fechaDiagnostico = builder.fechaDiagnostico;
    }
    
    public PacienteDto getPaciente() {
        return paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    // El Builder estático interno
    public static class Builder {
        private PacienteDto paciente;
        private String diagnostico;
        private String observaciones;
        private Date fechaDiagnostico;

        // Método para establecer el paciente
        public Builder setPaciente(PacienteDto paciente) {
            this.paciente = paciente;
            return this;
        }

        // Método para establecer el diagnóstico
        public Builder setDiagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
            return this;
        }

        // Método para establecer observaciones
        public Builder setObservaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }

        // Método para establecer la fecha
        public Builder setFechaDiagnostico(Date fechaDiagnostico) {
            this.fechaDiagnostico = fechaDiagnostico;
            return this;
        }

        // Método para construir el objeto Diagnóstico
        public DiagnosticoDto build() {
            return new DiagnosticoDto(this);
        }
    }
}
