package aulas.classes.suppliers;

public interface Supplier {
    Product product = new Product("unknown", 0.0);
    Retailer retailer = new Retailer("unknown");
    String getName();
    Product[] getProducts();
    int getNumberOfProducts();
    Product find(String productName);
    String getDescription(String prefix);
}
