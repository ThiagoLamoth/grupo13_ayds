package com.aydsii.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Catalogo {

    // Atributo "productos : List<Producto>" del diagrama de secuencia.
    // Datos de ejemplo cargados en memoria (el diagrama no incluye repository).
    private final List<Producto> productos = new ArrayList<>();

    public Catalogo() {
        productos.add(new Producto(1, "Bandeja PET para frutas", "Bandeja de PET reciclado, 500 g", 120.0, 300));
        productos.add(new Producto(2, "Vaso PET 250 ml", "Vaso transparente de PET reciclado", 45.0, 1200));
        productos.add(new Producto(3, "Clamshell PET 500 g", "Envase con tapa articulada de PET reciclado", 150.0, 450));
        productos.add(new Producto(4, "Bandeja PET 1 kg", "Bandeja de PET reciclado, 1 kg", 190.0, 0)); // sin stock
    }

    // Sigue el diagrama de secuencia (1.1.1 a 1.1.1.4):
    // crea la lista "disponibles", recorre "productos" con get(i),
    // consulta estaDisponible() y agrega con add(producto).
    public List<Producto> obtenerProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.estaDisponible()) {
                disponibles.add(producto);
            }
        }
        return disponibles;
    }
}
