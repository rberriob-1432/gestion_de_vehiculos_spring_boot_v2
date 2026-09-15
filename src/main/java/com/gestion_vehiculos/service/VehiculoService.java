package com.gestion_vehiculos.service;

import com.gestion_vehiculos.model.Vehiculo;
import com.gestion_vehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return vehiculoRepository.findById(placa);
    }

    public List<Vehiculo> buscarPorCategoria(String categoria) {
        return vehiculoRepository.findByCategoriaIgnoreCase(categoria);
    }

    public List<Vehiculo> buscarPorCombustible(String combustible) {
        return vehiculoRepository.findByCombustibleIgnoreCase(combustible);
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminar(String placa) {
        vehiculoRepository.deleteById(placa);
    }
}