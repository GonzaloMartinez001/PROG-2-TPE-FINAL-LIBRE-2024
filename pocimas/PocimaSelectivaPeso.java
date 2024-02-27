package juegoDeCartasTPE.pocimas;

import juegoDeCartasTPE.Carta;

import java.util.HashMap;

public class PocimaSelectivaPeso extends Pocima{
    protected double valorPocima;

    public PocimaSelectivaPeso(String nombre, String nombreCarta, double valorPocima) {
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

        if (atributos.containsKey("Peso")){
            double pesoActual = atributos.get("Peso");
            double nuevoValor = (pesoActual * valorPocima);
            atributos.put("Peso", nuevoValor);
        }

        cartaCopia.setAtributos(atributos);
        return cartaCopia;
    }
}
