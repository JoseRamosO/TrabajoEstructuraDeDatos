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
public class Pila {

    private nodoPila inicio;
    private int size;

    public nodoPila getInicio() {
        return inicio;
    }

    public void setInicio(nodoPila inicio) {
        this.inicio = inicio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Pila() {
        this.inicio = null;
        this.size = 0;
    }

    public boolean EsVacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;

        }
    }

    public void apilar(Transferencia dato) {
        nodoPila nuevoNodo = new nodoPila();
        nuevoNodo.setDato(dato);
        if (EsVacia()) {
            this.inicio = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(inicio);
            this.inicio = nuevoNodo;
        }
        this.size++;
    }

    public void listarPila() {
        nodoPila aux = inicio;
        if (EsVacia()) {
            System.out.println("LA pila esta vacia");
        } else {
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
    }

    //Escribir el método mostrarPila() para escribir los elementos de una pila de cadenas de caracteres,
    //utilizando sólo las operaciones básicas y una pila auxiliar.
    public void mostrarPila() {
        nodoPila auxiliar = inicio;
        if (EsVacia()) {
            System.out.println("La pila esta vacia");
        } else {
            while (auxiliar != null) {
                System.out.println(auxiliar.getDato());
                auxiliar = auxiliar.getSiguiente();
            }
        }
    }
    //Obtener una secuencia de 10 números reales, guardarlos en un array y ponerlos en una pila.
    //Imprimir la secuencia original y, a continuación, imprimir la pila extrayendo los elementos
     public Pila mostrarPilaNum() {
        Pila pilaaux =new Pila();
        nodoPila aux=inicio;
        if (EsVacia()) {
            System.out.println("La pila esta vacia");
        } else {
            while (aux != null) {
                pilaaux.apilar(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
        return pilaaux;
    }
      /**
     * 4. Escribir un método, copiarPila(), que copie el contenido de una pila
     * en otra. El método tendrá dos argumentos de tipo pila, uno para la pila
     * fuente y otro para la pila destino. Utilizar las operaciones definidas de
     * la clase Pila.*/
      public void copiarPila(Pila fuente, Pila destino) {
       
        nodoPila aux=fuente.getInicio();
        if (EsVacia()) {
            System.out.println("La pila esta vacia");
        } else {
            while (aux != null) {
                destino.apilar(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
    }
     
     
    public void desapilar() {
        if (EsVacia()) {
            System.out.println("Pila vacia");
        } else {
            inicio = inicio.getSiguiente();
            size--;
        }
    }

    public void eliminarPila() {
        inicio = null;
        size = 0;
    }
}
