package quanly;
import model.*;

public class thungThu {
    private buuPham[] danhSach;
    private int soLuong;

    public thungThu(int maxCapacity) {
        danhSach = new buuPham[maxCapacity];
        soLuong = 0;
    }

    public void boVaoThung(buuPham bp) {
        if (soLuong < danhSach.length) {
            danhSach[soLuong] = bp;
            soLuong++;
        } else {
            System.out.println("Thùng thư đã đầy!");
        }
    }

    public void lietKeTatCa() {
        System.out.println("\nDANH SÁCH TOÀN BỘ BƯU PHẨM");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("- Mã: %-5s | Loại: %-15s | Giá: %.0f đ\n", 
                    danhSach[i].getMaBP(), danhSach[i].layLoai(), danhSach[i].tinhGiaTien());
        }
    }

    public void lietKeTheoLoai(String loaiCanTim) {
        System.out.println("\n--- CÁC BƯU PHẨM LOẠI: " + loaiCanTim.toUpperCase() + " ---");
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].layLoai().equalsIgnoreCase(loaiCanTim)) {
                System.out.printf("- Mã: %-5s | Giá: %.0f đ\n", danhSach[i].getMaBP(), danhSach[i].tinhGiaTien());
            }
        }
    }

    public double tinhTongTien() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            tong += danhSach[i].tinhGiaTien();
        }
        return tong;
    }

    public double tinhTongTienTheoLoai(String loaiCanTinh) {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].layLoai().equalsIgnoreCase(loaiCanTinh)) {
                tong += danhSach[i].tinhGiaTien();
            }
        }
        return tong;
    }
}