package Client;

import Entities.SinhVien;
import Management.QuanLySinhVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soLuong = nhapSoLuong(scanner);
        QuanLySinhVien danhSach = new QuanLySinhVien(soLuong);

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nNhap thong tin sinh vien thu " + (i + 1) + ":");

            String hoTen;
            do {
                System.out.print("Ho va ten: ");
                hoTen = scanner.nextLine().trim();
                if (hoTen.isEmpty()) {
                    System.out.println("Ho va ten khong duoc de trong.");
                }
            } while (hoTen.isEmpty());

            Date ngaySinh = nhapNgaySinh(scanner);
            double diemTrungBinh = nhapDiem(scanner);
            danhSach.Them(new SinhVien(hoTen, ngaySinh, diemTrungBinh));
        }

        System.out.println("\n=== Danh sach sinh vien ===");
        danhSach.lietke();

        System.out.println("\n=== Sinh vien xep loai Gioi (DTB >= 8.0) ===");
        danhSach.lietke(8.0);

        System.out.println("\n=== Sinh vien co ten Nam ===");
        danhSach.lietke("Nam");

        System.out.println("\n=== Xoa sinh vien dau tien co ten Hoa ===");
        if (!danhSach.xoaTen("Hòa")) {
            System.out.println("Khong tim thay sinh vien ten Hoa.");
        }
        danhSach.lietke();

        System.out.printf("%nTuoi trung binh cua danh sach hien tai: %.2f%n", danhSach.TinhTuoiTB());

        System.out.println("\n=== Danh sach sau khi sap xep theo ten A-Z ===");
        danhSach.sapxep();
        danhSach.lietke();

        scanner.close();
    }

    private static int nhapSoLuong(Scanner scanner) {
        while (true) {
            System.out.print("Nhap so luong sinh vien: ");
            String input = scanner.nextLine().trim();
            try {
                int soLuong = Integer.parseInt(input);
                if (soLuong >= 0) {
                    return soLuong;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Vui long nhap so nguyen khong am.");
        }
    }

    private static Date nhapNgaySinh(Scanner scanner) {
        SimpleDateFormat dinhDang = new SimpleDateFormat("dd/MM/yyyy");
        dinhDang.setLenient(false);

        while (true) {
            System.out.print("Ngay sinh (dd/MM/yyyy): ");
            String input = scanner.nextLine().trim();
            try {
                Date ngaySinh = dinhDang.parse(input);
                if (dinhDang.format(ngaySinh).equals(input)) {
                    return ngaySinh;
                }
            } catch (ParseException ignored) {
            }
            System.out.println("Ngay sinh khong hop le. Hay nhap theo dd/MM/yyyy.");
        }
    }

    private static double nhapDiem(Scanner scanner) {
        while (true) {
            System.out.print("Diem trung binh (0-10): ");
            String input = scanner.nextLine().trim();
            try {
                double diem = Double.parseDouble(input);
                if (Double.isFinite(diem) && diem >= 0.0 && diem <= 10.0) {
                    return diem;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Diem phai la so trong khoang tu 0 den 10.");
        }
    }
}
