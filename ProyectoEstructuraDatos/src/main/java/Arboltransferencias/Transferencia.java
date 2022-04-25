/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboltransferencias;


import ListaCircularDobleServicios.Servicios;
import ListaCircularEjecutivo.Ejecutivo;
import ListaUsuarios.Usuario;
import java.io.Serializable;

/**
 *
 * @author Jose Ramos
 */
public class Transferencia implements Serializable{
    private Usuario usuario;
    private Ejecutivo ejecutivo;
    private String FechayHora;
    private Servicios servicio;
    private int id;

    public Transferencia(Usuario usuario, Ejecutivo ejecutivo, String FechayHora, Servicios servicio,int id) {
        this.usuario = usuario;
        this.ejecutivo = ejecutivo;
        this.FechayHora = FechayHora;
        this.servicio = servicio;
        this.id=id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ejecutivo getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Ejecutivo ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public String getFechayHora() {
        return FechayHora;
    }

    public void setFechayHora(String FechayHora) {
        this.FechayHora = FechayHora;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
}


