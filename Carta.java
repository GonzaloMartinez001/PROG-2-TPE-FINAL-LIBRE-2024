package juegoDeCartasTPE;

import java.util.HashMap;
import java.util.Map;

public class Carta {
    protected String nombre;
    protected Map<String,Double> atributos;


    public Carta(String nombre) {
        this.nombre = nombre;
        this.atributos = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addAtributos(String nombreAtrib, Double valor) {
        this.atributos.put(nombreAtrib,valor);
    }

    public HashMap<String, Double> getAtributos() {
        return new HashMap<>(atributos);
    }

    public void setAtributos(Map<String, Double> atributos) {
        this.atributos = atributos;
    }

    public Double getValorAtributo(String nombreAtributo) {
        return atributos.get(nombreAtributo);
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", atributos=" + atributos +
                '}';
    }
}
