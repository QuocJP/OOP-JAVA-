package Thuchanh5.TinhDiemHP.Entities;

public class SinhVien {
    private String hoTen;
    private DiemHP hp1;
    private DiemHP hp2;

    public SinhVien(){
        super();
        hp1 = new HPLyThuyet();
        hp2 = new HPThucHanh();
    }
    public SinhVien(String hoTen, DiemHP hp1, DiemHP hp2){
        this.hoTen = hoTen;
        this.hp1 = hp1;
        this.hp2 = hp2;
    }
    public double tinhDTB(){
        return (hp1.tinhDiem() * hp1.laySoTinChi() + hp2.tinhDiem() * hp2.laySoTinChi())/(hp1.laySoTinChi() + hp2.laySoTinChi());
    }
    public String getHoTen() {
        return hoTen;
    }
    public double getHp1() {
        return hp1.tinhDiem();
    }
    public double getHp2() {
        return hp2.tinhDiem();
    }
    public void hienThi(){
        System.out.println("Ho va Ten: " + getHoTen() + " Hoc Phan 1: " + getHp1() + " Hoc Phan 2: " + getHp2() + " DTB: " + tinhDTB());
    }
}
