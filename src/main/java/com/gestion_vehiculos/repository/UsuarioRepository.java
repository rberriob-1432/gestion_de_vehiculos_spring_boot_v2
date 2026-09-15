package com.gestion_vehiculos.repository;

import com.gestion_vehiculos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}