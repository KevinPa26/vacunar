/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vancuar.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class VacunatorioData {
    Connection con;

    public VacunatorioData(Conexion conexion) {
        con = conexion.getConnection();
    }
    
    public void crearVacunatorio(Vacunatorio vac){
        try {
            String sql = "INSERT INTO vacunatorio(nombre, departamento, ciudad) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vac.getNombre());
            ps.setString(2, vac.getDepartamento());
            ps.setString(3, vac.getCiudad());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                vac.setIdVacunatorio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El vacunatorio se creo correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "El vacunatorio no se pudo crear");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el vacunatorio");
        }
    }
    
    public Vacunatorio buscarVacunatorioId(int id){
        Vacunatorio vac = null;
        try {
            String sql = "SELECT * FROM vacunatorio WHERE idVacunatorio = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                vac = new Vacunatorio();
                vac.setIdVacunatorio(rs.getInt(1));
                vac.setNombre(rs.getString(2));
                vac.setDepartamento(rs.getString(3));
                vac.setCiudad(rs.getString(4));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el vacunatorio");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el vacunatorio");
        }
        return vac;
    }
    
    public Vacunatorio buscarVacunatorioNombre(String nom){
        Vacunatorio vac = null;
        try {
            String sql = "SELECT * FROM vacunatorio WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                vac = new Vacunatorio();
                vac.setIdVacunatorio(rs.getInt(1));
                vac.setNombre(rs.getString(2));
                vac.setDepartamento(rs.getString(3));
                vac.setCiudad(rs.getString(4));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el vacunatorio");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el vacunatorio");
        }
        return vac;
    }
    
    public List<Vacunatorio> traerTodoVacunatorio(){
        List<Vacunatorio> vacs = new ArrayList<>();
        Vacunatorio vac = null;
        try {
            String sql = "SELECT * FROM vacunatorio";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                vac = new Vacunatorio();
                vac.setIdVacunatorio(rs.getInt(1));
                vac.setNombre(rs.getString(2));
                vac.setDepartamento(rs.getString(3));
                vac.setCiudad(rs.getString(4));
                vacs.add(vac);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer todos los vacunatorios");
        }
        return vacs;
    }
}
