/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vancuar.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author kevin
 */
public class CitaVacunacion {
    private int idCita;
    private Persona persona;
    private Vacunatorio vacunatorio;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private String dosis;

    public CitaVacunacion(int idCita, Persona persona, Vacunatorio vacunatorio, LocalDate fecha, LocalTime hora, String estado, String dosis) {
        this.idCita = idCita;
        this.persona = persona;
        this.vacunatorio = vacunatorio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.dosis = dosis;
    }

    public CitaVacunacion(Persona persona, Vacunatorio vacunatorio, LocalDate fecha, LocalTime hora, String estado, String dosis) {
        this.persona = persona;
        this.vacunatorio = vacunatorio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.dosis = dosis;
    }

    public CitaVacunacion() {
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Vacunatorio getVacunatorio() {
        return vacunatorio;
    }

    public void setVacunatorio(Vacunatorio vacunatorio) {
        this.vacunatorio = vacunatorio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    

    @Override
    public String toString() {
        return "CitaVacunacion{" + "idCita=" + idCita + ", persona=" + persona + ", vacunatorio=" + vacunatorio + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + '}';
    }
}
