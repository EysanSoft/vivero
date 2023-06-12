package entities;

import java.io.Serializable;

public class Fotos implements Serializable {
    Integer idFoto;
    String fecha;
    String foto;
    Producto producto;

    public Fotos(){}

    public Fotos(Producto idProdcuto, String fecha, String foto) {
        this.producto = idProdcuto;
        this.fecha = fecha;
        this.foto = foto;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Producto getProducto() { return producto; }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
