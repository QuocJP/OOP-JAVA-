package model;

public abstract class buuPham {
    protected String maBP;

    public buuPham(String maBP) {
        this.maBP = maBP;
    }

    public String getMaBP() { return maBP; }
    
    public abstract double tinhGiaTien();
    public abstract String layLoai();
}