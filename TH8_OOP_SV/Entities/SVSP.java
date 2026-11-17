package Entities;


public class SVSP extends SV {
    private static final long serialVersionUID = 1L;
    protected String noiTT;
    protected double diemTT;
    public SVSP(){
        super();
    }
    public SVSP(String mSSV, String hoTen, int namSinh, double dtb, String noiTT, double diemTT){
        super(mSSV, hoTen, namSinh, dtb);
        this.noiTT = noiTT;
        this.diemTT = diemTT;
    }
    @Override
    public void hienThi(){
        super.hienThi();
        System.out.println(" Noi TT: " + noiTT + " Diem TT: " + diemTT);
    }
    
    @Override
    public String toString() {
        return super.toString() + "|" + loaiSV() + "|" + noiTT + "|" + diemTT;
    }
    @Override
    public boolean duocTN() {
        return dtb >= 5.0 && diemTT >= 5.0;
    }
    @Override
    public String loaiSV() {
        return "SVSP";
    }
    
}
