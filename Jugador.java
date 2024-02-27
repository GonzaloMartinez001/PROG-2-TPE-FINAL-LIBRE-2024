package juegoDeCartasTPE;

import juegoDeCartasTPE.interfaz.EstrategiaJuego;

import java.util.ArrayList;

public class Jugador {
    protected String nombreJugador;
    protected ArrayList<Carta> mazoJugador;
    protected EstrategiaJuego estrategiaJugador;

    public Jugador(String nombreJugador, EstrategiaJuego estrategiaJugador) {
        this.nombreJugador = nombreJugador;
        this.mazoJugador = new ArrayList<>();
        this.estrategiaJugador = estrategiaJugador;
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

    public EstrategiaJuego getEstrategiaJugador() {
        return estrategiaJugador;
    }

    public void cambiarEstrategia(EstrategiaJuego nuevaEstrategia){
        this.estrategiaJugador = nuevaEstrategia;
    }

    public String elegirAtributo(Carta carta){
        return estrategiaJugador.elegirAtributo(carta);
    }
}
