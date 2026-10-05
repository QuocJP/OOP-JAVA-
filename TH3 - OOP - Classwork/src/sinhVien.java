public class sinhVien {
    private String hoTen;
    private Diem dm1;
    private Diem dm2;

    public sinhVien(String hoTen, Diem dm1, Diem dm2) {
        this.hoTen = hoTen;
        this.dm1 = dm1;
        this.dm2 = dm2;
    }

    public double tinhDTB() {
        return (dm1.tinhDiem() + dm2.tinhDiem()) / (dm1.getsoTinChi() + dm2.getsoTinChi());
    }

    // Thêm hàm này để file Main có thể lấy được tên sinh viên
    public String getHoTen() {
        return this.hoTen;
    }
}