import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CuocGoi {
    private String soDienThoaiNhan;
    private double thoiLuong; // phút
    private String loaiCuocGoi; // "noi mang" hoặc "ngoai mang"

    public CuocGoi(String sdt, double thoiLuong, String loaiCuocGoi) {
        this.soDienThoaiNhan = sdt;
        this.thoiLuong = thoiLuong;
        this.loaiCuocGoi = loaiCuocGoi;
    }

    public double tinhTienCuoc() {
        if (loaiCuocGoi.equalsIgnoreCase("noi mang")) {
            return thoiLuong * 1000;
        } else {
            return thoiLuong * 2000;
        }
    }

    public void xuat() {
        System.out.printf("    * SĐT nhan: %s | Thoi luong: %.1f phut | Loai: %s | Thanh tien: %.0f VNĐ\n",
                soDienThoaiNhan, thoiLuong, loaiCuocGoi, tinhTienCuoc());
    }
}

class ThueBao {
    private String hoTenChuThueBao;
    private String soDienThoai;
    private List<CuocGoi> danhSachCuocGoi; // 2 cuộc gọi gần nhất

    public ThueBao() {
        danhSachCuocGoi = new ArrayList<>();
    }

    public void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ho ten chu thue bao: ");
        hoTenChuThueBao = scanner.nextLine();
        System.out.print("Nhap so dien thoai thue bao: ");
        soDienThoai = scanner.nextLine();

        danhSachCuocGoi.clear();
        for (int i = 0; i < 2; i++) {
            System.out.println("  -- Nhap thong tin cuoc goi thu " + (i + 1) + " --");
            System.out.print("  + So dien thoai nhan: ");
            String sdtNhan = scanner.nextLine();
            System.out.print("  + Thoi luong (phut): ");
            double thoiLuong = Double.parseDouble(scanner.nextLine());
            System.out.print("  + Loai cuoc goi (noi mang / ngoai mang): ");
            String loai = scanner.nextLine();

            danhSachCuocGoi.add(new CuocGoi(sdtNhan, thoiLuong, loai));
        }
    }

    public double tinhTongCuoc() {
        double tong = 0;
        for (CuocGoi cg : danhSachCuocGoi) {
            tong += cg.tinhTienCuoc();
        }
        return tong;
    }

    public boolean kiemTraVoucher() {
        return tinhTongCuoc() > 50000;
    }

    public void xuat() {
        System.out.println("Chu thue bao: " + hoTenChuThueBao + " (SĐT: " + soDienThoai + ")");
        System.out.println("  Chi tiet 2 cuoc goi gan nhat:");
        for (CuocGoi cg : danhSachCuocGoi) {
            cg.xuat();
        }
        System.out.printf("  => Tong tien cuoc can thanh toan: %.0f VNĐ\n", tinhTongCuoc());
        if (kiemTraVoucher()) {
            System.out.println("  => THONG BAO: Du dieu kien nhan voucher khuyen mai 10%!");
        } else {
            System.out.println("  => THONG BAO: Khong du dieu kien nhan voucher.");
        }
        System.out.println("--------------------------------------------------------");
    }
}

public class QuanLyThueBao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong thue bao N: ");
        int n = Integer.parseInt(scanner.nextLine());

        List<ThueBao> danhSachThueBao = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin thue bao thu " + (i + 1) + " ---");
            ThueBao tb = new ThueBao();
            tb.nhapThongTin(scanner);
            danhSachThueBao.add(tb);
        }

        System.out.println("\n\nDANH SACH THUE BAO VA CUOC PHI");
        for (int i = 0; i < danhSachThueBao.size(); i++) {
            System.out.println("Thue bao " + (i + 1) + ":");
            danhSachThueBao.get(i).xuat();
        }

        System.out.println("\nDANH SACH THUE BAO DAT DIEU KIEN NHAN VOUCHER");
        boolean coNguoiNhan = false;
        for (ThueBao tb : danhSachThueBao) {
            if (tb.kiemTraVoucher()) {
                tb.xuat();
                coNguoiNhan = true;
            }
        }
        if (!coNguoiNhan) {
            System.out.println("Khong co thue bao nao dat dieu kien nhan voucher.");
        }
    }
}