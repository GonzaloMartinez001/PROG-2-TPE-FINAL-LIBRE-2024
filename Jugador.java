package juegoDeCartasTPE;

import java.util.ArrayList;

public class Jugador {
    protected String nombreJugador;
    protected ArrayList<Carta> mazoJugador;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.mazoJugador = new ArrayList<>();
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public ArrayList<Carta> getMazoJugador() {
        return mazoJugador;
    }

    public void setMazoJugador(ArrayList<Carta> mazoJugador) {
        this.mazoJugador = mazoJugador;
    }


}
