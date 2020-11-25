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
public class VentasDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int numBolera() {
        String sql = "SELECT max(idVentas) FROM `ventas`";
        int boleta =0;
        try {
            con = cn.con;
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                boleta=rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return boleta;
    }

    public Ventas ingresar(String fecha, int idSucursal, int rutVendedor, int rutCliente,
            int idDespacho, double total, String fechaDespacho, double descuento) {
        Ventas v = new Ventas();
        String guardar = "INSERT INTO `ventas` (`fecha`, `sucursales_id`, `rutvendedor`, `cliente_rut`, "
                + "`Despachos_idDespachos`, `total`, `fechaDes`, `descuento`) VALUES (?,?,?,"
                + "?,?,?,?,?);";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setString(1, fecha);
            ps.setInt(2, idSucursal);
            ps.setInt(3, rutVendedor);
            ps.setInt(4, rutCliente);
            ps.setInt(5, idDespacho);
            ps.setDouble(6, total);
            ps.setString(7, fechaDespacho);
            ps.setDouble(8, descuento);
         
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return v;
    }   
       public Ventas ingresar_vp(int id,int idPro,int cantidad) {
        Ventas v = new Ventas();
        String guardar = "INSERT INTO `ventas_has_productos` (`ventas_id`, `productos_id`, `cantidad`) VALUES (?, ?, ?);";
        try {
            con = cn.con;
            ps = con.prepareStatement(guardar);
            ps.setInt(1, id);
            ps.setInt(2, idPro);
            ps.setInt(3, cantidad);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return v;
    }  
    public List<Ventas> listar() {
        List<Ventas> lstVentas = new ArrayList<Ventas>();

        String listar = "select * from Ventas";

        try {
            con = cn.con;
            ps = con.prepareStatement(listar);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String fecha = rs.getString(2);
                int idSucursal = rs.getInt(3);
                int rutVendedor = rs.getInt(4);
                int rutCliente = rs.getInt(5);
                int idDespacho = rs.getInt(6);
                double total = rs.getDouble(7);
                String fechaDespacho = rs.getString(8);
                double descuento = rs.getDouble(9);
                double subTotal = rs.getDouble(10);

                Ventas v = new Ventas(id, fecha, idSucursal, rutVendedor, rutCliente, idDespacho, total, fechaDespacho,
                        descuento, subTotal);
                lstVentas.add(v);
            }

        } catch (Exception e) {

        }

        return lstVentas;
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

}
