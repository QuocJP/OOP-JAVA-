package Thuchanh3.GoiCuoc;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args){
        GoiCuoc c1 = new GoiCuoc("0956789990", LocalTime.of(00,15, 30), 1);
        GoiCuoc c2 = new GoiCuoc("0355789990", LocalTime.of(00,30, 15), 2);
        NguoiDung nd = new NguoiDung("Tu Minh Duc", "0899903772", c1, c2);
        System.out.println("Nguoi Dung: " + nd.getNguoiDung() + " So Dien Thoai: " + nd.getSoDienThoai() + " Gia Cuoc: " + nd.tinhGiaCuoc());
    }
}
