import java.util.ArrayList;
import java.util.List;

//---class điểm---
class Diem {
    private String tenHocPhan;
    private int soTinChi;
    private double chuyenCan, giuaKy, cuoiKy;

    public Diem(String ten, int tc, double cc, double gk, double ck) {
        this.tenHocPhan = ten;
        this.soTinChi = (tc >= 1 && tc <= 4) ? tc : 1;
        this.chuyenCan = cc;
        this.giuaKy = gk;
        this.cuoiKy = ck;
    }

//tính điểm học phần theo tỷ lệ 10%, 20%, 70%
    public double tinhDiem() {
        return this.chuyenCan * 0.1 + this.giuaKy * 0.2 + this.cuoiKy * 0.7;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void xuat() {
        System.out.printf("    + %s (TC: %d) | CC: %.1f | GK: %.1f | CK: %.1f => Diem HP: %.2f\n",
                tenHocPhan, soTinChi, chuyenCan, giuaKy, cuoiKy, tinhDiem());
    }
}

//--- class sinh viên ---
class SinhVien {
    private String hoTen;
    private List<Diem> danhSachDiem;

    public SinhVien(String hoTen) {
        this.hoTen = hoTen;
        this.danhSachDiem = new ArrayList<>();
    }

    public void themHocPhan(Diem d) {
        danhSachDiem.add(d);
    }

//tính điểm trung bình tích lũy theo số tín chỉ
    public double tinhDTB() {
        double tongDiemTinChi = 0;
        int tongTinChi = 0;
        for (Diem d : danhSachDiem) {
            tongDiemTinChi += d.tinhDiem() * d.getSoTinChi();
            tongTinChi += d.getSoTinChi();
        }
        if (tongTinChi == 0) return 0;
        return tongDiemTinChi / tongTinChi;
    }

    public void xuat() {
        System.out.println("Ho ten sinh vien: " + hoTen);
        System.out.println("Danh sach cac hoc phan da hoc:");
        for (Diem d : danhSachDiem) {
            d.xuat();
        }
        System.out.printf("=> Diem Trung Binh (DTB): %.2f\n", tinhDTB());
        System.out.println("--------------------------------------------------");
    }
}

public class MainThucHanh {
    public static void main(String[] args) {
        List<SinhVien> dsSV = new ArrayList<>();

        SinhVien sv1 = new SinhVien("Nguyen Anh Quoc");
        sv1.themHocPhan(new Diem("Lap trinh Java", 3, 8.5, 7.0, 8.0));
        sv1.themHocPhan(new Diem("Cau truc du lieu", 3, 9.0, 8.0, 7.5));
        sv1.themHocPhan(new Diem("Toan roi rac", 2, 7.0, 6.5, 8.0));

        SinhVien sv2 = new SinhVien("Tran Thi Lien");
        sv2.themHocPhan(new Diem("Lap trinh Java", 3, 9.5, 9.0, 9.0));
        sv2.themHocPhan(new Diem("Cau truc du lieu", 3, 8.0, 8.5, 8.5));

        SinhVien sv3 = new SinhVien("Le Thanh Truc");
        sv3.themHocPhan(new Diem("Lap trinh Java", 3, 6.0, 5.5, 6.5));
        sv3.themHocPhan(new Diem("Toan roi rac", 2, 8.0, 7.0, 7.5));

        dsSV.add(sv1);
        dsSV.add(sv2);
        dsSV.add(sv3);

        System.out.println("DANH SACH THONG TIN VA DIEM TRUNG BINH SINH VIEN");
        for (int i = 0; i < dsSV.size(); i++) {
            System.out.println("Sinh vien thu " + (i + 1) + ":");
            dsSV.get(i).xuat();
        }
    }
} 


