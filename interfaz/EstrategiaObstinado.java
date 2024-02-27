package juegoDeCartasTPE.interfaz;

import juegoDeCartasTPE.Carta;


public class EstrategiaObstinado implements EstrategiaJuego{
    protected String atributoElegido;

    public EstrategiaObstinado(String atributoElegido) {
        this.atributoElegido = atributoElegido;
    }

    @Override
    public String elegirAtributo(Carta carta) {
        return atributoElegido;
    }
}
