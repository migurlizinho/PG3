package aulas.classes.suppliers;

public class Retailer extends SupplierBase{
    Supplier supplier;
    int totalProducts;

    public Retailer(String name) {
        super(name);
        totalProducts = 0;
    }

    @Override
    public Product[] getProducts() {
        return new Product[0];
    }

    @Override
    public int getNumberOfProducts() {
        return totalProducts;
    }

    @Override
    public Product find(String productName) {
        return null;
    }

    public Retailer append(Supplier supplier){
        return null;
    }

    @Override
    public String getDescription(String prefix) {
        return super.getDescription(prefix);
    }
}