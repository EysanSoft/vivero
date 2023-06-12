package entities;

import java.io.Serializable;
import java.util.List;

public class Tipo implements Serializable {
    Integer idTipo;
    String Tipo;
    List<Producto> producto;

    public Tipo(){}

    public Tipo(Integer idTipo, String tipo) {
        this.idTipo = idTipo;
        this.Tipo = tipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
}
