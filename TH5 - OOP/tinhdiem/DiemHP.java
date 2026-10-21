package Thuchanh5.TinhDiemHP.Entities;

abstract public class DiemHP {
    protected String tenHP;
    protected int soTinChi;

    public DiemHP(){
        super();
    }
    public DiemHP(String tenHP, int soTinChi){
        super();
        this.tenHP = tenHP;
        this.soTinChi = soTinChi;
    }
    public String layTenHP(){
        return tenHP;
    }
    public int laySoTinChi(){
        return soTinChi;
    }
    abstract public double tinhDiem();
}
