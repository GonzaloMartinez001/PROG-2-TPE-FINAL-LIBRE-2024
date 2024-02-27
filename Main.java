package juegoDeCartasTPE;

import juegoDeCartasTPE.interfaz.EstrategiaAmbicioso;
import juegoDeCartasTPE.interfaz.EstrategiaJuego;
import juegoDeCartasTPE.interfaz.EstrategiaObstinado;
import juegoDeCartasTPE.interfaz.EstrategiaTimbero;
import juegoDeCartasTPE.pocimas.*;



public class Main {
    public static void main(String[] args) {
        EstrategiaJuego estrategiaObstinado = new EstrategiaObstinado("Velocidad");
        EstrategiaJuego estrategiaAmbicioso = new EstrategiaAmbicioso();

        Jugador jugador1 = new Jugador("Mario",estrategiaObstinado);
        Jugador jugador2 = new Jugador("Luigi",estrategiaAmbicioso);

        EstrategiaJuego estrategiaActual = jugador1.getEstrategiaJugador();
        jugador1.cambiarEstrategia(new EstrategiaTimbero());

        Pocima pocima1 = new PocimaFortalecedora("Pocima Fortalecedora"," ",1.2);
        Pocima pocima2 = new PocimaSelectivaFuerza("Pocima Selectiva Fuerza"," ",1.35);
        Pocima pocima3 = new PocimaKriptonita("Pocima Kriptonita"," ",0.75);
        Pocima pocima4 = new PocimaQuieroValeCuatro("Pocima Quiero Vale Cuatro"," ",4);
        PocimaCocktail pocima5 = new PocimaCocktail("Pocima Cocktail"," ");
        Pocima pocima6 = new PocimaSelectivaFuerza("Pocima Selectiva Fuerza"," ",1.35);
        Pocima pocima7 = new PocimaSelectivaPeso("Pocima Selectiva Peso"," ",1.43);
        Pocima pocima8 = new PocimaFortalecedora("Pocima Fortalecedora"," ",1.2);
        Pocima pocima9 = new PocimaFortalecedora("Pocima Fortalecedora", " ", 2.6);
        Pocima pocima10 = new PocimaSelectivaPeso("Pocima Selectiva Peso", " ", 2.56);
        Pocima pocima11 = new PocimaKriptonita("Pocima Kriptonita"," ",0.56);
        Pocima pocima12 = new PocimaNumeroMagico("Pocima Numero Magico"," ",23);
        Pocima pocima13 = new PocimaFortalecedoraPlus("Pocima Fortalecedora Plus"," ",1.8);
        Pocima pocima14 = new PocimaReductorDePlomo("Pocima Reductor Plomo"," ",0.45);

        Carta carta1 = new Carta("Superman");
        carta1.addAtributos("Altura",2.05);
        carta1.addAtributos("Peso",110.0);
        carta1.addAtributos("Fuerza",2000.0);
        carta1.addAtributos("Peleas Ganadas",990.0);
        carta1.addAtributos("Velocidad",400.0);
        Carta carta2 = new Carta("Deadpool");
        carta2.addAtributos("Altura",1.90);
        carta2.addAtributos("Peso",75.0);
        carta2.addAtributos("Fuerza",1750.0);
        carta2.addAtributos("Peleas Ganadas",870.0);
        carta2.addAtributos("Velocidad",300.0);
        Carta carta3 = new Carta("Wolverine");
        carta3.addAtributos("Altura",1.75);
        carta3.addAtributos("Peso",87.0);
        carta3.addAtributos("Fuerza",900.0);
        carta3.addAtributos("Peleas Ganadas",500.0);
        carta3.addAtributos("Velocidad",500.0);
        Carta carta4 = new Carta("Goku");
        carta4.addAtributos("Altura",1.98);
        carta4.addAtributos("Peso",82.0);
        carta4.addAtributos("Fuerza",4000.0);
        carta4.addAtributos("Peleas Ganadas",999.0);
        carta4.addAtributos("Velocidad",599.0);
        Carta carta5 = new Carta("Batman");
        carta5.addAtributos("Altura",2.0);
        carta5.addAtributos("Peso",79.0);
        carta5.addAtributos("Fuerza",1500.0);
        carta5.addAtributos("Peleas Ganadas",830.0);
        carta5.addAtributos("Velocidad",300.0);
        Carta carta6 = new Carta("AntMan");
        carta6.addAtributos("Altura",4.85);
        carta6.addAtributos("Peso",348.0);
        carta6.addAtributos("Fuerza",350.0);
        carta6.addAtributos("Peleas Ganadas",570.0);
        carta6.addAtributos("Velocidad",200.0);
        Carta carta7 = new Carta("Flash");
        carta7.addAtributos("Altura",1.95);
        carta7.addAtributos("Peso",84.0);
        carta7.addAtributos("Fuerza",300.0);
        carta7.addAtributos("Peleas Ganadas",900.0);
        carta7.addAtributos("Velocidad",600.0);

        Mazo mazo = new Mazo();
        mazo.addCartas(carta1);
        mazo.addCartas(carta2);
        mazo.addCartas(carta3);
        mazo.addCartas(carta4);
        mazo.addCartas(carta5);
        mazo.addCartas(carta6);
        mazo.addCartas(carta7);

        Juego juego = new Juego(mazo,jugador1,jugador2);
        juego.addPocima(pocima1);
        juego.addPocima(pocima2);
        juego.addPocima(pocima3);
        juego.addPocima(pocima4);
        pocima5.addPocima(pocima6);
        pocima5.addPocima(pocima7);
        pocima5.addPocima(pocima8);
        juego.addPocima(pocima5);
        juego.addPocima(pocima9);
        juego.addPocima(pocima10);
        juego.addPocima(pocima11);
        juego.addPocima(pocima12);
        juego.addPocima(pocima13);
        juego.addPocima(pocima14);

        juego.comenzarJuego(10);


    }

}
