package model;

public class buuKien extends buuPham {
    public buuKien(String maBP) { super(maBP); }
    
    @Override
    public double tinhGiaTien() { return 5000; }
    
    @Override
    public String layLoai() { return "Bưu kiện"; }
}