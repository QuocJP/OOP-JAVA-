package Entities;

public class LineItem {
    private int order_ip;
    private int product_ip;
    private int quantity;
    private double price;

    public LineItem(){
        super();
    }
    public LineItem(int order_ip, int product_ip, int quantity, double price){
        this.order_ip = order_ip;
        this.product_ip = product_ip;
        this.quantity = quantity;
        this.price = price;
    }
    public int getOrder_ip() {
        return order_ip;
    }
    public int getProduct_ip() {
        return product_ip;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "LineItem [order_ip=" + order_ip + ", product_ip=" + product_ip + ", quantity=" + quantity + ", price="
                + price + "]";
    }
}
