package trabs.trab3.model;

import java.util.Random;

public class Robot extends RacerClass {
    private static final Random rand = new Random(System.currentTimeMillis());
    public Robot(String name) {
        super(name,0, 0,"󰞬");
    }
    @Override
    public void walk() {
        super.walk();
        if ((rand.nextInt(2) == 1)) {
            addVel(6);
        } else {
            setVel(1);
        }
    }
}