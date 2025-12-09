package trabs.trab3;

public class Sprinter extends Car{
    private static final double STARTING_ACC = 0.5;
    public Sprinter(String name, int init_x) {
        super(name,init_x,0, STARTING_ACC);
    }

    @Override
    public void reset(int x) {
        super.reset(x);
        setAcc(STARTING_ACC);
    }

    @Override
    public void move() {
        super.move();
        if(getVel() > 15)
            setVel(2);
    }
}