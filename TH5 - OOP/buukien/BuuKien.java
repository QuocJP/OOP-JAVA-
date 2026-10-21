package Thuchanh5.ThuVaBK.Entities;

public class BuuKien extends BuuPham{
    private double tien;
    public BuuKien(){
        super();
    }
    public BuuKien(String maBuuPham, double tien){
        super(maBuuPham);
        this.tien = tien;
    }
    @Override
    public double Tinhtien() {
        return tien = 5000.0;
    }
    @Override
    public String loaiBuuPham() {
        return "Buu Kien";
    }
}
