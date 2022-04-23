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
public class ListaDoble implements Serializable{

    private NodoLD primero;
    private NodoLD ultimo;
    private int CantNodos;

    public ListaDoble() {
        this.primero = null;
        this.ultimo = null;
    }

    public NodoLD getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLD primero) {
        this.primero = primero;
    }

    public NodoLD getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLD ultimo) {
        this.ultimo = ultimo;
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

    //---------------------------------------------
    public ListaDoble EliminarServicio(String usuario, String ejecutivo, String fyh, String servicio) {
        NodoLD aux = getPrimero();
        ListaDoble LDtemp = new ListaDoble();
        if (!esVacia()) {
            while (aux != null) {
                if (aux.getAtencionC().getUsuario().getName().equals(usuario)
                        && aux.getAtencionC().getEjecutivo().getNombre().equals(ejecutivo)
                        && aux.getAtencionC().getFechayHora().equals(fyh)
                        && aux.getAtencionC().getServicio().getNombre().equals(ejecutivo)) {
                    this.CantNodos = this.CantNodos--;
                } else {
                    LDtemp.insertarFInal(aux.getAtencionC());
                }

                aux = aux.getSiguiente();
            }

        } else {
            System.out.println("La cola esta vacia");
        }

        return LDtemp;
    }

    public ListaDoble EditarDatosLCD(String usuario, String ejecutivo, String fyh, String servicio, String usuarioE, String ejecutivoE, String fyhE, String servicioE) {

        NodoLD aux = getPrimero();
        ListaDoble LDtemp = new ListaDoble();
        if (!esVacia()) {
            do {
                if (aux.getAtencionC().getUsuario().getName().equals(usuario)
                        && aux.getAtencionC().getEjecutivo().getNombre().equals(ejecutivo)
                        && aux.getAtencionC().getFechayHora().equals(fyh)
                        && aux.getAtencionC().getServicio().getNombre().equals(servicio)) {
                    aux.getAtencionC().getUsuario().setName(usuarioE);
                    aux.getAtencionC().getEjecutivo().setNombre(ejecutivoE);
                    aux.getAtencionC().setFechayHora(fyhE);
                    aux.getAtencionC().getServicio().setNombre(servicioE);
                }
                LDtemp.insertarFInal(aux.getAtencionC());

                aux = aux.getSiguiente();

            } while (aux != primero);

        } else {
            System.out.println("La lista esta vacia");
        }

        return LDtemp;
    }

//------------------------------------------------------------------------
    //-----------------------------------------------------------------------
    public void insertarPrimero(AtencionC p) {
        NodoLD nuevo = new NodoLD(p);
        if (esVacia()) {
            this.ultimo = nuevo;

        } else {
            this.primero.setAnterior(nuevo);

        }
        nuevo.setSiguiente(this.primero);
        this.primero = nuevo;
        this.CantNodos = this.CantNodos + 1;
    }

    public void insertarFInal(AtencionC p) {
        NodoLD nuevo = new NodoLD(p);
        if (esVacia()) {
            this.primero = nuevo;

        } else {
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
        }
        this.ultimo = nuevo;
        this.CantNodos = this.CantNodos + 1;
    }

    public void listarAdelante() {
        NodoLD actual = this.primero;
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            while (actual != null) {
                System.out.println("" + actual.getAtencionC().getEjecutivo().getNombre() + " cliente " + actual.getAtencionC().getUsuario().getCedula() + " servicio " + actual.getAtencionC().getServicio().getNombre());
                actual = actual.getSiguiente();
            }
        }

    }

    public void listarAtras() {
        NodoLD actual = this.ultimo;
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            while (actual != null) {
                System.out.println("" + actual.getAtencionC().getEjecutivo().getNombre() + " cliente " + actual.getAtencionC().getUsuario().getCedula() + " servicio " + actual.getAtencionC().getServicio().getNombre());
                actual = actual.getAnterior();
            }
        }

    }

    public void RMPrimero() {
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {
            if (primero.getSiguiente() == null) {
                this.ultimo = null;
            }
            this.primero = primero.getSiguiente();
            this.primero.setAnterior(null);
            this.CantNodos--;
        }
    }

    public void RMUltimo() {
        if (esVacia()) {
            System.out.println("La lista esta vacia");

        } else {

            if (primero.getSiguiente() == null) {
                this.primero = null;
            }
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setSiguiente(null);
            this.CantNodos--;
        }
    }

    public boolean esPosicionValida(int indice) {
        return indice > 0 && indice <= this.CantNodos + 1;
    }

    public void insertarEnPosicion(AtencionC p, int posicion) {
        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            NodoLD nuevo = new NodoLD(p);
            NodoLD actual = this.primero;
            NodoLD temp = this.primero;
            if (posicion == 1) {
                this.insertarPrimero(p);
            } else if (posicion == this.CantNodos + 1) {
                this.insertarFInal(p);
            } else {
                for (int j = 1; j <= (posicion - 1); j++) {
                    if (j == (posicion - 1)) {
                        nuevo.setSiguiente(primero.getSiguiente());
                        this.primero.getSiguiente().setAnterior(nuevo);
                        this.primero.setSiguiente(nuevo);
                        nuevo.setAnterior(this.primero);
                        if (posicion == 2) {
                            temp = this.primero;
                        }
                    } else {
                        this.primero = this.primero.getSiguiente();
                    }
                }
                this.primero = temp;
                this.CantNodos++;
            }

        }
    }

    public void removerEnPosicion(int posicion) {
        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            NodoLD actual = this.primero;

            if (posicion == 1) {
                this.RMPrimero();
            } else if (posicion == this.CantNodos) {
                this.RMUltimo();
            } else {
                for (int i = 1; i < posicion && actual.getSiguiente() != null; i++) {
                    actual = actual.getSiguiente();
                }
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
                this.CantNodos--;
            }

        }

    }

}
