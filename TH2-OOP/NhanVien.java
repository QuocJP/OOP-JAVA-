import java.util.Date;

@SuppressWarnings("deprecation")
public class NhanVien {
    private String hoTen;
    private Date ngaySinh;
    private String chucVu;
    private double heSoLuong;
    private double luongCoBan;

    public NhanVien(String hoTen, String ngaySinhStr, String chucVu, double heSoLuong, double luongCoBan) {
        this.hoTen = hoTen;
        this.ngaySinh = new Date(ngaySinhStr); // Format: "tháng/ngày/năm"
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public double getHeSoPhuCap() {
        if (chucVu.equalsIgnoreCase("GD") || chucVu.equalsIgnoreCase("Giám đốc")) return 1.0;
        if (chucVu.equalsIgnoreCase("PGD") || chucVu.equalsIgnoreCase("Phó giám đốc")) return 0.8;
        if (chucVu.equalsIgnoreCase("TP") || chucVu.equalsIgnoreCase("Trưởng phòng")) return 0.5;
        if (chucVu.equalsIgnoreCase("PP") || chucVu.equalsIgnoreCase("Phó phòng")) return 0.4;
        return 0.0; // Các chức vụ khác không có phụ cấp
    }

    public double tinhLuong() {
        return (heSoLuong + getHeSoPhuCap()) * luongCoBan;
    }

    public double tinhBHXH() {
        return 0.06 * tinhLuong();
    }

    public double tinhBHTN() {
        return 0.01 * tinhLuong();
    }

    public double thucLinh() {
        return tinhLuong() - tinhBHXH() - tinhBHTN();
    }

    public void hienThi() {
        System.out.printf("%-20s | Lương: %10.2f | BHXH: %8.2f | BHTN: %8.2f | Thực lĩnh: %10.2f\n", 
                          hoTen, tinhLuong(), tinhBHXH(), tinhBHTN(), thucLinh());
    }

    // HÀM MAIN ĐỂ CHẠY CHƯƠNG TRÌNH
    public static void main(String[] args) {
        NhanVien[] dsNV = new NhanVien[5];
        dsNV[0] = new NhanVien("Nguyen Van A", "05/15/1980", "GD", 4.5, 1500000);
        dsNV[1] = new NhanVien("Tran Thi B", "12/20/1985", "PGD", 4.0, 1500000);
        dsNV[2] = new NhanVien("Le Van C", "01/10/1990", "TP", 3.5, 1500000);
        dsNV[3] = new NhanVien("Pham Thi D", "08/08/1995", "PP", 3.0, 1500000);
        dsNV[4] = new NhanVien("Hoang Van E", "04/25/2000", "NV", 2.0, 1500000);

        System.out.println("THÔNG TIN NHÂN VIÊN");
        double tongLuong = 0;
        NhanVien nvLonTuoiNhat = dsNV[0];

        for (NhanVien nv : dsNV) {
            nv.hienThi();
            tongLuong += nv.tinhLuong();
            
            // So sánh ngày sinh: Date càng nhỏ (before) thì tuổi càng lớn
            if (nv.getNgaySinh().before(nvLonTuoiNhat.getNgaySinh())) {
                nvLonTuoiNhat = nv;
            }
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("Tổng lương của các nhân viên: %.2f\n", tongLuong);
        System.out.printf("Lương trung bình: %.2f\n", tongLuong / dsNV.length);
        System.out.println("Nhân viên có tuổi cao nhất: " + nvLonTuoiNhat.hoTen);
    }
}