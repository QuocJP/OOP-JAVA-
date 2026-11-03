public class SV {
    private String hoTen;
    private int namSinh;
    private double dtb;

    public SV(String hoTen, int namSinh, double dtb) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.dtb = dtb;
    }

    public String layHoTen() {
        return hoTen;
    }

    @Override
    public boolean equals(Object s) {
        if (s instanceof SV) {
            SV ss = (SV) s;
            return hoTen.equals(ss.hoTen) && namSinh == ss.namSinh && dtb == ss.dtb;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Họ tên: " + hoTen + ", Năm sinh: " + namSinh + ", ĐTB: " + dtb;
    }
}