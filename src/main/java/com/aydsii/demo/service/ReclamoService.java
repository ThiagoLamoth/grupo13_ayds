package com.example.grupo13.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.grupo13.model.Cliente;
import com.example.grupo13.model.Empleado;
import com.example.grupo13.model.Pedido;
import com.example.grupo13.model.Reclamo;

@Service
public class ReclamoService {

    private static final Logger logger = LoggerFactory.getLogger(ReclamoService.class);

    // "atencionCliente : Empleado" del diagrama de secuencia de Realizar reclamo
    private final Empleado atencionCliente;

    public ReclamoService() {
        this.atencionCliente = new Empleado("Atención al cliente", 1L);
    }

    // Realizar reclamo - 1.1 registrarReclamo(pedido, motivo, descripcion, evidencia)
    public Reclamo registrarReclamo(Pedido pedido, String motivo, String descripcion, String evidencia) {
        // 1.1.1 puedeReclamarse()
        if (!pedido.puedeReclamarse()) {
            logger.warn("El pedido {} no puede reclamarse", pedido.getId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El pedido no puede reclamarse");
        }
        // 1.1.2 generarReclamo(...)
        Reclamo reclamo = pedido.generarReclamo(motivo, descripcion, evidencia);
        // 1.1.3 recibirReclamo(reclamo)
        atencionCliente.recibirReclamo(reclamo);
        logger.info("Reclamo {} registrado para el pedido {}", reclamo.getId(), pedido.getId());
        return reclamo;
    }

    // Consultar historial de reclamos - 1.1 listarReclamosDeCliente(cliente)
    public List<Reclamo> listarReclamosDeCliente(Cliente cliente) {
        logger.info("Listando reclamos del cliente {}", cliente.getEmail());
        // 1.1.1 obtenerReclamos()
        List<Reclamo> historial = cliente.obtenerReclamos();
        logger.info("Se encontraron {} reclamo(s) para el cliente {}", historial.size(), cliente.getEmail());
        return historial;
    }
}