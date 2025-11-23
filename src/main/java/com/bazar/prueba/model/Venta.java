package com.bazar.prueba.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
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

    public Venta(Long codigo_venta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
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
