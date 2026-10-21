package Thuchanh4.Sinhvien.Management;
import Thuchanh4.Sinhvien.Entities.SinhVien;
public class QuanLySinhVien {
    private SinhVien [] ds;
    private int soSV;

    public QuanLySinhVien(int n){
        ds = new SinhVien[n];
        this.soSV = 0;
    }
    public void Them(SinhVien sv){
        if(this.soSV < ds.length){
            ds[soSV] = sv;
            soSV++;
        }
    }
    public void lietke(){
        for(int i = 0; i < soSV; i++){
            ds[i].hienThi();
        }
    }
    public void sapxep(){
        for(int i = 0; i < soSV - 1; i++){
            for(int j = 1; j < soSV; j++){
                if(ds[i].TachTen().compareTo(ds[j].TachTen()) > 0){
                    SinhVien temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }
    public void lietke(double x){
        for(int i = 0; i < soSV; i++){
            if(ds[i].getdTB() >= 8.0)
                ds[i].hienThi();
        }
    }
    public void lietke(String a){
        for(int i = 0; i < soSV; i ++){
            if(ds[i].TachTen().equals(a))
                ds[i].hienThi();
        }
    }
    public void xoaTen(String a){
        for(int i = 0; i < soSV; i++){
            if(ds[i].TachTen().equals(a)){
                for(int j = i; j < soSV - 1; j++){
                    ds[j] = ds[j + 1];
                }soSV--;
                ds[soSV] = null;
                return;
            }
        }
    }
    public double TinhTuoiTB(){
        double Tong = 0;
        for(int i = 0; i < soSV; i++){
            Tong += ds[i].TinhTuoi();
        }return Tong / soSV;
    }
}
