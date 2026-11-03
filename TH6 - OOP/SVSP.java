public class SVSP extends SV {
    private String noiTT;
    private double diemTT;

    public SVSP(String hoTen, int namSinh, double dtb, String noiTT, double diemTT) {
        super(hoTen, namSinh, dtb);
        this.noiTT = noiTT;
        this.diemTT = diemTT;
    }

    @Override
    public boolean equals(Object s) {
        if (s instanceof SVSP) {
            SVSP ss = (SVSP) s;
            return super.equals(ss) && noiTT.equals(ss.noiTT) && diemTT == ss.diemTT;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[SVSP] " + super.toString() + ", Nơi TT: " + noiTT + ", Điểm TT: " + diemTT;
    }
}
