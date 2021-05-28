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
public class PersonaData {
    Connection con;

    public PersonaData(Conexion conexion) {
        con = conexion.getConnection();
    }
    
    public void crearPersona(Persona persona){
        try {
            String sql = "INSERT INTO persona(dni, nombre, apellido, altura, peso, fechaNac, celular, email, trabajo, departamento, ciudad) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, persona.getDni());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setDouble(4, persona.getAltura());
            ps.setDouble(5, persona.getPeso());
            ps.setDate(6, Date.valueOf(persona.getFechaNac()));
            ps.setLong(7, persona.getCelular());
            ps.setString(8, persona.getEmail());
            ps.setString(9, persona.getTrabajo());
            ps.setString(10, persona.getDepartamento());
            ps.setString(11, persona.getCiudad());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                persona.setIdPersona(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "La persona se creo correctamente.");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo crear la persona.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la persona.");
        }
    }
    
    public Persona buscarPersonaId(int id){
        Persona persona = null;
        try {
            String sql = "SELECT * FROM persona WHERE idPersona = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setDni(rs.getLong(2));
                persona.setNombre(rs.getString(3));
                persona.setApellido(rs.getString(4));
                persona.setAltura(rs.getDouble(5));
                persona.setPeso(rs.getDouble(6));
                persona.setFechaNac(LocalDate.parse(String.valueOf(rs.getDate(7))));
                persona.setCelular(rs.getLong(8));
                persona.setEmail(rs.getString(9));
                persona.setTrabajo(rs.getString(10));
                persona.setDepartamento(rs.getString(11));
                persona.setCiudad(rs.getString(12));
            }else{
                JOptionPane.showConfirmDialog(null, "No se encontro la persona");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error al buscar la persona");
        }
        return persona;
    }
    
    public Persona buscarPersonaDni(int dni){
        Persona persona = null;
        try {
            String sql = "SELECT * FROM persona WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setDni(rs.getLong(2));
                persona.setNombre(rs.getString(3));
                persona.setApellido(rs.getString(4));
                persona.setAltura(rs.getDouble(5));
                persona.setPeso(rs.getDouble(6));
                persona.setFechaNac(LocalDate.parse(String.valueOf(rs.getDate(7))));
                persona.setCelular(rs.getLong(8));
                persona.setEmail(rs.getString(9));
                persona.setTrabajo(rs.getString(10));
                persona.setDepartamento(rs.getString(11));
                persona.setCiudad(rs.getString(12));
            }else{
                JOptionPane.showConfirmDialog(null, "No se encontro la persona");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error al buscar la persona");
        }
        return persona;
    }
    
    public List<Persona> traerTodoPersona(){
        List<Persona> personas = new ArrayList<>();
        Persona persona = null;
        try {
            String sql = "SELECT * FROM persona";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setDni(rs.getLong(2));
                persona.setNombre(rs.getString(3));
                persona.setApellido(rs.getString(4));
                persona.setAltura(rs.getDouble(5));
                persona.setPeso(rs.getDouble(6));
                persona.setFechaNac(LocalDate.parse(String.valueOf(rs.getDate(7))));
                persona.setCelular(rs.getLong(8));
                persona.setEmail(rs.getString(9));
                persona.setTrabajo(rs.getString(10));
                persona.setDepartamento(rs.getString(11));
                persona.setCiudad(rs.getString(12));
                personas.add(persona);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer todas las personas");
        }
        return personas;
    }
}
