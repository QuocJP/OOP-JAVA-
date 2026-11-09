package app;

import manager.QuanLySinhVien;

public class App {
    public static void main(String[] args) {
        QuanLySinhVien quanLy = new QuanLySinhVien();
        String tenTepDuLieu = "sv.txt";

        //Gọi lớp quản lý thực hiện ghi dữ liệu
        quanLy.luuThongTinSinhVien("Nguyễn Anh Quốc", 2007, 7.5, tenTepDuLieu);
        
        //Gọi lớp quản lý thực hiện đọc dữ liệu
        quanLy.taiThongTinSinhVien(tenTepDuLieu);
    }
}