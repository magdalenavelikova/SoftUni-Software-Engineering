import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean contains(Product product) {
        return products.stream().anyMatch(p -> p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        findByLabel(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

    }

    @Override
    public Product findByLabel(String label) {
        return products.stream()
                .filter(p -> p.getLabel().equals(label)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return products.stream().limit(count)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return products.stream()
                .filter(p -> p.getPrice() > 2 && p.getPrice() <= 20)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if(count> products.size()){
            throw new IllegalArgumentException("Count is bigger then size of products");
        }
            return products.stream()
                    .sorted(Comparator.comparing(Product::getPrice).reversed())
                    .limit(count)
                    .collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
