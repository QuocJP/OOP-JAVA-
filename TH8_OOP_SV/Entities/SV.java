package Entities;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.StringTokenizer;

public abstract class SV implements ISV, Serializable {
    private static final long serialVersionUID = 1L;
    protected String mSSV;
    protected String hoTen;
    protected int namSinh;
    protected double dtb;

    public SV(){
        super();
    }
    public SV(String mSSV, String hoTen, int namSinh, double dtb){
        this.mSSV = mSSV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.dtb = dtb;
    }
    public void hienThi() {
        System.out.println(toString());
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    @Override
    public String toString() {
        return mSSV + "|" + hoTen + "|" + namSinh + "|" + dtb;
    }
    public void ghiTep(String tenTep){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(tenTep))){
            pw.println(this);
        }catch(IOException e){System.out.println("Loi Doc File!");}
    }
    public void docTep(String tenTep){
        try(BufferedReader br = new BufferedReader(new FileReader(tenTep))){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, "|");
            mSSV = st.nextToken();
            hoTen = st.nextToken();
            namSinh = Integer.parseInt(st.nextToken());
            dtb = Double.parseDouble(st.nextToken());
        }catch(IOException e){System.out.println("Loi Doc Tep!");}
    }
}
