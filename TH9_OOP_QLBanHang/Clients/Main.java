package Clients;

import java.sql.Date;
import java.sql.SQLException;

import Entities.*;
import Management.*;

public class Main {
    public static void main(String[] args) {
        DanhSach ds = new DanhSach();
        try {
            System.out.println("-----------------------------");
            for (Customer c : ds.getAllCustomers()) System.out.println(c);

            System.out.println("-----------------------------");
            for (Orders o : ds.getOrdersByCustomer(1)) System.out.println(o);

            System.out.println("-----------------------------");
            for (LineItem li : ds.getLineItems(101)) System.out.println(li);

            System.out.println("Tong tien don 101 (UDF)" + ds.computeOrderTotal(101));

            System.out.println("-----------------------------");
            ds.addCustomer(11, "Nguyen Van Test");

            System.out.println("------------------------------");
            ds.updateCustomer(11, "Nguyen Van Da Sua");

            System.out.println("------------------------------");
            ds.createOrder(111, Date.valueOf("2026-11-18"), 11, 2);
            ds.addLineItem(111, 2, 2, 25.5);
            ds.addLineItem(111, 3, 1, 80.0);
            ds.updateOrderTotal(111);
            for (Orders o : ds.getOrdersByCustomer(11)) System.out.println(o);

            System.out.println("== 3.7 Xoa KH 11 (kem don hang) ==");
            ds.deleteCustomer(11);
            System.out.println("Xong!");
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

}
