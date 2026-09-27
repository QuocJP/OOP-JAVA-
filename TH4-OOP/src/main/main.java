package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.sinhVien;
import quanly.danhSachSinhVien;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        danhSachSinhVien qlsv = new danhSachSinhVien(100);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("QUẢN LÝ HỒ SƠ SINH VIÊN);
        System.out.print("Nhập số lượng sinh viên cần thêm ban đầu: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n- Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            
            System.out.print(" + Họ và tên: ");
            String hoTen = sc.nextLine();
            
            System.out.print(" + Ngày sinh (dd/MM/yyyy): ");
            Date ngaySinh = null;
            while (ngaySinh == null) {
                try {
                    ngaySinh = sdf.parse(sc.nextLine());
                } catch (ParseException e) {
                    System.out.print("   -> Sai định dạng! Nhập lại (dd/MM/yyyy): ");
                }
            }
            
            System.out.print(" + Điểm trung bình: ");
            double dtb = Double.parseDouble(sc.nextLine());

            qlsv.themSinhVien(new sinhVien(hoTen, ngaySinh, dtb));
        }

        System.out.println("\n1. DANH SÁCH SINH VIÊN VỪA NHẬP:");
        qlsv.hienThiDanhSach();

        qlsv.lietKeSinhVienGioi();

        qlsv.timSinhVienTheoTen("Nam");

        qlsv.xoaSinhVienTheoTen("Hòa");
        System.out.println("\nDANH SÁCH SAU KHI XÓA:");
        qlsv.hienThiDanhSach();

        System.out.printf("\n=> Tuổi trung bình của toàn bộ sinh viên: %.2f\n", qlsv.tinhTuoiTrungBinh());

        System.out.println("\nDANH SÁCH SAU KHI SẮP XẾP THEO TÊN (A-Z):");
        qlsv.sapXepTheoTen();
        qlsv.hienThiDanhSach();

        sc.close();
    }
}