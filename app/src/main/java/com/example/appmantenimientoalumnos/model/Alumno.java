package com.example.appmantenimientoalumnos.model;

public class Alumno {

    private final int id;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String correoElectronico;
    private final String direccion;
    private final String fechaNacimiento;
    private final String dni;
    private final String carrera;
    private final String ciclo;
    private final String estado;

    public Alumno(int id, String nombre, String apellido, String telefono,
                  String correoElectronico, String direccion, String fechaNacimiento,
                  String dni, String carrera, String ciclo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.carrera = carrera;
        this.ciclo = ciclo;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getDireccion() { return direccion; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getDni() { return dni; }
    public String getCarrera() { return carrera; }
    public String getCiclo() { return ciclo; }
    public String getEstado() { return estado; }
}
