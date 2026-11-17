package Clients;

import java.io.IOException;

import Entities.SVSP;
import Entities.SVTH;
import Management.DanhSachSinhVien;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        DanhSachSinhVien ds = new DanhSachSinhVien();

        // Them 1 vai SV
        ds.them(new SVSP("SV001", "Nguyen Van A", 2002, 8.5, "FPT Software", 8.0));
        ds.them(new SVSP("SV002", "Tran Thi B", 2003, 4.5, "Viettel", 6.0));
        ds.them(new SVSP("SV003", "Le Van C", 2001, 6.0, "Samsung", 3.0));
        ds.them(new SVTH("SV004", "Pham Thi D", 2002, 7.2, "Quan ly sinh vien", 7.5));
        ds.them(new SVTH("SV005", "Hoang Van E", 2003, 4.0, "Website ban hang", 5.0));
        ds.them(new SVTH("SV006", "Vo Thi F", 2002, 5.5, "App di dong", 6.0));

        // Liet ke tat ca SV
        System.out.println("LIET KE TAT CA SINH VIEN");
        ds.lietke();

        // Liet ke theo loai
        System.out.println("\nLIET KE SVSP");
        ds.lietke("SVSP");

        System.out.println("\nLIET KE SVTH");
        ds.lietke("SVTH");

        // Tim kiem theo ho ten
        System.out.println("\n TIM SINH VIEN: Nguyen Van A" );
        ds.tim("Nguyen Van A");

        // Ghi ra tep van ban, doc lai va liet ke
        ds.ghiTep("SinhVien.txt");
        System.out.println("\n>> Da ghi ra file SinhVien.txt");

        DanhSachSinhVien ds2 = new DanhSachSinhVien();
        ds2.docTep("SinhVien.txt");
        System.out.println("\nLIET KE SAU KHI DOC TU TEP VAN BAN");
        ds2.lietke();

        // Ghi ra file doi tuong, doc lai va liet ke
        ds.ghiFileObject("SinhVien.dat");
        System.out.println("\n>> Da ghi ra file SinhVien.dat");

        DanhSachSinhVien ds3 = new DanhSachSinhVien();
        ds3.docFileObject("SinhVien.dat");
        System.out.println("\nLIET KE SAU KHI DOC TU FILE DOI TUONG");
        ds3.lietke();

        // In danh sach SV duoc tot nghiep
        System.out.println("\nDANH SACH SINH VIEN DUOC TOT NGHIEP");
        ds.lietKeDuocTN();
    }
}
