package trabs.trab3;

public abstract class Car {
    private final String name;
    private int x;
    private double vel;
    private double acc;

    public Car(String name, int init_x,double vel, double acc){
        this.name = name;
        this.x = init_x;
        this.vel = vel;
        this.acc = acc;
    }

    public void move(){
        vel += acc;
        x += vel;
    }

    public void reset(int x){
        this.x = x;
        vel = 0;
        acc = 0;
    }

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    public double getVel() {return vel;}
    public void setVel(double vel) {this.vel = vel;}
    public void addVel(double n){this.vel += n;}

    public double getAcc() {return acc;}
    public void setAcc(double acc) {this.acc = acc;}

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
