package ListaCircularDobleServicios;

import java.io.Serializable;

public class ListaCircularDoble implements Serializable{

    private NodoLCD primero;
    private NodoLCD ultimo;
    private int cantNodos;

    public ListaCircularDoble() {
        this.primero = null;
        this.ultimo = null;
    }

//------------------------------------------------------------------------
    public boolean esVacia() {
        return (this.primero == null);
    }
//------------------------------------------------------------------------

    public ListaCircularDoble EliminarServicio(String nombre, int codigo, String AreaAtencion) {
        NodoLCD aux = getPrimero();
        ListaCircularDoble LCDtemp = new ListaCircularDoble();
        if (!esVacia()) {
            do {
                if (aux.getServicios().getNombre().equals(nombre)
                        && aux.getServicios().getCodigo() == codigo
                        && aux.getServicios().getAreaAtencion().equals(AreaAtencion)) {
                    this.cantNodos = this.cantNodos--;
                } else {
                    LCDtemp.insertarFinal(aux.getServicios());
                }

                aux = aux.getSiguiente();
            }while (aux != primero);
        } else {
            System.out.println("La cola esta vacia");
        }

        return LCDtemp;
    }

    //-----------------------------------------------------------------------
        public ListaCircularDoble EditarDatosLCD(String nombre, int codigo, String AreaAtencion,String nombreE, int codigoE, String AreaAtencionE) {

        NodoLCD aux = getPrimero();
        ListaCircularDoble LCDtemp = new ListaCircularDoble();
        if (!esVacia()) {
            do {
                if (aux.getServicios().getNombre().equals(nombre)
                        && aux.getServicios().getCodigo()==codigo
                        && aux.getServicios().getAreaAtencion().equals(AreaAtencion)){
                    aux.getServicios().setNombre(nombreE);
                    aux.getServicios().setCodigo(codigoE);
                    aux.getServicios().setAreaAtencion(AreaAtencionE);
                 }
                LCDtemp.insertarFinal(aux.getServicios());

                aux = aux.getSiguiente();

            } while (aux != primero);

        } else {
            System.out.println("La lista esta vacia");
        }

        return LCDtemp;
    }

//------------------------------------------------------------------------
    public void insertarPrimero(Servicios p) {
        NodoLCD nuevo = new NodoLCD(p);
        if (esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(primero);
        } else {
            nuevo.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(nuevo);
            this.primero.setAnterior(nuevo);
            nuevo.setSiguiente(this.primero);
            this.primero = nuevo;
        }
        this.cantNodos++;

    }
//------------------------------------------------------------------------

    public void insertarFinal(Servicios p) {
        NodoLCD nuevo = new NodoLCD(p);
        if (esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(primero);
        } else {
            nuevo.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(nuevo);
            this.primero.setAnterior(nuevo);
            nuevo.setSiguiente(this.primero);
            this.ultimo = nuevo;
        }
        this.cantNodos++;
    }
//------------------------------------------------------------------------

    public void listarHaciaAdelante() {
        NodoLCD actual = this.primero;

        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            do {
                System.out.println(
                        actual.getServicios().getNombre());
                actual = actual.getSiguiente();
            } while (actual != primero);

        }
    }
//------------------------------------------------------------------------

    public void listarHaciaAtras() {
        NodoLCD actual = this.ultimo;
        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            do {
                System.out.println(
                        actual.getServicios().getNombre());
                actual = actual.getAnterior();
            } while (actual != ultimo);

        }
    }
//------------------------------------------------------------------------

    public boolean esPosicionValida(int indice) {
        return (indice > 0 && indice <= this.cantNodos) || (indice > 0 && indice == this.cantNodos + 1);
    }
//------------------------------------------------------------------------

    public void insertarEnPosicion(Servicios p, int posicion) {
        if (!this.esPosicionValida(posicion)) {
            System.out.println("Indice no valido en la lista");
        } else {
            NodoLCD nuevoNodo = new NodoLCD(p);
            NodoLCD actual = primero;

            if (posicion == 1) {
                this.insertarPrimero(p);
            } else if (posicion == this.cantNodos + 1) {
                this.insertarFinal(p);
            } else {
                for (int i = 1; i < posicion; i++) {
                    actual = actual.getSiguiente();
                }

                nuevoNodo.setSiguiente(actual);
                actual.getAnterior().setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(actual.getAnterior());
                actual.setAnterior(nuevoNodo);
                this.cantNodos++;
            }

        }

    }
//------------------------------------------------------------------------

    public void removerPrimero() {

        if (this.esVacia()) {
            System.out.println("La lista está vacia");
        } else {

            //Si hay mas de un nodo
            if (this.primero != this.ultimo) {
                primero = primero.getSiguiente();
                ultimo.setSiguiente(primero);
                primero.setAnterior(ultimo);
            } //si hay solo un nodo
            else {
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
            //Si hay mas de un nodo
            if (this.primero != this.ultimo) {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(primero);
                primero.setAnterior(ultimo);
            } else {
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
            NodoLCD actual = this.primero;

            if (posicion == 1) {
                this.removerPrimero();
            } else if (posicion == this.cantNodos) {
                this.removerUltimo();
            } else {
                for (int i = 1; i < posicion && actual.getSiguiente() != null; i++) {
                    actual = actual.getSiguiente();
                }
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
                this.cantNodos--;
            }

        }

    }
//------------------------------------------------------------------------
//Devuelve el nodo de la posicion indicada

    public NodoLCD getCualquierNodo(int posicion) {
        NodoLCD nodo = null;
        NodoLCD actual = this.primero;

        if (esVacia()) {
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
    public void listarDesdePosicion(NodoLCD nodo) {

        NodoLCD actual = nodo;

        do {
            System.out.println("||" + actual.getServicios().getNombre() + ")");
            actual = actual.getSiguiente();
        } while (actual != nodo);

    }
//------------------------------------------------------------------------    

    public void insertarASC(Servicios p) {
        NodoLCD actual = this.primero;
        NodoLCD nuevo = new NodoLCD(p);

        //Caso 1: La lista esta vacia
        //se puede comprobar tambien con el metodo esVacia()
        if (actual == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(primero);
            this.cantNodos++;
        } //Caso 2: El nuevo nodo es menor que el primero
        else if (nuevo.getServicios().getCodigo() < primero.getServicios().getCodigo()) {
            this.insertarPrimero(p);

        } //Caso 3: el nuevo es mayor que el ultimo
        else if (nuevo.getServicios().getCodigo() > ultimo.getServicios().getCodigo()) {
            this.insertarFinal(p);
        } //Caso 4: el nodo esta entre el primero y el ultimo
        else {
            while (p.getCodigo() > actual.getServicios().getCodigo()) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual);
            actual.getAnterior().setSiguiente(nuevo);
            nuevo.setAnterior(actual.getAnterior());
            actual.setAnterior(nuevo);
            this.cantNodos++;
        }

    }
//------------------------------------------------------------------------

    public ListaCircularDoble ordenarLista(ListaCircularDoble l) {
        ListaCircularDoble listaOrdenada = new ListaCircularDoble();

        NodoLCD actual = l.getPrimero();

        do {
            listaOrdenada.insertarASC(actual.getServicios());
            actual = actual.getSiguiente();
        } while (actual != primero);

        return listaOrdenada;

    }
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------

    public NodoLCD getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLCD primero) {
        this.primero = primero;
    }

    public NodoLCD getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLCD ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }
}
