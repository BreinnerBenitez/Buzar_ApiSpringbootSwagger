package com.bazar.prueba.service;

import com.bazar.prueba.dto.ClienteDTO;
import com.bazar.prueba.dto.ResumenVentasDTO;
import com.bazar.prueba.dto.VentaMayorDTO;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.model.Venta;
import com.bazar.prueba.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<Venta> getVentas() {

        List<Venta> listaVentas = ventaRepository.findAll();
        return listaVentas;
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
    public Venta findVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void editVenta(  Long codigo_venta, Venta venta) {
            venta.setCodigo_venta(codigo_venta);
        this.saveVenta(venta);

    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, LocalDate fecha_venta, Double total) {

    }

    @Override
    public List<Producto> obtenerProductosDeVenta(Long codigoVenta) {

        Venta venta = this.findVenta(codigoVenta);

        if (venta == null) {
            return null;  // null
        }

        return venta.getListaProductos(); // lista de prodductos
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
    public VentaMayorDTO ventaMayor() {

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
