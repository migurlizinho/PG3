package trabs.trab3;

import java.util.Random;

public class Robot extends Car{
    private final Random r;
    public Robot(String name) {
        super(name,0, 0);
        r = new Random(System.currentTimeMillis());
    }
    @Override
    public void move() {
        super.move();
        if ((r.nextInt(2) == 1)) {
            addVel(4);
        } else {
            setVel(0);
        }
    }
}
