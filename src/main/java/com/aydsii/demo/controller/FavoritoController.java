package com.example.grupo13.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupo13.model.Producto;
import com.example.grupo13.service.FavoritoService;
import com.example.grupo13.util.SesionCliente;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    private static final Logger logger = LoggerFactory.getLogger(FavoritoController.class);

    private final FavoritoService favoritoService;

    // Singleton: la sesión del cliente es única y compartida
    private final SesionCliente sesion = SesionCliente.getInstance();

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    // POST /api/favoritos   (el producto va en el body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarAFavoritos(@RequestBody Producto producto) {
        logger.info("POST /api/favoritos - producto id={}", producto.getId());
        favoritoService.registrarFavorito(sesion.getClienteLogueado(), producto);
    }
}