package com.aydsii.demo.model;

public class Producto {

    private long id;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private int stockProducto;

    public Producto() {
    }

    public Producto(long id, String nombre, String descripcion, double precioUnitario, int stockProducto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockProducto = stockProducto;
    }

    // Un producto está disponible cuando tiene stock (regla del diagrama: stock > 0)
    public boolean estaDisponible() {
        return stockProducto > 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    // Dos productos son el mismo si tienen el mismo id.
    // Necesario para que List.contains(producto) funcione con objetos recibidos por JSON.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producto otro = (Producto) o;
        return id == otro.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}