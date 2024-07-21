package com.company;

public class Pared extends Bloque {

    public Pared() {

        esTangible = false;
        direcciónEnArchivo = getClass().getResource("/Imagenes/paredDeRoca.png");
    }

}
