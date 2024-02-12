package juegoDeCartasTPE;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Juego {
    protected Mazo mazo;
    protected Jugador jugador1, jugador2;

    public Juego(Mazo mazo, Jugador jugador1, Jugador jugador2) {
        this.mazo = mazo;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
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

    public void repartirCartas() {
        ArrayList<Carta> mazoJugador1 = new ArrayList<>();
        ArrayList<Carta> mazoJugador2 = new ArrayList<>();

        if (mazo.cartasPar()) {
            for (int i=0; i<(mazo.cantCartas())/2; i++) {
                mazoJugador1.add(mazo.getCartas().get(i));
            }
            for (int i=((mazo.cantCartas())/2); i<(mazo.cantCartas()); i++) {
                mazoJugador2.add(mazo.getCartas().get(i));
            }
        }

        else {
            for (int i = 0; i <= (mazo.cantCartas())/2; i++) {
                mazoJugador1.add(mazo.getCartas().get(i));
            }
            for (int i=((mazo.cantCartas())/2)+1; i<(mazo.cantCartas()); i++) {
                mazoJugador2.add(mazo.getCartas().get(i));
            }
        }
        jugador1.setMazoJugador(mazoJugador1);
        jugador2.setMazoJugador(mazoJugador2);
    }

    public String atributoAleatorio() {
        Set<String> nombresAtributos = mazo.cartas.get(0).getAtributos().keySet();
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

    public void rondas(String atributoActual, String situacionRonda, String mano, int numRonda) {
        String jugadorMano = mano;
        String nombreJugadorMano = "";

        if (jugadorMano.equals("jugador1")){
            nombreJugadorMano = jugador1.getNombreJugador();
        }
        else {
            nombreJugadorMano = jugador2.getNombreJugador();
        }
        //COMIENZAN LAS RONDAS
        System.out.println("------- Ronda "+ numRonda +" -------");
        atributoActual = atributoAleatorio();
        System.out.println("El jugador "+ nombreJugadorMano +" selecciona competir por el atributo "+ atributoActual);
        System.out.println("La carta de "+ jugador1.getNombreJugador() +" es "+ jugador1.mazoJugador.get(0).getNombre() +" con "+ atributoActual +" "+ getValorAtribActual(jugador1,atributoActual));
        System.out.println("La carta de "+ jugador2.getNombreJugador() +" es "+ jugador2.mazoJugador.get(0).getNombre() +" con "+ atributoActual +" "+getValorAtribActual(jugador2,atributoActual));
        if (getValorAtribActual(jugador1,atributoActual) > getValorAtribActual(jugador2,atributoActual)){
            System.out.println("Gana la ronda "+ jugador1.getNombreJugador() +".");
            situacionRonda = "jugador1";
            moverCartas(situacionRonda);
            System.out.println(jugador1.getNombreJugador() + " posee ahora " +jugador1.mazoJugador.size()+ " cartas y " +jugador2.getNombreJugador()+ " posee ahora " +jugador2.mazoJugador.size()+ " cartas");
            mano = "jugador1";
        }
        else {
            if (getValorAtribActual(jugador2,atributoActual) > getValorAtribActual(jugador1,atributoActual)){
                System.out.println("Gana la ronda "+ jugador2.getNombreJugador() +".");
                situacionRonda = "jugador2";
                moverCartas(situacionRonda);
                System.out.println(jugador1.getNombreJugador() + " posee ahora " +jugador1.mazoJugador.size()+ " cartas y " +jugador2.getNombreJugador()+ " posee ahora " +jugador2.mazoJugador.size()+ " cartas");
                mano = "jugador2";
            }
            else {
                System.out.println("Los valores son iguales, se empata la ronda.");
                situacionRonda = "empate";
                moverCartas(situacionRonda);
                System.out.println(jugador1.getNombreJugador() + " posee ahora " +jugador1.mazoJugador.size()+ " cartas y " +jugador2.getNombreJugador()+ " posee ahora " +jugador2.mazoJugador.size()+ " cartas");
            }
        }
    }

    public void jugarRondas(int maxRondas) {
        int numRonda = 1;
        String atributoActual = "";
        String situacionRonda = "";
        String mano = "jugador1";
        while ((numRonda <= maxRondas) && !(jugador1.mazoJugador.isEmpty()) && !(jugador2.mazoJugador.isEmpty()) ) {
            rondas(atributoActual,situacionRonda,mano,numRonda);
            numRonda ++;
        }
        if (jugador2.mazoJugador.isEmpty()){
            System.out.println("Se terminó el juego. Ha ganado "+jugador1.getNombreJugador());
        }
        if (jugador1.mazoJugador.isEmpty()) {
            System.out.println("Se terminó el juego. Ha ganado " + jugador2.getNombreJugador());
        }
        else {
            if (numRonda>=maxRondas){
                if (jugador1.mazoJugador.size() > jugador2.mazoJugador.size()){
                    System.out.println("Se terminó el juego, se alcanzó el número máximo de rondas. Ha ganado "+jugador1.getNombreJugador());
                }
                else {
                    System.out.println("Se terminó el juego, se alcanzó el número máximo de rondas. Ha ganado "+jugador2.getNombreJugador());
                }
                if (jugador1.mazoJugador.size() == jugador2.mazoJugador.size()){
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
