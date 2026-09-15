package com.gestion_vehiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehiculo {

    @Id
    private String placa;

    private String marca;
    private String modelo;
    private String version;
    private String color;
    private Integer numPuestos;
    private Integer numPuertas;
    private String combustible;
    private Double kilometros;
    private Double cilindraje;
    private String categoria;
}