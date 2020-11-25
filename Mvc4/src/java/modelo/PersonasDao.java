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
public class PersonasDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Personas ingresar(int rut, String dv, String nombre, String direccion, String correo, String fono) {
        Personas p = new Personas();
        String guardar = "INSERT INTO personas VALUES(?,?,?,?,?,?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setInt(1, rut);
            ps.setString(2, dv);
            ps.setString(3, nombre);
            ps.setString(4, direccion);
            ps.setString(5, correo);
            ps.setString(6, fono);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return p;
    }

    public Personas actualizar(String dv, String nombre, String direccion, String correo, String fono, int rut) {
        Personas p = new Personas();
        String actualizar = "update personas set dv=?,nombre=?,direccion=?,correo=?,fono=? where rut=?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setString(1, dv);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, correo);
            ps.setString(5, fono);
            ps.setInt(6, rut);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return p;
    }

    public void eliminar(int rut) {

        String actualizar = "DELETE FROM `personas` WHERE `personas`.`rut` =?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, rut);
            ps.executeUpdate();
        } catch (Exception e) {

        }

        // return pr;
    }

    public List<Personas> listar() {
        List<Personas> lstPersonas = new ArrayList<Personas>();

        String listar = "select * from personas";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int rut = rs.getInt(1);
                String dv = rs.getString(2);
                String nombre = rs.getString(3);
                String direccion = rs.getString(4);
                String correo = rs.getString(5);
                String fono = rs.getString(6);
                Personas p = new Personas(rut, dv, nombre, direccion, correo, fono);
                lstPersonas.add(p);
            }

        } catch (Exception e) {

        }

        return lstPersonas;
    }

    public List<Personas> listarDespachos() {
        List<Personas> lstDespachos = new ArrayList<Personas>();

        String listar = "SELECT p.rut,p.dv,p.nombre,d.direccion as DireccionDespacho\n"
                + "FROM personas as p, personas_has_despachos as pd, despachos d\n"
                + "where p.rut=pd.Personas_rut and d.idDespachos=pd.Despachos_idDespachos";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);

            rs = ps.executeQuery();
            while (rs.next()) {

                int rut = rs.getInt(1);
                String dv = rs.getString(2);
                String nombre = rs.getString(3);
                String direccion = rs.getString(4);

                Personas p = new Personas(rut, dv, nombre, direccion);
                lstDespachos.add(p);
            }

        } catch (Exception e) {

        }

        return lstDespachos;
    }

    public List<Personas> listarDireccionesRut(int rut) {
        List<Personas> lstDespachosRut = new ArrayList<Personas>();
        String sql = "SELECT p.rut,p.dv,p.nombre,d.direccion\n"
                + "FROM personas as p, despachos as d, personas_has_despachos as pd\n"
                + "WHERE p.rut=pd.Personas_rut  and d.idDespachos=pd.Despachos_idDespachos and p.rut=?";

        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            ps.setInt(1, rut);
            rs = ps.executeQuery();
            while (rs.next()) {

                int rut1 = rs.getInt(1);
                String dv = rs.getString(2);
                String nombre = rs.getString(3);
                String direccion = rs.getString(4);

                Personas p = new Personas(rut1, dv, nombre, direccion);
                lstDespachosRut.add(p);
            }

        } catch (Exception e) {

        }
        return lstDespachosRut;
    }

    public Personas listarRut(int rut) {
        String sql = "select * from personas where rut=?";
        Personas p = new Personas();

        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            ps.setInt(1, rut);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setRut(rs.getInt("rut"));
                p.setDv(rs.getString("dv"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setCorreo(rs.getString("correo"));
                p.setFono(rs.getString("fono"));
            }

        } catch (Exception e) {

        }
        return p;
    }

    public Personas listarDespachosRut(int rut) {
        String sql = "SELECT p.rut,p.dv,p.nombre,d.direccion,d.idDespachos\n"
                + "FROM personas as p, despachos as d, personas_has_despachos as pd\n"
                + "WHERE p.rut=pd.Personas_rut  and d.idDespachos=pd.Despachos_idDespachos and p.rut=?";
        Personas p = new Personas();
        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            ps.setInt(1, rut);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setRut(rs.getInt("rut"));
                p.setDv(rs.getString("dv"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setIdDespachos(rs.getInt("idDespachos"));
                

            }

        } catch (Exception e) {

        }
        return p;
    }

}
