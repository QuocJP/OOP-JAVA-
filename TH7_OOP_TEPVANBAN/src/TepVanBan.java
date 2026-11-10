import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TepVanBan {
    public static void TaoTep(){
        try{
            FileOutputStream fo = new FileOutputStream("songuyento.txt");
            PrintWriter pw = new PrintWriter(fo);
            for(int i = 1; i <= 100; i++){
                int k = (int)(Math.random()*1000);
                pw.print(k + " ");
                if(i % 10 == 0)
                    pw.println();
            }
            pw.close();
        }catch(IOException e){
            System.out.println("Loi Doc File");
        }
    }
    public static void GhiTep(){
        try{
            FileInputStream fin = new FileInputStream("songuyento.txt");
            FileOutputStream fo = new FileOutputStream("sochan.txt");
            PrintWriter pw = new PrintWriter(fo);
            Scanner sc = new Scanner(fin);
            int d = 0;
            for(int i = 1; i <= 100; i++){
                int k = sc.nextInt();
                if(k % 2 == 0){pw.print(k + " "); d++;};
                if(d % 10 == 0)pw.println();
            }
            pw.close(); fin.close(); sc.close();;
        }catch(IOException e){
            System.out.println("Loi Doc File");
        }
    }
    public static void XuatTep(String tenFile){
        try{
            FileInputStream fin = new FileInputStream(tenFile);
            int ch;
            while((ch = fin.read()) != -1){
                System.out.print((char)ch);
            }fin.close();
        }catch(IOException e){
            System.out.println("Loi Doc File");
        }
    }
    public static void main(String[] args){
        TaoTep();
        GhiTep();
        XuatTep("songuyento.txt");
    }
}