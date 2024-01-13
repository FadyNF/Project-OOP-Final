import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends User implements Serializable {
    private int customerID;
    private ArrayList<Order> customerOrders;
    private double customerRevenue;
    private Cart customerCart;

    public Customer(String userName, String userPassword, int customerID) {
        super(userName, userPassword);
        this.customerID = customerID;
        customerOrders = new ArrayList<>();
        customerRevenue = 0.0;
        customerCart = new Cart();
    }

    @Override
    public String toString(){
        return "Customer{" +
                "Customer ID: " + this.getCustomerID() +
                ", username: " + this.getUserName() +
                "}";
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(ArrayList<Order> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public double getCustomerRevenue() {
        return customerRevenue;
    }

    public void setCustomerRevenue(double customerRevenue) {
        this.customerRevenue = customerRevenue;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(Cart customerCart) {
        this.customerCart = customerCart;
    }

    public ArrayList<Product> searchProducts(ArrayList<Product> productList,String searchQuery) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(searchQuery.toLowerCase())) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Order order : customerOrders) {
            totalRevenue += order.getTotalPrice();
        }
        return totalRevenue;
    }

}
