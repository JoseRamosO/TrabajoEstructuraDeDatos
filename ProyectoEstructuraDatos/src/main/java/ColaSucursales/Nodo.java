/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColaSucursales;

import java.io.Serializable;

/**
 *
 * @author Randall
 */
public class Nodo implements Serializable{

    private Sucursal Sucursal;
    private Nodo Siguiente;

    public Nodo(Sucursal Sucursal) {
        this.Sucursal = Sucursal;
        this.Siguiente = null;
    }

    public Sucursal getSucursal() {
        return Sucursal;
    }

    public void setSucursal(Sucursal Sucursal) {
        this.Sucursal = Sucursal;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo Siguiente) {
        this.Siguiente = Siguiente;
    }
    
}
