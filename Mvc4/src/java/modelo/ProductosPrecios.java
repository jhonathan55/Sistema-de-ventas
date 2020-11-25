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
public class ProductosPrecios {
    
   int id;
   String fecha;
   double neto,iva,bruto;

    public ProductosPrecios() {
    }

    public ProductosPrecios(int id, String fecha, double neto, double iva, double bruto) {
        this.id = id;
        this.fecha = fecha;
        this.neto = neto;
        this.iva = iva;
        this.bruto = bruto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
   
}
