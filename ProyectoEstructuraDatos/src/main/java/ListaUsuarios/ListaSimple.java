/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaUsuarios;

import java.io.Serializable;

/**
 *
 * @author Randall
 */
public class ListaSimple implements Serializable {

    private Nodo primero;
    private Nodo ultima;
    private int CantNodos;

    public ListaSimple() {
        this.primero = null;
        this.ultima = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltima() {
        return ultima;
    }

    public void setUltima(Nodo ultima) {
        this.ultima = ultima;
    }

    public int getCantNodos() {
        return CantNodos;
    }

    public void setCantNodos(int CantNodos) {
        this.CantNodos = CantNodos;
    }

    public boolean esVacia() {
        return (this.primero == null);
    }

    public void insertarPrimero(Usuario p) {
        Nodo nuevo = new Nodo(p);
        if (esVacia()) {
            this.ultima = nuevo;

        } else {

        }
        nuevo.setSiguiente(primero);
        this.primero = nuevo;
    }

    public void insertarFInal(Usuario p) {
        Nodo nuevo = new Nodo(p);
        if (esVacia()) {
            this.primero = nuevo;

        } else {
            this.ultima.setSiguiente(nuevo);
        }
        this.ultima = nuevo;
    }

    public void RMPrimero() {
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            if (primero.getSiguiente() == null) {
                this.ultima = null;
            }
            this.primero = primero.getSiguiente();
            this.CantNodos--;
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
            while (actual != this.ultima) {
                temp = actual;
                actual = actual.getSiguiente();
            }
            this.ultima = temp;
            this.ultima.setSiguiente(null);
            this.CantNodos--;
        }
    }

    public void listar() {
        Nodo actual = this.primero;
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            while (actual != null) {
                System.out.println("" + actual.getUsuario().getName());
                actual = actual.getSiguiente();
            }
        }

    }

    public void agregarOrdenP(Usuario u) {
        Nodo nuevo = new Nodo(u);

        if (esVacia()) {
            this.insertarFInal(u);
        } else {
            Nodo actual = this.primero;
            if (nuevo.getUsuario().getPrioridad().equals("Adulto mayor")) {
                if (this.primero.getUsuario().getPrioridad().equals("Adulto mayor") && !this.ultima.getUsuario().getPrioridad().equals("Adulto mayor")) {
                    int i = 1;
                    while (actual.getUsuario().getPrioridad().equals("Adulto mayor") && actual.getSiguiente().getUsuario().getPrioridad().equals("Adulto mayor")) {
                        i++;
                        actual = actual.getSiguiente();
                    }
                    System.out.println("" + i);
                    nuevo.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(nuevo);
                } else if (this.ultima.getUsuario().getPrioridad().equals("Adulto mayor")) {
                    this.insertarFInal(u);
                } else {
                    this.insertarPrimero(u);
                }
            }
            if (nuevo.getUsuario().getPrioridad().equals("Persona con alguna discapacidad")) {
                if (this.primero.getUsuario().getPrioridad().equals("Mujer embarazada") || this.primero.getUsuario().getPrioridad().equals("Usuario")) {
                    this.insertarPrimero(u);
                } else if (this.ultima.getUsuario().getPrioridad().equals("Persona con alguna discapacidad") || this.ultima.getUsuario().getPrioridad().equals("Adulto mayor")) {
                    this.insertarFInal(u);
                } else {
                    actual = this.primero;
                    int w = 0;
                    while (w == 0) {
                        if ((actual.getUsuario().getPrioridad().equals("Persona con alguna discapacidad")
                                && !actual.getSiguiente().getUsuario().getPrioridad().equals("Persona con alguna discapacidad"))
                                || (actual.getUsuario().getPrioridad().equals("Adulto mayor")
                                && (actual.getSiguiente().getUsuario().getPrioridad().equals("Mujer embarazada")
                                || actual.getSiguiente().getUsuario().getPrioridad().equals("Usuario")))) {
                            w = 1;
                        }
                        if (w == 0) {
                            actual = actual.getSiguiente();
                        }
                    }
                    nuevo.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(nuevo);
                }
            }
            if (nuevo.getUsuario().getPrioridad().equals("Mujer embarazada")) {
                if (this.primero.getUsuario().getPrioridad().equals("Usuario")) {
                    this.insertarPrimero(u);
                } else if (this.ultima.getUsuario().getPrioridad().equals("Mujer embarazada") || this.ultima.getUsuario().getPrioridad().equals("Adulto Mayor") || this.ultima.getUsuario().getPrioridad().equals("Persona con alguna discapacidad")) {
                    this.insertarFInal(u);
                } else {
                    actual = this.primero;
                    int q = 0;
                    while (q == 0) {
                        if ((actual.getUsuario().getPrioridad().equals("Mujer embarazada")
                                && !actual.getSiguiente().getUsuario().getPrioridad().equals("Mujer embarazada"))
                                || ((actual.getUsuario().getPrioridad().equals("Adulto mayor")
                                || actual.getUsuario().getPrioridad().equals("Persona con alguna discapacidad"))

                                && actual.getSiguiente().getUsuario().getPrioridad().equals("Usuario"))) {
                            q = 1;
                        }
                         if (q == 0) {
                            actual = actual.getSiguiente();
                        }
                    }
                    nuevo.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(nuevo);
                }
            }
            if (nuevo.getUsuario().getPrioridad().equals("Usuario")) {
                this.insertarFInal(u);
            }

        }
this.CantNodos = this.CantNodos + 1;
    }

    public boolean esPosicionValida(int indice) {
        return indice > 0 && indice <= this.CantNodos;
    }

}
