package ListaCircularEjecutivo;

import java.io.Serializable;

public class ListaCircularSimple implements Serializable{

    private NodoLCS primero;
    private NodoLCS ultimo;
    private int cantNodos;

    public ListaCircularSimple() {
        this.primero = null;
        this.ultimo = null;
    }
//------------------------------------------------------------------------

    public boolean esVacia() {
        return (this.primero == null);
    }
    //-----------------------------------------------------------------------
    public ListaCircularSimple EliminarEjecutivo(String Nombre, int Cedula) {
        NodoLCS aux = getPrimero();
        ListaCircularSimple LCStemp = new ListaCircularSimple();
        if (!esVacia()) {
            do{
                if (aux.getEjecutivo().getNombre().equals(Nombre)
                        && aux.getEjecutivo().getCedula()==Cedula) {
                    this.cantNodos = this.cantNodos--;
                } else {
                    LCStemp.insertarFinal(aux.getEjecutivo());
                }

                aux = aux.getSiguiente();
            }while (aux != primero);
            
        } else {
            System.out.println("La cola esta vacia");
        }

        return LCStemp;
    }

    //-----------------------------------------------------------------------

    public ListaCircularSimple EditarDatosLCS(String Nombre, int Cedula, String Sucursal, String Estado, String NombreE, int CedulaE, String SucursalE, String EstadoE) {

        NodoLCS aux = getPrimero();
        ListaCircularSimple LCStemp = new ListaCircularSimple();
        if (!esVacia()) {
            do {

                if (aux.getEjecutivo().getNombre().equals(Nombre)
                        && aux.getEjecutivo().getCedula()==Cedula
                        && aux.getEjecutivo().getSucursal().equals(Sucursal)
                        && aux.getEjecutivo().getEstado().equals(Estado)) {
                    aux.getEjecutivo().setNombre(NombreE);
                    aux.getEjecutivo().setCedula(CedulaE);
                    aux.getEjecutivo().setSucursal(SucursalE);
                    aux.getEjecutivo().setEstado(EstadoE);
                }
                LCStemp.insertarFinal(aux.getEjecutivo());

                aux = aux.getSiguiente();

            } while (aux != primero);
        } else {
            System.out.println("La lista esta vacia");
        }

        return LCStemp;
    }

//------------------------------------------------------------------------
    public void insertarPrimero(Ejecutivo p) {
        NodoLCS nuevo = new NodoLCS(p);

        if (esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            nuevo.setSiguiente(primero);
        } else {
            nuevo.setSiguiente(primero);
            this.primero = nuevo;
            this.ultimo.setSiguiente(primero);
        }
        this.cantNodos++;
    }

//------------------------------------------------------------------------
    public void insertarFinal(Ejecutivo p) {
        NodoLCS nuevo = new NodoLCS(p);
        if (esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            nuevo.setSiguiente(primero);
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
            this.ultimo.setSiguiente(this.primero);
        }

        this.cantNodos++;
    }
//------------------------------------------------------------------------

    public void listar() {
        NodoLCS actual = this.primero;

        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            do {
                System.out.println(
                        actual.getEjecutivo().getNombre());

                actual = actual.getSiguiente();
            } while (actual != primero);
        }

    }

//------------------------------------------------------------------------   
    public boolean esPosicionValida(int indice) {

        return (indice > 0 && indice <= this.cantNodos) || (indice > 0 && indice == this.cantNodos + 1);
    }

//------------------------------------------------------------------------    
    public void insertarEnPosicion(Ejecutivo p, int posicion) {

        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            NodoLCS nuevoNodo = new NodoLCS(p);
            NodoLCS actual = this.primero;
            NodoLCS temp = this.primero;

            if (posicion == 1) {
                this.insertarPrimero(p);
            } else if (posicion == this.cantNodos + 1) {
                this.insertarFinal(p);
            } else {
                for (int i = 1; i < posicion; i++) {
                    temp = actual;
                    actual = actual.getSiguiente();
                }
                nuevoNodo.setSiguiente(actual);
                temp.setSiguiente(nuevoNodo);
                this.cantNodos++;
            }

        }

    }
//------------------------------------------------------------------------

    public void removerPrimero() {
        if (this.esVacia()) {
            System.out.println("La lista está vacia");
        } else {

            if (this.primero != this.ultimo) {
                primero = primero.getSiguiente();
                ultimo.setSiguiente(primero);
            } else {
                this.primero = null;
                this.ultimo = null;
            }

        }
        this.cantNodos--;
    }
//------------------------------------------------------------------------

    public void removerUltimo() {
        if (this.esVacia()) {
            System.out.println("La lista está vacia");
        } else {

            if (this.primero != this.ultimo) {
                NodoLCS actual = this.primero; //nos sirve para determinar el anterior al ultimo
                while (actual.getSiguiente() != ultimo) {
                    actual = actual.getSiguiente();
                }
                this.ultimo = actual;
                ultimo.setSiguiente(primero);

            } else { //en caso de que la lista tenga un solo nodo
                this.primero = null;
                this.ultimo = null;
            }

        }
        this.cantNodos--;
    }
//------------------------------------------------------------------------

    public void removerEnPosicion(int posicion) {
        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            NodoLCS actual = this.primero;
            NodoLCS temp = this.primero;

            if (posicion == 1) {
                this.removerPrimero();
            } else if (posicion == this.cantNodos) {
                this.removerUltimo();
            } else {
                for (int i = 1; i < posicion; i++) {
                    temp = actual;
                    actual = actual.getSiguiente();
                }
                temp.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(null);
                this.cantNodos--;
            }

        }

    }

//------------------------------------------------------------------------
    public NodoLCS getCualquierNodo(int posicion) {
        NodoLCS nodo = null;
        NodoLCS actual = this.primero;
        if (this.esVacia()) {
            System.out.println("La lista está vacia");
        } else {
            for (int i = 1; i <= posicion; i++) {
                nodo = actual;
                actual = actual.getSiguiente();
            }
        }
        return nodo;
    }

//------------------------------------------------------------------------
    public void listarDesdeposicion(NodoLCS nodo) {
        NodoLCS actual = nodo;

        do {
            System.out.println(
                    actual.getEjecutivo().getNombre());

            actual = actual.getSiguiente();
        } while (actual != nodo);

    }
//------------------------------------------------------------------------

    public void buscar(int id) {
        NodoLCS actual = this.primero;
        int contador = 1;
        boolean encontrado = false;
        if (esVacia()) {
            System.out.println("La lista está vacia");
        } else {

            do {

                if (actual.getEjecutivo().getCedula() == id) {
                    encontrado = true;
                    break;
                }

                actual = actual.getSiguiente();
                contador++;

            } while (actual != primero);

            if (encontrado) {
                System.out.println("La Ejecutivo con id : " + id + " si se encuentra en la lista, posicion: " + contador);
            } else {
                System.out.println("La Ejecutivo con id : " + id + " no se encuentra en la lista");
            }
        }

    }
    //---------------------------------------------------------------------------------------------

    public void insertarASC(Ejecutivo p) {
        NodoLCS actual = this.primero;
        NodoLCS temp = this.primero;
        NodoLCS nuevo = new NodoLCS(p);

        //Caso 1: La lista esta vacia
        if (actual == null) {
            nuevo.setSiguiente(nuevo);
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.cantNodos++;
        } //Caso 2: El nuevo nodo es menor que el primero
        else if (nuevo.getEjecutivo().getCedula() < primero.getEjecutivo().getCedula()) {
            this.insertarPrimero(p);

        } //Caso 3: el nuevo es mayor que el ultimo
        else if (nuevo.getEjecutivo().getCedula() > ultimo.getEjecutivo().getCedula()) {
            this.insertarFinal(p);
        } //Caso 4: el nodo esta entre el primero y el ultimo
        else {
            while (p.getCedula() > actual.getEjecutivo().getCedula()) {
                temp = actual;
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual);
            temp.setSiguiente(nuevo);
            this.cantNodos++;
        }

    }
    //----------------------------------------------------------------------------------------------

    public ListaCircularSimple ordenarLista(ListaCircularSimple l) {
        ListaCircularSimple listaOrdenada = new ListaCircularSimple();

        NodoLCS actual = l.getPrimero();

        do {
            listaOrdenada.insertarASC(actual.getEjecutivo());
            actual = actual.getSiguiente();
        } while (actual != primero);

        return listaOrdenada;

    }

//------------------------------------------------------------------------
    public NodoLCS getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLCS primero) {
        this.primero = primero;
    }

    public NodoLCS getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLCS ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }

}
