package com.company;

import Interfaces.VentanaDeJuego;

import java.net.URL;

public abstract class Bloque {
    protected URL direcciónEnArchivo;
    protected boolean esTangible;
    //protected VentanaDeJuego ventanaDeJuego;

    public URL getDirecciónEnArchivo() {
        return direcciónEnArchivo;
    }

}
