package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JFrameNiveles extends JFrame {
    private VentanaDeJuego ventanaDeSokoban;
    private JButton nivel1Button;
    private JButton nivel2Button;
    private JButton nivel3Button;
    private JButton nivel4Button;
    private JButton nivel5Button;
    private JButton nivel6Button;
    private JButton regresarButton;
    private JLabel nombreNiveles;
    private JPanel JPanelNiveles;

    public JFrameNiveles() {
        ventanaDeSokoban = new VentanaDeJuego();
        setTitle("Sokoban - Niveles");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear el JPanel con un fondo personalizado
        JPanelNiveles = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                URL resourceUrl = getClass().getResource("/Imagenes/fondoNiveles.png");
                if (resourceUrl != null) {
                    ImageIcon imagen = new ImageIcon(resourceUrl);
                    g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Resource not found: /Imagenes/fondoNiveles.png");
                }
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margen entre los componentes

        // Inicializar y configurar los componentes
        nombreNiveles = new JLabel("NIVELES");
        configureLabel(nombreNiveles);

        nivel1Button = createLevelButton("Nivel 1", 0);
        nivel2Button = createLevelButton("Nivel 2", 1);
        nivel3Button = createLevelButton("Nivel 3", 2);
        nivel4Button = createLevelButton("NIVEL 4", 3);
        nivel5Button = createLevelButton("NIVEL 5", 4);
        nivel6Button = createLevelButton("NIVEL 6", 5);
        regresarButton = createRegresarButton();

        // Añadir los componentes al JPanelNiveles con GridBagConstraints
        posicionesNivelesButtom(gbc);

        // Establecer el panel como el contenido del JFrame
        setContentPane(JPanelNiveles);
        setVisible(true);
    }

    private void posicionesNivelesButtom(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanelNiveles.add(nombreNiveles, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanelNiveles.add(nivel1Button, gbc);

        gbc.gridx = 1;
        JPanelNiveles.add(nivel2Button, gbc);

        gbc.gridx = 2;
        JPanelNiveles.add(nivel3Button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JPanelNiveles.add(nivel4Button, gbc);

        gbc.gridx = 1;
        JPanelNiveles.add(nivel5Button, gbc);

        gbc.gridx = 2;
        JPanelNiveles.add(nivel6Button, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JPanelNiveles.add(regresarButton, gbc);
    }

    private void configureLabel(JLabel label) {
        label.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
        label.setForeground(Color.WHITE);
        label.setOpaque(true); // Permite que se vea el color de fondo
        Color transparentBlack = new Color(0, 0, 0, 127); // Color negro con transparencia
        label.setBackground(transparentBlack); // Aplica el color de fondo
    }

    private JButton createLevelButton(String text, int level) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40));
        button.addActionListener(e -> {
            ventanaDeSokoban.setNúmeroDeNivelDeJuego(level);
            ventanaDeSokoban.crearVentana();
            dispose();
        });
        return button;
    }

    private JButton createRegresarButton() {
        JButton button = new JButton("Regresar");
        button.setPreferredSize(new Dimension(150, 40));
        button.addActionListener(e -> {
            MenuPrincipall menuPrincipal = new MenuPrincipall();
            dispose();
        });
        return button;
    }

}
