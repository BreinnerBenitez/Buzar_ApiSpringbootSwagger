package com.bazar.prueba.service;

import com.bazar.prueba.dto.ProductoDTO;
import com.bazar.prueba.model.Producto;

import java.util.List;

public interface IProductoService {

    //método para traer a todas las personas
    //lectura
     List<ProductoDTO> getProductos();
     List<Producto> getProductosInterno();

    //crear
     void saveProducto(Producto Producto);

    //eliminar
     void deleteProducto(Long id);

    //buscar
     ProductoDTO findProducto(Long id);

    //edición/modificación
     void editProducto (Long codigo_producto,Producto Producto);
     void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaMarca,
                            Double nuevoCosto, Double cantidad_disponible);

     List<ProductoDTO> getProductoCantidad5();
}
