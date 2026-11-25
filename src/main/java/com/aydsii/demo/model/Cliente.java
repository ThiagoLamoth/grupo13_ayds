package com.example.grupo13.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String apellido;
    private String nombre;
    private String email;
    private String telefono;
    private String contrasenia; // "contraseña" en el diagrama (se evita la ñ en el código)

    // Cliente 1 ---> 1..* Pedido
    private List<Pedido> pedidos = new ArrayList<>();

    // Cliente 1 ---> 1..* Producto ("favoritos : List<Producto>" del diagrama de secuencia)
    private List<Producto> favoritos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String apellido, String nombre, String email, String telefono, String contrasenia) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }

    // 1.1.1 estaEnFavoritos(producto) -> 1.1.1.1 contains(producto)
    public boolean estaEnFavoritos(Producto producto) {
        return favoritos.contains(producto);
    }

    // 1.1.2 agregarFavorito(producto) -> 1.1.2.1 add(producto)
    public void agregarFavorito(Producto producto) {
        favoritos.add(producto);
    }

    // 1.1.1 obtenerReclamos(): arma el historial recorriendo los pedidos del cliente
    public List<Reclamo> obtenerReclamos() {
        List<Reclamo> historial = new ArrayList<>();                 // 1.1.1.1 <<create>> historial
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);                          // 1.1.1.2 get(i)
            Reclamo reclamo = pedido.obtenerReclamo();               // 1.1.1.3 obtenerReclamo()
            if (reclamo != null) {                                   // un pedido puede no tener reclamo (0..1)
                historial.add(reclamo);                              // 1.1.1.4 add(reclamo)
            }
        }
        return historial;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Producto> getFavoritos() {
        return favoritos;
    }
}