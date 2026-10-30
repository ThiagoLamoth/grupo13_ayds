package com.aydsii.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydsii.demo.model.Catalogo;
import com.aydsii.demo.model.Producto;

@Service
public class ProductoService {

    private final Catalogo catalogo;

    public ProductoService(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Producto> listarProductosDisponibles() {
        return catalogo.obtenerProductosDisponibles();
    }
}
