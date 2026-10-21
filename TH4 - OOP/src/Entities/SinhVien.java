package Thuchanh4.Sinhvien.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SinhVien {
    private String hoTen;
    private LocalDate ngaySinh;
    private double dTB;

    public SinhVien(){
        this.hoTen = "";
        this.ngaySinh = null;
        this.dTB = 0.0f;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setdTB(double dTB) {
        this.dTB = dTB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public double getdTB() {
        return dTB;
    }
    public String getHocLuc(){
        return HocLuc();
    }
    public void hienThi(){
        System.out.println("Ho va Ten: " + this.hoTen + " Ngay Sinh: " + this.ngaySinh.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Tuoi: " + this.TinhTuoi() + " DTB: " + this.dTB + " Xep Loai: " + this.getHocLuc());
    }
    public String TachHo(){
        int vt = this.hoTen.indexOf(" ");
        return this.hoTen.substring(0, vt);
    }
    public String TachDem(){
        int vt1 = this.hoTen.indexOf(" ");
        int vt2 = this.hoTen.lastIndexOf(" ");
        return this.hoTen.substring(vt1, vt2);
    }
    public String TachTen(){
        int vt = this.hoTen.lastIndexOf(" ");
        return this.hoTen.substring(vt + 1);
    }
    public int TinhTuoi(){
        return LocalDate.now().getYear() - this.ngaySinh.getYear();
    }
    public String HocLuc(){
        String xl;
        if(this.dTB >= 8.0){
            xl = "Gioi";
        }else if(this.dTB >= 7.0){
            xl = "Kha";
        }else if(this.dTB >= 5.0){
            xl = "Trung Binh";
        }else{
            xl = "Yeu";
        }
        return xl;
    }
}
