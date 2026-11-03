public class SVTH extends SV {
    private double diemTH;

    public SVTH(String hoTen, int namSinh, double dtb, double diemTH) {
        super(hoTen, namSinh, dtb);
        this.diemTH = diemTH;
    }

    @Override
    public boolean equals(Object s) {
        if (s instanceof SVTH) {
            SVTH ss = (SVTH) s;
            return super.equals(ss) && diemTH == ss.diemTH;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[SVTH] " + super.toString() + ", Điểm TH: " + diemTH;
    }
}