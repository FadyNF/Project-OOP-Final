import java.io.Serializable;
import java.util.HashMap;

public class Cart implements Serializable {
    private HashMap<Product, Integer> cartProducts;
    private double totalPrice;

    public Cart() {
        cartProducts = new HashMap<Product, Integer>();
        totalPrice = 0.0;
    }

    public HashMap<Product, Integer> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(HashMap<Product, Integer> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addProduct(Product product, int quantity) {
        if (cartProducts.containsKey(product)) {
            cartProducts.put(product, cartProducts.get(product) + quantity);
        } else {
            cartProducts.put(product, quantity);
        }

        totalPrice += (product.productPrice)*quantity;
    }

    public void removeProduct(Product product, int quantity){
        if (cartProducts.containsKey(product)) {
            int currentQuantity = cartProducts.get(product);
            if (quantity < currentQuantity) {
                cartProducts.put(product, currentQuantity - quantity);
            } else {
                cartProducts.remove(product);
            }
        }

        totalPrice -= (product.productPrice)*quantity;
    }

    public void clearCart(){
        cartProducts.clear();
        totalPrice = 0.0;
    }
}
