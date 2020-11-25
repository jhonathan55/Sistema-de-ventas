/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jhonathan
 */
public class Personas_has_despachosDao {
    
      
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Personas_has_despachos ingresar(int rut,int id) {
        Personas_has_despachos pd = new Personas_has_despachos();
        String guardar = "INSERT INTO personas_has_despachos VALUES(?,?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setInt(1, rut);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return pd;
    }
     public void eliminar(int rut,int id) {

        String actualizar = "DELETE FROM `personas_has_despachos` "
                + "WHERE `personas_has_despachos`.`Personas_rut` = ? AND `personas_has_despachos`.`Despachos_idDespachos` = ?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, rut);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }

        
    }
     
    
    
}
