package com.example.angel.fiagualid.Entidades;

import java.sql.Date;

public class Ventas {
    Integer idventas;
    Integer idcliente;
    Integer idarticulos;
    String tipo_pago;
    String serie_comprobante;
    String nro_comprobante;
    String  fecha_hora;
    Integer cantidad;
    Double total_venta;
    String Estado;

    public Ventas(){
        //constructor vacio;
    }

    public Ventas(Integer idventas, Integer idcliente, Integer idarticulos, String tipo_pago, String serie_comprobante,
                  String nro_comprobante, String fecha_hora, Integer cantidad, Double total_venta, String estado) {
        this.idventas = idventas;
        this.idcliente = idcliente;
        this.idarticulos = idarticulos;
        this.tipo_pago = tipo_pago;
        this.serie_comprobante = serie_comprobante;
        this.nro_comprobante = nro_comprobante;
        this.fecha_hora = fecha_hora;
        this.cantidad = cantidad;
        this.total_venta = total_venta;
        Estado = estado;
    }

    public Integer getIdventas() {
        return idventas;
    }

    public void setIdventas(Integer idventas) {
        this.idventas = idventas;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdarticulos() {
        return idarticulos;
    }

    public void setIdarticulos(Integer idarticulos) {
        this.idarticulos = idarticulos;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getSerie_comprobante() {
        return serie_comprobante;
    }

    public void setSerie_comprobante(String serie_comprobante) {
        this.serie_comprobante = serie_comprobante;
    }

    public String getNro_comprobante() {
        return nro_comprobante;
    }

    public void setNro_comprobante(String nro_comprobante) {
        this.nro_comprobante = nro_comprobante;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha) {
        this.fecha_hora = fecha_hora;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
