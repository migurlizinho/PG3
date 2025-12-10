package trabs.trab3.model;

public abstract class RacerClass implements Racer{
    private final String name;
    private int x;
    private double vel;
    private double acc;
    public final String icon;

    public RacerClass(String name, double vel, double acc, String icon){
        this.name = name;
        this.x = 0;
        this.vel = vel;
        this.acc = acc;
        this.icon = icon;
    }

    @Override
    public void walk() {
        vel += acc;
        x += vel;
    }

    @Override
    public void reset(){
        x = 0;
        vel = 0;
        acc = 0;
    }

    @Override
    public String getIdentifier() {
        return name;
    }

    @Override
    public int getPosition() {
        return x;
    }
    public void setX(int x) {this.x = x;}

    public double getVel() {return vel;}
    public void setVel(double vel) {this.vel = vel;}
    public void addVel(double n){this.vel += n;}

    public double getAcc() {return acc;}
    public void setAcc(double acc) {this.acc = acc;}
    public void addAcc(double n){this.acc += n;}
    public final String getName(){return this.name;}

    @Override
    public String toString() {
        return name + "{" +
                "x=" + x +
                ", vel=" + vel +
                ", acc=" + acc +
                '}';
    }
}
