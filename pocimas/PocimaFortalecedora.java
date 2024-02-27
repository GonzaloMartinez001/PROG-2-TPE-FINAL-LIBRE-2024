package juegoDeCartasTPE.pocimas;

import juegoDeCartasTPE.Carta;

import java.util.HashMap;

public class PocimaFortalecedora extends Pocima {
    protected double valorPocima;

    public PocimaFortalecedora(String nombre, String nombreCarta, double valorPocima) {
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
            double valorActual = atributos.get(atributo);
            double nuevoValor = (valorActual * valorPocima);
            atributos.put(atributo, nuevoValor);
        }

        cartaCopia.setAtributos(atributos);
        return cartaCopia;
    }
}
