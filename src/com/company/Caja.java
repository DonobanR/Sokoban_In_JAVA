package com.company;

public class Caja extends Bloque {

    protected boolean llegoAlPuntoDeLlegada;

    public Caja() {
        this.esTangible = false;
        this.direcciónEnArchivo = getClass().getResource("/Imagenes/caja.png");
        this.llegoAlPuntoDeLlegada = false;
    }

    public boolean getLlegoAlPuntoDeLlegada() {
        return llegoAlPuntoDeLlegada;
    }

    public boolean setLlegoAlPuntoDeLlegada(boolean nuevoLlegoAlPuntoDeLlegada) {
        this.llegoAlPuntoDeLlegada = nuevoLlegoAlPuntoDeLlegada;
        System.out.println("\nSet LLEGO " + nuevoLlegoAlPuntoDeLlegada + "\n");
        // Devolver el valor actualizado
        return this.llegoAlPuntoDeLlegada;
    }



}