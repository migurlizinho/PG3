package trabs.trab3;

public abstract class Car {
    private final String name;
    private int x;
    private int vel;
    private int acc;

    public Car(String name, int vel, int acc){
        this.name = name;
        this.x = 0;
        this.vel = vel;
        this.acc = acc;
    }

    public void move(){
        vel += acc;
        x += vel;
    }

    public void reset(){
        x = 0;
        vel = 0;
        acc = 0;
    }

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    public int getVel() {return vel;}
    public void setVel(int vel) {this.vel = vel;}
    public void addVel(int n){this.vel += n;}

    public int getAcc() {return acc;}
    public void setAcc(int acc) {this.acc = acc;}

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
