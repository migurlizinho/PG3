package trabs.trab1.grupo3;

public class Var extends Elem{
    private final String name;

    public Var(String name, int value) {
        super(value);
        this.name = name;
    }

    public int setValue(int value){
        int old = this.value;
        this.value = value;
        return old;
    }

    @Override
    public String toString() {
        return name;
    }
}
