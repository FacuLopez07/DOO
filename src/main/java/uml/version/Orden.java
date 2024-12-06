/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

import java.util.Date;

/**
 *
 * @author facundito
 */
public class Orden {
    private int nro_orden;
    private String servicio;
    private String turno;
    private String diagnostico;
    private Date fecha_consulta;
    private String estado;
    private Paciente paciente;

    public Orden(int nro_orden, String servicio, String turno, String diagnostico, Date fecha_consulta, String estado, Paciente paciente) {
        this.nro_orden = nro_orden;
        this.servicio = servicio;
        this.turno = turno;
        this.diagnostico = diagnostico;
        this.fecha_consulta = fecha_consulta;
        this.estado = estado;
        this.paciente = paciente; // Paciente se pasa como un objeto.
    }


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

    public Date getFechaConsulta() {
        return fecha_consulta;
    }

    public String getEstado() {
        return estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getApellido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getDni() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
