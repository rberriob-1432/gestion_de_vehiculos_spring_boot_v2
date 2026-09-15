package com.gestion_vehiculos.repository;

import com.gestion_vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

    List<Vehiculo> findByCategoriaIgnoreCase(String categoria);

    List<Vehiculo> findByCombustibleIgnoreCase(String combustible);
}