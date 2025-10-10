package aulas.classes.suppliers;

public class Product implements Comparable{
    private final String name;
    private double price;
    private Supplier supplier;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Product))
            return false;
        Product other = (Product) obj;
        return this.name.equals(other.getName()) &&
                this.price == other.price &&
                 this.supplier.equals(other.supplier);
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Product))
            return 0;
        Product other = (Product) o;
        return (int) (this.price - other.price);
    }

    @Override
    public String toString() {
        return name + " at " + "$" + price;
    }
}