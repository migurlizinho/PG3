package aulas.classes.GUIs;

import javax.swing.*;

public class FirstWindow extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public FirstWindow() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        JLabel myLabel =
                new JLabel("Please don't click that button!");
        getContentPane().add(myLabel);
    }
}