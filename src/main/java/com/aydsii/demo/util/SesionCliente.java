package com.example.grupo13.util;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.grupo13.model.Cliente;
import com.example.grupo13.model.EstadosPedido;
import com.example.grupo13.model.Pedido;

/**
 * Patrón Singleton: existe una única sesión de cliente en toda la aplicación.
 * Simula al cliente que inició sesión (todavía no hay login) y lo comparten
 * FavoritoController y ReclamoController.
 */
public class SesionCliente {

    // IMPORTANTE: el logger se declara ANTES que INSTANCIA, porque el constructor
    // lo usa y los atributos estáticos se inicializan en el orden en que están escritos.
    private static final Logger logger = LoggerFactory.getLogger(SesionCliente.class);

    // La única instancia, creada una sola vez al cargar la clase
    private static final SesionCliente INSTANCIA = new SesionCliente();

    private final Cliente clienteLogueado;

    // Constructor privado: nadie puede hacer "new SesionCliente()"
    private SesionCliente() {
        this.clienteLogueado = crearClienteDeEjemplo();
        logger.info("Se creó la única instancia de SesionCliente (cliente: {})", clienteLogueado.getEmail());
    }

    // Punto de acceso global a la única instancia
    public static SesionCliente getInstance() {
        return INSTANCIA;
    }

    public Cliente getClienteLogueado() {
        return clienteLogueado;
    }

    private static Cliente crearClienteDeEjemplo() {
        Cliente cliente = new Cliente("Pérez", "Juan", "juan.perez@mail.com", "2302123456", "1234");

        Pedido p1 = new Pedido("P-001", LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 10),
                EstadosPedido.ENTREGADO, "General Pico", "");
        p1.generarReclamo("Producto dañado", "Las bandejas llegaron rotas", "foto1.jpg");

        Pedido p2 = new Pedido("P-002", LocalDate.of(2026, 10, 15), LocalDate.of(2026, 10, 25),
                EstadosPedido.EN_PROCESO, "General Pico", ""); // sin reclamo

        Pedido p3 = new Pedido("P-003", LocalDate.of(2026, 10, 20), LocalDate.of(2026, 10, 30),
                EstadosPedido.PENDIENTE_ENTREGA, "Santa Rosa", "");
        p3.generarReclamo("Demora en la entrega", "El pedido no llegó en la fecha acordada", "captura.png");

        cliente.getPedidos().add(p1);
        cliente.getPedidos().add(p2);
        cliente.getPedidos().add(p3);
        return cliente;
    }
}