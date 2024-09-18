package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MenuPrincipall extends JFrame {

    private JButton jugarButton;
    private JButton creditosButton;
    private JButton salirButton;
    private JButton cargarButton;
    private JLabel logo;
    private JLabel nombreSokoban;
    private JPanel PanelPrincipal;

    public MenuPrincipall() {
        setTitle("Sokoban");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear un JPanel personalizado para dibujar la imagen
        PanelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Cargar y dibujar la imagen
                URL resourceUrl = getClass().getResource("/Imagenes/fondoMenuPrincipal.png");
                if (resourceUrl != null) {
                    ImageIcon imagen = new ImageIcon(resourceUrl);
                    g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Resource not found: /Imagenes/fondoMenuPrincipal.png");
                }
            }
        };

        PanelPrincipal.setLayout(null);

        setContentPane(PanelPrincipal);

        // Inicializar los componentes
        nombreSokoban = new JLabel("Bienvenido a SOKOBAN");
        logo = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/images.png")));
        jugarButton = new JButton("Jugar");
        cargarButton = new JButton("Cargar");
        creditosButton = new JButton("Créditos");
        salirButton = new JButton("Salir");

        // Configurar el logo
        logo.setBounds(150, 60, 200, 140);
        PanelPrincipal.add(logo);

        // Configurar el nombre del juego
        nombreSokoban.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
        nombreSokoban.setForeground(Color.WHITE);
        nombreSokoban.setBounds(100, 20, 300, 30);
        PanelPrincipal.add(nombreSokoban);

        // Configurar los botones
        jugarButton.setBounds(150, 260, 200, 40);
        cargarButton.setBounds(150, 320, 200, 40);
        creditosButton.setBounds(150, 380, 200, 40);
        salirButton.setBounds(150, 440, 200, 40);

        // Añadir los botones al panel
        PanelPrincipal.add(jugarButton);
        PanelPrincipal.add(cargarButton);
        PanelPrincipal.add(creditosButton);
        PanelPrincipal.add(salirButton);

        // Configurar la ventana
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Añadir acciones a los botones
        jugarButton.addActionListener(e -> {
            JFrameNiveles menuNiveles = new JFrameNiveles();
            dispose();
        });

        creditosButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Joel Delgado" + "\nDonoban Ramón" + "\nJuan Rengifo" + "\nDylan Granizo"));

        salirButton.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipall::new);
    }
}
