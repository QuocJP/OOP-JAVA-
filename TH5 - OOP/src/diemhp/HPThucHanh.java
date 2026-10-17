package diemhp;

public class HPThucHanh extends DiemHP {
    private final double[] diemBaiThucHanh;

    public HPThucHanh(String tenHP, int soTinChi, double... diemBaiThucHanh) {
        super(tenHP, soTinChi);
        if (diemBaiThucHanh == null || diemBaiThucHanh.length == 0) {
            throw new IllegalArgumentException("Hoc phan phai co it nhat mot bai thuc hanh.");
        }
        this.diemBaiThucHanh = diemBaiThucHanh.clone();
        for (double diem : this.diemBaiThucHanh) {
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
        for (double diem : diemBaiThucHanh) {
            tongDiem += diem;
        }
        return tongDiem / diemBaiThucHanh.length;
    }
}
