
package ListaCircularDobleServicios;

import java.io.Serializable;

public class Servicios implements Serializable{
    
    private int codigo;
    private String nombre;
    private String AreaAtencion;

    public Servicios(int codigo, String nombre, String AreaAtencion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.AreaAtencion = AreaAtencion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAreaAtencion() {
        return AreaAtencion;
    }

    public void setAreaAtencion(String AreaAtencion) {
        this.AreaAtencion = AreaAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
            
}
