package com.bazar.prueba.controller;

import com.bazar.prueba.dto.ProductoDTO;
import com.bazar.prueba.dto.ResumenVentasDTO;
import com.bazar.prueba.dto.VentaDTO;
import com.bazar.prueba.dto.VentaMayorDTO;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.model.Venta;
import com.bazar.prueba.service.IVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <?> crearVenta(@RequestBody Venta ven) {
        ventaService.saveVenta(ven);
        return   ResponseEntity.status(HttpStatus.CREATED).body("Venta registrada correctamente");
    }

    // LISTAR TODAS
    @Operation(
            summary = "Listar todos las Ventas",
            description = "Muestra la lista completa de las Ventas  registrados")
    @GetMapping("/ventas")
    public  ResponseEntity <List<VentaDTO>> traerVentas() {
        return ResponseEntity.ok(ventaService.getVentas());
    }

    // TRAER UNA POR CÓDIGO
    @GetMapping("/ventas/{codigo_venta}")
    public ResponseEntity <VentaDTO> traerVenta(
            @Parameter(description = "codigo de la venta a traer")
            @PathVariable Long codigo_venta) {
        return  ResponseEntity.ok(ventaService.findVenta(codigo_venta));
    }

    @Operation(
            summary = "Eliminar una venta",
            description = "Elimina una  Ventaa  registrada")
    // ELIMINAR
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public  ResponseEntity <?> eliminarVenta(
            @Parameter(description = "codigo de la venta a eliminar")
            @PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
        return ResponseEntity.noContent().build();
    }

    // EDITAR
    @Operation(
            summary = "Editar venta",
            description = "Edita las ventas")
    @PutMapping("/ventas/editar/{codigo_venta}")
    public ResponseEntity<?> editarVenta(
            @Parameter(description = "codigo de la venta a editar")
            @PathVariable Long codigo_venta,
            @RequestBody Venta ven) {

        ventaService.editVenta(codigo_venta, ven);
        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "trae los prodcuto de la venta",
            description = "con el codigo de la venta trae los productos relacionados a la venta")
    @GetMapping("/ventas/productos/{codigo_venta}") // obtener productos de venta
    public  ResponseEntity  <List<ProductoDTO>> obtenerProductosPorVenta(
            @Parameter(description = "codigo de venta ")
            @PathVariable Long codigo_venta) {

        return  ResponseEntity.ok(ventaService.obtenerProductosDeVenta(codigo_venta));
    }

    @Operation(
            summary = "venta por fecha",
            description = " Obtienes venta por fecha todo el monto y cantidad de ventas")
    @GetMapping("/ventas/fecha/{fechaVenta}")  // venta por fecha todo el monto y cantidad de ventas
    public  ResponseEntity <ResumenVentasDTO> obtenerMontoVenta(
            @Parameter(description = "fecha a buscar")
            @PathVariable LocalDate fechaVenta) {

        return  ResponseEntity.ok(ventaService.obtenerResumenPorFecha(fechaVenta));
    }

    @Operation(
            summary = "venta mayor",
            description = " obtener la venta mayor ")
    @GetMapping("/ventas/mayor_venta")
    public  ResponseEntity <VentaMayorDTO> getVentaMayor() {
        return  ResponseEntity.ok( ventaService.ventaMayor());
    }


}
