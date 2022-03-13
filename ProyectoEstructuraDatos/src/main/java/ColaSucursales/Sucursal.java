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
public class Sucursal implements Serializable{
    private String NomSu;
    private String Provincia ;
    private String Canton;
    private String HorarioAten;
    private String CantPuesto;

    public Sucursal(String NomSu, String Provincia, String Canton, String HorarioAten, String CantPuesto) {
        this.NomSu = NomSu;
        this.Provincia = Provincia;
        this.Canton = Canton;
        this.HorarioAten = HorarioAten;
        this.CantPuesto = CantPuesto;
    }

    public String getNomSu() {
        return NomSu;
    }

    public void setNomSu(String NomSu) {
        this.NomSu = NomSu;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCanton() {
        return Canton;
    }

    public void setCanton(String Canton) {
        this.Canton = Canton;
    }

    public String getHorarioAten() {
        return HorarioAten;
    }

    public void setHorarioAten(String HorarioAten) {
        this.HorarioAten = HorarioAten;
    }

    public String getCantPuesto() {
        return CantPuesto;
    }

    public void setCantPuesto(String CantPuesto) {
        this.CantPuesto = CantPuesto;
    }
}
