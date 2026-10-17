package diemhp;

public abstract class DiemHP {
    protected final String tenHP;
    protected final int soTinChi;

    public DiemHP(String tenHP, int soTinChi) {
        if (tenHP == null || tenHP.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten hoc phan khong duoc de trong.");
        }
        if (soTinChi <= 0) {
            throw new IllegalArgumentException("So tin chi phai lon hon 0.");
        }
        this.tenHP = tenHP.trim();
        this.soTinChi = soTinChi;
    }

    public String getTenHP() {
        return tenHP;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public abstract double tinhDiem();
}
