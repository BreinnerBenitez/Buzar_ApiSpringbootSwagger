package com.bazar.prueba.service;

import com.bazar.prueba.model.Producto;
import com.bazar.prueba.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repoRepository;


    @Override
    public List<Producto> getProductos() {  // trae la lista de productos
        List<Producto> listaProductos = repoRepository.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto Producto) {  // metodo usado en el controller para guardar
        repoRepository.save(Producto);
    }

    @Override
    public void deleteProducto(Long id) {  //para borrar producto
        repoRepository.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {  // buscar producto

        return repoRepository.findById(id).orElse(null);


    }

    @Override
    public void editProducto(Long codigo_producto,Producto producto) {
        producto.setCodigo_producto(codigo_producto);
        this.saveProducto(producto);

    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double cantidad_disponible) {


    }

    @Override
    public List<Producto> getProductoCantidad5() {

        List<Producto> listaproductos = this.getProductos();
        List<Producto> listaproductos5 = new ArrayList<>();
        Producto pro = new Producto();
        for (Producto p : listaproductos) {
            if (p.getCantidad_disponible() < 5) {
                pro.setCodigo_producto(p.getCodigo_producto());
                pro.setNombre(p.getNombre());
                pro.setCantidad_disponible(p.getCantidad_disponible());
                pro.setCosto(p.getCosto());

                listaproductos5.add(pro);
                pro = new Producto(); //reseteo
            }
        }

        return listaproductos5;
    }


}
