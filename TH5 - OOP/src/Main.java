import buupham.BuuPham;
import buupham.BuuKien;
import buupham.LoaiBuuPham;
import buupham.ThuBaoDam;
import buupham.ThuThuong;
import buupham.ThungThu;
import diemhp.DiemHP;
import diemhp.HPDoAn;
import diemhp.HPLyThuyet;
import diemhp.HPThucHanh;
import diemhp.SinhVien;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        minhHoaDiemHocPhan();
        minhHoaThungThu();
    }

    private static void minhHoaDiemHocPhan() {
        System.out.println("=== BAI TAP TINH DIEM HOC PHAN ===");
        SinhVien[] sinhViens = {
                new SinhVien("Nguyen An", new HPLyThuyet("Lap trinh Java", 3, 9, 8, 9),
                        new HPThucHanh("Thuc hanh Java", 2, 8.5, 9.0, 8.0)),
                new SinhVien("Tran Binh", new HPThucHanh("Mang may tinh", 3, 7.0, 8.0),
                        new HPDoAn("Do an phan mem", 4, 8.0, 9.0, 8.5, 9.0, 8.5)),
                new SinhVien("Le Chi", new HPLyThuyet("Co so du lieu", 3, 8, 9, 8),
                        new HPThucHanh("Thuc hanh CSDL", 2, 9.0, 8.0, 9.5, 8.5),
                        new HPDoAn("Do an CSDL", 3, 9.0, 8.5, 9.0, 9.5, 9.0))
        };

        for (SinhVien sinhVien : sinhViens) {
            sinhVien.hienThi();
        }
    }

    private static void minhHoaThungThu() {
        System.out.println();
        System.out.println("=== BAI TAP THUNG THU ===");
        ThungThu thungThu = new ThungThu(100);
        thungThu.themBuuPham(new ThuThuong());
        thungThu.themBuuPham(new ThuBaoDam());
        thungThu.themBuuPham(new BuuKien());
        thungThu.themBuuPham(new ThuThuong());
        thungThu.themBuuPham(new ThuBaoDam());
        thungThu.themBuuPham(new BuuKien());

        System.out.println("Tat ca buu pham:");
        inDanhSach(thungThu.getDanhSachBuuPham());
        System.out.println("Thu bao dam:");
        inDanhSach(thungThu.getDanhSachBuuPham(LoaiBuuPham.THU_BAO_DAM));

        System.out.println("Tong cuoc phi: " + thungThu.tinhTongCuocPhi() + " dong");
        for (LoaiBuuPham loai : LoaiBuuPham.values()) {
            System.out.printf("Tong %s: %d dong%n",
                    loai.getTenLoai(), thungThu.tinhTongCuocPhi(loai));
        }
    }

    private static void inDanhSach(List<BuuPham> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("  (khong co)");
            return;
        }
        for (BuuPham buuPham : danhSach) {
            System.out.printf("  %-14s %d dong%n",
                    buuPham.getLoai().getTenLoai(), buuPham.tinhCuocPhi());
        }
    }
}
