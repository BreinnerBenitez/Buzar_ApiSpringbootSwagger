package com.bazar.prueba.service;

import com.bazar.prueba.model.Producto;

import java.util.List;

public interface IProductoService {

    //método para traer a todas las personas
    //lectura
    public List<Producto> getProductos();

    //crear
    public void saveProducto(Producto Producto);

    //eliminar
    public void deleteProducto(Long id);

    //buscar
    public Producto findProducto(Long id);

    //edición/modificación
    public void editProducto (Long codigo_producto,Producto Producto);
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaMarca,
                            Double nuevoCosto, Double cantidad_disponible);

    public List<Producto> getProductoCantidad5();
}
