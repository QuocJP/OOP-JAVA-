package buupham;

public class ThuBaoDam extends Thu {
    @Override
    public LoaiBuuPham getLoai() {
        return LoaiBuuPham.THU_BAO_DAM;
    }

    @Override
    public int tinhCuocPhi() {
        return 2000;
    }
}
