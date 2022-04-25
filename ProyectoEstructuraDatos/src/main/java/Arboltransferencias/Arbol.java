package Arboltransferencias;

import ReportesPila.Pila;
import java.io.Serializable;

public class Arbol implements Serializable{

    private NodoArbol raiz;
    private int cantNodos;

    public Arbol() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void insertar(Transferencia transferencia) {
        if (esVacio()) {
            raiz = new NodoArbol(transferencia);
            this.cantNodos++;
        } else {
            insertar(raiz, transferencia);
            this.cantNodos++;
        }

    }

    public void insertar(NodoArbol nodo, Transferencia transferencia) {
        //si el dato que estoy insertando es menor al actual, entonces se debe colocar a la izquierda

        if (transferencia.getId() < nodo.getTransferencia().getId()) {

            //compruebo si el nodo izquierdo no tiene nada
            if (nodo.getHijoizq() == null) {
                nodo.setHijoizq(new NodoArbol(transferencia));
            } //
            else {
                insertar(nodo.getHijoizq(), transferencia);
            }

        } //--------------------------------------------------------------------------------------------
        //si el valor que estoy insertando es mayor al actual, entonces se debe insertar a la derecha
        //
        else {
            //compruebo si el nodo derecho no tiene nada 
            if (nodo.getHijoder() == null) {
                nodo.setHijoder(new NodoArbol(transferencia));
            } else {
                insertar(nodo.getHijoder(), transferencia);
            }

        }

    }

    //--------------------------------------------------------------------------------------------
    public void listarPreOrder() {
        if (esVacio()) {
            System.out.print("Arbol vacio");
        } else {
            listarPreOrder(this.raiz);
        }

    }

    public void listarPreOrder(NodoArbol nodo) {
        if (nodo != null) {
            System.out.println(nodo.getTransferencia().getEjecutivo().getNombre()+"|"+
                    nodo.getTransferencia().getUsuario().getName()+"|"+
                    nodo.getTransferencia().getServicio().getNombre()+"|"+
                    nodo.getTransferencia().getFechayHora()+"|"
                    + "-->");
            listarPreOrder(nodo.getHijoizq());
            listarPreOrder(nodo.getHijoder());
        }

    }
    //--------------------------------------------------------------------------------------------

    public void listarInOrder() {
        if (esVacio()) {
            System.out.print("Arbol vacio");
        } else {
            listarInOrder(this.raiz);
        }

    }

    public void listarInOrder(NodoArbol nodo) {
        if (nodo != null) {
            listarInOrder(nodo.getHijoizq());
            System.out.println(nodo.getTransferencia().getEjecutivo().getNombre()+"|"+
                    nodo.getTransferencia().getUsuario().getName()+"|"+
                    nodo.getTransferencia().getServicio().getNombre()+"|"+
                    nodo.getTransferencia().getFechayHora()+"|"
                    + "-->");
            listarInOrder(nodo.getHijoder());
        }

    }
    ///--------------------------------------------------------------------------------------------
       public Pila ArbolPila() {
           Pila pila=new Pila();
        if (esVacio()) {
            System.out.print("Arbol vacio");
        } else {
            
            ArbolPila(this.raiz,pila);
        }
        return pila;
    }

    public Pila ArbolPila(NodoArbol nodo, Pila pila) {
        if (nodo != null) {
            ArbolPila(nodo.getHijoizq(),pila);
            pila.apilar(nodo.getTransferencia());
            ArbolPila(nodo.getHijoder(),pila);
        }
        
        return pila;
    }
    //--------------------------------------------------------------------------------------------

    public void listarPostOrden() {
        if (esVacio()) {
            System.out.print("Arbol vacio");
        } else {
            listarPostOrden(this.raiz);
        }
    }

    public void listarPostOrden(NodoArbol nodo) {
        if (nodo != null) {
            listarPostOrden(nodo.getHijoizq());
            listarPostOrden(nodo.getHijoder());
            System.out.println(nodo.getTransferencia().getEjecutivo().getNombre()+"|"+
                    nodo.getTransferencia().getUsuario().getName()+"|"+
                    nodo.getTransferencia().getServicio().getNombre()+"|"+
                    nodo.getTransferencia().getFechayHora()+"|"
                    + "-->");
        }

    }
    //--------------------------------------------------------------------------------------------

    public NodoArbol menor(NodoArbol nodo) {

        if (nodo.getHijoizq() != null) {
            return menor(nodo.getHijoizq());
        }
        return nodo;
    }

    //--------------------------------------------------------------------------------------------
    public NodoArbol mayor(NodoArbol nodo) {

        if (nodo.getHijoder() != null) {
            return mayor(nodo.getHijoder());
        }
        return nodo;
    }

    //--------------------------------------------------------------------------------------------
    public NodoArbol buscar(Transferencia dato) {
        NodoArbol actual = this.raiz;

        while (actual.getTransferencia().getId()!= dato.getId()) {
            if (dato.getId() < actual.getTransferencia().getId()) {
                actual = actual.getHijoizq();
            } else {
                actual = actual.getHijoder();
            }

            if (actual == null) {
                return null;
            }
        }
        return actual;
    }

    //--------------------------------------------------------------------------------------------   
    public NodoArbol eliminar(NodoArbol nodo, Transferencia dato) {
        if (nodo == null) {
            return null;
        }

        //llegamos a la posicion del nodo que queremos eliminar
        if (dato.getId() < nodo.getTransferencia().getId()) {
            nodo.setHijoizq(eliminar(nodo.getHijoizq(), dato));
        } else if (dato.getId()> nodo.getTransferencia().getId()) {

            nodo.setHijoder(eliminar(nodo.getHijoder(), dato));
        } //--------------------------------------------------------------------
        else {
            //1er caso: el nodo es un nodo hoja
            if (nodo.getHijoizq() == null && nodo.getHijoder() == null) {
                nodo = null;
            } //el nodo a eliminar tiene un hijo derecho.
            else if (nodo.getHijoizq() == null) {
                nodo = nodo.getHijoder();
            } //si el nodo a eliminar tiene un hijo izquierdo
            else if (nodo.getHijoder() == null) {
                nodo = nodo.getHijoizq();

            } //el nodo a eliminar tiene sus dos hijos
            else {
                NodoArbol sucesor = encontrarSucesor(nodo.getHijoder());

                //copiamos el valor del sucesor al nodo actual
                nodo.setTransferencia(sucesor.getTransferencia());

                //eliminamos el nodo
                nodo.setHijoder(eliminar(nodo.getHijoder(), sucesor.getTransferencia()));
            }
        }
        return nodo;
    }

    private NodoArbol encontrarSucesor(NodoArbol nodo) {
        if (nodo.getHijoizq() == null) {
            return nodo;
        } else {
            return encontrarSucesor(nodo.getHijoizq());
        }

    }

    //--------------------------------------------------------------------------------------------   
    public int sumatoria(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }

        return (nodo.getTransferencia().getId() + sumatoria(nodo.getHijoizq()) + sumatoria(nodo.getHijoder()));
    }

//--------------------------------------------------------------------------------------------   
    //--------------------------------------------------------------------------------------------    
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }

}
