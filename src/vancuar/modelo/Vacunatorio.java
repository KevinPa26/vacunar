/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vancuar.modelo;

/**
 *
 * @author kevin
 */
public class Vacunatorio {
    private int idVacunatorio;
    private String nombre;
    private String departamento;
    private String ciudad;

    public Vacunatorio(int idVacunatorio, String nombre, String departamento, String ciudad) {
        this.idVacunatorio = idVacunatorio;
        this.nombre = nombre;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Vacunatorio(String nombre, String departamento, String ciudad) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Vacunatorio() {
    }

    public int getIdVacunatorio() {
        return idVacunatorio;
    }

    public void setIdVacunatorio(int idVacunatorio) {
        this.idVacunatorio = idVacunatorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Vacunatorio{" + "idVacunatorio=" + idVacunatorio + ", nombre=" + nombre + ", departamento=" + departamento + ", ciudad=" + ciudad + '}';
    }
}
