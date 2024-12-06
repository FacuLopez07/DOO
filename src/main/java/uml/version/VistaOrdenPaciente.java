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

    // Constructor
    public VistaOrdenPaciente(int nroOrden, String dniPaciente, String servicio, String fechaConsulta) {
        this.nroOrden = nroOrden;
        this.dniPaciente = dniPaciente;
        this.servicio = servicio;
        this.fechaConsulta = fechaConsulta;
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
}

