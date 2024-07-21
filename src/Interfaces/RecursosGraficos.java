package Interfaces;

import com.company.Nivel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class RecursosGraficos extends JPanel {
    private final URL imagenDeFondo;
    private Nivel nivel;
    private int x;

    public RecursosGraficos(Nivel nivel) {
        x = nivel.getEscenario().getMatrízDeObjetos().length;

        System.out.println(x);
        this.nivel = nivel;
        setVisible(true);
        imagenDeFondo = getClass().getResource("/Imagenes/sueloHierba.png");

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        pintarFondo(gr);
        pintarElEscenario(gr);
        pintarPersonaje(gr);
        repaint(100);
    }

    private void pintarFondo(Graphics2D gr) {
        ImageIcon fondo = new ImageIcon(imagenDeFondo);
        gr.drawImage(fondo.getImage(), 0, 0, 600, 600, null);
    }

    public void pintarPersonaje(Graphics2D grafico){
        ImageIcon personaje = new ImageIcon(nivel.getPersonaje().getDirecciónEnArchivo());
        grafico.drawImage(personaje.getImage(), nivel.getPersonaje().getPosicionPersonajeEnX(), nivel.getPersonaje().getPosicionPersonajeEnY(), 60, 60, null);
    }


    public void pintarBloqueIndividual(Graphics2D grafico, int fila, int columna){
        ImageIcon bloque = new ImageIcon(nivel.getEscenario().getMatrízDeObjetos()[fila][columna].getDirecciónEnArchivo());
        grafico.drawImage(bloque.getImage(), (columna)*60, (fila)*60, 60, 60, null);
    }

    public void pintarElEscenario(Graphics2D grafico){
        for(int i = 0; i < nivel.getEscenario().getMatrízDeObjetos().length; i++){
            for (int j = 0; j < nivel.getEscenario().getMatrízDeObjetos()[0].length; j++){
                pintarBloqueIndividual(grafico, i, j);
            }
        }
    }


}
