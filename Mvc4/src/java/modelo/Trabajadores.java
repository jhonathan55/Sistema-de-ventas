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
public class Trabajadores {
    
    int rut;
    String pass,cargo,nombre;

    public Trabajadores() {
    }

    public Trabajadores(int rut, String pass, String cargo) {
        this.rut = rut;
        this.pass = pass;
        this.cargo = cargo;
    }

    public Trabajadores(int rut, String nombre, String cargo,String pass) {
        this.rut = rut;
        this.pass = pass;
        this.cargo = cargo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
          
    
}
