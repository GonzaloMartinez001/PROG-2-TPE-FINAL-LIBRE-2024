package juegoDeCartasTPE.pocimas;

import juegoDeCartasTPE.Carta;

import java.util.ArrayList;

public class PocimaCocktail extends Pocima{
    protected ArrayList<Pocima> pocimas;

    public PocimaCocktail(String nombre, String nombreCarta) {
        super(nombre, nombreCarta);
        this.pocimas = new ArrayList<>();
    }

    public ArrayList<Pocima> getPocimas() {
        return pocimas;
    }

    public void setPocimas(ArrayList<Pocima> pocimas) {
        this.pocimas = pocimas;
    }

    public void addPocima(Pocima pocima){
        pocima.setNombreCarta(this.getNombreCarta());
        pocimas.add(pocima);
    }

    public void setNombrePocima(String nombrePocima){
        for (Pocima pocima : pocimas){
            pocima.setNombreCarta(nombrePocima);
        }
    }

    @Override
    public Carta efectoPocima(Carta carta) {
        Carta cartaCopia = new Carta(carta.getNombre());
        cartaCopia.setAtributos(carta.getAtributos());

        for (Pocima pocima : pocimas){
            cartaCopia = pocima.efectoPocima(cartaCopia);
        }

        return cartaCopia;
    }
}
