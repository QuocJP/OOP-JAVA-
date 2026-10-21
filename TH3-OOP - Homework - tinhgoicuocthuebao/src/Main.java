

import java.time.LocalTime;

public class Main {
    public static void main(String[] args){
        GoiCuoc c1 = new GoiCuoc("1122334455", LocalTime.of(00,15, 30), 1);
        GoiCuoc c2 = new GoiCuoc("9876543210", LocalTime.of(00,30, 15), 2);
        NguoiDung nd = new NguoiDung("Tu Minh Duc", "1234567890", c1, c2);
        System.out.println("Nguoi Dung: " + nd.getNguoiDung() + " So Dien Thoai: " + nd.getSoDienThoai() + " Gia Cuoc: " + nd.tinhGiaCuoc());
    }
}
