package trabs.trab1.grupo2;

public class Proof implements Type{
    private final String name;
    private final int minimum;

    public Proof(String name, int minimum){
        this.name = name;
        this.minimum = minimum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMinimum() {
        return minimum;
    }
}
