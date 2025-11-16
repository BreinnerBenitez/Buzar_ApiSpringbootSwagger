package com.bazar.prueba.controller;

import com.bazar.prueba.model.Producto;
import com.bazar.prueba.service.IProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createProducto(@RequestBody Producto pro) {

        productoService.saveProducto(pro);

        return "productos registrados correctamente";
    }

    @Operation(
            summary = "Listar todos los Productos",
            description = "Muestra la lista completa de los productos  registrados"
    )
    @GetMapping("/productos")
    public List traerProductos() {

        return productoService.getProductos();
    }

    @Operation(
            summary = "Listar producto ",
            description = "Muestra  el  producto  registrado  por id"
    )

    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProductos(
            @Parameter(description = "codigo del producto  a eliminar")
            @PathVariable Long codigo_producto) { // trae el producto con el codigo del producto

        return productoService.findProducto(codigo_producto);
    }

    @Operation(
            summary = "Eliminar producto ",
            description = "Elimina  el  producto  registrado  por id"
    )

    @DeleteMapping("/productos/eliminar/{codigo_producto}")  // borra el producto
    public String deleteProducto(
            @Parameter(description = "codigo del producto a eliminar")
            @PathVariable Long codigo_producto) {

        productoService.deleteProducto(codigo_producto);

        return "el producto fue borrado correctamente";
    }

    @Operation(
            summary = "Editar producto ",
            description = "Edita  el  producto  registrado  por id"
    )
    @PutMapping("/productos/editar/{codigo_producto}")
    public String editProducto(
            @Parameter(description = "codigo del producto  a editar")
            @PathVariable Long codigo_producto, @RequestBody Producto pro) { // editar producto

        productoService.editProducto(codigo_producto, pro);

        return "editar producto";
    }

    @Operation(
            summary = " productos cantidad menor a 5  ",
            description = "Trae los productos  con canitdad menor de 5"
    )
    @GetMapping("/productos/falta_stock") // punto 4
    public List traerCanitdad5() {

        return productoService.getProductoCantidad5();
    }
}
