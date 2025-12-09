package trabs.trab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Gui extends JFrame {
    private final int FPS = 60;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final Race race;
    private final Timer timer;
    private int starting_line;
    private int finnish_line;

    private int first_line;
    private int second_line;
    private int third_line;

    public Gui(){
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();

        race = new Race(starting_line, finnish_line);

        starting_line = (int) (0.1*WINDOW_WIDTH);
        finnish_line = (int) (0.9*WINDOW_WIDTH);

        first_line = getHeight()/4;
        second_line = 2*getHeight()/4;
        third_line = 3*getHeight()/4;

        JPanel topPanel = new JPanel(new FlowLayout());
        content.add(topPanel, BorderLayout.NORTH);
        JButton b1 = new JButton("a");
        topPanel.add(b1);

        JPanel racePanel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int w = getWidth();
                g.setColor(Color.BLACK);
                g.drawLine(0, first_line, w, first_line);
                g.drawLine(0, second_line, w, second_line);
                g.drawLine(0, third_line, w, third_line);

                g.setColor(Color.RED);
                g.drawLine(starting_line, first_line - 20, starting_line,third_line + 20);
                g.drawLine(finnish_line, first_line - 20, finnish_line,third_line + 20);

                g.setColor(Color.BLUE);
                g.drawString(race.car1.toString(), 0, first_line);
                g.fillOval( starting_line + race.car1.getX(), first_line - 10, 20,20);

                g.setColor(Color.ORANGE);
                g.drawString(race.car2.toString(), 0, second_line);
                g.fillOval(starting_line + race.car2.getX(), second_line - 10, 20,20);

                g.setColor(Color.GREEN);
                g.drawString(race.car3.toString(), 0, third_line);
                g.fillOval( starting_line + race.car3.getX(), third_line - 10, 20,20);
            }
        };
        content.add(racePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        content.add(bottomPanel, BorderLayout.SOUTH);
        JButton b2 = new JButton("Pause/Resume");
        b2.addActionListener(a -> pauseResume());
        bottomPanel.add(b2);

        timer = new Timer(1000/FPS, e -> {
            //Update Logic
            race.updateCars();
            //Check Game State
            if(race.getGameState() != Race.GameState.ONGOING){
                pauseResume();
            }
            //Display/Paint
            racePanel.repaint();
        });
        timer.start();
    }

    public void pauseResume(){
        if(timer.isRunning()){
            timer.stop();
        }else{
            timer.start();
            race.startRace();
        }
    }
}
