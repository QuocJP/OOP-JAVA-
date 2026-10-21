package Thuchanh5.ThuVaBK.Management;

import Thuchanh5.ThuVaBK.Entities.*;

public class ThungThu {
    private BuuPham[] list;
    private int soBuuPham;
    public ThungThu(int n){
        list = new BuuPham[n];
        soBuuPham = 0;
    }
    public void Them(BuuPham bp){
        if(soBuuPham < list.length){
            list[soBuuPham] = bp;
            soBuuPham++;
        }
    }
    public void lietKe(){
        for(int i = 0; i < soBuuPham; i++){
            list[i].hienThi();
        }
    }
    public double tongTien(){
        double Tongtien = 0;
        for(int i = 0; i < soBuuPham; i++){
            Tongtien += list[i].Tinhtien();
        }return Tongtien;
    }
}
