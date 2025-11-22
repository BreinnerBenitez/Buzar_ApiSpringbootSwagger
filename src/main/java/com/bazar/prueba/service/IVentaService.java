package com.bazar.prueba.service;

import com.bazar.prueba.dto.ResumenVentasDTO;
import com.bazar.prueba.dto.VentaMayorDTO;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.model.Venta;
import com.bazar.prueba.model.Venta;

import java.time.LocalDate;
import java.util.List;


public interface IVentaService  {
    //método para traer a todas las personas
    //lectura
    public List<Venta> getVentas();

    //crear
    public void saveVenta(Venta Venta);

    //eliminar
    public void deleteVenta(Long id);

    //buscar
    public Venta findVenta(Long id);

    //edición/modificación
    public void editVenta ( Long codigo_venta, Venta Venta);
    public void editMascota(Long idOriginal, Long idNueva, LocalDate fecha_venta, Double total);

    public List<Producto> obtenerProductosDeVenta(Long codigoVenta); // obtener productos por ventas
    public ResumenVentasDTO obtenerResumenPorFecha(LocalDate fechaVenta); // obtener resumen de fecha
    public VentaMayorDTO ventaMayor();

}
