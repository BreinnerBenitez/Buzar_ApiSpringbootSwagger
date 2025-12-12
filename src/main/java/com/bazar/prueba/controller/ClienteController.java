package com.bazar.prueba.controller;

import com.bazar.prueba.dto.ClienteDTO;
import com.bazar.prueba.model.Cliente;
import com.bazar.prueba.service.IClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Clientes", description = "CRUD completo de clientes")
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    // CREAR
    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Registra un nuevo cliente en el sistema"
    )
    @PostMapping("/crear")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cli) {
        clienteService.saveCliente(cli);
        return  ResponseEntity.status(HttpStatus.CREATED).body("cliente creado con exito");
    }

    @Operation(
            summary = "Listar todos los clientes",
            description = "Muestra la lista completa de clientes registrados"
    )
    // LISTAR TODOS
    @GetMapping
    public   ResponseEntity<List<ClienteDTO>> traerClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }

    // TRAER UNO POR ID
    @Operation(
            summary = "Obtener un cliente por ID",
            description = "Devuelve la información del cliente solicitado"
    )
    @GetMapping("/{id_cliente}")
    public ClienteDTO traerCliente(
            @Parameter(description = "ID del cliente a buscar")
            @PathVariable Long id_cliente

    ) {
        return clienteService.findCliente(id_cliente);
    }

    // ELIMINAR
    @Operation(
            summary = "Eliminar un cliente",
            description = "Elimina un cliente según su ID"
    )
    @DeleteMapping("/eliminar/{id_cliente}")
    public String eliminarCliente(
            @Parameter(description = "ID del cliente a eliminar")
            @PathVariable Long id_cliente) {
        clienteService.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }

    // EDITAR
    @Operation(
            summary = "Editar un cliente",
            description = "Actualiza los datos de un cliente existente"
    )
    @PutMapping("/editar/{id_cliente}")
    public String editarCliente(
            @Parameter(description = "ID del cliente a editar")
            @PathVariable Long id_cliente,
            @RequestBody Cliente cli) {


        clienteService.editCliente(id_cliente, cli);
        return "Cliente editado correctamente";
    }

}
