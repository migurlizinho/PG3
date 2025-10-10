package aulas.classes.suppliers;

public class Producer extends SupplierBase {
    private Product[] products;

    public Producer(String name, Product[] products){
        super(name);
        this.products = products;
        product.setSupplier(this);
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public int getNumberOfProducts() {
        return products.length;
    }

    @Override
    public Product find(String productName) {
        for(Product product : products){
            if(product.getName().equals(productName))
                return product;
        }
        return null;
    }

    @Override
    public String getDescription(String prefix) {
        String description = new String(prefix + "The Producer " + this.getName() + ", produces ");

        String separator = ", ";
        for(int i = 0; i < getNumberOfProducts() ; i++){
            if(i == getNumberOfProducts() - 1)
                separator = "";
            if(i == getNumberOfProducts() - 2)
                separator = " and ";
            description += products[i].toString() + separator;
        }

        return description;
    }
}
