/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vancuar.modelo;

import java.time.LocalDate;

/**
 *
 * @author kevin
 */
public class Persona {
    private int idPersona;
    private long dni;
    private String nombre;
    private String apellido;
    private double altura;
    private double peso;
    private LocalDate fechaNac;
    private long celular;
    private String email;
    private String trabajo;
    private String departamento;
    private String ciudad;

    public Persona(int idPersona, long dni, String nombre, String apellido, double altura, double peso, LocalDate fechaNac, long celular, String email, String trabajo, String departamento, String ciudad) {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.email = email;
        this.trabajo = trabajo;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Persona(long dni, String nombre, String apellido, double altura, double peso, LocalDate fechaNac, long celular, String email, String trabajo, String departamento, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.email = email;
        this.trabajo = trabajo;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Persona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
}
