package adiviannumeroventanas;

import javax.swing.*;
import java.awt.*;

public class BarraColores extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Definimos los colores del espectro
        Color[] colores = {
            Color.RED, Color.ORANGE, Color.YELLOW, 
            Color.GREEN, Color.BLUE
        };
        
        // Definimos las posiciones (de 0.0 a 1.0)
        float[] posiciones = {0.0f, 0.15f, 0.33f, 0.5f, 0.66f};

        // Creamos el gradiente que llena todo el ancho del panel
        LinearGradientPaint gp = new LinearGradientPaint(
            0, 0, getWidth(), 0, posiciones, colores
        );

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Espectro de Colores");
//        BarraColores barra = new BarraColores();
//        barra.setPreferredSize(new Dimension(400, 30));
//        
//        frame.add(barra, BorderLayout.CENTER);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
