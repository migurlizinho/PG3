package trabs.trab3.model;

import java.util.Random;

public class Crawler extends RacerClass {
    private static final int VEL_MIN = 6;
    private static final int VEL_MAX = 11;
    private static final Random rand = new Random(System.currentTimeMillis());
    public Crawler(String name) {
        super(name,rand.nextDouble(VEL_MIN, VEL_MAX), 0, "󰞨");
    }
    @Override
    public void reset() {
        super.reset();
        setVel(rand.nextDouble(VEL_MIN, VEL_MAX));
    }
}
