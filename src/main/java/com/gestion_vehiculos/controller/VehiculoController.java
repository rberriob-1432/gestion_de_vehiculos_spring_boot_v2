package com.gestion_vehiculos.controller;

import com.gestion_vehiculos.model.Vehiculo;
import com.gestion_vehiculos.service.VehiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vehiculos", vehiculoService.listarVehiculos());
        return "vehiculos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "vehiculos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Vehiculo vehiculo) {
        vehiculoService.guardar(vehiculo);
        return "redirect:/vehiculos";
    }

    @GetMapping("/editar/{placa}")
    public String editar(@PathVariable String placa, Model model) {

        Vehiculo vehiculo = vehiculoService.buscarPorPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        model.addAttribute("vehiculo", vehiculo);

        return "vehiculos/formulario";
    }

    @GetMapping("/eliminar/{placa}")
    public String eliminar(@PathVariable String placa) {
        vehiculoService.eliminar(placa);
        return "redirect:/vehiculos";
    }

    @GetMapping("/buscar")
    public String buscar(
            @RequestParam(required = false) String placa,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String combustible,
            Model model) {

        if (placa != null && !placa.isBlank()) {

            vehiculoService.buscarPorPlaca(placa)
                    .ifPresent(vehiculo ->
                            model.addAttribute("vehiculos",
                                    java.util.List.of(vehiculo)));

        } else if (categoria != null && !categoria.isBlank()) {

            model.addAttribute(
                    "vehiculos",
                    vehiculoService.buscarPorCategoria(categoria)
            );

        } else if (combustible != null && !combustible.isBlank()) {

            model.addAttribute(
                    "vehiculos",
                    vehiculoService.buscarPorCombustible(combustible)
            );

        } else {

            model.addAttribute(
                    "vehiculos",
                    vehiculoService.listarVehiculos()
            );
        }

        return "vehiculos/lista";
    }
}