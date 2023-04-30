package org.example;

public class Barco {
    private String nombre;
    private int capacidad;
    private int tripulacion;
    private double velocidad;

    public Barco(String nombre, int capacidad, int tripulacion, double velocidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tripulacion = tripulacion;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTripulacion() {
        return tripulacion;
    }

    public double getVelocidad() {
        return velocidad;
    }

}
