package Thuchanh5.ThuVaBK.Entities;

public class Thu extends BuuPham {
    private int loaiThu;//1. Thu thuong; 2. Thu Bao Dam;
    private double tien;
    public Thu(){
        super();
    }
    public Thu(String maBuuPham, int loaiThu, double tien){
        super(maBuuPham);
        this.loaiThu = loaiThu;
        this.tien = tien;
    }
    @Override
    public double Tinhtien() {
        if(this.loaiThu == 1){
            tien = 800.0;
        }else if(this.loaiThu == 2){
            tien = 2000.0;
        }
        return tien;
    }

    public int getLoaiThu() {
        return loaiThu;
    }
    @Override
    public String loaiBuuPham() {
        String loaiThu;
        if(this.loaiThu == 1)
            loaiThu = "Thu Thuong";
        else if(this.loaiThu == 2)
            loaiThu = "Thu Bao Dam";
        else
            loaiThu = "Khong xac dinh";
        return loaiThu;
    }
}
