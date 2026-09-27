package main;
import model.*;
import quanly.thungThu;

public class main {
    public static void main(String[] args) {
        thungThu thung = new thungThu(100);

        thung.boVaoThung(new thuThuong("T01"));
        thung.boVaoThung(new thuBaoDam("TBD1"));
        thung.boVaoThung(new buuKien("BK1"));
        thung.boVaoThung(new thuThuong("T02"));
        thung.boVaoThung(new thuBaoDam("TBD2"));
        thung.boVaoThung(new thuBaoDam("TBD3"));
        thung.boVaoThung(new buuKien("BK2"));

        thung.lietKeTatCa();
        thung.lietKeTheoLoai("Thư bảo đảm");

        System.out.println("\n=> TỔNG SỐ TIỀN TRONG THÙNG: " + thung.tinhTongTien() + " đ");

        System.out.println(" - Tổng tiền Thư thường : " + thung.tinhTongTienTheoLoai("Thư thường") + " đ");
        System.out.println(" - Tổng tiền Thư bảo đảm: " + thung.tinhTongTienTheoLoai("Thư bảo đảm") + " đ");
        System.out.println(" - Tổng tiền Bưu kiện   : " + thung.tinhTongTienTheoLoai("Bưu kiện") + " đ");
    }
}