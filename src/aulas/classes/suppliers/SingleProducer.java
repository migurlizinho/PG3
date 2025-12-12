package aulas.classes.suppliers;

public class SingleProducer extends SupplierBase {
    private Product product;

    public SingleProducer(String name, Product product){
        super(name);
        this.product = product;
        product.setSupplier(this);
    }

    @Override
    public Product[] getProducts() {
        Product[] products =  new Product[1];
        products[0] = product;
        return products;
    }

    @Override
    public int getNumberOfProducts() {
        return 1;
    }

    @Override
    public Product find(String productName) {
        if(product.getName().equals(productName))
            return product;
        return null;
    }

    @Override
    public String getDescription(String prefix) {
        return prefix + "The Single Producer " + this.getName() + ", produces " + product.toString();
    }
}
