package com.example.grupo13.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.grupo13.model.Cliente;
import com.example.grupo13.model.Producto;

@Service
public class FavoritoService {

    private static final Logger logger = LoggerFactory.getLogger(FavoritoService.class);

    // 1.1 registrarFavorito(cliente, producto)
    public void registrarFavorito(Cliente cliente, Producto producto) {
        logger.info("Cliente {} quiere agregar el producto {} a favoritos", cliente.getEmail(), producto.getId());

        // 1.1.1 estaEnFavoritos(producto)
        if (cliente.estaEnFavoritos(producto)) {
            logger.warn("El producto {} ya está en los favoritos del cliente {}", producto.getId(), cliente.getEmail());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El producto ya está en favoritos");
        }
        // 1.1.2 agregarFavorito(producto)
        cliente.agregarFavorito(producto);
        logger.info("Producto {} agregado. El cliente {} tiene ahora {} favorito(s)",
                producto.getId(), cliente.getEmail(), cliente.getFavoritos().size());
    }
}