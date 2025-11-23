package com.bazar.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="producto")  // nombre de la entidad en la base de datos
public class Producto {
    @Id
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;


    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }



    @Override
    public String toString() {
        return "Producto{" +
                "codigo_producto=" + codigo_producto +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                ", cantidad_disponible=" + cantidad_disponible +
                '}';
    }
}
