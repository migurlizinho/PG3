package aulas.classes.suppliers;

public class ExampleSuppliers {
    public static void main(String[] args) {
        SingleProducer sp = new SingleProducer("John", new Product("Banana", 29.99));
        System.out.println(sp.getDescription(""));

        Producer p = new Producer("Joe", new Product[]{
                new Product("Apple", 9.99),
                new Product("Orange", 19.99),
                new Product("Mango", 29.99),
                new Product("Bike", 999.99),
        });
        System.out.println(p.getDescription(""));
    }
}
