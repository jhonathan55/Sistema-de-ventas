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
public class Despachos {
    
    int id;
    String direccion;

    public Despachos() {
    }

    public Despachos(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public Despachos(String direccion) {
        this.direccion = direccion;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
          
    
}
