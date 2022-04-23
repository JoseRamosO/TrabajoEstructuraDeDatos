
package ListaCircularEjecutivo;

import ColaSucursales.Sucursal;
import java.io.Serializable;

public class Ejecutivo implements Serializable{
    
    private String Nombre;
    private int Cedula;
    private String sucursal;
    private String Estado;
    private String Nombre_Cliente;

    public Ejecutivo(String Nombre, int Cedula, String sucursal) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.sucursal = sucursal;
        this.Estado = "Disponible";
        this.Nombre_Cliente="";
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    

            
}
