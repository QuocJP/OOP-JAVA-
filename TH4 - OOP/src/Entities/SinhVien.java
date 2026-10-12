package Entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SinhVien {
    private String hoTen;
    private Date ngaySinh;
    private double dTB;

    public SinhVien() {
        this("", null, 0.0);
    }

    public SinhVien(String hoTen, Date ngaySinh, double dTB) {
        this.hoTen = hoTen == null ? "" : hoTen.trim().replaceAll("\\s+", " ");
        this.ngaySinh = ngaySinh == null ? null : new Date(ngaySinh.getTime());
        kiemTraDiem(dTB);
        this.dTB = dTB;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen == null ? "" : hoTen.trim().replaceAll("\\s+", " ");
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh == null ? null : new Date(ngaySinh.getTime());
    }

    public void setdTB(double dTB) {
        kiemTraDiem(dTB);
        this.dTB = dTB;
    }

    private void kiemTraDiem(double dTB) {
        if (dTB < 0.0 || dTB > 10.0) {
            throw new IllegalArgumentException("Diem trung binh phai nam trong khoang 0 den 10.");
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh == null ? null : new Date(ngaySinh.getTime());
    }

    public double getdTB() {
        return dTB;
    }

    public String layHo() {
        String[] cacTu = layCacTuTrongHoTen();
        return cacTu[0];
    }

    public String layDem() {
        String[] cacTu = layCacTuTrongHoTen();
        if (cacTu.length < 3) {
            return "";
        }
        return String.join(" ", java.util.Arrays.copyOfRange(cacTu, 1, cacTu.length - 1));
    }

    public String layTen() {
        String[] cacTu = layCacTuTrongHoTen();
        return cacTu[cacTu.length - 1];
    }

    public String TachHo() {
        return layHo();
    }

    public String TachDem() {
        return layDem();
    }

    public String TachTen() {
        return layTen();
    }

    private String[] layCacTuTrongHoTen() {
        if (hoTen.isEmpty()) {
            return new String[] { "" };
        }
        return hoTen.split("\\s+");
    }

    public int layTuoi() {
        if (ngaySinh == null) {
            return 0;
        }
        Calendar ngaySinhCalendar = Calendar.getInstance();
        ngaySinhCalendar.setTime(ngaySinh);
        return Calendar.getInstance().get(Calendar.YEAR) - ngaySinhCalendar.get(Calendar.YEAR);
    }

    public int TinhTuoi() {
        return layTuoi();
    }

    public String layXepLoai() {
        if (dTB >= 8.0) {
            return "Giỏi";
        } else if (dTB >= 7.0) {
            return "Khá";
        } else if (dTB >= 5.0) {
            return "Trung bình";
        }
        return "Yếu";
    }

    public String HocLuc() {
        return layXepLoai();
    }

    public void hienThi() {
        String ngaySinhText = ngaySinh == null
                ? "Chua co"
                : new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh);
        System.out.printf(
                "Ho ten: %s | Ho: %s | Ten dem: %s | Ten: %s | Ngay sinh: %s | Tuoi: %d | DTB: %.1f | Xep loai: %s%n",
                hoTen, layHo(), layDem(), layTen(), ngaySinhText, layTuoi(), dTB, layXepLoai());
    }
}
