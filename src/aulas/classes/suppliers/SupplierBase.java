package aulas.classes.suppliers;

public abstract class SupplierBase implements Supplier{
    private final String name;

    public SupplierBase(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription(String prefix) {
        return prefix + name;
    }

    @Override
    public String toString() {
        return getDescription("");
    }
}
