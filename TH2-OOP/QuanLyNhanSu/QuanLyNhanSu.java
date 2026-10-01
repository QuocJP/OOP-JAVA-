package Thuchanh2.QuanLyNhanSu;
import java.time.LocalDate;
public class QuanLyNhanSu {
    protected String hoTen;
    protected LocalDate ngaySinh;
    protected String chucVu;
    protected double heSoLuong;
    protected double luongCoBan;

    public QuanLyNhanSu(String hoten, LocalDate ngaySinh, String chucVu, double heSoLuong, double luongCoBan){
        this.hoTen = hoten;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    public String toString(){
        return ("Ho Ten: " + hoTen + " Ngay Sinh: " + ngaySinh + " Chuc Vu: " + chucVu + " He So Luong: " + heSoLuong + " Luong Co Ban:" + luongCoBan);
    }

    public double tinhluong(){
        return 0;
    }

    public double baohiemxahoi(){
        return 0.06 * tinhluong();
    }
    public double baohiemthatnghiep(){
        return 0.01 * tinhluong();
    }
    public double tienluong(){
        return tinhluong() - baohiemthatnghiep() - baohiemxahoi();
    }
    public LocalDate getngaysinh(){
        return ngaySinh;
    }
    public String gethoten(){
        return hoTen;
    }
    public boolean sosanhtuoi(QuanLyNhanSu nskhac){
        return this.ngaySinh.isBefore(nskhac.getngaysinh());
    }
}
