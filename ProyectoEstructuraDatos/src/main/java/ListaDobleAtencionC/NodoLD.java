/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDobleAtencionC;

import java.io.Serializable;

/**
 *
 * @author Jose Ramos
 */
public class NodoLD implements Serializable{

    private AtencionC atencionC;
    private NodoLD siguiente;
    private NodoLD anterior;

    public NodoLD(AtencionC persona) {
        this.atencionC = persona;
    }

    public void setSiguiente(NodoLD siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLD getSiguiente() {
        return siguiente;
    }

    public AtencionC getAtencionC() {
        return atencionC;
    }

    public void setAtencionC(AtencionC atencionC) {
        this.atencionC = atencionC;
    }

    public NodoLD getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLD anterior) {
        this.anterior = anterior;
    }

}
