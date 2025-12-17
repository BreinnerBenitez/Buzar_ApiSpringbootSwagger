package com.bazar.prueba.controller;

import com.bazar.prueba.dto.ProductoDTO;
import com.bazar.prueba.model.Producto;
import com.bazar.prueba.service.IProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Productos", description = "CRUD completo de productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Operation(
            summary = "Crear un nuevo Producto",
            description = "Registra un nuevo producto en el sistema"
    )
    @PostMapping("/productos/crear")
    public ResponseEntity<?> createProducto(@RequestBody Producto pro) {

        productoService.saveProducto(pro);

        return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado con exito");
    }

    @Operation(
            summary = "Listar todos los Productos",
            description = "Muestra la lista completa de los productos  registrados"
    )
    @GetMapping("/productos")
    public  ResponseEntity<List<ProductoDTO>> traerProductos() {

        return   ResponseEntity.ok(productoService.getProductos());
    }

    @Operation(
            summary = "Listar producto ",
            description = "Muestra  el  producto  registrado  por id"
    )

    @GetMapping("/productos/{codigo_producto}")
    public ResponseEntity <ProductoDTO> traerProductos(
            @Parameter(description = "codigo del producto  a eliminar")
            @PathVariable Long codigo_producto) { // trae el producto con el codigo del producto

        return  ResponseEntity.ok(productoService.findProducto(codigo_producto));
    }

    @Operation(
            summary = "Eliminar producto ",
            description = "Elimina  el  producto  registrado  por id"
    )

    @DeleteMapping("/productos/eliminar/{codigo_producto}")  // borra el producto
    public ResponseEntity<?> deleteProducto(
            @Parameter(description = "codigo del producto a eliminar")
            @PathVariable Long codigo_producto) {

        productoService.deleteProducto(codigo_producto);

        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Editar producto ",
            description = "Edita  el  producto  registrado  por id"
    )
    @PutMapping("/productos/editar/{codigo_producto}")
    public  ResponseEntity <?> editProducto(
            @Parameter(description = "codigo del producto  a editar")
            @PathVariable Long codigo_producto, @RequestBody Producto pro) { // editar producto

        productoService.editProducto(codigo_producto, pro);

        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = " productos cantidad menor a 5  ",
            description = "Trae los productos  con canitdad menor de 5"
    )
    @GetMapping("/productos/falta_stock") // punto 4
    public  ResponseEntity  <List> traerCanitdad5() {

        return ResponseEntity.ok(productoService.getProductoCantidad5());
    }
}
