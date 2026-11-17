package Entities;

public class Nghia {
    String nghia, phanLoai, viDu;
    public Nghia(){
        super();
    }
    public Nghia(String nghia, String phanLoai, String viDu) {
        this.nghia = nghia;
        this.phanLoai = phanLoai;
        this.viDu = viDu;
    }
    public String getNghia() {
        return nghia;
    }
    public void setNghia(String nghia) {
        this.nghia = nghia;
    }
    public String getPhanLoai() {
        return phanLoai;
    }
    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }
    public String getViDu() {
        return viDu;
    }
    public void setViDu(String viDu) {
        this.viDu = viDu;
    }
}
