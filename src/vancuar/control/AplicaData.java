/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vancuar.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vancuar.modelo.*;

/**
 *
 * @author kevin
 */
public class AplicaData {
    Connection con;
    DosisData dd;
    CitaVacunacionData cvd;

    public AplicaData(Conexion conexion) {
        con = conexion.getConnection();
        dd = new DosisData(conexion);
        cvd = new CitaVacunacionData(conexion);
    }
    
    public void crearAplica(Aplica aplica){
        try {
            String sql = "INSERT INTO aplica(idDosis, idCita, fecha_aplica) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, aplica.getDosis().getIdDosis());
            ps.setInt(2, aplica.getCita().getIdCita());
            ps.setDate(3, Date.valueOf(aplica.getFecha()));
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "La aplica se creo correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo crear aplica");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear aplica");
        }
    }
    
    public Aplica buscarAplicaIdDosis(int id){
        Aplica aplica = null;
        try {
            String sql = "SELECT * FROM aplica WHERE idDosis = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                aplica = new Aplica();
                aplica.setDosis(dd.buscarDosisId(rs.getInt(1)));
                aplica.setCita(cvd.buscarCitaVacunacionId(rs.getInt(2)));
                aplica.setFecha(LocalDate.parse(String.valueOf(rs.getDate(3))));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar aplica");
        }
        return aplica;
    }
    
    public List<Aplica> traerAplicaIdCita(int id){
        List<Aplica> aplicas = new ArrayList<>();
        Aplica aplica = null;
        try {
            String sql = "SELECT * FROM aplica WHERE idCita = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                aplica = new Aplica();
                aplica.setDosis(dd.buscarDosisId(rs.getInt(1)));
                aplica.setCita(cvd.buscarCitaVacunacionId(rs.getInt(2)));
                aplica.setFecha(LocalDate.parse(String.valueOf(rs.getDate(3))));
                aplicas.add(aplica);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer aplica con el id cita");
        }
        return aplicas;
    }
    
    public List<Aplica> traerAplicaFecha(LocalDate fecha){
        List<Aplica> aplicas = new ArrayList<>();
        Aplica aplica = null;
        try {
            String sql = "SELECT * FROM aplica WHERE fecha_aplica = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                aplica = new Aplica();
                aplica.setDosis(dd.buscarDosisId(rs.getInt(1)));
                aplica.setCita(cvd.buscarCitaVacunacionId(rs.getInt(2)));
                aplica.setFecha(LocalDate.parse(String.valueOf(rs.getDate(3))));
                aplicas.add(aplica);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer aplica con la fecha");
        }
        return aplicas;
    }
}
