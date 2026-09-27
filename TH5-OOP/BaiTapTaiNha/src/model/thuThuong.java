package model;

public class thuThuong extends buuPham {
    public thuThuong(String maBP) { super(maBP); }
    
    @Override
    public double tinhGiaTien() { return 800; }
    
    @Override
    public String layLoai() { return "Thư thường"; }
}