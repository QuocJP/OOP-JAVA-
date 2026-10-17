package diemhp;

public class HPDoAn extends DiemHP {
    private final double[] diemHoiDong;

    public HPDoAn(String tenHP, int soTinChi, double... diemHoiDong) {
        super(tenHP, soTinChi);
        if (diemHoiDong == null || diemHoiDong.length != 5) {
            throw new IllegalArgumentException("Diem do an phai gom dung 5 diem hoi dong.");
        }
        this.diemHoiDong = diemHoiDong.clone();
        for (double diem : this.diemHoiDong) {
            kiemTraDiem(diem);
        }
    }

    private void kiemTraDiem(double diem) {
        if (!Double.isFinite(diem) || diem < 0.0 || diem > 10.0) {
            throw new IllegalArgumentException("Diem phai nam trong khoang 0 den 10.");
        }
    }

    @Override
    public double tinhDiem() {
        double tongDiem = 0.0;
        for (double diem : diemHoiDong) {
            tongDiem += diem;
        }
        return tongDiem / diemHoiDong.length;
    }
}
