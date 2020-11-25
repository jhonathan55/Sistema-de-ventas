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
public class Personas {

    int rut,idDespachos;
    String nombre, direccion, correo, fono, dv;

    public Personas() {
    }

    public Personas(int rut, String dv, String nombre, String direccion, String correo, String fono) {
        this.rut = rut;
        this.dv = dv;
        this.fono = fono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Personas(int rut, String dv, String nombre, String direccion,int idDespachos) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idDespachos=idDespachos;

    }
 public Personas(int rut, String dv, String nombre, String direccion) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.direccion = direccion;

    }
    public int getIdDespachos() {
        return idDespachos;
    }

    public void setIdDespachos(int idDespachos) {
        this.idDespachos = idDespachos;
    }

    
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
