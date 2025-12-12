package aulas.estudos.t121;

public class TCompensation extends Transaction{
    public TCompensation(String name) {
        super(name);
    }

    @Override
    public boolean isCompensable() {
        return false;
    }

    @Override
    public String compesationToString() {
        throw new UnsupportedOperationException();
    }
}
