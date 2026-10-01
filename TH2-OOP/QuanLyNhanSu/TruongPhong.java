package Thuchanh2.QuanLyNhanSu;

import java.time.LocalDate;

public class TruongPhong extends QuanLyNhanSu{
    public TruongPhong(String hoten, LocalDate ngaySinh, String chucVu, double heSoLuong, double luongCoBan){
        super(hoten, ngaySinh, chucVu, heSoLuong, luongCoBan);
    }
    @Override
    public double tinhluong(){
        return (this.heSoLuong + 0.5)*this.luongCoBan;
    }
}
