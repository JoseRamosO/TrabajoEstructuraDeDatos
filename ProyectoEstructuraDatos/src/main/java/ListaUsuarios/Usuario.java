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
public class Usuario implements Serializable{

    private String Name;
    private String Apellido;
    private String Cedula;
    private String TipodeTransaccion;
    private String Prioridad;

    public Usuario(String Name, String Apellido, String Cedula, String TipodeTransaccion, String Prioridad) {
        this.Name = Name;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.TipodeTransaccion = TipodeTransaccion;
        this.Prioridad = Prioridad;
    }

    public Usuario() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getTipodeTransaccion() {
        return TipodeTransaccion;
    }

    public void setTipodeTransaccion(String TipodeTransaccion) {
        this.TipodeTransaccion = TipodeTransaccion;
    }

    public String getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(String Prioridad) {
        this.Prioridad = Prioridad;
    }
}
