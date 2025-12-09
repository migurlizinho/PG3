package trabs.trab3;

public class Crawler extends Car{
    private static final int STARTING_VEL = 7;
    public Crawler(String name, int init_x) {
        super(name,init_x,STARTING_VEL, 0);
    }
    @Override
    public void reset(int x) {
        super.reset(x);
        setVel(STARTING_VEL);
    }
}
