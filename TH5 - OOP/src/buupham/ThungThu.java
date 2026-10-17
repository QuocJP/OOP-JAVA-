package buupham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThungThu {
    private final int sucChua;
    private final List<BuuPham> cacBuuPham = new ArrayList<>();

    public ThungThu(int sucChua) {
        if (sucChua <= 0) {
            throw new IllegalArgumentException("Suc chua phai lon hon 0.");
        }
        this.sucChua = sucChua;
    }

    public void themBuuPham(BuuPham buuPham) {
        if (buuPham == null) {
            throw new IllegalArgumentException("Buu pham khong duoc null.");
        }
        if (cacBuuPham.size() >= sucChua) {
            throw new IllegalStateException("Thung thu da day.");
        }
        cacBuuPham.add(buuPham);
    }

    public List<BuuPham> getDanhSachBuuPham() {
        return Collections.unmodifiableList(cacBuuPham);
    }

    public List<BuuPham> getDanhSachBuuPham(LoaiBuuPham loai) {
        if (loai == null) {
            throw new IllegalArgumentException("Loai buu pham khong duoc null.");
        }
        List<BuuPham> ketQua = new ArrayList<>();
        for (BuuPham buuPham : cacBuuPham) {
            if (buuPham.getLoai() == loai) {
                ketQua.add(buuPham);
            }
        }
        return Collections.unmodifiableList(ketQua);
    }

    public int tinhTongCuocPhi() {
        int tongTien = 0;
        for (BuuPham buuPham : cacBuuPham) {
            tongTien += buuPham.tinhCuocPhi();
        }
        return tongTien;
    }

    public int tinhTongCuocPhi(LoaiBuuPham loai) {
        int tongTien = 0;
        for (BuuPham buuPham : getDanhSachBuuPham(loai)) {
            tongTien += buuPham.tinhCuocPhi();
        }
        return tongTien;
    }
}
