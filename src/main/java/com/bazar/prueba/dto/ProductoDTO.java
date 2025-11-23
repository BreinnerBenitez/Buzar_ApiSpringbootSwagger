package com.bazar.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "codigo_producto=" + codigo_producto +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                ", cantidad_disponible=" + cantidad_disponible +
                '}';
    }
}
