package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.awt.event.KeyEvent;
import java.net.URL;

public class Personaje {
    private int posicionPersonajeEnX;
    private int posicionPersonajeEnY;
    protected URL direcciónEnArchivo;
    private final int valorDePosicionDeBloque;

    public Personaje() {
        this.posicionPersonajeEnX = 120;
        this.posicionPersonajeEnY = 120;
        this.valorDePosicionDeBloque = 60;
        this.direcciónEnArchivo = getClass().getResource("/Imagenes/personaje.png");
    }

    public void moverPersonaje(KeyEvent evento) {

        if (evento.getKeyCode() == KeyEvent.VK_UP) {
            posicionPersonajeEnY = posicionPersonajeEnY - valorDePosicionDeBloque;
        }
        if (evento.getKeyCode() == KeyEvent.VK_DOWN) {
            posicionPersonajeEnY = posicionPersonajeEnY + valorDePosicionDeBloque;
        }
        if (evento.getKeyCode() == KeyEvent.VK_LEFT) {
            posicionPersonajeEnX = posicionPersonajeEnX - valorDePosicionDeBloque;
        }
        if (evento.getKeyCode() == KeyEvent.VK_RIGHT) {
            posicionPersonajeEnX = posicionPersonajeEnX + valorDePosicionDeBloque;
        }
    }


    public boolean podreMoverBloque(KeyEvent evento, Escenario escenario) {
        int difPersonajeBloqueEnX = posicionPersonajeEnX / valorDePosicionDeBloque;
        int difPersonajeBloqueEnY = posicionPersonajeEnY / valorDePosicionDeBloque;
        if (evento.getKeyCode() == KeyEvent.VK_UP) {
            if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX] instanceof Caja) {
                if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX].esTangible) {
                    return true;
                }
            }

        }

        if (evento.getKeyCode() == KeyEvent.VK_DOWN) {
            if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX] instanceof Caja) {
                if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX].esTangible) {
                    return true;
                }
            }

        }

        if (evento.getKeyCode() == KeyEvent.VK_LEFT) {
            if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1] instanceof Caja) {
                if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2].esTangible) {
                    return true;
                }
            }

        }

        if (evento.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1] instanceof Caja) {
                if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2].esTangible) {
                    return true;
                }
            }

        }
        return false;
    }


    public void moverBloque(KeyEvent evento, Escenario escenario) {
        int difPersonajeBloqueEnX = posicionPersonajeEnX / valorDePosicionDeBloque;
        int difPersonajeBloqueEnY = posicionPersonajeEnY / valorDePosicionDeBloque;

        //arriba
        if (evento.getKeyCode() == KeyEvent.VK_UP) {

            if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] instanceof PuntoDeLlegada & !((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX]).llegoAlPuntoDeLlegada) {
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX] = new Suelo();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] instanceof PuntoDeLlegada & ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX]).llegoAlPuntoDeLlegada) {

                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] = new Caja();
                ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] instanceof Suelo & (((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX]).llegoAlPuntoDeLlegada)) {

                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] = new Caja();
                ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX]).setLlegoAlPuntoDeLlegada(false);

            } else {
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX] = new Suelo();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 2][difPersonajeBloqueEnX] = new Caja();
            }
            System.out.println("Arriba" + posicionPersonajeEnY + " en X, " + posicionPersonajeEnX + " en Y");

        }
        //abajo
        if (evento.getKeyCode() == KeyEvent.VK_DOWN) {
            if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] instanceof PuntoDeLlegada & (!((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX] = new Suelo();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] instanceof PuntoDeLlegada & (((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] instanceof Suelo & (((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX]).setLlegoAlPuntoDeLlegada(false);

            } else {
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX] = new Suelo();
                escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 2][difPersonajeBloqueEnX] = new Caja();
            }
            System.out.println("Abajo" + posicionPersonajeEnY + " en X, " + posicionPersonajeEnX + " en Y");

        }
        //izquierda
        if (evento.getKeyCode() == KeyEvent.VK_LEFT) {

            if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2] instanceof PuntoDeLlegada & (!((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1] = new Suelo();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2] instanceof PuntoDeLlegada & (((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2] instanceof Suelo & (((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 2]).setLlegoAlPuntoDeLlegada(false);

            } else {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX)  - 1] = new Suelo();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX)  - 2] = new Caja();
            }
            System.out.println("Izquierda" + posicionPersonajeEnY + " en X, " + posicionPersonajeEnX + " en Y");

        }
        //derecho
        if (evento.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] instanceof PuntoDeLlegada & (!((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1] = new Suelo();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] instanceof PuntoDeLlegada & (((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2]).setLlegoAlPuntoDeLlegada(true);

            } else if (escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] instanceof Suelo & (((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1]).llegoAlPuntoDeLlegada)) {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1] = new PuntoDeLlegada();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] = new Caja();

                ((Caja) escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2]).setLlegoAlPuntoDeLlegada(false);

            } else {
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1] = new Suelo();
                escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 2] = new Caja();
            }
            System.out.println("Derecha" + posicionPersonajeEnY + " en X, " + posicionPersonajeEnX + " en Y");

        }

        escenario.acabarJuego();
        System.out.println("Numero de llegada: " + escenario.puntosDeLlegadaFinalizados());
    }


    public boolean puedeAvanzar(KeyEvent evento, Escenario escenario) {
        int difPersonajeBloqueEnX = posicionPersonajeEnX / valorDePosicionDeBloque;
        int difPersonajeBloqueEnY = posicionPersonajeEnY / valorDePosicionDeBloque;

        if (evento.getKeyCode() == KeyEvent.VK_UP & escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) - 1][difPersonajeBloqueEnX].esTangible) {
            return true;
        }

        if (evento.getKeyCode() == KeyEvent.VK_DOWN & escenario.getMatrízDeObjetos()[(difPersonajeBloqueEnY) + 1][difPersonajeBloqueEnX].esTangible) {
            return true;
        }

        if (evento.getKeyCode() == KeyEvent.VK_LEFT & escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) - 1].esTangible) {
            return true;
        }

        if (evento.getKeyCode() == KeyEvent.VK_RIGHT & escenario.getMatrízDeObjetos()[difPersonajeBloqueEnY][(difPersonajeBloqueEnX) + 1].esTangible) {
            return true;
        }
        return false;
    }
    public void interaccion(KeyEvent evento, Escenario escenario) {
        if (puedeAvanzar(evento, escenario)) {
            moverPersonaje(evento);
        } else if (podreMoverBloque(evento, escenario)) {
            moverBloque(evento, escenario);
            moverPersonaje(evento);
        }
    }

    public URL getDirecciónEnArchivo() {
        return direcciónEnArchivo;
    }

    public int getPosicionPersonajeEnX() {
        return posicionPersonajeEnX;
    }

    public int getPosicionPersonajeEnY() {
        return posicionPersonajeEnY;
    }

}

