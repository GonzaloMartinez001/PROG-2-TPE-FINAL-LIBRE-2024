package juegoDeCartasTPE.pocimas;

import juegoDeCartasTPE.Carta;

import java.util.HashMap;

public class PocimaSelectivaFuerza extends Pocima{
    protected double valorPocima;

    public PocimaSelectivaFuerza(String nombre, String nombreCarta, double valorPocima) {
        super(nombre, nombreCarta);
        this.valorPocima = valorPocima;
    }

    public double getValorPocima() {
        return valorPocima;
    }

    public void setValorPocima(double valorPocima) {
        this.valorPocima = valorPocima;
    }

    @Override
    public Carta efectoPocima(Carta carta) {
        HashMap<String,Double> atributos = carta.getAtributos();
        Carta cartaCopia = new Carta(carta.getNombre());

        if (atributos.containsKey("Fuerza")){
            double fuerzaActual = atributos.get("Fuerza");
            double nuevoValor = (fuerzaActual * valorPocima);
            atributos.put("Fuerza", nuevoValor);
        }

        cartaCopia.setAtributos(atributos);
        return cartaCopia;
    }
}
