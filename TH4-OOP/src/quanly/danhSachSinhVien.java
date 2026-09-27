package quanly;

import model.sinhVien;

public class danhSachSinhVien {
    private sinhVien[] danhSach;
    private int soLuong;

    public danhSachSinhVien(int maxCapacity) {
        danhSach = new sinhVien[maxCapacity];
        soLuong = 0;
    }

    // Thêm sinh viên
    public void themSinhVien(sinhVien sv) {
        if (soLuong < danhSach.length) {
            danhSach[soLuong] = sv;
            soLuong++;
        } else {
            System.out.println("Danh sách đã đầy!");
        }
    }

    // In tiêu đề bảng
    private void inTieuDe() {
        System.out.println(new String(new char[105]).replace("\0", "-"));
        System.out.printf("| %-22s | %-7s | %-10s | %-7s | %-12s | %-5s | %-5s | %-10s |\n",
                "Họ và tên đầy đủ", "Họ", "Tên đệm", "Tên", "Ngày sinh", "Tuổi", "ĐTB", "Xếp loại");
        System.out.println(new String(new char[105]).replace("\0", "-"));
    }

    // Hiển thị danh sách toàn bộ
    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        inTieuDe();
        for (int i = 0; i < soLuong; i++) {
            danhSach[i].hienThiThongTin();
        }
        System.out.println(new String(new char[105]).replace("\0", "-"));
    }

    // Liệt kê sinh viên Giỏi
    public void lietKeSinhVienGioi() {
        System.out.println("\n--- DANH SÁCH SINH VIÊN ĐẠT LOẠI GIỎI ---");
        inTieuDe();
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getDiemTB() >= 8.0) {
                danhSach[i].hienThiThongTin();
            }
        }
        System.out.println(new String(new char[105]).replace("\0", "-"));
    }

    // Tìm kiếm sinh viên theo Tên
    public void timSinhVienTheoTen(String tenCanTim) {
        System.out.println("\n--- KẾT QUẢ TÌM KIẾM SINH VIÊN TÊN \"" + tenCanTim + "\" ---");
        inTieuDe();
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].layTen().equalsIgnoreCase(tenCanTim)) {
                danhSach[i].hienThiThongTin();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Không tìm thấy sinh viên nào tên " + tenCanTim);
        System.out.println(new String(new char[105]).replace("\0", "-"));
    }

    // Xóa sinh viên
    public void xoaSinhVienTheoTen(String tenCanXoa) {
        int viTriXoa = -1;
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].layTen().equalsIgnoreCase(tenCanXoa)) {
                viTriXoa = i;
                break;
            }
        }

        if (viTriXoa != -1) {
            for (int i = viTriXoa; i < soLuong - 1; i++) {
                danhSach[i] = danhSach[i + 1];
            }
            danhSach[soLuong - 1] = null; 
            soLuong--; 
            System.out.println("\n=> Đã xóa thành công sinh viên đầu tiên tên \"" + tenCanXoa + "\".");
        } else {
            System.out.println("\n=> Không có sinh viên nào tên \"" + tenCanXoa + "\" để xóa.");
        }
    }

    // Tính tuổi trung bình
    public double tinhTuoiTrungBinh() {
        if (soLuong == 0) return 0;
        int tongTuoi = 0;
        for (int i = 0; i < soLuong; i++) {
            tongTuoi += danhSach[i].layTuoi();
        }
        return (double) tongTuoi / soLuong;
    }

    // Sắp xếp danh sách
    public void sapXepTheoTen() {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                String s1 = danhSach[i].layTen() + " " + danhSach[i].layHo() + " " + danhSach[i].layTenDem();
                String s2 = danhSach[j].layTen() + " " + danhSach[j].layHo() + " " + danhSach[j].layTenDem();
                
                if (s1.compareToIgnoreCase(s2) > 0) {
                    sinhVien temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }
}