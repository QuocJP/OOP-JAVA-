package Entities;

public class Products {
    private int product_id;
    private String product_name;
    private double list_price;

    public Products(){
        super();
    }
    public Products(int product_id, String product_name, double list_price){
        this.product_id = product_id;
        this.product_name = product_name;
        this.list_price = list_price;
    }
    public int getProduct_id() {
        return product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public double getList_price() {
        return list_price;
    }
    @Override
    public String toString() {
        return "Products [product_id=" + product_id + ", product_name=" + product_name + ", list_price=" + list_price
                + "]";
    }
}
