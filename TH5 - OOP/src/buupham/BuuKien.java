package buupham;

public class BuuKien extends BuuPham {
    @Override
    public LoaiBuuPham getLoai() {
        return LoaiBuuPham.BUU_KIEN;
    }

    @Override
    public int tinhCuocPhi() {
        return 5000;
    }
}
