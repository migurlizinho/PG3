package trabs.trab3;

public class Sprinter extends Car{
    public Sprinter(String name) {
        super(name,0, 4);
    }

    @Override
    public void reset() {
        super.reset();
        setAcc(4);
    }

    @Override
    public void move() {
        super.move();
        if(getVel() > 8)
            setVel(2);
    }
}