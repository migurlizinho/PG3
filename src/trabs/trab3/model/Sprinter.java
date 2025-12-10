package trabs.trab3.model;

import java.util.Random;

public class Sprinter extends RacerClass {
    private static final double ACC_MIN = 0.1;
    private static final double ACC_MAX = 0.4;
    private static final double MAX_VEL = 17;
    private static final Random rand = new Random(System.currentTimeMillis());
    public Sprinter(String name) {
        super(name,0, rand.nextDouble(ACC_MIN,ACC_MAX), "󰚩");
    }

    @Override
    public void reset() {
        super.reset();
        setAcc(rand.nextDouble(ACC_MIN,ACC_MAX));
    }

    @Override
    public void walk() {
        super.walk();
        if(getVel() > MAX_VEL){
            addVel(-5);
            addAcc(-0.2);
        }
    }
}