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
public class ProductosPreciosDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ProductosPrecios ingresar(int id, String fecha, double neto, double iva, double bruto) {
        ProductosPrecios p = new ProductosPrecios();
        String guardar = "INSERT INTO productosprecios VALUES(?,?,?,?,?)";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setInt(1, id);
            ps.setString(2, fecha);
            ps.setDouble(3, neto);
            ps.setDouble(4, iva);
            ps.setDouble(5, bruto);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return p;
    }
    
    public List<ProductosPrecios> listar() {
        List<ProductosPrecios> lstProductosPrecios = new ArrayList<ProductosPrecios>();

        String listar = "select * from productosprecios";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String fecha = rs.getString(2);
                double neto = rs.getDouble(3);
                double iva = rs.getDouble(4);
                double bruto = rs.getDouble(3);
                ProductosPrecios p = new ProductosPrecios(id, fecha, neto,iva,bruto);
                lstProductosPrecios.add(p);
            }

        } catch (Exception e) {

        }

        return lstProductosPrecios;
    }

    public ProductosPrecios listarID(int id) {
        String sql = "select * from productosprecios where productos_id=?";
        ProductosPrecios p = new ProductosPrecios();

        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("productos_id"));
                p.setFecha(rs.getString("fecha"));
                p.setNeto(rs.getDouble("precioNeto"));
                p.setIva(rs.getDouble("iva"));
                p.setBruto(rs.getDouble("bruto"));

            }

        } catch (Exception e) {

        }
        return p;
    }

}
