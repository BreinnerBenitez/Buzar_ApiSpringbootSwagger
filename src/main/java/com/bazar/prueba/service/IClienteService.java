package com.bazar.prueba.service;

import com.bazar.prueba.dto.ClienteDTO;
import com.bazar.prueba.model.Cliente;

import java.util.List;

public interface IClienteService {

    //método para traer a todas las personas
    //lectura
    public List<ClienteDTO> getClientes();

    //crear
    public void saveCliente(Cliente Cliente);

    //eliminar
    public void deleteCliente(Long id);

    //buscar
    public Cliente findCliente(Long id);

    //edición/modificación
    public void editCliente (Long id_cliente ,Cliente Cliente);
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String Apellido,
                          String dni);



}
