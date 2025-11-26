package com.bazar.prueba.service;

import com.bazar.prueba.dto.ProductoDTO;
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
    public List<ProductoDTO> getProductos() { // trae la lista de productos
        List<Producto> listaProductos = repoRepository.findAll();
        List<ProductoDTO> listaProductoDTO = new ArrayList<>();
        ProductoDTO proDTO = new ProductoDTO();

        for (Producto p : listaProductos) {

            proDTO.setCantidad_disponible(p.getCantidad_disponible());
            proDTO.setNombre(p.getNombre());
            proDTO.setMarca(p.getMarca());
            proDTO.setCosto(p.getCosto());

        }
        listaProductoDTO.add(proDTO);
        proDTO = new ProductoDTO(); // reincia el objeto
        return listaProductoDTO;
    }

    @Override
    public List<Producto> getProductosInterno() {  // trae la lista de productos para los metodos internos
        List<Producto> listaProductos = repoRepository.findAll();


        return listaProductos; // falta a comodar esto
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
    public void editProducto(Long codigo_producto, Producto producto) {
        producto.setCodigo_producto(codigo_producto);
        this.saveProducto(producto);

    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double cantidad_disponible) {


    }

    @Override
    public List<ProductoDTO> getProductoCantidad5() {

        List<Producto> listaproductos = this.getProductosInterno();
        List<ProductoDTO> listaproductos5 = new ArrayList<>();
        ProductoDTO proDTO = new ProductoDTO();
        for (Producto p : listaproductos) {
            if (p.getCantidad_disponible() < 5) {
                proDTO.setCodigo_producto(p.getCodigo_producto());
                proDTO.setNombre(p.getNombre());
                proDTO.setCantidad_disponible(p.getCantidad_disponible());
                proDTO.setCosto(p.getCosto());

                listaproductos5.add(proDTO);
                proDTO = new ProductoDTO(); //reseteo
            }
        }

        return listaproductos5;
    }


}
