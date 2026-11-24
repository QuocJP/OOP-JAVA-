package Entities;

public class Customer {
    private int customer_id;
    private String customer_name;
    public Customer(){
        super();
    }
    public Customer(int customer_id, String customer_name){
        this.customer_id = customer_id;
        this.customer_name = customer_name;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    @Override
    public String toString() {
        return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + "]";
    }
}
