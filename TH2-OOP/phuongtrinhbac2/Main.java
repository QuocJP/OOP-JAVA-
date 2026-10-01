package Thuchanh2.phuongtrinhbac2;
import java.util.Scanner;
public class Main {
    public static void main(String[] arggs){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        bienso pt = new bienso();
        pt.ganBSa(a);
        pt.ganBSb(b);
        pt.ganBSc(c);
        double ketqua[] = pt.tinhtoan(a, b, c);
        for(int i = 0; i < ketqua.length; i++){
            System.out.println("Ket qua cua Phuong trinh: " + ketqua[i]);
        }
    }
}
