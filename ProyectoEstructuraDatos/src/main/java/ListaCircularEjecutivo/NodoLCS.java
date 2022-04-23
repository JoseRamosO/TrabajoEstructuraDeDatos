
package ListaCircularEjecutivo;

import java.io.Serializable;


public class NodoLCS implements Serializable {
    
    private Ejecutivo persona;
    private NodoLCS siguiente;

    public NodoLCS(Ejecutivo persona) {
        this.persona = persona;
    }

    public Ejecutivo getEjecutivo() {
        return persona;
    }

    public void setEjecutivo(Ejecutivo persona) {
        this.persona = persona;
    }

    public NodoLCS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLCS siguiente) {
        this.siguiente = siguiente;
    }

    
    
                
}
