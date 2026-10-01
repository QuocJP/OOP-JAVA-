package Thuchanh2.QuanLyNhanSu;

import java.time.LocalDate;

public class GiamDoc extends QuanLyNhanSu{
    public GiamDoc(String hoten, LocalDate ngaySinh, String chucVu, double heSoLuong, double luongCoBan){
        super(hoten, ngaySinh, chucVu, heSoLuong, luongCoBan);
    }
    @Override
    public double tinhluong(){
        return (this.heSoLuong + 1.0)*this.luongCoBan;
    }

}
