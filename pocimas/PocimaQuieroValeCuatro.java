package juegoDeCartasTPE.pocimas;

import juegoDeCartasTPE.Carta;

import java.util.HashMap;

public class PocimaQuieroValeCuatro extends Pocima{
    protected double valorPocima;

    public PocimaQuieroValeCuatro(String nombre, String nombreCarta, double valorPocima) {
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

        for (String atributo : atributos.keySet()){
            atributos.put(atributo, valorPocima);
        }

        cartaCopia.setAtributos(atributos);
        return cartaCopia;
    }

    @Override
    public String toString() {
        return "PocimaQuieroValeCuatro{" +
                "valorPocima=" + valorPocima +
                super.toString() +
                '}';
    }
}
