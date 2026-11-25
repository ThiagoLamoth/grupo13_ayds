package com.example.grupo13.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupo13.model.Pedido;
import com.example.grupo13.model.Reclamo;
import com.example.grupo13.service.ReclamoService;
import com.example.grupo13.util.SesionCliente;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {

    private static final Logger logger = LoggerFactory.getLogger(ReclamoController.class);

    private final ReclamoService reclamoService;

    // Singleton: la sesión del cliente es única y compartida
    private final SesionCliente sesion = SesionCliente.getInstance();

    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    // ---------- Realizar reclamo ----------
    // POST /api/reclamos?motivo=...&descripcion=...&evidencia=...   (el pedido va en el body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reclamo realizarReclamo(@RequestBody Pedido pedido,
                                   @RequestParam String motivo,
                                   @RequestParam String descripcion,
                                   @RequestParam String evidencia) {
        logger.info("POST /api/reclamos - pedido id={}", pedido.getId());
        return reclamoService.registrarReclamo(pedido, motivo, descripcion, evidencia);
    }

    // ---------- Consultar historial de reclamos ----------
    // GET /api/reclamos/historial
    @GetMapping("/historial")
    public List<Reclamo> consultarHistorialReclamos() {
        logger.info("GET /api/reclamos/historial");
        return reclamoService.listarReclamosDeCliente(sesion.getClienteLogueado());
    }
}