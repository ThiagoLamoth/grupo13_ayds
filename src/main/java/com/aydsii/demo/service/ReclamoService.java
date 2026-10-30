package com.aydsii.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aydsii.demo.model.Empleado;
import com.aydsii.demo.model.Pedido;
import com.aydsii.demo.model.Reclamo;

@Service
public class ReclamoService {

    // "atencionCliente : Empleado" del diagrama de secuencia
    private final Empleado atencionCliente;

    public ReclamoService() {
        this.atencionCliente = new Empleado("Atención al cliente", 1L);
    }

    // 1.1 registrarReclamo(pedido, motivo, descripcion, evidencia)
    public Reclamo registrarReclamo(Pedido pedido, String motivo, String descripcion, String evidencia) {
        // 1.1.1 puedeReclamarse()
        if (!pedido.puedeReclamarse()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El pedido no puede reclamarse");
        }
        // 1.1.2 generarReclamo(...)
        Reclamo reclamo = pedido.generarReclamo(motivo, descripcion, evidencia);
        // 1.1.3 recibirReclamo(reclamo)
        atencionCliente.recibirReclamo(reclamo);
        return reclamo;
    }
}
