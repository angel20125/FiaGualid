package com.example.angel.fiagualid.Entidades;

public class ArticuloL {
    private String nombre;
    private String cod_articulo;
    private Integer idcategoria;
    private Double precio_venta;
    private Integer stock;
    private String estado;

    public ArticuloL(){}

    public ArticuloL(String nombre, String cod_articulo, Integer idcategoria, Double precio_venta, Integer stock, String estado) {
        this.nombre = nombre;
        this.cod_articulo = cod_articulo;
        this.idcategoria = idcategoria;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(String cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
