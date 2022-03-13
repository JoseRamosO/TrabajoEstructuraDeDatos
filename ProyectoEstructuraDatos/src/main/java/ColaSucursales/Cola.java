/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColaSucursales;

import java.io.Serializable;

/**
 *
 * @author Randall
 */
public class Cola implements Serializable{
    private Nodo Frente;
    private Nodo Atras;
    private int size;

    public Cola() {
        this.setFrente(null);
        this.setAtras(null);
        this.setSize(0);

    }

    public boolean EsVacia() {
        if (getFrente() == null) {
            return true;

        } else {
            return false;
        }
    }

    public void encolar(Sucursal u) {
        Nodo nuevoNodo = new Nodo(u);
        if (EsVacia()) {
            setFrente(nuevoNodo);

        } else {
            getAtras().setSiguiente(nuevoNodo);
        }
        setAtras(nuevoNodo);
        this.size++;
    }

    public void listarCola() {
        Nodo aux = getFrente();
        String text = "La cola original es: ";
        if (!EsVacia()) {
            while (aux != null) {

                text = text + aux.getSucursal().getNomSu()+ ",";
                aux = aux.getSiguiente();
            }
            System.out.println(text);
        } else {
            System.out.println("La cola esta vacia");
        }
    }

    public Nodo getFrente() {
        return Frente;
    }

    public void setFrente(Nodo Frente) {
        this.Frente = Frente;
    }

    public Nodo getAtras() {
        return Atras;
    }

    public void setAtras(Nodo Atras) {
        this.Atras = Atras;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
