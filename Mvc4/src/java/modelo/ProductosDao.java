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
public class ProductosDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Productos ingresar(String nombre, int sku) {
        Productos p = new Productos();
        String guardar = "INSERT INTO productos (nombre,sku) VALUES(?,?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setString(1, nombre);
            ps.setInt(2, sku);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return p;
    }

    public Productos actualizar(String nombre, int sku, int id) {
        Productos p = new Productos();
        String actualizar = "update productos set nombre=?,sku=? where id=?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setString(1, nombre);
            ps.setInt(2, sku);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return p;
    }

    public void eliminar(int id) {
        String actualizar = "DELETE FROM `productos` WHERE `productos`.`id` =?";
        try {
            con = cn.con;
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

    public List<Productos> listar() {
        List<Productos> lstProductos = new ArrayList<Productos>();

        String listar = "select * from productos";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                int sku = rs.getInt(3);
                Productos p = new Productos(id, nombre, sku);
                lstProductos.add(p);
            }

        } catch (Exception e) {

        }

        return lstProductos;
    }

    public List<Productos> listarPrecios() {
        List<Productos> lstProductos = new ArrayList<Productos>();

        String listar = "SELECT p.id,p.nombre,p.sku,pp.fecha,pp.precioNeto,pp.iva,pp.bruto\n"
                + "FROM productos as p, productosprecios as pp\n"
                + "WHERE p.id=pp.productos_id";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                int sku = rs.getInt(3);
                String fecha = rs.getString(4);
                double neto = rs.getDouble(5);
                double iva = rs.getDouble(6);
                double bruto = rs.getDouble(7);

                Productos p = new Productos(id, nombre, sku, fecha, neto, iva, bruto);
                lstProductos.add(p);
            }

        } catch (Exception e) {

        }

        return lstProductos;
    }

    public Productos listarId(int id) {
        String sql = "SELECT p.id,p.nombre,p.sku,pp.fecha,pp.precioNeto,pp.iva,pp.bruto\n"
                + "FROM productos as p , productosprecios as pp\n"
                + "where p.id=pp.productos_id and p.id=?  \n"
                + "ORDER BY `pp`.`fecha`  DESC";
        Productos p = new Productos();

        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setSku(rs.getInt("sku"));
                p.setFecha(rs.getString("fecha"));
                p.setNeto(rs.getDouble("precioNeto"));
                p.setIva(rs.getDouble("iva"));
                p.setBruto(rs.getDouble("bruto"));

            }

        } catch (Exception e) {

        }
        return p;
    }

    public String idProductos() {
        String idD = "";
        String max = "SELECT max(id) from productos";
        try {
            con = cn.con;
            ps = con.prepareStatement(max);
            rs = ps.executeQuery();
            while (rs.next()) {
                idD = (rs.getString(1));
            }
        } catch (Exception e) {

        }
        return idD;
    }
}
