package com.bazar.prueba.service;

import com.bazar.prueba.dto.*;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.model.Venta;
import com.bazar.prueba.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<VentaDTO> getVentas() {

        List<Venta> listaVentas = ventaRepository.findAll();
        List<VentaDTO> listaVentasDto = new ArrayList<>();
        VentaDTO venDTO = new VentaDTO();

        for (Venta v : listaVentas) {
            venDTO.setFechaVenta(v.getFechaVenta());
            venDTO.setTotal(v.getTotal());


        }
        venDTO = new VentaDTO();  //reiniciar objeto
        return listaVentasDto;
    }

    @Override
    public void saveVenta(Venta Venta) {
        ventaRepository.save(Venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta findVentaInterna(Long id) { // buscar objetos internos

        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public VentaDTO findVenta(Long id) {
        Venta ven = ventaRepository.findById(id).orElse(null);
        VentaDTO venDTO = new VentaDTO();
        venDTO.setFechaVenta(ven.getFechaVenta());
        venDTO.setTotal(ven.getTotal());

        return venDTO;
    }


    @Override
    public void editVenta(Long codigo_venta, Venta venta) {
        venta.setCodigo_venta(codigo_venta);
        this.saveVenta(venta);

    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, LocalDate fecha_venta, Double total) {

    }

    @Override
    public List<ProductoDTO> obtenerProductosDeVenta(Long codigoVenta) {

        Venta venta = this.findVentaInterna(codigoVenta);
        List<ProductoDTO> listaVentaProductoDTO = new ArrayList<>();
        ProductoDTO proDTO = new ProductoDTO();
        if (venta == null) {
            return null;  // null
        }

        for (Producto p : venta.getListaProductos()) {
            proDTO.setMarca(p.getMarca());
            proDTO.setCosto(p.getCosto());
            proDTO.setNombre(p.getNombre());
            listaVentaProductoDTO.add(proDTO);
            proDTO = new ProductoDTO(); //reseteo de objeto
        }


        return listaVentaProductoDTO;  // lista de productos en DTO
    }

    @Override
    public ResumenVentasDTO obtenerResumenPorFecha(LocalDate fechaVenta) {

        List<Venta> ventas = ventaRepository.findByfechaVenta(fechaVenta);
        ResumenVentasDTO objetoResumenVentas = new ResumenVentasDTO();

        double montoTotal = 0.0;
        long cantidadVentas = 0;


        for (Venta v : ventas) {

            // Verificar si la fecha coincide
            if (v.getFechaVenta().equals(fechaVenta)) {

                montoTotal += v.getTotal(); // sumar totales
                cantidadVentas++;           // aumentar contador

            }
        }
        objetoResumenVentas.setFecha(fechaVenta);
        objetoResumenVentas.setMontoTotal(montoTotal);
        objetoResumenVentas.setCantidadVentas(cantidadVentas);


        return objetoResumenVentas;
    }

    @Override
    public VentaMayorDTO ventaMayor() { // trae la venta mayor

        Venta ventaMayor = ventaRepository.findTopByOrderByTotalDesc();
        if (ventaMayor == null) {
            return null; // envia null
        }

        Long codigo = ventaMayor.getCodigo_venta();
        Double total = ventaMayor.getTotal();
        int cantidadProductos = ventaMayor.getListaProductos().size();
        String nombreCliente = ventaMayor.getUnCliente().getNombre();
        String apellidoCliente = ventaMayor.getUnCliente().getApellido();

        return new VentaMayorDTO(codigo,
                total,
                cantidadProductos,
                nombreCliente,
                apellidoCliente);
    }


}
