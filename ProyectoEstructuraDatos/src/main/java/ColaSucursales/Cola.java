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
public class Cola implements Serializable {

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

                text = text + aux.getSucursal().getNomSu() + ",";
                aux = aux.getSiguiente();
            }
            System.out.println(text);
        } else {
            System.out.println("La cola esta vacia");
        }
    }

    public Cola EditarDatos(String NomSu, String Provincia, String Canton, String HorarioAten, String CantPuesto, String NomSuE, String ProvinciaE, String CantonE, String HorarioAtenE, String CantPuestoE) {

        Nodo aux = getFrente();
        Cola colatemp = new Cola();
        if (!EsVacia()) {
            while (aux != null) {
                if (aux.getSucursal().getNomSu().equals(NomSu)
                        && aux.getSucursal().getProvincia().equals(Provincia)
                        && aux.getSucursal().getCanton().equals(Canton)
                        && aux.getSucursal().getHorarioAten().equals(HorarioAten)
                        && aux.getSucursal().getCantPuesto().equals(CantPuesto)) {
                    aux.getSucursal().setNomSu(NomSuE);
                    aux.getSucursal().setProvincia(ProvinciaE);
                    aux.getSucursal().setCanton(CantonE);
                    aux.getSucursal().setHorarioAten(HorarioAtenE);
                    aux.getSucursal().setCantPuesto(CantPuestoE);
                }
                colatemp.encolar(aux.getSucursal());

                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("La cola esta vacia");
        }

        return colatemp;
    }

    public Cola EliminarSucursal(String NomSu, String Provincia, String Canton, String HorarioAten, String CantPuesto) {
        Nodo aux = getFrente();
        Cola colatemp = new Cola();
        if (!EsVacia()) {
            while (aux != null) {
                if (aux.getSucursal().getNomSu().equals(NomSu)
                        && aux.getSucursal().getProvincia().equals(Provincia)
                        && aux.getSucursal().getCanton().equals(Canton)
                        && aux.getSucursal().getHorarioAten().equals(HorarioAten)
                        && aux.getSucursal().getCantPuesto().equals(CantPuesto)) {

                } else {
                    colatemp.encolar(aux.getSucursal());
                }

                aux = aux.getSiguiente();
            }
            this.size = this.size--;
        } else {
            System.out.println("La cola esta vacia");
        }

        return colatemp;
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
