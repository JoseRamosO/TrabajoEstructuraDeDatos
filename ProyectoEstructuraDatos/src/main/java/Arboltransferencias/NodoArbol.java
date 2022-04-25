
package Arboltransferencias;

import java.io.Serializable;


public class NodoArbol implements Serializable{
    
    private Transferencia transferencia;
    private NodoArbol hijoizq;
    private NodoArbol hijoder;

    public NodoArbol(Transferencia transferencia) {
        this.transferencia = transferencia;
        this.hijoizq = null;
        this.hijoder = null;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public NodoArbol getHijoizq() {
        return hijoizq;
    }

    public void setHijoizq(NodoArbol hijoizq) {
        this.hijoizq = hijoizq;
    }

    public NodoArbol getHijoder() {
        return hijoder;
    }

    public void setHijoder(NodoArbol hijoder) {
        this.hijoder = hijoder;
    }
    
    
    
    
    
}
