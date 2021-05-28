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
public class Patologia {
    private int idPatologia;
    private String nombre;

    public Patologia(int idPatologia, String nombre) {
        this.idPatologia = idPatologia;
        this.nombre = nombre;
    }

    public Patologia(String nombre) {
        this.nombre = nombre;
    }

    public Patologia() {
    }

    public int getIdPatologia() {
        return idPatologia;
    }

    public void setIdPatologia(int idPatologia) {
        this.idPatologia = idPatologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
