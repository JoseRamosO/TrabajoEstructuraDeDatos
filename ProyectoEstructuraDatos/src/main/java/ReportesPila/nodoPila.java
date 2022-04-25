/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportesPila;

import Arboltransferencias.Transferencia;

/**
 *
 * @author Jose Ramos
 */
public class nodoPila {
        private Transferencia dato;
        private nodoPila siguiente;

    
    public nodoPila() {
        this.dato = null;
        this.siguiente = null;
    }

    public Transferencia getDato() {
        return dato;
    }

    public void setDato(Transferencia dato) {
        this.dato = dato;
    }

    

    public nodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoPila siguiente) {
        this.siguiente = siguiente;
    }
        
}
