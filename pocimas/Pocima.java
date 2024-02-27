package juegoDeCartasTPE.pocimas;


import juegoDeCartasTPE.Carta;

public abstract class Pocima {
    protected String nombre;
    protected String nombreCarta;

    public Pocima(String nombre, String nombreCarta) {
        this.nombre = nombre;
        this.nombreCarta = nombreCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }

    public abstract Carta efectoPocima(Carta carta);

}
