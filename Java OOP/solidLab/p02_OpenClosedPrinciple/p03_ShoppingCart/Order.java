package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public abstract class Order {
    protected final Cart cart;

    protected Order(Cart cart) {
        this.cart = cart;
    }
    void chekout(){
        //log the order in the p03_Database
    }
}
