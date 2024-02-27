package juegoDeCartasTPE.interfaz;

import juegoDeCartasTPE.Carta;

import java.util.Map;
import java.util.Set;

public class EstrategiaAmbicioso implements EstrategiaJuego{

    @Override
    public String elegirAtributo(Carta carta) {
        Map<String, Double> atributos = carta.getAtributos();
        String atributoMayor = "";
        Double valorAtributoMayor = 0.0;

        for (Map.Entry<String, Double> entry : atributos.entrySet()){
            String nombreAtributo = entry.getKey();
            Double valorAtributo = entry.getValue();

            if (valorAtributo > valorAtributoMayor){
                atributoMayor = nombreAtributo;
                valorAtributoMayor = valorAtributo;
            }
        }
        return atributoMayor;
    }
}
