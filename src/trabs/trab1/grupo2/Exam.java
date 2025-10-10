package trabs.trab1.grupo2;

public class Exam implements Type{
    private final String name;

    public Exam(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMinimum() {
        return 10;
    }
}
