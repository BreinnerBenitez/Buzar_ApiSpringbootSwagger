package com.bazar.prueba.service;

import com.bazar.prueba.dto.ClienteDTO;
import com.bazar.prueba.model.Cliente;

import java.util.List;

public interface IClienteService {

    //método para traer a todas las personas
    //lectura
     List<ClienteDTO> getClientes();

    //crear
     void saveCliente(Cliente Cliente);

    //eliminar
     void deleteCliente(Long id);

    //buscar
     ClienteDTO findCliente(Long id);

    //edición/modificación
     void editCliente (Long id_cliente ,Cliente Cliente);
     void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String Apellido,
                          String dni);



}
