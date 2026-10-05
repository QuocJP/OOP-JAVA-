package Thuchanh3.GoiCuoc;

public class NguoiDung {
    private String tenNguoiDung;
    private String soDienThoai;
    private GoiCuoc loaiGoiCuoc2;
    private GoiCuoc loaiGoiCuoc1;
    
    public NguoiDung(String tenNguoiDung, String soDienThoai, GoiCuoc loaiGoiCuoc2, GoiCuoc loaiGoiCuoc1){
        this.tenNguoiDung = tenNguoiDung;
        this.soDienThoai = soDienThoai;
        this.loaiGoiCuoc1 = loaiGoiCuoc1;
        this.loaiGoiCuoc2 = loaiGoiCuoc2;
    }

    public double tinhGiaCuoc(){
        double GiaCuoc = loaiGoiCuoc1.TinhCuoc() + loaiGoiCuoc2.TinhCuoc();
        if(GiaCuoc > 50000){
            System.out.println("Du dieu kien nhan voucher khuyen mai 10%");
        }return GiaCuoc;
    }
    public String getNguoiDung(){
        return this.tenNguoiDung;
    }
    public String getSoDienThoai(){
        return this.soDienThoai;
    }
}
