package buupham;

public class ThuThuong extends Thu {
    @Override
    public LoaiBuuPham getLoai() {
        return LoaiBuuPham.THU_THUONG;
    }

    @Override
    public int tinhCuocPhi() {
        return 800;
    }
}
