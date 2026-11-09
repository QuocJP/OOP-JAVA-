package manager;

import model.SinhVien;

public class QuanLySinhVien {
    private SinhVien sinhVienHienTai;

    public QuanLySinhVien() {
        this.sinhVienHienTai = new SinhVien();
    }

    public void luuThongTinSinhVien(String hoTen, int namSinh, double dtb, String tenTep) {
        sinhVienHienTai = new SinhVien(hoTen, namSinh, dtb);
        sinhVienHienTai.ghiTep(tenTep);
        System.out.println("Đã ghi thành công thông tin sinh viên vào tệp: " + tenTep);
    }

    public void taiThongTinSinhVien(String tenTep) {
        sinhVienHienTai = new SinhVien();
        sinhVienHienTai.docTep(tenTep);
        System.out.println("Thông tin sinh viên được tải lên từ tệp:");
        sinhVienHienTai.hienThi();
    }
}