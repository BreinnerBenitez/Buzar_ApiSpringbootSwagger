package com.bazar.prueba.repository;

import com.bazar.prueba.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente,Long>{
}
