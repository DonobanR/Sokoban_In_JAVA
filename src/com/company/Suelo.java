package com.company;

public class Suelo extends Bloque {

    public Suelo() {

        esTangible = true;
        direcciónEnArchivo = getClass().getResource("/Imagenes/sueloHierba.png");
    }
}
