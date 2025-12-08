package com.bazar.prueba.service;

import com.bazar.prueba.dto.ClienteDTO;
import com.bazar.prueba.model.Cliente;
import com.bazar.prueba.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repoRepository;

    @Override
    public List<ClienteDTO> getClientes() { //Traer todos los clientes
        List<Cliente> listaCliente = repoRepository.findAll();
        List<ClienteDTO> listaClienteDto = new ArrayList<>(); // lista de clientes dto
        ClienteDTO cliDTO = new ClienteDTO();

        for (Cliente cli : listaCliente) {

            cliDTO.setNombre(cli.getNombre());   // paso de la entidad al DTO
            cliDTO.setApellido(cli.getApellido());
            cliDTO.setDni(cli.getApellido());
            listaClienteDto.add(cliDTO);
            cliDTO = new ClienteDTO(); //reinicio el objeto
        }


        return listaClienteDto;
    }

    @Override
    public void saveCliente(Cliente Cliente) {
        repoRepository.save(Cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        repoRepository.deleteById(id);
    }

    @Override
    public ClienteDTO findCliente(Long id) {
        Cliente cli = repoRepository.findById(id).orElse(null);
        ClienteDTO cliDTO = new ClienteDTO();
        cliDTO.setDni(cli.getDni());
        cliDTO.setNombre(cli.getNombre());
        cliDTO.setApellido(cli.getApellido());

        return cliDTO;
    }

    @Override
    public void editCliente(Long id_cliente, Cliente cliente) {
        cliente.setId_cliente(id_cliente);
        this.saveCliente(cliente);

    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String Apellido, String dni) {

    }


}
