package Thuchanh4.Sinhvien.Client;
import java.time.LocalDate;

import Thuchanh4.Sinhvien.Entities.*;
import Thuchanh4.Sinhvien.Management.*;
public class Main {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(); SinhVien sv2 = new SinhVien(); SinhVien sv3 = new SinhVien();
        sv1.setHoTen("Tu Minh Duc");
        sv1.setNgaySinh(LocalDate.of(2007, 8, 07));
        sv1.setdTB(8.6f);
        sv2.setHoTen("Nguyen Van Nam");
        sv2.setNgaySinh(LocalDate.of(1999, 6, 01));
        sv2.setdTB(6.5f);
        sv3.setHoTen("Tran Thi Hoa");
        sv3.setNgaySinh(LocalDate.of(2000, 3, 10));
        sv3.setdTB(5.5f);
        QuanLySinhVien list = new QuanLySinhVien(5);
        list.Them(sv1);
        list.Them(sv2);
        list.Them(sv3);
        list.lietke();
        System.out.println("---------------------");
        System.out.println("Diem trung binh cua cac hoc sinh: " + list.TinhTuoiTB());
        System.out.println("---------------------");
        list.sapxep();
        list.lietke();
        System.out.println("---------------------");
        list.lietke("Nam");
        System.out.println("---------------------");
        list.xoaTen("Hoa");
        list.lietke();
    }
}
