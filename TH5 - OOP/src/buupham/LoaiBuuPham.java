package buupham;

public enum LoaiBuuPham {
    THU_THUONG("Thu thuong"),
    THU_BAO_DAM("Thu bao dam"),
    BUU_KIEN("Buu kien");

    private final String tenLoai;

    LoaiBuuPham(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }
}
