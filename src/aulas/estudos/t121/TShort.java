package aulas.estudos.t121;

import java.util.function.Predicate;

public class TShort extends Transaction{
    public final TCompensation compensation;

    protected TShort(String name, TCompensation compensation) {
        super(name);
        this.compensation = compensation;
    }

    protected TShort(String name, String compensationName) {
        super(name);
        this.compensation = new TCompensation(compensationName);
    }

    @Override
    public boolean isCompensable() {
        return true;
    }

    @Override
    public String compesationToString() {
        return compensation.getDescription("");
    }

    @Override
    public String getDescription(String prefix) {
        return super.getDescription(prefix) + compensation.getDescription(prefix);
    }

    public boolean find(Predicate<String> predicate){
        return predicate.test(getName()) || predicate.test(compensation.getName());
    }
}
