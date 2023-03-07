public interface ProductStock extends Iterable<Product> {
    //getter
    int getCount();

    //Validations
    boolean contains(Product product);

    //Modifications
    void add(Product product);
    void changeQuantity(String product, int quantity);

    //Retrievals
    Product find(int index);
    Product findByLabel(String label);
    Iterable<Product> findFirstByAlphabeticalOrder(int count);

    //Querying
    Iterable<Product> findAllInRange(double lo, double hi);
    Iterable<Product> findAllByPrice(double price);
    Iterable<Product> findFirstMostExpensiveProducts(int count);
    Iterable<Product> findAllByQuantity(int quantity);
}
