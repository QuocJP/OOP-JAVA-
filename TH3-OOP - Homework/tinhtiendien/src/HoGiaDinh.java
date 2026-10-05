public class HoGiaDinh {
    private String maHo;
    private String tenChuHo;
    private String loaiHo;
    private ChiSoCongTo congTo;

    public HoGiaDinh() {
    }

    public HoGiaDinh(String maHo, String tenChuHo, String loaiHo, ChiSoCongTo congTo) {
        this.maHo = maHo;
        this.tenChuHo = tenChuHo;
        this.loaiHo = loaiHo;
        this.congTo = congTo;
    }

    public String getMaHo() {
        return maHo;
    }

    public void setMaHo(String maHo) {
        this.maHo = maHo;
    }

    public ChiSoCongTo getCongTo() {
        return congTo;
    }

    public double tinhTienDien() {
        int soDien = congTo.tinhDienTieuThu();
    
        if (loaiHo.equals("Kinh doanh")) {
            return soDien * 3200;
        } else {
            return soDien * 2500;
        }
    }

    public double tinhThueVAT() {
        return tinhTienDien() * 0.08;
    }

    public double tongTien() {
        return tinhTienDien() + tinhThueVAT();
    }

    public void xuatThongTin() {
        System.out.println("Mã hộ: " + maHo + " | Tên chủ hộ: " + tenChuHo + " | Loại hộ: " + loaiHo);
        System.out.println("Số điện tiêu thụ: " + congTo.tinhDienTieuThu() + " (kWh)");
        System.out.println("Tiền điện: " + tinhTienDien() + " VNĐ | Thuế VAT: " + tinhThueVAT() + " VNĐ");
        System.out.println("Tổng tiền cần trả: " + tongTien() + " VNĐ");
        System.out.println();
    }
}