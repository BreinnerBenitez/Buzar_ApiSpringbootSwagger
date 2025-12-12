package com.bazar.prueba.service;

import com.bazar.prueba.dto.ProductoDTO;
import com.bazar.prueba.dto.ResumenVentasDTO;
import com.bazar.prueba.dto.VentaDTO;
import com.bazar.prueba.dto.VentaMayorDTO;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.model.Venta;
import com.bazar.prueba.model.Venta;

import java.time.LocalDate;
import java.util.List;


public interface IVentaService  {
    //método para traer a todas las personas
    //lectura
     List<VentaDTO> getVentas();

    //crear
     void saveVenta(Venta Venta);

    //eliminar
     void deleteVenta(Long id);

    //buscar
     Venta findVentaInterna(Long id);
     VentaDTO findVenta(Long id);

    //edición/modificación
     void editVenta ( Long codigo_venta, Venta Venta);
     void editMascota(Long idOriginal, Long idNueva, LocalDate fecha_venta, Double total);

     List<ProductoDTO> obtenerProductosDeVenta(Long codigoVenta); // obtener productos por ventas
     ResumenVentasDTO obtenerResumenPorFecha(LocalDate fechaVenta); // obtener resumen de fecha
     VentaMayorDTO ventaMayor();

}
