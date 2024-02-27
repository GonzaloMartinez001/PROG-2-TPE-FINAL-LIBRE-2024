package juegoDeCartasTPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Mazo {
    protected ArrayList<Carta> cartas;


    public Mazo() {
        this.cartas = new ArrayList<>();
    }

    public boolean verificarCartas() {
        Carta primerCarta = cartas.get(0);
        int cantAtributos = primerCarta.getAtributos().size();
        Set<String> nombresAtributos = primerCarta.getAtributos().keySet();

        for (Carta carta : cartas) {
            if (cantAtributos != carta.getAtributos().size() & nombresAtributos != carta.getAtributos().keySet()) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Carta> getCartas() {
        ArrayList<Carta> aux = new ArrayList<>(cartas);
        return aux;
    }

    public void addCartas(Carta carta) {
        this.cartas.add(carta);
    }

    public int cantCartas() {
        return cartas.size();
    }

    public boolean cartasPar() {
        int cantCartas = cartas.size();
        return (cantCartas % 2 == 0);
    }


    public void mezclarCartas(){
        Collections.shuffle(cartas);
    }


}
