package Management;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import Entities.Nghia;



public class TuDien {
    private HashMap<String, Nghia> tD;

    public TuDien(){
        tD = new HashMap<String, Nghia>();
    }
    public void themTu(String tu, Nghia nghia){
        tD.put(tu, nghia);
    }
    public void hienThi(){
        for(Map.Entry<String,Nghia> entry : tD.entrySet()){
            String tu = entry.getKey();
            String loai = entry.getValue().getPhanLoai();
            String nghia = entry.getValue().getNghia();
            String vd = entry.getValue().getViDu();
            System.out.println(tu + "|"+ loai + "|" + nghia + "|" + vd);
        }
    }
    public void hienThi(String tu){
        for(Map.Entry<String,Nghia> entry : tD.entrySet()){
            if(entry.getKey().equals(tu)){
                String loai = entry.getValue().getPhanLoai();
                String nghia = entry.getValue().getNghia();
                String vd = entry.getValue().getViDu();
                System.out.println(tu + "|" + loai + "|" + nghia + "|" + vd);
            }
        }
    }
    public void ghiFile(String tentep){
        try{
            FileOutputStream fo = new FileOutputStream(tentep);
            PrintWriter pw = new PrintWriter(fo);
            for(Map.Entry<String, Nghia> a: tD.entrySet()){
                pw.println(a.getKey() + ":" + a.getValue().getNghia());
            }pw.close(); fo.close();
        }catch(IOException e){System.out.println("Loi Ghi file!");}
    }
    public void docFile(String tentep) throws IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(tentep);
        DataInputStream di = new DataInputStream(fi);
        while(di.available() > 0){
            String s = di.readLine();
            StringTokenizer st = new StringTokenizer(s, "//|");
            String ta = st.nextToken();
            String loai = st.nextToken();
            String nghia = st.nextToken();
            String vidu = st.nextToken();
            Nghia ng = new Nghia(nghia, loai, vidu);
            tD.put(ta, ng);
        }di.close(); fi.close();
    }
}