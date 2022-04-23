
package ListaCircularDobleServicios;

import java.io.Serializable;


public class NodoLCD implements Serializable{
    
    private Servicios Servicios;
    private NodoLCD siguiente;
    private NodoLCD anterior;

    public NodoLCD(Servicios persona) {
        this.Servicios = persona;
    }

    public Servicios getServicios() {
        return Servicios;
    }

    public void setServicios(Servicios Servicios) {
        this.Servicios = Servicios;
    }

    public NodoLCD getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLCD siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLCD getAnterior() {
        return anterior;
    }
    public void setAnterior(NodoLCD anterior) {
        this.anterior = anterior;
    }
    
    
                
}
