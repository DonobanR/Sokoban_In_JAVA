package com.company;

public class Arbusto extends Caja {
    protected boolean llegoAlPuntoDeLlegada;
    public Arbusto() {
        esTangible = false;
        direcciónEnArchivo = getClass().getResource("/Imagenes/images.png");
    }
}
