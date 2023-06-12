package entities;

import java.io.Serializable;
import java.util.List;

public class Producto implements Serializable {
    private Integer idProducto;
    private String nombre;
    private entities.Tipo tipo;
    private String nombreTipo;
    private String ingreso;
    private String estado;
    private List<entities.Fotos> listaFotos;
    private List<entities.Riego> listaRiego;
    private entities.Calendario calendario;

    public Producto() {}

    public Producto(String nombre, entities.Tipo tipo, String ingreso, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ingreso = ingreso;
        this.estado = estado;
    }
    public Producto(String nombre, String nombreTipo, String ingreso, String estado) {
        this.nombre = nombre;
        this.nombreTipo = nombreTipo;
        this.ingreso = ingreso;
        this.estado = estado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //ver
    public entities.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(entities.Tipo tipo) {
        this.tipo = tipo;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<entities.Fotos> getListaFotos() {
        return listaFotos;
    }

    public void setListaFotos(List<entities.Fotos> listaFotos) {
        this.listaFotos = listaFotos;
    }

    public List<entities.Riego> getListaRiego() { return listaRiego; }

    public void setListaRiego(List<entities.Riego> listRiego) {
        this.listaRiego = listRiego;
    }

    public entities.Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(entities.Calendario calendario) {
        this.calendario = calendario;
    }

    public String getNombreTipo() {
        return tipo.getTipo();
    }

}
