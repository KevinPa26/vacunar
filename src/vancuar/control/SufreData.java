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
public class SufreData {
    Connection con;
    PersonaData pd;
    PatologiaData patod;

    public SufreData(Conexion conexion) {
        con = conexion.getConnection();
        pd = new PersonaData(conexion);
        patod = new PatologiaData(conexion);
    }
    
    public void crearSufre(Sufre suf){
        try {
            String sql = "INSERT INTO sufre(idPersona, idPatologia) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, suf.getPersona().getIdPersona());
            ps.setInt(2, suf.getPatologia().getIdPatologia());
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "se creo el sufre");
            }else{
                JOptionPane.showMessageDialog(null, "No se creo el sufre");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el sufre");
        }
    }
    
    public List<Sufre> traerSufreIdPersona(int idPersona){
        List<Sufre> sufres = new ArrayList<>();
        Sufre sufre = null;
        try {
            String sql = "SELECT * FROM sufre WHERE idPersona = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sufre = new Sufre();
                sufre.setPersona(pd.buscarPersonaId(rs.getInt(1)));
                sufre.setPatologia(patod.buscarPatologiaId(rs.getInt(2)));
                sufres.add(sufre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer los sufre por idPersona");
        }
        return sufres;
    }
    
    public List<Sufre> traerSufreIdPatologia(int idPatologia){
        List<Sufre> sufres = new ArrayList<>();
        Sufre sufre = null;
        try {
            String sql = "SELECT * FROM sufre WHERE idPatologia = ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPatologia);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sufre = new Sufre();
                sufre.setPersona(pd.buscarPersonaId(rs.getInt(1)));
                sufre.setPatologia(patod.buscarPatologiaId(rs.getInt(2)));
                sufres.add(sufre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer los sufre por idPersona");
        }
        return sufres;
    }
}
