package com.bazar.prueba.controller;

import com.bazar.prueba.dto.ResumenVentasDTO;
import com.bazar.prueba.dto.VentaMayorDTO;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.model.Venta;
import com.bazar.prueba.service.IVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Tag(name = "Venta", description = "CRUD completo de ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    // CREAR
    @Operation(
            summary = "Agregar ventas ",
            description = "Agrega la venta  registrada")
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta ven) {
        ventaService.saveVenta(ven);
        return "Venta registrada correctamente";
    }

    // LISTAR TODAS
    @Operation(
            summary = "Listar todos las Ventas",
            description = "Muestra la lista completa de las Ventas  registrados")
    @GetMapping("/ventas")
    public List<Venta> traerVentas() {
        return ventaService.getVentas();
    }

    // TRAER UNA POR CÓDIGO
    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(
            @Parameter(description = "codigo de la venta a traer")
            @PathVariable Long codigo_venta) {
        return ventaService.findVenta(codigo_venta);
    }

    @Operation(
            summary = "Eliminar una venta",
            description = "Elimina una  Ventaa  registrada")
    // ELIMINAR
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(
            @Parameter(description = "codigo de la venta a eliminar")
            @PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }

    // EDITAR
    @Operation(
            summary = "Editar venta",
            description = "Edita las ventas")
    @PutMapping("/ventas/editar/{codigo_venta}")
    public String editarVenta(
            @Parameter(description = "codigo de la venta a editar")
            @PathVariable Long codigo_venta,
            @RequestBody Venta ven) {

        ventaService.editVenta(codigo_venta, ven);
        return "Venta editada correctamente";
    }

    @Operation(
            summary = "trae los prodcuto de la venta",
            description = "con el codigo de la venta tra los productos relacionados a la venta")
    @GetMapping("/ventas/productos/{codigo_venta}") // obtener productos de venta
    public List<Producto> obtenerProductosPorVenta(
            @Parameter(description = "codigo de venta ")
            @PathVariable Long codigo_venta) {

        return ventaService.obtenerProductosDeVenta(codigo_venta);
    }

    @Operation(
            summary = "venta por fecha",
            description = " Obtienes venta por fecha todo el monto y cantidad de ventas")
    @GetMapping("/ventas/fecha/{fechaVenta}")  // venta por fecha todo el monto y cantidad de ventas
    public ResumenVentasDTO obtenerMontoVenta(
            @Parameter(description = "fecha a buscar")
            @PathVariable LocalDate fechaVenta) {

        return ventaService.obtenerResumenPorFecha(fechaVenta);
    }

    @Operation(
            summary = "venta mayor",
            description = " obtener la venta mayor ")
    @GetMapping("/ventas/mayor_venta")
    public VentaMayorDTO getVentaMayor() {
        return ventaService.ventaMayor();
    }


}
