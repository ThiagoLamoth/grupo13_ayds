package com.aydsii.demo.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Reclamo {

    // Genera ids consecutivos mientras no haya base de datos
    private static final AtomicLong SECUENCIA = new AtomicLong(1);

    private long id;
    private LocalDate fecha;
    private String motivo;
    private String descripcion;
    private String evidencia;
    private String gravedad;
    private EstadosReclamo estado;

    // 1.1.2.1 <<create>> Reclamo(motivo, descripcion, evidencia)
    public Reclamo(String motivo, String descripcion, String evidencia) {
        this.id = SECUENCIA.getAndIncrement();
        this.fecha = LocalDate.now();
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.evidencia = evidencia;
        this.gravedad = "SIN_ASIGNAR"; // la define luego la empresa, no el cliente
        this.estado = EstadosReclamo.PENDIENTE;
    }

    public long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public String getGravedad() {
        return gravedad;
    }

    public EstadosReclamo getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Reclamo [id=" + id + ", fecha=" + fecha + ", motivo=" + motivo
                + ", descripcion=" + descripcion + ", evidencia=" + evidencia
                + ", gravedad=" + gravedad + ", estado=" + estado + "]";
    }
}
