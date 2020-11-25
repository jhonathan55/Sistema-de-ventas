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
public class Productos {

    int id, sku;
    String nombre, fecha;
    double neto, iva, bruto;

    public Productos() {
    }

    public Productos(int id, String nombre, int sku) {
        this.id = id;
        this.nombre = nombre;
        this.sku = sku;
    }

    public Productos(String nombre, int sku) {
        this.sku = sku;
        this.nombre = nombre;
    }

    public Productos(int id, String nombre, int sku, String fecha, double neto, double iva, double bruto) {
        this.id = id;
        this.nombre = nombre;
        this.sku = sku;
        this.fecha = fecha;
        this.neto = neto;
        this.iva = iva;
        this.bruto = bruto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getBruto() {
        return bruto;
    }

    public void setBruto(double bruto) {
        this.bruto = bruto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
