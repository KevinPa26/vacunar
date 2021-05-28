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
public class Sufre {
    private Persona persona;
    private Patologia patologia;

    public Sufre(Persona persona, Patologia patologia) {
        this.persona = persona;
        this.patologia = patologia;
    }

    public Sufre() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Patologia getPatologia() {
        return patologia;
    }

    public void setPatologia(Patologia patologia) {
        this.patologia = patologia;
    }

    @Override
    public String toString() {
        return "Sufre{" + "persona=" + persona + ", patologia=" + patologia + '}';
    }
}
