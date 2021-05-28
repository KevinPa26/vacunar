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
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class CitaVacunacionData {
    Connection con;
    PersonaData pd;
    VacunatorioData vd;

    public CitaVacunacionData(Conexion conexion) {
        con = conexion.getConnection();
        pd = new PersonaData(conexion);
        vd = new VacunatorioData(conexion);
    }
    
    public void crearCitaVacunacion(CitaVacunacion cv){
        try {
            String sql = "INSERT INTO cita_vacunacion(idPersona, idVacunatorio, fecha, hora, estado, dosis) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cv.getPersona().getIdPersona());
            ps.setInt(2, cv.getVacunatorio().getIdVacunatorio());
            ps.setDate(3, Date.valueOf(cv.getFecha()));
            ps.setTime(4, Time.valueOf(cv.getHora()));
            ps.setString(5, cv.getEstado());
            ps.setString(6, cv.getDosis());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                cv.setIdCita(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "La cita de vacunacion se creo correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo crear la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la cita de vacunacion");
        }
    }
    
    public CitaVacunacion buscarCitaVacunacionId(int id){
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE idCita = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return cv;
    }
    
    public CitaVacunacion buscarCitaVacunacionIdPersona(int id){
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE idPersona = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return cv;
    }
    
    public List<CitaVacunacion> traerCitaVacunacionIdVacunatorio(int id){
        List<CitaVacunacion> citas = new ArrayList<>();
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE idVacunatorio = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
                citas.add(cv);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return citas;
    }
    
    public List<CitaVacunacion> traerCitaVacunacionFecha(LocalDate fecha){
        List<CitaVacunacion> citas = new ArrayList<>();
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE fecha = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
                citas.add(cv);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return citas;
    }
    
    public List<CitaVacunacion> traerCitaVacunacionHora(LocalTime hora){
        List<CitaVacunacion> citas = new ArrayList<>();
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE fecha = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTime(1, Time.valueOf(hora));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
                citas.add(cv);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return citas;
    }
    
    public List<CitaVacunacion> traerCitaVacunacionEstado(String estado){
        List<CitaVacunacion> citas = new ArrayList<>();
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE estado = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
                citas.add(cv);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return citas;
    }
    
    public List<CitaVacunacion> traerCitaVacunacionDosis(String dosis){
        List<CitaVacunacion> citas = new ArrayList<>();
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion WHERE dosis = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dosis);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
                citas.add(cv);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return citas;
    }
    
    public List<CitaVacunacion> traerTodoCitaVacunacion(){
        List<CitaVacunacion> citas = new ArrayList<>();
        CitaVacunacion cv = null;
        try {
            String sql = "SELECT * FROM cita_vacunacion";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cv = new CitaVacunacion();
                cv.setIdCita(rs.getInt(1));
                cv.setPersona(pd.buscarPersonaId(rs.getInt(2)));
                cv.setVacunatorio(vd.buscarVacunatorioId(rs.getInt(3)));
                cv.setFecha(LocalDate.parse(String.valueOf(rs.getDate(4))));
                cv.setHora(LocalTime.parse(String.valueOf(rs.getTime(5))));
                cv.setEstado(rs.getString(6));
                cv.setDosis(rs.getString(7));
                citas.add(cv);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro la cita de vacunacion");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cita de vacunacion");
        }
        return citas;
    }
}
