/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import uml.version.Paciente;

/**
 *
 * @author facundito
 */
public class OrdenDto {
    private int nro_orden;
    private String servicio;
    private String turno;
    private String diagnostico;
    private String fecha_consulta;
    private String estado;
    private Paciente paciente;
    
    // Constructor completo
    public OrdenDto(int nro_orden, String servicio, String turno, String diagnostico, String fechaConsulta, String estado1, int pacienteId) {
        this.nro_orden = nro_orden;
        this.servicio = servicio;
        this.turno = turno;
        this.diagnostico = diagnostico;
        this.fecha_consulta = fecha_consulta;
        this.estado = estado;
        this.paciente = paciente; // Paciente se pasa como un objeto.
    }


    // Getters
    public int getNroOrden() {
        return nro_orden;
    }

    public String getServicio() {
        return servicio;
    }

    public String getTurno() {
        return turno;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getFechaConsulta() {
        return fecha_consulta;
    }

    public String getEstado() {
        return estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }


    // Setters
    public void setNroOrden(int nro_orden) {
        this.nro_orden = nro_orden;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setFechaConsulta(String fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getPacienteId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

