package Thuchanh5.TinhDiemHP.Management;

import Thuchanh5.TinhDiemHP.Entities.SinhVien;

public class QuanLySinhVien {
    private SinhVien[] list;
    private int soSV;

    public QuanLySinhVien(int n){
        list = new SinhVien[n];
        this.soSV = 0;
    }
    public void Them(SinhVien sv){
        if(this.soSV < list.length){
            list[soSV] = sv;
            soSV++;
        }
    }
    public void lietKe(){
        for(int i = 0; i < soSV; i++){
            list[i].hienThi();
        }
    }
}
