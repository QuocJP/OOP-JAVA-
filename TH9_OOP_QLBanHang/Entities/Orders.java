package Entities;

import java.util.Date;

public class Orders {
    private int order_ip;
    private Date order_date;
    private int customer_ip;
    private int employee_ip;
    private double total;
    
    public Orders(){
        super();
    }
    public Orders(int order_ip, Date order_date, int customer_ip, int employee_ip, double total){
        this.order_ip = order_ip;
        this.order_date = order_date;
        this.customer_ip = customer_ip;
        this.employee_ip = employee_ip;
        this.total = total;
    }
    public int getOrder_ip() {
        return order_ip;
    }
    public Date getOrder_date() {
        return order_date;
    }
    public int getCustomer_ip() {
        return customer_ip;
    }
    public int getEmployee_ip() {
        return employee_ip;
    }
    public double getTotal() {
        return total;
    }
    
    @Override
    public String toString() {
        return "Orders [order_ip=" + order_ip + ", order_date=" + order_date + ", customer_ip=" + customer_ip
                + ", employee_ip=" + employee_ip + ", total=" + total + "]";
    }
}
