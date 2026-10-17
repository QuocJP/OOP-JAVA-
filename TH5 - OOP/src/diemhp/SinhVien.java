package diemhp;

public class SinhVien {
    private final String hoTen;
    private final DiemHP[] hocPhan;

    public SinhVien(String hoTen, DiemHP... hocPhan) {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Ho ten sinh vien khong duoc de trong.");
        }
        if (hocPhan == null || hocPhan.length == 0) {
            throw new IllegalArgumentException("Sinh vien phai co it nhat mot hoc phan.");
        }
        this.hoTen = hoTen.trim();
        this.hocPhan = hocPhan.clone();
        for (DiemHP hp : this.hocPhan) {
            if (hp == null) {
                throw new IllegalArgumentException("Hoc phan khong duoc null.");
            }
        }
    }

    public double tinhDTB() {
        double tongDiemCoTrongSo = 0.0;
        int tongTinChi = 0;
        for (DiemHP hp : hocPhan) {
            tongDiemCoTrongSo += hp.tinhDiem() * hp.getSoTinChi();
            tongTinChi += hp.getSoTinChi();
        }
        return tongDiemCoTrongSo / tongTinChi;
    }

    public void hienThi() {
        System.out.println("Sinh vien: " + hoTen);
        for (DiemHP hp : hocPhan) {
            System.out.printf("  %-24s (%d TC): %.2f%n",
                    hp.getTenHP(), hp.getSoTinChi(), hp.tinhDiem());
        }
        System.out.printf("  Diem trung binh: %.2f%n", tinhDTB());
    }
}
