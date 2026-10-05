package Thuchanh3.GoiCuoc;

import java.time.LocalTime;

public class GoiCuoc {
    private String soDienThoainhan;
    private LocalTime thoiLuongCuocGoi;
    private int loaiCuocGoi;//1: nội mạng, 2: ngoại mạng

    public GoiCuoc(String soDienThoai, LocalTime thoiLuongCuocGoi, int loaiCuoGoi){
        this.soDienThoainhan = soDienThoai;
        this.thoiLuongCuocGoi = thoiLuongCuocGoi;
        this.loaiCuocGoi = loaiCuoGoi;
    }

    public double getPhut(){
        return (this.thoiLuongCuocGoi.getMinute() + this.thoiLuongCuocGoi.getHour() * 60.0f + this.thoiLuongCuocGoi.getSecond()/60.0f);
    }

    public double TinhCuoc(){
        double GiaCuoc = 0.0f;
        if(this.loaiCuocGoi == 1){
            GiaCuoc = 1000.0 * this.getPhut();
        }
        
        else if(this.loaiCuocGoi == 2){
            GiaCuoc = 2000.0 * this.getPhut();
        }
        return GiaCuoc;
    }
}
