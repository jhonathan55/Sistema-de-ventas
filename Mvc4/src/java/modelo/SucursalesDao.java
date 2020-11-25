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
public class SucursalesDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Sucursales ingresar(String nombre, String direccion, String fecha, String tipo) {
        Sucursales s = new Sucursales();
        String guardar = "INSERT INTO sucursales (nombre,direccion,fechainicio,tipo) VALUES(?,?,?,?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, fecha);
            ps.setString(4, tipo);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return s;
    }

    public Sucursales actualizar(String nombre, String direccion, String fecha, String tipo, int id) {
        Sucursales s = new Sucursales();
        String actualizar = "update sucursales set nombre=?,direccion=?,fechainicio=?,tipo=? where id=?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, fecha);
            ps.setString(4, tipo);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return s;
    }

    public void eliminar(int id) {

        String actualizar = "DELETE FROM `sucursales` WHERE `sucursales`.`id` =?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }

        // return pr;
    }

    public List<Sucursales> listar() {
        List<Sucursales> lstSucursales = new ArrayList<Sucursales>();

        String listar = "select * from sucursales";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String fecha = rs.getString(4);
                String tipo = rs.getString(5);

                Sucursales s = new Sucursales(id, nombre, direccion, fecha, tipo);
                lstSucursales.add(s);
            }

        } catch (Exception e) {

        }

        return lstSucursales;
    }

}
