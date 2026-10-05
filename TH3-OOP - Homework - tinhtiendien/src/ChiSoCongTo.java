public class ChiSoCongTo {
    private int chiSoCu;
    private int chiSoMoi;

    public ChiSoCongTo() {
    }

    public ChiSoCongTo(int chiSoCu, int chiSoMoi) {
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public int tinhDienTieuThu() {
        return chiSoMoi - chiSoCu;
    }
}