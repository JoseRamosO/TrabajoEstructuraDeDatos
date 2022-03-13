/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaUsuarios;

/**
 *
 * @author Randall
 */
public class ListaSimple {

    private Nodo ultimo;
    private Nodo primero;
    private int CantN;

    public ListaSimple() {
        this.ultimo = null;
        this.primero = null;
    }

    public boolean esVacia() {
        return (this.primero == null);
    }

    public void RMPrimero() {
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            if (primero.getSiguiente() == null) {
                this.ultimo = null;
            }
            this.primero = primero.getSiguiente();
            this.CantN--;
        }
    }

    public void RMUltimo() {
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            Nodo actual = primero;
            Nodo temp = primero;
            if (primero.getSiguiente() == null) {
                this.primero = null;
            }
            while (actual != this.ultimo) {
                temp = actual;
                actual = actual.getSiguiente();
            }
            this.ultimo = temp;
            this.ultimo.setSiguiente(null);
            this.CantN--;
        }
    }

    public void removerEnPosicion(int posicion) {
        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            Nodo actual = this.primero;
            Nodo temp = this.primero;

            if (posicion == 1) {
                this.RMPrimero();
            } else if (posicion == this.CantN) {
                this.RMUltimo();
            } else {
                for (int i = 1; i < posicion; i++) {
                    temp = actual;
                    actual = actual.getSiguiente();
                }
                temp.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(null);
                this.CantN--;
            }

        }

    }

    public boolean esPosicionValida(int indice) {
        return indice > 0 && indice <= this.CantN + 1;
    }

    public void insertarEnPosicion(Usuario p, int posicion) {
        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            Nodo nuevo = new Nodo(p);
            Nodo actual = this.primero;
            Nodo temp = this.primero;
            if (posicion == 1) {
                this.insertarPrimero(p);
            } else if (posicion == this.CantN + 1) {
                this.insertarFInal(p);
            } else {
                for (int j = 1; j <= (posicion - 1); j++) {
                    if (j == (posicion - 1)) {
                        nuevo.setSiguiente(primero.getSiguiente());
                        this.primero.setSiguiente(nuevo);
                        if (posicion == 2) {
                            temp = this.primero;
                        }
                    } else {
                        this.primero = this.primero.getSiguiente();
                    }
                }
                this.primero = temp;
                this.CantN++;
            }

        }
    }

    public void insertarPrimero(Usuario p) {
        Nodo nuevo = new Nodo(p);
        if (esVacia()) {
            this.ultimo = nuevo;

        } else {

        }
        nuevo.setSiguiente(primero);
        this.primero = nuevo;
        this.CantN = this.CantN + 1;
    }

    public void insertarFInal(Usuario p) {
        Nodo nuevo = new Nodo(p);
        if (esVacia()) {
            this.primero = nuevo;

        } else {
            this.ultimo.setSiguiente(nuevo);
        }
        this.ultimo = nuevo;
        this.CantN = this.CantN + 1;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public int getCantN() {
        return CantN;
    }

    public void setCantN(int CantN) {
        this.CantN = CantN;
    }

}
