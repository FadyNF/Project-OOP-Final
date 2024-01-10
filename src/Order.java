import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Order implements Serializable {
    private int OrderID;
    private HashMap<Product, Integer> orderProducts;
    private OrderStatus Status;
    private String orderAddress;
    private Date orderDate;
    private double totalPrice;
    private int rate;

    public Order(int i) {
        this.OrderID = i;
        this.orderProducts = new HashMap<>();
        this.Status = OrderStatus.PENDING;
        this.rate = -1;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public HashMap<Product, Integer> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(HashMap<Product, Integer> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public OrderStatus getStatus() {
        return Status;
    }

    public void setStatus(OrderStatus status) {
        Status = status;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
