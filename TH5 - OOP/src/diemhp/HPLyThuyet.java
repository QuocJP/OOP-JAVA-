package diemhp;

public class HPLyThuyet extends DiemHP {
    private final int chuyenCan;
    private final int giuaKy;
    private final int cuoiKy;

    public HPLyThuyet(String tenHP, int soTinChi, int chuyenCan, int giuaKy, int cuoiKy) {
        super(tenHP, soTinChi);
        this.chuyenCan = kiemTraDiem(chuyenCan);
        this.giuaKy = kiemTraDiem(giuaKy);
        this.cuoiKy = kiemTraDiem(cuoiKy);
    }

    private int kiemTraDiem(int diem) {
        if (diem < 0 || diem > 10) {
            throw new IllegalArgumentException("Diem phai nam trong khoang 0 den 10.");
        }
        return diem;
    }

    @Override
    public double tinhDiem() {
        return chuyenCan * 0.1 + giuaKy * 0.2 + cuoiKy * 0.7;
    }
}
