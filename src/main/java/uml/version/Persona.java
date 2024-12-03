/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

/**
 *
 * @author facundito
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String tipo_dni;
    private String nro_dni;
    private String direccion;
    private String fecha_nacimiento;
    
    public Persona(String nombre, String apellido, String tipo_dni, String nro_dni, String direccion, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_dni = tipo_dni;
        this.nro_dni = nro_dni;
        this.direccion = direccion;
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

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }
    
}
