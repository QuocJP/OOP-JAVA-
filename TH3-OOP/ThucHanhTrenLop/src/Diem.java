public class Diem {
    private String tenHocPhan;
    private int soTinChi;
    private double chuyenCan;
    private double giuaKy;
    private double cuoiKy;

    public Diem(String tenHocPhan, int soTinChi, double chuyenCan, double giuaKy, double cuoiKy) {
        this.tenHocPhan = tenHocPhan;
        this.soTinChi = soTinChi;
        this.chuyenCan = chuyenCan;
        this.giuaKy = giuaKy;
        this.cuoiKy = cuoiKy;
    }

    public double tinhDiem() {
        double result = 0;
        result = (this.chuyenCan * 0.1) + (this.giuaKy * 0.2) + (this.cuoiKy * 0.7);
        return result * soTinChi;
    }

    public int getsoTinChi() {
        return this.soTinChi;
    }

    // Thêm hàm lấy tên học phần để xoá cảnh báo gạch dưới màu vàng
    public String getTenHocPhan() {
        return this.tenHocPhan;
    }
}