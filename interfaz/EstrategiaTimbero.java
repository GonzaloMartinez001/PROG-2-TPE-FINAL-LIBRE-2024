package juegoDeCartasTPE.interfaz;

import juegoDeCartasTPE.Carta;

import java.util.Random;
import java.util.Set;

public class EstrategiaTimbero implements EstrategiaJuego{

    @Override
    public String elegirAtributo(Carta carta) {
        Set<String> nombresAtributos = carta.getAtributos().keySet();
        Random valorRandom = new Random();
        int indiceAleatorio = valorRandom.nextInt(nombresAtributos.size());
        String atributoAleatorio = "";
        int i=0;
        for (String nombreAtributo : nombresAtributos) {
            if (i == indiceAleatorio) {
                atributoAleatorio = nombreAtributo;
                break;
            }
            i++;
        }
        return atributoAleatorio;
    }
}
