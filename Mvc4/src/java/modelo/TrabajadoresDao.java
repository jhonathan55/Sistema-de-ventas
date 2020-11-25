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
public class TrabajadoresDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Trabajadores validar(int rut, String pass) {
        String sql = "select * from trabajadores where Personas_rut=? and pass=?";
        Trabajadores t = new Trabajadores();

        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            ps.setInt(1, rut);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setRut(rs.getInt("Personas_rut"));
                t.setPass(rs.getString("pass"));
                t.setCargo(rs.getString("cargo"));
            }

        } catch (Exception e) {

        }
        return t;
    }

    public Trabajadores ingresar(int rut, String pass, String cargo) {
        Trabajadores t = new Trabajadores();
        String guardar = "INSERT INTO trabajadores VALUES(?,?,?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setInt(1, rut);
            ps.setString(2, pass);
            ps.setString(3, cargo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return t;
    }

    public Trabajadores actualizar(String pass, String cargo, int rut) {
        Trabajadores t = new Trabajadores();
        String actualizar = "update trabajadores set pass=?,cargo=? where rut=?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setString(1, pass);
            ps.setString(2, cargo);
            ps.setInt(3, rut);

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return t;
    }

    public void eliminar(int rut) {

        String actualizar = "DELETE FROM `trabajadores` WHERE `trabajadores`.`rut` =?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, rut);
            ps.executeUpdate();
        } catch (Exception e) {

        }

        // return pr;
    }

    public List<Trabajadores> listar() {
        List<Trabajadores> lstTrabajadores = new ArrayList<Trabajadores>();

        String listar = "SELECT p.rut,p.nombre,t.cargo,t.pass\n"
                + "FROM trabajadores as t, personas as p\n"
                + "WHERE t.Personas_rut=p.rut";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int rut = rs.getInt(1);
                String nombre = rs.getString(2);
                String cargo = rs.getString(3);
                String pass = rs.getString(4);
                Trabajadores t = new Trabajadores(rut, nombre, cargo, pass);
                lstTrabajadores.add(t);
            }

        } catch (Exception e) {

        }

        return lstTrabajadores;
    }

}
