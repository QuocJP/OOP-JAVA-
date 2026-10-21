package Thuchanh5.ThuVaBK.Entities;

abstract public class BuuPham {
    protected String maBuuPham;
    public BuuPham(){
        super();
    }
    public BuuPham(String maBuuPham){
        this.maBuuPham = maBuuPham;
    }
    
    public String getMaBuuPham() {
        return maBuuPham;
    }
    abstract public double Tinhtien();
    public void setMaBuuPham(String maBuuPham) {
        this.maBuuPham = maBuuPham;
    }
    abstract public String loaiBuuPham();
    public void hienThi(){
        System.out.println("Ma Buu Pham: " + this.maBuuPham + " Loai Buu Pham " + this.loaiBuuPham() + " So Tien " + this.Tinhtien());
    }
}
