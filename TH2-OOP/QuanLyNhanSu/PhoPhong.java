package Thuchanh2.QuanLyNhanSu;

import java.time.LocalDate;

public class PhoPhong extends QuanLyNhanSu{
    public PhoPhong(String hoten, LocalDate ngaySinh, String chucVu, double heSoLuong, double luongCoBan){
        super(hoten, ngaySinh, chucVu, heSoLuong, luongCoBan);
    }
    @Override
    public double tinhluong(){
        return (this.heSoLuong + 0.4)*this.luongCoBan;
    }

}
