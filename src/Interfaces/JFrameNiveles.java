package Interfaces;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameNiveles extends JFrame {
    private VentanaDeJuego ventanaDeSokoban;
    private JButton nivel3Button;
    private JButton nivel1Button;
    private JButton nivel2Button;
    private JPanel JPanelNiveles;
    private JButton regresarButton;

    public JFrameNiveles() {
        ventanaDeSokoban = new VentanaDeJuego();
        setTitle("Sokoban - Niveles");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setContentPane(JPanelNiveles);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        regresarButton.addActionListener(e -> {
            MenuPrincipall menuPrincipal = new MenuPrincipall();
            dispose();
        });

        nivel1Button.addActionListener(e -> {
            ventanaDeSokoban.setNúmeroDeNivelDeJuego(0);
            System.out.println(ventanaDeSokoban.númeroDeNivelDeJuego);
            ventanaDeSokoban.crearVentana();
            dispose();
        });

        nivel2Button.addActionListener(e -> {
            ventanaDeSokoban.setNúmeroDeNivelDeJuego(1);
            System.out.println("Nivel seleccionado: " + ventanaDeSokoban.númeroDeNivelDeJuego);
            ventanaDeSokoban.crearVentana();
            dispose();
        });

        nivel3Button.addActionListener(e -> {
            ventanaDeSokoban.setNúmeroDeNivelDeJuego(2);
            System.out.println("Nivel seleccionado: " + ventanaDeSokoban.númeroDeNivelDeJuego);
            ventanaDeSokoban.crearVentana();
            dispose();
        });
    }
}
