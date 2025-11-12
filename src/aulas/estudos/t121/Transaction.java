package aulas.estudos.t121;

import java.util.function.Predicate;

public abstract class Transaction {
    private final String name;
    protected Transaction(String name){
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract boolean isCompensable();
    public abstract String compesationToString();

    public String getDescription(String prefix){
        return prefix + name;
    }

    public boolean find(Predicate<String> pred){ return pred.test(name); }

    public final String toString() { return name; }
}
