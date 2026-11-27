package com.aydsii.demo.model;

import java.time.LocalDate;

public class Pedido {

    private String id;
    private LocalDate fecha;
    private LocalDate fechaEntrega;
    private EstadosPedido estado;
    private String destino;
    private String observacion;

    // Pedido 1 ---> 0..1 Reclamo
    private Reclamo reclamo;

    public Pedido() {
    }

    public Pedido(String id, LocalDate fecha, LocalDate fechaEntrega, EstadosPedido estado,
                  String destino, String observacion) {
        this.id = id;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.destino = destino;
        this.observacion = observacion;
    }

    // SUPUESTO DEL GRUPO: un pedido se puede reclamar mientras no esté cancelado.
    // (Si deciden que solo se reclama tras la entrega: return estado == EstadosPedido.ENTREGADO;)
    public boolean puedeReclamarse() {
        return estado != null && estado != EstadosPedido.CANCELADO;
    }

    // 1.1.2 generarReclamo -> 1.1.2.1 <<create>> Reclamo
    public Reclamo generarReclamo(String motivo, String descripcion, String evidencia) {
        Reclamo nuevo = new Reclamo(motivo, descripcion, evidencia);
        this.reclamo = nuevo;
        return nuevo;
    }

    // 1.1.1.3 obtenerReclamo(): devuelve el reclamo del pedido (null si no tiene)
    public Reclamo obtenerReclamo() {
        return reclamo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadosPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadosPedido estado) {
        this.estado = estado;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}