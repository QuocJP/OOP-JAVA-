package model;

public class thuBaoDam extends buuPham {
    public thuBaoDam(String maBP) { super(maBP); }
    
    @Override
    public double tinhGiaTien() { return 2000; }
    
    @Override
    public String layLoai() { return "Thư bảo đảm"; }
}