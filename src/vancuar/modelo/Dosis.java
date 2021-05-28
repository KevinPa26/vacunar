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
public class Dosis {
    private int idDosis;
    private Laboratorio lab;
    private int numSerie;
    private boolean estado;

    public Dosis(int idDosis, Laboratorio lab, int numSerie, boolean estado) {
        this.idDosis = idDosis;
        this.lab = lab;
        this.numSerie = numSerie;
        this.estado = estado;
    }

    public Dosis(Laboratorio lab, int numSerie, boolean estado) {
        this.lab = lab;
        this.numSerie = numSerie;
        this.estado = estado;
    }

    public Dosis() {
    }

    public int getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(int idDosis) {
        this.idDosis = idDosis;
    }

    public Laboratorio getLab() {
        return lab;
    }

    public void setLab(Laboratorio lab) {
        this.lab = lab;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Dosis{" + "idDosis=" + idDosis + ", lab=" + lab + ", numSerie=" + numSerie + ", estado=" + estado + '}';
    }
}
