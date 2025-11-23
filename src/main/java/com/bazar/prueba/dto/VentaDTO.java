package com.bazar.prueba.dto;

import com.bazar.prueba.model.Cliente;
import com.bazar.prueba.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Long codigo_venta;
    private LocalDate fechaVenta;
    private Double total;
    List<Producto> listaProductos;
    private Cliente unCliente;

    @Override
    public String toString() {
        return "VentaDTO{" +
                "codigo_venta=" + codigo_venta +
                ", fechaVenta=" + fechaVenta +
                ", total=" + total +
                ", listaProductos=" + listaProductos +
                ", unCliente=" + unCliente +
                '}';
    }
}
