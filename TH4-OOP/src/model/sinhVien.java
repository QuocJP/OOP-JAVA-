package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class sinhVien {
    private String hoTen;
    private Date ngaySinh;
    private double diemTB;

    // Hàm khởi tạo (Constructor) - tên hàm phải giống hệt tên class
    public sinhVien() {
    }

    public sinhVien(String hoTen, Date ngaySinh, double diemTB) {
        this.hoTen = hoTen.trim();
        this.ngaySinh = ngaySinh;
        this.diemTB = diemTB;
    }

    // Các phương thức Getter/Setter
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen.trim(); }

    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    // Xử lý chuỗi tên: Lấy Họ
    public String layHo() {
        String[] parts = hoTen.split("\\s+");
        return parts.length > 0 ? parts[0] : "";
    }

    // Xử lý chuỗi tên: Lấy Tên
    public String layTen() {
        String[] parts = hoTen.split("\\s+");
        return parts.length > 1 ? parts[parts.length - 1] : (parts.length == 1 ? parts[0] : "");
    }

    // Xử lý chuỗi tên: Lấy Tên đệm
    public String layTenDem() {
        String[] parts = hoTen.split("\\s+");
        if (parts.length <= 2) return ""; 
        
        StringBuilder dem = new StringBuilder();
        for (int i = 1; i < parts.length - 1; i++) {
            dem.append(parts[i]).append(" ");
        }
        return dem.toString().trim();
    }

    // Xử lý ngày tháng: Tính Tuổi
    public int layTuoi() {
        Calendar calSinh = Calendar.getInstance();
        calSinh.setTime(ngaySinh);
        int namSinh = calSinh.get(Calendar.YEAR);

        Calendar calHienTai = Calendar.getInstance();
        int namHienTai = calHienTai.get(Calendar.YEAR);

        return namHienTai - namSinh;
    }

    // Xếp loại học lực
    public String layXepLoai() {
        if (diemTB >= 8.0) return "Giỏi";
        else if (diemTB >= 7.0) return "Khá";
        else if (diemTB >= 5.0) return "Trung bình";
        else return "Yếu";
    }

    // Hiển thị thông tin sinh viên
    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("| %-22s | %-7s | %-10s | %-7s | %-12s | %-5d | %-5.2f | %-10s |\n",
                hoTen, layHo(), layTenDem(), layTen(), sdf.format(ngaySinh), layTuoi(), diemTB, layXepLoai());
    }
}