package entities;

import java.io.Serializable;

public class Riego implements Serializable {

    Integer idRiego;
    String fecha;
    String riego;
    Producto producto;

    public Riego(){}
    public Riego(Producto producto, String fecha, String riego) {
        this.producto = producto;
        this.fecha = fecha;
        this.riego = riego;
    }

    public Integer getIdRiego() {
        return idRiego;
    }

    public void setIdRiego(Integer idRiego) {
        this.idRiego = idRiego;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRiego() {
        return riego;
    }

    public void setRiego(String riego) {
        this.riego = riego;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
