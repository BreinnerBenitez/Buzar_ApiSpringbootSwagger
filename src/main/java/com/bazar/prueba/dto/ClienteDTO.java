package com.bazar.prueba.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}

