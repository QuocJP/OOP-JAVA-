package Thuchanh5.TinhDiemHP.Entities;

public class HPLyThuyet extends DiemHP{
    private int chuyenCan;
    private int giuaKy;
    private int cuoiKy;
    public HPLyThuyet(){
        super();
    }
    public HPLyThuyet(String tenHP, int soTinChi, int chuyenCan, int giuaKy, int cuoiKy){
        super(tenHP, soTinChi);
        this.chuyenCan = chuyenCan;
        this.giuaKy = giuaKy;
        this.cuoiKy = cuoiKy;
    }
    @Override
    public double tinhDiem() {
        return (chuyenCan * 0.1 + giuaKy * 0.2 + cuoiKy * 0.7);
    }
}
