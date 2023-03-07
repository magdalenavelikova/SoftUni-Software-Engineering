import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private ProductStock instock;
    private Product product;
    private Product missingProduct;

    @Before
    public void setup() {
        instock = new Instock();
        product = new Product("Label", 2.50, 8);
        missingProduct = new Product("Missing", 2.50, 8);
    }

    @Test
    public void testAddProductShouldContainsIt() {
        instock.add(product);
        assertTrue(instock.contains(product));
    }

    @Test
    public void testContainsShouldBeFalseForMissingProduct() {
        assertFalse(instock.contains(missingProduct));
    }

    @Test
    public void testCountShouldCountProducts() {
        assertEquals(0, instock.getCount());
        instock.add(product);
        assertEquals(1, instock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldThrowIndexOutOfBoundsException() {
        List<Product> products = addMultipleProducts();
        instock.find(products.size());
    }

    @Test
    public void testFindShouldReturnProduct() {
        List<Product> products = addMultipleProducts();
        assertEquals(products.get(0), instock.find(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowWhenThereIsNoSuchProduct() {
        instock.changeQuantity("Missing", 5);
    }

    @Test
    public void testChangeQuantityShouldChangeQuantity() {
        List<Product> products = addMultipleProducts();
        instock.changeQuantity("Label1", 15);
        assertEquals(15, instock.findByLabel("Label1").getQuantity());
    }

    @Test
    public void testFindByLabelShouldReturnProduct() {
        instock.add(product);
        Product expectedProduct = instock.findByLabel(product.getLabel());
        assertNotNull(expectedProduct);
        assertEquals(product, expectedProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowIllegalArgumentExceptionWhenThereIsNotSuchProduct() {

        instock.findByLabel("Missing");

    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnIterable() {
        List<Product> products = addMultipleProducts();
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(products.size());
        List<Product> actual = iterableToList(iterable);
        assertEquals(products.size(), actual.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyListWhenTheCountIsBiggerThenSize() {
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(10);
        List<Product> actual = iterableToList(iterable);
        assertEquals(0, actual.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnSortedList() {
        List<Product> products = addMultipleProducts();
        List<Product> sorted = products.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(products.size());
        List<Product> actual = iterableToList(iterable);
        assertEquals(products.size(), actual.size());
        for (int i = 0; i < products.size(); i++) {
            assertEquals(sorted.get(i).getLabel(), actual.get(i).getLabel());
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnValidCollection() {

        final double START = 2.0;
        final double END = 20.0;

        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getPrice() > START && p.getPrice() <= END)
                .collect(Collectors.toList());
        Iterable<Product> iterable = instock.findAllInRange(START, END);
        List<Product> actual = iterableToList(iterable);
        assertEquals(expected.size(), actual.size());
        boolean hasNoOutOfRangePrices = actual.stream()
                .map(Product::getPrice).noneMatch(p -> p <= START || p > END);
        assertTrue(hasNoOutOfRangePrices);

    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyListWhenTheCountIsBiggerThenSize() {
        final double START = 0.0;
        final double END = 1.0;
        Iterable<Product> iterable = instock.findAllInRange(START, END);
        List<Product> actual = iterableToList(iterable);
        assertEquals(0, actual.size());
    }

    @Test
    public void testFindAllInRangeReturnSortedListOrderedByPriceDesc() {
        final double START = 2.0;
        final double END = 20.0;
        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getPrice() > START && p.getPrice() <= END)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findAllInRange(START, END);
        List<Product> actual = iterableToList(iterable);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getPrice(), actual.get(i).getPrice(), 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnListOfProductsWithMatchingPrices() {
        double expectedPrice = 2.0;
        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getPrice() == expectedPrice)
                .collect(Collectors.toList());
        List<Product> actual = iterableToList(instock.findAllByPrice(expectedPrice));
        assertEquals(expected.size(), actual.size());

        for (Product pr : actual) {
            assertEquals(expectedPrice, pr.getPrice(), 0.0);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyList() {
        double expectedPrice = -2;
        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getPrice() == expectedPrice)
                .collect(Collectors.toList());
        List<Product> actual = iterableToList(instock.findAllByPrice(expectedPrice));
        assertEquals(0, actual.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnValidCollection() {


        List<Product> expected = addMultipleProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<Product> actual = iterableToList(instock.findFirstMostExpensiveProducts(3));
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getPrice(), actual.get(i).getPrice(), 0.0);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowWhenTheCountIsLessThenExpected() {
        List<Product> expected = addMultipleProducts();
        List<Product> actual = iterableToList(iterableToList(instock.findFirstMostExpensiveProducts(expected.size() + 1)));
        assertEquals(0, actual.size());
    }

    @Test
    public void testFindAllByQuantityShouldReturnListOfProductsWithMatchingPrices() {
        int expectedQuantity = 10;
        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getQuantity() == expectedQuantity)
                .collect(Collectors.toList());
        List<Product> actual = iterableToList(instock.findAllByQuantity(expectedQuantity));
        assertEquals(expected.size(), actual.size());

        for (Product pr : actual) {
            assertEquals(expectedQuantity, pr.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyList() {
        int expectedQuantity = -2;
        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getQuantity() == expectedQuantity)
                .collect(Collectors.toList());
        List<Product> actual = iterableToList(instock.findAllByQuantity(expectedQuantity));
        assertEquals(0, actual.size());
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = addMultipleProducts();
        Iterator<Product> iterator = instock.iterator();
        List<Product> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    private List<Product> iterableToList(Iterable<Product> iterable) {
        List<Product> products = new ArrayList<>();

        iterable.forEach(products::add);
        return products;
    }

    private List<Product> addMultipleProducts() {
        List<Product> multipleProducts = List.of(
                new Product("Label1", 30, 10),
                new Product("Label2", 2, 20),
                new Product("Label3", 2, 10),
                new Product("Label5", 10, 50),
                new Product("Label4", 20, 40)

        );
        multipleProducts.forEach(p -> instock.add(p));
        return multipleProducts;
    }

}