package Management;

import Entities.SinhVien;
import java.text.Normalizer;
import java.util.Locale;

public class QuanLySinhVien {
    private final SinhVien[] ds;
    private int soSV;

    public QuanLySinhVien(int sucChua) {
        if (sucChua < 0) {
            throw new IllegalArgumentException("Suc chua danh sach khong duoc am.");
        }
        ds = new SinhVien[sucChua];
    }

    public boolean Them(SinhVien sv) {
        if (sv == null) {
            throw new IllegalArgumentException("Sinh vien khong duoc null.");
        }
        if (soSV == ds.length) {
            return false;
        }
        ds[soSV++] = sv;
        return true;
    }

    public void lietke() {
        for (int i = 0; i < soSV; i++) {
            ds[i].hienThi();
        }
    }

    public void lietke(double diemToiThieu) {
        for (int i = 0; i < soSV; i++) {
            if (ds[i].getdTB() >= diemToiThieu) {
                ds[i].hienThi();
            }
        }
    }

    public void lietke(String ten) {
        String tenCanTim = chuanHoaTen(ten.trim());
        for (int i = 0; i < soSV; i++) {
            if (chuanHoaTen(ds[i].layTen()).equalsIgnoreCase(tenCanTim)) {
                ds[i].hienThi();
            }
        }
    }

    public void sapxep() {
        for (int i = 0; i < soSV - 1; i++) {
            for (int j = i + 1; j < soSV; j++) {
                String tenThuTuI = taoKhoaSapXep(ds[i]);
                String tenThuTuJ = taoKhoaSapXep(ds[j]);
                if (chuanHoaTen(tenThuTuI).compareToIgnoreCase(chuanHoaTen(tenThuTuJ)) > 0) {
                    SinhVien temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }

    private String taoKhoaSapXep(SinhVien sv) {
        return sv.layTen() + " " + sv.layHo() + " " + sv.layDem();
    }

    public boolean xoaTen(String ten) {
        String tenCanXoa = chuanHoaTen(ten.trim());
        for (int i = 0; i < soSV; i++) {
            if (chuanHoaTen(ds[i].layTen()).equalsIgnoreCase(tenCanXoa)) {
                for (int j = i; j < soSV - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds[--soSV] = null;
                return true;
            }
        }
        return false;
    }

    private String chuanHoaTen(String ten) {
        String khongDau = Normalizer.normalize(ten, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return khongDau.replace('đ', 'd').replace('Đ', 'D').toLowerCase(Locale.ROOT);
    }

    public double TinhTuoiTB() {
        if (soSV == 0) {
            return 0.0;
        }
        double tongTuoi = 0.0;
        for (int i = 0; i < soSV; i++) {
            tongTuoi += ds[i].layTuoi();
        }
        return tongTuoi / soSV;
    }

    public int getSoSV() {
        return soSV;
    }
}
