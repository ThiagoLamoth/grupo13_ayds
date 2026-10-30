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
}
