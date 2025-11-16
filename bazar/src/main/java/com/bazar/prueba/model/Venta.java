package com.bazar.prueba.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venta") // nombre de la entidad en la base de datos
public class Venta {
    @Id
    private Long codigo_venta;
    private LocalDate fechaVenta;
    private Double total;
    @OneToMany
    List<Producto> listaProductos;
    @OneToOne
    private Cliente unCliente;

    public Venta() {
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo_venta=" + codigo_venta +
                ", fecha_venta=" + fechaVenta +
                ", totar=" + total +
                ", listaProductos=" + listaProductos +
                ", unCliente=" + unCliente +
                '}';
    }
}
