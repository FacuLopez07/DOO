/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

/**
 *
 * @author agusm
 */
public class VistaOrdenPaciente {
    private int nroOrden;
    private String dniPaciente;
    private String servicio;
    private String fechaConsulta;
    private String nombre;
    private String turno;
    private String apellido;
    private String estado;
    private String diagnostico;

    // Constructor
    public VistaOrdenPaciente(int nroOrden, String dniPaciente, String servicio, String fechaConsulta, String nombre, String turno, String apellido, String estado, String diagnostico) {
        this.nroOrden = nroOrden;
        this.dniPaciente = dniPaciente;
        this.servicio = servicio;
        this.fechaConsulta = fechaConsulta;
        this.turno = turno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.diagnostico = diagnostico;
    }

    // Getters y Setters
    public int getNroOrden() { return nroOrden; }
    public void setNroOrden(int nroOrden) { this.nroOrden = nroOrden; }

    public String getDniPaciente() { return dniPaciente; }
    public void setDniPaciente(String dniPaciente) { this.dniPaciente = dniPaciente; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public String getFechaConsulta() { return fechaConsulta; }
    public void setFechaConsulta(String fechaConsulta) { this.fechaConsulta = fechaConsulta; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
   
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }


    
}

