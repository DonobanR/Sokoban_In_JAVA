package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipall extends JFrame {

    private JButton jugarButton;
    private JButton creditosButton;
    private JButton salirButton;
    private JPanel PanelPrincipal;
    private JButton cargarButton;

//    public void paint(Graphics g){
//        ImageIcon imagen = new ImageIcon(getClass().getResource("imagenes/fondo-1.png"));
//        g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
//
//    }

    public MenuPrincipall() {
        setTitle("Sokoban");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(PanelPrincipal);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameNiveles menuNiveles = new JFrameNiveles();
                dispose();
            }
        });

        creditosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Joel Delgado" + "\nDonoban Ramón" + "\nJuan Rengifo" + "\nDylan Granizo");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

//    public static void main(String[] args){
//        MenuPrincipal menuPrincipal = new MenuPrincipal();
//    }
}
