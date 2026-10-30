package com.aydsii.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aydsii.demo.model.Pedido;
import com.aydsii.demo.model.Reclamo;
import com.aydsii.demo.service.ReclamoService;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {

    private final ReclamoService reclamoService;

    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    // POST /api/reclamos?motivo=...&descripcion=...&evidencia=...   (el pedido va en el body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reclamo realizarReclamo(@RequestBody Pedido pedido,
                                   @RequestParam String motivo,
                                   @RequestParam String descripcion,
                                   @RequestParam String evidencia) {
        return reclamoService.registrarReclamo(pedido, motivo, descripcion, evidencia);
    }
}
