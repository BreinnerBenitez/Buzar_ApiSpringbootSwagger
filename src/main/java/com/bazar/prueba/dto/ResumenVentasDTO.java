package com.bazar.prueba.dto;

import java.time.LocalDate;

public class ResumenVentasDTO {

    private LocalDate fecha;
    private  Double montoTotal;
    private Long cantidadVentas;

    public ResumenVentasDTO() {
    }

    public ResumenVentasDTO(Long cantidadVentas, Double montoTotal, LocalDate fecha) {
        this.cantidadVentas = cantidadVentas;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Long getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
}


