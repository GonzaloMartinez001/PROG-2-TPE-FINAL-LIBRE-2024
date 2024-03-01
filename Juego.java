package juegoDeCartasTPE;

import juegoDeCartasTPE.pocimas.Pocima;
import juegoDeCartasTPE.pocimas.PocimaCocktail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

public class Juego {
    protected Mazo mazo;
    protected Jugador jugador1, jugador2;

    protected ArrayList<Pocima> mazoPocima;

    public Juego(Mazo mazo, Jugador jugador1, Jugador jugador2) {
        this.mazo = mazo;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mazoPocima = new ArrayList<>();
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public ArrayList<Pocima> getMazoPocima() {
        return mazoPocima;
    }

    public void setMazoPocima(ArrayList<Pocima> mazoPocima) {
        this.mazoPocima = mazoPocima;
    }

    public void addPocima(Pocima pocima){
        this.mazoPocima.add(pocima);
    }

    public void repartirCartas() {
        ArrayList<Carta> mazoJugador1 = new ArrayList<>();
        ArrayList<Carta> mazoJugador2 = new ArrayList<>();
        mazo.mezclarCartas();

        if (mazo.cartasPar()) {
            for (int i=0; i<(mazo.cantCartas())/2; i++) {
                Carta carta = mazo.getCartas().get(i);
                mazoJugador1.add(carta);
                if (!mazoPocima.isEmpty()){
                    repartirPocimas(carta);
                }
            }

            for (int i=((mazo.cantCartas())/2); i<(mazo.cantCartas()); i++) {
                Carta carta = mazo.getCartas().get(i);
                mazoJugador2.add(carta);
                if (!mazoPocima.isEmpty()) {
                    repartirPocimas(carta);
                }
            }
        }

        else {
            for (int i = 0; i <= (mazo.cantCartas())/2; i++) {
                Carta carta = mazo.getCartas().get(i);
                mazoJugador1.add(carta);
                if (!mazoPocima.isEmpty()) {
                    repartirPocimas(carta);
                }
            }

            for (int i=((mazo.cantCartas())/2)+1; i<(mazo.cantCartas()); i++) {
                Carta carta = mazo.getCartas().get(i);
                mazoJugador2.add(carta);
                if (!mazoPocima.isEmpty()) {
                    repartirPocimas(carta);
                }
            }
        }
        jugador1.setMazoJugador(mazoJugador1);
        jugador2.setMazoJugador(mazoJugador2);
    }

    private boolean pocimaAsociada(Carta carta){
        for (Pocima pocima : mazoPocima){
            if (carta.getNombre().equals(pocima.getNombreCarta())){
                System.out.println("Hola Gonza");
                return true;
            }
        }
        System.out.println("HOLA BEBE");
        return false;
    }

    private void repartirPocimas(Carta carta){
        Collections.shuffle(mazoPocima);
        for (Pocima pocima : mazoPocima){
            if (pocimaAsociada(carta)){
                break;
            }
            else {
                if (!pocima.getNombreCarta().equals(" ")) {
                    break;
                }
                if (pocima instanceof PocimaCocktail) {
                    pocima.setNombreCarta(carta.getNombre());
                    ((PocimaCocktail) pocima).setNombrePocima(carta.getNombre());
                    System.out.println("Hola Cora, es una pocima Cocktail " + pocima.getNombre() + " " + carta.getNombre());
                }
                else {
                    pocima.setNombreCarta(carta.getNombre());
                    System.out.println("Hola Bambi, es una pocima normal " + pocima.getNombre() + " " + carta.getNombre());
                }
            }
        }
    }

    public Pocima getPocimaAsociada(Carta carta){  // getPocimaAsociada usado en las rondas para buscar pocima asociada a la carta jugada
        String nombreCarta = carta.getNombre();
        for (Pocima pocima : mazoPocima){
            if (pocima.getNombreCarta().equals(nombreCarta)){
                return pocima;
            }
        }
        return null;
    }

    public Double getValorAtribActual(Jugador jugador, String atributo) {
        return jugador.mazoJugador.get(0).getValorAtributo(atributo);
    }

    public void moverCartas(String situacionRonda) {
        Carta cartaJugador1 = jugador1.mazoJugador.get(0);
        Carta cartaJugador2 = jugador2.mazoJugador.get(0);
        switch (situacionRonda){
            case "jugador1":
                    jugador1.mazoJugador.remove(cartaJugador1);
                    jugador1.mazoJugador.add(cartaJugador1);
                    jugador2.mazoJugador.remove(cartaJugador2);
                    jugador1.mazoJugador.add(cartaJugador2);
                    break;
            case "jugador2":
                    jugador2.mazoJugador.remove(cartaJugador2);
                    jugador2.mazoJugador.add(cartaJugador2);
                    jugador1.mazoJugador.remove(cartaJugador1);
                    jugador2.mazoJugador.add(cartaJugador1);
                    break;
            case "empate":
                    jugador1.mazoJugador.remove(cartaJugador1);
                    jugador1.mazoJugador.add(cartaJugador1);
                    jugador2.mazoJugador.remove(cartaJugador2);
                    jugador2.mazoJugador.add(cartaJugador2);
                    break;
        }
    }

    public void rondas(int maxRondas, int numRonda) {
        String jugadorMano = "jugador1";
        System.out.println(jugadorMano);
        String nombreJugadorMano = "";
        String atributoActual = "";
        String situacionRonda = "";

        while ((numRonda <= maxRondas) && !(jugador1.getMazoJugador().isEmpty()) && !(jugador2.getMazoJugador().isEmpty()) ) {
            Carta cartaJug1 = jugador1.getMazoJugador().get(0);
            Carta cartaJug2 = jugador2.getMazoJugador().get(0);
            Pocima pocimaJug1 = getPocimaAsociada(cartaJug1);
            Pocima pocimaJug2 = getPocimaAsociada(cartaJug2);

            System.out.println("POC JUG 111" + pocimaJug1);
            System.out.println("POC JUG 222" + pocimaJug2);

            if (jugadorMano.equals("jugador1")) {
                nombreJugadorMano = jugador1.getNombreJugador();
                atributoActual = jugador1.elegirAtributo(cartaJug1);
            } else {
                nombreJugadorMano = jugador2.getNombreJugador();
                atributoActual = jugador2.elegirAtributo(cartaJug2);
            }
            //COMIENZAN LAS RONDAS
            System.out.println("------- Ronda " + numRonda + " -------");
            System.out.println("El jugador " + nombreJugadorMano + " selecciona competir por el atributo " + atributoActual);
            System.out.print("La carta de " + jugador1.getNombreJugador() + " es " + cartaJug1.getNombre() + " con " + atributoActual + " " + getValorAtribActual(jugador1, atributoActual));
            if (pocimaJug1 != null) {
                System.out.print(", se aplicó pócima " + pocimaJug1.getNombre() + " valor resultante " + pocimaJug1.efectoPocima(cartaJug1).getValorAtributo(atributoActual));
            }
            System.out.println("  ");
            System.out.print("La carta de " + jugador2.getNombreJugador() + " es " + cartaJug2.getNombre() + " con " + atributoActual + " " + getValorAtribActual(jugador2, atributoActual));
            if (pocimaJug2 != null) {
                System.out.print(", se aplicó pócima " + pocimaJug2.getNombre() + " valor resultante " + pocimaJug2.efectoPocima(cartaJug2).getValorAtributo(atributoActual));
            }
            System.out.println("  ");
            if (getValorAtribActual(jugador1, atributoActual) > getValorAtribActual(jugador2, atributoActual)) {
                System.out.println("Gana la ronda " + jugador1.getNombreJugador() + ".");
                situacionRonda = "jugador1";
                moverCartas(situacionRonda);
                System.out.println(jugador1.getNombreJugador() + " posee ahora " + jugador1.getMazoJugador().size() + " cartas y " + jugador2.getNombreJugador() + " posee ahora " + jugador2.getMazoJugador().size() + " cartas");
                jugadorMano = "jugador1";
                System.out.println(jugadorMano);
            } else {
                if (getValorAtribActual(jugador2, atributoActual) > getValorAtribActual(jugador1, atributoActual)) {
                    System.out.println("Gana la ronda " + jugador2.getNombreJugador() + ".");
                    situacionRonda = "jugador2";
                    moverCartas(situacionRonda);
                    System.out.println(jugador1.getNombreJugador() + " posee ahora " + jugador1.getMazoJugador().size() + " cartas y " + jugador2.getNombreJugador() + " posee ahora " + jugador2.getMazoJugador().size() + " cartas");
                    jugadorMano = "jugador2";
                    System.out.println(jugadorMano);
                } else {
                    System.out.println("Los valores son iguales, se empata la ronda.");
                    situacionRonda = "empate";
                    moverCartas(situacionRonda);
                    System.out.println(jugador1.getNombreJugador() + " posee ahora " + jugador1.getMazoJugador().size() + " cartas y " + jugador2.getNombreJugador() + " posee ahora " + jugador2.getMazoJugador().size() + " cartas");
                }
            }
            numRonda++;
        }
    }

    public void jugarRondas(int maxRondas) {
        int numRonda = 1;
        rondas(maxRondas,numRonda);
        if (jugador2.mazoJugador.isEmpty()){
            System.out.println("Se terminó el juego. Ha ganado "+jugador1.getNombreJugador());
        }
        if (jugador1.mazoJugador.isEmpty()) {
            System.out.println("Se terminó el juego. Ha ganado " + jugador2.getNombreJugador());
        }
        else {
            if (numRonda>=maxRondas){
                if (jugador1.getMazoJugador().size() > jugador2.getMazoJugador().size()){
                    System.out.println("Se terminó el juego, se alcanzó el número máximo de rondas. Ha ganado "+jugador1.getNombreJugador());
                }
                else {
                    System.out.println("Se terminó el juego, se alcanzó el número máximo de rondas. Ha ganado "+jugador2.getNombreJugador());
                }
                if (jugador1.getMazoJugador().size() == jugador2.getMazoJugador().size()){
                    System.out.println("Se terminó el juego, se alcanzó el número máximo de rondas. Hay empate.");
                }
            }
        }

    }

    public void comenzarJuego(int maxRondas){
        mazo.verificarCartas();
        repartirCartas();

        jugarRondas(maxRondas);
    }

}
