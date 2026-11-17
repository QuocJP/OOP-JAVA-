package Management;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Entities.SV;
import Entities.SVSP;
import Entities.SVTH;
public class DanhSachSinhVien{
    private ArrayList<SV> ds;

    public DanhSachSinhVien(){
        ds = new ArrayList<SV>();
    }
    public void them(SV a){
        if(!ds.contains(a)){
            ds.add(a);
        }
    }
    public void lietke(){
        for(SV a:ds)
            System.out.println(a);
    }
    public void lietke(String l){
        for(SV a:ds){
            if(a.loaiSV().equals(l))
                a.hienThi();
        }
    }
    public void tim(String l){
        for(SV a:ds){
            if(a.getHoTen().equals((l)))
                a.hienThi();
        }
    }
    public void lietKeDuocTN(){
        for(SV a:ds){
            if(a.duocTN())
                a.hienThi();
        }
    }
    public void ghiTep(String tenTep){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(tenTep))){
            for(SV a:ds){
                pw.println(a.toString());
            }
        }catch(IOException e){System.out.println("Loi Ghi Tep");}
    }
    public void docTep(String tenTep){
        try(BufferedReader br = new BufferedReader(new FileReader(tenTep))){
            String s;
            while((s = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(s, "|");
                String mSSV = st.nextToken();
                String hoTen = st.nextToken();
                int namSinh = Integer.parseInt(st.nextToken());
                double dtb = Double.parseDouble(st.nextToken());
                String loaiSV = st.nextToken();
                SV sv;
                if(loaiSV.equals("SVSP")){
                    String noiTT = st.nextToken();
                    double diemTT = Double.parseDouble(st.nextToken());
                    sv = new SVSP(mSSV, hoTen, namSinh, dtb, noiTT, diemTT);
                    them(sv);
                }
                else{
                    String tenDT = st.nextToken();
                    double diemDT = Double.parseDouble(st.nextToken());
                    sv = new SVTH(mSSV, hoTen, namSinh, dtb, tenDT, diemDT);
                    them(sv);
                }
            }
        }catch(IOException e){System.out.println("Loi Doc File");}
    }
    public void ghiFileObject(String tenTep){
        try(ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(tenTep))){
            objout.writeObject(ds.size());
            for(SV a: ds){
                objout.writeObject(a);
            }
        }catch(IOException e){System.out.println("Loi Ghi File");}
    }
    public void docFileObject(String tenTep) throws IOException, ClassNotFoundException{
        try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream(tenTep))){
            int soLuong = (int)objin.readObject();
            for(int i = 0; i < soLuong; i++){
                SV s = (SV)objin.readObject();
                them(s);
            }
        }
    }
}
