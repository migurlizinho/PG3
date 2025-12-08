package trabs.trab3;

public class Crawler extends Car{
    public Crawler(String name) {
        super(name,7, 0);
    }
    @Override
    public void reset() {
        super.reset();
        setVel(7);
    }
}
