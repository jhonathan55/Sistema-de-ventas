/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jhonathan
 */
public class Ventas {

    int cantidad, num, id, idSucursal, rutCli, idDespacho, rutVendedor, idPro;
    String fecha, fechaDespacho, nombrePro;
    double total, descuento, subTotal, precio;

    public Ventas() {
    }

    public Ventas(int num, int id, String nombrePro, double precio, int cantidad, double subTotal) {
        this.num = num;
        this.id = id;
        this.nombrePro = nombrePro;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;

    }

    public Ventas(int id, String fecha, int idSucursal, int rutVendedor, int rutCli, int idDespacho,
            double total, String fechaDespacho, double descuento, double subTotal) {
        this.id = id;
        this.idSucursal = idSucursal;
        this.rutCli = rutCli;
        this.idDespacho = idDespacho;
        this.rutVendedor = rutVendedor;
        this.fecha = fecha;
        this.fechaDespacho = fechaDespacho;
        this.total = total;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }

    public Ventas(String fecha, int idSucursal, int rutVendedor, int rutCli, int idDespacho,
            double total, String fechaDespacho, double descuento) {

        this.idSucursal = idSucursal;
        this.rutCli = rutCli;
        this.idDespacho = idDespacho;
        this.rutVendedor = rutVendedor;
        this.fecha = fecha;
        this.fechaDespacho = fechaDespacho;
        this.total = total;
        this.descuento = descuento;

    }

    public Ventas(int id, int idPro, int cantidad) {
        this.id = id;
        this.idPro = idPro;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getRutCli() {
        return rutCli;
    }

    public void setRutCli(int rutCli) {
        this.rutCli = rutCli;
    }

    public int getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
    }

    public int getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(int rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(String fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
