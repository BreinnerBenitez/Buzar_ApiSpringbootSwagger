package com.bazar.prueba.repository;

import com.bazar.prueba.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findByfechaVenta(LocalDate fecha_venta);
    Venta findTopByOrderByTotalDesc();
}
