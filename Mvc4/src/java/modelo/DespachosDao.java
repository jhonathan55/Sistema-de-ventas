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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonathan
 */
public class DespachosDao {
    
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Despachos ingresar(String direccion) {
        Despachos d = new Despachos();
        String guardar = "INSERT INTO despachos (direccion) VALUES(?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setString(1, direccion);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return d;
    }

    public Despachos actualizar(String direccion, int id) {
        Despachos d = new Despachos();
        String actualizar = "update despachos set direccion=? where idDespachos=?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setString(1, direccion);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return d;
    }

    public void eliminar(int id) {

        String actualizar = "DELETE FROM `despachos` WHERE `despachos`.`idDespachos` =?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

    public String idDespachos(){
        String idD="";
        String max = "SELECT max(idDespachos) from despachos";
        try {
            con = cn.con;
            ps = con.prepareStatement(max);
            rs=ps.executeQuery();
             while(rs.next()){
                idD=(rs.getString(1));
            }
        } catch (Exception e) {
            
        }
        return idD;
    }
    
    public Despachos listarId(int id){
        String sql="select * from despachos where idDespachos=?";
        Despachos d=new Despachos();
        
         try{
            con=cn.con;
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                d.setId(rs.getInt("idDespachos"));
                d.setDireccion(rs.getString("direccion"));
             
            }
            
        }catch(Exception e){
            
        }
        return d;
    }
    
}
