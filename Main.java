package juegoDeCartasTPE;

public class Main {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Mario");
        Jugador jugador2 = new Jugador("Luigi");
        Carta carta1 = new Carta("Superman");
        carta1.addAtributos("Altura",2.05);
        carta1.addAtributos("Peso",110.0);
        carta1.addAtributos("Fuerza",2000.0);    //500 y 400
        carta1.addAtributos("Peleas Ganadas",990.0);
        carta1.addAtributos("Velocidad",400.0);
        Carta carta2 = new Carta("Deadpool");
        carta2.addAtributos("Altura",1.90);
        carta2.addAtributos("Peso",82.0);
        carta2.addAtributos("Fuerza",1750.0); //300 y 300
        carta2.addAtributos("Peleas Ganadas",870.0);
        carta2.addAtributos("Velocidad",300.0);
        Carta carta3 = new Carta("Wolverine");
        carta3.addAtributos("Altura",1.75);
        carta3.addAtributos("Peso",87.0);
        carta3.addAtributos("Fuerza",900.0);    //600 y 500
        carta3.addAtributos("Peleas Ganadas",500.0);
        carta3.addAtributos("Velocidad",500.0);
        Carta carta4 = new Carta("Goku");
        carta4.addAtributos("Altura",1.98);
        carta4.addAtributos("Peso",110.0);
        carta4.addAtributos("Fuerza",4000.0);    //900 y 900
        carta4.addAtributos("Peleas Ganadas",999.0);
        carta4.addAtributos("Velocidad",599.0);
        Carta carta5 = new Carta("Batman");
        carta5.addAtributos("Altura",2.0);
        carta5.addAtributos("Peso",10.0);
        carta5.addAtributos("Fuerza",1500.0);    //300 y 300
        carta5.addAtributos("Peleas Ganadas",830.0);
        carta5.addAtributos("Velocidad",300.0);
        Carta carta6 = new Carta("AntMan");
        carta6.addAtributos("Altura",4.85);
        carta6.addAtributos("Peso",348.0);
        carta6.addAtributos("Fuerza",350.0);    //900 y 900
        carta6.addAtributos("Peleas Ganadas",570.0);
        carta6.addAtributos("Velocidad",200.0);
        Carta carta7 = new Carta("Flash");
        carta7.addAtributos("Altura",1.95);
        carta7.addAtributos("Peso",84.0);
        carta7.addAtributos("Fuerza",300.0);    //300 y 600
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
        juego.comenzarJuego(10);

    }

}
