package Interfaces;

import com.company.Nivel;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaDeJuego extends JFrame {

    private JPanel JPanelSokoban;
    private JButton reiniciarNivelButton;
    private JButton nivelesButton;
    private JPanel juego;
    private JButton guardarButton;
    private RecursosGraficos panelDeGraficos;
    private Nivel[] niveles;
    protected int númeroDeNivelDeJuego;

    public VentanaDeJuego() {
        setTitle("Sokoban");
        niveles = crearListaDeNiveles();
        System.out.println(númeroDeNivelDeJuego + " es lo que me van a poner");
        nivelesButton.addActionListener(e -> {
            JFrameNiveles niveles = new JFrameNiveles();
            dispose();
        });


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                for (Nivel nivel:niveles){
                    nivel.getPersonaje().interaccion(e, nivel.getEscenario());
                }

                if (niveles[númeroDeNivelDeJuego].getEscenario().acabarJuego()) {
                    JOptionPane.showMessageDialog(VentanaDeJuego.this, "¡Felicidades! Has completado el nivel.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }


    public void crearVentana() {
        this.setContentPane(JPanelSokoban);
        juego.removeAll();
        juego.add(new RecursosGraficos(niveles[númeroDeNivelDeJuego]));
        juego.revalidate();
        juego.repaint();
        this.setSize(620, 620);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void setNúmeroDeNivelDeJuego(int númeroDeNivelDeJuego) {
        this.númeroDeNivelDeJuego = númeroDeNivelDeJuego;
    }


    // Se pone nivel como objeto, por error en reconocer los arreglos

    public Nivel[] crearListaDeNiveles(){
        Nivel[] levels = new Nivel[6];
        for (int i = 0; i< levels.length; i++){
            levels[i] = new Nivel(i);
        }
        return levels;
    }
}
