/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nico
 */
public abstract class PersonaDto {
    private String nombre;
    private String apellido;
    private String tipo_dni;
    private String nro_dni;
    private String direccion;
    private String barrio;
    private String fecha_nacimiento;
    
    public PersonaDto(String nombre, String apellido, String tipo_dni, String nro_dni, String direccion, String barrio, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_dni = tipo_dni;
        this.nro_dni = nro_dni;
        this.direccion = direccion;
        this.barrio = barrio;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoDni() {
        return tipo_dni;
    }

    public String getNroDni() {
        return nro_dni;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public String getBarrio() {
        return barrio;
    }    

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }
    
}
