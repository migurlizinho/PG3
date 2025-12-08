package trabs.trab3;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private final int FPS = 60;
    private final Race race;
    private final Timer timer;
    public Gui(){
        setSize(1000,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();

        race = new Race();

        JPanel topPanel = new JPanel(new FlowLayout());
        content.add(topPanel, BorderLayout.NORTH);
        JButton b1 = new JButton("a");
        topPanel.add(b1);

        JPanel racePanel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int w = getWidth();
                int h = getHeight();
                g.drawLine(0, h/4, w, h/4);
                g.drawLine(0, 2*h/4, w, 2*h/4);
                g.drawLine(0, 3*h/4, w, 3*h/4);

                race.car1.getX();
            }
        };
        content.add(racePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        content.add(bottomPanel, BorderLayout.SOUTH);
        JButton b2 = new JButton("a");
        bottomPanel.add(b2);

        timer = new Timer(1000/FPS, e -> {
            //Update Logic
            race.updateCars();
            //Display/Paint
            racePanel.repaint();
        });
    }
}
