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
public class Aplica {
    private Dosis dosis;
    private CitaVacunacion cita;
    private LocalDate fecha;

    public Aplica(Dosis dosis, CitaVacunacion cita, LocalDate fecha) {
        this.dosis = dosis;
        this.cita = cita;
        this.fecha = fecha;
    }

    public Aplica() {
    }

    public Dosis getDosis() {
        return dosis;
    }

    public void setDosis(Dosis dosis) {
        this.dosis = dosis;
    }

    public CitaVacunacion getCita() {
        return cita;
    }

    public void setCita(CitaVacunacion cita) {
        this.cita = cita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Aplica{" + "dosis=" + dosis + ", cita=" + cita + ", fecha=" + fecha + '}';
    }
}
