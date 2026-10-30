package com.aydsii.demo.model;

import java.util.ArrayList;
import java.util.List;

// Empleado hereda de Cliente (generalización del diagrama de clases)
public class Empleado extends Cliente {

    private String area;
    private long idEmpleado;

    // Empleado 1 ---> 1..* Reclamo ("reclamos : List<Reclamo>" del diagrama de secuencia)
    private List<Reclamo> reclamos = new ArrayList<>();

    public Empleado() {
    }

    public Empleado(String area, long idEmpleado) {
        this.area = area;
        this.idEmpleado = idEmpleado;
    }

    // 1.1.3 recibirReclamo(reclamo) -> 1.1.3.1 add(reclamo)
    public void recibirReclamo(Reclamo reclamo) {
        reclamos.add(reclamo);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }
}
