package Entities;
public class SVTH extends SV {
    private static final long serialVersionUID = 1L;
    protected String tenDT;
    protected double diemDT;
    public SVTH(){
        super();
    }
    public SVTH(String mSSV, String hoTen, int namSinh, double dtb, String tenDT, double diemDT){
        super(mSSV, hoTen, namSinh, dtb);
        this.tenDT = tenDT;
        this.diemDT = diemDT;
    }
    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println(" ten DT: " + tenDT + " Diem TT: " + diemDT);
    }
    @Override
    public boolean duocTN() {
        return dtb >= 5.0 && diemDT >= 5.0;
    }
    @Override
    public String loaiSV() {
        return "SVTH";
    }
    @Override
    public String toString() {
        return super.toString() + "|" + loaiSV() + "|" + tenDT + "|" + diemDT;
    }
    
}
