package com.aydsii.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aydsii.demo.model.Producto;
import com.aydsii.demo.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET /api/productos/catalogo
    @GetMapping("/catalogo")
    public List<Producto> consultarCatalogo() {
        return productoService.listarProductosDisponibles();
    }
}
